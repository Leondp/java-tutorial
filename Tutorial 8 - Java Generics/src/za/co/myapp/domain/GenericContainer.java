package za.co.myapp.domain;

import java.util.ArrayList;
import java.util.List;

public class GenericContainer<T, K extends Number> {
   private T value1;
   private T value2;
   private K value3;
   
   public GenericContainer(T value1, T value2, K value3) {
       this.value1 = value1;
       this.value2 = value2;
       this.value3 = value3;
   }
   
   public List<T> getValues() {
       List<T> list = new ArrayList<>();
       list.add(value1);
       list.add(value2);
       return list;
   }
   
   public K getValue3() {
       return value3;
   }
   
}
