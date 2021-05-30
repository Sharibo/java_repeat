package box_sorting;

import java.util.Comparator;

public class Box3 {
    
    private int a, b, c;

    public Box3(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String toString() {
        return "Box [a=" + a + ", b=" + b + ", c=" + c + "]";
    }
    
    // 3. Static inner class
    public static class CompareByA implements Comparator<Box3> {

        @Override
        public int compare(Box3 b1, Box3 b2) {
            return b1.a - b2.a;
        }
        
    }
}