package org.botparty.annabelle.api;

import org.botparty.annabelle.FullscreenActivity;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by brandon on 2/25/2017.
 */

@Singleton
public class ViewControllerImpl implements ViewController {

    private FullscreenActivity _activity;
    private final String BASEURL = "file:///android_asset/face/index.html?showtime=&localstate=";
    private final String FACECTRL = "javascript:window.robotface.connectionmanager.setLocalState(" +
                                        "{emotion: '%s', eyeState: '%s', isTalking: %s}); ";


    private  String _currentEmotion;
    private  boolean _isTalking;
    private  String _eyeState;

    private void updateView() {
        _activity.getWebView().post(new Runnable() {
            @Override
            public void run() {
                _activity.getWebView().loadUrl(String.format(FACECTRL,_currentEmotion,_eyeState,_isTalking));
            }
        });
    }

    @Inject
    public ViewControllerImpl(FullscreenActivity activity) {
        _activity = activity;
    }

    @Override
    public void setImage(String image) {
        _currentEmotion = image;
        updateView();
    }

    @Override
    public void setEyeState(String eyeState) {
        _eyeState = eyeState;
        updateView();
    }

    @Override
    public void talk(boolean talkOn) {
        _isTalking = talkOn;
        updateView();
    }

    @Override
    public void setUri(String uriStr) {
        URL url;
        try {
            if (uriStr == null || uriStr.equals("")) {
                uriStr = BASEURL;
            }
            URI uri = new URI(uriStr);
            url = uri.toURL();
        }
        catch (MalformedURLException | URISyntaxException ex) {
            ex.printStackTrace();
            return;
        }
        _activity.getWebView().loadUrl(url.toString());
    }
}
