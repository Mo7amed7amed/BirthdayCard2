package com.example.mohamed.happybirthdaycard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class EditActivity extends AppCompatActivity {
    EditText mEditText1, mEditText2;
    Button mChooseImageBtn;
    Button mCreateBtn;
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        mEditText1 = (EditText) findViewById(R.id.mEditTextName);
        mEditText2 = (EditText) findViewById(R.id.mEditTextFriendName);
        mChooseImageBtn = (Button) findViewById(R.id.mChooseImage);
        mCreateBtn = (Button) findViewById(R.id.mCreateCard);
        mCreateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditActivity.this, MainActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("name", mEditText1.getText().toString());
                bundle.putString("friend_name", mEditText2.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });
        MobileAds.initialize(EditActivity.this, "ca-app-pub-8177797381753680~5926486701");
        mAdView = (AdView) findViewById(R.id.adView3);
        AdRequest adRequest3 = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest3);
    }
    /** Called when leaving the activity */
    @Override
    public void onPause() {
        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();
    }

    /** Called when returning to the activity */
    @Override
    public void onResume() {
        super.onResume();
        if (mAdView != null) {
            mAdView.resume();
        }
    }

    /** Called before the activity is destroyed */
    @Override
    public void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();
    }
}
