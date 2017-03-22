@Deprecated
public class ConcreteClass extends BaseClass implements BaseInterface{  
    public int publicInt;  
    private String privateString = "private string";  
    protected boolean protectedBoolean;  
    Object defaultObject;  
      
    public ConcreteClass(int i) {  
        this.publicInt = i;  
    }

    @Override  
    public void method1() {  
        System.out.println("method1 impl.");  
    }  
  
    @Override  
    public int method2(String str) {  
        System.out.println("method2 impl.");  
        return 0;  
    }  
    
    @Override  
    public int method4() {  
        System.out.println("method4 overriden.");  
        return 0;  
    }  
      
    public int method5(int i) {  
        System.out.println("method5 overriden.");  
        return 0;  
    }

    //inner classes
    public class ConcreteClassPublicClass{}  
    private class ConcreteClassPrivateClass{}  
    protected class ConcreteClassProtectedClass{}  
    class ConcreteClassDefualtClass{}  
      
    //member enum  
    enum ConcreteClassDefultEnum{}  
    public enum ConcreteClassPublicEnum{}  
      
    //member interface
    public interface ConcreteClassPublicInterface{}
} 