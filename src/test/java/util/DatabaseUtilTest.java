package util;

import Login.Page.Util.DatabaseUtil;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseUtilTest {
    @Test
    void testConnection() {
        try(HikariDataSource dataSource = DatabaseUtil.getDataSource();
        Connection connection = dataSource.getConnection()){
            System.out.println("Database berhasil terkoneksi dengan baik!");
        } catch (SQLException error){
            throw new RuntimeException(error);
        }
    }
}
