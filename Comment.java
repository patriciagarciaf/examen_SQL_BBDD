import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.UUID;


public class Comment extends Entity{

    private Date date;
    private String text;
    private int rating;
    public Pizza pizza; //NO HACEN FALTA XQ YA ESTÁN RELACIONADOS EN PIZZA, ES RELACION 1.MUCHOS
    private final User user; //SI XQ ES RELACION 1.1, no se si tengo q hacer getters y setters
    private UUID id;

    SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    public Date getDate() {
        return this.date;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId() {
        this.id = UUID.randomUUID();
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getRating() {
        return this.rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user){
        //this.user=user;
    }

    


    public Comment(User user, String text, int rating, Pizza pizza) {
        this.user = user;
        this.rating=rating;
        this.text=text;
        this.date=java.sql.Date.valueOf(java.time.LocalDate.now());
        this.pizza=pizza;
    }


    // public void add(Comment comment) {
    // }
    // public void remove(Comment comment) {
    // }
    
}
