package assignment1;

/**
 * A Customer class for containing information about a customer
 * @author Wafiy Damit
 */
public class Customer extends User {
    
    /**
     * A constructor for a new Customer with no parameters
     */
    public Customer ()
    {
        super();
    }

    /**
     * A constructor for a new Customer with parameters
     * @param user the username of the customer
     * @param pass the password for logging in
     * @param name the full name of the customer
     * @param email the email address of the customer
     */
    public Customer (String user, String pass, String name, String email)
    {
        super(user, pass, name, email);
    }       
  
    /**
     * A method to get the class name of Customer, which in this case is Customer
     * @return className
     */
    public String getClassName()
    {
        String className = this.getClass().getSimpleName(); 
        return className;
    }
    
    /**
     * A toString method to return information about the Customer
     * @return String information
     */
    public String toString ()
    {
        return super.getUsername() + " with full name: " + super.getFullName()
                + " and email: " + super.getEmail();
    }
}
