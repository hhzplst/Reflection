import java.lang.annotation.*;
import java.lang.reflect.*;

public class Reflection {
  public static void main(String[] args) {
    System.out.println("Getting the canonical name of the class...");
    Class<?> type = null;
    try {
      type = Class.forName("ConcreteClass");
    } catch(ClassNotFoundException e) {
      e.printStackTrace();
    }
    System.out.println(type.getCanonicalName());
    System.out.println();

    System.out.println("Getting the super class of the class...");
    System.out.println(type.getSuperclass());
    System.out.println();

    System.out.println("Getting the public interface members inherited from" + 
      "super classes and the public class and interface members declared by the class...");
    Class<?>[] classes = type.getClasses();
    for(Class<?> c : classes)
      System.out.println(c);
    System.out.println();

    System.out.println("Getting all the classes and interfaces declared" + 
                        "as memebers of the class(not inherited)...");
    classes = type.getDeclaredClasses(); 
    for(Class<?> c : classes)
      System.out.println(c);
    System.out.println(); 

    System.out.println("Getting the class modifier...");
    System.out.println(type.getModifiers());
    System.out.println(); 

    System.out.println("Getting the implemented interface...");
    classes = type.getInterfaces();
    for(Class<?> c : classes)
      System.out.println(c.getCanonicalName());
    System.out.println();

    System.out.println("Getting the public methods...");
    Method[] methods = type.getMethods();
    for(Method m : methods)
      System.out.println(m);
    System.out.println(); 

    System.out.println("Getting the public constructors...");
    Constructor<?>[] constructors = type.getConstructors();
    for(Constructor<?> c : constructors)
      System.out.println(c);
    System.out.println();

    System.out.println("Getting the public fields...");
    Field[] fields = type.getFields();
    for(Field f : fields)
      System.out.println(f);
    System.out.println(); 

    System.out.println("Getting the class annotations...");
    Annotation[] annotations = type.getAnnotations();
    for(Annotation a : annotations)
      System.out.println(a);
    System.out.println();

    System.out.println("Getting the constructors and use the Constructor to create a new instance...");
    ConcreteClass c = null;
    try{
      c = (ConcreteClass)constructors[0].newInstance(10);      
    } catch (Exception e) {
      System.err.println(e);
    }
    System.out.println("New instance created with integer " + c.publicInt); 
  }
}