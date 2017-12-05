package logic;

import data.Progression;

public class ValidateTestResult {

    public ValidateTestResult() {
    }

    public int validateEvaluationTest(int answers[], int corrects[], int chapter[]) {
        int n = 0;
        if (answers.length != 20 || corrects.length != 20 || chapter.length != 20) {
            for (int i = 0; i < answers.length; i++) {
                if (answers[i] == corrects[i]) {
                    n++;
                }
            }
            updateProgression(chapter);
            return n;
        } else {
            System.err.println("arrays size incorrect");
            return -1;
        }
    }

    public int validateChapterTest(int answers[], int corrects[], int chapter, Progression pro) {
        int n = 0;
        if (answers.length != 7 || corrects.length != 7) {
            for (int i = 0; i < answers.length; i++) {
                if (answers[i] == corrects[i]) {
                    n++;
                }
            }
            if (n > 3) {
//        updateProgressionAfterChapter(chapter, pro); //verify if can be the same funtion or another one
            }
            return n;
        } else {
            System.err.println("arrays size incorrect");
            return -1;
        }
    }

    private void updateProgression(int chapters[]) {
        int array[] = null;
        for (int i = 0; i < chapters.length; i++) {
            //incomplete 
            //verify if there is a duplicate number in the arrar, 
            //if there is uses that number to update progression
        }
    }
    
    private void updateProgressionAfterChapter(int chapters, Progression pro) {
        //bla bla bla
    }
}


//    public void UpdateProgression(int[]i,int[]j,int k,Progression pro,Question ques ){
//        int correct;
//        int questCorrect;
//        int total;
//        if(ValidateResults(i[],j[],k,pro,ques) == 1)
//            
//            for(int i = 0;i< 9 ;i++)
//                if(0==chapter[i])
//                    pro.setChapter(chapter+1);
//}
//        //Function to evaluation test
//        int correct;
//        int questCorrect;
//        int total;
//        int n = 0;
//        questCorrect = ques.getCorrect();
//        
//        correct = pro.getCorrect();
//        total = pro.getTotal();
//        
//        if(correct > total/2)
//                n = 1;
