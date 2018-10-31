package kumarworld.rahul.kumarbioseeds.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kumarworld.rahul.kumarbioseeds.R;

public class Adapter_SuccessStories extends RecyclerView.Adapter<Adapter_SuccessStories.ViewHolderStories> {
    private Context mContext;

    public Adapter_SuccessStories(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolderStories onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(mContext).inflate(R.layout.lay_success_stories_view,viewGroup,false);
        return new ViewHolderStories(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderStories viewHolderStories, int i) {

    }

    @Override
    public int getItemCount() {
        return 50;
    }


    public class ViewHolderStories extends RecyclerView.ViewHolder {
        public ViewHolderStories(@NonNull View itemView) {
            super(itemView);
        }
    }
}
