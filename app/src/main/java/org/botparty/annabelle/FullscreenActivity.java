package org.botparty.annabelle;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.botparty.annabelle.util.Helpers.*;

import org.botparty.annabelle.api.ViewController;
import org.botparty.annabelle.command.ChatCommand;
import org.botparty.annabelle.domain.CommunicationData;
import org.botparty.annabelle.parser.ChatParser;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.inject.Inject;


public class FullscreenActivity extends BaseActivity {

    /**
     * Whether or not the system UI should be auto-hidden after
     * {@link #AUTO_HIDE_DELAY_MILLIS} milliseconds.
     */
    private static final boolean AUTO_HIDE = true;

    /**
     * If {@link #AUTO_HIDE} is set, the number of milliseconds to wait after
     * user interaction before hiding the system UI.
     */
    private static final int AUTO_HIDE_DELAY_MILLIS = 3000;

    /**
     * Some older devices needs a small delay between UI widget updates
     * and a change of the status and navigation bar.
     */
    private static final int UI_ANIMATION_DELAY = 300;
    private final Handler mHideHandler = new Handler();
    private WebView mContentView;
    private final Runnable mHidePart2Runnable = new Runnable() {
        @SuppressLint("InlinedApi")
        @Override
        public void run() {
            // Delayed removal of status and navigation bar

            // Note that some of these constants are new as of API 16 (Jelly Bean)
            // and API 19 (KitKat). It is safe to use them, as they are inlined
            // at compile-time and do nothing on earlier devices.
            mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        }
    };
    private View mControlsView;
    private final Runnable mShowPart2Runnable = new Runnable() {
        @Override
        public void run() {
            // Delayed display of UI elements
            android.support.v7.app.ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.show();
            }
            mControlsView.setVisibility(View.VISIBLE);
        }
    };
    private boolean mVisible;
    public Button connectButton;
    public Button disconnectButton;

    Context context;
    @Inject ChatParser chatParser;
    @Inject ViewController viewController;


    private final Runnable mHideRunnable = new Runnable() {
        @Override
        public void run() {
            hide();
        }
    };
    /**
     * Touch listener to use for in-layout UI controls to delay hiding the
     * system UI. This is to prevent the jarring behavior of controls going away
     * while interacting with activity UI.
     */
    private final View.OnTouchListener mDelayHideTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (AUTO_HIDE) {
                delayedHide(AUTO_HIDE_DELAY_MILLIS);
            }
            return false;
        }
    };

    private AnnabelleComponent mAnnabelleComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAnnabelleComponent = DaggerAnnabelleComponent.builder()
                .appModule(new AppModule(getApplication()))
                .annabelleModule(new AnnabelleModule(this))
                .build();

        mAnnabelleComponent.inject(this);

        setContentView(R.layout.activity_fullscreen);
        this.context = this;


        mControlsView = findViewById(R.id.fullscreen_content_controls);
        mContentView = (WebView) findViewById(R.id.webview);
        mVisible = true;

        connectButton = (Button) findViewById(R.id.button_connect);
        connectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onConnect();
            }
        });
        connectButton.setOnTouchListener(mDelayHideTouchListener);
        connectButton.setEnabled(true);

        WebSettings webSettings = mContentView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        //init face animation
        viewController.setUri("");


        //set the initial face state, if configured
        String face = getProperty("normal.face", this);
        if (face != null && !face.equals("")) {
            viewController.setImage(face);
        }

        // Set up the user interaction to manually show or hide the system UI.
        mContentView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent ev) {
                toggle();
                return false;
            }
        });

        // Upon interacting with UI controls, delay any scheduled hide()
        // operations to prevent the jarring behavior of controls going away
        // while interacting with the UI.
        disconnectButton = (Button) findViewById(R.id.disconnect_button);
        disconnectButton.setOnTouchListener(mDelayHideTouchListener);
        disconnectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDisconnect();
            }
        });
        disconnectButton.setEnabled(false);


    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        // Trigger the initial hide() shortly after the activity has been
        // created, to briefly hint to the user that UI controls
        // are available.
        delayedHide(100);
    }

    private void toggle() {
        if (mVisible) {
            hide();
        } else {
            show();
        }
    }

    private void hide() {
        // Hide UI first
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        mControlsView.setVisibility(View.GONE);
        mVisible = false;

        // Schedule a runnable to remove the status and navigation bar after a delay
        mHideHandler.removeCallbacks(mShowPart2Runnable);
        mHideHandler.postDelayed(mHidePart2Runnable, UI_ANIMATION_DELAY);
    }

    @SuppressLint("InlinedApi")
    private void show() {
        // Show the system bar
        mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        mVisible = true;

        // Schedule a runnable to display UI elements after a delay
        mHideHandler.removeCallbacks(mHidePart2Runnable);
        mHideHandler.postDelayed(mShowPart2Runnable, UI_ANIMATION_DELAY);
    }

    /**
     * Schedules a call to hide() in [delay] milliseconds, canceling any
     * previously scheduled calls.
     */
    private void delayedHide(int delayMillis) {
        mHideHandler.removeCallbacks(mHideRunnable);
        mHideHandler.postDelayed(mHideRunnable, delayMillis);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public void onConnect() {
        connectWebSocket(getProperty("default.host", context),
                getProperty("default.port",context));

    }

    public void onDisconnect() {
        Toast.makeText(this, "Disconnect", Toast.LENGTH_SHORT).show();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                connectButton.setEnabled(true);
                disconnectButton.setEnabled(false);
            }
        });
    }

    class AsyncCommandTask extends AsyncTask<ChatCommand, Void, Void>{

        @Override
        protected Void doInBackground(ChatCommand... params) {
            for(ChatCommand cc : params) {
                cc.execute();
            }
            return null;
        }
    }

    public void parseMessage(String message) {

        ObjectMapper mapper = new ObjectMapper();
        CommunicationData data = null;
        try {
            data = mapper.readValue(message, CommunicationData.class);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        if(!"face".equals(data.getRecipient())) {
            return;
        }

        String sentMessage = data.getMessage();

        try {
            boolean firstTask = true;
            for (ChatCommand command : chatParser.parse(sentMessage)) {
                if (firstTask) {
                    firstTask = false;
                    new AsyncCommandTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, command);
                } else {
                    new AsyncCommandTask().executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, command);
                }
            }
        } catch (Throwable ex) {
            Log.e("task fail","something went wrong",ex);
        }
    }

    private void connectWebSocket(String address, String port) {
        URI uri;
        try {
            String socketAddress = String.format("ws://%s:%s", address, port);
            String toastText = String.format("Connecting to %s", socketAddress);
            Toast.makeText(this,toastText,Toast.LENGTH_SHORT).show();
            uri = new URI(socketAddress);
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return;
        }

        WebSocketClient mWebSocketClient = new WebSocketClient(uri) {
            @Override
            public void onOpen(ServerHandshake handshakedata) {
                runOnUiThread(new Runnable() {
                    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                    @Override
                    public void run() {
                        connectButton.setEnabled(false);
                        disconnectButton.setEnabled(true);
                        parseMessage("Anna bell ready for action meow");
                    }
                });

                this.send("Hello from " + Build.MANUFACTURER + " " + Build.MODEL);
            }

            @Override
            public void onMessage(final String message) {
                Log.i("Websocket", message);
                runOnUiThread(new Runnable() {
                    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                    @Override
                    public void run() {
                        parseMessage(message);
                    }
                });
            }

            @Override
            public void onClose(int code, String reason, boolean remote) {
                Log.i("Websocket", "Closed " + reason);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        connectButton.setEnabled(true);
                        disconnectButton.setEnabled(false);
                    }
                });
            }

            @Override
            public void onError(Exception ex) {

                Log.i("Websocket", "Error " + ex.getMessage());
            }
        };

        mWebSocketClient.connect();
    }

    public WebView getWebView() {
        return mContentView;
    }
}
