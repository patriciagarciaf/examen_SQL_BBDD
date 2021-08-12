import java.sql.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class IngredientDao implements Dao<Ingredient>{

    static String URL= System.getenv("url");
    static String USER =System.getenv("user");
    static String PASS = System.getenv("password");

    final String selectIngredient= """
    SELECT id, name, price 
    FROM ingredients
    WHERE name=?
    """;

    final String selectAll="""
    SELECT id, name, price
    FROM ingredients
    """;

    final String insertIngredient= """
             INSERT INTO ingredients(id, name, price)
             VALUES
             (UUID_TO_BIN(UUID()),?,?);
          """;

    final String updateIngredient="""
        UPDATE ingredients
        SET ?
        WHERE name=?
    """;
    final String [] parametros= {"name=Peperoni,", "url=peperoni.png"};

    final String deleteIngredient="""
    DELETE
    FROM ingredients
    WHERE name=?
    """;


    @Override
    public Optional<List<Ingredient>> selectAll(){
    List<Ingredient> listaIng = new ArrayList<Ingredient>();
    try {
        Connection connection = DriverManager.getConnection(URL, USER, PASS);
        PreparedStatement selectPizza = connection.prepareStatement(selectAll);

        ResultSet rs = selectPizza.executeQuery();
        int i=0;
        while (rs.next()) {
            
        listaIng.add(new Ingredient(rs.getString(2), rs.getDouble(3)));
        System.out.println(listaIng.get(i).getName());
        i++;
        }
        
        return Optional.of(listaIng);
    } catch (SQLException e) {
        e.printStackTrace();
        return Optional.of(listaIng);
    }
}
    

    @Override
    public void insert(Ingredient ingredient){
        try (Connection connect = DriverManager.getConnection(URL, USER, PASS);
        Statement stmn = connect.createStatement();){
            PreparedStatement stPizza = connect.prepareStatement(insertIngredient);
     
            stPizza.setObject(1, UuidAdapter.getBytesFromUUID(ingredient.getId()));
            stPizza.setString(2, ingredient.getName());
            stPizza.setString(3, ingredient.getUrl());
     
            stPizza.executeUpdate();
            System.out.println(ingredient.getName() + " pizza has been saved correctly.");}
            catch (SQLException excep) {
            excep.printStackTrace();
            System.out.println("Error saving the pizza.");
            }
        }
 

    @Override
    public Optional<Ingredient> select(UUID uuid){
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement sPizza = connection.prepareStatement(selectIngredient);
            sPizza.setBytes(1, UuidAdapter.getBytesFromUUID(uuid));
    
            ResultSet rs = sPizza.executeQuery();
            System.out.println(rs);
            //while (rs.next()) {
            Ingredient ing=new Pizza(rs.getString(2), rs.getString(3));
            //}
            System.out.println("Pizza recuperada");
            connection.close();
            return Optional.of(ing);
        } catch (SQLException e) {
            e.printStackTrace();
            return Optional.of(ing);
        }
    }
 

    @Override
    public void update(UUID uuid, String params) {

    try(Connection conn = DriverManager.getConnection(URL, USER, PASS);
    Statement statement = conn.createStatement();)

    { PreparedStatement changePizza= conn.prepareStatement(updateIngredient);

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
