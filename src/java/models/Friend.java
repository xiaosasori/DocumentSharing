/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

/**
 *
 * @author Hoang Hiep
 */
@Entity("friend")
public class Friend {
    @Id
    private String friendID;
    @Reference(idOnly = true,lazy = true)
    private User fromUserID;
    @Reference(idOnly = true,lazy = true)
    private User toUserID;
    private Date acceptedAt;

    public Friend() {
    }

    public Friend(User fromUserID, User toUserID, Date acceptedAt) {
        this.fromUserID = fromUserID;
        this.toUserID = toUserID;
        this.acceptedAt = acceptedAt;
    }
    
     public Friend(User fromUserID, User toUserID) {
        this.fromUserID = fromUserID;
        this.toUserID = toUserID;
        this.acceptedAt = acceptedAt;
    }

    
    public String getFriendID() {
        return friendID;
    }

    public void setFriendID(String friendID) {
        this.friendID = friendID;
    }

    public User getFromUserID() {
        return fromUserID;
    }

    public void setFromUserID(User fromUserID) {
        this.fromUserID = fromUserID;
    }

    public User getToUserID() {
        return toUserID;
    }

    public void setToUserID(User toUserID) {
        this.toUserID = toUserID;
    }


    public Date getAcceptedAt() {
        return acceptedAt;
    }

    public void setAcceptedAt(Date acceptedAt) {
        this.acceptedAt = acceptedAt;
    }
    
}
