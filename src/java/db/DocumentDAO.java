/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import static db.UserDAO.showAllUser;
import java.util.ArrayList;
import java.util.Date;
import models.AuthorDocument;
import models.Document;
import models.LikeDocument;
import models.RequestFriend;
import models.User;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;

/**
 *
 * @author Hoang Hiep
 */
public class DocumentDAO {
     public static ObjectId createDocument(Document document) {
        Datastore ds = MongoContext.getDatastore();
        document.setPublishAt(new Date());
        return (ObjectId) ds.save(document).getId();
    }
     
     public static void changeDocument(ObjectId documentID, String title, String content, String filePath){
        Datastore ds = MongoContext.getDatastore();
        Query query = ds.createQuery(Document.class)
                .field("_id").equal(documentID);
        ds.update(query, ds.createUpdateOperations(Document.class).set("title", title)
                .set("content", content)
                .set("filePath", filePath));
    }

    
    public static void deleteDocument(ObjectId documentID) {
        Datastore ds = MongoContext.getDatastore();
        final Query<Document> row = ds.createQuery(Document.class)
                                                .filter("_id", documentID);
        ds.delete(row);
    }
     
     
     
    public static ArrayList<Document> findAllDocument(){
        ArrayList arr = new ArrayList<Document>();
        Datastore ds = MongoContext.getDatastore();
        arr = (ArrayList<Document>)ds.find(Document.class).order("-publishAt").asList();
        return arr;
    }
    
    public static ArrayList<Document> findDocumentByTitle(String titleContain){
        ArrayList<Document> arr = new ArrayList<Document>();
        Datastore ds = MongoContext.getDatastore();
        arr=(ArrayList) ds.createQuery(Document.class).field("title").contains(titleContain).order("-publishAt").asList();
        return arr;
    }
    
    public static Document getDocumentById(String id){
        ArrayList arr = new ArrayList<Document>();
        Datastore ds = MongoContext.getDatastore();
        Document document = ds.find(Document.class).filter("_id", new ObjectId(id)).get();
        
        return document;
    }
    
    
    
    public static void main(String[] args) {

        changeDocument(new ObjectId("5b506d94d0485758b8c597a9"), "a", "a", "a");
    }
}
