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

        
  }
}