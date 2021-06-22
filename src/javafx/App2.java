package javafx;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class App2 {
    public static void main(String[] args) {
        DemoProperty dp = new DemoProperty();
        dp.setK(11.2);
        dp.setK(-.7);

        DoubleProperty dp2 = new SimpleDoubleProperty();
        dp2.bind(dp.getKProperty());

        System.out.println("d = " + dp2.get());
    }
    
}

class DemoProperty {
    private DoubleProperty k = new SimpleDoubleProperty();

    public DemoProperty() {
        k.addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("oldValue = " + oldValue + " newValue = " + newValue);    
            }});
    }

    public void setK(double k) {
        this.k.set(k);
    }

     public double getK() {
         return k.get();
     }
     
     public DoubleProperty getKProperty() {
         return k;
     }
     
    
}