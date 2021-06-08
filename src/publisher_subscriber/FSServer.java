package publisher_subscriber;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.ArrayList;

public class FSServer {
    
    private String dir;
    private ArrayList<FSMonitor> clients;
    private volatile boolean canWork;
    
    public FSServer(String dir) {
        this.dir = dir;
        clients = new ArrayList<>();
    }

    public void addClient(FSMonitor client) {
        clients.add(client);
    }
    public void removeClient(FSMonitor client) {
        clients.remove(client);
    }

    public void start() {
        canWork = true;
        run(); //! запуск потока, переписать
    }

    public void stop() {
        canWork = false;
    }
    
    public void run() {
        try {
            // создаёт наблюдателя за файловой системой
            WatchService watch = FileSystems.getDefault().newWatchService();
            // привязывает наблюдателя к конкретной директории и конкретным событиям
            Paths.get(dir).register(watch,
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_DELETE);

            while (canWork) {
                // Дескриптор события
                WatchKey key = watch.take(); // take - блокирующий исполнение кода метод

                for (WatchEvent event : key.pollEvents()) {
                    String fName = event.context().toString(); // Получаем имя файла
                    int kind = 0;

                    // Определяем тип произошедшего события
                    if (event.kind() == StandardWatchEventKinds.ENTRY_CREATE) {
                        kind = FSMonitor.CREATE;
                    } else {
                        kind = FSMonitor.REMOVE;
                    }

                    // Оповещаем клиентов о произошедших событиях
                    for (FSMonitor client : clients) {
                        client.event(fName, kind);
                    }
                }

                key.reset();
            }

            watch.close(); // закрываем наблюдателя за событиями
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
