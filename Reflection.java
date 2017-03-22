public class Reflection {
  public static void main(String[] args) {
    System.out.println("Getting the canonical name of the class...");
    Class type = null;
    try {
      type = Class.forName("ConcreteClass");
    } catch(ClassNotFoundException e) {
      e.printStackTrace();
    }
    System.out.println(type.getCanonicalName());
  }
}