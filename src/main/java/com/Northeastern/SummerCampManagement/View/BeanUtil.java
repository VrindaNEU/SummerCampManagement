/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Northeastern.SummerCampManagement.View;

/**
 *
 * @author vrind
 */
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;


@Component
public class BeanUtil {
    private static ApplicationContext context;

    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        context = applicationContext;
    }

    public static <T> T getBean(Class<T> beanClass) {
        return context.getBean(beanClass);
    }

    // If you need to get a bean by name
    public static Object getBean(String beanName) {
        
        return context.getBean(beanName);
    }

    // Example method to manually inject a bean into an object
    public static void autowireBean(Object target) {
        context.getAutowireCapableBeanFactory().autowireBean(target);
    }
}

