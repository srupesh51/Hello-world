/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package needforcodeapplication;
import java.util.*;
/**
 *
 * @author Rupesh Kumar
 */
/*  This problem gives the message in the form of plain text */
final class MessageInterpreter
{
    private HashMap<Character,Integer> lowercase = new HashMap<Character,Integer>();
    private HashMap<Character,Integer> uppercase = new HashMap<Character,Integer>();
    private HashMap<Integer,Character> resultMsg = new HashMap<Integer,Character>();
    MessageInterpreter()
    {
           char ch = 'a';
           for(int i=1;i<=26;i++,ch++)
           {
               lowercase.put(ch,i);
               resultMsg.put(i, ch);
           }
           ch = 'A';
           for(int i=1;i<=26;i++,ch++)
           {
               uppercase.put(ch,i);
           }
           
    }        
    public boolean isPlainText(char option)
    {
        if(option == 'Y' || option == 'y')
        {
            return true;
        }
        return false;
    }
    public String getPlainText(String msg,String key)
    {
       int i = 0;
       int j = 0;
       String result = "";
       int len;
       if(msg.length() >= key.length())
       {
           len = msg.length();
       }
       else
       {
           len = key.length();
       }   
       int text1[] = new int[len];
       int text2[] = new int[len];
       int text3[] = new int[len];
       int index = 0,index1 = 0;
       while((i < msg.length()) && (j < key.length()))
       {
           char ch = msg.charAt(i);
           char ch1 = key.charAt(j);
           if(ch >= 'A' && ch <= 'Z')
           { 
               text1[index++] = uppercase.get(ch);
           }    
           else if(ch >= 'a' && ch <= 'z')
           {    
               text1[index++] = lowercase.get(ch);

           }    
           if(ch1 >= 'A' && ch1 <= 'Z')
           {    
               text2[index1++] = uppercase.get(ch1);
               
           }    
           else if(ch1 >= 'a' && ch1 <= 'z')
           {    
               text2[index1++] = lowercase.get(ch1);
               
           } 
           i++;
           j++;
       }
       
       while((i < msg.length()))
       {
          char ch = msg.charAt(i); 
          if(ch >= 'A' && ch <= 'Z')
           { 
               
               text1[index++] = uppercase.get(ch);
           }    
           else if(ch >= 'a' && ch <= 'z')
           {    
               text1[index++] = lowercase.get(ch);
           }     
          
          i++;
       }
       while((j < key.length()))
       {
          char ch1 = key.charAt(j); 
          if(ch1 >= 'A' && ch1 <= 'Z')
           {    
               text2[index1++] = uppercase.get(ch1);
           }    
           else if(ch1 >= 'a' && ch1 <= 'z')
           {    
               text2[index1++] = lowercase.get(ch1);  
           } 
          j++;
       }
       int letter;
       for(int k=0;k<text3.length;k++)
       {
           if(text1[k] != 0 || text2[k] != 0)
           {
               if(text1[k] < text2[k])
               {
                   letter = ((26)-(text2[k] - text1[k]))-1;
                   
               }
               else if((text1[k] - text2[k]) == 0)
               {
                   letter = 26-1;
               }
               else
               {
                   letter = ((text1[k] - text2[k])%(26))-1;
               }    
               result += resultMsg.get(letter);
           }    
       }
       return result;
        
       
    }        
    public String getCipherText(String msg,String key)
    {
        int i = 0;
       int j = 0;
       String result = "";
       int len;
       if(msg.length() >= key.length())
       {
           len = msg.length();
       }
       else
       {
           len = key.length();
       }   
       int text1[] = new int[len];
       int text2[] = new int[len];
       int text3[] = new int[len];
       int index = 0,index1 = 0;
       while((i < msg.length()) && (j < key.length()))
       {
           char ch = msg.charAt(i);
           char ch1 = key.charAt(j);
           if(ch >= 'A' && ch <= 'Z')
           { 
               text1[index++] = uppercase.get(ch);
           }    
           else if(ch >= 'a' && ch <= 'z')
           {    
               text1[index++] = lowercase.get(ch);

           }    
           if(ch1 >= 'A' && ch1 <= 'Z')
           {    
               text2[index1++] = uppercase.get(ch1);
               
           }    
           else if(ch1 >= 'a' && ch1 <= 'z')
           {    
               text2[index1++] = lowercase.get(ch1);
               
           } 
           i++;
           j++;
       }
       
       while((i < msg.length()))
       {
          char ch = msg.charAt(i); 
          if(ch >= 'A' && ch <= 'Z')
           { 
               
               text1[index++] = uppercase.get(ch);
           }    
           else if(ch >= 'a' && ch <= 'z')
           {    
               text1[index++] = lowercase.get(ch);
           }     
          
          i++;
       }
       while((j < key.length()))
       {
          char ch1 = key.charAt(j); 
          if(ch1 >= 'A' && ch1 <= 'Z')
           {    
               text2[index1++] = uppercase.get(ch1);
           }    
           else if(ch1 >= 'a' && ch1 <= 'z')
           {    
               text2[index1++] = lowercase.get(ch1);  
           } 
          j++;
       }
       int letter;
       for(int k=0;k<text3.length;k++)
       {
           if(text1[k] != 0 || text2[k] != 0)
           {    
           letter = ((text1[k] + text2[k]) % (26)) + 1;
           result +=  resultMsg.get(letter);
           } 
       }
       return result;
        
    }
    public String readmessage(String msg,String key,char option)
    {
        if(isPlainText(option))
        {
            return getCipherText(msg,key);
        }    
        return getPlainText(msg,key);
    }        
}

public class NeedForCodeApplication {

    /**
     * @param args the command line arguments
     */
    
    
    
    
    
    public static void main(String[] args) {
        // TODO code application logic here
    
    MessageInterpreter mit = new MessageInterpreter();
    System.out.print(mit.readmessage("Qntzjxssgdligiowvqudyatt!","Venturesityventuresityve!",'N')+" ");
    
    }
    
}
