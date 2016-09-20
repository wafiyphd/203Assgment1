package assignment1;

/**
 * A FoodTruckOwner class for containing information about a Food Truck Owner
 * @author Wafiy Damit
 */
public class FoodTruckOwner extends User {
    
    private int licenseNo;
    
    /**
     * A constructor for a new FoodTruckOwner with no parameters
     */
    public FoodTruckOwner ()
    {
        super();
        this.licenseNo = 0;
    }
    
    /**
     * A constructor for a new FoodTruckOwner with parameters
     * @param user
     * @param pass
     * @param license 
     */
    public FoodTruckOwner (String user, String pass, String name, String email, int license)
    {
        super(user, pass, name, email);
        this.licenseNo = license;
    }

    /**
     * A method to get the license number of a FoodTruckOwner
     * @return licenseNo
     */
    public int getLicenseNo() {
        return licenseNo;
    }

    /**
     * A method to set the license number of a FoodTruckOwner
     * @param licenseNo 
     */
    public void setLicenseNo(int licenseNo)
    {
        if (licenseNo > 0)
            this.licenseNo = licenseNo;
        else
            this.licenseNo = 0;
    }

    /**
     * A method to get the class name of this class, which in this case is FoodTruckOwner
     * @return className
     */
    public String getClassName()
    {
        String className = this.getClass().getSimpleName(); 
        return className;
    }
    
    /**
     * A toString method to return information about the FoodTruckOwner
     * @return String information
     */
    public String toString()
    {
        return super.getUsername() + " with license no: " + this.getLicenseNo()
                + " with full name: " + super.getFullName() + 
                " with email: " + super.getEmail();
    }

}
