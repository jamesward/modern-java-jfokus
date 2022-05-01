package adt;

public class HelloSum {

    sealed interface Robot
            permits Vacuum, SnowBlower, LawnMower { }

    static final class Vacuum implements Robot {
        public void suck() {
            System.out.println("shhhhhhh");
        }
    }

    static final class SnowBlower implements Robot {
        public void blow() {
            System.out.println("chggggg");
        }
    }

    static final class LawnMower implements Robot {
        public void cut() {
            System.out.println("bzzzzzz");
        }
    }

}
