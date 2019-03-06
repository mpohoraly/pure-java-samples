/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.mpohoraly.sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author MiroslavPohoraly
 * $ java -cp target/config-test-1.0-SNAPSHOT.jar io.github.mpohoraly.sample.FileHash "/home/mpohoraly/workspace/tmp/smallFile.gz"
 */
public class FileHash {

    /**
     * @param args the command line arguments
     * @throws java.security.NoSuchAlgorithmException
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {

        if (args[0] == null) {
            throw new IllegalArgumentException("Argument File with index 0 not set");
        }
        File file = new File(args[0]);
        
        System.out.println("... FileHash Running for file " + args[0] + " with size " + (file.length()/1000) + "Kb ...");
        long start = System.currentTimeMillis();

        //MessageDigest digest = MessageDigest.getInstance("SHA-1");
        MessageDigest digest = MessageDigest.getInstance("SHA-1");

        //Get file input stream for reading the file content
        FileInputStream fis = new FileInputStream(file);

        //Create byte array to read data in chunks
        byte[] byteArray = new byte[1024];
        int bytesCount = 0;

        //Read file data and update in message digest
        while ((bytesCount = fis.read(byteArray)) != -1) {
            digest.update(byteArray, 0, bytesCount);
        };

        //close the stream; We don't need it now.
        fis.close();

        //Get the hash's bytes
        byte[] bytes = digest.digest();

        //This bytes[] has bytes in decimal format;
        //Convert it to hexadecimal format
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }

        //return complete hash
        System.out.println("FileHash Completed with hash: " + sb.toString());
        System.out.println("Completed in " + (System.currentTimeMillis() - start) + "ms (" + (System.currentTimeMillis() - start)/1000 + "s)");
    }

}
