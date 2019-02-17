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
		MagnetSDK.getSettings().setTestMode(false);
		
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
		//bannerAd.load("b29f84df-da2f-4b2b-8027-0ece3dbdd26b", adLayout);
		nativeAd.load("2f84c1f29e0408d5b305f98aad0e008e", adLayout, 300);
		//rewardAd.load("6417590d4c7108d59003fcd758743791");
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
