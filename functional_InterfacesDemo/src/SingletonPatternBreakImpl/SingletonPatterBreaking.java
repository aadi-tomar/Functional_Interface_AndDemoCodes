package SingletonPatternBreakImpl;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonPatterBreaking {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException, CloneNotSupportedException {

        Singleton singletonObject = Singleton.getInstance();
        Singleton singletonObject2 = Singleton.getInstance();

        System.out.println("Singleton Object1 hashCode "+ singletonObject.hashCode());
        System.out.println("Singleton Object2 hashCode " + singletonObject2.hashCode());

        Class< ?> className = Class.forName("SingletonPatternBreakImpl.Singleton");
        Constructor< ?> constructor = (Constructor<Singleton>) className.getDeclaredConstructor();
        constructor.setAccessible(true);

        Singleton reflectionObject = (Singleton) constructor.newInstance();
        System.out.println(" -----------Reflection Breaking-------------");
        System.out.println("New Object hashCode after breaking by reflection is "+ reflectionObject.hashCode());

        System.out.println(" ------------Serialization Breaking------------");

        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("/Users/aadi/Documents/Projects/Serialization.ser"));
        outputStream.writeObject(singletonObject);
        outputStream.close();

        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("/Users/aadi/Documents/Projects/Serialization.ser"));
        Singleton singletonSerObject = (Singleton) inputStream.readObject();
        inputStream.close();

        System.out.println("New Object hashCode after breaking by Serialization is " + singletonSerObject.hashCode());



        Singleton ClonedObject = (Singleton) singletonObject.clone();

        System.out.println("New Object hashCode after breaking by Serialization is " + ClonedObject.hashCode());


    }
}
