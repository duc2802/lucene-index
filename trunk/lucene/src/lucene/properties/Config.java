/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lucene.properties;

/**
 *
 * @author duchuynh
 */
import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;

public class Config {
    public static Properties properties;
    static {
         try {
            URL url = Config.class.getResource("config.properties");
            FileInputStream in = new FileInputStream(url.getPath());
            properties = new Properties();
            properties.load(in);
        } catch (Exception ex) {
            
        }
    }
    public static String getParameter(String key){
        return properties.getProperty(key);
    }
}