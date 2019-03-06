/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.mpohoraly.sample;

/**
 *
 * @author MiroslavPohoraly
 * $ java -cp "/jar-folder/config-test-1.0-SNAPSHOT.jar:/properties-folder/" ConfigRun
 */
public class ConfigRun {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ConfigHandler ch = new ConfigHandler();
        System.out.println("... App Running ...");
        System.out.println("Config property value: " + ch.getProp().getProperty("echo"));
    }
    
}
