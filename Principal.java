import java.sql.*;


 
public class Principal{

    public static void main(String[] args) throws SQLException {

            // app.insertIngredient("tomato", 1.50);
            // app.insertIngredient("cheese", 1.20);
            // app.insertIngredient("bacon", 1.30);
            // app.insertIngredient("ham", 1.00);
            // app.insertIngredient("bbq", 0.90);
            // app.insertIngredient("cream", 0.90);
            // app.insertIngredient("tuna", 1.00);
            // app.insertIngredient("oregano", 0.50);

            // app.insertUser("Juan", "Lopez", "juanlopez@gmail.com", "juanlo12");
            // app.insertUser("Eustaquio", "Martinez", "eustaquio@gmail.com", "eustaqui98");
            // app.insertUser("Ambrosia", "Justa", "ambrosia@gmail.com", "justa13");
            // app.insertUser("Eulalia", "Jimenez", "eulalia@gmail.com", "eulalia65");

            // app.insertPizza("Carbonara", "carbonara.png");
            // app.insertPizza("Barbacoa", "barbacoa.png");
            // app.insertPizza("Atún y Bacon", "atunbacon.png");
            // app.insertPizza("Margarita", "margarita.png");

            //app.insertComment( "Carbonara", "Juan", "Muy rica", 10);
           //app.selectUserId("Juan");
           //app.query("Juan");

        //    app.insertPizzaIngredients("Carbonara", "dought");
        //    app.insertPizzaIngredients("Carbonara", "cream");
        //    app.insertPizzaIngredients("Carbonara", "bacon");
        //    app.insertPizzaIngredients("Carbonara", "cheese");

       
        PizzaDao pizzaDao= new PizzaDao();
        
        //UUID id2= UUID.randomUUID();
        //Pizza atunBacon= new Pizza("Atun y bacon", "atunbacon.png");
        //atunBacon.setId(id1);
        //pizzaDao.insert(atunBacon);
       
        
        // Pizza barbacoa= new Pizza("Barbacoa", "barbacoa.png");
        // barbacoa.setId(id2);
        // pizzaDao.insert(barbacoa);
        // pizzaDao.select(id2);

        pizzaDao.selectAll();
        
        
        //commentDao.selectAll();
        //Comment comentario1=new Comment(user1, "Qué asco de pizza", 1, atunBacon);
        //commentDao.select(comentario1);

       // userDao.save(user1);
        //userDao.select(user1);

        //pizzaDao.select(18775207-fb89-11eb-adbe-e8d8d1f0c0d8);
        //UUID pruebaId=c78cda9c-fb8b-11eb-adbe-e8d8d1f0c0d8;
                   
        
    }
}
