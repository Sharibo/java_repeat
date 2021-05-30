package box_sorting;

import java.util.Comparator;

public class Box4 {

    private int a, b, c;

    public Box4(int a, int b, int c) {
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

    // 4. Local class
    public static Comparator<Box4> compareByA() {
        class CMP implements Comparator<Box4> {

            @Override
            public int compare(Box4 b1, Box4 b2) {
                return b1.a - b2.a;
            }
        }

        return new CMP();
    }

}
