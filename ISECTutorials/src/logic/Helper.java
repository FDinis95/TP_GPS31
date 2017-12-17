package logic;

import data.Progression;

public class Helper
{

    String[] stars;
    int[] chapters;
    int var;

    public Helper()
    {
    }

    public String[] fillStars(Progression pro)
    {
        stars = new String[5];
        chapters = pro.getChapter();
        var=0;
        for (int i = 0; i < 10; i++)
        {
            var += chapters[i];
        }
        for (int j = 0; j < 5; j++)
        {
            if (var == 0)
            {
                stars[j] = "src/logic/images/star-outline.png";
            }
            if (var == 1)
            {
                stars[j] = "src/logic/images/star-half.png";
                var -= 1;
            }
            else if (var >= 2)
            {
                stars[j] = "src/logic/images/star.png";
                var -= 2;
            }
//            System.out.println(stars[j]);
        }
//        "images/star.png"
//        "images/star-half.png"
//        "images/star-outline.png"
            return stars;
        
    }

}
