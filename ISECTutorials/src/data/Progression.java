package data;

public class Progression
{

    private int correct;
    private int totalNumberOfQuestionsAnswered;
    private int chapter[];
    private int chapterTests[];

    public Progression()
    {
        this.correct = 0;
        this.totalNumberOfQuestionsAnswered = 0;
        this.chapter = new int[10];
        this.chapterTests = new int[10];
    }

    public int getCorrect()
    {
        return correct;
    }

    public void setCorrect(int correct)
    {
        this.correct += correct;
    }

    public int getTotalNumberOfQuestionsAnswered()
    {
        return totalNumberOfQuestionsAnswered;
    }

    public void setTotalNumberOfQuestionsAnswered()
    {
        this.totalNumberOfQuestionsAnswered += 7;
    }

    //returns the array
    public int[] getChapter()
    {
        return chapter;
    }

    //num is the chapter number
    public void setChapter(int num)
    {
        this.chapter[num] = 1;
    }

    //returns the array
    public int[] getChapterTests()
    {
        return chapterTests;
    }

    //num is the chapter number
    public void setChapterTests(int num)
    {
        this.chapterTests[num] = 1;
    }

}
