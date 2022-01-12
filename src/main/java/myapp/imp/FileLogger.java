package myapp.imp;

import myapp.services.ILogger;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Date;

public class FileLogger implements ILogger {
    private final PrintWriter writer;

    public FileLogger(String fileName) {
        try {
            writer = new PrintWriter(new FileOutputStream(fileName, true));
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("bad fileName");
        }
    }

    public void start() {
        System.err.println("Start " + this);
    }
    public void stop() {
        writer.close();
        System.err.println("Stop " + this);
    }
    @Override
    public void log(String message) {
        writer.printf("%tF %1$tR | %s\n", new Date(), message);
    }
}
