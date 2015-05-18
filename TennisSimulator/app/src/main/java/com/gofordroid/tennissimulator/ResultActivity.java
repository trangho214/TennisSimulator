package com.gofordroid.tennissimulator;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by TrangHo on 18-05-2015.
 */
public class ResultActivity extends Activity {
    double number;
    TextView txtNumberOfPlayer;
    ImageView ivBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        number = getIntent().getExtras().getInt("number");
        txtNumberOfPlayer = (TextView)findViewById(R.id.txtNumberOfPlayer);
        txtNumberOfPlayer.setText(String.valueOf(number)+ " players participate in the tournament.");
        ivBack = (ImageView)findViewById(R.id.ivBack);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavUtils.navigateUpFromSameTask(ResultActivity.this);
            }
        });


    }


}
