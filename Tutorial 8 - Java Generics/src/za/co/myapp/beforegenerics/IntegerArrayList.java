
package za.co.myapp.beforegenerics;

import java.util.ArrayList;
import java.util.List;


public class IntegerArrayList {
    private List list = new ArrayList();
    
    public void add(Integer value) {
        list.add(value);
    }
    
    public Integer get(int index) {
        return (Integer)list.get(index);
    }
}
