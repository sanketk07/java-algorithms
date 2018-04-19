/**
 * 
 */
package com.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sanketkumar
 *
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
    
    public static void main(String args[]){
    	LengthOfLongestSubstring s = new LengthOfLongestSubstring();
    	int length = s.lengthOfLongestSubstring("abcgdfa");
    	System.out.println(length);
    }
}
