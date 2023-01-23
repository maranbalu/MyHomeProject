import org.home.CustomAnnotationTransformer;
import org.home.SeleniumTest;
import org.testng.TestNG;
import org.testng.annotations.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!!");
        TestNG testNG = new TestNG();

        // Adding Listeners:
        CustomAnnotationTransformer annotationTransformer = new CustomAnnotationTransformer();
        testNG.addListener(annotationTransformer);

        // Setting the Test Class for TestNG:
        Class[] testClasses = new Class[]{SeleniumTest.class};
        testNG.setTestClasses(testClasses);

        // Getting all methods annotated with @Test from the
        Class<SeleniumTest> exampleClass = SeleniumTest.class;
        Method[] methods = exampleClass.getMethods();

        for (Method method : methods) {
            Test testAnnotation = method.getAnnotation(Test.class);
            if (testAnnotation != null) {
                System.out.println("Method Name : " + method.getName());
                System.out.println("Description : " + testAnnotation.description());
                System.out.println("Enabled : " + testAnnotation.enabled());
                Annotation[] annotations = method.getAnnotations();
                for (Annotation annotation : annotations) {
                    System.out.println("Annotation displayed are: " + annotation.annotationType());
                }
            }
        }

        testNG.run();

    }
}
