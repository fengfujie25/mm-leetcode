package com.maomao.leetcode.solution.sort;

import java.util.Arrays;

/**
 * 桶排序
 * 步骤：
 * 1.设置固定数量的空桶。
 * 2.把数据放到对应的桶中。
 * 3.对每个不为空的桶进行排序。
 * 4.拼接不为空的桶的数据。
 *
 * @auther: fujie.feng
 * @DateT: 2019-12-25
 */
public class BucketSort extends BaseSort {
    public BucketSort(int[] nums) {
        super(nums);
    }

    @Override
    public int[] sort() {
        return bucketSort(arr, 5);
    }

    public int[] bucketSort(int[] nums, int bucketSize) {
        if (nums.length == 0) {
            return nums;
        }
        int maxValue = nums[0];
        int minValue = nums[0];

        for (int i : nums) {
            if (i < minValue) {
                minValue = i;
            } else if (i > maxValue) {
                maxValue = i;
            }
        }

        int bucketCount = (int) (Math.floor((maxValue - minValue) / bucketSize) + 1);
        int[][] buckets = new int[bucketCount][0];

        for (int i = 0; i < nums.length; i++) {
            int index = (int) Math.floor((nums[i] - minValue) / bucketCount);
            buckets[index] = appendBucket(buckets[index], nums[i]);
        }

        int arrIndex = 0;
        for (int[] bucket : buckets) {
            if (bucket.length <= 0) {
                continue;
            }
            //对每个桶进行插入排序
            InsertSort insertSort = new InsertSort(bucket);
            bucket = insertSort.sort();
            for (int i : bucket) {
                nums[arrIndex++] = i;
            }
        }
        return nums;
    }

    /**
     * 自动扩容并保存数据
     * @param bucket
     * @param num
     * @return
     */
    private int[] appendBucket(int[] bucket, int num) {
        bucket = Arrays.copyOf(bucket, bucket.length + 1);
        bucket[bucket.length - 1] = num;
        return bucket;
    }
}
