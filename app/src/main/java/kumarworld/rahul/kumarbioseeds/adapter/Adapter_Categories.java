package kumarworld.rahul.kumarbioseeds.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import kumarworld.rahul.kumarbioseeds.R;
import kumarworld.rahul.kumarbioseeds.activity.Activity_Product;

public class Adapter_Categories extends RecyclerView.Adapter<Adapter_Categories.ViewHolderCategories> {
    private Context mContext;

    public Adapter_Categories(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolderCategories onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(mContext).inflate(R.layout.lay_category_view,viewGroup,false);
        ViewHolderCategories viewHolderCategories=new ViewHolderCategories(view);
        return viewHolderCategories;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderCategories viewHolderCategories, int i) {

        viewHolderCategories.categoriesview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent=new Intent(mContext,Activity_Product.class);
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 50;
    }

    public class ViewHolderCategories extends RecyclerView.ViewHolder {
        LinearLayout categoriesview;
        public ViewHolderCategories(@NonNull View itemView) {
            super(itemView);
            categoriesview=itemView.findViewById(R.id.categoriesview);
        }
    }
}
