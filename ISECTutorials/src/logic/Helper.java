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
        var = 0;
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
            } else
            {
                if (var >= 2)
                {
                    stars[j] = "src/logic/images/star.png";
                    var -= 2;
                }
            }
//            System.out.println(stars[j]);
        }
//        "images/star.png"
//        "images/star-half.png"
//        "images/star-outline.png"
        return stars;

    }

    public String messages(Progression pro)
    {
        String message = "Woops!";
        chapters = pro.getChapter();
        var = 0;
        for (int i = 0; i < 10; i++)
        {
            var += chapters[i];
        }
        System.err.println(var);
        if (var == 0)
        {
            message = "Only 99% of people went as far as you did!";
        }
        if (var > 0 && var <= 2)
        {
            message = "Congrats you passed the easy ones!";
        }
        if (var > 2 && var <= 4)
        {
            message = "Things are getting intense!";
        }
        if (var > 4 && var <= 6)
        {
            message = "You're actually getting good at this!";
        }
        if (var > 6 && var <= 8)
        {
            message = "Wow! You got here so fast! ";
        }
        if (var > 8 && var <= 9)
        {
            message = "Most people dont come this far!";
        }
        if (var > 8 && var <= 9)
        {
            message = "You got them all!!";
        } 
        return message;
    }

}
