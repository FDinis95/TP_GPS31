package data;

import java.io.File;

public class LoadQuestions {
    
    private String diagnose;
    private String chapters;
    private String test;
    
    public LoadQuestions(String path) {
        
        System.out.println(path);
        if(path == null)
            return;
        
        diagnose = path + "\\Diagnose.txt";
        
        System.out.println(diagnose);
        
        File dir = new File(path);
        File[] content = dir.listFiles();
        
        for(File f : content){
            System.out.println(f);
        }
        
    }
    
}
