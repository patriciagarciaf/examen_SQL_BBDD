import java.util.UUID;

public class User extends Entity{

    
    private String name; 
    private String email;
    private String lastName;
    private String password;
    private UUID id;

    User(String name, String lastName, String email, String password){
        this.name=name;
        this.email=email;
        this.lastName=lastName;
        this.password=password;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public String getLastName() {
        return lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setName(String name) {
        this.name = name;
    }
    
}
