import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface Dao<T> {
    Optional<T> select(UUID uuid);
    void update(UUID uuid, String params);
    String delete(UUID uuid);
    public Optional<List<T>> selectAll();
    public void insert(T t);
}
