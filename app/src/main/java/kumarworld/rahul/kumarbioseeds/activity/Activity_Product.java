package kumarworld.rahul.kumarbioseeds.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import kumarworld.rahul.kumarbioseeds.R;
import kumarworld.rahul.kumarbioseeds.adapter.Adapter_Product;

public class Activity_Product extends AppCompatActivity {

    private ImageView mImgBack;
    private RecyclerView mRecyclerViewProduct;
    private Adapter_Product mAdapterProduct;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        mRecyclerViewProduct=findViewById(R.id.recycler_product);
        mImgBack=findViewById(R.id.img_arrowback);




        mRecyclerViewProduct.setHasFixedSize(true);
        GridLayoutManager recycleLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        mRecyclerViewProduct.setLayoutManager(recycleLayoutManager);
        mRecyclerViewProduct.setItemAnimator(new DefaultItemAnimator());
        mAdapterProduct  = new Adapter_Product(this);
        mRecyclerViewProduct.setAdapter(mAdapterProduct);

        mImgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
