package logic;

import data.Progression;
import java.util.ArrayList;

public class ValidateTestResult {

    //Array to store chapters done in evaluation test
    private ArrayList<Integer> chap = new ArrayList<>(10);

    public ValidateTestResult() {
        //fill the array with '0'
        for (int i = 0; i < 10; i++) {
            chap.add(0);
        }
    }

    public int validateEvaluationTest(int answers[], int corrects[], int chapter[], Progression pro) {
        int n = 0;
        try {
            if (!(answers.length != 20 || corrects.length != 20 || chapter.length != 20)) {
                for (int i = 0; i < answers.length; i++) {
                    if (answers[i] == corrects[i]) {
                        chap.set(chapter[i], chap.get(chapter[i]) + 1);//increments the value on chap array
                        n++;
                    }
                }
//            System.out.println(chap);
                updateProgression(pro);
                return n;

            } else {
                System.err.println("Array size is incorrect");
                return -1;
            }
        } catch (NullPointerException ex) {
            System.err.println("Null array");
            return -2;
        }

    }

    public int validateChapterTest(int answers[], int corrects[], int chapter, Progression pro) {
        int n = 0;
        try {

            if (!(answers.length != 7 || corrects.length != 7)) {
                for (int i = 0; i < answers.length; i++) {
                    if (answers[i] == corrects[i]) {
                        n++;
                    }
                }
                if (n > 3) {
                    updateProgressionAfterChapter(chapter, pro);
                }

                pro.setCorrect(n);
                pro.setTotalNumberOfQuestionsAnswered();

                return n;
            } else {
                System.err.println("arrays size incorrect");
                return -1;
            }
        } catch (NullPointerException ex) {
            System.err.println("Null array");
            return -2;
        }
    }

    private void updateProgression(Progression pro) {
        for (int i = 0; i < chap.size(); i++) {
            //if the number on chap array index 'i' is greater then '1' setChapter done
            if (chap.get(i) > 1) {
                pro.setChapter(i);
            }
        }
    }

    /*private*/
    public void updateProgressionAfterChapter(int chapter, Progression pro) {
        //update the chapter progression array until the chapters done
        if (chapter >= 0 && chapter < 10) {
            pro.setChapterTests(chapter);
            pro.setChapter(chapter);
        }
    }
}
