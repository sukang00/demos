
fun staticCompilation(){
//    val b: Byte = 1 // OK, 字面值是静态检测的
//    val i: Int = b // 错误

    val b: Byte = 1 // OK, 字面值是静态检测的
    val i: Int = b.toInt() // OK
    println(i)
}

fun funArray () {
    //[1,2,3]
    val a = arrayOf(1, 2, 3)
    //[0,2,4]
    val b = Array(3, { i -> (i * 2) })

    //读取数组内容
    println(a[0])    // 输出结果：1
    println(b[1])    // 输出结果：2
}
fun replaceBlank() {
    val text = """
    |多行字符串
    |菜鸟教程
    |多行字符串
    |Runoob
    """.trimMargin()
    println(text)    // 前置空格删除了
}

fun characterTemplate() {
    val s = "runoob"
    val str = "$s.length is ${s.length}" // 求值结果为 "runoob.length is 6"
    println(str)

    val price = """
    ${'$'}9.99
    """
    println(price)  // 求值结果为 $9.99
}
fun main(args: Array<String>) {
    val a: Int = 10000
    println(a === a) // true，值相等，对象地址相等

    //经过了装箱，创建了两个不同的对象
    val boxedA: Int? = a
    val anotherBoxedA: Int? = a

    //虽然经过了装箱，但是值是相等的，都是10000
    println(boxedA === anotherBoxedA) //  false，值相等，对象地址不一样
    println(boxedA == anotherBoxedA) // true，值相等

    staticCompilation()

    funArray()
    replaceBlank()
    characterTemplate()

}