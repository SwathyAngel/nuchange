import java.lang.*;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class urldatabase {
    public static void main(String args[]){
        String command = new String();
        Map<String, String> links= new HashMap<String,String>();
        Scanner read = new Scanner(System.in);
        do{
            command = read.nextLine();
            if(!command.equals("exit")){
                String[] words=command.split(" ");
                if(words[0].equals("storeurl")){
                    links.put(words[1],"0");
                    String[] urlwords = words[1].split(".com");
                    links.put(words[1],"0 "+urlwords[0]);
                }
                else if(words[0].equals("get")){
                    String x = links.get(words[1]);
                    String[] entrywords = x.split(" ");
                    int count = Integer.parseInt(entrywords[0]);
                    count++;
                    links.replace(words[1],String.valueOf(count)+" "+entrywords[1]);
                    System.out.println(entrywords[1]);
                }
                else if(words[0].equals("count")){
                    System.out.println(links.get(words[1]).split(" ")[0]);
                }
                else if(words[0].equals("list")){
                    String jsonentry = "[";
                    for(String entry: links.keySet()){
                        jsonentry=jsonentry+"{\"url\":\""+entry+"\",\"count\":\""+links.get(entry).split(" ")[0]+"\"},";
                    }
                    jsonentry+="]";
                    System.out.println(jsonentry);
                }
            }
        }while(!command.equals("exit"));
    }
}