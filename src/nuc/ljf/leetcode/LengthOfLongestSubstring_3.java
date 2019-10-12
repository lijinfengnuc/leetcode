package nuc.ljf.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: LengthOfLongestSubstring_3 <br/>
 * Function: <br/>
 * Date: 2019年10月12日 10:00 <br/>
 *
 * @author lijinfeng
 * @since JDK1.8
 */

public class LengthOfLongestSubstring_3 {

    public static void main(String[] args) {
        LengthOfLongestSubstring_3 solution = new LengthOfLongestSubstring_3();
        System.out.println(solution.lengthOfLongestSubstring("abcdbef"));
    }

    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        Map<Character, Integer> charMap = new HashMap();
        int beginIndex = 0;
        int endIndex = 0;
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++) {
            Integer index = charMap.get(chars[i]);
            if(null != index && index >= beginIndex) {
                int currentLength = endIndex - beginIndex;
                maxLength =  maxLength > currentLength ? maxLength : currentLength;
                beginIndex = index + 1;
            }
            charMap.put(chars[i], i);
            endIndex++;
        }
        int lastLength = endIndex - beginIndex;
        return maxLength > lastLength ? maxLength : lastLength;
    }

}
