import java.util.*;

public class Main {

    enum Element {
        FIRE, WIND, EARTH, SKY, WATER
    }

    public static void main(String[] args) {

        // Change this statement
        Set<Element> set = new HashSet<>(); 

        /** instanceof operator returns true if set object has EnumSet type
         *  and false - otherwise
         */
        System.out.println(set instanceof EnumSet<Element>);
        System.out.println(set);
    }
}