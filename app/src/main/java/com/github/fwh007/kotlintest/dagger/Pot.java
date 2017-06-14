package com.github.fwh007.kotlintest.dagger;

import javax.inject.Inject;

/**
 * TODO 类说明
 *
 * @author : Winter
 */


public class Pot {
    private Flower flower;

    public Pot(Flower flower) {
        this.flower = flower;
    }

    public String show() {
        return flower.whisper();
    }
}
