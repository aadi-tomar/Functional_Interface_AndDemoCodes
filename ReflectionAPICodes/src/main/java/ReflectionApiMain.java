import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionApiMain {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException {
        //Three ways to get the class info
        //Class c = Class.forName(String.valueOf(Employee.class));
        Class c1 = Class.forName("Employee");
        Employee e = new Employee();
        Class c2 = e.getClass();

        Class c3 = Employee.class;

        //MetaData about the class.
        System.out.println("Class name : " + c1.getName() + " " + c3.getName());
        System.out.println("SuperClass metaData : " + c1.getSuperclass());
        Class[] interfaces = c2.getInterfaces();
        for(Class intf : interfaces){
            System.out.println("Class interfaces : " + intf);
        }
        int modifiers= c1.getModifiers();
        System.out.println("Modifiers : " + modifiers);

        // Constructors info
        System.out.println();
        System.out.println("Constructors information using the reflection APIs");

        Constructor[] constructor = c1.getConstructors();
        Constructor[] constructor1 = c2.getDeclaredConstructors();

        for(Constructor c : constructor){
            System.out.println("Constructors without private : " + c.getName());


        }
        for(Constructor c : constructor1){
            System.out.println("Constructors with private : " + c.getName());
            Class[] classes = c.getParameterTypes();
            for(Class cl : classes)
                System.out.println("Parameters type : " + cl.getName());

        }

        //Fields information
        System.out.println();
        System.out.println("Fields information using the reflection APIs");

        Field[] fields = c1.getDeclaredFields();
        for(Field f : fields){
            System.out.println("Fields : " + f.getName() + " with type " + f.getType().getName());
            //System.out.println("Field value " +f.get(f));
            //f.getType();
        }


        //Methods Information
        System.out.println();
        System.out.println("Methods information using the reflection APIs");

        Method[] methods = c3.getDeclaredMethods();
        for(Method m : methods){
            System.out.println(" Methods : " + m.getName());
            Class[] clas = m.getParameterTypes();
            for(Class cl : clas){
                System.out.println(" parameter type : " + cl.getTypeName());
            }

        }
        Method method = c2.getMethod("getEmpDepartment");
        Class[] classes = method.getExceptionTypes();
        for(Class c : classes){
            System.out.println(c.getName());
        }


    }
}
