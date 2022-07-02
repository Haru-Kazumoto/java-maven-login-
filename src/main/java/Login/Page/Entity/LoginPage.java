package Login.Page.Entity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginPage {
    private String Username,email,Password;

    public LoginPage(String username, String email, String password) {
        Username = username;
        this.email = email;
        Password = password;
    }

    public LoginPage(){
        //Empty Constructor
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isValidEmail(String email){
        Pattern p = Pattern.compile("^[a-zA-Z0-9_]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
        Matcher m = p.matcher(email);
        return m.matches();
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

}
