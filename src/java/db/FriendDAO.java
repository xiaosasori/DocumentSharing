/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import static db.UserDAO.showAllUser;
import java.util.ArrayList;
import java.util.Date;
import models.Friend;
import models.RequestFriend;
import models.User;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;

/**
 *
 * @author Hoang Hiep
 */
public class FriendDAO {
    public static String acceptFriend(Friend friend) {
        Datastore ds = MongoContext.getDatastore();
        friend.setAcceptedAt(new Date());
        return String.valueOf(ds.save(friend));
    }
    
    public static void cancelFriend(String fromUserID, String toUserID) {
        Datastore ds = MongoContext.getDatastore();
        final Query<Friend> row = ds.createQuery(Friend.class)
                                                .filter("fromUserID", fromUserID)
                                                .filter("toUserID", toUserID);
        ds.delete(row);
    }
//     ObjectId("5b4b0c7b00364e0854a03155")
//    ObjectId("5b4b0c8b00364e0854a03157")
    public static boolean checkIsFriend(ObjectId fromUserID, ObjectId toUserID){
        Datastore ds = MongoContext.getDatastore();
        
        Friend friend = ds.find(Friend.class)
                .filter("fromUserID", fromUserID).filter("toUserID", toUserID).get();
//        .filter("_id","5b4b02e5d048571a1419ceb5").get();
        if(friend!=null)return true;
        return false;
    }
    public static void main(String[] args) {
        ArrayList<User> arr = showAllUser();
        
        acceptFriend(new Friend(arr.get(0),arr.get(1)));
        System.out.println(checkIsFriend(arr.get(0).getId(),arr.get(1).getId()));
        
        /*String id = requestFriend(new RequestFriend("123456", "789456"));
        System.out.println(id);*/
        /*ArrayList<User> arr = showAllUser();
        User user = arr.get(0);
        //requestFriend(new RequestFriend(arr.get(0).getId(), arr.get(1).getId()));
        cancelRequestFriend(arr.get(0).getId(), arr.get(1).getId());
         
        System.out.println(checkRequestSent(arr.get(6).getId(), arr.get(5).getId()));*/
    }
}
