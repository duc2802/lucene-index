/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lucene.main;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import lucene.properties.Config;
import org.json.simple.JSONObject;

/**
 *
 * @author duchm
 */
public class ImportDataMongoDB {    
    public static void main(String[] agrs){
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/cspublicationcrawler", "root", "root");
            String sql = Config.getParameter("db.query");
            PreparedStatement stat = connection.prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            stat.setFetchSize(Integer.MIN_VALUE);
            ResultSet rs = stat.executeQuery();
            
            MongoClient mongo = new MongoClient("localhost", 27017);            
            DB db = mongo.getDB("CSPublication");            
            DBCollection paperCollection = db.getCollection("PaperCollection");            
            
            while (rs.next()) { 
                BasicDBObject doc = new BasicDBObject();  
                String idPaper = rs.getString(Config.getParameter("field.idPaper"));
                doc.put(Config.getParameter("field.idPaper"), idPaper);
                doc.put(Config.getParameter("field.title"), rs.getString(Config.getParameter("field.title")));
                doc.put(Config.getParameter("field.abstract"), rs.getString(Config.getParameter("field.abstract")));
                doc.put(Config.getParameter("field.authorName"), rs.getString(Config.getParameter("field.authorName")));
                doc.put(Config.getParameter("field.year"), rs.getString(Config.getParameter("field.year")));
                doc.put(Config.getParameter("field.conferenceName"), rs.getString(Config.getParameter("field.conferenceName")));
                doc.put(Config.getParameter("field.authorsName"), getListAuthor(Integer.parseInt(idPaper))); 
                
                paperCollection.insert(doc);               
            }
        }
        catch(Exception e){
            System.out.println("Exception : " + e.getMessage());
        }
    }
    
    public static String getListAuthor(int idPaper) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/cspublicationcrawler", "root", "root");
        String sql = Config.getParameter("db.query.list.author");
        PreparedStatement stat = connection.prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
        stat.setInt(1, idPaper);
        stat.setFetchSize(Integer.MIN_VALUE);
        ResultSet rs = stat.executeQuery();
        Map json = new HashMap();
        ArrayList<Object> list = new ArrayList<Object>();
        while (rs.next()) {
            //db.authorTable.idAuthor
            LinkedHashMap<String, Object> author = new LinkedHashMap<String, Object>();
            author.put("id", rs.getInt(Config.getParameter("db.authorTable.idAuthor")));
            author.put("name", rs.getString(Config.getParameter("db.authorTable.authorName")));
            list.add(author);
        }
        json.put("authors", list);
        JSONObject outJSON = new JSONObject(json);
        connection.close();
        return outJSON.toJSONString();
    }
}
