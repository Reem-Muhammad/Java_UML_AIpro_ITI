import java.io.*;
import java.util.List;
import java.util.ArrayList;


public class FileToList{

  private String filePath;

  public FileToList(String filePath){
    this.filePath = filePath;
  }

  public List<String[]> convertFileToList(){
    List<String[]> convertedFile = new ArrayList<String[]>();
    try{
      //open the file
      FileReader file=new FileReader(this.filePath);
      BufferedReader br=new BufferedReader(file);
      String line;
      //read line by line
      while( (line=br.readLine() ) != null){
        //convert each line to array of strings
        convertedFile.add(line.split(", ")); //entries separated by commas followed by space
      }
    }
    catch (Exception e){
        System.out.println("error");
    }

    return convertedFile;
  }

}
