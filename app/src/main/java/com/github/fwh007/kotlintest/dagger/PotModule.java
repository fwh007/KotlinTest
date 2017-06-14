package com.github.fwh007.kotlintest.dagger;

import dagger.Module;
import dagger.Provides;

/**
 * TODO 类说明
 *
 * @author : Winter
 */

@Module
public class PotModule {

    @Provides
    Pot providePot(@RoseFlower Flower flower) {
        return new Pot(flower);
    }
}
