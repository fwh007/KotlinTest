package com.github.fwh007.kotlintest.dagger;

import javax.inject.Inject;

/**
 * TODO 类说明
 *
 * @author : Winter
 */


public class Rose extends Flower {

    Rose(String name) {
        super(name);
    }

    @Override
    public String whisper() {
        return "热恋：" + name;
    }
}
