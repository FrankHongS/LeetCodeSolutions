/**
 * Created by Frank_Hon on 2020/12/13 3:08 下午.
 * E-mail: frank_hon@foxmail.com
 */

fun main() {
    // let可以进行非空判断，最后一行为返回值
    // 在lambda表达式中it指向的是调用对象
    val a = 2
    val b = a.let {
        println(it)
        it + 3
    }
    println(b)

    // with不可以进行非空判断，在lambda表达式中this指向的是第一个参数receiver对象，
    // 所以在表达式中可以直接使用该对象的属性和方法，
    // 最后一行为返回值
    val user = User("Joey", 26)
    val c = with(user) {
        println("name: $name, age: $age")
        10
    }
    println(c)

    // run可以进行非空判断，在lambda表达式中this指向的是调用对象，
    // 所以在表达式中可以直接使用该对象的属性和方法，
    // 最后一行为返回值
    // run结合了let和with的特点
    val d = user.run {
        println("name: $name, age: $age")
        100
    }
    println(d)

    // run可以进行非空判断，在lambda表达式中this指向的是调用对象，
    // 所以在表达式中可以直接使用该对象的属性和方法，
    // 最后一行不是返回值，返回的值为该对象
    val e = user.apply {
        name = "Monica"
        100
    }
    println(e)

    // also可以进行非空判断，在lambda表达式中it指向的是调用对象，
    // 所以在表达式中需要使用it来调用该对象的属性和方法，
    // 最后一行不是返回值，返回的值为该对象
    val f = user.also {
        it.name = "Chandler"
        1000
    }
    println(f)
}

data class User(var name: String, val age: Int) {
    override fun toString(): String {
        return "User(name='$name', age=$age)"
    }
}