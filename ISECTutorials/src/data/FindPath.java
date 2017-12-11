package data;

import java.io.File;

public class FindPath
{

    private String path[] = null;
    private String name[] = null;
    private int index = 0;
    private int size = 0;

    public FindPath()
    {

        File dir = new File("./src/Tutorials");
        File[] content = dir.listFiles();
        if (content != null)
        {
            for (File f : content)
            {
                if (f.isDirectory())
                {
                    size++;
                }
            }
            path = new String[size];
            name = new String[size];
            for (File f : content)
            {
                if (f.isDirectory())
                {
                    path[index] = f.getPath();
                    name[index] = f.getName();
                    index++;
                }
            }
////        verification
//        for(int j=0;j<path.length; j++){
//            System.out.println(path[j]);
//            System.out.println(name[j]);
//        }
        } else
        {
            System.err.println("Tutorials folder inexistent or empty!");
        }
    }
    
    public String[] getPath()
    {
        return path;
    }

    public String[] getName()
    {
        return name;
    }
}
