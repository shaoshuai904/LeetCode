package com.maple.leetcode

import org.junit.Test

/**
 * [★]
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 * 你可以返回任何满足上述条件的数组作为答案。
 *
 * 示例：
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 *
 * https://leetcode-cn.com/problems/sort-array-by-parity-ii/
 *
 * @author maple
 * @time 2020-11-12
 */
class LeetCode922 {

    @Test
    fun runTest() {
        val aaa = intArrayOf(4, 2, 5, 7, 1, 2)
        val bbb = sortArrayByParityII(aaa)

        println("return data: ${toStr(bbb)}  ")
    }

    fun sortArrayByParityII(A: IntArray): IntArray {
        val result = IntArray(A.size)
        var ouSize = 0
        var jiSize = 0
        A.forEach { i ->
            if (i % 2 == 0) {
                // 偶数，0 1 2 3 4 5
                // 索引，0 2 4 6 8
                result[ouSize * 2] = i
                ouSize++
            } else {
                // 偶数，0 1 2 3 4
                // 索引，1 3 5 7 9
                result[(jiSize * 2) + 1] = i
                jiSize++
            }
        }
        return result
    }


    fun toStr(A: IntArray): String {
        val sb = StringBuilder()
        A.forEachIndexed { index, i ->
            sb.append("$i  ")
        }
        return sb.toString()
    }
}