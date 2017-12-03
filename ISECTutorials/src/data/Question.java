package data;

public class Question {
    private String question;
    private String answers[] = new String[4];
    private int correct;
    
    Question(String string[]){
        
        //for testing the strings
        for(int i=0;i<string.length;i++){
        System.out.println(string[i]);
        }
        
        this.question = string[0];
        this.correct = Integer.parseInt(string[5]);
        for (int index=0; index<4; index++){
            this.answers[index]=string[index+1];
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
