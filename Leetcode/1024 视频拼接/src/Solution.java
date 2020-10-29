/**
 *
 你将会获得一系列视频片段，这些片段来自于一项持续时长为 T 秒的体育赛事。这些片段可能有所重叠，也可能长度不一。

 视频片段 clips[i] 都用区间进行表示：开始于 clips[i][0] 并于 clips[i][1] 结束。我们甚至可以对这些片段自由地再剪辑，例如片段 [0, 7] 可以剪切成 [0, 1] + [1, 3] + [3, 7] 三部分。

 我们需要将这些片段进行再剪辑，并将剪辑后的内容拼接成覆盖整个运动过程的片段（[0, T]）。返回所需片段的最小数目，如果无法完成该任务，则返回 -1 。



 示例 1：

 输入：clips = [[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]], T = 10
 输出：3
 解释：
 我们选中 [0,2], [8,10], [1,9] 这三个片段。
 然后，按下面的方案重制比赛片段：
 将 [1,9] 再剪辑为 [1,2] + [2,8] + [8,9] 。
 现在我们手上有 [0,2] + [2,8] + [8,10]，而这些涵盖了整场比赛 [0, 10]。
 示例 2：

 输入：clips = [[0,1],[1,2]], T = 5
 输出：-1
 解释：
 我们无法只用 [0,1] 和 [1,2] 覆盖 [0,5] 的整个过程。
 示例 3：

 输入：clips = [[0,1],[6,8],[0,2],[5,6],[0,4],[0,3],[6,7],[1,3],[4,7],[1,4],[2,5],[2,6],[3,4],[4,5],[5,7],[6,9]], T = 9
 输出：3
 解释：
 我们选取片段 [0,4], [4,7] 和 [6,9] 。
 示例 4：

 输入：clips = [[0,4],[2,8]], T = 5
 输出：2
 解释：
 注意，你可能录制超过比赛结束时间的视频。


 提示：

 1 <= clips.length <= 100
 0 <= clips[i][0] <= clips[i][1] <= 100
 0 <= T <= 100
 */

import java.util.*;
class Solution {
    int count = 1;
    public int videoStitching(int[][] clips, int T) {
        Map<Integer, Integer> map = new HashMap<>();
        int cmin = -1, cmax = -1;
        Set<Integer> set = new TreeSet<>();
        for (int[] clip : clips) {
            Integer mv = map.get(clip[0]);
            if (mv == null || mv < clip[1]) {
                map.put(clip[0], clip[1]);
                set.add(clip[0]);
            }
            if (clip[0] == 0) {
                cmin = 0;
            }
            if (clip[1] >= T) {
                cmax = T;
            }
        }
        System.out.println(map.toString());
        System.out.println(set);
        if (cmin == -1 || cmax == -1) {
            return -1;
        }
        int begin = 0;
        int end = map.get(0);
        while (end < T) {
            begin = findNext(map, set, begin, end);
            if (begin == -1) {
                return -1;
            }
            end = map.get(begin);
            count++;
        }
        return count;
    }

    public int findNext(Map<Integer, Integer> map, Set<Integer> sets, int begin, int end) {
        int max = -1;
        int maxKey = -1;
        for (int i : sets) {
            if (i <= begin) {
                continue;
            }
            if (i > end) {
                break;
            }
            int mv = map.get(i);
            System.out.println(i + ",mv: "+ mv +",end: "+ end +",max:" + max);
            if (mv > end && mv > max) {
                max = mv;
                maxKey = i;
            }
        }
        if (maxKey == -1) {
            System.out.println("begin: " + begin +", end: "+ end);
        }
        return maxKey;
    }

    public int best(int[][] clips, int T) {
        // 新建一个T长度的数组
        int[] maxn = new int[T];
        int last = 0, ret = 0, pre = 0;
        // 遍历二位数组，对应的下标为最大值
        for (int[] clip : clips) {
            if (clip[0] < T) {
                maxn[clip[0]] = Math.max(maxn[clip[0]], clip[1]);
            }
        }
        // 从0开始遍历到T
        for (int i = 0; i < T; i++) {
            // 比较上一次的值跟这次下标的值那个最大，不存在的下标为0, 而有值的一定大于0
            last = Math.max(last, maxn[i]);
            // 比较到上次最大的坐标，都没有更新更大的值，则中断了。比如[0,4],[1,3][2,3][5,7],这里1,3都更新不到最新的值
            if (i == last) {
                return -1;
            }
            // i走到了上次的最大值，且最大值已经更新，则视频连上了一块（ret+1）,这次最大值更新为pre
            if (i == pre) {
                ret++;
                pre = last;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        //int[][] clips = new int[][]{{0, 1}, {6, 8}, {0, 2}, {5, 6}, {0, 4}, {0, 3}, {6, 7}, {1, 3}, {4, 7}, {1, 4}, {2, 5}, {2, 6}, {3, 4}, {4, 5}, {5, 7}, {6, 9}};
        //int[][] clips = new int[][]{{0,4},{2,8}};
        int[][] clips = new int[][]{{0,2},{4,6},{8,10},{1,9},{1,5},{5,9}};
        int T = 10;
        Solution solution = new Solution();
        int res = solution.videoStitching(clips, T);
        System.out.println(res);
    }
}