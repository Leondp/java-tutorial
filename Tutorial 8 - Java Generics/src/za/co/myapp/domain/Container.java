package za.co.myapp.domain;

import java.util.ArrayList;
import java.util.List;

public class Container {
   private String value1;
   private String value2;
   
   public Container(String value1, String value2) {
       this.value1 = value1;
       this.value2 = value2;
   }
   
   public List<String> getValues() {
       List<String> list = new ArrayList<>();
       list.add(value1);
       list.add(value2);
       return list;
   }
   
}
