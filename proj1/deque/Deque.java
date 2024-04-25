package deque;

public interface Deque<Item> {
    void addFirst(Item item);
    void addLast(Item item);
    int size();
    default boolean isEmpty() {
        return size() == 0;
    }
    void printDeque();
    Item removeFirst();
    Item removeLast();
    Item get(int index);
}
