package com.techelevator.data;

import java.io.File;
import java.io.IOException;

public class Logger {

    private String fileName = "log.txt";
    private boolean deleteFile = new File(fileName).delete();
    private File logFile = new File(fileName);

    public Logger() {
        createNewFile();
    }

    private void createNewFile() {
        try {
            logFile.createNewFile();
        } catch (IOException e) {
        }
    }
}
