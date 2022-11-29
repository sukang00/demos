interface MyInterface {
    fun bar()
    fun foo() {
        // 可选的方法体
        println("foo")
    }
}
class Child : MyInterface {
    override fun bar() {
        // 方法体
        println("bar")
    }
}

interface MyInterface1 {
    var name:String //name 属性, 抽象的
    fun bar()
    fun foo() {
        // 可选的方法体
        println("foo")
    }
}
class Child1 : MyInterface1 {
    override var name: String = "runoob" //重写属性
    override fun bar() {
        // 方法体
        println("bar")
    }
}

interface A1 {
    fun foo() { print("A") }   // 已实现
    fun bar()                  // 未实现，没有方法体，是抽象的
}

interface B1 {
    fun foo() { print("B") }   // 已实现
    fun bar() { print("bar") } // 已实现
}

class C1 : A1 {
    override fun bar() { print("bar") }   // 重写
}

class D1 : A1, B1 {
    override fun foo() {
        super<A1>.foo()
        super<B1>.foo()
    }

    override fun bar() {
        super<B1>.bar()
    }
}
fun main(args: Array<String>) {
    val c =  Child()
    c.foo();
    c.bar();

    val c1 =  Child1()
    c1.foo();
    c1.bar();
    println(c1.name)

    val d =  D1()
    d.foo();
    d.bar();
}