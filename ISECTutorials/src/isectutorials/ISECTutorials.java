package isectutorials;

import data.FindPath;
import data.LoadQuestions;
import data.OpenFile;
import java.util.Arrays;
import logic.UpdateProgression;

public class ISECTutorials {

    public static void main(String[] args) {
        
        int i = 0;
        FindPath fp = new FindPath();
        String[] Sfp = new String[fp.getPath().length];
        
        Sfp[i] = fp.getPath()[i];
        System.out.println(Sfp[i]);
        
        System.out.println("This is main!");
        
        new OpenFile();
        new UpdateProgression();
        LoadQuestions lq = new LoadQuestions(Sfp[i]);
    }
    
}
