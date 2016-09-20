package assignment1;
import java.util.*;
/**
 *
 * @author Root
 */
public class FTTConsole {
    
    static Scanner kbd;
    static FoodTruckTracker ftt;
    static Customer custLogin;
    static FoodTruckOwner ownerLogin;
    
    public static void main (String[] args)
    {
        ftt = new FoodTruckTracker();
        kbd = new Scanner(System.in);
        
        System.out.println("Welcome to the Food Truck Tracker!");
        System.out.println("Please sign up to start using.");
        
        System.out.println("\nDo you want to sign up or log in?");
        System.out.println("1. Sign up");
        System.out.println("2. Log in");
        System.out.println("3. Exit");
        System.out.println("Enter choice: ");
        int choice = kbd.nextInt();
        kbd.nextLine();
        while (choice != 1 && choice != 2 && choice != 3)
        {
            System.out.println("\nInvalid choice!");
            System.out.println("Please enter valid choice: ");
            choice = kbd.nextInt();
            kbd.nextLine();
        }

        while (choice != 3)
        {
            switch (choice)
            {
                case 1: 
                    signUp(); 
                    break;
                case 2:
                    if (ftt.getNumUsers() == 0)
                        System.out.println("\nNo users found, please sign up.");
                    else
                        login();
                    break;
            }
            System.out.println("\nThere are " + ftt.getNumUsers() + " users signed up");
            System.out.println("Do you want to sign up or log in?");
            System.out.println("1. Sign up");
            System.out.println("2. Log in");
            System.out.println("3. Exit");
            System.out.println("Enter choice: ");
            choice = kbd.nextInt();
            kbd.nextLine();
            while (choice != 1 && choice != 2 && choice != 3)
            {
                System.out.println("\nInvalid choice!");
                System.out.println("Please enter valid choice: ");
                choice = kbd.nextInt();
                kbd.nextLine();
            }
        }
        System.out.println("\nGoodbye, thank you for using Food Truck Tracker!");
    }
    
    /**
     * A method for the signing up process of the console
     */
    public static void signUp ()
    {
        System.out.println("\nAre you:");
        System.out.println("1. A Customer");
        System.out.println("2. A Food Truck Owner \n");
        System.out.println("Enter choice: ");
        int choice = kbd.nextInt();
        kbd.nextLine();

        while (choice != 1 && choice != 2)
        {
            System.out.println("\nInvalid choice!");
            System.out.println("Please enter valid choice: ");
            choice = kbd.nextInt();
            kbd.nextLine();
        }

        switch(choice)
        {
            case 1: addCustomer(); break;
            case 2: addOwner(); break;
        }
    }
    
    /**
     * A method for signing up as a customer
     */
    public static void addCustomer ()
    {
        System.out.println("\nSigning up as customer.");
        System.out.println("Please enter user name: ");
        String user = kbd.nextLine();
        User userfind = ftt.findUser(user);
        while(userfind != null)
        {
            System.out.println("\nThat username is taken.");
            System.out.println("Please pick different username: ");
            user = kbd.nextLine();
            userfind = ftt.findUser(user);
        }
        
        System.out.println("Please enter password: ");
        String pass = kbd.nextLine();
        System.out.println("Please enter full name: ");
        String name = kbd.nextLine();
        System.out.println("Please enter email address: ");
        String email = kbd.nextLine();
        
        Customer cust = ftt.addCustomer(user, pass, name, email);
        if (cust != null)
            System.out.println("\nUser successfully added.");
        else
            System.out.println("\nFailed, user not added.");
    }
    
    /**
     * A method for signing up as a Food Truck Owner
     */
    public static void addOwner ()
    {
        System.out.println("\nSigning up as Food Truck Owner.");
        System.out.println("Please enter user name: ");
        String user = kbd.nextLine();
        User userfind = ftt.findUser(user);
        while(userfind != null)
        {
            System.out.println("\nThat username is taken.");
            System.out.println("Please pick different username: ");
            user = kbd.nextLine();
            userfind = ftt.findUser(user);
        }
        
        System.out.println("Please enter password: ");
        String pass = kbd.nextLine();
        System.out.println("Please enter license number: ");
        int license = kbd.nextInt();
        kbd.nextLine();
        
        FoodTruckOwner fto = ftt.addFoodTruckOwner(user, pass, license);
        if (fto != null)
            System.out.println("\nUser successfully added.");
        else
            System.out.println("\nFailed, user not added.");
    }

    /**
     * A method for the logging in process of the console
     */
    public static void login ()
    {
        System.out.println("\nLogging in.");
        System.out.println("\nPlease enter your username: ");
        String find = kbd.nextLine();
        User ft = ftt.findUser(find);
        while (ft == null)
            {
                System.out.println("Invalid username");
                System.out.println("\nPlease enter your username: ");
                find = kbd.nextLine();
                ft = ftt.findUser(find);
            }
        
        if (ft.getClassName().equals("Customer"))
        {    
            custLogin = (Customer) ft;
            loginCustomer();
        }
        
        else
        {
            ownerLogin = (FoodTruckOwner) ft;
            loginOwner();
        }
    }
    
    /**
     * A method for logging in as a Customer
     */
    public static void loginCustomer ()
    {
        System.out.println("\nPlease enter your password:");
        String passwd = kbd.nextLine();
        while (!passwd.equals(custLogin.getPassword()))
        {
            System.out.println("Wrong password!");
            System.out.println("\nPlease enter correct password: ");
            passwd = kbd.nextLine();
        }

        System.out.println("\nSuccessfully logged in.");
        System.out.println("(Logged in as Customer)");
        System.out.println("\nUser details: ");
        System.out.println(custLogin.toString());

        System.out.println("\nWhat would you like to do: ");
        System.out.println("1. Modify user details");
        System.out.println("2. Logout");
        System.out.println("Enter choice: ");
        int choice = kbd.nextInt();
        kbd.nextLine();

        while (choice != 1 && choice != 2)
        {
            System.out.println("\nInvalid choice!");
            System.out.println("Please enter valid choice: ");
            choice = kbd.nextInt();
            kbd.nextLine();
        }

        while (choice != 2) 
        {
            modifyCustomer();
            System.out.println("\nWhat would you like to do: ");
            System.out.println("1. Modify user details");
            System.out.println("2. Logout");
            System.out.println("Enter choice: ");
            choice = kbd.nextInt();
            kbd.nextLine();
        }
        System.out.println("\nSuccessfully logged out.");
    }
    
    /**
     * A method for logging in as an owner
     */
    public static void loginOwner ()
    {
        System.out.println("\nPlease enter your password:");
        String passwd = kbd.nextLine();
        while (!passwd.equals(ownerLogin.getPassword()))
        {
            System.out.println("Wrong password!");
            System.out.println("\nPlease enter correct password: ");
            passwd = kbd.nextLine();
        }

        System.out.println("\nSuccessfully logged in.");
        System.out.println("(Logged in as Food Truck Owner)");
        System.out.println("\nUser details: ");
        System.out.println(ownerLogin.toString() + ftt.getAllTrucksOwned(ownerLogin));
        
        System.out.println("\nWhat would you like to do: ");
        System.out.println("1. Modify user details");
        System.out.println("2. Manage trucks");
        System.out.println("3. Logout");
        System.out.println("Enter choice: ");
        int choice = kbd.nextInt();
        kbd.nextLine();
        
        while (choice != 1 && choice != 2 && choice != 3)
        {
            System.out.println("\nInvalid choice!");
            System.out.println("Please enter valid choice: ");
            choice = kbd.nextInt();
            kbd.nextLine();
        }
            
        while (choice != 3 && choice != 2) 
        {
            modifyOwner();
            System.out.println("\nWhat would you like to do: ");
            System.out.println("1. Modify user details");
            System.out.println("2. Manage trucks");
            System.out.println("3. Logout");
            System.out.println("Enter choice: ");
            choice = kbd.nextInt();
            kbd.nextLine();
        }
        
        while (choice != 1 && choice != 3)
        {
            manageTrucks();
            System.out.println("\nWhat would you like to do: ");
            System.out.println("1. Modify user details");
            System.out.println("2. Manage trucks");
            System.out.println("3. Logout");
            System.out.println("Enter choice: ");
            choice = kbd.nextInt();
            kbd.nextLine();
        }
        
        System.out.println("\nSuccessfully logged out.");
        
    }
    
    /**
     * A method for modifying details of a customer
     */
    public static void modifyCustomer ()
    {
        System.out.println("\nWhat would you like to modify?");
        System.out.println("1. Password");
        System.out.println("2. Full name");
        System.out.println("3. Email address");
        System.out.println("Enter choice: ");
        int modify = kbd.nextInt();
        kbd.nextLine();

        while (modify != 1 && modify != 2 && modify != 3)
        {
            System.out.println("\nInvalid choice!");
            System.out.println("Please enter valid choice: ");
            modify = kbd.nextInt();
            kbd.nextLine();
        }

        switch (modify) 
        {
            case 1:
                System.out.println("\nChanging password");
                System.out.println("Please enter new password: ");
                String newpass = kbd.nextLine();
                System.out.println("Re-enter new password: ");
                String newpassConf = kbd.nextLine();
                while (!newpass.equals(newpassConf))
                {
                    System.out.println("\nPassword not equal, please re-enter: ");
                    newpassConf = kbd.nextLine();
                }   custLogin.setPassword(newpassConf);
                System.out.println("\nPassword successfully changed.");
                break;
                
            case 2:
                System.out.println("\nChanging full name");
                System.out.println("Please enter new full name: ");
                String newname = kbd.nextLine();
                custLogin.setFullName(newname);
                System.out.println("\nFull name successfully changed to '" + newname + "'.");
                break;
                
            case 3:
                System.out.println("\nChanging email address");
                System.out.println("Please enter new email address: ");
                String newemail = kbd.nextLine();
                custLogin.setEmail(newemail);
                System.out.println("\nFull name successfully changed to '" + newemail + "'.");
                break;
        }

        System.out.println("\nUser details: ");
        System.out.println(custLogin.toString());
    }
    
    
    /**
     * A method for modifying details of a food truck owner
     */
    public static void modifyOwner ()
    {
        System.out.println("\nWhat would you like to modify?");
        System.out.println("1. Password");
        System.out.println("2. Full name");
        System.out.println("3. Email address");
        System.out.println("Enter choice: ");
        int modify = kbd.nextInt();
        kbd.nextLine();

        while (modify != 1 && modify != 2 && modify != 3)
        {
            System.out.println("\nInvalid choice!");
            System.out.println("Please enter valid choice: ");
            modify = kbd.nextInt();
            kbd.nextLine();
        }

        switch (modify) 
        {
            case 1:
                System.out.println("\nChanging password");
                System.out.println("Please enter new password: ");
                String newpass = kbd.nextLine();
                System.out.println("Re-enter new password: ");
                String newpassConf = kbd.nextLine();
                while (!newpass.equals(newpassConf))
                {
                    System.out.println("\nPassword not equal, please re-enter: ");
                    newpassConf = kbd.nextLine();
                }   ownerLogin.setPassword(newpassConf);
                System.out.println("\nPassword successfully changed.");
                break;
                
            case 2:
                System.out.println("\nChanging full name");
                System.out.println("Please enter new full name: ");
                String newname = kbd.nextLine();
                ownerLogin.setFullName(newname);
                System.out.println("\nFull name successfully changed to '" + newname + "'.");
                break;
                
            case 3:
                System.out.println("\nChanging email address");
                System.out.println("Please enter new email address: ");
                String newemail = kbd.nextLine();
                ownerLogin.setEmail(newemail);
                System.out.println("\nFull name successfully changed to '" + newemail + "'.");
                break;
        }

        System.out.println("\nUser details: ");
        System.out.println(ownerLogin.toString() + ftt.getAllTrucksOwned(ownerLogin));
    }
    
    /**
     * A method to manage trucks for food truck owners
     */
    public static void manageTrucks ()
    {
        System.out.println("\nManaging Trucks.");
        System.out.println("\nUser details: ");
        System.out.println(ftt.getAllTrucksOwned(ownerLogin));
        
        System.out.println("\nWhat would you like to do?");
        System.out.println("1. Add a truck");
        System.out.println("2. Modify truck details");
        System.out.println("3. Exit managing truck");
        System.out.println("Enter choice: ");
        int choice = kbd.nextInt();
        kbd.nextLine();
        
        while (choice != 1 && choice != 2 && choice != 3)
        {
            System.out.println("\nInvalid choice!");
            System.out.println("Please enter valid choice: ");
            choice = kbd.nextInt();
            kbd.nextLine();
        }
        
        while (choice != 3)
        {
            switch(choice)
            {
                case 1: 
                    addTruck(); 
                    break;
                case 2:
                    if (ftt.getTrucksOwnedNum(ownerLogin) == 0)
                        System.out.println("\nNo trucks owned yet, please add a Truck.");
                    else
                        modifyTruck();
                    break;
            }
            
            System.out.println(ftt.getAllTrucksOwned(ownerLogin));
            
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Add a truck");
            System.out.println("2. Modify truck details");
            System.out.println("3. Exit managing truck");
            System.out.println("Enter choice: ");
            choice = kbd.nextInt();
            kbd.nextLine();
            
            while (choice != 1 && choice != 2 && choice != 3)
            {
            System.out.println("\nInvalid choice!");
            System.out.println("Please enter valid choice: ");
            choice = kbd.nextInt();
            kbd.nextLine();
            }
        }
    }
    
    /**
     * A method for adding trucks for an owner
     */
    public static void addTruck ()
    {
        System.out.println("\nAdding a new truck");
        System.out.println("Please enter the name of food truck: ");
        String name = kbd.nextLine();
        System.out.println("Please enter the food type served by the food truck: ");
        String foodtype = kbd.nextLine();
        FoodTruck ft = ftt.addFoodTruck(ownerLogin, name, foodtype);
        if (ft != null)
        {
            System.out.println("\nSuccessfully added new truck!");
            System.out.println(ft.toString());
        }
        else
            System.out.println("\nFailed, truck not added");
    }
    
    /**
     * A method to modify truck details for an owner    
     */
    public static void modifyTruck ()
    {
        System.out.println("\nModifying trucks");
        System.out.println(ftt.getAllTrucksOwned(ownerLogin));
        System.out.println("Which truck would you like to modify?");
        System.out.println("Enter ID of truck: ");        
        int ID = kbd.nextInt();
        kbd.nextLine();
        
        FoodTruck ft = ftt.findFoodTruck(ID);
        while (ft == null)
        {
            System.out.println("\nTruck with that ID not found ");
            System.out.println("Enter ID of truck: ");
            ID = kbd.nextInt();
            kbd.nextLine();
            ft = ftt.findFoodTruck(ID);
        }
        
        while (ftt.getTruckOwner(ID, ownerLogin) == false)
        {
            System.out.println("The truck with that ID is not yours.");
            System.out.println("Enter ID of truck: ");
            ID = kbd.nextInt();
            kbd.nextLine();
            ft = ftt.findFoodTruck(ID);
        }
        
        System.out.println("\nWhat would you like to modify?");
        System.out.println("1. Truck name");
        System.out.println("2. Truck food type");
        System.out.println("3. Truck location");
        System.out.println("4. Truck status");
        System.out.println("5. Exit modifying trucks");
        System.out.println("Enter choice: ");
        int choice = kbd.nextInt();
        kbd.nextLine();
        
        while (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5)
        {
            System.out.println("\nInvalid choice!");
            System.out.println("Please enter valid choice: ");
            choice = kbd.nextInt();
            kbd.nextLine();
        }
        
        while (choice != 5)
        {
            switch (choice)
            {
                case 1:
                    System.out.println("\nPlease enter new name of truck: ");
                    String name = kbd.nextLine();
                    ft.setTruckName(name);
                    System.out.println("\nSuccessfully changed truck name to '" + name + "'.");
                    break;
                case 2:
                    System.out.println("\nPlease enter new food type of truck: ");
                    String foodtype = kbd.nextLine();
                    ft.setFoodType(foodtype);
                    System.out.println("\nSuccessfully changed truck food type to '" + foodtype + "'.");
                    break;
                case 3:
                    System.out.println("\nPlease enter new location of truck: ");
                    String location = kbd.nextLine();
                    ft.setLocation(location);
                    System.out.println("\nSuccessfully changed truck location to '" + location + "'.");
                    break;
                case 4:
                    System.out.println("\nPlease enter new status of truck: ");
                    String status = kbd.nextLine();
                    ft.setStatus(status);
                    System.out.println("\nSuccessfully changed truck status to '" + status + "'.");
                    break;
            }
            
            System.out.println(ftt.getAllTrucksOwned(ownerLogin));
            
            System.out.println("\nWhat would you like to modify?");
            System.out.println("1. Truck name");
            System.out.println("2. Truck food type");
            System.out.println("3. Truck location");
            System.out.println("4. Truck status");
            System.out.println("5. Exit modifying trucks");
            System.out.println("Enter choice: ");
            choice = kbd.nextInt();
            kbd.nextLine();

            while (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5)
            {
                System.out.println("\nInvalid choice!");
                System.out.println("Please enter valid choice: ");
                choice = kbd.nextInt();
                kbd.nextLine();
            } 
        }
    }
    
    
}
