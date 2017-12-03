package data;

import java.io.File;

public class LoadQuestions {

    public LoadQuestions(String path) {
        
        System.out.println(path);
        if(path == null)
            return;
        
        File dir = new File(path);
        File[] content = dir.listFiles();
        
        for(File f : content){
            System.out.println(f);
        }
        
        
    }
    
}
