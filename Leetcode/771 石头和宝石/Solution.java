/**
 * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 *
 * 示例 1:
 * 输入: J = "aA", S = "aAAbbbb"
 * 输出: 3
 * 示例 2:
 *
 * 输入: J = "z", S = "ZZ"
 * 输出: 0
 *
 * 注意:
 * S 和 J 最多含有50个字母。
 *  J 中的字符不重复。
 */
import java.util.*;
class Solution {
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        HashSet<Character> hashStone = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            char j = J.charAt(i);
            hashStone.add(j);
        }
        for (int i = 0; i < S.length(); i++) {
            char s = S.charAt(i);
            if (hashStone.contains(s)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String J = "aA";
        String S = "aAAbbbb";
        Solution solution = new Solution();
        int res = solution.numJewelsInStones(J, S);
        System.out.println(res);
    }
}