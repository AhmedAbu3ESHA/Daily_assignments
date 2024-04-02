import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InvTest2 {
Inv obj =new Inv();
    @Test
    void add() {
        //arrange
        int expected=1;

        //act
        int actual=obj.add("Chair",10);

        //assert
        assertEquals(expected, actual);
    }

    @Test
    void remove() {
        int expected=1;

        //act
        int actual=obj.remove("Table",5);

        //assert
        assertEquals(expected, actual);
    }
}