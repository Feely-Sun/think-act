package com.ithink.iact.pj2.beam;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * @author sunzihan
 * @version $Id: TypeCapture.java V 0.1 11/24/16 19:16 sunzihan EXP $
 */
public abstract class TypeCapture<T> {
    /** Returns the captured type. */
    public final Type capture() {
        Type superclass = getClass().getGenericSuperclass();
        checkArgument(superclass instanceof ParameterizedType,
                "%s isn't parameterized", superclass);
        return ((ParameterizedType) superclass).getActualTypeArguments()[0];
    }
}

