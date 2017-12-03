package data;

import java.io.*;
import java.util.List;

public class LoadQuestions {

    private String diagnose;
    private List<Question> question;
    String line = null;
    String array[] = new String[6];

    public LoadQuestions(String path) {

//        System.out.println(path);
        if (path == null) {
            return;
        }

        diagnose = path + "\\diagnose.txt";

        System.out.println(diagnose);

        try {
            int index = 0;
            int questionNumber = 60;
            
            if(questionNumber<0 || questionNumber > 49){
                System.err.println("Question number invalid");
                //must validate between 0 and 12
                //and between 0 and 49 accordind to type...
            }
            
            FileReader fr = new FileReader(diagnose);
            BufferedReader br = new BufferedReader(fr);

            while ((line = br.readLine()) != null) {
                if (line.contains("Q" + questionNumber + " ")) {
                    array[index] = line;
                    System.out.println(array[index]);
                    index++;
                    for (int i = 1; i < 6; i++) {
                        array[index] = br.readLine();
                        System.out.println(array[index]);
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
    }

}
