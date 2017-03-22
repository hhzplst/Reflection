import java.lang.annotation.*;
import java.lang.reflect.*;

public class Reflection {
  public static void main(String[] args) {
    System.out.println("Getting the canonical name of the class...");
    Class<?> type = null;
    try {
      type = Class.forName("ConcreteClass");
    } catch(Exception e) {
      System.err.println(e);
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
    } catch(Exception e) {
      System.err.println(e);
    }
    System.out.println("New instance created with integer " + c.publicInt); 
    System.out.println();

    System.out.println("Getting the public fields and use the Field claass to get and set the public fields...");
    try {
      int original = (int)fields[0].get(c);
      fields[0].set(c, 15);  
      System.out.println("Instance variable has been set to " + c.publicInt + " from " + original);
    } catch(Exception e) {
      System.err.println(e);
    } 
    System.out.println();

    System.out.println("Getting the public methods and use the Method claass to involke public methods...");
    try {
      Method m5 = type.getMethod("method5", int.class);
      System.out.println("Involking method5 with return value " + (int)m5.invoke(c, 3));
    } catch(Exception e) {
      System.err.println(e);
    }
  }
}

/*******************************************************OUTPUT*******************************************************

➜  AssignmentD git:(master) ✗ java Reflection      
Getting the canonical name of the class...
ConcreteClass

Getting the super class of the class...
class BaseClass

Getting the public interface members inherited fromsuper classes and the public class and interface members declared by the class...
interface ConcreteClass$ConcreteClassPublicInterface
class ConcreteClass$ConcreteClassPublicEnum
class ConcreteClass$ConcreteClassPublicClass
class BaseClass$BaseClassMemberEnum
class BaseClass$BaseClassInnerClass

Getting all the classes and interfaces declaredas memebers of the class(not inherited)...
interface ConcreteClass$ConcreteClassPublicInterface
class ConcreteClass$ConcreteClassPublicEnum
class ConcreteClass$ConcreteClassDefultEnum
class ConcreteClass$ConcreteClassDefualtClass
class ConcreteClass$ConcreteClassProtectedClass
class ConcreteClass$ConcreteClassPrivateClass
class ConcreteClass$ConcreteClassPublicClass

Getting the class modifier...
1

Getting the implemented interface...
BaseInterface

Getting the public methods...
public int ConcreteClass.method5(int)
public void ConcreteClass.method1()
public int ConcreteClass.method2(java.lang.String)
public int ConcreteClass.method4()
public static void BaseClass.method5()
public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException
public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException
public final void java.lang.Object.wait() throws java.lang.InterruptedException
public boolean java.lang.Object.equals(java.lang.Object)
public java.lang.String java.lang.Object.toString()
public native int java.lang.Object.hashCode()
public final native java.lang.Class java.lang.Object.getClass()
public final native void java.lang.Object.notify()
public final native void java.lang.Object.notifyAll()

Getting the public constructors...
public ConcreteClass(int)

Getting the public fields...
public int ConcreteClass.publicInt
public static final int BaseInterface.interFaceInt

Getting the class annotations...
@java.lang.Deprecated()

Getting the constructors and use the Constructor to create a new instance...
New instance created with integer 10

Getting the public fields and use the Field claass to get and set the public fields...
Instance variable has been set to 15 from 10

Getting the public methods and use the Method claass to involke public methods...
method5 overriden.
Involking method5 with return value 0

*******************************************************END OUTPUT*******************************************************/