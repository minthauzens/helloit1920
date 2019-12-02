import java.util.ArrayList;
import java.util.List;

class IntegerQueue {
    private List<Integer> data;

    IntegerQueue() {
        this.data = new ArrayList<>();
    }

    IntegerQueue(int initialSize) {
        this.data = new ArrayList<>(initialSize);
    }

    public void add(Integer element) {
        data.add(element);
    }

    public Integer pop() {
        if (isEmpty()) {
            return null;
        }
        Integer element = data.get(0);
        data.remove(0);
        return element;
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }
}
