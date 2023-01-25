import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {
    MyLinkedList<String> list=new MyLinkedList<>();
    @Test
    void testConstructor(){
    }
    @Test
    void testSimpleAdd(){
        list.add(1,"a");
        list.add(2,"b");
        list.add(3,"c");
        assertEquals("a",list.get(1));
        assertEquals("b",list.get(2));
        assertEquals("c",list.get(3));
    }
    @Test
    void testMiddleAdd(){
        list.add(1,"a");
        list.add(2,"c");
        list.add(2,"b");
        assertEquals("a",list.get(1));
        assertEquals("b",list.get(2));
        assertEquals("c",list.get(3));
    }
    @Test
    void testAddLast(){
        list.addLast("a");
        list.addLast("b");
        list.addLast("c");
        assertEquals("a",list.get(1));
        assertEquals("b",list.get(2));
        assertEquals("c",list.get(3));
    }
    @Test
    void testAddFirst(){
        list.addFirst("c");
        list.addFirst("b");
        list.addFirst("a");
        assertEquals("a",list.get(1));
        assertEquals("b",list.get(2));
        assertEquals("c",list.get(3));
    }
    @Test
    void testRemoveFirst(){
        list.addLast("a");
        list.addLast("b");
        list.addLast("c");
        list.remove(1);
        assertEquals("b",list.get(1));
        assertEquals("c",list.get(2));
    }
    @Test
    void testRemoveMiddle(){
        list.addLast("b");
        list.addLast("c");
        list.addFirst("a");
        list.remove(2);
        assertEquals("a",list.get(1));
        assertEquals("c",list.get(2));
    }
    @Test
    void testRemoveLast(){
        list.addLast("b");
        list.addLast("c");
        list.addFirst("a");
        list.remove(3);
        assertEquals("a",list.get(1));
        assertEquals("b",list.get(2));
    }
    @Test
    void getSize(){
        assertEquals(0,list.size());
        list.addFirst("a");
        assertEquals(1,list.size());
        list.addFirst("a");
        assertEquals(2,list.size());
        list.remove(2);
        assertEquals(1,list.size());
        list.remove(1);
        assertEquals(0,list.size());
    }
    @Test
    void testClone(){
        list.addLast("a");
        list.addLast("b");
        list.addLast("c");
        MyLinkedList<String> newList=new MyLinkedList<>();
        list.clone(newList);
        newList.remove(2);
        assertEquals("b",list.get(2));
        assertEquals("c",newList.get(2));
    }
    @Test
    void testContains(){
        list.addLast("a");
        list.addLast("b");
        list.addLast("c");
        assertEquals(true,list.contains("a"));
        assertEquals(false,list.contains("d"));
    }
    @Test
    void testIndexOf(){
        list.addLast("a");
        list.addLast("b");
        list.addLast("c");
        assertEquals(1,list.indexOf("a"));
        assertEquals(-1,list.indexOf("d"));
        assertEquals(2,list.indexOf("b"));
        assertEquals(3,list.indexOf("c"));
    }
    @Test
    void removeObject(){
        list.addLast("a");
        list.addLast("b");
        list.addLast("c");
        list.addLast("a");
        list.removeObject("a");
        assertEquals(1,list.indexOf("b"));
        assertEquals(2,list.indexOf("c"));
    }
}