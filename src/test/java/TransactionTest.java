import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TransactionTest {
    @Test
    void shouldReturnStringInSpecificFormat(){
        Transaction transaction = new Transaction("A","B",new Money(10));
        String result = "A->B, 10";
        assertEquals(result,transaction.toString());
    }
}
