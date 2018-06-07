public class NeedleInHaystack {

	public int strStr(String haystack, String needle) {
        if (needle.isEmpty())
            return 0;
        if (haystack.isEmpty())
            return -1;
        int i = 0;
        int j = 0;
        while (i<haystack.length() && j<needle.length()){
            if (haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }
            else{
                i = i-j +1;
                j = 0;
            }
        }
        if (j == needle.length())
            return i-j;
        return -1;
       }
	
	
	
	public static void main(String[] args) {
		NeedleInHaystack n = new NeedleInHaystack();
		String haystack = "abaabb";
		String needle = "aa";
		int val = n.strStr(haystack, needle);
		System.out.println(val);

	}

}
