package za.co.myapp.beforegenerics;

import java.util.ArrayList;
import java.util.List;

public class BeforeGenerics {

    public static void main(String[] args) {
        beforeGenerics();
        beforeGenericsInt();
        beforeGenericsDouble();
        GenericArrayList();
        JavaArrayList();
    }
    
    
    private static void beforeGenerics() {
        List values = new ArrayList();
        
        values.add(7); //int 4 bytes
        values.add(7L); //long 8 bytes
        values.add(7.7f); //float 4bytes
        values.add(7.7);  //double 8bytes
        
        int myValue1 = (Integer)values.get(0);
        
        System.out.println(values.get(0).getClass().getName());  
        System.out.println( ((Long)values.get(1)).getClass().getName());  
        System.out.println(values.get(2).getClass().getName());  
        System.out.println(values.get(3).getClass().getName());  
    }
        
    
    private static void beforeGenericsInt() {
        IntegerArrayList values = new IntegerArrayList();
        
        values.add(7);
        values.add(89);
        values.add(44);
        
        int myValue1 = values.get(0);

        System.out.println("myValue1 = " + myValue1);
    }

    
    private static void beforeGenericsDouble() {
        DoubleArrayList values = new DoubleArrayList();
        
        values.add(7.7);
        values.add(89.5);
        values.add(44.4);
        
        double myValue1 = values.get(0);

        System.out.println("myValue1 = " + myValue1);
    }

    
    
    private static void GenericArrayList() {
        GenericArrayList<Integer> intValues = new GenericArrayList<>();
        intValues.add(7);
        intValues.add(89);
        intValues.add(44);
        int myIntValue = intValues.get(0);
        System.out.println("myIntValue = " + myIntValue);
        
        
        GenericArrayList<Double> doubleValues = new GenericArrayList<>();
        doubleValues.add(7.7);
        doubleValues.add(89.5);
        doubleValues.add(44.4);
        double myDoubleValue = doubleValues.get(0);
        System.out.println("myDoubleValue = " + myDoubleValue);
    }

    private static void JavaArrayList() {
        List<Integer> intValues = new ArrayList<>();
        intValues.add(7);
        intValues.add(89);
        intValues.add(44);
        int myIntValue = intValues.get(0);
        System.out.println("myIntValue = " + myIntValue);
        
        
        List<Double> doubleValues = new ArrayList<>();
        doubleValues.add(7.7);
        doubleValues.add(89.5);
        doubleValues.add(44.4);
        double myDoubleValue = doubleValues.get(0);
        System.out.println("myDoubleValue = " + myDoubleValue);
    }
    
}
