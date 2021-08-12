import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

public class Ingredient extends Entity{
    private String name;
    private double price;
    private UUID id;

    Ingredient(String name, double price){
        this.name=name;
        this.price=price;
    }

    public void validate(){
        super.validate();

    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price){
        this.price=price;
    }
    public double getPrice(){
        return price;
    }

    public ResultSet select(IngredientDao ingredientDao) {
        ResultSet rs=null;
    
        try(Connection conn = DriverManager.getConnection(IngredientDao.URL, IngredientDao.USER, IngredientDao.PASS);
        Statement statement = conn.createStatement();)
    
        { PreparedStatement getIngredient= conn.prepareStatement(ingredientDao.selectIngredient);
            
            getIngredient.setString(1, getName());
    
            rs=getIngredient.executeQuery();
        
            while (rs.next()) {
            String id=rs.getString("id");
            String name= rs.getString("name");
            String price=rs.getString("price");
            
            System.out.println("id,             name,         price");
            System.out.format("%s, %s, %s\n", id, name, price);
            }
    
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("No funciona");
        }
            return rs; // RETURN NULL?????
    }

    // public void add(Ingredient ingredient) {
    // }

    // public void remove(Ingredient ingredient) {
    // }  
        

}