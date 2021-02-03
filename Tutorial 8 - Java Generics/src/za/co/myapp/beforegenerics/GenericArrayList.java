
package za.co.myapp.beforegenerics;

import java.util.ArrayList;
import java.util.List;


public class GenericArrayList<E> {
    private List<E> list = new ArrayList<>();
    
    public void add(E value) {
        list.add(value);
    }
    
    public E get(int index) {
        return list.get(index);
    }
}
