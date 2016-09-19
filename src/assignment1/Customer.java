package assignment1;

/**
 *
 * @author Root
 */
public class Customer extends User {
    
    public Customer ()
    {
        super();
    }

    public Customer (String user, String pass, String name, String email)
    {
        super(user, pass, name, email);
    }       
  
    public String getClassName()
    {
        String className = this.getClass().getSimpleName(); 
        return className;
    }
    
    public String toString ()
    {
        return super.getUsername() + " with full name: " + super.getFullName()
                + " and email: " + super.getEmail();
    }
}
