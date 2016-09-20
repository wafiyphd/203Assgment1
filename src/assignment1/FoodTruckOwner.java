package assignment1;
import java.util.*;
/**
 *
 * @author Root
 */
public class FoodTruckOwner extends User {
    
    private int licenseNo;
    
    public FoodTruckOwner ()
    {
        super();
        this.licenseNo = 0;
    }
    
    public FoodTruckOwner (String user, String pass, int license)
    {
        super(user, pass, "unknown", "unknown");
        this.licenseNo = license;
    }

    public int getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(int licenseNo) {
        this.licenseNo = licenseNo;
    }

    public String getClassName()
    {
        String className = this.getClass().getSimpleName(); 
        return className;
    }
    
    public String toString()
    {
        return super.getUsername() + " with license no: " + this.getLicenseNo()
                + " with full name: " + super.getFullName() + 
                " with email: " + super.getEmail();
    }

}
