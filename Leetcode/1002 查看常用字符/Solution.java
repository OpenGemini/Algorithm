/**
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 *
 * 你可以按任意顺序返回答案。
 *
 *  
 *
 * 示例 1：
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 * 示例 2：
 *
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 *  
 *
 * 提示：
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] 是小写字母
 *
 */
import java.util.*;
class Solution {
    public List<String> commonChars(String[] A) {
        List<String> list= new ArrayList<String>();

        List<Map<Character, Integer>> listMap = new ArrayList<>();

        for (int i = 0; i < A.length; i++) {
            String itemString = A[i];
            Map<Character, Integer> map = new HashMap<Character, Integer>();
            for(int j = 0; j < itemString.length(); j++) {
                Integer count = map.get(itemString.charAt(j));
                if (count != null) {
                    map.put(itemString.charAt(j), count+1);
                } else {
                    map.put(itemString.charAt(j), 1);
                }
                listMap.add(map);
            }
        }

        Map<Character, Integer> firstMap = listMap.get(0);
        for (Map.Entry<Character, Integer> mapItem : firstMap.entrySet()) {
            Character key = mapItem.getKey();
            Integer minCount = mapItem.getValue();
            boolean existValue = true;
            for (int i = 1; i < listMap.size(); i++) {
                Map<Character, Integer> m = listMap.get(i);
                Integer itemValue = m.get(key);
                if(itemValue == null) {
                    existValue = false;
                    break;
                }
                if (itemValue != null && itemValue < minCount) {
                    minCount = itemValue;
                }
            }
            if (existValue) {
                for (int i = 0; i < minCount; i++) {
                    list.add("" + key);
                }
            }
        }
        return list;
    }

    public List<String> Best(String[] A) {
        int[] minfreq = new int[26];
        Arrays.fill(minfreq, Integer.MAX_VALUE);
        for (String word: A) {
            int[] freq = new int[26];
            int length = word.length();
            for (int i = 0; i < length; ++i) {
                char ch = word.charAt(i);
                // 这个操作有点骚
                ++freq[ch - 'a'];
            }
            for (int i = 0; i < 26; ++i) {
                minfreq[i] = Math.min(minfreq[i], freq[i]);
            }
        }

        List<String> ans = new ArrayList<String>();
        for (int i = 0; i < 26; ++i) {
            for (int j = 0; j < minfreq[i]; ++j) {
                ans.add(String.valueOf((char) (i + 'a')));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] s1 = new String[] {"bella","label","roller"};
        String[] s2 = new String[] {"cool","lock","cook"};
        Solution solution = new Solution();
        List<String> r1 = solution.Best(s1);
        List<String> r2 = solution.Best(s2);
        System.out.println(r1.toString());
        System.out.println(r2.toString());
    }
}