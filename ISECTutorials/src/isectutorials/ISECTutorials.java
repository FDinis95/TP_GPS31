package isectutorials;

import data.FindPath;
import data.LoadQuestions;
import data.LoadTutorial;

public class ISECTutorials {

    public static void main(String[] args) {
        
        String test2 = null;
        
        int i = 0;
        int chapt = 0;
        FindPath fp = new FindPath();
        String[] Sfp = new String[fp.getPath().length];
        
        Sfp[i] = fp.getPath()[i];
//        System.out.println(Sfp[i]);
        
        System.out.println("This is main!");
        
//        new UpdateProgression();
//        LoadQuestions lq = new LoadQuestions(Sfp[i]+ "\\diagnose.txt");
        test2 = new LoadTutorial(Sfp[i] + "\\chapters\\chapter" + chapt + ".txt").loadChapter(Sfp[i] + "\\chapters\\chapter" + chapt + ".txt");
        
        System.out.println(test2);
    }
    
}
