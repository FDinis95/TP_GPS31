package data;

import java.io.File;

public class OpenFile {

    public OpenFile() {
        System.out.println("This is data starting!");
        
        File dir = new File("./test");
        File[] content = dir.listFiles();
        for(File f : content)
            System.out.println(f.getAbsolutePath());
        System.out.println("TEST2");
           
    }   
}
