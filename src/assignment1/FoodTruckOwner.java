package assignment1;
import java.util.*;
/**
 *
 * @author Root
 */
public class FoodTruckOwner extends User {
    
    private int licenseNo;
    private ArrayList<FoodTruck> TruckOwned;
    
    public FoodTruckOwner ()
    {
        super();
        this.licenseNo = 0;
        TruckOwned = new ArrayList<>();
    }
    
    public FoodTruckOwner (String user, String pass, int license)
    {
        super(user, pass, "unknown", "unknown");
        this.licenseNo = license;
        TruckOwned = new ArrayList<>();
    }

    public int getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(int licenseNo) {
        this.licenseNo = licenseNo;
    }
    
    public FoodTruck addFT (String name, String type)
    {
        FoodTruck ft = new FoodTruck(name, type);
        if (TruckOwned.add(ft))
            return ft;
        else
            return null;
    }
    
    public String getClassName()
    {
        String className = this.getClass().getSimpleName(); 
        return className;
    }
    
    public int getTrucksNum ()
    {
        return TruckOwned.size();
    }
    
    public String allTrucksOwned ()
    {
        String all = "Foods truck owned: \n";
        if (TruckOwned.size() != 0)
        {
            for (FoodTruck ft: TruckOwned)
                all += ft.toString() + "\n";
        }
        else
            all += "No trucks owned \n";
        return all;
    }
    
    public String toString()
    {
        return super.getUsername() + " with license no: " + this.getLicenseNo()
                + " with full name: " + super.getFullName() + 
                " with email: " + super.getEmail() + " and \n" + allTrucksOwned();
    }

}
