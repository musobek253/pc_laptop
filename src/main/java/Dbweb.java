import model.Laptop;
import model.Pc;
import model.Printer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.sql.DriverManager.getConnection;

public class Dbweb {
    private final String jdbcURL = "jdbc:postgresql://localhost:5432/computer_db";
    private final String jdbcUsername = "postgres";
    private final String jdbcPassword = "user";

    private static final String listpc = "select maker,model,price from pc join product p using (model)";
    private static final String listLaptop = "select maker,model,price from laptop join product p using (model)";
    private static final String listPrinter = "select maker,model,price from printer join product p using (model)";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        }
        return connection;
    }


    public List<Pc> selectAllPc() {
        List<Pc> pcs = new ArrayList<>();

        try {
              Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(listpc);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String maker = rs.getString("maker");
                String name = rs.getString("model");
                int price = rs.getInt("price");
                pcs.add(new Pc(maker,name,price));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return pcs;
    }

    public List<Laptop> selectAllLaptop() {
        List<Laptop> laptops = new ArrayList<>();
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            PreparedStatement preparedStatement = connection.prepareStatement(listLaptop);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String maker = rs.getString("maker");
                String name = rs.getString("model");
                int price = rs.getInt("price");
                laptops.add(new Laptop(maker,name,price));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return laptops;
    }

    public List<Printer> selectAllPrinter() {
        List<Printer> printers = new ArrayList<>();
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            PreparedStatement preparedStatement = connection.prepareStatement(listPrinter);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String maker = rs.getString("maker");
                String name = rs.getString("model");
                int price = rs.getInt("price");
                printers.add(new Printer(maker,name,price));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return printers;
    }
}





