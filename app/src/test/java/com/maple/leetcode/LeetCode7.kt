package com.maple.leetcode

import org.junit.Test

/**
 * [★]
 * 7. 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 * 输入: 123
 * 输出: 321
 *
 * 示例 2:
 * 输入: -123
 * 输出: -321
 *
 * 示例 3:
 * 输入: 120
 * 输出: 21
 *
 * 注意:
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * https://leetcode-cn.com/problems/reverse-integer/
 *
 * @author : shaoshuai27
 * @date ：2020/12/18
 */
class LeetCode7 {

    @Test
    fun runTest() {
        val ret = reverse(846384742)
        println("return data: $ret ")

    }

    fun reverse(x: Int): Int {
        var oldValue = if (x > 0) x else -x
        var newValue = 0
        while (oldValue > 0) {
            if (newValue > Int.MAX_VALUE / 10) {
                return 0
            }
            newValue = newValue * 10 + oldValue % 10
            oldValue /= 10
        }
        if (x < 0) {
            newValue *= -1
        }
        return newValue
    }

}