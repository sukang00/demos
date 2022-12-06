/**
 * 对象表达式和对象声明之间的语义差异
对象表达式和对象声明之间有一个重要的语义差别：

对象表达式是在使用他们的地方立即执行的

对象声明是在第一次被访问到时延迟初始化的

伴生对象的初始化是在相应的类被加载（解析）时，与 Java 静态初始化器的语义相匹配
 */

fun main(args: Array<String>) {
    val site = object {
        var name: String = "菜鸟教程"
        var url: String = "www.runoob.com"
    }
    println(site.name)
    println(site.url)


    var s1 =  Site0
    var s2 = Site0
    s1.url = "www.runoob.com"
    println(s1.url)
    println(s2.url)

    var site2 = Site1()
    // site2.DeskTop.url // 错误，不能通过外部类的实例访问到该对象
    Site1.DeskTop.url // 正确
}


object Site0 {
    var url:String = ""
    val name: String = "菜鸟教程"
}

class Site1 {
    var name = "菜鸟教程"
    object DeskTop{
        var url = "www.runoob.com"
        fun showName(){
           // print{"desk legs $name"} // 错误，不能访问到外部类的方法和变量
        }
    }
}

interface Factory<T> {
    fun create(): T
}


class MyClass1 {
    companion object : Factory<MyClass1> {
        override fun create(): MyClass1 = MyClass1()
    }
}