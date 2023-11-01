package J1SP0078.ReadWriteFile;

import J1SP0078.Model.Config;
import J1SP0078.validate.Input;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Properties;

public class CopyData {
    private static CopyData instance = null;
    Input input = new Input();
    public static CopyData Instance() {
        if (instance == null) {
            synchronized (CopyData.class) {
                if (instance == null) {
                    instance = new CopyData();
                }
            }
        }
        return instance;
    }
    public void dataCopy(Config config) {
        readFileConfig(config);
        copyFile(config);
    }


    public boolean checkFileConfig(String copyFolder, String Path) {
        File f = new File(copyFolder);
        if (!f.isDirectory()) {
            System.out.println("Folder not exist");
            return false;
        }
        f = new File(Path);
        if (!f.isDirectory()) {
            if (f.mkdir()) {
                return true;
            } else {
                System.out.println("Fail to create path");
                return false;
            }
        }
        return true;
    }

    public void createFileConfig(Config config) {
        config.setCopyFolder(input.enterString("Copy Folder"));
        config.setDataType(input.enterString("Data Type"));
        config.setPath(input.enterString("Path"));
        if (!checkFileConfig(config.getCopyFolder(), config.getPath())) {
            System.out.println("System Shutdown...");
            System.exit(0);
        }
        Properties prop = new Properties();
        prop.setProperty("COPY_FOLDER", config.getCopyFolder());
        prop.setProperty("DATA_TYPE", config.getDataType());
        prop.setProperty("PATH", config.getPath());
        try {
            OutputStream output = new FileOutputStream("F:\\JAVA2023\\lab211\\src\\J1SP0078\\Property\\config.properties");
            prop.store(output, null);
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFileConfig(Config config) {
        try (InputStream input = new FileInputStream(("F:\\JAVA2023\\lab211\\src\\J1SP0078\\Property\\config.properties"))) {
            Properties prop = new Properties();
            prop.load(input);
            config.setCopyFolder(prop.getProperty("COPY_FOLDER"));
            config.setDataType(prop.getProperty("DATA_TYPE"));
            config.setPath(prop.getProperty("PATH"));
            input.close();
        } catch (IOException e) {
            createFileConfig(config);
        }
    }
    public boolean isBlank(String str) {
        if (str == null || str.trim().isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean checkPath(String[] match, String name) {
        for (String str : match) {
            if(isBlank(str)) {
                continue;
            }
            if (name.endsWith(str)) {
                return true;
            }
        }
        return false;
    }

    public void copyFile(Config config) {
        try{
            File test = new File(config.getCopyFolder());
        }
        catch(NullPointerException e){
            createFileConfig(config);
        }
        File f = new File(config.getCopyFolder());
        File[] files = f.listFiles();
        String[] str = config.getDataType().split("[^(\\.a-zA-Z)]|[\\..+\\..+]");
        for (File file : files) {
            if (file.isFile() && checkPath(str, file.getName())) {
                try {
                    File destination = new File(config.getPath(), file.getName());
                    Files.copy(file.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
