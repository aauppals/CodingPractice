import org.junit.jupiter.api.Test;

import java.time.chrono.ChronoLocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NomuraTest {

    @Test
    public void whenPowFunctionCalledThenCorrectResultReturned() {
        int x = 2;
        int y = 5;
        assertEquals(32, powerFuncRec(x, y));

    }

    @Test
    public void whenPowFunctionRecCalledThenCorrectResultReturned() {
        int x = 2;
        int y = 5;
        assertEquals(32, powerFunc(x, y));

    }

    public static void main(String[] args) {

        int x = 2;
        int y = 2;

        long startTime = System.nanoTime();
        powerFunc(x, y);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("powerFunc" + duration);

        startTime = System.nanoTime();
        powerFuncRec(x, y);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("powerFuncRec" + duration);

    }


    //Iterative
    public static int powerFunc(int x, int y) {
        int result = 1;

        for (int i = 0; i < y; i++) {
            result = result * x;
        }

        return result;
    }

    //Recursive
    public static int powerFuncRec(int x, int y) {
        int result;
        if (y == 0) return 1;

        result = powerFuncRec(x, y - 1) * x;
        return result;

    }

}
