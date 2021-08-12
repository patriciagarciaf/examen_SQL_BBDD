import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.print.attribute.SetOfIntegerSyntax;

import jdk.incubator.vector.VectorOperators.Binary;

public class PizzaDao implements Dao<Pizza>{
    
    static final String JDBC_DRIVER = System.getenv("JDBC_Driver");
    static final String URL = System.getenv("url");
    static final String USER = System.getenv("user");
    static final String PASS = System.getenv("password");
    

    private void registerDriver() throws IllegalAccessException {

        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("hecho");
        } catch (Exception ex) {
            ex.getCause();
            System.out.println("no va coño");
        }
}
    


    final String selectPizza= """
    SELECT id, name, url 
    FROM pizza
    WHERE id=?
    """;

    final String selectAll="""
    SELECT id, name, url
    FROM pizza
    """;

    final String insertPizza= """
             INSERT INTO pizza(id, name, url)
             VALUES
             (?,?,?);
          """;

    final String updatePizza="""
        UPDATE pizza
        SET name=?
        WHERE id=?
    """;
    final String [] parametros= {"name=Peperoni,", "url=peperoni.png"};

    final String deletePizza="""
    DELETE
    FROM pizza
    WHERE id=?
    """;
    Pizza pizza;
    UuidAdapter uuidadapter= new UuidAdapter();


    @Override
    public Optional<List<Pizza>> selectAll(){
    List<Pizza> listaPizzas = new ArrayList<Pizza>();
    try {
        Connection connection = DriverManager.getConnection(URL, USER, PASS);
        PreparedStatement selectPizza = connection.prepareStatement(selectAll);

        ResultSet rs = selectPizza.executeQuery();
        int i=0;
        while (rs.next()) {
            
        listaPizzas.add(new Pizza(rs.getString(2), rs.getString(3)));
        System.out.println(listaPizzas.get(i).getName());
        i++;
        }
        
        return Optional.of(listaPizzas);
    } catch (SQLException e) {
        e.printStackTrace();
        return Optional.of(listaPizzas);
    }
}
    

    @Override
    public void insert(Pizza pizza){
        try (Connection connect = DriverManager.getConnection(URL, USER, PASS);
        Statement stmn = connect.createStatement();){
            PreparedStatement stPizza = connect.prepareStatement(insertPizza);
     
            stPizza.setObject(1, UuidAdapter.getBytesFromUUID(pizza.getId()));
            stPizza.setString(2, pizza.getName());
            stPizza.setString(3, pizza.getUrl());
     
            stPizza.executeUpdate();
            System.out.println(pizza.getName() + " pizza has been saved correctly.");}
            catch (SQLException excep) {
            excep.printStackTrace();
            System.out.println("Error saving the pizza.");
            }
        }
 

    @Override
    public Optional<Pizza> select(UUID uuid){
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement sPizza = connection.prepareStatement(selectPizza);
            sPizza.setBytes(1, UuidAdapter.getBytesFromUUID(uuid));
    
            ResultSet rs = sPizza.executeQuery();
            System.out.println(rs);
            //while (rs.next()) {
            Pizza pizza=new Pizza(rs.getString(2), rs.getString(3));
            //}
            System.out.println("Pizza recuperada");
            connection.close();
            return Optional.of(pizza);
        } catch (SQLException e) {
            e.printStackTrace();
            return Optional.of(pizza);
        }
    }
 

    @Override
    public void update(UUID uuid, String params) {

    try(Connection conn = DriverManager.getConnection(URL, USER, PASS);
    Statement statement = conn.createStatement();)

    { PreparedStatement changePizza= conn.prepareStatement(updatePizza);

        changePizza.setObject(2, uuid);
        changePizza.setString(1, pizza.getName());

        changePizza.executeUpdate();

        System.out.println("Modificada la pizza "+pizza.getName());
       
    } catch (SQLException e){
        e.printStackTrace();
        System.out.println("No se pudo modificar la pizza "+pizza.getName());
    }
        

    }

    @Override
    public String delete(UUID uuid) {
            try {
                Connection connection = DriverManager.getConnection(URL, USER, PASS);
                PreparedStatement dPizza = connection.prepareStatement(deletePizza);
                dPizza.setBytes(1, UuidAdapter.getBytesFromUUID(uuid));
        
                ResultSet rs = dPizza.executeQuery();
 
                connection.close();
                return "Pizza eliminada";
            } catch (SQLException e) {
                e.printStackTrace();
                return "Error al eliminar la pizza";
            }
        }
    
}
