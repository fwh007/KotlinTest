package com.github.fwh007.kotlintest.dagger;

import dagger.Component;

/**
 * TODO 类说明
 *
 * @author : Winter
 */

@Component(modules = {FlowerModule.class, PotModule.class})
public interface MainActivityComponent {
    void inject(MainActivity activity);
}
