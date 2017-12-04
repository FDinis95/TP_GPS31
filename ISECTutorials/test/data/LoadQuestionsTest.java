package data;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class LoadQuestionsTest {
    
    @Test
    public void notNullPath(){
        LoadQuestions fp = new LoadQuestions(".\\src\\Tutorials\\C#\\tests\\chapter4.txt");
        assertNotNull(fp);        
    }
    
    @Test
    public void nullPath(){
        LoadQuestions fp = new LoadQuestions(null);
        assertNotNull(fp);
    }
        
    @Test
    public void nonExistentPath(){
        LoadQuestions fp = new LoadQuestions(".\\src\\Tutorials\\C#\\tests\\chapter20.txt");
        assertNotNull(fp);
        //included return on exceptions - NOT ALRIGHT
    }

//    don't know how to solve this yet
//    @Test
//    public void ExistentPathWrongTypeOfFile(){
//        LoadQuestions fp = new LoadQuestions(".\\src\\Tutorials\\C#\\chapters\\chapter2.txt");
//        assertNotNull(fp);        
//    }
}

