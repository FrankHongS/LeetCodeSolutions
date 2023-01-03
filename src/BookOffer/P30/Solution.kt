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
fun main() {
    val stack = Stack<Int>()
    stack.push(2, 1, 3, 4, 7)
//    stack.pop(count = 1)
    println(stack.min())
}

private class Stack<T : Comparable<T>> {

    private val data by lazy { LinkedList<T>() }
    private val minItems by lazy { LinkedList<T>() }

    fun push(vararg items: T) {
        items.forEach {
            push(it)
        }
    }

    fun push(item: T) {
        data.push(item)
        val min = if (minItems.isEmpty()) {
            null
        } else {
            minItems.first
        }
        if (min == null || item < min) {
            minItems.push(item)
        } else {
            minItems.push(min)
        }
    }

    fun pop(count: Int): List<T> {
        return mutableListOf<T>().apply {
            val stackSize = size()
            var tempCount = 0
            while (tempCount < count && tempCount < stackSize) {
                add(pop())
                tempCount++
            }
        }
    }

    fun pop(): T {
        minItems.pop()
        return data.pop()
    }

    fun min(): T? {
        return if (minItems.isEmpty()) {
            null
        } else {
            minItems.first
        }
    }

    fun size() = data.size
}