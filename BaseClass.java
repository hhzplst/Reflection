public class BaseClass {  
  
    private int baseInt;  
      
    private static void method3() {  
        System.out.println("method3");  
    }  
      
    public  int method4() {  
        System.out.println("method4");  
        return 0;  
    }  
      
    public static void method5() {  
        System.out.println("method5");  
    }  
  
    void method6() {  
        System.out.println("method6");  
    }  
      
    //inner public class 
    public class BaseClassInnerClass{}  
      
    //member public enum
    public enum BaseClassMemberEnum{}  
}  