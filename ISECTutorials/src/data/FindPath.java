package data;

import java.io.File;

public class FindPath {
    private String path[] = null ;
    private String name[] = null;
    int i= 0;
    
    public FindPath(){
        
        File dir = new File("./test");
        File[] content = dir.listFiles();
        path = new String[content.length];
        name = new String[content.length];
        for(File f : content){
            path[i] = f.getPath();
            name[i] = f.getName();
            i++;
        }
//        verification
//        for(int j=0;j<path.length; j++){
//            System.out.println(path[j]);
//            System.out.println(name[j]);
//        }
    };

    public String[] getPath() {
        return path;
    }

    public String[] getName() {
        return name;
    }
}
