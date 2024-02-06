import MyExceptions.CustomException;
import org.example.linkedList.LinkedListImplementation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkedListImplementationTest {
    LinkedListImplementation<Integer> linkedListImplementation = new LinkedListImplementation<>();

/*    @Test
    public void test0() {
        initializeList0();
        assertEquals(3, linkedListImplementation.size());
    }

    @Test
    public void testSize5() {
        initializeList1();
        assertEquals(5, linkedListImplementation.size());
    }

    @Test
    public void test1() {
        initializeList0();
        try {
            assertEquals(Integer.valueOf(1), linkedListImplementation.get(0));
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void test2() {
        initializeList0();
        try {
            assertEquals(Integer.valueOf(2), linkedListImplementation.get(1));
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void test3() {
        initializeList0();
        try {
            assertEquals(Integer.valueOf(3), linkedListImplementation.get(2));
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }
    }*/


    private void initializeList0() {
        linkedListImplementation.add(1);
        linkedListImplementation.add(2);
        linkedListImplementation.add(3);
    }

    private void initializeList1() {
        linkedListImplementation.add(23);
        linkedListImplementation.add(52);
        linkedListImplementation.add(21);
        linkedListImplementation.add(2);
        linkedListImplementation.add(1);
    }
}
