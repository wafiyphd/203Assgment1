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
    
    public FoodTruck (FoodTruckOwner owner, String name, String type)
    {
        this.truckID = nextTruckNum++;
        this.owner = owner;
        this.truckName = name;
        this.location = "unknown";
        this.foodType = type;
        this.status = "unknown";
    }
 
    public FoodTruckOwner getOwner ()
    {
        return this.owner;
    }
    
    public void setOwner (FoodTruckOwner fto)
    {
        this.owner = fto;
    }
    
    public int getTruckID() {
        return truckID;
    }

    public String getTruckName() {
        return truckName;
    }

    public void setTruckName(String truckName) {
        this.truckName = truckName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Foodtruck ID: " + truckID + ", with name: " + truckName + ", food type: "
                + foodType + ", location: " + location + ", and status: " + status;
    }
    
    

}
