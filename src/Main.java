/*   Created By: IntelliJ Idea
 *    Author: Naman Agarwal (naman2807)
 *    Date: 18-08-2020
 *    Time: 09:38 PM
 *    Package: PACKAGE_NAME
 */


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static Map<Integer, Locations> locations = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> tempExits = new HashMap<>();
        locations.put(0, new Locations(0, "You are sitting in front of computer learning Java", tempExits));

        tempExits = new HashMap<>();
        tempExits.put("N", 5);
        tempExits.put("E", 3);
        tempExits.put("S", 4);
        tempExits.put("W", 2);
        locations.put(1, new Locations(1, "You are standing at the end of the road in front of building.", tempExits));

        tempExits = new HashMap<>();
        tempExits.put("N", 5);
        locations.put(2, new Locations(2, "You are at top of the hill.", tempExits));

        tempExits = new HashMap<>();
        tempExits.put("W", 1);
        locations.put(3, new Locations(3, "You are inside a building", tempExits));

        tempExits = new HashMap<>();
        tempExits.put("N", 1);
        tempExits.put("E", 2);
        locations.put(4, new Locations(4, "You are in a valley beside a stream.", tempExits));

        tempExits = new HashMap<>();
        tempExits.put("E", 2);
        tempExits.put("S", 1);
        locations.put(5, new Locations(5, "You are in a forest.", tempExits));

        //         ******** THIS IS FOR MUTABLE CLASS**************
         //        Scanner scanner = new Scanner(System.in);
         //        locations.put(0, new Locations(0, "You are sitting in front of computer learning Java"));
         //        locations.put(1, new Locations(1, "You are standing at the end of the road in front of building."));
         //        locations.put(2, new Locations(2, "You are at top of the hill."));
         //        locations.put(3, new Locations(3, "You are inside a building"));
         //        locations.put(4, new Locations(4, "You are in a valley beside a stream."));
         //        locations.put(5, new Locations(5, "You are in a forest."));
         //
         //        locations.get(1).addExits("N", 5);
         //        locations.get(1).addExits("E", 3);
         //        locations.get(1).addExits("S", 4);
         //        locations.get(1).addExits("W", 2);
         //
         //        locations.get(2).addExits("N", 5);
         //
         //        locations.get(3).addExits("W", 1);
         //
         //        locations.get(4).addExits("N", 1);
         //        locations.get(4).addExits("E", 2);
         //
         //        locations.get(5).addExits("E", 2);
         //        locations.get(5).addExits("S", 1);

        Map<String, String> vocabulary = new HashMap<>();
        vocabulary.put("QUIT", "Q");
        vocabulary.put("NORTH", "N");
        vocabulary.put("EAST", "E");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("WEST", "W");

        int loc = 1;
        while (true) {
            System.out.println(locations.get(loc).getDescription());
            if (loc == 0) {
                break;
            }
            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.print("Available exits are: ");
            for (String exit : exits.keySet()) {
                System.out.print(exit + ", ");
            }
            System.out.println();
            String direction = scanner.nextLine().toUpperCase();
            if (direction.length() > 1) {
                String[] words = direction.split(" ");
                for (String word : words) {
                    if (vocabulary.containsKey(word)) {
                        direction = vocabulary.get(word);
                        break;
                    }
                }
            }

            if (exits.containsKey(direction)) {
                loc = exits.get(direction);
            } else {
                System.out.println("You cannot go in that direction.");
            }
        }
    }
}
