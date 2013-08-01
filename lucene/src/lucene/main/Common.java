/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lucene.main;

import java.io.File;
import org.apache.lucene.store.FSDirectory;

/**
 *
 * @author duchuynh
 */
public class Common {
    public static FSDirectory getFSDirectory(String path){
        FSDirectory directory = null;
        try{
            if(path != null){
                File location = new File(path);
                directory = FSDirectory.open(location);
            }
            return directory;
        }catch(Exception e){
            //write log
            System.out.println(e.getMessage());
            return null;
        }
    }
}
