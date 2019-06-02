package sort;

import java.util.List;

public class Heap {

    public int size;

    public Heap(List<Integer> array) {
        this.array = array;
        this.size = array.size();
    }

    public List<Integer> array;

    public void decrease() {
        size--;
    }
}
