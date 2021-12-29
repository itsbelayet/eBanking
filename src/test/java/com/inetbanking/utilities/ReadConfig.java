package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

    Properties pro;
    public ReadConfig() {
        File fpath = new File("./Configaration/config.properties");

        try {
            FileInputStream fis = new FileInputStream(fpath);
            pro = new Properties();
            pro.load(fis);
        } catch (Exception e) {
            System.out.println("Exception is " + e.getMessage());
        }
    }

    public String getURL() {
        String url = pro.getProperty("baseURL");
        return url;
    }

    public String getUsername() {
        String username = pro.getProperty("username");
        return username;
    }

    public String getPassword() {
        String password = pro.getProperty("password");
        return password;
    }

    public String getChromePath() {
        String chromepath = pro.getProperty("chromepath");
        return chromepath;
    }

    public String getFirefoxPath() {
        String firefoxpath = pro.getProperty("firefoxpath");
        return firefoxpath;
    }

}
