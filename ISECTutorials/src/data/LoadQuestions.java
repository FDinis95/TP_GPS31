package data;

import java.io.*;
import java.util.List;

public class LoadQuestions {
    
    private String diagnose;
    private List<Question> question;
//    private String chapters;
//    private String test;
    String line = null;
    
    public LoadQuestions(String path) {
        
//        System.out.println(path);
        if(path == null)
            return;
        
        diagnose = path + "\\1.txt";
        
        System.out.println(diagnose);
        
        try{
            FileReader fr = new FileReader(diagnose);
            
            BufferedReader br = new BufferedReader(fr);
            
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
            
            br.close();
        }
        catch(FileNotFoundException ex){
            System.out.println("Unable to open file");
        }
        
        catch(IOException ex){
            System.out.println("Error reading file");
        }
    }
    
}
