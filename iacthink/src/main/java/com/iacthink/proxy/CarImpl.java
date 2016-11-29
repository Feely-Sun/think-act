package com.iacthink.proxy;

/**
 * @author sunzihan
 * @version $Id: CarImpl.java V 0.1 10/20/16 12:13 sunzihan EXP $
 */
public class CarImpl implements Car {
    public void run(String speed) {

        System.out.println("run with:" + speed);
    }


    static {
        System.out.println("car static");
    }
}

