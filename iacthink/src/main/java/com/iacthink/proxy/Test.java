package com.iacthink.proxy;

import sun.misc.CompoundEnumeration;
import sun.misc.Resource;
import sun.misc.URLClassPath;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * @author sunzihan
 * @version $Id: Test.java V 0.1 10/21/16 19:30 sunzihan EXP $
 */
public class Test<T> {

    protected static CarImpl[] car = new CarImpl[2];


    public static void main(String[] args) {

       ClassLoader cls =  Thread.currentThread().getContextClassLoader();

        Enumeration<URL> urls = null;
        try {
            urls = getResources("META-INF/NOTICE.txt",cls);
            while(urls.hasMoreElements()){
                System.out.println(urls.nextElement());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }



    public static Enumeration<URL> getResources(String name,ClassLoader classLoader) throws IOException {
        Enumeration[] tmp = new Enumeration[2];

            tmp[0] = getBootstrapResources(name);

       // tmp[1] = findResources(name);

        return new CompoundEnumeration(tmp);
    }


    private static Enumeration<URL> getBootstrapResources(String name)
            throws IOException
    {
        final Enumeration<Resource> e =
                getBootstrapClassPath().getResources(name);
        return new Enumeration<URL> () {
            public URL nextElement() {
                return e.nextElement().getURL();
            }
            public boolean hasMoreElements() {
                return e.hasMoreElements();
            }
        };
    }

    // Returns the URLClassPath that is used for finding system resources.
    static URLClassPath getBootstrapClassPath() {
        sun.misc.URLClassPath tmp = sun.misc.Launcher.getBootstrapClassPath();

        return tmp;
    }
}

