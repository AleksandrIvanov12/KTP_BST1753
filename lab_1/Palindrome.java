// Defines if word is a palindrome


public class Palindrome
{
	// Reverse passed string
	public static String reverseStrings(String strings)
	{
		int stringLength = strings.length();
		String result = "";
		for (int i = 0; i < stringLength; i++)
		{
			result = strings.charAt(i) + result;
		}
		return result;

	}

	// Compares initial string with reversed string
	public static boolean isPalindrome(String s)
	{
		return s.equals(reverseStrings(s));
	}

	// Main method to run application
	public static void main(String[] args)
	{
		for (int i = 0; i < args.length; i++)
		{
			String s = args[i];
			if (isPalindrome(s))
			{
				System.out.println("This word is a palindrome");
			}
			else
			{
				System.out.println("This word isnt a palindrome");
			}
		}
	}
}