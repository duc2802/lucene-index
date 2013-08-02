package lucene.main;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;
import java.io.File;
import lucene.properties.Config;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.NumericField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author duchuynh
 */
public class MongoDBIndexer {    
    public static void main(String[] agrs){        
        try {         
            
            //create Lucene
            StandardAnalyzer analyzer = new StandardAnalyzer(Version.LUCENE_34);
            IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_34, analyzer);
            Directory directory = FSDirectory.open(new File(Config.getParameter("index")));
            IndexWriter writer = new IndexWriter(directory, config);
            
            MongoClient mongo = new MongoClient("localhost", 27017);            
            DB db = mongo.getDB("CSPublication");            
            DBCollection paperCollection = db.getCollection("PaperCollection");
            
            DBCursor cursorDoc = paperCollection.find();
            while (cursorDoc.hasNext()) {
                DBObject object = (DBObject)JSON.parse(cursorDoc.next().toString());
                Document d = new Document();               
                
                d.add(new Field(Config.getParameter("field.idPaper"), object.get(Config.getParameter("field.idPaper")).toString(), Field.Store.YES, Field.Index.NO));
                if(object.get(Config.getParameter("field.title")) != null){
                    d.add(new Field(Config.getParameter("field.title"), object.get(Config.getParameter("field.title")).toString(), Field.Store.YES, Field.Index.ANALYZED));
                }
                else
                {
                    d.add(new Field(Config.getParameter("field.title"), "", Field.Store.YES, Field.Index.ANALYZED));
                }
                
                if(object.get(Config.getParameter("field.abstract")) != null){
                    d.add(new Field(Config.getParameter("field.abstract"), object.get(Config.getParameter("field.abstract")).toString(), Field.Store.YES, Field.Index.ANALYZED));
                }
                else
                {
                    d.add(new Field(Config.getParameter("field.abstract"), "", Field.Store.YES, Field.Index.ANALYZED));
                }
                
                if(object.get(Config.getParameter("field.authorName")) != null){
                    d.add(new Field(Config.getParameter("field.authorName"), object.get(Config.getParameter("field.authorName")).toString(), Field.Store.YES, Field.Index.ANALYZED));
                }
                else
                {
                    d.add(new Field(Config.getParameter("field.authorName"), "", Field.Store.YES, Field.Index.ANALYZED));                
                }
                
                if(object.get(Config.getParameter("field.authorsName")) != null){
                    d.add(new Field(Config.getParameter("field.authorsName"), object.get(Config.getParameter("field.authorsName")).toString(), Field.Store.YES, Field.Index.NO));
                }
                else
                {
                    d.add(new Field(Config.getParameter("field.authorsName"), "", Field.Store.YES, Field.Index.NO));
                }                
                NumericField year = new NumericField(Config.getParameter("field.year"), Field.Store.YES, true);
                if(object.get(Config.getParameter("field.year")) != null){
                    year.setIntValue(Integer.parseInt(object.get(Config.getParameter("field.year")).toString()));
                }else{
                    year.setIntValue(0);
                }
                d.add(year);
                
                if(object.get(Config.getParameter("field.conferenceName")) != null){
                    d.add(new Field(Config.getParameter("field.conferenceName"), object.get(Config.getParameter("field.authorsName")).toString(), Field.Store.YES, Field.Index.NO));
                }
                else
                {
                    d.add(new Field(Config.getParameter("field.conferenceName"), "", Field.Store.YES, Field.Index.NO));
                }   
                writer.addDocument(d);
                year = null;
                d = null;   
            } 
            writer.optimize();
            writer.close();
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
        }        
    }
}
