package org.botparty.annabelle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by brandon on 2/25/2017.
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Perform injection so that when this call returns all dependencies will be available for use.
     //   ((AnnabelleApp) getApplication()).inject(this);
    }
}
