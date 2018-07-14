/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import com.mongodb.DBObject;
import java.util.Date;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

/**
 *
 * @author Hoang Hiep
 */
@Entity("requestFriend")
public class RequestFriend {
    @Id
    private String requestFriendID;
    @Property("fromUsername")
    private String fromUsername;
    private String toUsername;
    
    public RequestFriend(DBObject next) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public RequestFriend(String fromUserID, String toUserID) {
        this.requestFriendID = requestFriendID;
        this.fromUsername = fromUserID;
        this.toUsername = toUserID;
    }
    
    public RequestFriend(String requestFriendID, String fromUserID, String toUserID) {
        this.requestFriendID = requestFriendID;
        this.fromUsername = fromUserID;
        this.toUsername = toUserID;
    }

    public String getRequestFriendID() {
        return requestFriendID;
    }

    public void setRequestFriendID(String requestFriendID) {
        this.requestFriendID = requestFriendID;
    }

    public String getFromUserID() {
        return fromUsername;
    }

    public void setFromUserID(String fromUserID) {
        this.fromUsername = fromUserID;
    }

    public String getToUserID() {
        return toUsername;
    }

    public void setToUserID(String toUserID) {
        this.toUsername = toUserID;
    }
    
}
