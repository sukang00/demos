
open class Persons(var name : String, var age : Int){// 基类

}
class Student(name : String, age : Int, var no : String, var score : Int) : Persons(name, age) {

}

/**用户基类**/
open class Person8(name:String){
    /**次级构造函数**/
    constructor(name:String,age:Int):this(name){
        //初始化
        println("-------基类次级构造函数---------")
    }
}

/**子类继承 Person 类**/
class Student1:Person8{

    /**次级构造函数**/
    constructor(name:String,age:Int,no:String,score:Int):super(name,age){
        println("-------继承类次级构造函数---------")
        println("学生名： ${name}")
        println("年龄： ${age}")
        println("学生号： ${no}")
        println("成绩： ${score}")
    }
}

/**用户基类**/
open class Person7{
    open fun study(){       // 允许子类重写
        println("我毕业了")
    }
}

/**子类继承 Person 类**/
class Student2 : Person7() {

    override fun study(){    // 重写方法
        println("我在读大学")
    }
}

open class A {
    open fun f () { print("A") }
    fun a() { print("a") }
}

interface B {
    fun f() { print("B") } //接口的成员变量默认是 open 的
    fun b() { print("b") }
}

class C() : A() , B{
    override fun f() {
        super<A>.f()//调用 A.f()
        super<B>.f()//调用 B.f()
    }
}

interface Foo {
    val count: Int
}

class Bar1(override val count: Int) : Foo

class Bar2 : Foo {
    override var count: Int = 0
}
// 测试
fun main(args: Array<String>) {
    val s =  Student("Runoob", 18, "S12346", 89)
    println("学生名： ${s.name}")
    println("年龄： ${s.age}")
    println("学生号： ${s.no}")
    println("成绩： ${s.score}")
    var s1 =  Student1("Runoob", 18, "S12345", 89)

    val s2 =  Student2()
    s2.study();

    val c =  C()
    c.f();
}