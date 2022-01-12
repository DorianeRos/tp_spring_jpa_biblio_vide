package myapp;

import myapp.imp.BeanFileLogger;
import myapp.imp.FileLogger;
import myapp.imp.SimpleCalculator;
import myapp.imp.StderrLogger;
import myapp.services.ICalculator;
import myapp.services.ILogger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestLoggerServices {
    @Before
    public void beforeEachTest() {
        System.err.println("====================");
    }
    @After
    public void afterEachTest() {
    }

    // use a logger
    void use(ILogger logger) {
        logger.log("Voila le résultat = hello");
    }

    // use a calculator
    void use(ICalculator calc){
        calc.add(100, 200);
    }
    // Test StderrLogger
    @Test
    public void testStderrLogger() {
        // create the service
        StderrLogger logger = new StderrLogger();
        // start the service
        logger.start();
        // use the service
        use(logger);
        // stop the service
        logger.stop();
    }

    @Test
    public void testFileLogger() {
        FileLogger logger = new FileLogger("tmp/myapp.log");
        logger.start();
        use(logger);
        logger.stop();
    }

    @Test
    public void testBeanFileLogger() {
        // create the service
        BeanFileLogger logger = new BeanFileLogger();

        // set parameter
        logger.setFileName("tmp/myapp.log");  //useless with default parameter for filename in BeanFileLogger

        // start
        logger.start();
        // use
        use(logger);
        // stop
        logger.stop();
    }

    @Test
    public void testCalculorAndStderrLogger() {
        // create and start the logger service (on stderr)
        //StderrLogger logger = new StderrLogger();

        // create file logger
        BeanFileLogger logger = new BeanFileLogger();
        logger.setFileName("tmp/myapp.log");
        logger.start();
        // create, inject and start the calculator service
        SimpleCalculator calculator = new SimpleCalculator();
        calculator.setLogger(logger);
        calculator.start();
        // use the calculator service
        use(calculator);
        // stop the calculator service
        calculator.stop();
        // stop the logger service
        logger.stop();
    }
}
