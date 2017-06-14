package com.github.fwh007.kotlintest.dagger;

import dagger.Module;
import dagger.Provides;

/**
 * TODO 类说明
 *
 * @author : Winter
 */

@Module
public class FlowerModule {
    @Provides
    @RoseFlower
    Flower provideRose() {
        return new Rose("Candi");
    }

    @Provides
    @LilyFlower
    Flower provideLily() {
        return new Lily("Wu");
    }
}
