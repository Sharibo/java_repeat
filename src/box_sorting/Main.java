package box_sorting;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        Box[] boxes = { new Box(10, 1, 1), new Box(1, 10, 10), new Box(2, 2, 2) };
        Box2[] boxes2 = { new Box2(10, 1, 1), new Box2(1, 10, 10), new Box2(2, 2, 2) };
        Box3[] boxes3 = { new Box3(10, 1, 1), new Box3(1, 10, 10), new Box3(2, 2, 2) };
        Box4[] boxes4 = { new Box4(10, 1, 1), new Box4(1, 10, 10), new Box4(2, 2, 2) };
        Box5[] boxes5 = { new Box5(10, 1, 1), new Box5(1, 10, 10), new Box5(2, 2, 2) };
        Box6[] boxes6 = { new Box6(10, 1, 1), new Box6(1, 10, 10), new Box6(2, 2, 2) };
        Box7[] boxes7 = { new Box7(10, 1, 1), new Box7(1, 10, 10), new Box7(2, 2, 2) };

        // 1. Sorting by volume
        Arrays.sort(boxes);

        System.out.println("Sorting by volume:");
        for (Box box : boxes) {
            System.out.println(box);
        }

        // 2. Sorting by a-side with inner class
        // Box2.CompareByA cmp = new Box2(0, 0, 0).new CompareByA();
        // Arrays.sort(boxes2, cmp);
        Arrays.sort(boxes2, new Box2(0, 0, 0).new CompareByA());

        System.out.println("\nSorting by a-side with inner class:");
        for (Box2 box : boxes2) {
            System.out.println(box);
        }

        // 3. Sorting by a-side with static inner class
        Arrays.sort(boxes3, new Box3.CompareByA());

        System.out.println("\nSorting by a-side with static inner class:");
        for (Box3 box : boxes3) {
            System.out.println(box);
        }

        // 4. Sorting by a-side with local class
        Arrays.sort(boxes4, Box4.compareByA());
        
        System.out.println("\nSorting by a-side with local class:");
        for (Box4 box : boxes4) {
            System.out.println(box);
        }

        // 5. Sorting by a-side anonymous local class
        Arrays.sort(boxes5, Box5.compareByA());
        
        System.out.println("\nSorting by a-side with anonymous local class:");
        for (Box5 box : boxes5) {
            System.out.println(box);
        }

        // 6. Sorting by a-side with anonymous class
        Arrays.sort(boxes6, new Comparator<Box6>() {
            
            @Override
            public int compare(Box6 b1, Box6 b2) {
                return b1.getA() - b2.getA();
            }            
        });

        System.out.println("\nSorting by a-side with anonymous class:");
        for (Box6 box : boxes6) {
            System.out.println(box);
        }

        // 7. Sorting by a-side with anonymous class
        Arrays.sort(boxes7, (b1, b2) -> b1.getA() - b2.getA());

        System.out.println("\nSorting by a-side with lambda expression:");
        for (Box7 box : boxes7) {
            System.out.println(box);
        }
        
    }
}
