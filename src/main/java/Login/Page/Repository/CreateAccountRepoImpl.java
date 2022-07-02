package Login.Page.Repository;

import Login.Page.Entity.LoginPage;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateAccountRepoImpl implements CreateAccountRepo{
    private HikariDataSource dataSource;

    public CreateAccountRepoImpl(HikariDataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Override
    public void add(LoginPage account) {
        String sql = "insert into accountUser(nameUser,emailUser,password) values (?,?,?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, account.getUsername());
            preparedStatement.setString(2, account.getEmail());
            preparedStatement.setString(3, account.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException error) {
            throw new RuntimeException(error);
        }
    }
}
