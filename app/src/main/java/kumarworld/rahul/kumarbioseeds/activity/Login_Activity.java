package kumarworld.rahul.kumarbioseeds.activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.util.PatternsCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import kumarworld.rahul.kumarbioseeds.R;
import kumarworld.rahul.kumarbioseeds.model.CommonUI;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;

public class Login_Activity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtUserName;
    private EditText edtUserPhone;
    private EditText edtUserEmail;
    private EditText edtUserCity;
    private EditText edtUserState;
    private Button btnLogin;
    private TextView txtSkip;
    private ArrayList<String> permissionsToRequest;
    private ArrayList<String> permissionsRejected = new ArrayList<>();
    private ArrayList<String> permissions = new ArrayList<>();
    private final static int ALL_PERMISSIONS_RESULT = 101;
    LocationTrack locationTrack;
    double longitude, latitude;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViews();
        permissions.add(ACCESS_FINE_LOCATION);
        permissions.add(ACCESS_COARSE_LOCATION);
        permissionsToRequest = findUnAskedPermissions(permissions);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            if (permissionsToRequest.size() > 0)
                requestPermissions(permissionsToRequest.toArray(new String[permissionsToRequest.size()]), ALL_PERMISSIONS_RESULT);
        }
        getLocation();
    }

    private void findViews() {
        edtUserName = findViewById( R.id.edtUserName );
        edtUserPhone = findViewById( R.id.edtUserPhone );
        edtUserEmail = findViewById( R.id.edtUserEmail );
        edtUserCity = findViewById( R.id.edtUserCity );
        edtUserState = findViewById( R.id.edtUserState );
        btnLogin = findViewById( R.id.btnLogin );
        txtSkip = findViewById( R.id.txtSkip );

        btnLogin.setOnClickListener( this );
        txtSkip.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        if ( v == btnLogin ) {
            if (validation()){
                Intent intent=new Intent(Login_Activity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }


        }else if (v==txtSkip){
            Intent intent=new Intent(Login_Activity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
    }


    private ArrayList<String> findUnAskedPermissions(ArrayList<String> wanted) {
        ArrayList<String> result = new ArrayList<String>();

        for (String perm : wanted) {
            if (!hasPermission(perm)) {
                result.add(perm);
            }
        }

        return result;
    }

    private boolean hasPermission(String permission) {
        if (canMakeSmores()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                return (checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED);
            }
        }
        return true;
    }

    private boolean canMakeSmores() {
        return (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1);
    }

    public void getLocation(){
        locationTrack = new LocationTrack(Login_Activity.this);
        if (locationTrack.canGetLocation()) {


            longitude = locationTrack.getLongitude();
            latitude = locationTrack.getLatitude();

            Log.e("current",""+latitude);

            try {

                Geocoder geo = new Geocoder(Login_Activity.this.getApplicationContext(), Locale.getDefault());
                List<Address> addresses = geo.getFromLocation(latitude, longitude, 1);
                Log.e("asasdadadadad",""+addresses.toString());

                if (addresses.isEmpty()) {
                    //  yourtextboxname.setText("Waiting for Location");
                }
                else {
                    if (addresses.size() > 0) {
                        //txtCurrent.setText(addresses.get(0).getFeatureName() + ", " + addresses.get(0).getLocality() +", " + addresses.get(0).getAdminArea() + ", " + addresses.get(0).getCountryName());
                        edtUserCity.setText(addresses.get(0).getLocality());
                        edtUserState.setText(addresses.get(0).getAdminArea());
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {

            locationTrack.showSettingsAlert();
        }


    }
    private boolean validation() {


        String name=edtUserName.getText().toString().trim();
        String phone=edtUserPhone.getText().toString().trim();
        String email=edtUserEmail.getText().toString().trim();
        String city=edtUserCity.getText().toString().trim();
        String state=edtUserState.getText().toString();


        if (name.equalsIgnoreCase(""))
            CommonUI.showAlert(this, getResources().getString(R.string.app_name), "Please Enter valid User Name");
        else if (phone.equalsIgnoreCase(""))
            CommonUI.showAlert(this, getResources().getString(R.string.app_name), "Please Enter Mobile No.");
        else if (phone.length()<10)
            CommonUI.showAlert(this, getResources().getString(R.string.app_name), "Please Enter Valid Mobile No.");
        else if (!(PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()))
            CommonUI.showAlert(this, getResources().getString(R.string.app_name), "Please Enter Valid Email Address.");
        else if (city.equalsIgnoreCase(""))
            CommonUI.showAlert(this, getResources().getString(R.string.app_name), "Please Enter City.");
        else if (state.equalsIgnoreCase(""))
            CommonUI.showAlert(this, getResources().getString(R.string.app_name), "Please Enter State");
        else
            return true;

        return false;
    }
}


