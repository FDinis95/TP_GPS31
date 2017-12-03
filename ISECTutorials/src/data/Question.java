package data;

public class Question {
    private String question;
    private String answers[];
    private int correct;
    
    Question(String string[]){
        this.question = string[0];
        this.correct = Integer.parseInt(string[5]);
        for (int i=1; i<5; i++){
            this.answers[i-1]=string[i];
        }
    }

    public String getQuestion() {
        return question;
    }

    public String[] getAnswers() {
        return answers;
    }

    public int getCorrect() {
        return correct;
    }
}
