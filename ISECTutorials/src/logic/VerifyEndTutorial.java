package logic;

import data.Progression;

public class VerifyEndTutorial {
    
    public VerifyEndTutorial(){}

    public boolean verify(Progression pro) {

        int completedChapters[] = pro.getChapterTests();
        for (int i = 0; i < 10; i++) {
            if (completedChapters[i] == 0) {
                return false;
            }
        }
        return true;
    }
   
}
