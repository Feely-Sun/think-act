package com.iacthink.proxy;

import java.net.URL;
import java.util.Enumeration;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author sunzihan
 * @version $Id: Test2.java V 0.1 10/21/16 19:48 sunzihan EXP $
 */
public class Test2<T> extends Test3<T> {


    private String name;

    private String address;

    


    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
       ClassLoader cl = Thread.currentThread().getContextClassLoader();

      final  AtomicReference at = new AtomicReference();


        try {
            new Thread(new Runnable() {
                public void run() {
                    ClassLoader cls = Thread.currentThread().getContextClassLoader();
                    at.set(cls);
                    try {
                       Enumeration<URL> urls = cls.getResources("META-INF/NOTICE.txt");
                        while(urls.hasMoreElements()){
                            System.out.println(urls.nextElement());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();

            Class<?> clazz =  cl.loadClass(CarImpl.class.getName());

            Class<?> clazz2 =  cl.loadClass(CarImpl.class.getName());

            System.out.println(clazz == at.get());

            Car car = (Car) clazz.newInstance();

            Car car2 = (Car) clazz2.newInstance();

            System.out.println(car == car2);



            car.run("210");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }



}

