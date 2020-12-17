package com.maple.leetcode

import org.junit.Test

/**
 * [★]
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 示例：
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * https://leetcode-cn.com/problems/two-sum/
 *
 * @author maple
 * @time 2020-11-12
 */
class LeetCode1 {

    @Test
    fun runTest() {
        val aaa = intArrayOf(3, 2, 4)
        val bbb = twoSum(aaa, 6)

        println("return data: ${toStr(bbb)}  ")
    }

    // 借助哈希表，将时间复杂度降为 O(n)
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val hash = hashMapOf<Int, Int>()
        for (i in nums.indices) {
            val findValue = target - nums[i]
            // hash 查找时间复杂度 O(1)
            if (hash.contains(findValue)) {
                return intArrayOf(hash[findValue]!!, i)
            }
            hash[nums[i]] = i // 值：索引
        }
        return intArrayOf(-1, -1)
    }

    // 双for 暴力破解，时间复杂度 O（n^2）
    fun twoSum1(nums: IntArray, target: Int): IntArray {
        for (i in nums.indices) {
            val findValue = target - nums[i]
            for (j in i + 1 until nums.size) {
                if (findValue == nums[j]) {
                    return intArrayOf(i, j)
                }
            }
        }
        return intArrayOf(-1, -1)
    }


    // 双while 暴力破解，时间复杂度 O（n^2）
    fun twoSum2(nums: IntArray, target: Int): IntArray {
        var curIndex = 0
        while (curIndex < nums.size) {
            val findValue = target - nums[curIndex]
            var line = curIndex + 1
            while (line < nums.size) {
                if (findValue == nums[line]) {
                    return intArrayOf(curIndex, line)
                }
                line++
            }
            curIndex++
        }
        return intArrayOf(-1, -1)
    }

    fun toStr(A: IntArray): String {
        val sb = StringBuilder()
        A.forEachIndexed { index, i ->
            sb.append("$i  ")
        }
        return sb.toString()
    }
}