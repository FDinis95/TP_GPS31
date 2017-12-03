package data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LoadQuestions {

    private List<Question> question = new ArrayList<>();
    String line = null;

    public LoadQuestions(String path) {

        if (path.contains("diagnose")) {
            int n, m = 0;
            Random rand = new Random();
            //rand.nextInt((max - min) + 1) + min; sendo que min e max variam a incrementos de 5 entre 0-49
            for(int i = 1; i<11;i++){
                n = rand.nextInt((((5*i)-1) - ((5*i)-5)) + 1) + ((5*i)-5);
                loadOne(path, n);
            }
            
        }

    }

    private void loadOne(String path, int questionNumber) {
        String array[] = new String[6];
        if (path == null) {
            System.err.println("LoadQuestions: Invalid path");
            return;
        }

        try {
            int index = 0;
            if (questionNumber < 0 || questionNumber > 49) {
                System.err.println("Question number invalid");
            }

            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);

            while ((line = br.readLine()) != null) {
                if (line.contains("Q" + questionNumber + " ")) {
                    array[index] = line;
                    //System.out.println(array[index]);
                    index++;
                    for (int i = 1; i < 6; i++) {
                        array[index] = br.readLine();
                        //System.out.println(array[index]);
                        index++;
                    }
                }
            }
            br.close();
        } catch (FileNotFoundException ex) {
            System.err.println("Unable to open file");
        } catch (IOException ex) {
            System.err.println("Error reading file");
        }

        Question q = new Question(array);
        question.add(q);
    }

}
