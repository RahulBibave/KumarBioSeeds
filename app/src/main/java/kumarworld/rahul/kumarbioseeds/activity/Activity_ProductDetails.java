package kumarworld.rahul.kumarbioseeds.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import kumarworld.rahul.kumarbioseeds.R;

public class Activity_ProductDetails extends AppCompatActivity {

    private ImageView mImgBack;
    private Button mBtnManual,mBtnChat,mBtnEnquiry;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        mImgBack=findViewById(R.id.img_arrowback);
        mBtnManual=findViewById(R.id.btnManual);
        mImgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mBtnManual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Activity_ProductDetails.this,Activity_CultivationManual.class);
                startActivity(intent);
            }
        });

    }
}
