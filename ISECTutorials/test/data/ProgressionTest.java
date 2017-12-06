package data;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ProgressionTest {

    Progression pro = new Progression();
    int array[] = new int[10];
    int array2[] = new int[10];

    @Before
    public void setUp() {
        for (int i = 0; i < 10; i++) {
            array2[i] = 1;
        }
    }

    @Test
    public void validateProgression() {
        assertNotNull(pro);
    }

    @Test
    public void validatGetChapterTests() {
        assertNotNull(pro.getChapterTests());
    }

    @Test
    public void validatGetChapter() {
        assertNotNull(pro.getChapter());
    }

    @Test
    public void validatGetCorrect() {
        assertNotNull(pro.getCorrect());
    }

    @Test
    public void validatGetTotalNumberOfQuestionsAnswered() {
        assertNotNull(pro.getTotalNumberOfQuestionsAnswered());
    }

    @Test
    public void validatGetChapterTestsIsZeros() {
        assertArrayEquals(pro.getChapterTests(), array);
    }

    @Test
    public void validatGetChapterIsZeros() {
        assertArrayEquals(pro.getChapter(), array);
    }

    @Test
    public void validatGetCorrectIsZero() {
        assertEquals(pro.getCorrect(), 0);
    }

    @Test
    public void validatGetTotalIsZeros() {
        assertEquals(pro.getTotalNumberOfQuestionsAnswered(), 0);
    }

    @Test
    public void validatGetChapterTestsDiferent() {
        assertNotEquals(array, pro.getChapterTests());
    }

    @Test
    public void validatGetChapterDiferent() {

        assertNotEquals(array, pro.getChapter());
    }

    @Test
    public void validatSetChapterTestsEqual() {
        for (int i = 0; i < 10; i++) {
            pro.setChapterTests(i);
        }
        assertArrayEquals(array2, pro.getChapterTests());
    }

    @Test
    public void validatSetChapterEqual() {
        for (int i = 0; i < 10; i++) {
            pro.setChapter(i);
        }
        assertArrayEquals(array2, pro.getChapter());
    }

    @Test
    public void validatSetCorrectEqual() {
        pro.setCorrect(10);
        assertEquals(10, pro.getCorrect());
    }

    @Test
    public void validatSetTotalEqual() {
        pro.setTotalNumberOfQuestionsAnswered();
        assertEquals(7, pro.getTotalNumberOfQuestionsAnswered());
    }

}
