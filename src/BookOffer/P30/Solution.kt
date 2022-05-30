package BookOffer.P30

import java.util.*

/**
 * 包含min函数的栈
 * 题目：定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min函数。在
 * 该栈中，调用min、push以及pop的时间复杂度都是O(1)
 *
 *
 * Created by Frank_Hon on 2022/3/29 下午11:38.
 * E-mail: frank_hon@foxmail.com
 */
object Solution {
    private val so = A()
    @JvmStatic
    fun main(args: Array<String>) {
        val stack = Stack<Int>()
        stack.push(2)
        stack.push(1)
        stack.push(3)
        stack.push(4)
        stack.push(7)
        println(stack.min())
    }

    private class A
    private class Stack<T : Comparable<T>?> {
        private val dataContainer: LinkedList<T>
        private val minItemContainer: LinkedList<T>
        fun push(item: T) {
            dataContainer.push(item)
            val min: T?
            min = if (minItemContainer.isEmpty()) {
                null
            } else {
                minItemContainer.first
            }
            if (min == null || item!!.compareTo(min) < 0) {
                minItemContainer.push(item)
            } else {
                minItemContainer.push(min)
            }
        }

        fun pop(): T {
            val target = dataContainer.pop()
            val min = minItemContainer.pop()
            if (target !== min) {
                minItemContainer.push(min)
            }
            return target
        }

        fun min(): T? {
            return if (minItemContainer.isEmpty()) {
                null
            } else {
                minItemContainer.first
            }
        }

        init {
            dataContainer = LinkedList()
            minItemContainer = LinkedList()
        }
    }
}