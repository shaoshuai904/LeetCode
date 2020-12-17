package com.maple.leetcode

import junit.framework.TestCase
import org.junit.Test

/**
 * [★★]
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 * 示例:
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 *
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 *
 * https://leetcode-cn.com/problems/powx-n/
 *
 * @author maple
 * @time 2019-08-18
 */
class LeetCode50 {

    @Test
    fun runTest() {
        val ret = myPow(2.0, 10)
        println("return data: $ret ")

        TestCase.assertEquals(1024.0, myPow(2.0, 10))
    }

    /**
     * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
     */
    private fun myPow(x: Double, n: Int): Double {
        return if (n > 0) {
            fastPow(x, n)
        } else {
            fastPow(1 / x, -n)
        }
    }

    private fun fastPow(x: Double, n: Int): Double {
        if (n == 0) return 1.0
        if (n == 1) return x
        val half = fastPow(x, n / 2)
        return if (n % 2 == 0) {
            half * half
        } else {
            half * half * x
        }
    }
}