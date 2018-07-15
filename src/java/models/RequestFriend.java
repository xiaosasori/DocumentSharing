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
    private String fromUserID;
    private String toUserID;

    public RequestFriend() {
    }
    
    public RequestFriend(DBObject next) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public RequestFriend(String fromUserID, String toUserID) {
        this.requestFriendID = requestFriendID;
        this.fromUserID = fromUserID;
        this.toUserID = toUserID;
    }
    
    public RequestFriend(String requestFriendID, String fromUserID, String toUserID) {
        this.requestFriendID = requestFriendID;
        this.fromUserID = fromUserID;
        this.toUserID = toUserID;
    }

    public String getRequestFriendID() {
        return requestFriendID;
    }

    public void setRequestFriendID(String requestFriendID) {
        this.requestFriendID = requestFriendID;
    }

    public String getFromUserID() {
        return fromUserID;
    }

    public void setFromUserID(String fromUserID) {
        this.fromUserID = fromUserID;
    }

    public String getToUserID() {
        return toUserID;
    }

    public void setToUserID(String toUserID) {
        this.toUserID = toUserID;
    }
    
}
