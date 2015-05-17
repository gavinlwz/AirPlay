package com.pingfengluo.github.airplay;

import com.pingfengluo.github.airplay.util.Constants;
import com.pingfengluo.github.android.airplay.AirPlayServer;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

import com.pingfengluo.airplay.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Thread(AirPlayServer.getIstance(this)).start();
        
        findViewById(R.id.button1).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			Log.w("MainActivity", "PlayerState : "+MyApplication.getInstance().getPlayerState()) ;
		    MainActivity.this.sendBroadcast(new Intent(Constants.IKEY_MEDIA_PLAY_OR_PAUSE));
			}
		});
    }

}
