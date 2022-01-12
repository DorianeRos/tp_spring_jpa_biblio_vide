package myapp;

import myapp.services.ICalculator;
import myapp.services.ILogger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class TestSpring {
    @Before
    public void beforeEachTest() {
        System.err.println("====================");
    }

    void use(ILogger logger) {
        logger.log("Voila le résultat");
    }

    void use(ICalculator calc) {
        calc.add(100, 200);
    }

    @Test
    public void testStderrLogger() {
        System.err.println("+++ StderrLogger");
        String conf = "config.xml";
        // create a context and find beans
        try (AbstractApplicationContext ctx = new ClassPathXmlApplicationContext(conf);) {
            ILogger logger = ctx.getBean("stderrLogger", ILogger.class);
            use(logger);
        }
    }

    @Test
    public void testCalculatorWithLogger() {
        System.err.println("+++ CalculatorWithLogger");
        String conf = "config.xml";
        // create a context and find beans
        try (AbstractApplicationContext ctx = new ClassPathXmlApplicationContext(conf);) {
            ICalculator calc= ctx.getBean("calculator", ICalculator.class);
            use(calc);
        }
    }
}
