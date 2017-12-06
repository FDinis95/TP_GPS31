package isectutorials;

import data.FindPath;
import data.LoadQuestions;
import data.LoadTutorial;
import data.Progression;
import java.util.Random;
import logic.ValidateTestResult;
import ui.CreateMainMenu;

public class ISECTutorials
{

    public static void main(String[] args)
    {

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
        LoadQuestions lq = new LoadQuestions(Sfp[i] + "\\tests\\chapter" + 4 + ".txt");

//        System.out.println(test2);
//        CreateMainMenu first = new CreateMainMenu();
//        System.err.println("passed");
        int array1[] = new Random().ints(0, 50).distinct().limit(20).toArray();
        int array2[] = array1;
        int array3[] =
        {
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
        };
        Progression pro = new Progression();

        ValidateTestResult tst = new ValidateTestResult();
        tst.validateEvaluationTest(array1, array2, array3, pro);
        int array4[] = pro.getChapter();
//        for (int index = 0; index < array4.length; index++) {
//            System.out.println(array4[i]);
//        }
    }

}
