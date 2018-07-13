package db;

import java.util.Date;
import models.User;
import org.mongodb.morphia.Datastore;
/**
 *
 * @author Admin
 */
public class UserDAO {
    public static String insertUser(User user){
        Datastore ds = MongoContext.getDatastore();
        user.setCreatedAt(new Date());
        return String.valueOf(ds.save(user));
    }
    
    public static User login(String email, String password){
        Datastore ds = MongoContext.getDatastore();
        User user = ds.find(User.class).filter("email", email).filter("password", password).get();
        return user;
    }
    
}
