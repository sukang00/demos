// 函数定义
fun sum(a: Int, b: Int): Int {   // Int 参数，返回值 Int
    return a + b
}
// 无返回值的函数
fun printSum(a: Int, b: Int): Unit {
    println(a + b)
}
// 可变长参数函数
fun vars(vararg v:Int){
    for(vt in v){
        println(vt)
    }
}
fun main() {
    val t = sum(1,2);
    println(t)
    printSum(10,12);
    vars(1,2,3,4,5)
    // lambda(匿名函数)
    val sumLambda: (Int, Int) -> Int = {x,y -> x+y}
    println(sumLambda(1,2))  // 输出 3

    var a = 1
    // 模板中的简单名称：
    val s1 = "a is $a"
    println(s1)
    a = 2
    // 模板中的任意表达式：
    val s2 = "${s1.replace("is", "was")}, but now is $a"
    println(s2)

    //类型后面加?表示可为空
    var age: String? = "23"
    //抛出空指针异常
    val ages = age!!.toInt()
    println("ages:" + ages)
    //不做处理返回 null
    age = null
    val ages1 = age?.toInt()
    println("ages1:"+ages1)
    //age为空返回-1
    val ages2 = age?.toInt() ?: -1
    println("age2："+ages2)
}