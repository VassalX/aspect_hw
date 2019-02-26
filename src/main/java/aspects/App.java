package aspects;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext ctx1 = new ClassPathXmlApplicationContext("SpringBeans.xml");
        Person person = (Person)ctx1.getBean("guest");
        person.enterHome();
        System.out.println();
        Pilot pilot = (Pilot)ctx1.getBean("pilot");
        pilot.fly("Nowhere");
    }
}
