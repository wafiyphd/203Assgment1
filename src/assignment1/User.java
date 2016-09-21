package assignment1;

/**
 * An abstract user class with subclasses Customer and FoodTruckOwner
 * @author Wafiy Damit 
 */
public abstract class User {
    
    private String username;
    private String password;
    private String fullName;
    private String email;
    
    
    /**
     * A super constructor for subclasses, Customer & FoodTruckOwners with no parameters
     */
    public User ()
    {
        this.username = "unknown";
        this.password = "unknown";
        this.fullName = "unknown";
        this.email = "unknown";
    }

    /**
     * A super constructor for subclasses, Customer & FoodTrucksOwners with parameters
     * @param inUser the username of the user
     * @param inPass the password for logging in
     * @param inName the full name of the user
     * @param inEmail the email of the user
     */
    public User (String inUser, String inPass, String inName, String inEmail)
    {
        this.username = inUser;
        this.password = inPass;
        this.fullName = inName;
        this.email = inEmail;
    }

    /**
     * A method to get username of User
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * A method to set username of user
     * @param username the username of the user
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * A method to get the password of User
     * @return password 
     */
    public String getPassword() {
        return password;
    }

    /**
     * A method to set password of user
     * @param password the password for logging in
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * A method to get the full name of user
     * @return fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * A method to set the full name of user
     * @param fullName the full name of the user
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * A method to get the email of user
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * A method to set the email of user
     * @param email the amil of the user
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * A method to get the Class name of User whether Customer or FoodTruckOwner
     * @return class name of User, Customer / FoodTruckOwner
     */
    public abstract String getClassName();    

    /**
     * An abstract toString method 
     * @return information about User, whether Customer / FoodTruckOwner
     */
    @Override
    public abstract String toString();    
    
}
