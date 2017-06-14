package com.github.fwh007.kotlintest.dagger;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import javax.inject.Inject;

/**
 * TODO 类说明
 *
 * @author : Winter
 */


public class MainActivity extends AppCompatActivity {
    @Inject
    Pot pot;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerMainActivityComponent.create().inject(this);
        Toast.makeText(this, pot.show(), Toast.LENGTH_SHORT).show();
    }
}
