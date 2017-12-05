package isectutorials;

import data.FindPath;
import data.LoadQuestions;
import data.LoadTutorial;
import ui.CreateMainMenu;

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
        test2 = new LoadTutorial().loadChapter(Sfp[i] + "\\chapters\\chapter" + chapt + ".txt");
        LoadQuestions lq = new LoadQuestions(Sfp[i]+ "\\tests\\chapter"+4+".txt");
        
//        System.out.println(test2);
        
//        CreateMainMenu first = new CreateMainMenu();
//        System.err.println("passed");
    }
    
}
