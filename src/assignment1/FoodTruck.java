package assignment1;

/**
 *
 * @author Root
 */
public class FoodTruck {
    
    private FoodTruckOwner owner;
    private int truckID;
    private String truckName;
    private String location;
    private String foodType;
    private String status;
    
    private static int nextTruckNum = 0;
    
    /**
     * A constructor for a new Food Truck with parameters
     * @param owner
     * @param name
     * @param type 
     */
    public FoodTruck (FoodTruckOwner owner, String name, String type)
    {
        this.truckID = nextTruckNum++;
        this.owner = owner;
        this.truckName = name;
        this.location = "unknown";
        this.foodType = type;
        this.status = "unknown";
    }
 
    /**
     * A method to get the Owner of this food truck
     * @return owner
     */
    public FoodTruckOwner getOwner ()
    {
        return this.owner;
    }
    
    /**
     * A method to set the owner of this food truck to an existing food truck owner
     * @param fto 
     */
    public void setOwner (FoodTruckOwner fto)
    {
        this.owner = fto;
    }
    
    
    /**
     * A method to get the ID of the food truck, which is automatically generated
     * @return truckID
     */
    public int getTruckID() {
        return truckID;
    }

    /**
     * A method to get the name of the food truck
     * @return truckName
     */
    public String getTruckName() {
        return truckName;
    }

    /**
     * A method to set the name of the food truck
     * @param truckName 
     */
    public void setTruckName(String truckName) {
        this.truckName = truckName;
    }

    /**
     * A method to get the location of the food truck
     * @return location
     */
    public String getLocation() {
        return location;
    }

    /**
     * A method to set the location of the food truck
     * @param location 
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * A method to get the food type served by the food truck
     * @return foodType
     */
    public String getFoodType() {
        return foodType;
    }

    /**
     * A method to set the food type served by the food truck
     * @param foodType 
     */
    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    /**
     * A method to get the status of the food truck
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * A method to set the status of the food truck
     * @param status 
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * A toString method to give full information about the food truck
     * @return information about truck
     */
    @Override
    public String toString() {
        return "Foodtruck ID: " + truckID + ", with name: " + truckName + ", food type: "
                + foodType + ", location: " + location + ", and status: " + status;
    }
    
    

}
