package myapp.imp;

import myapp.services.ILogger;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Date;

@Service("stderrLogger")
@Primary
public class StderrLogger implements ILogger {

    @PostConstruct
    public void start() {
        System.err.println("Start " + this);
    }

    @PreDestroy
    public void stop() {
        System.err.println("Stop " + this);
    }

    public StderrLogger() {
    }

    @Override
    public void log(String message) {
        System.err.printf("%tF %1$tR | %s\n", new Date(), message);
    }
}
