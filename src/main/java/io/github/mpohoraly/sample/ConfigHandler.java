/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.mpohoraly.sample;

import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author MiroslavPohoraly
 */
public class ConfigHandler {
    
    Properties prop;
    
    public ConfigHandler() {
        try {
            prop = new Properties();
            prop.load(ConfigHandler.class.getClassLoader().getResourceAsStream("application.properties"));
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    public Properties getProp() {
        return prop;
    }

    public void setProp(Properties prop) {
        this.prop = prop;
    }

}
