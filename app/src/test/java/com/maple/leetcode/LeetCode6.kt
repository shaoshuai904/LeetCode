package com.maple.leetcode

import org.junit.Test

/**
 * [★★]
 * 6. Z 字形变换
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，
 * 比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 * string convert(string s, int numRows);
 *
 * 示例 :
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 *
 * https://leetcode-cn.com/problems/zigzag-conversion/
 *
 * @author : shaoshuai
 * @date ：2020/12/22
 */
class LeetCode6 {

    @Test
    fun runTest() {
        val test = "LEETCODEISHIRING"
        val sum = convert(test, 3)
        println("return data: $sum ")
    }

    //
//    * L     D     R
//    * E   O E   I I
//    * E C   I H   N
//    * T     S     G
    fun convert(s: String, numRows: Int): String {
        if (numRows <= 1)
            return s
        val cycle = numRows * 2 - 2
        val cycleN = s.length + cycle - 1 / cycle
        val sb = StringBuilder()
        // 首行
        for (i in 0 until cycleN) {
            val start = i * cycle
            if (start >= 0 && start < s.length) {
                sb.append(s[start])
            }
        }
        for (aa in 1..numRows - 2) {
            for (i in 0 until cycleN) {
                val start1 = i * cycle + aa
                if (start1 >= 0 && start1 < s.length) {
                    sb.append(s[start1])
                }
                val start2 = (i + 1) * cycle - aa
                if (start2 >= 0 && start2 < s.length) {
                    sb.append(s[start2])
                }
            }
        }
        // 尾行
        for (i in 0 until cycleN) {
            val start = i * cycle + numRows - 1
            if (start >= 0 && start < s.length) {
                sb.append(s[start])
            }
        }
        return sb.toString()
    }
}