package assignment1;

/**
 *
 * @author Root
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
     * @param user
     * @param pass
     * @param name
     * @param email 
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
