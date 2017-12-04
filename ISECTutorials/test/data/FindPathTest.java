package data;

import org.junit.*;
import static org.junit.Assert.*;

public class FindPathTest {

    String a[] = null;
    String b[] = null;
    FindPath fp = new FindPath();

    @Before
    public void setUp() {

        a = new String[fp.getPath().length];
        a = fp.getPath();
        b = new String[fp.getName().length];
        b = fp.getName();

    }

    @Test
    public void nullPath() {
        assertNotNull(a);
        assertNotNull(b);
    }

    @Test
    public void pathTest() {
        String c = ".\\src\\Tutorials\\C#";
        assertEquals(a[0], c);
    }
    
    @Test
    public void nameTest() {
        String c = "C#";
        assertEquals(b[0], c);
    }

    @Test
    public void sizeTest() {
        assertEquals(a.length, fp.getPath().length);
        assertEquals(a.length, fp.getName().length);
    }

}
