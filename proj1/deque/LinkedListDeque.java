package deque;



public class LinkedListDeque<Item> implements Deque<Item>{
    private class StaffNode{
        public Item item;
        public StaffNode next;
        public StaffNode prev;

        public StaffNode(Item x, StaffNode i, StaffNode j){
            item = x;
            next = i;
            prev = j;
        }
    }

    private StaffNode sentinel;
    private int size=0;
    private StaffNode last;


    LinkedListDeque(Item x){
        sentinel = new StaffNode(null,null,null);
        sentinel.next = new StaffNode(x, sentinel,sentinel);
        sentinel.prev = sentinel.next;
        size +=1;
        last = sentinel.next;
    }

    public LinkedListDeque(){
        sentinel = new StaffNode(null,null,null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
        last = sentinel;
    }

    public void addFirst(Item x){

        sentinel.next = new StaffNode(x,sentinel.next,sentinel);
        sentinel.next.next.prev = sentinel.next;
        if (size==0) last = sentinel.next;
        size += 1;

    }

    public int size(){
        return size;
    }


    public Item getfirst(){
        return sentinel.next.item;
    }

    public Item getLast(){
        return last.item;
    }


    public void addLast(Item x){
        last.next = new StaffNode(x,sentinel,last);
        last = last.next;
        size +=1;

    }

    public Item removeLast(){

        Item a = last.item;
        last.prev.next = sentinel;

        last = last.prev;
        if (size != 0)size -= 1;
        return a;

    }

    public boolean isEmpty(){
        if(size == 0) return true;
        else return false;
    }

    public void printDeque(){
        StaffNode p = sentinel.next;
        do {
            System.out.print(p.item + " ");
            p = p.next;
        }while(p != sentinel);
    }

    public Item get(int index){
        int n = 0;
        StaffNode p = sentinel.next;
         while(n < index){
            p = p.next;
            n++;
        }
         return p.item;

    }

    public Item removeFirst(){

        Item a = sentinel.next.item;
        sentinel.next.next.prev =sentinel;
        sentinel.next = sentinel.next.next;
        if(size != 0)size -= 1;
        return(a);
    }


    private Item getRecursiveHelper(int index, StaffNode p){

        if(index == 0) return p.item;
        else
            return getRecursiveHelper(index -1,p.next);
    }

    public Item getRecursive(int index){

        if(index < 0||index >= size) return null;
        else return getRecursiveHelper(index,this.sentinel.next);
    }


    public static void main(String[] args){
        LinkedListDeque<String> lld1 = new LinkedListDeque<String>();
        System.out.println(String.valueOf(lld1.isEmpty()));
        lld1.addFirst("front");
        lld1.addFirst("one");
        lld1.addFirst("two");
        System.out.println(lld1.get(0));
        System.out.println(lld1.getRecursive(0));


    }
}

