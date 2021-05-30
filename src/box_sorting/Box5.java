package box_sorting;

import java.util.Comparator;

public class Box5 implements Comparable<Box> {
    
    private int a, b, c;

    public Box5(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String toString() {
        return "Box [a=" + a + ", b=" + b + ", c=" + c + "]";
    }

    public int volume() {
        return a * b * c;
    }

    @Override
    public int compareTo(Box rValue) {
        return volume() - rValue.volume();
    }
    
    // 5. Anonymous local class
    public static Comparator<Box5> compareByA() {
        
        return new Comparator<Box5>() {

            @Override
            public int compare(Box5 b1, Box5 b2) {
                return b1.a - b2.a;
            };
        };
    }
}
