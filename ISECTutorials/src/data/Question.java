package data;

public class Question {
    private String question;
    private String answers[];
    private String correct;
    private int index;
    
    Question(String string[]){
        this.question = string[0];
        this.correct = string[5];
        for (int i=1; i<5; i++){
            this.answers[i-1]=string[i];
            if(string[i].equals(correct))
                this.index=i-1;
        }
    }

    public String getQuestion() {
        return question;
    }

    public String[] getAnswers() {
        return answers;
    }

    public String getCorrect() {
        return correct;
    }

    public int getIndex() {
        return index;
    }
}
