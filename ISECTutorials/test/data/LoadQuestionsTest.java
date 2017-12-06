package data;

import static org.junit.Assert.*;
import org.junit.Test;

public class LoadQuestionsTest
{
    
    @Test
    public void notNullPath()
    {
        LoadQuestions fp = new LoadQuestions(".\\src\\Tutorials\\C#\\tests\\chapter4.txt");
        assertNotNull(fp);        
    }
    
    @Test
    public void notNullPathDiagnose()
    {
        LoadQuestions fp = new LoadQuestions(".\\src\\Tutorials\\C#\\diagnose.txt");
        assertNotNull(fp);        
    }
    
    @Test
    public void nullPath()
    {
        LoadQuestions fp = new LoadQuestions(null);
        assertNotNull(fp);
    }
    
    @Test
    public void nonExistentPath()
    {
        LoadQuestions fp = new LoadQuestions(".\\src\\Tutorials\\C#\\tests\\chapter20.txt");
        assertNotNull(fp);
    }
    
    @Test
    public void existentPathWrongTypeOfFile()
    {
        LoadQuestions fp = new LoadQuestions(".\\src\\Tutorials\\C#\\chapters\\chapter2.txt");
        assertNotNull(fp);        
    }
    
    @Test    
    public void incorrectFormatedFile()
    {
        LoadQuestions fp = new LoadQuestions(".\\src\\Tutorials\\C#\\diagnoseTest.txt");
        assertNotNull(fp);
    }

    @Test
    public void returnQuestions()
    {
        LoadQuestions fp = new LoadQuestions(".\\src\\Tutorials\\C#\\diagnose.txt");
        LoadQuestions fp2 = new LoadQuestions(".\\src\\Tutorials\\C#\\diagnose.txt");
        assertNotNull(fp);
        assertNotNull(fp2);
        assertNotEquals(fp2.getQuestions(), fp.getQuestions());
        
    }
}
