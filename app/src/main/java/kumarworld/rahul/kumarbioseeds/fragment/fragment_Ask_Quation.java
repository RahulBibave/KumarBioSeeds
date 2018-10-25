package kumarworld.rahul.kumarbioseeds.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import kumarworld.rahul.kumarbioseeds.R;

import static android.app.Activity.RESULT_OK;

public class fragment_Ask_Quation extends Fragment {

    private ImageView imgCapture,imageView;
    private final int requestCode=20;
    private EditText user_question;
    private TextView mTxtCount;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.lay_askquation,container,false);
        imgCapture=view.findViewById(R.id.image1);
        imageView=view.findViewById(R.id.image2);
        user_question=view.findViewById(R.id.user_question);
        mTxtCount=view.findViewById(R.id.txtCount);
        user_question.addTextChangedListener(mTextEditorWatcher);


        imgCapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCapture=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intentCapture,requestCode);
            }
        });




        return view;
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (this.requestCode==requestCode && resultCode==RESULT_OK){
            Bitmap bitmap=(Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(bitmap);
        }


    }

    private final TextWatcher mTextEditorWatcher = new TextWatcher() {
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
            //This sets a textview to the current length
            mTxtCount.setText(String.valueOf(s.length()));
        }

        public void afterTextChanged(Editable s) {
        }
    };


}
