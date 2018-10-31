package kumarworld.rahul.kumarbioseeds.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import kumarworld.rahul.kumarbioseeds.R;
import kumarworld.rahul.kumarbioseeds.adapter.Adapter_SuccessStories;

public class Activity_SuccessStories extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private Adapter_SuccessStories mAdapterSuccessStories;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_stories);
        mRecyclerView=findViewById(R.id.recyclerStories);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapterSuccessStories=new Adapter_SuccessStories(this);
        mRecyclerView.setAdapter(mAdapterSuccessStories);
    }
}
