package com.example.mohamed.happybirthdaycard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class SplashActivity extends AppCompatActivity {
    ImageView mImageView;
    TextView mTextView;
    Button mButton;

    private AdView mAdView, mAdView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

//        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);

        mImageView = (ImageView) findViewById(R.id.mAppLogo);
        mTextView = (TextView) findViewById(R.id.mAppName);
        mButton = (Button) findViewById(R.id.mGetStartBtn);
        Animation myAnim = AnimationUtils.loadAnimation(SplashActivity.this, R.anim.transition);
        mTextView.startAnimation(myAnim);
        mImageView.startAnimation(myAnim);
        mButton.startAnimation(myAnim);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SplashActivity.this, EditActivity.class);
                startActivity(intent);
            }
        });
        MobileAds.initialize(SplashActivity.this, "ca-app-pub-8177797381753680~5926486701");
        mAdView = (AdView) findViewById(R.id.adView);
        mAdView2 = (AdView) findViewById(R.id.adView2);
        AdRequest adRequest = new AdRequest.Builder().build();
        AdRequest adRequest2 = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mAdView2.loadAd(adRequest2);
    }

    /**
     * Called when leaving the activity
     */
    @Override
    public void onPause() {
        if (mAdView != null) {
            mAdView.pause();
        }
        if (mAdView2 != null) {
            mAdView2.pause();
        }
        super.onPause();
    }

    /**
     * Called when returning to the activity
     */
    @Override
    public void onResume() {
        super.onResume();
        if (mAdView != null) {
            mAdView.resume();
        }
        if (mAdView2 != null) {
            mAdView2.resume();
        }
    }

    /**
     * Called before the activity is destroyed
     */
    @Override
    public void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy();
        }
        if (mAdView2 != null) {
            mAdView2.destroy();
        }
        super.onDestroy();
    }
}
