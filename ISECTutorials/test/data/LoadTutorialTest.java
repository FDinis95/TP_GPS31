package data;

import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;

public class LoadTutorialTest {
    
    
    @Before
    public void setUp(){
        
     }
    
    @Test
    public void NullPath(){
        
        LoadTutorial lt = new LoadTutorial();
        
        String a = lt.loadChapter(null);
        assertNotNull(a);
    }
    
    @Test
    public void NotNullPath(){
        LoadTutorial lt = new LoadTutorial();
        
        String a = lt.loadChapter(".\\src\\Tutorials\\C#\\chapters\\chapter0.txt");
        assertNotNull(a);
    }
    
    @Test
    public void WrongPath(){
        
        LoadTutorial lt = new LoadTutorial();
        lt.loadChapter(".\\src\\Tutorials\\C#\\chapters\\chapter30.txt");
    }

}
