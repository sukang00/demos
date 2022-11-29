class User(var name:String)

/**扩展函数**/
fun User.Print(){
    print("用户名 $name")
}

// 扩展函数 swap,调换不同位置的值
fun MutableList<Int>.swap(index1: Int, index2: Int) {
    val tmp = this[index1]     //  this 对应该列表
    this[index1] = this[index2]
    this[index2] = tmp
}

class MyClass {
    companion object { }  // 将被称为 "Companion"
}

fun MyClass.Companion.foo() {
    println("伴随对象的扩展函数")
}

val MyClass.Companion.no: Int
    get() = 10


class D {
    fun bar() { println("D bar") }
}

class C2 {
    fun baz() { println("C baz") }

    fun D.foo() {
        bar()   // 调用 D.bar
        baz()   // 调用 C.baz
    }

    fun caller(d: D) {
        d.foo()   // 调用扩展函数
    }
}

fun main(arg:Array<String>){
    var user = User("Runoob")
    user.Print()

    val l = mutableListOf(1, 2, 3)
    // 位置 0 和 2 的值做了互换
    l.swap(0, 2) // 'swap()' 函数内的 'this' 将指向 'l' 的值

    println(l.toString())

    println("no:${MyClass.no}")
    MyClass.foo()

    val c: C2 = C2()
    val d: D = D()
    c.caller(d)
}