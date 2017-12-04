package logic;
import data.Progression;
import data.Question;
public class ValidateTestResult {

    public ValidateTestResult(int[] i, int[] j, int[] k) {
        System.out.println("This is logic starting");
        
    }
       public ValidateTestResult(int[] i, int[] j, int k) {
        System.out.println("This is logic starting");
        
    }

 
    public int ValidateResults(int []i, int[]j, int[]k, Progression pro, Question ques){
        //Function to evaluation test
        
        int correct;
        int questCorrect;
        int total;
        int n = 0;
        questCorrect = ques.getCorrect();
        
        correct = pro.getCorrect();
        total = pro.getTotal();
        
        if(correct > total/2)
                n = 1;
    
    return n;
    
    }
    public void UpdateProgression(int[]i,int[]j,int k,Progression pro,Question ques ){
        int correct;
        int questCorrect;
        int total;
        
//        if(ValidateResults(i[],j[],k,pro,ques) == 1)
//            
//            for(int i = 0;i< 9 ;i++)
//                if(0==chapter[i])
//                    pro.setChapter(chapter+1);
        

}

}