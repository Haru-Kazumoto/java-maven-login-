package Repository;

import Login.Page.Entity.LoginPage;
import Login.Page.Repository.CreateAccountRepo;
import Login.Page.Repository.CreateAccountRepoImpl;
import Login.Page.Util.DatabaseUtil;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateAccountRepoTest {
    private HikariDataSource dataSource;
    private CreateAccountRepo createAccountRepo;

    @BeforeEach
    void setUp() {
        dataSource = DatabaseUtil.getDataSource();
        createAccountRepo = new CreateAccountRepoImpl(dataSource);
    }

    @Test
    void testAdd() {
        LoginPage create = new LoginPage();
        String email = "testing@gmail.com";
        if(create.isValidEmail(email)){
            create.setEmail(email);
            create.setPassword("Testing123");
            create.setUsername("Testing");
            createAccountRepo.add(create);
        } else {
            System.out.println("[Error] : Email tidak valid");
        }
    }

    @Test
    void testLogin() {
        try(Connection connection = DatabaseUtil.getDataSource().getConnection();
            Statement statement = connection.createStatement()){
            String ussername = "Testing";
            String password = "Testing123";

            //SQL Variable
            String SQL = "SELECT * FROM accountUser WHERE nameUser = '"+ussername+"' AND password = '"+password+"'";
            ResultSet resultSet = statement.executeQuery(SQL);

            if(resultSet.next()){
                System.out.println("Login Succsess!");
            } else {
                System.out.println("Login Failed!");
            }
        } catch (SQLException error){
            throw new RuntimeException(error);
        }
    }

    @AfterEach
    void tearDown() {
        dataSource.close();
    }
}
