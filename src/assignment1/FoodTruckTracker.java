package assignment1;
import java.util.*;

/**
 *
 * @author Root
 */
public class FoodTruckTracker {
    
    private ArrayList<FoodTruck> FoodTrucks;
    private ArrayList<User> Users;
    
    public FoodTruckTracker ()
    {
        FoodTrucks = new ArrayList<>();
        Users = new ArrayList<>();
    }
    
    public FoodTruck addFoodTruck (FoodTruckOwner owner, String name, String type)
    {
        FoodTruck ft = new FoodTruck(owner, name, type);
        if (FoodTrucks.add(ft))
            return ft;
        else
            return null;
    }
    
    public Customer addCustomer (String user, String pass, String name, String email)
    {
        Customer customer = new Customer(user, pass, name, email);
        if (Users.add(customer))
            return customer;
        else
            return null;
    }
    
    public FoodTruckOwner addFoodTruckOwner (String user, String pass, int license)
    {
        FoodTruckOwner owner = new FoodTruckOwner(user, pass, license);
        if (Users.add(owner))
            return owner;
        else
            return null;
    }
    
    public FoodTruck findFoodTruck (int find)
    {
        for (FoodTruck ft:FoodTrucks)
        {
            if (find == ft.getTruckID())
                return ft;
        }
        return null;
    }
    
    public User findUser (String username)
    {
        for (User user:Users)
        {
            if (user.getUsername().equalsIgnoreCase(username))
                return user;
        }
        return null;
    }
    
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
    
    public boolean getTruckOwner (int id, FoodTruckOwner fto)
    {
        FoodTruck ft = findFoodTruck (id);
        if (ft.getOwner() == fto)
            return true;
        else
            return false;
    }
    
    public ArrayList<FoodTruck> getFoodTrucks() 
    {
        return FoodTrucks;
    }

    public ArrayList<User> getUsers() 
    {
        return Users;
    }

    public int getNumUsers() 
    {
        return Users.size();
    }
    
    public int getNumTrucks()
    {
        return FoodTrucks.size();
    }

}
