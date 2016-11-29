import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/**
 * @author sunzihan
 * @version $Id: B.java V 0.1 11/24/16 20:26 sunzihan EXP $
 */
public class B extends TypeCaptureTest {


    protected B(){
        Type type = super.capture();
        System.out.println(type instanceof TypeVariable);
    }


    public static void main(String[] args) {
        new B();
    }

}

