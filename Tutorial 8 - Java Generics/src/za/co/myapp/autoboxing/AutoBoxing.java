package za.co.myapp.autoboxing;

import java.util.ArrayList;
import java.util.List;

public class AutoBoxing {

    public static void main(String[] args) {
        autoBoxing();
        autoboxingSample();
        noAutoboxingSample();
    }
    
    
    private static void autoBoxing() { //automatic conversion from primitives to objects
        Integer myValue = 2; //autoboxing
        int myValue2 = myValue; //unboxing
    }
    
    private static void autoboxingSample() {
        List values = new ArrayList();
        
        values.add(7); //int 4 bytes
        values.add(7L); //long 8 bytes
        values.add(7.7F); //float 4bytes
        values.add(7.7);  //double 8bytes
        
        System.out.println(values.get(0).getClass().getName());  
        System.out.println(values.get(1).getClass().getName());  
        System.out.println(values.get(2).getClass().getName());  
        System.out.println(values.get(3).getClass().getName());  
    }
    
    private static void noAutoboxingSample() {
        List values = new ArrayList();
        
        values.add(new Integer(7));
        values.add(new Long(7));
        values.add(new Float(7.7));
        values.add(new Double(7.7));
        
        System.out.println(values.get(0).getClass().getName());  
        System.out.println(values.get(1).getClass().getName());  
        System.out.println(values.get(2).getClass().getName());  
        System.out.println(values.get(3).getClass().getName());  
    }
    
}
