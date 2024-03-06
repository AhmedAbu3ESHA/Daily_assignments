import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionUtils {
    private static BasicDataSource ds=new BasicDataSource();
    static {
        ds.setUrl("jdbc:mysql://localhost/banktps");
        ds.setUsername("root");
        ds.setPassword("root123");
        ds.setMaxIdle(100);
        ds.setMinIdle(10);
        ds.setMaxOpenPreparedStatements(100);
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    private ConnectionUtils(){}
}
