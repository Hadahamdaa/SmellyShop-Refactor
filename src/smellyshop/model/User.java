package smellyshop.model;

public class User {
    private String username;
    private String password;
    private String role; 

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() { return username; }
    
    public boolean checkPassword(String inputPass) { 
        return this.password.equals(inputPass); 
    }
    
    public String getRole() { return role; }
}
