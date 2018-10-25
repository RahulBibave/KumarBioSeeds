package kumarworld.rahul.kumarbioseeds.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import kumarworld.rahul.kumarbioseeds.R;
import kumarworld.rahul.kumarbioseeds.adapter.Adapter_Categories;

public class Activity_Categories extends AppCompatActivity {
    private ImageView mImgBack;

    private RecyclerView mRecyclerViewCategories;
    private Adapter_Categories mAdapterCategories;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        mRecyclerViewCategories=findViewById(R.id.recyclerCate);
        mImgBack=findViewById(R.id.img_arrowback);

        mRecyclerViewCategories.setHasFixedSize(true);
        GridLayoutManager recycleLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        mRecyclerViewCategories.setLayoutManager(recycleLayoutManager);
        mRecyclerViewCategories.setItemAnimator(new DefaultItemAnimator());
        mAdapterCategories=new Adapter_Categories(this);
        mRecyclerViewCategories.setAdapter(mAdapterCategories);

        mImgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
