package br.com.ligeiro.cs.presentation.view.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.ligeiro.cs.R;

import br.com.ligeiro.cs.presentation.view.fragments.ReposFragment;
import br.com.ligeiro.cs.presentation.view.uicomponents.FragmentUtils;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentUtils.getOrCreate(this,"repos", new ReposFragment(), R.id.fragment_container);


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(getSupportFragmentManager().getBackStackEntryCount() == 0){
            finish();
        }
    }
}
