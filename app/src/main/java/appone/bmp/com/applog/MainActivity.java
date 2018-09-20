package appone.bmp.com.applog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import appone.bmp.com.applog.Fragment.FragmentInsertData;
import appone.bmp.com.applog.Fragment.FragmentList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState==null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.contentMain,new FragmentInsertData())
                    .commit();

        }
    }
}
