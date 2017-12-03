package isectutorials;

import data.FindPath;
import data.OpenFile;
import java.util.Arrays;
import logic.UpdateProgression;

public class ISECTutorials {

    public static void main(String[] args) {

        System.out.println("This is main!");
        
        new OpenFile();
        new UpdateProgression();
        FindPath fd = new FindPath();
        System.out.println(Arrays.toString(fd.getPath()));
    }
    
}
