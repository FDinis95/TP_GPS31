package logic;

import data.Progression;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class VerifyEndTutorialTest {

    Progression pro = new Progression();
    VerifyEndTutorial ver = new VerifyEndTutorial();


    @Test
    public void progressionNotNull() {

        assertNotNull(pro);
    }
    
    @Test
    public void getChapterTestsNotNull(){
       assertNotNull(pro.getChapterTests());
    }
    
    @Test
    public void completedChaptersNotNull(){
       int completedChapters[] = pro.getChapterTests();
       assertNotNull(completedChapters);
    }
    
    /*@Test
    public void verifyIsFalse(){
        boolean result = ver.verify(pro);
        assertFalse(result);
    }

    @Test
    public void verifyIsTrue(){
        boolean result = ver.verify(pro);
        for (int i=0;i<10;i++)
            pro.setChapterTests(i);
        assertTrue(result);
    }*/
}
