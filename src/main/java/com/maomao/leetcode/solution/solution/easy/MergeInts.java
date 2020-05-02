package com.maomao.leetcode.solution.solution.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author fujie.feng
 * @Date 2020-04-16
 */
public class MergeInts {

    /**
     * 将而为数组分开排序，然后merge
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        
        int[] s1 = new int[len];
        int[] s2 = new int[len];
        for (int i = 0; i < len; i++) {
            s1[i] = intervals[i][0];
            s2[i] = intervals[i][1];
        }

        Arrays.sort(s1);
        Arrays.sort(s2);
        
        List<int[]> list = new ArrayList<>();
        for (int i = 0, j = 0; i < len; i++) {
            if (i == len - 1 || s1[i + 1] > s2[i]) {
                list.add(new int[]{s1[j], s2[i]});
                j = i + 1;
            }
        }

        return list.toArray(new int[list.size()][]);
    }

    /**
     * 整体排序
     * @param intervals
     * @return
     */
    public int[][] merge2(int[][] intervals) {
        LinkedList<int[]> res = new LinkedList<>();
        if (intervals == null || intervals.length == 0) {
            return res.toArray(new int[0][]);
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int i = 0; i < intervals.length; i++) {
            if (res.isEmpty() || res.getLast()[1] < intervals[i][0]) {
                res.add(intervals[i]);
            } else {
                res.getLast()[1] = Math.max(res.getLast()[1], intervals[i][1]);
            }
        }
        return res.toArray(new int[0][0]);
    }
}
