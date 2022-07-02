package Login.Page.View;

import Login.Page.Entity.LoginPage;
import Login.Page.Util.DatabaseUtil;
import Login.Page.Util.inputUtil;
import Login.Page.Service.addAccount;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateAccountView {
    private addAccount addAccount;

    public CreateAccountView(addAccount addAccount) {
        this.addAccount = addAccount;
    }

    public void Menu(){
        while(true){
            System.out.println("1. Sign up");
            System.out.println("2. Sign in");
            System.out.println("3. exit");

            var in = inputUtil.Input(">>");

            if(in.equals("1")){
                AddAccountView();
            } else if(in.equals("2")){
                loginAccountView();
                break;
            } else if(in.equals("3")) {
                System.exit(0);
            }else {
                System.out.println("Error : invalid key");
            }
        }
    }
    public void AddAccountView(){
        LoginPage createAccount = new LoginPage();
        System.out.println("[Create Account]");
        while(true) {
            var email = inputUtil.Input("Insert your email");
            if (!createAccount.isValidEmail(email)) {
                System.out.println("Email tidak terverifikasi");
            } else {
                System.out.println("Email terverifikasi");
                var username = inputUtil.Input("Create username");
                var password = inputUtil.Input("Create password");
                if (username.equals("") || password.equals("")) {
                    System.out.println("Block pada kolom input kosong!, isi kembali");
                } else {
                    createAccount.setEmail(email);
                    createAccount.setUsername(username);
                    createAccount.setPassword(password);
                    System.out.println("Akun berhasil dibuat!");
                    addAccount.addAcc(username, password, email);
                    break;
                }
            }
        }
    }
    public void loginAccountView(){
        while(true){
            try(Connection connection = DatabaseUtil.getDataSource().getConnection();
                Statement statement = connection.createStatement()){
                String username = inputUtil.Input("Username");
                String password = inputUtil.Input("Password");

                //SQL Variable
                String SQL = "SELECT * FROM accountUser WHERE nameUser = '"+username+"' AND password = '"+password+"'";
                ResultSet resultSet = statement.executeQuery(SQL);

                if(resultSet.next()){
                    System.out.println("Login Succsess!");
                    break;
                } else {
                    System.out.println("Login Failed!");
                }
            } catch (SQLException error){
                throw new RuntimeException(error);
            }
        }
    }
}
