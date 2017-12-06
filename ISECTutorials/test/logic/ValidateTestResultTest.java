package logic;

import data.Progression;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;

public class ValidateTestResultTest {

    Progression pro = new Progression();
    ValidateTestResult val = new ValidateTestResult();
    int array[] = new int[20];
    int array2[] = new int[10];

    @Before
    public void setUp() {
        for (int i = 0; i < 10; i++) {
            array2[i] = 1;
        }
    }

    @Test
    public void progressionNull() {
        assertNotNull(pro);
    }

    @Test
    public void validateNullArray() {
        assertNotNull(val.validateEvaluationTest(array, array, array, null));
    }


 @Test
    public void validateOutcome() {
        assertEquals(val.validateEvaluationTest(array, array, array, pro),20);
    }
}