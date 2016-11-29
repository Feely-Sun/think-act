package com.iacthink.proxy;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author sunzihan
 * @version $Id: GenerateProxy.java V 0.1 10/20/16 12:05 sunzihan EXP $
 */
public class GenerateProxy {




    public static void main(String[] args) {

        Car car = new CarImpl();
        generateClassFile(car.getClass(),"CarProxy");
    }


    public static void generateClassFile(Class clazz,String proxyName){

      byte[]  cls =  ProxyGenerator.generateProxyClass(proxyName,clazz.getInterfaces());

        String paths= clazz.getResource(".").getPath();


        System.out.println(paths);

        FileOutputStream out = null;

        try{
            out = new FileOutputStream(paths + proxyName + ".class");
            out.write(cls);
            out.flush();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            try {
                out.close();
            }catch (IOException e){
                e.printStackTrace();
            }

        }
    }

}

