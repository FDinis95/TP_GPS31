package data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LoadTutorial {
    String line = null;
    String chapterNum = null;
    public LoadTutorial(String path, int chapter){
        
        if(path == null){
            System.err.println("LoadTutorial: Invalid path");
            return;
        }
        
        if(chapter < 0 || chapter > 9){
            System.err.println("Chapter not available!");
            return;
        }
        
        chapterNum = ("chapter" + chapter + ".txt");
        
        try{
        
            FileReader fr = new FileReader((path + "\\" + chapterNum));
            BufferedReader br = new BufferedReader(fr);
            
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
            
            br.close();
        
        }
        catch(FileNotFoundException ex){
            System.err.println("Unable to open file");
        }
        catch(IOException ex){
            System.err.println("Error reading file");
        }
    }
    
}
