package data;

import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;

public class LoadTutorialTest {
    
    
    @Before
    public void setUp(){
        
     }
    
    @Test
    public void nullPath(){
        
        LoadTutorial lt = new LoadTutorial();
        
        String a = lt.loadChapter(null);
        assertNotNull(a);
    }
    
    @Test
    public void notNullPath(){
        LoadTutorial lt = new LoadTutorial();
        
        String a = lt.loadChapter(".\\src\\Tutorials\\C#\\chapters\\chapter0.txt");
        assertNotNull(a);
    }
    
    @Test
    public void wrongPath(){
        
        LoadTutorial lt = new LoadTutorial();
        lt.loadChapter(".\\src\\Tutorials\\C#\\chapters\\chapter30.txt");
    }

}
