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
import kumarworld.rahul.kumarbioseeds.activity.Activity_ProductDetails;

public class Adapter_Product extends RecyclerView.Adapter<Adapter_Product.ViewHolderProduct> {
    private Context mContext;


    public Adapter_Product(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolderProduct onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(mContext).inflate(R.layout.lay_product_view,viewGroup,false);
        ViewHolderProduct viewHolderProduct=new ViewHolderProduct(view);
        return viewHolderProduct;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderProduct viewHolderProduct, final int i) {
        viewHolderProduct.linearContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext,Activity_ProductDetails.class);
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolderProduct extends RecyclerView.ViewHolder{
        LinearLayout linearContainer;
        public ViewHolderProduct(@NonNull View itemView) {
            super(itemView);
            linearContainer=itemView.findViewById(R.id.linearContainer);
        }
    }
}
