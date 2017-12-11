package logic;

import data.Progression;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;

public class ValidateTestResultTest
{

    Progression pro = new Progression();
    ValidateTestResult val = new ValidateTestResult();
    int[] arrayOf20 = new int[20];
    int[] arrayOf10 = new int[10];
    int[] arrayChapters =  new int[7];
    int[] arrayOfZeros;
    int[] arrayUnknown;

    @Before
    public void setUp()
    {
        for (int i = 0; i < 10; i++)
        {
            arrayOf10[i] = 1;
        }
    }

    @Test
    public void progressionNull()
    {
        assertNotNull(pro);
    }

    @Test
    public void validateNull()
    {
        assertNotNull(val.validateEvaluationTest(arrayOf20, arrayOf20, arrayOf20, null));
        assertNotNull(val.validateEvaluationTest(null, null, null, null));
    }

    @Test
    public void validateUninstantiatedArray()
    {
        assertNotNull(val.validateEvaluationTest(arrayUnknown, arrayOf20, arrayOf20, pro));
        assertNotNull(val.validateEvaluationTest(arrayOf20, arrayUnknown, arrayOf20, pro));
        assertNotNull(val.validateEvaluationTest(arrayOf20, arrayOf20, arrayUnknown, pro));
    }

    @Test
    public void validateDifferentSizeArray()
    {
        assertNotNull(val.validateEvaluationTest(arrayOf20, arrayOf10, arrayOf20, pro));
        assertNotNull(val.validateEvaluationTest(arrayOf10, arrayOf20, arrayOf20, pro));
        assertNotNull(val.validateEvaluationTest(arrayOf20, arrayOf20, arrayOf10, pro));
    }

    @Test
    public void validateAllCorrectAnswers()
    {
        assertEquals(val.validateEvaluationTest(arrayOf20, arrayOf20, arrayOf20, pro), 20);
    }

    @Test
    public void validateNotAllCorrectAnswers()
    {
        int arrayTemp[] =  new int[20];
        arrayTemp[1] = 1;
        assertNotEquals(val.validateEvaluationTest(arrayOf20, arrayTemp, arrayOf20, pro), 20);
    }

    @Test
    public void updateProgression()
    {
        arrayOfZeros = new int[10];
        assertArrayEquals(pro.getChapter(), arrayOfZeros);
        val.validateEvaluationTest(arrayOf20, arrayOf20, arrayOf20, pro);
        assertNotEquals(pro.getChapter(), arrayOfZeros);
    }

    @Test
    public void updateProgressionOutcome()
    {
//        this ensures all the chapters have two questions correct
        int[] verySpecificArray = new int[20];
        for (int i = 0; i < 10; i++)
        {
            verySpecificArray[i] = i;
            verySpecificArray[i + 10] = i;
        }
        val.validateEvaluationTest(arrayOf20, arrayOf20, verySpecificArray, pro);
        assertArrayEquals(pro.getChapter(), arrayOf10);
    }

    @Test
    public void validateNullPro()
    {
        assertNotNull(val.validateChapterTest(arrayOf20, arrayOf20, 1, null));
        assertNotNull(val.validateChapterTest(null, null, 1, pro));

    }

    @Test
    public void validateChapter()
    {
        assertNotNull(val.validateChapterTest(arrayChapters, arrayChapters, 0, pro));
        assertNotNull(val.validateChapterTest(arrayChapters, arrayChapters, 1, pro));
        assertNotNull(val.validateChapterTest(arrayChapters, arrayChapters, 5, pro));
        assertNotNull(val.validateChapterTest(arrayChapters, arrayChapters, 10, pro));
        assertNotNull(val.validateChapterTest(arrayChapters, arrayChapters, 20, pro));
    }

    @Test
    public void validateUninstantiatedArrayForChapters()
    {
        assertNotNull(val.validateChapterTest(arrayUnknown, arrayChapters, 1, pro));
        assertNotNull(val.validateChapterTest(arrayChapters, arrayUnknown, 1, pro));
        assertNotNull(val.validateChapterTest(arrayChapters, arrayOf20, 1, pro));
    }

    @Test
    public void validateDifferentSizeArrayChapter()
    {
        assertNotNull(val.validateChapterTest(arrayChapters, arrayOf10, 1, pro));
        assertNotNull(val.validateChapterTest(arrayOf10, arrayChapters, 1, pro));
        assertNotNull(val.validateChapterTest(arrayOf20, arrayOf20, 1, pro));
    }

    @Test
    public void validateAllCorrectAnswersChapter()
    {
        assertEquals(val.validateChapterTest(arrayChapters, arrayChapters, 2, pro),7);
    }

    @Test
    public void validateNotAllCorrectAnswersChapter()
    {
        int[] arrayTemp = new int[7];
        arrayTemp[5]=1;
        assertNotEquals(val.validateChapterTest(arrayChapters, arrayTemp,1, pro),7);
    }

    @Test
    public void updateProgressionAfterChapter()
    {
        arrayOfZeros = new int[10];
        assertArrayEquals(pro.getChapter(), arrayOfZeros);
        val.validateChapterTest(arrayOf20, arrayOf20, 1, pro);
        assertNotEquals(pro.getChapter(), arrayOfZeros);
    }

    @Test
    public void updateProgressionOutcomeAfterChapter()
    {
//        this ensures all the chapters have two questions correct
        int[] verySpecificArray = new int[10];
        verySpecificArray[0]=1;
        val.validateChapterTest(arrayChapters, arrayChapters, 0, pro);
        assertArrayEquals(pro.getChapter(), verySpecificArray);
    }
    

}
