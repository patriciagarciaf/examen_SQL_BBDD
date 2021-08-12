import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.lang.Double;


public class Pizza extends Entity{

    private String name;
    private UUID id;
    private double price;
    private String url;
    private final Set<Ingredient> ingredients= new HashSet<Ingredient>();
    private final List<Comment> comments=new ArrayList<Comment>();
    //public List<Double> ingrPrice= new ArrayList<Double>();


    public Pizza(String name, String url){
        this.name=name;
        this.url=url;
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
    public void setPrice(double price) {
        this.price = price;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Set<Ingredient> getIngredients() {
        return this.ingredients;
    }

    public List<Comment> getComments() {
        return this.comments;
    }

    public void setComentario(Comment comment){
        comments.add(comment);
    }

    public void removeIngredient(Ingredient ingredient){
        ingredients.remove(ingredient);
    }
    public void removeComment(Comment comment){
        comments.remove(comment);
    }


    public static double sum(List<Double> list){
        double sum=0;
        for (double i: list){
            sum+=i;
        }
        return sum;
    }

    public double getPrice(List<Double> ingrPrice){
        return this.price=sum(ingrPrice)*1.2;
    }

    

    public List<Comment> getComment(List<Comment> comment){
        return comment;
    }

}