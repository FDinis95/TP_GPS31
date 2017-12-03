package data;

import java.io.*;

public class LoadTutorial {
    String line = null;
    String Texto = "";
    
    public LoadTutorial(String path){
        
        LoadChapter(path);
    }
    
    private String LoadChapter(String path){
        if(path == null){
            System.err.println("LoadTutorial: Invalid path");
        }
        
        try{
        
            FileReader fr = new FileReader((path));
            BufferedReader br = new BufferedReader(fr);
            
            while((line = br.readLine()) != null){
                Texto += line;
            }
            
            System.out.println(Texto);
            
            br.close();
        
        }
        catch(FileNotFoundException ex){
            System.err.println("Unable to open file");
        }
        catch(IOException ex){
            System.err.println("Error reading file");
        }
        
        return Texto;
    }
    
}
