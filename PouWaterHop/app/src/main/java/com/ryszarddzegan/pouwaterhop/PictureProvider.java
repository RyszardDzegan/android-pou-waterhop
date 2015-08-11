package com.ryszarddzegan.pouwaterhop;

import android.content.Intent;

public interface PictureProvider extends GameImageRequiredListener {
    void processActivityResult(int requestCode, int resultCode, Intent data);
}
