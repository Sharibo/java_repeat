package vectors_2d;

public class PointMain {
    public static void main(String[] args) {

        System.out.println("Total points: " + Point2D.getPointsCounter());

        Point2D p1 = new Point2D();
        p1.setX(1);
        p1.setY(1);
        System.out.println(p1.getPointId() + ": " + p1 + ", length = " + p1.getLength());

        Point2D p2 = new Point2D(3, 4);
        System.out.println(p2.getPointId() + ": " + p2 + ", length = " + p2.getLength());
    
        System.out.println("Total points: " + Point2D.getPointsCounter());

        System.out.println("DistanceBetwen = " + p1.distanceTo(p2));
        System.out.println("p1 + p2 = p3 = " + p1.addTo(p2));
    }

}
