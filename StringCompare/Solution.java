public class Solution {

    public Solution() {

    }

    public boolean isMatch(String input, String pattern) {
	
	int inIndex = 0;
	int patIndex = 0;

	char prevInCh = ' ';
	char prevPatCh = ' ';

	boolean matchBool = true;

	while (inIndex < input.length() && patIndex < pattern.length()) {
	    char inCh = input.charAt(inIndex);
	    char patCh = pattern.charAt(patIndex);

	    if (patCh == '.') {
		inIndex++;
		patIndex++;
	    } else if (patCh == '*') {
		if (prevPatCh == prevInCh && inCh == prevPatCh) {
		    
		}
	    } else {
		if (inCh != patCh) {
		    matchBool = false;
		}
		inIndex++;
		patIndex++;
	    }

	    prevInCh = inCh;
	    prevPatCh = patCh;
	    
	}
	
    }

    public static void main(String[] args) {
	Solution sol = new Solution();
	Str in1 = "aab";
	String pat1 = "a*b";

	String pat2 = "c*a*b";

	String pat3 = ".*";
    }

}