package aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class Plane {

    @Pointcut("execution(* aspects.Pilot.fly(..))")
    public void flying(){}

    @Before("flying()")
    public  void flyBefore(){
        System.out.println("before");
    }

    @Around("flying()")
    public void flyAdvice(ProceedingJoinPoint joinPoint) {
        try{
            String where = (String)joinPoint.getArgs()[0];
            System.out.println("Preparing to fly to " + where);
            joinPoint.proceed();
            System.out.println("Landing to + " + where);
        }catch (Throwable throwable){
            System.out.println("Plane crashed!");
        }
    }
}
