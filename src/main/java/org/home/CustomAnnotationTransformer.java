package org.home;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class CustomAnnotationTransformer implements IAnnotationTransformer {

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        if (testMethod.getName().equals("firstTest")) {
            annotation.setEnabled(true);
            annotation.setPriority(0);
            annotation.setDescription("This is my first Test");
        } else {
            annotation.setEnabled(false);
            annotation.setPriority(1);
            annotation.setDescription("This is my second Test");
        }
    }

}
