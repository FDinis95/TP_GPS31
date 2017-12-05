package logic;

import data.Progression;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class VerifyChapterTest {

    Progression pro = new Progression();
    VerifyChapter ver = new VerifyChapter();
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
    public void getUnlockedChaptersNotNull() {
        assertNotNull(ver.getUnlockedChapters(pro));
    }

    @Test
    public void getUnlockedChaptersIfProgressionIsNull() {
        assertNotNull(ver.getUnlockedChapters(null));
    }

    @Test
    public void getUnlockedChaptersValues() {
        assertArrayEquals(ver.getUnlockedChapters(pro), array);
    }

    @Test
    public void getUnlockedChaptersValuesNotZero() {
        for (int i = 0; i < 10; i++) {
            pro.setChapterTests(i);
        }
        assertNotEquals(ver.getUnlockedChapters(pro), array);
    }

    @Test
    public void getUnlockedChaptersValuesIsEqual() {
        for (int i = 0; i < 10; i++) {
            pro.setChapterTests(i);
        }
        assertArrayEquals(ver.getUnlockedChapters(pro), array2);
    }

}
