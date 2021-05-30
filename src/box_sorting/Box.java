package box_sorting;

public class Box implements Comparable<Box> {
    
    private int a, b, c;

    public Box(int a, int b, int c) {
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
}
