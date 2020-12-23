package com.maple.leetcode

import org.junit.Test

/**
 * [★★]
 * 15. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例：
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 *
 * https://leetcode-cn.com/problems/3sum/
 *
 * @author : shaoshuai
 * @date ：2020/12/23
 */
class LeetCode15 {

    @Test
    fun runTest() {
        val test = intArrayOf(-1, 0, 1, 2, -1, -4)
        val sum = threeSum(test)
        printIntArrays(sum)
    }

    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        // 数量小于三，全正数  全负数 (不需要)
//        if (nums.size < 3 || nums.first() > 0 || nums.last() < 0) {
//            return lists
//        }
        val lists = arrayListOf<List<Int>>()
        for (i in 0..nums.size - 3) {
            if (nums[i] > 0) break
            if (i > 0 && nums[i] == nums[i - 1]) continue

            var left = i + 1
            var right = nums.size - 1
            while (left < right) {
                val sum = nums[i] + nums[left] + nums[right]
                when {
                    sum > 0 -> right--
                    sum < 0 -> left++
                    sum == 0 -> {
                        lists.add(listOf(nums[i], nums[left], nums[right]))
                        while (left < right && nums[left] == nums[left + 1]) left++
                        while (right > left && nums[right] == nums[right - 1]) right--
                        left++
                        right--
                    }
                }
            }
        }
        return lists
    }

    // 打印 List<List<Int>>
    private fun printIntArrays(intArrays: List<List<Int>>) {
        val sb = StringBuilder()
        sb.append("[\n")
        intArrays.forEach { list ->
            sb.append("\t[")
            list.forEach {
                sb.append(" ${it} ,")
            }
            sb.append("]\n")
        }
        sb.append("]\n")
        println("return data: \n${sb.toString()} ")
    }

    // 打印 IntArray
    private fun printIntArray(intArray: IntArray) {
        val sb = StringBuilder()
        intArray.forEach {
            sb.append(" ${it} ,")
        }
        println("return data: \n${sb.toString()} ")
    }
}