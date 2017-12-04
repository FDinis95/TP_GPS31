package data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LoadQuestions {

    private List<Question> question = new ArrayList<>();
    String line = null;

    public LoadQuestions(String path) {
        if (path == null) {
            System.err.println("LoadQuestions Const: Invalid path");
            return;
        }

        if (path.contains("diagnose")) {
            int n, m = 0;
            for (int i = 1; i < 11; i++) {
                n = randomNum(i);
                m = randomNum(i);
                while (m == n) {
                    m = randomNum(i);
                }
                loadOne(path, n);
                loadOne(path, m);
            }
        }

        if (path.contains("chapter")) {
            //seven questions from a pool of twelve
            int[] array = new Random().ints(0, 11).distinct().limit(7).toArray();
            for (int i = 0; i < 7; i++) {
                //System.err.println(array[i]);
                loadOne(path, array[i]);
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
                }if (line.contains("Q" + questionNumber+1+ " ")) {
                    System.err.println("Invalid questions format");
                    return;
                }
            }
            Question q = new Question(array);
            question.add(q);
            br.close();
        } catch (FileNotFoundException ex) {
            System.err.println("Unable to open file");
        } catch (IOException ex) {
            System.err.println("Error reading file");
        }
    }

    private int randomNum(int num) {
        Random rand = new Random();
        //rand.nextInt((max - min) + 1) + min; sendo que min e max variam a incrementos de 5 entre 0-49
        int x = rand.nextInt((((5 * num) - 1) - ((5 * num) - 5)) + 1) + ((5 * num) - 5);
        return x;
    }

}
