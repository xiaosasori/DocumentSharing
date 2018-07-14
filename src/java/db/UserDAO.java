package db;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import java.util.ArrayList;
import java.util.Date;
import models.User;
import org.mongodb.morphia.Datastore;

/**
 *
 * @author Admin
 */
public class UserDAO {

    public static String insertUser(User user) {
        Datastore ds = MongoContext.getDatastore();
        user.setCreatedAt(new Date());
        return String.valueOf(ds.save(user));
    }

    public static User login(String email, String password) {
        Datastore ds = MongoContext.getDatastore();
        User user = ds.find(User.class).filter("email", email).filter("password", password).get();

        return user;
    }
    
    public static User UserInfo(String username) {
        Datastore ds = MongoContext.getDatastore();
        User user = ds.find(User.class).filter("user_name", username).get();

        return user;
    }

    public static ArrayList<User> showAllUser() {
        ArrayList arr = new ArrayList<User>();

        Datastore ds = MongoContext.getDatastore();
        //DBCollection colection = ds.getCollection(User.class);
        //DBCursor cursor = colection.find();
        arr = (ArrayList<User>)ds.find(User.class).asList();

        return arr;
    }

    public static void main(String[] args) {
        ArrayList<User> arr = showAllUser();
        User user = arr.get(0);
        System.out.println(user.getEmail());
    }
}
