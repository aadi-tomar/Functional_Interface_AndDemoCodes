package SingletonPatternBreakImpl;

import java.io.Serializable;

public class Singleton implements Serializable, Cloneable{
    private static Singleton singletonInstance;

    private Singleton() {

    }

    public static Singleton getInstance(){

        if( singletonInstance == null){
            singletonInstance = new Singleton();
        }

        return singletonInstance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
