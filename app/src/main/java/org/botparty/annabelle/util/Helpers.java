package org.botparty.annabelle.util;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by brandon on 2/25/2017.
 */

public final class Helpers {
    public static <T> T nullcoalesce(T... parms) {
        for (T parm : parms) {
            if (parm != null) return parm;
        }
        return null;
    }

    public static String getProperty(String key,Context context) {
        Properties properties = new Properties();
        AssetManager assetManager = context.getAssets();
        try {
            InputStream inputStream = assetManager.open("app.properties");
            properties.load(inputStream);

            return properties.getProperty(key);
        } catch (IOException ioex) {
            ioex.printStackTrace();
        }
        return null;
    }
}
