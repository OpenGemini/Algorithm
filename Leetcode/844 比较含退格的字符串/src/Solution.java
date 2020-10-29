/**
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 *
 * 注意：如果对空文本输入退格字符，文本继续为空。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 * 示例 2：
 *
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 * 示例 3：
 *
 * 输入：S = "a##c", T = "#a#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “c”。
 * 示例 4：
 *
 * 输入：S = "a#c", T = "b"
 * 输出：false
 * 解释：S 会变成 “c”，但 T 仍然是 “b”。
 */
import java.util.*;
public class Solution {
    public boolean backspaceCompare(String S, String T) {
        int sIndex = S.length() - 1;
        int tIndex = T.length() - 1;
        int hadSBlack = 0;
        int hadTBlack = 0;
        while (sIndex >= 0 || tIndex >= 0) {
            while (sIndex >= 0) {
                char sChar = S.charAt(sIndex);
                if (sChar == '#') {
                    hadSBlack++;
                    sIndex--;
                    continue;
                }
                if (hadSBlack > 0) {
                    hadSBlack--;
                    sIndex--;
                    continue;
                }
                break;
            }
            while (tIndex >= 0) {
                char tChar = T.charAt(tIndex);
                if (tChar == '#') {
                    hadTBlack++;
                    tIndex--;
                    continue;
                }
                if (hadTBlack > 0) {
                    hadTBlack--;
                    tIndex--;
                    continue;
                }
                break;
            }
            if (tIndex >= 0 && sIndex >= 0) {
                if (T.charAt(tIndex) != S.charAt(sIndex)) {
                    return false;
                }
            } else {
                if (tIndex >= 0 || sIndex >= 0) {
                    return false;
                }
            }
            sIndex--;
            tIndex--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String S1 = "ab#c";
        String T1 = "ad#c";
        String S2 = "ab##";
        String T2 = "c#d#";
        String S3 = "a##c";
        String T3 = "#a#c";
        String S4 = "a#c";
        String T4 = "b";
        String S5 ="j##yc##bs#srqpfzantto###########i#mwb";
        String T5 = "j##yc##bs#srqpf#zantto###########i#mwb";
        boolean r1 = solution.backspaceCompare(S1, T1);
        boolean r2 = solution.backspaceCompare(S2, T2);
        boolean r3 = solution.backspaceCompare(S3, T3);
        boolean r4 = solution.backspaceCompare(S4, T4);
        boolean r5 = solution.backspaceCompare(S5, T5);
        System.out.println(r1 + " " + r2 + " " + r3 + " " + r4 + " " + r5);
    }
}
