package kumarworld.rahul.kumarbioseeds.activity;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;

import kumarworld.rahul.kumarbioseeds.R;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private CardView cardProduct;
    private LinearLayout linproduct;
    private TextView txtProduct;
    private CardView cardEnquiry;
    private TextView txtEnquiry;
    private CardView cardSucess;
    private TextView txtSuccess;
    private CardView cardWeather;
    private TextView txtWeather;
    private CardView cardTechSupport;
    private TextView txtTechSupport;
    private CardView cardAbout;
    private TextView txtAbout;
    private View navHeader;
    LinearLayout linear_main;
    private Toolbar toolbar;

    private NavigationView navigationView, navForCart;
    private DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        cardProduct.setOnClickListener(this);
        cardEnquiry.setOnClickListener(this);
        cardSucess.setOnClickListener(this);
        cardTechSupport.setOnClickListener(this);
        cardWeather.setOnClickListener(this);
        cardAbout.setOnClickListener(this);


    }


    private void findViews() {
        cardProduct = findViewById(R.id.cardProduct);
        linproduct = findViewById(R.id.linproduct);
        txtProduct = findViewById(R.id.txtProduct);
        cardEnquiry = findViewById(R.id.cardEnquiry);
        txtEnquiry = findViewById(R.id.txtEnquiry);
        cardSucess = findViewById(R.id.cardSucess);
        txtSuccess = findViewById(R.id.txtSuccess);
        cardWeather = findViewById(R.id.cardWeather);
        txtWeather = findViewById(R.id.txtWeather);
        cardTechSupport = findViewById(R.id.cardTechSupport);
        txtTechSupport = findViewById(R.id.txtTechSupport);
        cardAbout = findViewById(R.id.cardAbout);
        txtAbout = findViewById(R.id.txtAbout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);


        navigationView.inflateMenu(R.menu.activity_home_drawer);
        navHeader = navigationView.inflateHeaderView(R.layout.lay_navigation_drawer_header);
        linear_main = (LinearLayout) findViewById(R.id.linear_main);
        setUpNavigationView();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cardProduct:
                Intent intent = new Intent(MainActivity.this, Activity_Categories.class);
                startActivity(intent);
                break;

            case R.id.cardEnquiry:
                Intent intentEnq = new Intent(MainActivity.this, Activity_Enquiry.class);
                startActivity(intentEnq);
                break;

            case R.id.cardSucess:
                Intent intentSuccess = new Intent(MainActivity.this, Activity_SuccessStories.class);
                startActivity(intentSuccess);
                break;

            case R.id.cardWeather:
                Intent intentWeather = new Intent(MainActivity.this, Activity_WetherReport.class);
                startActivity(intentWeather);
                break;

            case R.id.cardTechSupport:
                Intent intentTech = new Intent(MainActivity.this, Activity_TechSupport.class);
                startActivity(intentTech);
                break;
            case R.id.cardAbout:
                Intent intentAbout = new Intent(MainActivity.this, Activity_About.class);
                startActivity(intentAbout);
                break;
        }


    }


    private void setUpNavigationView() {
        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                //Check to see which item was being clicked and perform appropriate action
                drawerLayout.closeDrawers();
                switch (menuItem.getItemId()) {
                    //Replacing the main content with ContentFragment Which is our Inbox View;

                    case R.id.nav_home:
//                        replaceFragment(new fragment_Map());
//                        linear_Search.setVisibility(View.GONE);

                        return true;

                    case R.id.nav_profile:
//                        Intent intent=new Intent(MainActivity.this,Activity_Profile.class);
//                        startActivity(intent);

                        return true;

                    case R.id.nav_city:
                     /*   getCities();
                        if (cityArrayList==null||cityArrayList.size()>1){
                            getCities();
                            showCityListAlertDialog();

                        }
                        else {
                            showCityListAlertDialog();
                        }

*/
                        break;


                    case R.id.nav_serach_byCat:
                     /*   replaceFragment(new fragment_List());
                        linear_Search.setVisibility(View.GONE);*/
                        break;


                    case R.id.nav_logout:
                        // logoutApplication(getResources().getString(R.string.app_name),"Are You sure you want to Logout ?");


                        return true;

                    default:

                }

                //Checking if the item is in checked state or not, if not make it in checked state
                if (menuItem.isChecked()) {
                    menuItem.setChecked(false);
                } else {
                    menuItem.setChecked(true);
                }
                menuItem.setChecked(true);

                return true;
            }
        });


        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.openDrawer, R.string.closeDrawer) {

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                linear_main.setTranslationX(slideOffset * drawerView.getWidth());
                drawerLayout.bringChildToFront(drawerView);
                drawerLayout.requestLayout();
            }
        };

        //Setting the actionbarToggle to drawer layout
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessary or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();

    }

}
