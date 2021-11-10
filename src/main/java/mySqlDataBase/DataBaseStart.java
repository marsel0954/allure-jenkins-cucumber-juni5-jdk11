package mySqlDataBase;


import java.sql.*;

public class DataBaseStart {

    private static final String URL = "jdbc:mysql://10.10.15.45:3306/dev_crmreq_t";
    private static final String USER = "crmreqtdev_u";
    private static final String PASS = "xmsLxaE6ar7v6Rk";

    public static void main(String[] args) {
        Connection connection;

        try {
            connection = DriverManager.getConnection(URL,USER,PASS);
            if (!connection.isClosed()){
                System.out.println("соединение с БД установлено");
            }
        } catch (SQLException e) {
             System.err.println("Не удалось загрузить класс драйвера");
        }

    }
}
