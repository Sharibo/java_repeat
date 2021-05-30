package box_sorting;

public class Box7 {
    
    private int a, b, c;

    public Box7(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getA() {
        return a;
    }

    @Override
    public String toString() {
        return "Box [a=" + a + ", b=" + b + ", c=" + c + "]";
    }

    public int volume() {
        return a * b * c;
    }

}
