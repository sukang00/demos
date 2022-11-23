fun range() {
    val x = 5
    val y = 9
    if (x in 1..8) {
        println("x 在区间内")
    }
}

fun testWhen(x:Int){
    when (x) {
        1 -> print("x == 1")
        2 -> print("x == 2")
        else -> { // 注意这个块
            print("x 不是 1 ，也不是 2")
        }
    }
}
fun testWhen1(x:Int){
    when (x) {
        0, 1 -> print("x == 0 or x == 1")
        else -> print("otherwise")
    }
}

fun testWhen2(x: Int){
    val validNumbers = 30..60
    when (x) {
        in 1..10 -> print("x is in the range")
        in validNumbers -> print("x is valid")
        !in 10..20 -> print("x is outside the range")
        else -> print("none of the above")
    }
}
fun hasPrefix(x: Any) = when(x) {
    is String -> x.startsWith("prefix")
    else -> false
}
fun testWhen3(){
    val items = setOf("apple", "banana", "kiwi")
    when {
        "orange" in items -> println("juicy")
        "apple" in items -> println("apple is fine too")
    }
}
fun main(args: Array<String>) {
    var x = 0
    if(x>0){
        println("x 大于 0")
    }else if(x==0){
        println("x 等于 0")
    }else{
        println("x 小于 0")
    }

    var a = 1
    var b = 2
    val c = if (a>=b) a else b
    println("c 的值为 $c")

    range()
    testWhen(2)
    println()
    testWhen(3)
    println()
    testWhen1(1)
    println()
    testWhen2(31)
    println()
    println(hasPrefix("prefix123"))
    testWhen3()
}