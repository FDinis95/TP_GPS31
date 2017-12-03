package data;

import org.junit.*;
import static org.junit.Assert.*;

public class FindPathTest {
    
    String a[] = null;
    FindPath fp = new FindPath();
    
    @Before
    public void setUp(){
       
        a = new String[fp.getName().length];
        a = fp.getPath();
    }
    
    @Test
    public void NullPath(){
        assertNotNull(a);        
    }
    
    @Test
    public void PathTest(){
        String b = ".\\src\\Tutorials\\C#";
        assertEquals(a[0], b);
    }
    
    @Test
    public void sizeTest(){
         assertEquals(a.length, fp.getName().length);  
    }
}
