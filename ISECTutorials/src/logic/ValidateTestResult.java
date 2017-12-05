package logic;

import data.Progression;

public class ValidateTestResult {

    public ValidateTestResult() {
    }

    public int validateEvaluationTest(int answers[], int corrects[], int chapter[]) {
        int n = 0;
        int chap[] = null;
        if (answers.length != 20 || corrects.length != 20 || chapter.length != 20) {
            for (int i = 0; i < answers.length; i++) {
                if (answers[i] == corrects[i]) {
                    int j = chapter[i];
                    chap[j]++;
                    n++;
                }
            }
            
            return n;
         //   updateProgression(chap);
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
        updateProgressionAfterChapter(chapter, pro); //verify if can be the same funtion or another one
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
            //   if(chapters[i]!=0)
                    
            //incomplete 
            
            //verify if there is a duplicate number in the arrar, 
            //if there is uses that number to update progression
                    }
    }
    
    private void updateProgressionAfterChapter(int chapters, Progression pro) {
         //update the chapter progression array until the chapters done
        
             pro.setChapter(chapters);}
    }