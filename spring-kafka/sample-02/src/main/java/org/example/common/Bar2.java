package org.example.common;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2022/12/29 14:43
 */
public class Bar2 {

    public String bar;

    public Bar2() {
    }

    public Bar2(String bar) {
        this.bar = bar;
    }

    public String getBar() {
        return this.bar;
    }

    public void setBar(String bar) {
        this.bar = bar;
    }

    @Override
    public String toString() {
        return "Bar1 [bar=" + this.bar + "]";
    }
}
