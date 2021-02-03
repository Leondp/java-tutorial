
package za.co.myapp.beforegenerics;

import java.util.ArrayList;
import java.util.List;


public class DoubleArrayList {
    private List list = new ArrayList();
    
    public void add(Double value) {
        list.add(value);
    }
    
    public Double get(int index) {
        return (Double)list.get(index);
    }
}
