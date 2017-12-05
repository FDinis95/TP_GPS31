package logic;

import data.Progression;
import java.util.ArrayList;

public class ValidateTestResult {
    //Array to store chapters done in evaluation test
    private ArrayList<Integer> chap;

    public ValidateTestResult() {
        chap = new ArrayList<>(10);
         
        //fill the array with '0'
        for (int i = 0; i < 10; i++) {
                 chap.add(0);
        }
    }

    public int validateEvaluationTest(int answers[], int corrects[], int chapter[], Progression pro) {
        int n = 0;
        
        if (answers.length != 20 || corrects.length != 20 || chapter.length != 20) {
            for (int i = 0; i < answers.length; i++) {
                if (answers[i] == corrects[i]) {
                    int value = chap.get(i);//get the value on the chap[i]
                    chap.add(chapter[i],value++);//increments the value on chap array
                }
            }
            updateProgression(pro);
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
                updateProgressionAfterChapter(chapter, pro); //verify if can be the same funtion or another one
            }
            return n;
        } else {
            System.err.println("arrays size incorrect");
            return -1;
        }
    }

    private void updateProgression(Progression pro) {
        
        for (int i = 0; i < chap.size(); i++) {
            //if the number on chap array index 'i' is greater then '1' setChapter done
              if(chap.get(i) > 1)
                  pro.setChapter(i);
        }

    }

    private void updateProgressionAfterChapter(int chapters, Progression pro) {
        //update the chapter progression array until the chapters done

        pro.setChapter(chapters);
    }
}
