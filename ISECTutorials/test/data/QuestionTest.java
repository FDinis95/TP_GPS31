package data;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class QuestionTest
{

    @Test
    public void nullConstructor()
    {
        String array[] = null;
        assertNotNull(new Question(array));
    }

    @Test
    public void notInt()
    {
        String array[] =
        {
            "a", "b", "c", "d", "e", "f"
        };
        assertNotNull(new Question(array));
    }

    @Test
    public void toBigOfAnArray()
    {
        String array[] =
        {
            "1", "2", "3", "4", "5", "6", "7"
        };
        assertNotNull(new Question(array));
    }

    @Test
    public void toSmallOfAnArray()
    {
        String array[] =
        {
            "1", "2", "3"
        };
        assertNotNull(new Question(array));
    }

}
