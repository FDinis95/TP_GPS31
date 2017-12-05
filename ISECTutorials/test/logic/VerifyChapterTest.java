package logic;

import data.Progression;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;

public class VerifyChapterTest {

    Progression pro = new Progression();
    VerifyChapter ver = new VerifyChapter();

    @Before
    public void setUp() {

    }

    @Test
    public void validateProgression() {
        for (int i = 0; i < 10; i++) {
            pro.setChapterTests(i);
        }
        assertNotNull(pro);
        assertNotNull(pro.getChapterTests());
    }

    @Test
    public void validateNullChaptersProgression() {
        assertNotNull(ver.getUnlockedChapters(null));
    }

}
