package adt;

public class HelloRecords {

    // fancy immutable data class
    record Point(int x, int y) { }

    interface Bar {
        int x = 0;
        default int add(int y) {
            return x + y;
        }
    }

    record Foo(String s) implements Bar {

    }

    public static void main(String[] args) {
        // fancy type inference
        var point = new Point(1, 2);

        Bar bar = new Foo("asdf");
        System.out.println(bar.add(1));


        // point.x = 3;

        System.out.println(point);

        // fancy text block!
        System.out.printf("""
                x = %s
                y = %s
                """, point.x() ,point.y());
    }

}
