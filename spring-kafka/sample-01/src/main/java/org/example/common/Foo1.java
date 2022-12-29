package org.example.common;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2022/12/29 13:33
 */
public class Foo1 {
    private String foo;

    public Foo1() {
    }

    public Foo1(String foo) {
        this.foo = foo;
    }

    public String getFoo() {
        return this.foo;
    }

    public void setFoo(String foo) {
        this.foo = foo;
    }

    @Override
    public String toString() {
        return "Foo1 [foo=" + this.foo + "]";
    }

}
