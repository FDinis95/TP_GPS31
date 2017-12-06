package logic;

import data.Progression;
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
    
    @Test
    public void verifyIsFalse(){
        assertFalse(ver.verify(pro));
    }

    @Test
    public void verifyIsTrue(){
        for (int i=0;i<10;i++)
            pro.setChapterTests(i);
        assertTrue(ver.verify(pro));
    }
    
    @Test
    public void verifyIsIncomplete(){
        for (int i=0;i<9;i++)
            pro.setChapterTests(i);
        assertFalse(ver.verify(pro));
    }
}
