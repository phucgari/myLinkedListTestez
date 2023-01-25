public class MyLinkedList<E> {
    private Node head;
    MyLinkedList(){}
    private class Node{
        private Node next;
        private final E element;
        private Node(E e){
            element=e;
        }
    }
    public void add(int index,E e){
        Node pointerAfter=head;
        Node pointerBefore=null;
        for (int i = 1; i < index; i++) {
            pointerBefore=pointerAfter;
            pointerAfter=pointerAfter.next;
        }
        addNewNodeWhenHavePointer(pointerBefore,pointerAfter,e);
    }
    private void addNewNodeWhenHavePointer(Node before, Node after, E e){
        Node temp=new Node(e);
        temp.next=after;
        if(before==null) {
            head=temp;
        }else{
            before.next=temp;
        }
    }
    public E get(int index){
        Node pointer=head;
        for (int i = 1; i <index ; i++) {
            pointer=pointer.next;
        }
        return pointer.element;
    }

    public void addLast(E e) {
            Node pointerAfter = head;
            Node pointerBefore = null;
            while (true) {
                if (pointerAfter == null) break;
                pointerBefore = pointerAfter;
                pointerAfter = pointerAfter.next;
            }
            addNewNodeWhenHavePointer(pointerBefore, null, e);
    }
    public void addFirst(E e){
        add(1,e);
    }
    public void remove(int index){
        Node pointerBefore=null;
        Node pointerAfter=head;
        for (int i = 1; i < index; i++) {
            if(pointerAfter==null)continue;
            pointerBefore=pointerAfter;
            pointerAfter=pointerAfter.next;
        }
        if(pointerBefore==null)head=head.next;
        else if (pointerAfter==null) pointerBefore.next=null;
        else pointerBefore.next=pointerAfter.next;
    }
    public int size(){
        int count=0;
        Node pointer=head;
        while(pointer!=null){
            pointer=pointer.next;
            count++;
        }
        return count;
    }
    public void printList(){
        Node pointer=head;
        while(pointer!=null){
            System.out.println(pointer.element);
            pointer=pointer.next;
        }
    }
    public void clone(MyLinkedList<E> clone){
        Node pointer=head;
        while(pointer!=null){
            clone.addLast(pointer.element);
            pointer=pointer.next;
        }
    }
    public boolean contains(E e) {
        Node pointer=head;
        while(pointer!=null){
            if(pointer.element==e)return true;
            pointer=pointer.next;
        }
        return false;
    }
    public int indexOf(E e) {
        int counter=1;
        Node pointer=head;
        while(pointer!=null){
            if(pointer.element==e)return counter;
            pointer=pointer.next;
            counter++;
        }
        return -1;
    }
    public void removeObject(E e){
        Node pointer=head;
        int counter=1;
        while(pointer!=null){
            if(pointer.element==e) {
                this.remove(counter);
                counter--;
            }
            pointer=pointer.next;
            counter++;
        }
    }
}