package com.maple.leetcode

import org.junit.Test

/**
 * [★]
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例:
 * 输入: 121
 * 输出: true
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 *
 * https://leetcode-cn.com/problems/palindrome-number/
 *
 * @author maple
 * @time 2019-08-18
 */
class LeetCode9 {

    @Test
    fun runTest() {
        val ret = isPalindrome(121)
        println("return data: $ret ")

    }

    fun isPalindrome(x: Int): Boolean {
        // x 为负数 或 为10的倍数，直接false
        if (x < 0 || (x % 10 == 0 && x != 0)) return false

        var X = x
        var Y = 0
        while (X > Y) {
            Y = Y * 10 + X % 10// 个位数
            X /= 10
        }
        println("  data: $X  $Y")
        // 偶数位 X == Y
        // 奇数位 Y比X多一位
        // 必须和10的倍数条件配合，否则10010：X=10 Y=10；200200：X=20 Y=20
        return X == Y || X == Y / 10
    }

    private fun isPalindrome1(x: Int): Boolean {
        if (x < 0) return false
        val xsc = x.toString().toCharArray()
        for (i in 0 until xsc.size / 2) {
            if (xsc[i] != xsc[xsc.size - 1 - i]) {
                return false
            }
        }
        return true
    }

    // 判断一个字符串是否是回文
    private fun isPalindrome2(x: Int): Boolean {
        if (x < 0) return false
        val reversedStr = StringBuilder(x.toString()).reverse().toString()
        return x.toString() == reversedStr
    }

}