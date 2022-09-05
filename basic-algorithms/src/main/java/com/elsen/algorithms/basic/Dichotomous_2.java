package com.elsen.algorithms.basic;

/**
 * 二分法
 *
 * @author Elsen 2022/9/4
 */
public class Dichotomous_2 {

    /*
        题目地址: https://leetcode.cn/problems/first-bad-version/
        你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
        假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。       
        你可以通过调用bool isBadVersion(version)接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。

        示例 1：
        输入：n = 5, bad = 4
        输出：4
        解释：
            调用 isBadVersion(3) -> false
            调用 isBadVersion(5)-> true
            调用 isBadVersion(4)-> true
            所以，4 是第一个错误的版本。

        提示：
        1 <= bad <= n <= 231 - 1
     */
    public static void main(String[] args) {
        System.out.println(1 / 2);
    }

    /**
     * 自己写的
     * 状态：解答错误
     * 最后执行的输入： 1,  1
     * 时间复杂都:
     * 执行用时：1 ms
     */
    private static int firstBadVersion(int n) {
        // 左区间
        int left = 0;
        // 右区间
        int right = n - 1;

        while (left <= right) {
            // 计算中位数
            int mid = left + (right - left) / 2;

            // 左区间是false, 右区间是true, 则右区间是第一个错误的版本
            if (!isBadVersion(left) && isBadVersion(right)) {
                return right;
            }
            // 返回true则说明, 错误版本在数组的左区间, 修改右区间的值
            else if (isBadVersion(mid)) {
                right = mid - 1;
            }
            // 返回false则说明, 错误版本在数组的右区间, 修改左区间的值
            else {
                left = mid + 1;
            }
        }
        return -1;
    }

    private static boolean isBadVersion(int left) {
        return Boolean.TRUE;
    }

    /*
        题解过程：
            设定左右指针
            找出中间位置，并判断该位置值是否等于 target
            nums[mid] == target 则返回该位置下标
            nums[mid] > target 则右侧指针移到中间
            nums[mid] < target 则左侧指针移到中间
            时间复杂度：O(logN)O(logN)
     */
    private static int getTargetIndexAnswer(int[] sourceArr, int target) {


        return -1;
    }
}
