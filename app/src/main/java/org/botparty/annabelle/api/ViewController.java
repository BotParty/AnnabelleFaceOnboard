package org.botparty.annabelle.api;

/**
 * Created by brandon on 2/12/2017.
 */

public interface ViewController {
    void setImage(String image);

    void setEyeState(String eyeState);

    void talk(boolean talkOn);

    void setUri(String uriStr);
}
