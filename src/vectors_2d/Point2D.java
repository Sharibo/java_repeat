package vectors_2d;

public class Point2D {

    private int x, y;
    private double length;
    private static int pointsCounter;
    private final int pointId;
    
    static {
        System.out.println("Static block!");
    }

    public Point2D() {
        this(0, 0);
    }

    public Point2D(int x, int y) {
        setX(x);
        setY(y);
        pointId = pointsCounter++;
    }

    public int getX() {
        return x;
    }

    public final void setX(int x) {
        this.x = x;
        length();
    }

    public int getY() {
        return y;
    }

    public final void setY(int y) {
        this.y = y;
        length();
    }

    public double getLength() {
        return length;
    }
    
    public int getPointId() {
        return pointId;
    }

    public static int getPointsCounter() {
        return pointsCounter;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public static void setPointsCounter(int pointsCounter) {
        Point2D.pointsCounter = pointsCounter;
    }

    private void length() {
        length = Math.sqrt(x * x + y * y);
    }

    public double distanceTo(Point2D rValue) {
        return Math.sqrt((this.x - rValue.x) * (this.x - rValue.x) +
                         (this.y - rValue.y) * (this.y - rValue.y));
    }

    public Point2D addTo(Point2D rValue) {
        return new Point2D(x+rValue.x, y+rValue.y);
    }
    

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        sb.append(x);
        sb.append(", ");
        sb.append(y);
        sb.append(")");
        return sb.toString();
    }
}
