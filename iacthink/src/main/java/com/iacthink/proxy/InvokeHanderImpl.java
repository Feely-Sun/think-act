package com.iacthink.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author sunzihan
 * @version $Id: InvokeHanderImpl.java V 0.1 10/20/16 13:27 sunzihan EXP $
 */
public class InvokeHanderImpl implements InvocationHandler {


    private Car car;


    public InvokeHanderImpl(Car car){
        this.car = car;
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        method.invoke(car,args);
        return null;
    }
}

