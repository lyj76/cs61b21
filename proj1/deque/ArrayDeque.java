package deque;

public class ArrayDeque<Item> implements Deque<Item> {


    private int size;
    private Item[] items;
    private int first;
    private int last;

    public ArrayDeque() {
        items = (Item[]) new Object[8];
        size = 0;
        first = 0;
        last = 0;
    }

    public void resize(int n) {
        Item[] a = (Item[]) new Object[n];
        for (int i = 0; i <= this.size() - 1; i++) {
            a[i] = items[(first + i + items.length) % items.length];

        }
        items = a;
        first = 0;
        last = size - 1;
    }

    public void addLast(Item x) {
        if (size == items.length)
            resize(size * 2);


        if(size != 0)last= (last + 1) % items.length;
        items[last] = x;
        size++;


    }

    public void addFirst(Item x) {
        if (size == items.length)
            resize(size * 2);
        first = (first - 1 + items.length) % items.length;
        items[first] = x;

        if (size == 0) last = first;
        size++;
    }

    public Item removeLast() {
        if (size == 0) return null;
        else {
            if (size < items.length / 4)
                resize(items.length / 2);
            Item a = items[last];
            if (size != 0) size--;
            items[last] = null;
            last = (last - 1 + items.length) % items.length;
            return a;
        }
    }

    public Item removeFirst() {
        if (size == 0) return null;
        else {
            if (size < items.length / 4)
                resize(items.length / 2);
            Item a = items[first];

            if (size != 0) size--;
            items[first] = null;

            first = (first + 1) % items.length;
            return a;
        }
    }

    public int size() {
        return size;
    }

    public Item get(int index) {
        return items[(first + index + items.length) % items.length];
    }

    public boolean isEmpty() {
        if (size == 0) return true;
        else return false;
    }

    public void printDeque() {
        for (int i = 0; i <= this.size - 1; i++) {
            int index = (first + i + items.length) % items.length;
            System.out.print(items[index] + " ");
        }

    }

    public static void main(String[] args) {
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        for (int i = 1; i <= 10; i++)
            ad1.addLast(3);

        for (int i = 1; i <= 10; i++) {
            ad1.removeFirst();
            ad1.addLast(2);

        }
        System.out.println(".");
    }
}
