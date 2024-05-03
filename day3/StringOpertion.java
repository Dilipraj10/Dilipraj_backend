package stringopertion;

import java.util.Arrays;

public class StringOpertion {
	
	public static boolean panagram(String str) //Panagram
	{
		int[] freq=new int[26];
		str=str.toUpperCase();
		for(int i=0; i<str.length();i++) {
			freq[str.charAt(i)-65]++;
		}
		
		for(int i=0; i<freq.length;i++) {
			if(freq[i]==0)
			{
				return false;
			}
		}
		return true;
	}
	
	
	public boolean ispalindrom(String str) //ispalindrome
	{
		int i=0;
		int j=str.length()-1;
		while(i<j)
		{
			if(str.charAt(i)!=str.charAt(j))
			{
				return false;
			}
			i++;
			j--;
		}
		return true;
		
	}
	
	public void isAanaram(String str1,String str2) //isanagram
	{
		int n1=str1.length();
		int n2=str2.length();
		
		if(n1==n2) {
			char[] ch1=str1.toCharArray();
			char[] ch2=str2.toCharArray();
			
			Arrays.sort(ch1);
			Arrays.sort(ch2);
			
			if(Arrays.equals(ch1, ch2))
			{
				System.out.println("Anagram");
			}
			else
			{
				System.out.println("Not a Anagram");
			}
		}
		else
		{
			System.out.println("Not a Anagram");
		}
	}
	
	public void countWords(String str1) //countWords
	{
		int count = 1;
		 
        for (int i = 0; i < str1.length() - 1; i++)
        {
            if ((str1.charAt(i) == ' ') && (str1.charAt(i + 1) != ' '))
            {
                count++;
            }
        }
        System.out.println("Number of words in a string : " + count);
	}
	
	public void countEachChara(String str1) //countEachChara
	{
		 int[] charCounts = new int[256]; 

	        for (int i = 0; i < str1.length(); i++) {
	            char c = str1.charAt(i);
	            int index = (int) c; 
	            charCounts[index]++;
	        }
	        
	        System.out.println("Character Counts:");
	        for (int i = 0; i < charCounts.length; i++) {
	            if (charCounts[i] != 0) {
	                System.out.println((char) i + ": " + charCounts[i]);
	            }
	        }
	}
	
	public int countVowels(String str1) //countVowels
	{
		str1 = str1.toLowerCase(); 
        int count =0;
        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
               count++;
            }
        }
		return count;
	}
	
	public boolean allVowels(String str1) //allVowels
	{
		str1 = str1.toLowerCase(); 
        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            if (ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u') {
                return false; 
            }
        }
        return true;
	}
	
	
	public void reverseWords(String str1) //reverseWords
	{
		char ch[] = str1.toCharArray();
		String s =""; 
		
		for (int i = ch.length -1; i >= 0; i--) {
			s = s+ ch[i];
		}
		System.out.println(s.toString());
	}

	
	public static void main(String[] args) {
		String str1="wow man";
		String str2="john";
		StringOpertion ob= new StringOpertion();
//		System.out.println("panagram" + ob.panagram(str1));	
//		System.out.println("palindrom" + ob.ispalindrom(str1));	
//		ob.isAanaram(str1, str2);
//		ob.countWords(str1);
//		ob.countEachChara(str1);
//		System.out.println(ob.countVowels(str1));
//		System.out.println(ob.allVowels(str1));
		ob.reverseWords(str1);
	}

}

