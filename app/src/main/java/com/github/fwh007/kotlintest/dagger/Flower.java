package com.github.fwh007.kotlintest.dagger;

/**
 * TODO 类说明
 *
 * @author : Winter
 */


public abstract class Flower {

    protected String name;

    Flower(String name) {
        this.name = name;
    }

    public abstract String whisper();
}
