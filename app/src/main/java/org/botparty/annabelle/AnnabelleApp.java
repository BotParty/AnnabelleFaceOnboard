package org.botparty.annabelle;

import android.app.Application;


/**
 * Created by brandon on 2/25/2017.
 */

public class AnnabelleApp extends Application {
    //private ObjectGraph graph;
    private AnnabelleComponent mAnnabelleComponent;

    @Override public void onCreate() {
        super.onCreate();

    }


    public AnnabelleComponent getAnnabelleComponent() {
        return mAnnabelleComponent;
    }


}
