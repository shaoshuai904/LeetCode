package com.maple.leetcode

import org.junit.Test


/**
 * 桌上一堆糖，你和朋友两个人人一起玩游戏，每次你们轮流拿走1-3颗糖，拿掉最后一块糖的人就是获胜者
 * 你作为先手，你们都是聪明人，每一步都是最优解。
 * 编写一个函数判断你是否能够赢得胜利，函数输入值为糖的总量
 *
 *
 * @author maple
 * @time 2019-09-18
 */
class Ohter1 {

    @Test
    fun runTest() {
        val ret = canWinNim(121)
        if (ret) {
            println("初始值不是4的倍数, 胜利✌️")
        } else {
            println("初始值是4的倍数, 失败～️")
        }
    }

    // 先手，每次1-3，拿最后一个，胜利
    // 思路：保留4的倍数给对方，我方必赢
    private fun canWinNim(n: Int): Boolean {
        return n % 4 != 0
    }

}