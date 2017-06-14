package com.github.fwh007.kotlintest.dagger;

import javax.inject.Inject;

/**
 * TODO 类说明
 *
 * @author : Winter
 */


public class Lily extends Flower {

    Lily(String name) {
        super(name);
    }

    @Override
    public String whisper() {
        return "纯洁："+name;
    }
}
