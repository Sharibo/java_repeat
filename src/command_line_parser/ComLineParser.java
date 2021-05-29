package command_line_parser;

public class ComLineParser {
    private String[] keys;
    private String[] delimeters;

    public enum SwitchStatus {
        NoError, Error, ShowUsage
    }

    public ComLineParser(String[] keys, String[] delimeters) {
        this.keys = keys;
        this.delimeters = delimeters;
    }

    public ComLineParser(String[] keys) {
        this(keys, new String[] { "/", "-" });
    };

    public void onUsage(String errorKey) {
        if (errorKey != null) {
            System.out.println(errorKey);
        }

        System.out.println("формат ком.строки: имяПрограммы [-r<input-fileName>] [-w<output-fileName>]");
        System.out.println("   -?  показать Help файл");
        System.out.println("   -r  задать имя входного файла");
        System.out.println("   -w  выполнить вывод в указанный файл");
    }

    public SwitchStatus onSwitch(String key, String keyValue) {
        System.out.println(key);
        System.out.println(keyValue);

        return SwitchStatus.NoError;
    }

    public boolean Parse(String[] args) {
        SwitchStatus ss = SwitchStatus.NoError;
        int argNum;
        for (argNum = 0; (ss == SwitchStatus.NoError) && (argNum < args.length); argNum++) {
            boolean isDelimeter = false;
            for (int n = 0; !isDelimeter && (n < args.length); n++) {
                isDelimeter = args[argNum].regionMatches(0, delimeters[n], 0, 1);
            }

            if (isDelimeter) {
                // Проверка наличия правильного ключа
                boolean isKey = false;
                int i;

                for(i=0; !isKey && (i < keys.length); i++) {
                    isKey = args[argNum].toUpperCase().regionMatches(1, keys[i].toUpperCase(), 0, keys[i].length());

                    if (isKey) {
                        break;
                    }
                }

                if (!isKey) {
                    ss = SwitchStatus.Error;
                    System.out.println(ss);
                    break;
                } else {
                    ss = onSwitch(keys[i].toLowerCase(), args[argNum].substring(1 + keys[i].length()));
                }

            } else {
                ss = SwitchStatus.Error;
                break;
            }

        }

        if (ss == SwitchStatus.ShowUsage) {
            onUsage(null);
        }

        if (ss == SwitchStatus.Error) {
            onUsage((argNum == args.length) ? null : args[argNum]);
        }
        
        return ss == SwitchStatus.Error;
    }

}
