package tesena.automation.training.factory;

import tesena.automation.training.data.User;
import tesena.automation.training.data.Users;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.File;

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
}
