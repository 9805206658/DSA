public class Part1
{
      public static boolean isPalindrome(String s)
    {
        if(s.length() == 1)
        {
            return true;
        }
        int left= 0;
        int right = s.length() - 1;
        while(left < right)
        {  if(s.charAt(left) != s.charAt(right))
            { return false; }
            left ++;
            right --;
        }
        return true;
    }


  
    
    static int maxLen = 0;
   static int lo = 0;
    public static String longestPalindrome(String s) {
        char[] input = s.toCharArray();
        if(s.length() < 2) {
            return s;
        }
       for(int i = 0; i<input.length; i++) {
            expandPalindrome(input, i, i);
            expandPalindrome(input, i, i+1);
        }
        return s.substring(lo, lo+maxLen);
    }
    
    public static void expandPalindrome(char[] s, int j, int k) {
        while(j >= 0 && k < s.length && s[j] == s[k]) {
            j--;
            k++;
        }
        if(maxLen < k - j - 1) {
            System.out.println("j:"+j);
            System.out.println("k:"+k);
            System.out.println();
            maxLen = k - j - 1;
            lo = j+1;
            System.out.println("maxLen"+maxLen);
            System.out.println("lo"+lo);
        }
    }
public static void main(String args[])
    {
        String str = "1234";
        System.out.println('1'-48);
        
    }
}