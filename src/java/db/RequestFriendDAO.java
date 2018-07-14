/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.util.Date;
import models.RequestFriend;
import models.User;
import org.mongodb.morphia.Datastore;

/**
 *
 * @author Hoang Hiep
 */
public class RequestFriendDAO {
    public static String requestFriend(RequestFriend requestFriend) {
        Datastore ds = MongoContext.getDatastore();
        return String.valueOf(ds.save(requestFriend));
    }
    public static boolean checkRequestSent(String fromUsername, String toUsername){
        Datastore ds = MongoContext.getDatastore();
        RequestFriend requestFriend = ds.find(RequestFriend.class).filter("fromUsername", fromUsername).filter("toUsername", toUsername).get();
        if(requestFriend!=null)return true;
        return false;
    }
    public static void main(String[] args) {
        /*String id = requestFriend(new RequestFriend("123456", "789456"));
        System.out.println(id);*/
        System.out.println(checkRequestSent("123456", "789456"));
    }
}
