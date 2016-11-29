package com.iacthink.proxy;

import java.lang.reflect.TypeVariable;
import java.util.List;

/**
 * @author sunzihan
 * @version $Id: Client2.java V 0.1 10/24/16 12:11 sunzihan EXP $
 */
public class Client2 {

    public static void main(String[] args)  {

        TypeVariable[] tValue = List.class.getTypeParameters();
        System.out.println(tValue.length);



    }
}

