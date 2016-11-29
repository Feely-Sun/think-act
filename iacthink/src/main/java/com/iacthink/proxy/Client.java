package com.iacthink.proxy;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.net.URL;
import java.util.Enumeration;
import java.util.Map;

/**
 * @author sunzihan
 * @version $Id: Client.java V 0.1 10/20/16 13:28 sunzihan EXP $
 */
public class Client {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException,
                                           InvocationTargetException, InstantiationException {

        Car car = new CarImpl();
//        Class<?> clazz = Proxy.getProxyClass(car.getClass().getClassLoader(),
//                car.getClass().getInterfaces());
//        // 通过反射从生成的类对象获得构造函数对象
//
//        InvocationHandler handler = new InvokeHanderImpl(car);
//        Constructor constructor = clazz.getConstructor(new Class[] { InvocationHandler.class });
//
//        Car car1 = (Car) constructor.newInstance(new Object[] { handler });
//        car1.run("200");
//
//
//        Class<?> carClass = car.getClass();
//
//        ClassLoader classLoader =  car.getClass().getClassLoader();
//
//        Package p = carClass.getPackage();

//        System.out.println(classLoader.getResource("META-INF/spring/dal.xml"));
//
//        System.out.println(carClass.getName());
//        try {
//
//            Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources("META-INF/NOTICE.txt");
//            while (urls.hasMoreElements()) {
//                URL u = urls.nextElement();
//                InputStream in = u.openStream();
//                BufferedReader bf = new BufferedReader(new InputStreamReader(in));
//                System.out.println( bf.readLine() );
//
//                System.out.println(u);
//            }
//        } catch (Exception ex) {
//             ex.printStackTrace();
//        }


        for (Map.Entry<Object, Object> entry : System.getProperties().entrySet()) {
            System.out.println(entry.getKey()+"\t"+entry.getValue());
        }



//
//        ClassLoader loader = car.getClass().getClassLoader();
//        System.out.println(loader);
//        System.out.println(loader.getParent());
//        System.out.println(loader.getParent().getParent());
    }
}
