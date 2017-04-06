
package problem3;

/**
 *
 * @author Nerys Jimenez
 */

import java.util.*; 
public class Problem3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Scanner keyboard = new Scanner (System.in);
    ArrayList<String> list = new ArrayList<String>();
    int [] count;
    String line;
    String str =""; 
    line = keyboard.nextLine();  
    line = line.toLowerCase(); //ignore upper case
    
    //split words, ignores special characters and stores words into array list
    for(int i = 0; i < line.length(); i++)
    {
        if(line.charAt(i) >= 'a' && line.charAt(i) <= 'z')
        {
            str +=  line.charAt(i);
            if(i == line.length() -1)
                list.add(str);
        }
        else{
            list.add(str);
            str = "";
        }
    }
   
    count = new int[list.size()];
    Arrays.fill(count, 1); //fill the list with 1s
    Collections.sort(list); //sort the list of words
    int sum = 0;
    //taking each word in the list and doing a search to find duplicates
    //if duplicates then increase the count for that word
    for(int j = 0; j < list.size(); j++)
    {
        for(int k = j + 1; k < list.size(); k++)
        {
            sum = 0;
            if(list.get(j).equals(list.get(k)))
            {
                sum = count[j] + 1;
                count[j] = sum;
                list.remove(k);
                --k;
            }
        }
    }
      
    //print out result
    for(int s = 0; s < list.size(); s ++)
    {
        System.out.println(list.get(s) +"("+count[s]+")");
    }
    
   }
    
}
