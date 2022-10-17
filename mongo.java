import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;

public class mongo {

    public static MongoClientURI uri = null;
    public static MongoClient client = null;
    public static MongoDatabase database = null;
    public static MongoCollection<Document> collection = null;

    public static void closeConnection(){
        if(client != null) client.close();

        uri = null;
        database = null;
        collection = null;
        client = null;
    }

    public static void connectInstituteManagement(){
        uri = new MongoClientURI("mongodb+srv://mmsDatabaseAdmin:mmsDatabaseAdmin%40123@mmsdatabase.wkimz.mongodb.net/commonDatabase?retryWrites=true&w=majority&connectTimeoutMS=30000&socketTimeoutMS=30000");
        client = new MongoClient(uri);
        database = client.getDatabase("commonDatabase");
        collection = database.getCollection("instituteManagement");
    }

    public static void connectMessManagement(){
        uri = new MongoClientURI("mongodb+srv://mmsDatabaseAdmin:mmsDatabaseAdmin%40123@mmsdatabase.wkimz.mongodb.net/commonDatabase?retryWrites=true&w=majority&connectTimeoutMS=30000&socketTimeoutMS=30000");
        client = new MongoClient(uri);
        database = client.getDatabase("commonDatabase");
        collection = database.getCollection("messManagement");
    }

    public static void connectMessMenu(){
        uri = new MongoClientURI("mongodb+srv://mmsDatabaseAdmin:mmsDatabaseAdmin%40123@mmsdatabase.wkimz.mongodb.net/commonDatabase?retryWrites=true&w=majority&connectTimeoutMS=30000&socketTimeoutMS=30000");
        client = new MongoClient(uri);
        database = client.getDatabase("commonDatabase");
        collection = database.getCollection("messMenu");
    }

    public static void connectMessRates(){
        uri = new MongoClientURI("mongodb+srv://mmsDatabaseAdmin:mmsDatabaseAdmin%40123@mmsdatabase.wkimz.mongodb.net/commonDatabase?retryWrites=true&w=majority&connectTimeoutMS=30000&socketTimeoutMS=30000");
        client = new MongoClient(uri);
        database = client.getDatabase("commonDatabase");
        collection = database.getCollection("messRates");
    }

    public static void connectStudents(){
        uri = new MongoClientURI("mongodb+srv://mmsDatabaseAdmin:mmsDatabaseAdmin%40123@mmsdatabase.wkimz.mongodb.net/commonDatabase?retryWrites=true&w=majority&connectTimeoutMS=30000&socketTimeoutMS=30000");
        client = new MongoClient(uri);
        database = client.getDatabase("mmsDatabase");
        collection = database.getCollection("students");
    }
    
}