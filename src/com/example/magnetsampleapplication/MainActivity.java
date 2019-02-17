package com.example.magnetsampleapplication;

import com.magnetadservices.sdk.MagnetAdLoadListener;
import com.magnetadservices.sdk.MagnetMobileBannerAd;
import com.magnetadservices.sdk.MagnetNativeExpress;
import com.magnetadservices.sdk.MagnetRewardAd;
import com.magnetadservices.sdk.MagnetRewardListener;
import com.magnetadservices.sdk.MagnetSDK;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	private FrameLayout adLayout;
	
	private MagnetMobileBannerAd bannerAd;
	private MagnetNativeExpress nativeAd;
	private MagnetRewardAd rewardAd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		adLayout = (FrameLayout) findViewById(R.id.ad_layout);

		MagnetSDK.initialize(getApplicationContext());
		MagnetSDK.getSettings().setTestMode(true);
		
		bannerAd = MagnetMobileBannerAd.create(getApplicationContext());
		nativeAd = MagnetNativeExpress.create(getApplicationContext());

		rewardAd = MagnetRewardAd.create(getApplicationContext());
		rewardAd.setAdLoadListener(new MagnetAdLoadListener() {

			@Override
			public void onClose() {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "onClose", Toast.LENGTH_SHORT)
						.show();
			}

			@Override
			public void onFail(int arg0, String arg1) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "onFail", Toast.LENGTH_SHORT)
						.show();
			}

			@Override
			public void onPreload(int arg0, String arg1) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "onPreload",
						Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onReceive() {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "onReceive",
						Toast.LENGTH_SHORT).show();
			}
		});
	}

	public void loadRewardedAd(View view) {
		// TODO Replace AdUnitId with yours
		bannerAd.load("AdUnitId", adLayout);
		//nativeAd.load("AdUnitId", adLayout, 300);
		//rewardAd.load("AdUnitId");
	}

	public void showRewardedAd(View view) {
		if (rewardAd.isAdReady()) {
			rewardAd.show(new MagnetRewardListener() {
				@Override
				public void onFinish(boolean arg0) {
					// TODO Auto-generated method stub
					
				}
			});
		}
	}
}
