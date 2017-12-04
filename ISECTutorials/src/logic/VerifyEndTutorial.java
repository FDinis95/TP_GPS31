
package logic;

public class VerifyEndTutorial {
    private int completed[];
    private int done;
    
    VerifyEndTutorial(){
        this.completed= new int[10];    }
    
    public bool isOver(){
        this.completed = .GetChapterTests//get do Progression criado no validate tests
        int done = 0;
        for (int i=0;i<10;i++)
            if (completed[i]==1)
                done++;
        
        if (done==10)
            return 1;
                    else
            return 0;
    }
    
}
