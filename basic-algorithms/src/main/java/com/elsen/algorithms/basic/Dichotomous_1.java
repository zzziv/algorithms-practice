package com.elsen.algorithms.basic;

/**
 * 二分法
 *
 * @author Elsen 2022/9/4
 */
public class Dichotomous_1 {

    /*
        给定一个个元素有序的（升序）
        整型数组nums 和一个目标值target
        写一个函数搜索num中的 target，如果目标值存在返回下标，否则返回 -1。

        示例 1:
        输入: nums = [-1,0,3,5,9,12], target = 9
        输出: 4
        解释: 9 出现在 nums 中并且下标为 4

        示例2:
        输入: nums = [-1,0,3,5,9,12], target = 2
        输出: -1
        解释: 2 不存在 nums 中因此返回 -1
     */
    public static void main(String[] args) {
        int[] a1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        System.out.println(getTargetIndex(a1, 8));
        System.out.println(getTargetIndexAnswer(a1, 8));

    }

    /**
     * 在元素中查找目标数值索引值 自己写的
     *
     * @param sourceArr   源数组
     * @param targetValue 目标值
     * @return 目标值索引(- 1为不存在源数组中)
     */
    private static int getTargetIndex(int[] sourceArr, int targetValue) {
        // 获取中位数值
        int medianIndex = sourceArr.length / 2;
        int medianValue = sourceArr[medianIndex];

        // 目标值等于中位数, 返回索引
        if (targetValue == medianValue) {
            return medianIndex;
        }

        // 目标值大于中位数, 获取数组中位数之后的数据继续比对
        int[] tempArr = new int[sourceArr.length];
        if (targetValue > medianValue) {
            // 获取x到最后元素的中位数
            for (int i = medianIndex; i < sourceArr.length - 1; i++) {
                System.out.println(medianValue);
                System.out.println(i);
                tempArr[i] = sourceArr[i];
            }
        }
        // 目标值小于中位数, 获取数组中位数之前的数据继续比对
        else {
            for (int i = 0; i < medianIndex - 1; i++) {
                tempArr[i] = sourceArr[i];
            }
        }
        getTargetIndex(tempArr, targetValue);
        return -1;
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

        // 首位索引
        int left = 0;
        // 末尾索引
        int right = sourceArr.length - 1;
        // 区间为: [0, 10]

        // 定义查找的区间, 一开始为整个数组, <= 是因为必须是一个合法的区间内
        while (left <= right) {
            /*
                查询中位数, 中位数下标 = (右区间 + 左区间) / 2, 这里
                使用 左区间 + (右区间 - 左区间) / 2 是因为在程序中, 2个int相加可能会造成溢出
             */
            int mid = left + (right - left) / 2;

            if (sourceArr[mid] == target) {
                return mid;
            } else if (sourceArr[mid] > target) {
                // 目标值在左区间, 因此数值区间就变为 [0, 4]
                right = mid - 1;
            } else {
                // 目标值在右区间, 因此数值区间变为 [6, 10]
                left = mid + 1;
            }
        }
        return -1;
    }
}
