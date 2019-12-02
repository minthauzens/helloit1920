import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GenericStack<T extends Date> {
    private List<T> data; // this changed

    public GenericStack() {
        this.data = new ArrayList<>();
    }

    public GenericStack(int initialSize) {
        this.data = new ArrayList<>(initialSize);
    }

    public void add(T item) { // this changed
        this.data.add(item);
    }

    public T pop() { // this changed
        if (isEmpty()) {
            return null;
        }

        int size = this.data.size() - 1;
        T result = this.data.get(size); // this changed
        this.data.remove(size);
        return result;
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }
}
