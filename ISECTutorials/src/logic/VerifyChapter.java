package logic;

import data.Progression;

public class VerifyChapter {

    public VerifyChapter() {}

    public int[] getUnlockedChapters(Progression pro) {
        int array[] = new int[10];
        try {
            return pro.getChapterTests();
        } catch (NullPointerException ex) {
            System.err.println("Progression chapters is null");
        }
        return array;
    }

}
