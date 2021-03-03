/*   Created By: IntelliJ Idea
 *    Author: Naman Agarwal (naman2807)
 *    Date: 22-08-2020
 *    Time: 07:49 AM
 *    Package: PACKAGE_NAME
 */


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

// IMMUTABLE CLASS.............
public final class Locations {
    private final String description;
    private final int locationID;
    private final Map<String, Integer> exits;

    public Locations(int locationID, String description, Map<String, Integer> exits) {
        this.description = description;
        this.locationID = locationID;
        this.exits = Objects.requireNonNullElseGet(exits, HashMap::new);
        this.exits.put("Q", 0);
    }

//    public void addExits(String direction, int loc){
//        this.exits.put(direction,loc);
//    }

    public String getDescription() {
        return description;
    }

    public int getLocationID() {
        return locationID;
    }

    public Map<String, Integer> getExits() {
        return new HashMap<>(this.exits);
    }
}


// ************************THIS IS MUTABLE CLASS*************************************
 //    private final String description;
 //    private final int locationID;
 //    private final Map<String, Integer> exits;
 //
 //    public Locations(int locationID,String description){
 //        this.description=description;
 //        this.locationID=locationID;
 // this.exits=new HashMap<>();
 //
 //        this.exits.put("Q",0);
 //    }
 //
 //   public void addExits(String direction, int loc){
 //        this.exits.put(direction,loc);
 //    }
 //
 //    public String getDescription(){
 //        return description;
 //    }
 //
 //    public int getLocationID(){
 //        return locationID;
 //    }
 //
 //    public Map<String, Integer> getExits(){
 //        return this.exits;
 //    }

 /*
 *****************IMMUTABLE CLASSES******************************
 * Immutable classes are those whose values and functions cannot be changed by third party extension.
 *
 * To make classes immutable we have to do 4 process:
 *
 * 1. Do not provide setter methods =========> This restricts the external user to modify the private member varibles defined
 *    in the class.
 *
 * 2. Make all the fields/variables final and private ===========> final allows to assign the value once. Furthur chnage is not allowed
 *     Private does not allow external class to acess field through reference vaiables.
 *
 * 3. Make the class final ======> This will not allow the class to be subclasses. Bcz if an immutable class is subclasses, then
 *    the methods can be overridden and the purpose of immutable class will not fulfilled.
 *
 * 4. Do not provide methods that modify the object/class. As in line 24, we can access the method through reference variable
 *    and add exits to a particular location. So better way is defined the exits in starting and pass as a constructor.
 *    also dont return the actual object that can be changed . As of line 37, we are returning a new object of Hashmap that
 *    contains all the values of exits. So, if any changes is made then , it will modify only in the copied map object
 *    and not in the actual values of actual hashmap object of the class.
 */


