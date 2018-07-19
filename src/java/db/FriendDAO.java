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

   

    public static void cancelFriend(ObjectId fromUserID, ObjectId toUserID) {
        Datastore ds = MongoContext.getDatastore();
        final Query<Friend> row = ds.createQuery(Friend.class)
                .filter("fromUserID", fromUserID)
                .filter("toUserID", toUserID);
        ds.delete(row);
    }

    public static boolean checkIsFriend(ObjectId fromUserID, ObjectId toUserID) {
        Datastore ds = MongoContext.getDatastore();
        Friend friend = ds.find(Friend.class)
                .filter("fromUserID", fromUserID).filter("toUserID", toUserID).get();

        if (friend != null) {
            return true;
        }
        return false;
    }
    
     public static int numFriend(String fromUserID) {
        ArrayList<User> users = UserDAO.showAllUser();
        int count = 0;
        for (User user : users) {
            ObjectId toUserID = user.getId();
            if (FriendDAO.checkIsFriend(new ObjectId(fromUserID), toUserID) || FriendDAO.checkIsFriend(toUserID,new ObjectId(fromUserID))) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        ArrayList<User> arr = showAllUser();

        String s = acceptFriend(new Friend(arr.get(0).getId(), arr.get(1).getId()));
        //System.out.println(checkIsFriend(arr.get(0).getId(),arr.get(2).getId()));

        /*String id = requestFriend(new RequestFriend("123456", "789456"));
        System.out.println(id);*/
 /*ArrayList<User> arr = showAllUser();
        User user = arr.get(0);
        //requestFriend(new RequestFriend(arr.get(0).getId(), arr.get(1).getId()));
        cancelRequestFriend(arr.get(0).getId(), arr.get(1).getId());
         
        System.out.println(checkRequestSent(arr.get(6).getId(), arr.get(5).getId()));*/
    }
}
