package assignment1;
import java.util.*;

/**
 * A container class containing two array lists for Users
 * and food trucks.
 * Also contains methods for the Food Truck Tracker console
 * to use, such as the adding of Food Trucks, Customer, etc.
 * @author Wafiy Damit
 */
public class FoodTruckTracker {
    
    private ArrayList<FoodTruck> FoodTrucks;
    private ArrayList<User> Users;
    
    /**
     * A constructor to initialize the two array lists for Users and FoodTrucks
     */
    public FoodTruckTracker ()
    {
        FoodTrucks = new ArrayList<>();
        Users = new ArrayList<>();
    }
    
    /**
     * A method to add a new food truck to the array of food trucks
     * @param owner
     * @param name
     * @param type
     * @return ft, if successful, null if not
     */
    public FoodTruck addFoodTruck (FoodTruckOwner owner, String name, String type)
    {
        FoodTruck ft = new FoodTruck(owner, name, type);
        if (FoodTrucks.add(ft))
            return ft;
        else
            return null;
    }
    
    /**
     * A method to add a new customer to the array of users
     * @param user
     * @param pass
     * @param name
     * @param email
     * @return customer if successful, null if not
     */
    public Customer addCustomer (String user, String pass, String name, String email)
    {
        Customer customer = new Customer(user, pass, name, email);
        if (Users.add(customer))
            return customer;
        else
            return null;
    }
    
    /**
     * A method to add a new food truck owner to the array of users
     * @param user
     * @param pass
     * @param name
     * @param email
     * @param license
     * @return owner if successful, null if not
     */
    public FoodTruckOwner addFoodTruckOwner (String user, String pass, String name, String email, int license)
    {
        FoodTruckOwner owner = new FoodTruckOwner(user, pass, name, email, license);
        if (Users.add(owner))
            return owner;
        else
            return null;
    }
    
    /**
     * A method to find a food truck by searching for its ID
     * @param find
     * @return the food truck if found, null if not
     */
    public FoodTruck findFoodTruck (int find)
    {
        for (FoodTruck ft:FoodTrucks)
        {
            if (find == ft.getTruckID())
                return ft;
        }
        return null;
    }
    
    /**
     * A method to find a user by its username
     * @param username
     * @return the user if found, null if not
     */
    public User findUser (String username)
    {
        for (User user:Users)
        {
            if (user.getUsername().equalsIgnoreCase(username))
                return user;
        }
        return null;
    }
    
    /**
     * A method to find the amount of trucks a particular food truck
     * owner owns
     * @param fto
     * @return the number of trucks owned by the owner
     */
    public int getTrucksOwnedNum (FoodTruckOwner fto)
    {
        int count = 0;
        for (FoodTruck ft: FoodTrucks)
        {
            if (ft.getOwner() == fto)
                count++;
        }
        return count;
    }
    
    /**
     * A method to list all the food trucks owned with its informations
     * by a particular food truck owner
     * @param fto
     * @return string of information of all the food trucks
     */
    public String getAllTrucksOwned (FoodTruckOwner fto)
    {
        String all = "\nAll food trucks owned: \n";
        if (this.getTrucksOwnedNum(fto) == 0)
            all += "No trucks owned";
        else
            for (FoodTruck ft: FoodTrucks)
            {
                if (ft.getOwner() == fto)
                    all += ft.toString() + "\n";
            }
        return all;
    }
    
    /**
     * A method to check whether a truck belongs to a particular
     * food truck owner (in the parameters) or not
     * @param id
     * @param fto
     * @return true if it is the owner's, false if not
     */
    public boolean getTruckOwner (int id, FoodTruckOwner fto)
    {
        FoodTruck ft = findFoodTruck (id);
        if (ft.getOwner() == fto)
            return true;
        else
            return false;
    }
    
    /**
     * A method to get the array list of food trucks
     * @return FoodTrucks
     */
    public ArrayList<FoodTruck> getFoodTrucks() 
    {
        return FoodTrucks;
    }

    /**
     * A method to get the array list of users
     * @return Users
     */
    public ArrayList<User> getUsers() 
    {
        return Users;
    }

    /**
     * A method to get the current number of users in the array list
     * @return size of the array of users
     */
    public int getNumUsers() 
    {
        return Users.size();
    }
    
    /**
     * A method to get the current number of trucks in the array list
     * @return the size of the array of food trucks
     */
    public int getNumTrucks()
    {
        return FoodTrucks.size();
    }

}
