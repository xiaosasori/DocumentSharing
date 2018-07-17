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
public class RequestFriendDAO {

    public static String requestFriend(RequestFriend requestFriend) {
        Datastore ds = MongoContext.getDatastore();
        return String.valueOf(ds.save(requestFriend));
    }

    public static void cancelRequestFriend(ObjectId fromUserID, ObjectId toUserID) {
        Datastore ds = MongoContext.getDatastore();
        final Query<RequestFriend> row = ds.createQuery(RequestFriend.class)
                .filter("fromUserID", fromUserID)
                .filter("toUserID", toUserID);
        ds.delete(row);
    }

    public static boolean checkRequestSent(ObjectId fromUserID, ObjectId toUserID) {
        Datastore ds = MongoContext.getDatastore();
        RequestFriend requestFriend = ds.find(RequestFriend.class).filter("fromUserID", fromUserID).filter("toUserID", toUserID).get();
        

        if (requestFriend != null) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        /*String id = requestFriend(new RequestFriend("123456", "789456"));
        System.out.println(id);*/
        ArrayList<User> arr = showAllUser();
        User user = arr.get(0);
        //requestFriend(new RequestFriend(arr.get(0).getId(), arr.get(1).getId()));
        cancelRequestFriend(arr.get(0).getId(), arr.get(1).getId());

        System.out.println(checkRequestSent(arr.get(1).getId(), arr.get(2).getId()));
    }
}
