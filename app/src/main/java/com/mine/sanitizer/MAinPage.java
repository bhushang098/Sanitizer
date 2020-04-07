package com.mine.sanitizer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;

public class MAinPage extends AppCompatActivity {
    ImageView imh;
    TextView tv;
    Button logout;
    GoogleSignInClient mgoogleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m_ain_page);

        imh = findViewById(R.id.img1);
        tv = findViewById(R.id.tvName);
        logout = findViewById(R.id.logoutBtn);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mgoogleSignInClient.signOut();

                Intent i = new Intent(MAinPage.this,MainActivity.class);
                startActivity(i);

            }
        });

        tv.setText(getIntent().getStringExtra("name"));
        String url = getIntent().getStringExtra("imgUrl");
        Glide.with(MAinPage.this).load(url).into(imh);
    }
}
