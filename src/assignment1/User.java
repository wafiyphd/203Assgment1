package assignment1;

/**
 *
 * @author Root
 */
public abstract class User {
    
    private String username;
    private String password;
    private String fullName;
    private String email;
    
    public User ()
    {
        this.username = "unknown";
        this.password = "unknown";
        this.fullName = "unknown";
        this.email = "unknown";
    }

    public User (String inUser, String inPass, String inName, String inEmail)
    {
        this.username = inUser;
        this.password = inPass;
        this.fullName = inName;
        this.email = inEmail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public abstract String getClassName();    

    @Override
    public abstract String toString();    
    
}
