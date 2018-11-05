package tesena.automation.training.factory;

import tesena.automation.training.data.User;
import tesena.automation.training.data.Users;
import tesena.automation.training.driver.PropertiesManager;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.StandardCharsets;
import java.text.Normalizer;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class DataFactory {
    private static File dataFolder = new File("src\\test\\resources");
    public static User createUser(Users users) {
        return createObjectFromXML(User.class, users.getFileName());
    }

    @SuppressWarnings("unchecked")
    private static <T> T createObjectFromXML(Class<T> klass, String fileName){
        System.setProperty("javax.xml.accessExternalDTD", "all");
        File XMLFile = findFile(dataFolder, fileName);
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(klass);
            return (T) jaxbContext.createUnmarshaller().unmarshal(XMLFile);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    private static File findFile(File folder, String fileName) {
        File foundFile = null;
        if(folder.isDirectory()){
            for(String file: folder.list()){
                File temp = findFile(new File(folder, file), fileName);
                if ((temp != null) && (temp.isFile())) {
                    foundFile = temp;
                }
            }
        } else if (!folder.isHidden()){
            for (File file: folder.getParentFile().listFiles()){
                if(file.getName().equals(fileName)){
                    return file;
                }
            }
        }
        return foundFile;
    }

    public static String getBundleProperty(String key) {
        return Normalizer.normalize(processBundle(key), Normalizer.Form.NFC);
    }

    private static String processBundle(String value) {
        try {
            URL[] urls = new URL[]{dataFolder.toURI().toURL()};
            ClassLoader loader = new URLClassLoader(urls);
            return new String(ResourceBundle.getBundle("language", new Locale("cs", "CZ"), loader).getString(value).getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (MissingResourceException exception) {
            return value;
        }
        return value;
    }
}
