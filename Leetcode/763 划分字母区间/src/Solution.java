import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 *  
 *
 * 提示：
 *
 * S的长度在[1, 500]之间。
 * S只包含小写字母 'a' 到 'z' 。
 *
 */
import java.util.*;
class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> list = new ArrayList<Integer>();
        int length = S.length();
        int[] cArray = new int[26];
        int max = 0;
        int[] cell = new int[26];
        for (int i = 0; i < length; i++) {
            char c = S.charAt(i);
            int index = c - 'a';
            int cPart = cArray[index];
            System.out.println("第" + i + "次循环, 字母为" + c +",字母的组为: "+ cPart +", max为" + max + " :");
            if (cArray[index] == 0) {
                cell[max] = 1;
                cArray[index] = ++max;
                System.out.println("字母所在的组 " + Arrays.toString(cArray));
                System.out.println("组的个数 " +Arrays.toString(cell));
                continue;
            }
            for (int j = max; j > cPart; j--) {
                cell[cPart-1] += cell[j-1];
                cell[j-1] = 0;
                if (i==5) {
                    System.out.println(cell[index]);
                }
                for (int k = 0; k < 26; k++) {
                    if (cArray[k] > cPart) {
                        cArray[k] = cPart;
                    }
                }
            }
            if (cArray[index] > 0) {
                cell[cPart - 1]++;
                if (i==5) {
                    System.out.println(cell[cPart - 1]);
                }
            } else {
                cell[index]++;
            }
            max = cPart;
            System.out.println("---");
            System.out.println("cArray " + Arrays.toString(cArray));
            System.out.println("cell " + Arrays.toString(cell));
        }
        for (int i = 0 ; i < 26 ; i++) {
            if (cell[i] > 0) {
                list.add(cell[i]);
            }
        }
        // System.out.println(Arrays.toString(cell));
        System.out.println(list.toString());
        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String S = "ababcbacadefegdehijhklij";
        solution.partitionLabels(S);
    }
}