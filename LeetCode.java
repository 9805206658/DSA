import java.util.*;
public class LeetCode
{
    static class  Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int idx = 0;
        for (int i = 0; i < n; i++) {
            char ch = chars[i];
            int count = 0;
            while (i < n && chars[i] == ch) {
                count++;
                i++;
            }
            if (count == 1) {
                chars[idx++] = ch;
            } else {
                chars[idx++] = ch;
                for (char digit : Integer.toString(count).toCharArray()) {
                    chars[idx++] = digit;
                }
            }
            i--;
        }
        return idx;
    }
}
  public static void main(String args[])
    {
        Solution s = new Solution();
        char[] chars = {'a','a','a','b','c','c'};
        
       System.out.println( s.compress(chars));
       for(int i=0; i<chars.length; i++)
       {
        System.out.println(chars[i]);
       }
      
    }
}