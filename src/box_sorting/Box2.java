package box_sorting;

import java.util.Comparator;

public class Box2 {
    
    private int a, b, c;

    public Box2(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String toString() {
        return "Box [a=" + a + ", b=" + b + ", c=" + c + "]";
    }
    
    // 2. Inner class
    public class CompareByA implements Comparator<Box2> {

        @Override
        public int compare(Box2 b1, Box2 b2) {
            return b1.a - b2.a;
        }
        
    }
}