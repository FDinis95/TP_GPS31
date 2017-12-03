package data;

import org.junit.*;
import static org.junit.Assert.*;

public class FindPathTest {
    
    String a[] = null;
    FindPath fp = new FindPath();
    
    @Before
    public void setUp(){
       
        a = new String[fp.getName().length];
        
    }
    
    @Test
    public void NullPath(){
        assertTrue(a[0]!=null);        
    }
    
    
    
}
