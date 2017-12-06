package data;

import java.io.*;

public class LoadTutorial
{

    private String line = null;
    private String texto = "";

    public LoadTutorial()
    {
    }

    public String loadChapter(String path)
    {
        if (path == null)
        {
            System.err.println("LoadTutorial: Invalid path");
            return "ERROR!";
        }

        try
        {
            FileReader fr = new FileReader((path));
            BufferedReader br = new BufferedReader(fr);

            while ((line = br.readLine()) != null)
            {
                texto += " " + line + "\n";
            }
//            System.out.println(Texto);
            br.close();

        } catch (FileNotFoundException ex)
        {
            System.err.println("Unable to open file");
            texto = "Unable to open file!";
        } catch (IOException ex)
        {
            System.err.println("Error reading file");
            texto = "Unable to read file!";
        }

        return texto;
    }

}
