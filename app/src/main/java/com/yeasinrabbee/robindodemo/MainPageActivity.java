package com.yeasinrabbee.robindodemo;

import android.animation.ObjectAnimator;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import android.util.Log;
import android.util.LruCache;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes.dex */
public class MainPageActivity extends AppCompatActivity {
    private DrawerLayout _drawer;
    private LinearLayout _drawer_linear1;
    private LinearLayout _drawer_linear10;
    private LinearLayout _drawer_linear11;
    private LinearLayout _drawer_linear12;
    private LinearLayout _drawer_linear13;
    private LinearLayout _drawer_linear14;
    private LinearLayout _drawer_linear15;
    private LinearLayout _drawer_linear16;
    private LinearLayout _drawer_linear17;
    private LinearLayout _drawer_linear18;
    private LinearLayout _drawer_linear19;
    private LinearLayout _drawer_linear2;
    private LinearLayout _drawer_linear20;
    private LinearLayout _drawer_linear21;
    private LinearLayout _drawer_linear22;
    private LinearLayout _drawer_linear23;
    private LinearLayout _drawer_linear24;
    private LinearLayout _drawer_linear25;
    private LinearLayout _drawer_linear26;
    private LinearLayout _drawer_linear27;
    private LinearLayout _drawer_linear28;
    private LinearLayout _drawer_linear29;
    private LinearLayout _drawer_linear3;
    private LinearLayout _drawer_linear30;
    private LinearLayout _drawer_linear31;
    private LinearLayout _drawer_linear32;
    private LinearLayout _drawer_linear33;
    private LinearLayout _drawer_linear4;
    private LinearLayout _drawer_linear5;
    private LinearLayout _drawer_linear6;
    private LinearLayout _drawer_linear7;
    private LinearLayout _drawer_linear8;
    private LinearLayout _drawer_linear9;
    private TextView _drawer_textview_1;
    private TextView _drawer_textview_10;
    private TextView _drawer_textview_11;
    private TextView _drawer_textview_12;
    private TextView _drawer_textview_13;
    private TextView _drawer_textview_14;
    private TextView _drawer_textview_15;
    private TextView _drawer_textview_16;
    private TextView _drawer_textview_17;
    private TextView _drawer_textview_18;
    private TextView _drawer_textview_19;
    private TextView _drawer_textview_2;
    private TextView _drawer_textview_20;
    private TextView _drawer_textview_21;
    private TextView _drawer_textview_22;
    private TextView _drawer_textview_23;
    private TextView _drawer_textview_24;
    private TextView _drawer_textview_3;
    private TextView _drawer_textview_4;
    private TextView _drawer_textview_5;
    private TextView _drawer_textview_6;
    private TextView _drawer_textview_7;
    private TextView _drawer_textview_8;
    private TextView _drawer_textview_9;
    private ScrollView _drawer_vscroll1;
    private AdListener _interstitial_ad_listener;
    private Toolbar _toolbar;
    private AdView adview1;
    private AdView adview2;
    private AlertDialog.Builder backpress;
    private SharedPreferences data;
    private AlertDialog.Builder feedback;
    private ImageView imageview10;
    private ImageView imageview11;
    private ImageView imageview12;
    private ImageView imageview13;
    private ImageView imageview14;
    private ImageView imageview5;
    private ImageView imageview6;
    private ImageView imageview7;
    private ImageView imageview8;
    private ImageView imageview9;
    private ImageView imageview_about;
    private ImageView imageview_check_1;
    private ImageView imageview_check_2;
    private ImageView imageview_check_3;
    private ImageView imageview_check_4;
    private ImageView imageview_download;
    private ImageView imageview_drawer;
    private ImageView imageview_email;
    private ImageView imageview_feedback;
    private ImageView imageview_more;
    private ImageView imageview_rating;
    private ImageView imageview_share;
    private InterstitialAd interstitial;
    private LinearLayout linear1;
    private LinearLayout linear3;
    private LinearLayout linear4;
    private LinearLayout linear9;
    private LinearLayout linear_actionbar;
    private LinearLayout linear_bar_1;
    private LinearLayout linear_bar_2;
    private LinearLayout linear_bar_3;
    private LinearLayout linear_card;
    private LinearLayout linear_card_contain;
    private LinearLayout linear_email;
    private LinearLayout linear_exit;
    private LinearLayout linear_feedback;
    private LinearLayout linear_menu;
    private LinearLayout linear_more;
    private LinearLayout linear_rating;
    private LinearLayout linear_sub_tab_1;
    private LinearLayout linear_sub_tab_10;
    private LinearLayout linear_sub_tab_2;
    private LinearLayout linear_sub_tab_3;
    private LinearLayout linear_sub_tab_4;
    private LinearLayout linear_sub_tab_5;
    private LinearLayout linear_sub_tab_6;
    private LinearLayout linear_sub_tab_7;
    private LinearLayout linear_sub_tab_8;
    private LinearLayout linear_sub_tab_9;
    private LinearLayout linear_tab_1;
    private LinearLayout linear_tab_10;
    private LinearLayout linear_tab_2;
    private LinearLayout linear_tab_3;
    private LinearLayout linear_tab_4;
    private LinearLayout linear_tab_5;
    private LinearLayout linear_tab_6;
    private LinearLayout linear_tab_7;
    private LinearLayout linear_tab_8;
    private LinearLayout linear_tab_9;
    private LinearLayout linear_tab_bar_1;
    private LinearLayout linear_tab_bar_2;
    private LinearLayout linear_tab_bar_3;
    private LinearLayout linear_theme;
    private LinearLayout linear_toolbar;
    private TextView textview1;
    private TextView textview10;
    private TextView textview11;
    private TextView textview12;
    private TextView textview13;
    private TextView textview14;
    private TextView textview15;
    private TextView textview16;
    private TextView textview17;
    private TextView textview2;
    private TextView textview3;
    private TextView textview4;
    private TextView textview5;
    private TextView textview6;
    private TextView textview7;
    private TextView textview8;
    private TextView textview9;
    private LinearLayout theme1_button;
    private LinearLayout theme2_button;
    private LinearLayout theme3_button;
    private LinearLayout theme4_button;
    private TimerTask tmr;
    private ScrollView vscroll1;
    private Timer _timer = new Timer();
    private String fontName = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    private String typeace = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    private String aa = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    private String bb = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    private String code = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    private String colorPrimary = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    private String colorPrimaryDark = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    private String ColorText = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    private String ColorTextToo = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    private double Radius = 0.0d;
    private double Shadow = 0.0d;
    private double Stroke = 0.0d;
    private String Email_ID_Arefin_Khaled = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    private String Email_ID_Arefin_Studio = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    private String Email_ID_Arefin_Library = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    private String DevID_Arefin_Khaled = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    private String DevID_Arefin_Studio = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    private String DevID_Arefin_Library = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    private String PACKAGE_NAME = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    private String AppName = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    private String title = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    private String subtitle = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    private String AppID = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    private String DevEmail = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    private String DevID = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    private String site_1 = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    private String site_2 = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    private String site_3 = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    private Intent i = new Intent();
    private Intent web = new Intent();
    private Intent dev = new Intent();
    private Intent apps = new Intent();
    private Intent dow = new Intent();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.main_page);
        initialize(bundle);
        initializeLogic();
    }

    private void initialize(Bundle bundle) {
        this._toolbar = (Toolbar) findViewById(R.id._toolbar);
        setSupportActionBar(this._toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        this._toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.arefin.rabindra.MainPageActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MainPageActivity.this.onBackPressed();
            }
        });
        this._drawer = (DrawerLayout) findViewById(R.id._drawer);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, this._drawer, this._toolbar, R.string.app_name, R.string.app_name);
        this._drawer.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id._nav_view);
        this.linear1 = (LinearLayout) findViewById(R.id.linear1);
        this.linear_actionbar = (LinearLayout) findViewById(R.id.linear_actionbar);
        this.vscroll1 = (ScrollView) findViewById(R.id.vscroll1);
        this.linear3 = (LinearLayout) findViewById(R.id.linear3);
        this.linear_toolbar = (LinearLayout) findViewById(R.id.linear_toolbar);
        this.imageview_drawer = (ImageView) findViewById(R.id.imageview_drawer);
        this.linear_menu = (LinearLayout) findViewById(R.id.linear_menu);
        this.imageview_download = (ImageView) findViewById(R.id.imageview_download);
        this.imageview_share = (ImageView) findViewById(R.id.imageview_share);
        this.textview1 = (TextView) findViewById(R.id.textview1);
        this.linear4 = (LinearLayout) findViewById(R.id.linear4);
        this.linear_card_contain = (LinearLayout) findViewById(R.id.linear_card_contain);
        this.linear9 = (LinearLayout) findViewById(R.id.linear9);
        this.linear_bar_3 = (LinearLayout) findViewById(R.id.linear_bar_3);
        this.adview1 = (AdView) findViewById(R.id.adview1);
        this.linear_card = (LinearLayout) findViewById(R.id.linear_card);
        this.linear_bar_1 = (LinearLayout) findViewById(R.id.linear_bar_1);
        this.linear_theme = (LinearLayout) findViewById(R.id.linear_theme);
        this.linear_bar_2 = (LinearLayout) findViewById(R.id.linear_bar_2);
        this.imageview5 = (ImageView) findViewById(R.id.imageview5);
        this.theme4_button = (LinearLayout) findViewById(R.id.theme4_button);
        this.theme1_button = (LinearLayout) findViewById(R.id.theme1_button);
        this.theme2_button = (LinearLayout) findViewById(R.id.theme2_button);
        this.theme3_button = (LinearLayout) findViewById(R.id.theme3_button);
        this.imageview_check_4 = (ImageView) findViewById(R.id.imageview_check_4);
        this.imageview_check_1 = (ImageView) findViewById(R.id.imageview_check_1);
        this.imageview_check_2 = (ImageView) findViewById(R.id.imageview_check_2);
        this.imageview_check_3 = (ImageView) findViewById(R.id.imageview_check_3);
        this.linear_tab_bar_1 = (LinearLayout) findViewById(R.id.linear_tab_bar_1);
        this.linear_tab_bar_2 = (LinearLayout) findViewById(R.id.linear_tab_bar_2);
        this.linear_tab_bar_3 = (LinearLayout) findViewById(R.id.linear_tab_bar_3);
        this.linear_tab_10 = (LinearLayout) findViewById(R.id.linear_tab_10);
        this.linear_tab_1 = (LinearLayout) findViewById(R.id.linear_tab_1);
        this.linear_tab_2 = (LinearLayout) findViewById(R.id.linear_tab_2);
        this.linear_tab_3 = (LinearLayout) findViewById(R.id.linear_tab_3);
        this.linear_sub_tab_1 = (LinearLayout) findViewById(R.id.linear_sub_tab_1);
        this.imageview6 = (ImageView) findViewById(R.id.imageview6);
        this.textview4 = (TextView) findViewById(R.id.textview4);
        this.linear_sub_tab_2 = (LinearLayout) findViewById(R.id.linear_sub_tab_2);
        this.imageview7 = (ImageView) findViewById(R.id.imageview7);
        this.textview9 = (TextView) findViewById(R.id.textview9);
        this.linear_sub_tab_3 = (LinearLayout) findViewById(R.id.linear_sub_tab_3);
        this.imageview8 = (ImageView) findViewById(R.id.imageview8);
        this.textview10 = (TextView) findViewById(R.id.textview10);
        this.linear_tab_4 = (LinearLayout) findViewById(R.id.linear_tab_4);
        this.linear_tab_5 = (LinearLayout) findViewById(R.id.linear_tab_5);
        this.linear_tab_6 = (LinearLayout) findViewById(R.id.linear_tab_6);
        this.linear_sub_tab_4 = (LinearLayout) findViewById(R.id.linear_sub_tab_4);
        this.imageview9 = (ImageView) findViewById(R.id.imageview9);
        this.textview11 = (TextView) findViewById(R.id.textview11);
        this.linear_sub_tab_5 = (LinearLayout) findViewById(R.id.linear_sub_tab_5);
        this.imageview10 = (ImageView) findViewById(R.id.imageview10);
        this.textview12 = (TextView) findViewById(R.id.textview12);
        this.linear_sub_tab_6 = (LinearLayout) findViewById(R.id.linear_sub_tab_6);
        this.imageview11 = (ImageView) findViewById(R.id.imageview11);
        this.textview13 = (TextView) findViewById(R.id.textview13);
        this.linear_tab_7 = (LinearLayout) findViewById(R.id.linear_tab_7);
        this.linear_tab_8 = (LinearLayout) findViewById(R.id.linear_tab_8);
        this.linear_tab_9 = (LinearLayout) findViewById(R.id.linear_tab_9);
        this.linear_sub_tab_7 = (LinearLayout) findViewById(R.id.linear_sub_tab_7);
        this.imageview12 = (ImageView) findViewById(R.id.imageview12);
        this.textview14 = (TextView) findViewById(R.id.textview14);
        this.linear_sub_tab_8 = (LinearLayout) findViewById(R.id.linear_sub_tab_8);
        this.imageview13 = (ImageView) findViewById(R.id.imageview13);
        this.textview15 = (TextView) findViewById(R.id.textview15);
        this.linear_sub_tab_9 = (LinearLayout) findViewById(R.id.linear_sub_tab_9);
        this.imageview14 = (ImageView) findViewById(R.id.imageview14);
        this.textview16 = (TextView) findViewById(R.id.textview16);
        this.linear_sub_tab_10 = (LinearLayout) findViewById(R.id.linear_sub_tab_10);
        this.textview17 = (TextView) findViewById(R.id.textview17);
        this.textview3 = (TextView) findViewById(R.id.textview3);
        this.adview2 = (AdView) findViewById(R.id.adview2);
        this.linear_feedback = (LinearLayout) findViewById(R.id.linear_feedback);
        this.linear_rating = (LinearLayout) findViewById(R.id.linear_rating);
        this.linear_more = (LinearLayout) findViewById(R.id.linear_more);
        this.linear_email = (LinearLayout) findViewById(R.id.linear_email);
        this.linear_exit = (LinearLayout) findViewById(R.id.linear_exit);
        this.imageview_feedback = (ImageView) findViewById(R.id.imageview_feedback);
        this.textview2 = (TextView) findViewById(R.id.textview2);
        this.imageview_rating = (ImageView) findViewById(R.id.imageview_rating);
        this.textview8 = (TextView) findViewById(R.id.textview8);
        this.imageview_more = (ImageView) findViewById(R.id.imageview_more);
        this.textview5 = (TextView) findViewById(R.id.textview5);
        this.imageview_email = (ImageView) findViewById(R.id.imageview_email);
        this.textview6 = (TextView) findViewById(R.id.textview6);
        this.imageview_about = (ImageView) findViewById(R.id.imageview_about);
        this.textview7 = (TextView) findViewById(R.id.textview7);
        this._drawer_linear1 = (LinearLayout) linearLayout.findViewById(R.id.linear1);
        this._drawer_linear2 = (LinearLayout) linearLayout.findViewById(R.id.linear2);
        this._drawer_vscroll1 = (ScrollView) linearLayout.findViewById(R.id.vscroll1);
        this._drawer_textview_1 = (TextView) linearLayout.findViewById(R.id.textview_1);
        this._drawer_textview_2 = (TextView) linearLayout.findViewById(R.id.textview_2);
        this._drawer_linear3 = (LinearLayout) linearLayout.findViewById(R.id.linear3);
        this._drawer_linear4 = (LinearLayout) linearLayout.findViewById(R.id.linear4);
        this._drawer_linear7 = (LinearLayout) linearLayout.findViewById(R.id.linear7);
        this._drawer_linear8 = (LinearLayout) linearLayout.findViewById(R.id.linear8);
        this._drawer_linear9 = (LinearLayout) linearLayout.findViewById(R.id.linear9);
        this._drawer_linear16 = (LinearLayout) linearLayout.findViewById(R.id.linear16);
        this._drawer_linear19 = (LinearLayout) linearLayout.findViewById(R.id.linear19);
        this._drawer_linear22 = (LinearLayout) linearLayout.findViewById(R.id.linear22);
        this._drawer_linear25 = (LinearLayout) linearLayout.findViewById(R.id.linear25);
        this._drawer_linear28 = (LinearLayout) linearLayout.findViewById(R.id.linear28);
        this._drawer_linear31 = (LinearLayout) linearLayout.findViewById(R.id.linear31);
        this._drawer_textview_23 = (TextView) linearLayout.findViewById(R.id.textview_23);
        this._drawer_textview_24 = (TextView) linearLayout.findViewById(R.id.textview_24);
        this._drawer_linear5 = (LinearLayout) linearLayout.findViewById(R.id.linear5);
        this._drawer_linear6 = (LinearLayout) linearLayout.findViewById(R.id.linear6);
        this._drawer_textview_3 = (TextView) linearLayout.findViewById(R.id.textview_3);
        this._drawer_textview_4 = (TextView) linearLayout.findViewById(R.id.textview_4);
        this._drawer_linear10 = (LinearLayout) linearLayout.findViewById(R.id.linear10);
        this._drawer_linear11 = (LinearLayout) linearLayout.findViewById(R.id.linear11);
        this._drawer_textview_5 = (TextView) linearLayout.findViewById(R.id.textview_5);
        this._drawer_textview_6 = (TextView) linearLayout.findViewById(R.id.textview_6);
        this._drawer_linear12 = (LinearLayout) linearLayout.findViewById(R.id.linear12);
        this._drawer_linear13 = (LinearLayout) linearLayout.findViewById(R.id.linear13);
        this._drawer_textview_7 = (TextView) linearLayout.findViewById(R.id.textview_7);
        this._drawer_textview_8 = (TextView) linearLayout.findViewById(R.id.textview_8);
        this._drawer_linear14 = (LinearLayout) linearLayout.findViewById(R.id.linear14);
        this._drawer_linear15 = (LinearLayout) linearLayout.findViewById(R.id.linear15);
        this._drawer_textview_9 = (TextView) linearLayout.findViewById(R.id.textview_9);
        this._drawer_textview_10 = (TextView) linearLayout.findViewById(R.id.textview_10);
        this._drawer_linear17 = (LinearLayout) linearLayout.findViewById(R.id.linear17);
        this._drawer_linear18 = (LinearLayout) linearLayout.findViewById(R.id.linear18);
        this._drawer_textview_11 = (TextView) linearLayout.findViewById(R.id.textview_11);
        this._drawer_textview_12 = (TextView) linearLayout.findViewById(R.id.textview_12);
        this._drawer_linear20 = (LinearLayout) linearLayout.findViewById(R.id.linear20);
        this._drawer_linear21 = (LinearLayout) linearLayout.findViewById(R.id.linear21);
        this._drawer_textview_13 = (TextView) linearLayout.findViewById(R.id.textview_13);
        this._drawer_textview_14 = (TextView) linearLayout.findViewById(R.id.textview_14);
        this._drawer_linear23 = (LinearLayout) linearLayout.findViewById(R.id.linear23);
        this._drawer_linear24 = (LinearLayout) linearLayout.findViewById(R.id.linear24);
        this._drawer_textview_15 = (TextView) linearLayout.findViewById(R.id.textview_15);
        this._drawer_textview_16 = (TextView) linearLayout.findViewById(R.id.textview_16);
        this._drawer_linear26 = (LinearLayout) linearLayout.findViewById(R.id.linear26);
        this._drawer_linear27 = (LinearLayout) linearLayout.findViewById(R.id.linear27);
        this._drawer_textview_17 = (TextView) linearLayout.findViewById(R.id.textview_17);
        this._drawer_textview_18 = (TextView) linearLayout.findViewById(R.id.textview_18);
        this._drawer_linear29 = (LinearLayout) linearLayout.findViewById(R.id.linear29);
        this._drawer_linear30 = (LinearLayout) linearLayout.findViewById(R.id.linear30);
        this._drawer_textview_19 = (TextView) linearLayout.findViewById(R.id.textview_19);
        this._drawer_textview_20 = (TextView) linearLayout.findViewById(R.id.textview_20);
        this._drawer_linear32 = (LinearLayout) linearLayout.findViewById(R.id.linear32);
        this._drawer_linear33 = (LinearLayout) linearLayout.findViewById(R.id.linear33);
        this._drawer_textview_21 = (TextView) linearLayout.findViewById(R.id.textview_21);
        this._drawer_textview_22 = (TextView) linearLayout.findViewById(R.id.textview_22);
        this.feedback = new AlertDialog.Builder(this);
        this.backpress = new AlertDialog.Builder(this);
        this.data = getSharedPreferences("data", 0);
        this.imageview_drawer.setOnClickListener(new View.OnClickListener() { // from class: com.arefin.rabindra.MainPageActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MainPageActivity.this._drawer.isDrawerOpen(GravityCompat.START)) {
                    MainPageActivity.this._drawer.closeDrawer(GravityCompat.START);
                } else {
                    MainPageActivity.this._drawer.openDrawer(GravityCompat.START);
                }
            }
        });
        this.imageview_download.setOnClickListener(new View.OnClickListener() { // from class: com.arefin.rabindra.MainPageActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MainPageActivity.this.dev.setAction("android.intent.action.VIEW");
                MainPageActivity.this.dev.setClass(MainPageActivity.this.getApplicationContext(), DeveloperActivity.class);
                MainPageActivity.this.startActivity(MainPageActivity.this.dev);
            }
        });
        this.imageview_share.setOnClickListener(new View.OnClickListener() { // from class: com.arefin.rabindra.MainPageActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MainPageActivity.this._Share();
            }
        });
        this.theme4_button.setOnClickListener(new View.OnClickListener() { // from class: com.arefin.rabindra.MainPageActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MainPageActivity.this.interstitial.show();
                MainPageActivity.this._theme("theme4");
            }
        });
        this.theme1_button.setOnClickListener(new View.OnClickListener() { // from class: com.arefin.rabindra.MainPageActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MainPageActivity.this.interstitial.show();
                MainPageActivity.this._theme("theme1");
            }
        });
        this.theme2_button.setOnClickListener(new View.OnClickListener() { // from class: com.arefin.rabindra.MainPageActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MainPageActivity.this.interstitial.show();
                MainPageActivity.this._theme("theme2");
            }
        });
        this.theme3_button.setOnClickListener(new View.OnClickListener() { // from class: com.arefin.rabindra.MainPageActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MainPageActivity.this.interstitial.show();
                MainPageActivity.this._theme("theme3");
            }
        });
        this.linear_tab_10.setOnClickListener(new AnonymousClass9());
        this.linear_tab_1.setOnClickListener(new AnonymousClass10());
        this.linear_tab_2.setOnClickListener(new AnonymousClass11());
        this.linear_tab_3.setOnClickListener(new AnonymousClass12());
        this.linear_tab_4.setOnClickListener(new AnonymousClass13());
        this.linear_tab_5.setOnClickListener(new AnonymousClass14());
        this.linear_tab_6.setOnClickListener(new AnonymousClass15());
        this.linear_tab_7.setOnClickListener(new AnonymousClass16());
        this.linear_tab_8.setOnClickListener(new AnonymousClass17());
        this.linear_tab_9.setOnClickListener(new AnonymousClass18());
        this.linear_feedback.setOnClickListener(new View.OnClickListener() { // from class: com.arefin.rabindra.MainPageActivity.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MainPageActivity.this._Feedback();
            }
        });
        this.linear_rating.setOnClickListener(new View.OnClickListener() { // from class: com.arefin.rabindra.MainPageActivity.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MainPageActivity.this._Rate_Apps();
            }
        });
        this.linear_more.setOnClickListener(new View.OnClickListener() { // from class: com.arefin.rabindra.MainPageActivity.21
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MainPageActivity.this._More_Apps();
            }
        });
        this.linear_email.setOnClickListener(new View.OnClickListener() { // from class: com.arefin.rabindra.MainPageActivity.22
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MainPageActivity.this._Email_Us();
            }
        });
        this.linear_exit.setOnClickListener(new View.OnClickListener() { // from class: com.arefin.rabindra.MainPageActivity.23
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MainPageActivity.this._ButtomSheet();
            }
        });
        this._interstitial_ad_listener = new AdListener() { // from class: com.arefin.rabindra.MainPageActivity.24
            @Override // com.google.android.gms.ads.AdListener
            public void onAdLoaded() {
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdFailedToLoad(int i) {
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdOpened() {
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdClosed() {
                MainPageActivity.this.interstitial.loadAd(new AdRequest.Builder().build());
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.arefin.rabindra.MainPageActivity$9  reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass9 implements View.OnClickListener {
        AnonymousClass9() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MainPageActivity.this._Card_View(MainPageActivity.this.linear_tab_10, MainPageActivity.this.Radius, MainPageActivity.this.colorPrimary, MainPageActivity.this.Shadow, MainPageActivity.this.Stroke, MainPageActivity.this.colorPrimaryDark);
            MainPageActivity.this.tmr = new TimerTask() { // from class: com.arefin.rabindra.MainPageActivity.9.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    MainPageActivity.this.runOnUiThread(new Runnable() { // from class: com.arefin.rabindra.MainPageActivity.9.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MainPageActivity.this._Card_View(MainPageActivity.this.linear_tab_10, MainPageActivity.this.Radius, MainPageActivity.this.colorPrimaryDark, MainPageActivity.this.Shadow, MainPageActivity.this.Stroke, MainPageActivity.this.colorPrimary);
                            MainPageActivity.this.i.putExtra(AppMeasurementSdk.ConditionalUserProperty.NAME, "রবীন্দ্রনাথ ঠাকুরের জীবনী");
                            MainPageActivity.this.i.putExtra("content", ("ঠাকুর, রবীন্দ্রনাথ (১৮৬১-১৯৪১)  কবি, সঙ্গীতজ্ঞ, কথাসাহিত্যিক, নাট্যকার, চিত্রশিল্পী, প্রাবন্ধিক, দার্শনিক, শিক্ষাবিদ ও সমাজ-সংস্কারক। মূলত কবি হিসেবেই তাঁর প্রতিভা বিশ্বময় স্বীকৃত। ১৯১৩ সালে তাঁকে নোবেল পুরস্কারে ভূষিত করা হয়। এশিয়ার বিদগ্ধ ও বরেণ্য ব্যক্তিদের মধ্যে তিনিই প্রথম এই পুরস্কার জয়ের গৌরব অর্জন করেন।\n\nরবীন্দ্রনাথের সমগ্র জীবনের প্রেক্ষাপটেই তাঁর কবিমানস ও সাহিত্যকর্মের স্বরূপ অনুধাবন সম্ভব। জীবনের পর্বে পর্বে তাঁর জীবনজিজ্ঞাসা ও সাহিত্যাদর্শের পরিবর্তন ঘটেছে। যুগে যুগে পৃথিবীতে সাহিত্য, সংস্কৃতি, সভ্যতা,  দর্শন ও জ্ঞান-বিজ্ঞানের ক্ষেত্রে যে রূপান্তর ঘটেছে, রবীন্দ্রনাথ সবকিছুকেই আত্মস্থ করেছেন গভীর অনুশীলন, ক্রমাগত নিরীক্ষা এবং বিশ্বপরিক্রমার মধ্য দিয়ে। তাই তাঁর সাহিত্যজীবনের নানা পর্যায়ে বিষয় ও আঙ্গিকের নিরন্তর পালাবদল লক্ষণীয়। এই পরীক্ষা-নিরীক্ষার ফসল তাঁর অসংখ্য কবিতা, গান,  ছোটগল্প,  উপন্যাস, প্রবন্ধ, নাটক, গীতিনাট্য,  নৃত্যনাট্য, ভ্রমণকাহিনী, চিঠিপত্র এবং দেশে বিদেশে প্রদত্ত বক্তৃতামালা। রবীন্দ্রনাথের অন্তর্নিহিত জীবনবোধ ছিল স্থির এবং বহু পরিবর্তনকে স্বীকার করে নিয়েও আপন আদর্শে প্রতিষ্ঠিত; অন্যদিকে তাঁর সৃজনশীল রূপটি ছিল চলিষ্ণু ও পরিবর্তনশীল। রবীন্দ্রনাথ কেবল তাঁর কালের কবি নন, তিনি কালজয়ী। বাংলা কাব্যসাহিত্যের ইতিহাসে তাঁর আবির্ভাব ছিল এক যুগান্তর।\n\nরবীন্দ্রনাথ ঠাকুরের জন্ম ১৮৬১ সালের ৭ মে (১২৬৮ বঙ্গাব্দের ২৫ বৈশাখ) কলকাতার জোড়াসাঁকোর অভিজাত ঠাকুর পরিবারে। তাঁর পিতা মহর্ষি  দেবেন্দ্রনাথ ঠাকুর]] এবং পিতামহ প্রিন্স  দ্বারকানাথ ঠাকুর। এই পরিবারের পূর্বপুরুষ পূর্ববঙ্গ থেকে ব্যবসায়ের সূত্রে কলকাতায় গিয়ে বসবাস শুরু করেন। দ্বারকানাথ ঠাকুরের চেষ্টায় এ বংশের জমিদারি এবং ধনসম্পদ বৃদ্ধি পায়। ইংরেজি শিক্ষা ও সংস্কৃতিতে লালিত এবং আত্মপ্রতিষ্ঠিত দ্বারকানাথ ব্যবসা-বাণিজ্যের পাশাপাশি জনহিতকর কাজেও সাফল্য অর্জন করেন। উনিশ শতকের বাঙালির নবজাগরণ এবং ধর্ম ও সমাজ-সংস্কার আন্দোলনে জোড়াসাঁকোর ঠাকুর পরিবারের ভূমিকা বিশেষভাবে স্মরণযোগ্য। এ যুগের অন্যতম সমাজ-সংস্কারক এবং একেশ্বরবাদের প্রবক্তা  রামমোহন রায় ছিলেন দ্বারকানাথের ঘনিষ্ঠ বন্ধু। রামমোহন রায়ের আদর্শ দ্বারকানাথ, তাঁর পুত্র দেবেন্দ্রনাথ এবং দৌহিত্র রবীন্দ্রনাথের ওপর এক অভাবনীয় প্রভাব বিস্তার করে।\n\nনবজাগ্রত বাঙালি সমাজের পুরোধা রবীন্দ্রনাথ ঠাকুরের পিতা দেবেন্দ্রনাথ ঠাকুর হিন্দু কলেজে শিক্ষালাভ করেন। দ্বারকানাথ যখন ব্যবসায় এবং জমিদারি পরিচালনায় ব্যাপৃত, সে সময় পুত্র দেবেন্দ্রনাথের মধ্যে সঞ্চারিত হয় আধ্যাত্মিক চেতনা। ঈশ্বর-ব্যাকুলতায় তিনি ইউরোপীয় ও ভারতীয় দর্শনের প্রতি নিবিষ্ট হন। অবশেষে  উপনিষদ চর্চার মাধ্যমে তাঁর আত্মা স্থিত হয় এবং এক বিশুদ্ধ সত্যের উপলব্ধিতে তাঁর মধ্যে জেগে ওঠে আত্মপ্রত্যয়। দেবেন্দ্রনাথের এই বৈশিষ্ট্যই আকৃষ্ট করে পুত্র রবীন্দ্রনাথকে। তাঁর সমগ্র মনোজগতে এবং ব্যবহারিক জীবনে পিতার প্রভাব ছিল অত্যন্ত গভীর। পিতার মধ্যেই রবীন্দ্রনাথ দেখেছিলেন একজন আদর্শ ব্যক্তিকে, যিনি জাগতিক বিষয়ে নিষ্ঠাবান অথচ নিরাসক্ত, প্রখর যুক্তিবাদী কিন্তু হূদয়বান।\n\nসততায়, ধর্মবোধে, ঋষিসুলভ চারিত্রিক গুণে এবং উদার আভিজাত্যে দেবেন্দ্রনাথ ছিলেন অনন্য। রবীন্দ্রনাথের সমগ্র জীবন ও সাহিত্যসাধনায় দেবেন্দ্রনাথের প্রভাব ছিল ব্যাপক। সে যুগে জোড়াসাঁকোর ঠাকুর পরিবার ছিল সাহিত্য-সংস্কৃতি, মুক্তচিন্তা ও প্রগতিশীল ভাবধারার অন্যতম পীঠস্থান। একদিকে দেবেন্দ্রনাথের ধর্মানুশীলন এবং তাঁর পরিবারের স্বাদেশিকতা, সঙ্গীত-সাহিত্য ও শিল্পচর্চার পরিশীলিত আবহ, অন্যদিকে দেশের নানাবিধ পরিবর্তন রবীন্দ্রনাথের জীবনে গভীর তাৎপর্য বয়ে আনে।\n\nরবীন্দ্রনাথ ছিলেন দেবেন্দ্রনাথ ঠাকুরের চতুর্দশ সন্তান। তাঁর মা সারদা দেবী সম্বন্ধে বিশেষ কিছু জানা যায় না। রবীন্দ্রনাথের জ্যেষ্ঠ ভ্রাতা  দ্বিজেন্দ্রনাথ ঠাকুর ছিলেন দার্শনিক ও কবি, মেজ ভ্রাতা  সত্যেন্দ্রনাথ ঠাকুর ছিলেন প্রথম ভারতীয় আইসিএস; অন্য ভ্রাতা  জ্যোতিরিন্দ্রনাথ ঠাকুর ছিলেন সঙ্গীতজ্ঞ ও নাট্যকার এবং বোনদের মধ্যে  স্বর্ণকুমারী দেবী ঔপন্যাসিক হিসেবে খ্যাতি লাভ করেন। ঠাকুরবাড়ির পরিবেশ ছিল  সঙ্গীত, সাহিত্য ও নাট্যাভিনয়ে মুখর। শুধু তাই নয়, বাইরের জগতের সঙ্গেও তাদের যোগাযোগ ছিল নিবিড়। সেই বৃহৎ পরিবারে বালকেরা ভৃত্যদের তত্ত্বাবধানে বাহুল্যবর্জিতভাবে প্রতিপালিত হতো। রবীন্দ্রনাথ তাঁর বাল্যকালের অপূর্ব স্মৃতি-আলেখ্য রচনা করেছেন জীবনস্মৃতি গ্রন্থে। কলকাতার সেই প্রাসাদোপম বাড়িতে ছিল পুকুর, বাগান এবং আরও অনেক রহস্যঘেরা জায়গা। ভৃত্যদের শাসন এড়িয়ে বালক রবীন্দ্রনাথের পক্ষে দূরে কোথাও যাওয়া সম্ভব ছিল না। তাই তার শিশুচিত্ত বাইরের বিপুল পৃথিবীর বিচিত্র কল্পনায় বিহবল হয়ে উঠত। পরবর্তী জীবনের কবিতায়, গানে এবং দেশবিদেশ পর্যটনে শৈশবের এই আকাঙ্ক্ষাই যেন নানাভাবে মূর্ত হয়ে উঠেছে।\n\nরবীন্দ্রনাথের আনুষ্ঠানিক শিক্ষা শুরু হয় কলকাতার ওরিয়েন্টাল সেমিনারিতে। পরে বেশ কয়েক বছর তিনি পড়েন বিদ্যাসাগর প্রতিষ্ঠিত নর্মাল স্কুলে। সেখানেই তাঁর বাংলা শিক্ষার ভিত্তি তৈরি হয়। সবশেষে তাঁকে ভর্তি করা হয় সেন্ট জেভিয়ার্সে। কিন্তু অনিয়মিত উপস্থিতির জন্য তাঁর স্কুলে পড়া বন্ধ হয়ে যায়। তবে বাড়িতে বসে পড়াশোনা চলতে থাকে। রবীন্দ্রনাথের জীবনের একটি উল্লেখযোগ্য ঘটনা ১৮৭৩ সালে পিতার সঙ্গে হিমালয় ভ্রমণ। পথে মহর্ষি প্রতিষ্ঠিত শান্তিনিকেতনে কিছুদিন তাঁরা অতিবাহিত করেন। সেই প্রথম কবি নগরের বাইরে প্রকৃতির বৃহৎ অঙ্গনে পা রাখেন। এই যাত্রায় পিতার স্নেহসিক্ত সান্নিধ্য লাভ রবীন্দ্র-জীবনের এক গুরুত্বপূর্ণ অধ্যায়। পিতার অসাধারণ ব্যক্তিত্বের আদর্শ তাঁকে অভিভূত করে। হিমালয়ের নির্জন বাসগৃহে তিনি পিতার নিকট সংস্কৃত পড়তেন। সন্ধ্যায় মহর্ষি তাঁকে চিনিয়ে দিতেন আকাশের  গ্রহনক্ষত্র। এভাবে মহর্ষির প্রকৃতিপ্রীতি ও সৌন্দর্যবোধের সঙ্গে কবির নিবিড় পরিচয়  ঘটে।\n\nহিমালয় থেকে ফিরে এসে হঠাৎ যেন রবীন্দ্রনাথ শৈশব থেকে যৌবনে পদার্পণ করেন। এরপর থেকে তাঁর শিক্ষা ও সাহিত্যচর্চা অনেকটাই বাধামুক্ত হয়। এ সময় গৃহশিক্ষকের নিকট তাঁকে পড়তে হয় সংস্কৃত, ইংরেজি সাহিত্য, পদার্থবিদ্যা, গণিত, ইতিহাস, ভূগোল, প্রাকৃতবিজ্ঞান প্রভৃতি। এর পাশাপাশি চলতে থাকে ড্রয়িং, সঙ্গীতশিক্ষা এবং জিমন্যাস্টিকস। নিয়মিত স্কুলে যাওয়া বন্ধ হলেও কবির সাহিত্যচর্চা অব্যাহত থাকে। রবীন্দ্রনাথের প্রথম মুদ্রিত কবিতা ‘অভিলাষ’ তত্ত্ববোধিনী পত্রিকায় প্রকাশিত হয় ১২৮১ সনের (১৮৭৪) অগ্রহায়ণ মাসে (কারও কারও মতে প্রথম কবিতা ‘ভারতভূমি’ বঙ্গদর্শন পত্রিকায় ১৮৭৪ সালে প্রকাশিত হয়)। তাঁর দ্বিতীয় মুদ্রিত কবিতা ‘প্রকৃতির খেদ’ (১৮৭৫)। এ দুটি কবিতা তিনি পড়েছিলেন ঠাকুরবাড়ির বিদ্বজ্জন সভায়। প্রসঙ্গত উল্লেখ্য, ১৮৭৪ সালের গোড়ার দিকে ঠাকুরবাড়ির মনীষীরা বাংলাদেশের কবি-সাহিত্যিক, সংবাদপত্র-সম্পাদকসহ বিদগ্ধজনদের আহবান করে ‘বিদ্বজ্জন সমাগম’ নামে এক সাহিত্য সম্মিলনীর আয়োজন করেন। দ্বিজেন্দ্রনাথ, সত্যেন্দ্রনাথ ও জ্যোতিরিন্দ্রনাথ ছিলেন সম্মিলনীর উদ্যোক্তা।\n\nসে সময় রবীন্দ্রনাথ অধ্যয়নের মধ্যেই নিজেকে নিয়োজিত রাখেন। একই সঙ্গে চলে সাহিত্যচর্চাও। জ্ঞানাঙ্কুর ও প্রতিবিম্ব পত্রিকায় তাঁর বনফুল এবং  ভারতী পত্রিকায় কবি-কাহিনী (১৮৭৮) ধারাবাহিকভাবে প্রকাশিত হতে থাকে। ভারতী পত্রিকা দ্বিজেন্দ্রনাথ ঠাকুরের সম্পাদনায় ঠাকুরবাড়ি থেকে প্রকাশিত হতো। জ্ঞানাঙ্কুর সাহিত্যপত্রে সেকালের বিখ্যাত লেখকদের সঙ্গে রবীন্দ্রনাথ স্থান পেয়েছিলেন। এর অন্যতম কারণ হিন্দুমেলায় পঠিত তাঁর কবিতা ‘হিন্দুমেলার উপহার’। যে স্বদেশিচেতনা দেবেন্দ্রনাথের পরিবারে সহজেই বিকাশ লাভ করেছিল, তারই আনুকূল্যে প্রবর্তিত হয়  হিন্দুমেলা। বাঙালির জাতীয় চেতনার উন্মেষ ও বিকাশের ইতিহাসে হিন্দুমেলা বিশেষভাবে স্মরণীয়।\n\nদেশের প্রচলিত শিক্ষাধারার প্রতি রবীন্দ্রনাথের অনাগ্রহ দেখে মেজদা সত্যেন্দ্রনাথ তাঁকে ব্যারিস্টারি পড়ার জন্য বিলেতে পাঠানোর প্রস্তাব করেন। ১৮৭৮ সালের সেপ্টেম্বর মাসে সত্যেন্দ্রনাথ ঠাকুরের সঙ্গে রবীন্দ্রনাথ ইংল্যান্ড যান। সেখানে কিছুদিন ব্রাইটনের একটি পাবলিক স্কুলে এবং পরে লন্ডনের ইউনিভার্সিটি কলেজে তিনি পড়াশোনা করেন। তবে এ পড়াও সম্পূর্ণ হয়নি। দেড় বছর অবস্থানের পর তিনি দেশে ফিরে আসেন। এই দেড় বছর তিনি সে দেশের সমাজ ও জীবনকে গভীরভাবে নিরীক্ষণ করেন। এর প্রমাণ পাওয়া যায় ভারতীতে প্রকাশিত তাঁর য়ুরোপ-প্রবাসীর পত্রে (১৮৮১)। রবীন্দ্রনাথ ইংল্যান্ড থেকে কোন ডিগ্রি বা প্রশিক্ষণ না নিলেও সেখানে তাঁর প্রতিভা বিকাশের পথ খুঁজে পেয়েছিল। সে দেশের সঙ্গীত বিষয়ে অসীম কৌতূহল নিয়ে তিনি নিজের মতো করে পড়াশোনা করেন। এর ফলে দেশে ফিরেই তিনি রচনা করেন গীতিনাট্য বাল্মীকিপ্রতিভা (১৮৮১)। এতে তিনি স্বরচিত গানের সঙ্গে পাশ্চাত্য সুরের মিশ্রণ ঘটান। ঠাকুরবাড়ির ‘বিদ্বজ্জন সমাগম’ উপলক্ষে বাল্মীকিপ্রতিভার অভিনয় হয়। রবীন্দ্রনাথ নিজেই অভিনয় করেন বাল্মীকির চরিত্রে। তাঁর ভ্রাতুষ্পুত্রী প্রতিভা অভিনয় করেন সরস্বতীর ভূমিকায়। রবীন্দ্রনাথের প্রথম অভিনয় ছিল জ্যোতিরিন্দ্রনাথ ঠাকুরের এমন কর্ম আর করব না নাটকে অলীকবাবুর ভূমিকায়। বাল্মীকিপ্রতিভা রচনার সময় থেকে কবি সম্পূর্ণভাবে গান ও  কাব্য রচনায় মনোনিবেশ করেন। পরেই তিনি রচনা করেন সন্ধ্যাসংগীত (১৮৮২) ও প্রভাতসংগীত (১৮৮৩)। এ সময়ের অনুভূতি কবির জীবনে একটি স্মরণীয় ঘটনা; জীবনস্মৃতিতে তিনি তা ব্যক্ত করেছেন। তখন তিনি সদর স্ট্রিটের বাড়িতে জ্যোতিরিন্দ্রনাথের সঙ্গে থাকতেন। একদিন সূর্যোদয়ের মুহূর্তে আকস্মিকভাবেই তাঁর মধ্যে জেগে ওঠে এক দিব্যপ্রেরণা, যার ফলে জগৎ, প্রকৃতি ও মানুষ- সবকিছু তাঁর চোখে এক বিশ্বব্যাপী আনন্দধারায় প্লাবিত বলে মনে হয়। এই অলৌকিক অনুভূতিরই বহিঃপ্রকাশ তাঁর বিখ্যাত কবিতা ‘নির্ঝরের স্বপ্নভঙ্গ’:\n\nআজি এ প্রভাতে রবির কর\nকেমনে পশিল প্রাণের ’পর,\nকেমনে পশিল গুহার অাঁধারে\nপ্রভাত-পাখির গান।\nনা জানি কেন রে  এতদিন পরে\nজাগিয়া উঠিল প্রাণ।\n\nহঠাৎ করেই আত্মকেন্দ্রিক জগৎ থেকে মুক্তি পেয়ে কবি এসে দাঁড়ান মানুষের জগতে। এখান থেকেই রবীন্দ্রপ্রতিভার সত্যিকার স্ফূরণ ঘটে। তিনি একে একে রচনা করেন ছবি ও গান (১৮৮৪), প্রকৃতির প্রতিশোধ (১৮৮৪), কড়ি ও কোমল (১৮৮৬), মায়ার খেলা (১৮৮৮) ও মানসী (১৮৯০) কাব্য। পাশাপাশি লেখেন গদ্যপ্রবন্ধ, সমালোচনা, উপন্যাস প্রভৃতি। এ সময়ই রচিত হয় তাঁর প্রথম দুটি উপন্যাস বউঠাকুরানীর হাট (১৮৮৩) ও রাজর্ষি (১৮৮৭)।\n\n১৮৮৩ সালের ৯ ডিসেম্বর রবীন্দ্রনাথের বিয়ে হয় মৃণালিনী দেবী রায়চৌধুরীর সঙ্গে। তিনি বাংলাদেশের খুলনার বেণীমাধব রায়চৌধুরীর মেয়ে। রবীন্দ্রনাথ ও মৃণালিনী দেবীর দুই পুত্র এবং তিন কন্যা ছিল। বিয়ের অল্পকাল পরেই পিতার বিপুল কর্মের কিছু দায়িত্ব এসে পড়ে রবীন্দ্রনাথের ওপর। তিনি ছিলেন মহর্ষির আদি ব্রাহ্মসমাজের সম্পাদক। ব্রাহ্মসমাজে তখন নানারকম দ্বিধা ও অনিশ্চয়তা বিরাজ করছিল। সে যুগের কলকাতার ধর্মান্দোলনের সময় তরুণ রবীন্দ্রনাথ নিষ্ঠার সঙ্গে তাঁর ওপর অর্পিত দায়িত্ব পালন করেন।\n\nপরে রবীন্দ্রনাথের জীবনে শুরু হয় আর এক অধ্যায়। ১৮৯০ সালের সেপ্টেম্বরে তিনি সত্যেন্দ্রনাথের সঙ্গে দ্বিতীয় বার বিলেত যান একমাসের জন্য। অক্টোবর মাসে ফিরে আসার পর পিতার আদেশে তাঁকে জমিদারি রক্ষণাবেক্ষণের দায়িত্ব গ্রহণ করতে হয়। এই দায়িত্ব পালনের মধ্য দিয়ে রবীন্দ্রনাথের সাহিত্যকর্ম বিচিত্র পথ খুঁজে পায়। এতদিন তিনি যে কাব্য, নাটক আর উপন্যাস লিখেছেন, তার সবই ছিল ভাবমূলক এবং বিশুদ্ধ কল্পনার বস্ত্ত। এবার তিনি লোকজীবনের কাছাকাছি যাওয়ার সুযোগ পান এবং অত্যন্ত ঘনিষ্ঠভাবে দরিদ্র মানুষের সাধারণ জীবন পর্যবেক্ষণ করেন। কবি কল্পনার জগৎ থেকে নেমে আসেন বাস্তব পৃথিবীর প্রত্যক্ষ জীবনে। ফলে রচিত হয় বাংলা সাহিত্যের অপূর্ব সম্পদ গল্পগুচ্ছের  গল্পগুলি। এছাড়া উত্তর ও পূর্ববঙ্গের প্রকৃতি অপরূপ রূপে প্রতিভাত হয় তাঁর ভ্রাতুষ্পুত্রী ইন্দিরা দেবীকে লেখা পত্রে, যেগুলি ছিন্নপত্র ও ছিন্নপত্রাবলী নামে সংকলিত হয়। জীবনের এই পর্বে রবীন্দ্রনাথ জমিদারি তদারকি উপলক্ষে বাংলাদেশের বিভিন্ন স্থান  শাহজাদপুর,  পতিসর, কালিগ্রাম ও শিলাইদহে ঘুরে বেড়ান। এই সূত্রেই শিলাইদহে গড়ে ওঠে একটি কবিতীর্থ। পদ্মাবক্ষে নৌকায় চড়ে বেড়ানোর সময় পদ্মানদী, বালুচর, কাশবন, সূর্যোদয়-সূর্যাস্ত, দরিদ্র জীবন এবং সেখানকার সাধারণ মানুষের হূদয়লীলা কবিকে গভীরভাবে আলোড়িত করে, যা এ পর্বের গল্পে ও কবিতায় প্রতিফলিত হয়েছে।\n\nরবীন্দ্রজীবনের এ পর্বকে কোনো কোনো সমালোচক চিহ্নিত করেছেন সাধনাপর্ব হিসেবে। দ্বিজেন্দ্রনাথের পুত্র সুধীন্দ্রনাথের সম্পাদনায় তখন  সাধনা পত্রিকা প্রকাশিত হতো। রবীন্দ্রপ্রতিভার পূর্ণ দীপ্তির বিচ্ছুরণ ঘটায় এই সাধনা পত্রিকা। এ পত্রিকায় তিনি ছোটগল্প ও প্রবন্ধ লিখতেন। তাঁর শিক্ষাবিষয়ক মতামত এবং রাজনৈতিক আলোচনা-সম্বলিত লেখা ওই পত্রিকাতেই ছাপা হতো। শিক্ষা ও রাজনৈতিক বিষয়ে কবির দৃষ্টিভঙ্গি ছিল স্পষ্ট ও বলিষ্ঠ। ‘শিক্ষার হেরফের’ (১৮৯২) প্রবন্ধে তিনি বাংলা ভাষাকে শিক্ষার মাধ্যম করার প্রস্তাব দেন। রবীন্দ্রনাথ সবসময়ই গঠনমূলক কাজের ওপর গুরুত্ব দিয়েছেন। নিজের জাতি, সমাজ ও দেশকে উত্তমরূপে জানা, বৃহত্তর মানবিক নীতিবোধ দিয়ে নিজেদের সংশোধন করে চলা এবং বিদেশি শাসকের ভিক্ষার দানে নির্ভরশীল না থেকে আত্মশক্তিতে উজ্জীবিত হয়ে ওঠা এসবই ছিল তাঁর প্রবন্ধমালার মূল বক্তব্য। এ সময়ের প্রবন্ধে একদিকে ফুটে ওঠে বাঙালি সমাজের নানা দিক নিয়ে তাঁর চিন্তাভাবনা, আর অন্যদিকে ভারতের ঐতিহ্য, তার আধ্যাত্মিক প্রকৃতি এবং ঐক্যসাধনার ধারার স্বরূপ। সোনার তরী, চিত্রা, চৈতালি, কল্পনা, ক্ষণিকা, কথা ও কাহিনী কবির  শিলাইদহ পর্বের রচনা। এ পর্বের কবিতায় জীবনের বাস্তব চিত্র এবং সৌন্দর্যবোধ, বর্তমান কাল ও প্রাচীন ভারত, সমকালীন সমাজ ও ইতিহাসের মহৎ আত্মত্যাগের কাহিনী একই সঙ্গে প্রকাশিত হয়েছে।\n\nরবীন্দ্রনাথ কখনও সক্রিয় রাজনীতির সঙ্গে যুক্ত হননি, তবে সমসাময়িক ঘটনাপ্রবাহ থেকে নিজেকে বিচ্ছিন্নও রাখেননি; বরং তিনি ছিলেন স্বাদেশিকতার বরেণ্য পুরুষ। ১৮৯৬ সালে কলকাতায় যে কংগ্রেস সম্মেলন অনুষ্ঠিত হয়, ‘বন্দে মাতরম্’ গান গেয়ে রবীন্দ্রনাথ তার উদ্বোধন করেন। মহারাষ্ট্রে বালগঙ্গাধর তিলক যে শিবাজী উৎসবের প্রবর্তন করেন, তারই প্রেরণায় কবি রচনা করেন তাঁর বিখ্যাত কবিতা ‘শিবাজী উৎসব’। সাধনা, বঙ্গদর্শন ও ভারতী পত্রিকায় প্রকাশিত নানা প্রবন্ধে তিনি তৎকালীন রাজনৈতিক পরিস্থিতি বিশ্লেষণ করেন। ১৯০৫ সালে বঙ্গভঙ্গ আন্দোলনের সময় রবীন্দ্রনাথ বঙ্গভঙ্গের তীব্র বিরোধিতা করেন। বঙ্গদর্শন পত্রিকায় প্রকাশিত এক প্রবন্ধে কবি তাঁর মনোভাব ব্যক্ত করেন এবং রাখিবন্ধনের দিনটিকে স্মরণ করে রচনা করেন একটি গান:\n\nবাংলার মাটি বাংলার জল, বাংলার বায়ু বাংলার ফল\nপুণ্য হউক, পুণ্য হউক, পুণ্য হউক হে ভগবান।\n\nসে সময় কবির স্বদেশ পর্বের বেশকিছু  উল্লেখযোগ্য গান রচিত হয়। তাঁর দুটি গান বাংলাদেশ ও ভারতের জাতীয় সঙ্গীতের মর্যাদা লাভ করে। ‘আমার সোনার বাংলা আমি তোমায় ভালবাসি’ বাংলাদেশের এবং ‘জন গণ মন’ ভারতের জাতীয় সঙ্গীত। এ সময় রবীন্দ্রনাথ দেশ ও সমাজকে আত্মনির্ভরশীল করে তোলার বিস্তৃত কর্মসূচি তুলে ধরেন তাঁর বিখ্যাত ‘স্বদেশী সমাজ’ (ভাদ্র ১৩১১/১৯০৪) প্রবন্ধে। এতেই তিনি পল্লিসংগঠন সম্পর্কে গঠনাত্মক কার্যপদ্ধতি, লোকশিক্ষা, সামাজিক কর্তৃত্ব, সমবায় প্রভৃতি জনসেবার বিভিন্ন দিক তুলে ধরেন। প্রকৃতপক্ষে তাঁর পল্লিসংগঠনমূলক কাজের সূত্রপাত ঘটে শিলাইদহে বসবাসকালে। দরিদ্র প্রজাদের দুর্দশা লাঘবের জন্য তিনি বেশকিছু কর্মসূচি চালু করেন, যার মধ্যে ছিল শিক্ষা, চিকিৎসা, পানীয় জলের ব্যবস্থা, সড়ক নির্মাণ ও মেরামত, ঋণের দায় থেকে কৃষকদের মুক্তিদান প্রভৃতি। রবীন্দ্রনাথ স্বদেশী আন্দোলনকে সমর্থন করলেও উগ্র জাতীয়তাবাদ কিংবা সন্ত্রাসবাদকে কখনও সমর্থন করেননি।\n\n১৯০১ সালে রবীন্দ্রনাথ শিলাইদহের বাস তুলে দিয়ে চলে যান শান্তিনিকেতনে। ইতিপূর্বে ১৮৯২ সালে দেবেন্দ্রনাথ শান্তিনিকেতনে একটি মন্দির স্থাপন করেন। তখন থেকেই সেখানে প্রবর্তিত হয় ৭ পৌষের উৎসব ও মেলা। ১৯০১ সালের ডিসেম্বর মাসে (১৩০৮ সনের ৭ পৌষ) মহর্ষির অনুমতি নিয়ে রবীন্দ্রনাথ শান্তিনিকেতনে একটি স্কুল স্থাপন করেন। সেকালে এর নাম ছিল ব্রহ্মচর্যাশ্রম, পরবর্তী পর্যায়ে শান্তিনিকেতন বিদ্যালয়। ওই বিদ্যালয়ই আরও পরে রূপান্তরিত হয় বিশ্বভারতীতে। রবীন্দ্রনাথের জীবনের এক শ্রেষ্ঠ সম্পদ শান্তিনিকেতন বিদ্যালয়। পাঁচজন ছাত্র নিয়ে ওই বিদ্যালয়ের যাত্রা শুরু হয়েছিল। রবীন্দ্রনাথের পুত্র রথীন্দ্রনাথ ছিলেন ওই বিদ্যালয়ের প্রথম ছাত্র। কবির স্ত্রী মৃণালিনী দেবী ছাত্রদের দেখাশোনা করতেন।\n\nশান্তিনিকেতন ব্রহ্মচর্যাশ্রমের জীবনযাত্রা ছিল প্রাচীন ভারতীয় তপোবনের আদর্শে পরিচালিত। গুরু-শিষ্যের নিবিড় সাহচর্যে সরল অনাড়ম্বর জীবন। এই ব্রহ্মচর্যাশ্রম পরিচালনায় রবীন্দ্রনাথের প্রধান সহায়ক ছিলেন ব্রহ্মবান্ধব উপাধ্যায়- একজন রোমান ক্যাথলিক বৈদান্তিক সন্ন্যাসী। ব্রহ্মবান্ধবই সর্বপ্রথম রবীন্দ্রনাথকে ‘বিশ্বকবি’ অভিধা দিয়েছিলেন। প্রচলিত শিক্ষাবিধি সম্বন্ধে কবির অসন্তোষ ছিল শৈশব থেকেই। তাই দীর্ঘকাল ধরে তাঁর মনের মধ্যে যে জীবনমুখী আদর্শ শিক্ষাব্যবস্থার কল্পনা বিরাজমান ছিল, তাকেই বাস্তবে রূপায়িত করেন শান্তিনিকেতন বিদ্যালয় প্রতিষ্ঠার মধ্য দিয়ে। এই বিদ্যালয়কে তিনি একটি আদর্শ বিদ্যাপীঠরূপে গড়ে তুলতে চেয়েছিলেন। পরবর্তী পর্যায়ের বিশ্বভারতীর মধ্য দিয়ে রবীন্দ্রনাথ প্রকাশ করতে চেয়েছিলেন বিশ্বের প্রতি ভারতের আতিথ্য, ভারতের চর্চা, জগতের সংস্কৃতিতে ভারতের ঔৎসুক্য, ভারতের নিষ্ঠা এবং মানবপ্রেম। শান্তিনিকেতন বিদ্যালয় প্রতিষ্ঠিত হয় স্বদেশী যুগের সূচনায় এবং তা বিশ্বভারতীতে পরিণত হয় প্রথম মহাযুদ্ধের শেষে বিশ্বমৈত্রীর সংকল্প নিয়ে।\n\nব্যক্তিগত ও পারিবারিক জীবনে রবীন্দ্রনাথ বারবার নানা বিপর্যয়ের সম্মুখীন হন। ১৯০২ সালে কবিপত্নী মৃণালিনী দেবীর মৃত্যু হয়। এর কয়েক মাসের মধ্যে কন্যা রেণুকা মারা যান। ১৯০৫ সালে মহর্ষি দেবেন্দ্রনাথ দেহত্যাগ করেন এবং ১৯০৭ সালে মৃত্যু ঘটে কবির কনিষ্ঠ পুত্র শমীন্দ্রনাথের। এতগুলি মৃত্যুর শোক রবীন্দ্রনাথকে বিহবল করে তুললেও তিনি শান্তচিত্তে আশ্রমের দায়িত্ব পালন করে যান। পারিবারিক বিপর্যয়ের সঙ্গে সে সময় কবি চরম অর্থসঙ্কটে পড়েন। কিন্তু সমস্ত সঙ্কট থেকে উত্তরণের এক মহাশক্তি তাঁর মধ্যে ছিল। তাই তাঁর কর্মযজ্ঞে ছেদ পড়েনি, থেমে থাকেনি সাহিত্যসাধনা।\n\nরবীন্দ্রনাথের সাহিত্যজীবনে শান্তিনিকেতন পর্বের ছাপ বিশেষভাবে উল্লেখযোগ্য। এ সময়ে রচিত নৈবেদ্য কাব্য এবং নানা প্রবন্ধে প্রাচীন ভারতের ধ্যান ও তপস্যার রূপ ফুটে ওঠে। চোখের বালি (১৩০৯), নৌকাডুবি (১৩১৩) এবং গোরা (১৩১৬) উপন্যাসে একদিকে জীবনের বাস্তবতা, মনস্তত্ত্ব এবং অন্যদিকে স্বদেশের নানা সমস্যার চিত্র তুলে ধরেন তিনি। তবে এ পর্বে রবীন্দ্রমানসের একটি মহৎ দিক-পরিবর্তন ঘটে। জাতিগত সংকীর্ণতার ঊর্ধ্বে চিরন্তন ভারতবর্ষকে কবি এখানেই আবিষ্কার করেন। এ সময়ে রচিত তাঁর বিখ্যাত কবিতা ‘ভারততীর্থ’:\n\nহে মোর চিত্ত, পুণ্য তীর্থে\nজাগো রে ধীরে-\nএই ভারতের মহামানবের\nসাগরতীরে। (গীতাঞ্জলি)\n\nএকদিকে ভারতবর্ষের জাতীয় প্রকৃতি ও তার ইতিহাসের ধারা কবির কাছে হয়ে ওঠে গভীর অর্থবহ, আর অন্যদিকে অধ্যাত্মভাবনায় তাঁর চিত্ত ধাবিত হয় রূপ থেকে অরূপের সন্ধানে। এই অনুভূতিরই প্রকাশ খেয়া ও গীতাঞ্জলি কাব্য এবং রাজা ও ডাকঘর নাটক। এ পর্বে দুঃখ ও মৃত্যুর তত্ত্বকে কবি জীবনের তত্ত্বে অর্থান্বিত করে তোলেন। গীতাঞ্জলি কাব্যের কিছু কবিতা কবির শিলাইদহে থাকাকালে রচিত, তবে অধিকাংশই শান্তিনিকেতনে লেখা। গানগুলি লেখার পর তিনি ছাত্রদের দিয়ে গাইয়ে শুনতেন। জ্যোৎস্না রাতে খোলা আকাশের নিচে ছেলেরা দলবদ্ধ হয়ে গানগুলি গাইত। কবির শেষ বয়সের প্রায় সব নাটকই শান্তিনিকেতনে রচিত। ছাত্ররাই এতে অভিনয় করত। গীতিনাট্য ও নৃত্যনাট্যগুলি ঋতুভিত্তিক উৎসবের জন্য তিনি রচনা করতেন।\n\nরবীন্দ্রনাথের বিচিত্র সৃষ্টির অন্যতম ধারা তাঁর অসাধারণ গান। এই সঙ্গীতপ্রতিভা পারিবারিক সূত্রেই অঙ্কুরিত ও বিকশিত হয় তাঁর মধ্যে। প্রাচ্য-পাশ্চাত্যের সংমিশ্রণে গানের বাণী ও সুরে নব নব নিরীক্ষার ভিতর দিয়ে তিনি নির্মাণ করেন সঙ্গীতের এক স্বতন্ত্র জগৎ, যা একান্তভাবেই তাঁর নিজস্ব সৃষ্টি এবং কালক্রমে এই  রবীন্দ্রসঙ্গীত হয়ে ওঠে কালজয়ী।\n\n১৯১১ সালে রবীন্দ্রনাথের পঞ্চাশ বছর পূর্তি উপলক্ষে বঙ্গীয় সাহিত্য পরিষদের পক্ষ থেকে  রামেন্দ্রসুন্দর ত্রিবেদী, বিচারপতি সারদাচরণ মিত্র, আচার্য  প্রফুল্লচন্দ্র রায়, জগদীশচন্দ্র বসু, মণীন্দ্রনাথ নন্দী এবং অন্যান্য পন্ডিত মিলে সাড়ম্বরে কবির জন্মোৎসব পালন করেন। নোবেল পুরস্কার জয়ের পূর্বে এটাই ছিল কবির প্রতি স্বদেশবাসীর প্রথম অর্ঘ্য।\n\nজোড়াসাঁকোর ঠাকুরবাড়ি সমকালীন সাহিত্য ও শিল্পচর্চার অন্যতম প্রাণকেন্দ্র ছিল বলে দেশের ও বিদেশের জ্ঞানী গুণী ব্যক্তিরা প্রায়ই এখানে আসতেন। এসূত্রে বিখ্যাত শিল্পসমালোচক আনন্দ কুমারস্বামী এবং ভগিনী নিবেদিতার অন্তরঙ্গ সম্পর্ক গড়ে ওঠে এ পরিবারের সঙ্গে। কুমারস্বামী মডার্ন রিভিউ পত্রিকায় রবীন্দ্রনাথের কবিতার অনুবাদ করেন। বিখ্যাত ঐতিহাসিক যদুনাথ সরকারও সে সময়ে রবীন্দ্রনাথের রচনার অনুবাদ করেন ওই পত্রিকায়। ভগিনী  নিবেদিতা ১৯১২ সালের জানুয়ারি সংখ্যার মডার্ন রিভিউতে রবীন্দ্রনাথের ‘কাবুলিওয়ালা’ গল্পের ইংরেজি অনুবাদ করেন। এই গল্প পড়ে অভিভূত হন ইংরেজ মনীষী চিত্রশিল্পী উইলিয়ম রোটেনস্টাইন। তিনি রবীন্দ্রনাথ সম্পর্কে ঔৎসুক্য প্রকাশ করে অবনীন্দ্রনাথকে চিঠি লেখেন। রবীন্দ্রনাথের কয়েকটি কবিতার অনুবাদ তখন রোটেনস্টাইনকে পাঠানো হয়। সে সময়ে দার্শনিক  ব্রজেন্দ্রনাথ শীল একটি সম্মেলন উপলক্ষে ইংল্যান্ডে ছিলেন। সেখানকার বিদগ্ধ মহলের আগ্রহ দেখে তিনি রবীন্দ্রনাথকে ইংল্যান্ড যাওয়ার অনুরোধ করেন।\n\n১৯১২ সালের জুন মাসে রবীন্দ্রনাথ ইংল্যান্ড পৌঁছেন রথীন্দ্রনাথ ও পুত্রবধূ প্রতিমা দেবীকে সঙ্গে নিয়ে। শিল্পী রোটেনস্টাইনের সঙ্গে কবির আগেই পরিচয় হয়েছিল কলকাতায় ১৯১১ সালে। রবীন্দ্রনাথ তাঁর হাতে তুলে দেন নিজের করা কবিতার অনুবাদ। রোটেনস্টাইনের গৃহে রবীন্দ্রনাথের সঙ্গে পরিচয় হয় ইংল্যান্ডের বিশিষ্ট কবি ও পন্ডিতদের। তাঁদের মধ্যে উল্লেখযোগ্য দুজনের একজন ইংরেজ কবি ইয়েটস ইংরেজি গীতাঞ্জলির ভূমিকা লিখে পাশ্চাত্যে রবীন্দ্রনাথের খ্যাতির পথ প্রশস্ত করেন; অন্যজন সি.এফ.এন্ড্রুজ পরবর্তীকালে গান্ধী ও রবীন্দ্রনাথের অন্যতম ভক্ত হন। ইয়েটস রবীন্দ্রনাথের গীতাঞ্জলির কবিতা পড়ে শোনান। তারপর ইন্ডিয়া সোসাইটি থেকে ইয়েটসের চমৎকার ভূমিকাসহ ইংরেজি গীতাঞ্জলি  প্রকাশিত হয়। ওই সময় রবীন্দ্রনাথের চিত্রাঙ্গদা, মালিনী ও ডাকঘর নাটকেরও ইংরেজি অনুবাদ হয়, ফলে ইউরোপ তাঁকে শ্রেষ্ঠ কবি হিসেবে গ্রহণ করে। ইংল্যান্ড থেকে রবীন্দ্রনাথ আমেরিকায় যান। ইতিপূর্বে আমেরিকার আরবানায় ইলিনয় বিশ্ববিদ্যালয়ে কবিপুত্র রথীন্দ্রনাথকে কৃষি ও পশুপালন বিদ্যাশিক্ষার জন্য পাঠানো হয়। সেই সূত্রে সেখানকার কয়েকজন অধ্যাপকের সঙ্গে কবির পত্রালাপ ছিল। তাঁরা রবীন্দ্রনাথকে সেখানে বক্তৃতা প্রদানের আমন্ত্রণ জানান। এবার কবি একজন মনীষী ও দার্শনিক হিসেবে বক্তৃতা দেন। বক্তৃতাগুলি সংকলিত হয় 'Sadhana' (১৯১৩) গ্রন্থে। আমেরিকা থেকে ইংল্যান্ডে গিয়ে কবি আরও কিছু ভাষণ দেন। ১৯১৩ সালের অক্টোবরে তিনি দেশে ফিরে আসেন। সে বছরই নভেম্বর মাসে গীতাঞ্জলির  জন্য রবীন্দ্রনাথকে পৃথিবীর শ্রেষ্ঠ সাহিত্যসম্মান নোবেল পুরস্কার দেওয়া হয়।\n\nক্রমাগত অধ্যয়ন, যোগাযোগ ও বিশ্বপরিক্রমার মধ্য দিয়ে রবীন্দ্রনাথ চলমান বিশ্বের বুদ্ধিবৃত্তিক, বৈজ্ঞানিক এবং রাজনৈতিক রূপান্তরের প্রক্রিয়ার সঙ্গে নিজেকে সম্পৃক্ত করেন। ফলে তাঁর কবিমানসের পরিবর্তন এবং কাব্যসাহিত্যে তার প্রভাব অনিবার্য হয়ে ওঠে। গীতাঞ্জলির অধ্যাত্মচেতনার ধারা গীতিমাল্য ও গীতালি (১৯১৪) কাব্যেও বজায় ছিল। কিন্তু পরে তাঁর সাহিত্যসৃষ্টি নতুন দিকে মোড় নেয় এবং তার প্রধান অবলম্বন হয়  প্রমথ চৌধুরী সম্পাদিত  সবুজপত্র পত্রিকা। সে যুগে সবুজপত্র (বৈশাখ ১৩২১/১৯১৪) কথ্য ভাষারীতিকে আশ্রয় করে প্রগতিশীল চিন্তার বাহনরূপে দেখা দেয়। এ সময় রবীন্দ্রনাথ তাঁর সাহিত্যরীতির পরিবর্তন এবং পরীক্ষা-নিরীক্ষার নিদর্শন তুলে ধরেন সবুজপত্রে। বলাকা (১৯১৬) কাব্যের অধিকাংশ কবিতা এ পত্রিকায় প্রকাশিত হয়। গীতাঞ্জলির আধ্যাত্মিক পরিমন্ডল ছাড়িয়ে জগতের চলিষ্ণুতার নতুন তত্ত্ব প্রকাশ পায় এসব কবিতায়। এর মূলে ছিল রবীন্দ্রনাথের পাশ্চাত্য ভ্রমণের অভিজ্ঞতালব্ধ নতুন দৃষ্টিভঙ্গি।\n\nবলাকা কাব্যের পূর্ব পর্যন্ত রবীন্দ্রনাথের রোম্যান্টিক কবিমানস কখনও সুখ-দুঃখ-বিরহ-মিলনপূর্ণ মানব সংসারে বিচরণ করেছে, আবার কখনও নিরুদ্দেশ সৌন্দর্যলোকে যাত্রা করেছে। এই জীবন ও অরূপের সমন্বয় সাধনজনিত অস্থিরতা থেকে কবি মুক্তি পান বলাকা কাব্যে এসে। বিশ্বের সঙ্গে যুক্ত হতে না পারার দুঃখবোধ ও মানসিক দ্বন্দ্ব তাঁর সন্ধ্যাসংগীত কাব্যের মূল সুর। প্রভাতসংগীতে অনন্ত প্রেমে রবীন্দ্রনাথ প্রকৃতি ও মানবকে আহবান জানান। কড়ি ও কোমল কাব্যে রূপে-বর্ণে-ছন্দে সমৃদ্ধ প্রকৃতি এবং আশা-আকাঙ্ক্ষায় বিজড়িত মানুষ তাঁকে আকৃষ্ট করেছে, তবে এ মানুষ বৃহত্তর দেশে কালে পরিব্যাপ্ত বিশ্বমানব। সোনার তরী যুগে সৌন্দর্যের নিরুদ্দিষ্ট আকাঙ্ক্ষার প্রবণতা কবিকে অসম্পূর্ণ মানবের সংসার থেকে বিচ্ছিন্ন করেছে। মানসী, সোনার তরী এবং চিত্রায় সীমা ও অসীমের দ্বন্দ্বের মধ্য দিয়ে কবিমানসের যাত্রা চলেছে। তিনি জীবের মধ্যেই জীবনেশ্বরকে দেখেছেন। খেয়া থেকে গীতাঞ্জলি পর্যন্ত কবি অধ্যাত্মসাধনায় আত্মনিমগ্ন ছিলেন। বলাকায় প্রচন্ড জীবনাবেগ নিয়ে তাঁর আত্মপ্রকাশ ঘটে। রবীন্দ্র-কবিমানসের এই আকস্মিক পালাবদলের কারণ সমগ্র বিশ্বের মানবিক, দার্শনিক ও রাজনৈতিক পরিবর্তন। এ সময় আধুনিক বিশ্বজীবনবাদের সঙ্গে কবিমানসের গভীর সংযোগ সাধিত হয়। বস্ত্তত জীবনজিজ্ঞাসা ও প্রকাশরীতির বিভিন্ন পর্যায়ে প্রাচ্য চিন্তা এবং পাশ্চাত্য ধারণার সমন্বয় সাধনই রবীন্দ্র-কবিমানসের বৈশিষ্ট্য। বার্গসঁর গতিতত্ত্বের প্রভাব রবীন্দ্রমানসে প্রথম থেকেই ক্রিয়াশীল ছিল। বলাকা নবজীবনবাদের কাব্য। এতে বিষয়বস্ত্ত ও ভাবগত পরিবর্তনের সঙ্গে সঙ্গে কবি কলাকৌশলেও অভিনবত্ব এনেছেন। বস্ত্তজগতে পরমাণুর নিরন্তর গতি, অবিরাম প্রবাহ আর ছন্দের স্পন্দন যেন তাঁর চেতনার জগতেও সৃষ্টি করেছে এক প্রবল ছন্দোময়তা। তাই মুক্ত ছন্দ ব্যবহারের মধ্য দিয়ে তিনি ভাষা ও ছন্দের নিরীক্ষা করেছেন বিভিন্ন কবিতায়। যেমন:\n\nপউষের পাতা-ঝরা তপোবনে\nআজি কী কারণে\nটলিয়া পড়িল আসি বসন্তের মাতাল বাতাস;\nনাই লজ্জা, নাই ত্রাস,\nআকাশে ছড়ায় উচ্চহাস\nচঞ্চলিয়া শীতের প্রহর\nশিশির-মন্থর।\n\nরবীন্দ্রনাথের এ পর্বের উপন্যাস চতুরঙ্গ (১৯১৬) ও ঘরে বাইরে  (১৯১৬) ধারাবাহিকভাবে প্রকাশিত হয় সবুজপত্রে। এ সময় বাংলা সাহিত্যের দিক-পরিবর্তন যেমন তাৎপর্যবহ, তেমনি রবীন্দ্রনাথের মনোজগতের দিক-পরিবর্তনও গুরুত্বপূর্ণ। বলাকা কাব্যের জীবনতত্ত্বকেই কবি রূপ দিয়েছেন ফাল্গুনী (১৯১৬) নাটকে।\n\n১৯১৬ সালে কবি জাপান যান। এই ভ্রমণে তাঁর সঙ্গে ছিলেন দুজন ভারত অনুরাগী উইলিয়ম পিয়ারসন ও সিএফ এন্ড্রুজ এবং তরুণ শিল্পী মুকুল দে। জাপান সংস্কৃতির সঙ্গে রবীন্দ্রনাথের পরিচয় ঘটেছিল কলকাতায় চিত্রশিল্পী ওকাকুরার সান্নিধ্যে। তখন তিনি জাপানের মহৎ দিকটিকেই দেখেছিলেন। কিন্তু এবার তাঁর চোখে পড়ে বিপরীত চিত্র। তাই তিনি রচনা শুরু করেন 'Nationalism' বিষয়ক ভাষণগুলি। সেই ভাষণ তিনি আমেরিকাতেও পড়েন। এছাড়া সেখানে কবি তাঁর শিক্ষার আদর্শ, ব্যক্তিত্বের স্বরূপ, ব্যক্তি ও বিশ্বের সম্পর্ক প্রভৃতি বিষয়ে বক্তৃতা দেন, যেগুলি সংকলিত হয় 'Personality' (১৯১৭) নামক  গ্রন্থে।\n\nবিদেশ ভ্রমণের পর রবীন্দ্রনাথের জীবনের স্মরণীয় ঘটনা ইংরেজ প্রদত্ত ‘নাইট’ উপাধি প্রত্যাখ্যান, যা তাঁকে প্রদান করা হয় ১৯১৫ সালে। ১৯১৯ সালের ১৩ এপ্রিল রাউলাট অ্যাক্ট-এর বিরুদ্ধে পাঞ্জাবের জালিয়ানওয়ালাবাগে এক জনসমাবেশে ভারতীয়দের ওপর ব্রিটিশ পুলিশ আকস্মিকভাবে গুলি চালিয়ে অসহায় ব্যক্তিদের হত্যা করে। ইংরেজের এই অত্যাচারী মূর্তি দেখে রবীন্দ্রনাথ ভাইসরয়কে এক পত্র লিখে ‘নাইট’ উপাধি ফিরিয়ে দেন।\n\nআমেরিকা ভ্রমণের অভিজ্ঞতার ফলে কবির শান্তিনিকেতনের ব্রহ্মচর্যাশ্রমের ধারণায় কিছু পরিবর্তন ঘটে এবং বিশ্বভারতীর সত্যিকার রূপটি স্পষ্ট হয়ে ওঠে। জীবনের এ পর্বে তিনি বিশ্বভারতীর বিদ্যাচর্চাকে ব্রহ্মচর্যাশ্রমের বালকপাঠ্য শিক্ষাস্তর থেকে উচ্চতর স্বাধীন চর্চায় উন্নীত করেন। ভারতীয় দর্শন ও শিক্ষার সুসমন্বয়ে একটি পরিপূর্ণ শিক্ষাব্যবস্থা প্রবর্তনই ছিল তাঁর লক্ষ্য। এখানে অধ্যয়ন ও গবেষণার সঙ্গে সঙ্গে সঙ্গীত ও চিত্রকলা চর্চার ব্যবস্থা হয়। ১৯২১ সালে এক বিশেষ অনুষ্ঠানে বিশ্বভারতী পরিষদ গঠন এবং একটি স্থায়ী নিয়মাবলি রচনা করে এই বিদ্যায়তনকে কবি দেশের হাতে তুলে দেন। বিশ্বভারতী কেন্দ্রীয় বিশ্ববিদ্যালয়ে পরিণত হয়। সে সময়েই বিশ্বভারতীর একটি মূল অঙ্গ হিসেবে শান্তিনিকেতন থেকে দুই মাইল দূরে সুরুল গ্রামে কবি প্রতিষ্ঠা করেন শ্রীনিকেতন কৃষি ও পল্লিসংগঠন। এখানে শুরু হয় পশুপালন, তাঁতশিল্প, চাষাবাদ, কুটিরশিল্প প্রভৃতি উদ্যোগ। এ ছাড়া গ্রামের মানুষের উন্নতির জন্য গড়ে ওঠে গ্রামীণ পাঠাগার, হাসপাতাল, সমবায় ব্যাংক, নলকূপ, শিল্পভবন প্রভৃতি। রবীন্দ্রনাথের নিকট বিশ্বভারতীর একটি অর্থ ছিল বিশ্বকর্ম এবং অন্য অর্থ পৃথিবীজোড়া বিশ্ববোধের প্রকাশ। এরূপ ধারণার বশবর্তী হয়েই এ সময় এখানে যোগ দেন পিয়ারসন ও কৃষিবিজ্ঞানী লিওনার্ড এলমহার্স্ট। শ্রীনিকেতনের উন্নয়নে এলমহার্স্টের অর্থসাহায্য বিশেষভাবে স্মরণীয়। তাঁর স্ত্রী ডরথি স্ট্রেইটের বিপুল ও দীর্ঘকালব্যাপী দানে সম্ভব হয়েছিল শ্রীনিকেতন প্রতিষ্ঠার কাজ।\n\nশান্তিনিকেতন আশ্রমে প্রতিষ্ঠিত শান্তিনিকেতন বিদ্যালয় এবং বিশ্বভারতী সম্মিলিতভাবে রবীন্দ্রনাথের মূল শিক্ষাচিন্তার প্রকাশ।  শান্তিনিকেতন আশ্রম, শান্তিনিকেতন বিদ্যালয় এবং বিশ্বভারতী এই তিনটির মধ্যে প্রথমটির রূপ শুধুই আধ্যাত্মিক; দ্বিতীয়টির লক্ষ্য ব্রহ্মচর্য আদর্শে ছাত্রদের জীবনযাপন ও শিক্ষালাভ; আর শেষটির লক্ষ্য মানবতা ও সাংস্কৃতিক চর্চায় পূর্ব ও পশ্চিমের সেতুবন্ধন। এছাড়া তিনি চেয়েছিলেন শিক্ষা ও প্রতিদিনের জীবনকে এক করতে। তৎকালীন ভারতে ব্রিটিশদের চাপানো শিক্ষাব্যবস্থা ছিল জীবন থেকে বিচ্ছিন্ন। এই অসামঞ্জস্য দূর করে শিক্ষাকে জীবনের অঙ্গীভূত করার লক্ষ্য নিয়েই তিনি প্রতিষ্ঠা করেন শ্রীনিকেতন। দেশবিদেশের বহু শিক্ষাবিদ ও পন্ডিতকে কবি যুক্ত করেন বিশ্বভারতীর সঙ্গে। তাঁদের মধ্যে ছিলেন সিলভাঁ লেভি, মরিটস উইনটারনিটস, ভিনসেন্ট লেসনি, স্টেন কোনো, কার্লো ফরমিকি, জুসেপপে তুচচি, ম্যালেরিয়া বিশেষজ্ঞ ড. হ্যারি টিমবারস প্রমুখ। বিশ্বখ্যাত দার্শনিক রমা রঁলার সঙ্গেও কবির ঘনিষ্ঠ যোগাযোগ ছিল। এই প্রতিষ্ঠানের শিক্ষাব্যবস্থার আদর্শ রবীন্দ্রনাথের মানবমুখী ঐক্যমূলক জীবনতত্ত্বেরই বহিঃপ্রকাশ। ‘The Centre of Indian Culture’ প্রবন্ধে এই অভিনব বিদ্যাকেন্দ্রের মর্মকথা তিনি বিশদভাবে ব্যক্ত করেছেন। এই  প্রবন্ধ তিনি দেশে ও বিদেশে পড়েছেন। ভারতবর্ষের যেখানেই গিয়েছেন, কবি তাঁর বিশ্বভারতীর কথা জানিয়েছেন; এই প্রতিষ্ঠান গড়ে তুলতে কামনা করেছেন সকলের সহযোগিতা। শান্তিনিকেতনে কয়েকজন আদর্শ শিক্ষক আজীবন কবিকে সহায়তা করেছেন। তাঁরা হলেন মোহিতচন্দ্র সেন, সতীশচন্দ্র রায়, অজিতকুমার চক্রবর্তী, জগদানন্দ রায়, হরিচরণ বন্দ্যোপাধ্যায়, ভূপেন্দ্রনাথ সান্যাল, মনোরঞ্জন বন্দ্যোপাধ্যায়, কুঞ্জবিহারী ঘোষ,  বিধুশেখর শাস্ত্রী ও  ক্ষিতিমোহন সেন।\n\n১৯২০ সালে কবি আবার ইংল্যান্ড এবং সেখান থেকে ফ্রান্স, হল্যান্ড, বেলজিয়াম হয়ে আমেরিকা যান। এবার নানা স্থানে বক্তৃতা দিয়ে তিনি বিশ্বভারতীর কথা জানাতে চেয়েছেন। তবে তাঁর আমেরিকা ভ্রমণের অভিজ্ঞতা সুখকর হয় নি। এ যাত্রায় তিনি জার্মানি, সুইজারল্যান্ড, ডেনমার্ক ও সুইডেন ভ্রমণ করেন। ইউরোপে কবি পান রাজার সম্মান। তাঁর এ পর্বের বক্তৃতার সংকলন 'Creative Unity' (১৯২২)। তাতে ধ্বনিত হয়েছে বিশ্ববোধ ও মানব ঐক্যের বাণী।\n\n১৯২১ সালে রবীন্দ্রনাথ ইউরোপ থেকে দেশে ফিরে আসেন। দেশে তখন জাতীয়তাবাদী আন্দোলন নতুন মোড় নিয়েছে। মহাত্মা গান্ধী দক্ষিণ আফ্রিকা থেকে ভারতে আসেন আন্দোলন পরিচালনা করার জন্য। ১৯২১ সালের ৬ সেপ্টেম্বর গান্ধী ও রবীন্দ্রনাথের মধ্যে এক ঐতিহাসিক আলোচনা হয় জোড়াসাঁকোর বিচিত্রা ভবনে। ১৯৩২ সালে মহাত্মা গান্ধী যখন যারবেদা জেলে অনশন করেন, তখন রবীন্দ্রনাথ ‘জীবন যখন শুকায়ে যায়, করুণা ধারায় এসো...’ এই গানটি গেয়ে তাঁর  অনশন ভঙ্গ করেন।\n\n১৯১৬ সালে রবীন্দ্রনাথ যখন বিশ্বপরিক্রমা শুরু করেন, তখন থেকে দীর্ঘকাল তিনি বিশ্বসমস্যার চিন্তায় আচ্ছন্ন ছিলেন। মহাযুদ্ধের ধ্বংসযজ্ঞ থেকে মানবসভ্যতার পরিত্রাণের কথা ভেবে তিনি দেশে দেশে বক্তৃতা দিয়ে তারই পথনির্দেশ করেন। এরই মধ্যে তিনি রচনা করেন পলাতকা (১৯১৮) ও পূরবী (১৯২৫) কাব্য এবং মুক্তধারা (১৯২২) নাটক। ১৯২৪ সালে কবি প্রাচ্যদেশ ভ্রমণে বের হয়ে চীন-জাপান ঘুরে আসেন। এ সময় রচিত হয় তাঁর বিখ্যাত নাটক রক্তকরবী (১৯২৪-এ প্রবাসীতে প্রকাশিত)। এ বছরই তিনি দক্ষিণ আমেরিকার পেরুর স্বাধীনতার শতবার্ষিকী উৎসবে যোগ দেওয়ার জন্য যাত্রা করেও যেতে পারেননি; অসুস্থতার কারণে তাঁকে আর্জেন্টিনায় যাত্রাবিরতি করতে হয়। সেখানেই তাঁর সাক্ষাৎ হয় স্প্যানিশ ভাষার বিদুষী কবি ভিক্টোরিয়া ওকাম্পোর সঙ্গে। বুয়েনাস আইরিসে ওকাম্পো কবিকে নিজের আতিথ্যে রাখেন। কবির সেবার দায়িত্বভারও গ্রহণ করেন তিনি। রবীন্দ্রনাথ এই বিদেশিনী ভক্তকে উৎসর্গ করেন তাঁর পূরবী কাব্য। বুয়েনাস আইরিস থেকে ইতালি হয়ে কবি দেশে ফেরেন। ১৯২৬ থেকে ১৯২৭ সালের মধ্যে তিনি আবার ভ্রমণে বের হয়ে ইউরোপের বেশ কয়েকটি দেশ ঘুরে অবশেষে জাভা হয়ে দেশে ফেরেন। জাভায় তিনি দেখতে পান প্রাচীন ভারতীয় সভ্যতার কিছু নিদর্শন, যার পরিচয় তুলে ধরেন জাভা-যাত্রীর পত্রে।\n\nরবীন্দ্রনাথের পরবর্তী ভ্রমণ ছিল কানাডায় ১৯২৯ সালে। সেখানে প্রদত্ত তাঁর বিখ্যাত বক্তৃতা ‘অবসরতত্ত্ব’ (The Philosophy of Leisure)। কানাডা থেকে কবি তৃতীয় বারের জন্য জাপান যান। ১৯২৬ থেকে ১৯৩০ সালের মধ্যে রবীন্দ্রনাথের কয়েকটি বিখ্যাত গ্রন্থ প্রকাশিত হয়। এর মধ্যে ছিল কাব্যগ্রন্থ মহুয়া, উপন্যাস যোগাযোগ, শেষের কবিতা, নাটক তপতী, শেষরক্ষা এবং গীতিনাট্য ঋতুরঙ্গ। এছাড়া বিভিন্ন অভিভাষণ উপলক্ষে তিনি নানা প্রবন্ধ ও বক্তৃতা লিখেছেন। ১৯২৬ সালে ভারতীয় দর্শন সম্মেলনের সভাপতি হিসেবে তিনি এদেশের বাউলদের মানবধর্ম ব্যাখ্যা করে যে বক্তৃতা দেন, তার শিরোনাম ছিল 'The Philosophy of our People'। ১৯৩০ সালে রবীন্দ্রনাথ অক্সফোর্ড থেকে হিবার্ট বক্তৃতা প্রদানের আমন্ত্রণ পান। বিশ্বের খ্যাতনামা দার্শনিকগণ এই বক্তৃতা দিয়ে এসেছেন। সে বছর ১৯ মে অক্সফোর্ডে ম্যানচেস্টার কলেজে তাঁর হিবার্ট বক্তৃতা অনুষ্ঠিত হয়। বক্তৃতার নাম 'The Religion of Man'। ফলে কবি রবীন্দ্রনাথকে বিশ্বের প্রথম শ্রেণীর দার্শনিকদের সমপর্যায়ে স্থান দেওয়া হয়।\n\nষাটোত্তর বয়সে রবীন্দ্রনাথ চিত্রচর্চা শুরু করেন। লেখার কাটাকুটি থেকেই তাঁর এ চর্চার সূচনা। প্যারিস, ইংল্যান্ড, জার্মানি, ডেনমার্ক প্রভৃতি দেশে অনুষ্ঠিত কবির চিত্রপ্রদর্শনী শিল্পরসিকদের মুগ্ধ করে। ইতোমধ্যে তিনি রাশিয়া ভ্রমণ করেন। প্রথম মহাযুদ্ধের পর রাশিয়ার সামাজিক বিপ্লব এবং তাদের কর্মযজ্ঞ দেখে তিনি অভিভূত হন। তাঁর এই অভিজ্ঞতার প্রতিফলনই রাশিয়ার চিঠি। তারপর তিনি আমেরিকা হয়ে ১৯৩১ সালের জানুয়ারিতে দেশে ফেরেন। এটাই ছিল তাঁর শেষ পাশ্চাত্য ভ্রমণ। পরে কবি দুবার ভারতের বাইরে গিয়েছেন ১৯৩২ সালে পারস্য ও ইরাকে এবং ১৯৩৪ সালে সিংহলে।\n\nকলকাতা বিশ্ববিদ্যালয় রবীন্দ্রনাথকে নানাভাবে সম্মানিত করেছে। ১৯২১ সালে এই বিশ্ববিদ্যালয়ের ‘জগত্তারিণী পদক’ তাঁকেই প্রথম প্রদান করা হয়। ১৯৩২-এ সেখানে প্রদত্ত ‘কমলা বক্তৃতা’য় কবি বলেন ‘মানুষের ধর্ম’ সম্বন্ধে। রবীন্দ্রনাথ কলকাতা বিশ্ববিদ্যালয়ের অধ্যাপক পদ গ্রহণ করে কয়েকটি বক্তৃতা দেন এবং ১৯৩৮ সালে এই বিশ্ববিদ্যালয়ে বাংলায় সমাবর্তন ভাষণ দিয়ে ইতিহাস সৃষ্টি করেন।\n\nজীবনের শেষ দশ বছর রবীন্দ্রনাথ বহু কাব্য, গান, নৃত্যনাট্য, ভ্রমণকাহিনী, সমালোচনা, উপন্যাস এবং প্রবন্ধ রচনা করেন। এ পর্বে এসে তাঁর রচনায় নতুন যুগের স্পর্শ লাগে। এ সময়ে রচিত তাঁর কাব্যগ্রন্থের সংখ্যা প্রায় পনেরোটি। তার মধ্যে পুনশ্চ (১৯৩২), শেষ সপ্তক (১৯৩৫), পত্রপুট (১৯৩৬) ও শ্যামলী (১৯৩৬) গদ্যছন্দে লেখা। এ পর্যায়ে রবীন্দ্রমানসে একটা নিগূঢ় পরিবর্তন লক্ষ করা যায়। কবি ক্রমশ বিজ্ঞানমনস্ক হয়ে ওঠেন, তাঁর চেতনায় নেমে আসে দার্শনিক নির্লিপ্ততা। কবিতাগুলিও হয়ে ওঠে নিরাভরণ এবং ধ্যানগম্ভীর। মৃত্যুচেতনা তাঁকে মাঝে মাঝে আচ্ছন্ন করে। তার প্রতিফলন ঘটে প্রান্তিক (১৯৩৮)-এর কবিতায়। কবির মন আবার ধাবিত হয় মানবসমাজের দিকে, রূপকথার জগতে, বাউলের মনের মানুষের সন্ধানে, শৈশবস্মৃতিতে, পীড়িত মানুষের বেদনায়। কিন্তু অন্যদিকে সাহিত্য নিয়ে পরীক্ষা এবং নতুন সৃষ্টি চলতে থাকে। এবার তিনি লেখেন গদ্যগান। নৃত্যনাট্যগুলি তাঁর অপূর্ব সৃষ্টি। পুরানো কবিতাকে তিনি রূপ দেন নৃত্যনাট্যে; রচনা করেন চিত্রাঙ্গদা, শ্যামা ও চন্ডালিকা। নটরাজ, নবীন, শ্রাবণগাথা এগুলি নিসর্গ প্রকৃতির সঙ্গীতরূপ। কবির শেষ দশকের উপন্যাস দুইবোন (১৯৩৩), মালঞ্চ (১৯৩৪) এবং চার অধ্যায় (১৯৩৪)।\n\nজীবনসায়াহ্নে এসে রবীন্দ্রনাথ বিজ্ঞানের নানা জটিল তত্ত্ব নিয়ে ভেবেছেন। তারই ফসল বিশ্বপরিচয় (১৯৩৭)। বিজ্ঞানের প্রতি কবির সহজাত অনুরাগ ছিল শৈশব থেকেই। প্রাণিবিদ্যা, পদার্থবিদ্যা এবং জ্যোতির্বিদ্যা বিষয়ে তিনি প্রচুর প্রবন্ধ রচনা করেন। প্রথম জীবনে আচার্য জগদীশচন্দ্র বসুর সাহচর্য ও সখ্য বিজ্ঞানের প্রতি তাঁর কৌতূহল বাড়িয়ে তোলে। তাঁর সমগ্র কাব্যসাহিত্যে এক সজাগ বিজ্ঞানচেতনা ও দার্শনিক উপলব্ধির ছাপ সুস্পষ্ট। ইউরোপ সফরকালে রবীন্দ্রনাথ জার্মানিতে আইনস্টাইনের সঙ্গে সাক্ষাৎ করেন। সমকালীন বিজ্ঞানের গতিময়তার সুর তাঁর অসংখ্য কবিতায় ধ্বনিত। কবির প্রকৃতিবিষয়ক কবিতার অন্তরালেও ফুটে উঠেছে বিশ্বসৃষ্টির নিগূঢ় বৈজ্ঞানিক তত্ত্ব। সে (১৯৩৭), তিনসঙ্গী (১৮৪০), গল্পসল্প (১৯৪১) এসব গ্রন্থে বিজ্ঞান ও বিজ্ঞানীদের নিয়ে রবীন্দ্রনাথ চমৎকার গল্প উপস্থাপন করেছেন।\n\nবিশ্বমনস্ক কবি মৃত্যুর পূর্বে প্রত্যক্ষ করেছেন মানবসভ্যতার গভীর সঙ্কটকে। তথাপি তিনি মানুষের মহত্ত্বে চির-আস্থাবান ছিলেন। কালান্তর (১৯৩৭) ও সভ্যতার সঙ্কট (১৯৪১)-এ কবির সেই বিশ্বাসের সুর অক্ষুণ্ণ রয়েছে। রবীন্দ্রনাথের অন্তিম বাণী সভ্যতার সঙ্কট। এ ভাষণ তিনি পড়েছিলেন তাঁর শেষ জন্মোৎসব অনুষ্ঠানে। সেবার কবির আশি বছর পূর্ণ হয়। ১৯৪০ সালের সেপ্টেম্বর মাসে কবি কালিম্পঙ গিয়ে অসুস্থ হয়ে পড়েন। তখন থেকে তাঁর শারীরিক অবস্থার অবনতি ঘটতে থাকে। ১৯৪১ সালের ৭ আগস্ট (২২ শ্রাবণ ১৩৪৮) জোড়াসাঁকোর বাড়িতে রবীন্দ্রনাথ শেষ নিঃশ্বাস ত্যাগ করেন।\n\nরবীন্দ্রনাথ ছিলেন অনন্ত জীবন, চিরজীবী মানবাত্মা ও প্রকৃতির চিরন্তন সৌন্দর্যের কবি। মৃত্যুকে তিনি দেখেছেন মহাজীবনের যতি হিসেবে। জীবন-মৃত্যু ও জগৎ-সংসার তাঁর নিকট প্রতিভাত হয় এক অখন্ড রূপে। তাই তাঁর গানে জীবনলীলার সুর বাজে এভাবে:\n\nআছে দুঃখ আছে মৃত্যু বিরহ-দহন লাগে\nতবুও শান্তি তবু আনন্দ তবু অনন্ত জাগে।\n[শাহীদা আখতার]\n\nগ্রন্থপঞ্জি  শ্রীসুকুমার সেন, রবীন্দ্রনাথ ঠাকুর, ইস্টার্ন পাবলিশার্স, কলকাতা, ৪র্থ সংস্করণ, ১৯৬৯; পূর্ণানন্দ চট্টোপাধ্যায়, রবীন্দ্রনাথ এবং রবীন্দ্রনাথ, আনন্দ পাবলিশার্স প্রা. লি., কলকাতা, ১৯৮১; রবীন্দ্র পরিচয়, বিশ্বভারতী গ্রন্থনবিভাগ, কলকাতা, ১৯৮২; রবীন্দ্র রচনাবলী, ১-২৭ খন্ড, বিশ্বভারতী গ্রন্থনবিভাগ, কলকাতা, ১৯৭৪-১৯৮৩; Santiniketan 1901-1951, Visva-Bharati, ১৯৭১।\n\nতথ্য সংগ্রহ : http://banglapedia.org").intern());
                            MainPageActivity.this.i.setClass(MainPageActivity.this.getApplicationContext(), ContentActivity.class);
                            MainPageActivity.this.startActivity(MainPageActivity.this.i);
                        }
                    });
                }
            };
            MainPageActivity.this._timer.schedule(MainPageActivity.this.tmr, 150L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.arefin.rabindra.MainPageActivity$10  reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass10 implements View.OnClickListener {
        AnonymousClass10() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MainPageActivity.this._Card_View(MainPageActivity.this.linear_tab_1, MainPageActivity.this.Radius, MainPageActivity.this.colorPrimary, MainPageActivity.this.Shadow, MainPageActivity.this.Stroke, MainPageActivity.this.colorPrimaryDark);
            MainPageActivity.this.tmr = new TimerTask() { // from class: com.arefin.rabindra.MainPageActivity.10.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    MainPageActivity.this.runOnUiThread(new Runnable() { // from class: com.arefin.rabindra.MainPageActivity.10.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MainPageActivity.this._Card_View(MainPageActivity.this.linear_tab_1, MainPageActivity.this.Radius, MainPageActivity.this.colorPrimaryDark, MainPageActivity.this.Shadow, MainPageActivity.this.Stroke, MainPageActivity.this.colorPrimary);
                            MainPageActivity.this.i.putExtra("Type", "Poets");
                            MainPageActivity.this.i.setClass(MainPageActivity.this.getApplicationContext(), BookViewActivity.class);
                            MainPageActivity.this.startActivity(MainPageActivity.this.i);
                        }
                    });
                }
            };
            MainPageActivity.this._timer.schedule(MainPageActivity.this.tmr, 150L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.arefin.rabindra.MainPageActivity$11  reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass11 implements View.OnClickListener {
        AnonymousClass11() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MainPageActivity.this._Card_View(MainPageActivity.this.linear_tab_2, MainPageActivity.this.Radius, MainPageActivity.this.colorPrimary, MainPageActivity.this.Shadow, MainPageActivity.this.Stroke, MainPageActivity.this.colorPrimaryDark);
            MainPageActivity.this.tmr = new TimerTask() { // from class: com.arefin.rabindra.MainPageActivity.11.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    MainPageActivity.this.runOnUiThread(new Runnable() { // from class: com.arefin.rabindra.MainPageActivity.11.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MainPageActivity.this._Card_View(MainPageActivity.this.linear_tab_2, MainPageActivity.this.Radius, MainPageActivity.this.colorPrimaryDark, MainPageActivity.this.Shadow, MainPageActivity.this.Stroke, MainPageActivity.this.colorPrimary);
                            MainPageActivity.this.i.putExtra("Type", "Songs");
                            MainPageActivity.this.i.setClass(MainPageActivity.this.getApplicationContext(), BookViewActivity.class);
                            MainPageActivity.this.startActivity(MainPageActivity.this.i);
                        }
                    });
                }
            };
            MainPageActivity.this._timer.schedule(MainPageActivity.this.tmr, 150L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.arefin.rabindra.MainPageActivity$12  reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass12 implements View.OnClickListener {
        AnonymousClass12() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MainPageActivity.this._Card_View(MainPageActivity.this.linear_tab_3, MainPageActivity.this.Radius, MainPageActivity.this.colorPrimary, MainPageActivity.this.Shadow, MainPageActivity.this.Stroke, MainPageActivity.this.colorPrimaryDark);
            MainPageActivity.this.tmr = new TimerTask() { // from class: com.arefin.rabindra.MainPageActivity.12.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    MainPageActivity.this.runOnUiThread(new Runnable() { // from class: com.arefin.rabindra.MainPageActivity.12.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MainPageActivity.this._Card_View(MainPageActivity.this.linear_tab_3, MainPageActivity.this.Radius, MainPageActivity.this.colorPrimaryDark, MainPageActivity.this.Shadow, MainPageActivity.this.Stroke, MainPageActivity.this.colorPrimary);
                            MainPageActivity.this.i.putExtra("Type", "Drama");
                            MainPageActivity.this.i.setClass(MainPageActivity.this.getApplicationContext(), BookViewActivity.class);
                            MainPageActivity.this.startActivity(MainPageActivity.this.i);
                        }
                    });
                }
            };
            MainPageActivity.this._timer.schedule(MainPageActivity.this.tmr, 150L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.arefin.rabindra.MainPageActivity$13  reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass13 implements View.OnClickListener {
        AnonymousClass13() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MainPageActivity.this._Card_View(MainPageActivity.this.linear_tab_4, MainPageActivity.this.Radius, MainPageActivity.this.colorPrimary, MainPageActivity.this.Shadow, MainPageActivity.this.Stroke, MainPageActivity.this.colorPrimaryDark);
            MainPageActivity.this.tmr = new TimerTask() { // from class: com.arefin.rabindra.MainPageActivity.13.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    MainPageActivity.this.runOnUiThread(new Runnable() { // from class: com.arefin.rabindra.MainPageActivity.13.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MainPageActivity.this._Card_View(MainPageActivity.this.linear_tab_4, MainPageActivity.this.Radius, MainPageActivity.this.colorPrimaryDark, MainPageActivity.this.Shadow, MainPageActivity.this.Stroke, MainPageActivity.this.colorPrimary);
                            MainPageActivity.this.i.putExtra("Type", "Small_Nobel");
                            MainPageActivity.this.i.setClass(MainPageActivity.this.getApplicationContext(), BookViewActivity.class);
                            MainPageActivity.this.startActivity(MainPageActivity.this.i);
                        }
                    });
                }
            };
            MainPageActivity.this._timer.schedule(MainPageActivity.this.tmr, 150L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.arefin.rabindra.MainPageActivity$14  reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass14 implements View.OnClickListener {
        AnonymousClass14() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MainPageActivity.this._Card_View(MainPageActivity.this.linear_tab_5, MainPageActivity.this.Radius, MainPageActivity.this.colorPrimary, MainPageActivity.this.Shadow, MainPageActivity.this.Stroke, MainPageActivity.this.colorPrimaryDark);
            MainPageActivity.this.tmr = new TimerTask() { // from class: com.arefin.rabindra.MainPageActivity.14.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    MainPageActivity.this.runOnUiThread(new Runnable() { // from class: com.arefin.rabindra.MainPageActivity.14.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MainPageActivity.this._Card_View(MainPageActivity.this.linear_tab_5, MainPageActivity.this.Radius, MainPageActivity.this.colorPrimaryDark, MainPageActivity.this.Shadow, MainPageActivity.this.Stroke, MainPageActivity.this.colorPrimary);
                            MainPageActivity.this.i.putExtra("Type", "Essay");
                            MainPageActivity.this.i.setClass(MainPageActivity.this.getApplicationContext(), BookViewActivity.class);
                            MainPageActivity.this.startActivity(MainPageActivity.this.i);
                        }
                    });
                }
            };
            MainPageActivity.this._timer.schedule(MainPageActivity.this.tmr, 150L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.arefin.rabindra.MainPageActivity$15  reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass15 implements View.OnClickListener {
        AnonymousClass15() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MainPageActivity.this._Card_View(MainPageActivity.this.linear_tab_6, MainPageActivity.this.Radius, MainPageActivity.this.colorPrimary, MainPageActivity.this.Shadow, MainPageActivity.this.Stroke, MainPageActivity.this.colorPrimaryDark);
            MainPageActivity.this.tmr = new TimerTask() { // from class: com.arefin.rabindra.MainPageActivity.15.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    MainPageActivity.this.runOnUiThread(new Runnable() { // from class: com.arefin.rabindra.MainPageActivity.15.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MainPageActivity.this._Card_View(MainPageActivity.this.linear_tab_6, MainPageActivity.this.Radius, MainPageActivity.this.colorPrimaryDark, MainPageActivity.this.Shadow, MainPageActivity.this.Stroke, MainPageActivity.this.colorPrimary);
                            MainPageActivity.this.i.putExtra("Type", "Nobel");
                            MainPageActivity.this.i.setClass(MainPageActivity.this.getApplicationContext(), BookViewActivity.class);
                            MainPageActivity.this.startActivity(MainPageActivity.this.i);
                        }
                    });
                }
            };
            MainPageActivity.this._timer.schedule(MainPageActivity.this.tmr, 150L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.arefin.rabindra.MainPageActivity$16  reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass16 implements View.OnClickListener {
        AnonymousClass16() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MainPageActivity.this._Card_View(MainPageActivity.this.linear_tab_7, MainPageActivity.this.Radius, MainPageActivity.this.colorPrimary, MainPageActivity.this.Shadow, MainPageActivity.this.Stroke, MainPageActivity.this.colorPrimaryDark);
            MainPageActivity.this.tmr = new TimerTask() { // from class: com.arefin.rabindra.MainPageActivity.16.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    MainPageActivity.this.runOnUiThread(new Runnable() { // from class: com.arefin.rabindra.MainPageActivity.16.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MainPageActivity.this._Card_View(MainPageActivity.this.linear_tab_7, MainPageActivity.this.Radius, MainPageActivity.this.colorPrimaryDark, MainPageActivity.this.Shadow, MainPageActivity.this.Stroke, MainPageActivity.this.colorPrimary);
                            MainPageActivity.this.i.putExtra("Type", "Others");
                            MainPageActivity.this.i.setClass(MainPageActivity.this.getApplicationContext(), BookViewActivity.class);
                            MainPageActivity.this.startActivity(MainPageActivity.this.i);
                        }
                    });
                }
            };
            MainPageActivity.this._timer.schedule(MainPageActivity.this.tmr, 150L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.arefin.rabindra.MainPageActivity$17  reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass17 implements View.OnClickListener {
        AnonymousClass17() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MainPageActivity.this._Card_View(MainPageActivity.this.linear_tab_8, MainPageActivity.this.Radius, MainPageActivity.this.colorPrimary, MainPageActivity.this.Shadow, MainPageActivity.this.Stroke, MainPageActivity.this.colorPrimaryDark);
            MainPageActivity.this.tmr = new TimerTask() { // from class: com.arefin.rabindra.MainPageActivity.17.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    MainPageActivity.this.runOnUiThread(new Runnable() { // from class: com.arefin.rabindra.MainPageActivity.17.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MainPageActivity.this._Card_View(MainPageActivity.this.linear_tab_8, MainPageActivity.this.Radius, MainPageActivity.this.colorPrimaryDark, MainPageActivity.this.Shadow, MainPageActivity.this.Stroke, MainPageActivity.this.colorPrimary);
                            MainPageActivity.this.i.putExtra("Type", "Bani");
                            MainPageActivity.this.i.setClass(MainPageActivity.this.getApplicationContext(), BaniActivity.class);
                            MainPageActivity.this.startActivity(MainPageActivity.this.i);
                        }
                    });
                }
            };
            MainPageActivity.this._timer.schedule(MainPageActivity.this.tmr, 150L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.arefin.rabindra.MainPageActivity$18  reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass18 implements View.OnClickListener {
        AnonymousClass18() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MainPageActivity.this._Card_View(MainPageActivity.this.linear_tab_9, MainPageActivity.this.Radius, MainPageActivity.this.colorPrimary, MainPageActivity.this.Shadow, MainPageActivity.this.Stroke, MainPageActivity.this.colorPrimaryDark);
            MainPageActivity.this.tmr = new TimerTask() { // from class: com.arefin.rabindra.MainPageActivity.18.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    MainPageActivity.this.runOnUiThread(new Runnable() { // from class: com.arefin.rabindra.MainPageActivity.18.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MainPageActivity.this._Card_View(MainPageActivity.this.linear_tab_9, MainPageActivity.this.Radius, MainPageActivity.this.colorPrimaryDark, MainPageActivity.this.Shadow, MainPageActivity.this.Stroke, MainPageActivity.this.colorPrimary);
                            MainPageActivity.this.i.putExtra("Type", "Pdf");
                            MainPageActivity.this.i.setClass(MainPageActivity.this.getApplicationContext(), BaniActivity.class);
                            MainPageActivity.this.startActivity(MainPageActivity.this.i);
                        }
                    });
                }
            };
            MainPageActivity.this._timer.schedule(MainPageActivity.this.tmr, 150L);
        }
    }

    private void initializeLogic() {
        this.interstitial = new InterstitialAd(getApplicationContext());
        this.interstitial.setAdListener(this._interstitial_ad_listener);
        this.interstitial.setAdUnitId("ca-app-pub-8700028746384810/3694838553");
        this.interstitial.loadAd(new AdRequest.Builder().build());
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.getDecorView().setSystemUiVisibility(8192);
        window.setStatusBarColor(Color.parseColor("#FFFFFFFF"));
        this.textview1.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 1);
        this.textview3.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
        CardView cardView = new CardView(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(0, 0, 0, 0);
        cardView.setLayoutParams(layoutParams);
        cardView.setCardBackgroundColor(-1);
        cardView.setRadius(15.0f);
        cardView.setCardElevation(8.0f);
        cardView.setMaxCardElevation(12.0f);
        cardView.setPreventCornerOverlap(true);
        ((ViewGroup) this.imageview5.getParent()).removeView(this.imageview5);
        this.linear_card.removeAllViews();
        this.linear_card.addView(cardView);
        cardView.addView(this.imageview5);
        getSupportActionBar().hide();
        _extra();
        this.adview1.loadAd(new AdRequest.Builder().build());
        this.adview1.setAdListener(new AdListener() { // from class: com.arefin.rabindra.MainPageActivity.25
            @Override // com.google.android.gms.ads.AdListener
            public void onAdLoaded() {
                Log.i(com.google.ads.AdRequest.LOGTAG, "onAdLoaded");
                MainPageActivity.this.adview1.setVisibility(0);
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdFailedToLoad(int i) {
                Log.i(com.google.ads.AdRequest.LOGTAG, "onAdFailedToLoad");
                MainPageActivity.this.adview1.setVisibility(8);
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdOpened() {
                Log.i(com.google.ads.AdRequest.LOGTAG, "onAdOpened");
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdLeftApplication() {
                Log.i(com.google.ads.AdRequest.LOGTAG, "onAdLeftApplication");
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdClosed() {
                Log.i(com.google.ads.AdRequest.LOGTAG, "onAdClosed");
            }
        });
        this.adview2.loadAd(new AdRequest.Builder().build());
        this.adview2.setAdListener(new AdListener() { // from class: com.arefin.rabindra.MainPageActivity.26
            @Override // com.google.android.gms.ads.AdListener
            public void onAdLoaded() {
                Log.i(com.google.ads.AdRequest.LOGTAG, "onAdLoaded");
                MainPageActivity.this.adview2.setVisibility(0);
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdFailedToLoad(int i) {
                Log.i(com.google.ads.AdRequest.LOGTAG, "onAdFailedToLoad");
                MainPageActivity.this.adview2.setVisibility(8);
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdOpened() {
                Log.i(com.google.ads.AdRequest.LOGTAG, "onAdOpened");
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdLeftApplication() {
                Log.i(com.google.ads.AdRequest.LOGTAG, "onAdLeftApplication");
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdClosed() {
                Log.i(com.google.ads.AdRequest.LOGTAG, "onAdClosed");
            }
        });
        this.linear_bar_2.setVisibility(0);
        if (this.data.getString("theme", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED).equals(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED)) {
            _theme("theme1");
        } else {
            _theme(this.data.getString("theme", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED));
        }
        _CardStyle(this.theme1_button, 5.0d, 180.0d, "#FFFFFF", true);
        _CardStyle(this.theme2_button, 5.0d, 180.0d, "#FFE0B2", true);
        _CardStyle(this.theme3_button, 5.0d, 180.0d, "#000000", true);
        _CardStyle(this.theme4_button, 5.0d, 180.0d, "#006064", true);
        this.imageview_check_1.setVisibility(0);
        this.imageview_check_2.setVisibility(8);
        this.imageview_check_3.setVisibility(8);
        this.imageview_check_4.setVisibility(8);
        this.vscroll1.setVerticalScrollBarEnabled(false);
    }

    /* loaded from: classes.dex */
    public static class CircleDrawables {
        public static Drawable getSelectableDrawableFor(int i) {
            if (Build.VERSION.SDK_INT < 21) {
                StateListDrawable stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(new int[]{16842919}, new ColorDrawable(Color.parseColor("#ffffff")));
                stateListDrawable.addState(new int[]{16842908}, new ColorDrawable(Color.parseColor("#00ffffff")));
                stateListDrawable.addState(new int[0], new ColorDrawable(Color.parseColor("#00ffffff")));
                return stateListDrawable;
            }
            return new RippleDrawable(ColorStateList.valueOf(i), new ColorDrawable(Color.parseColor("#00ffffff")), getRippleColor(i));
        }

        private static Drawable getRippleColor(int i) {
            float[] fArr = new float[180];
            Arrays.fill(fArr, 80.0f);
            ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(fArr, null, null));
            shapeDrawable.getPaint().setColor(i);
            return shapeDrawable;
        }

        private static int lightenOrDarken(int i, double d) {
            return canLighten(i, d) ? lighten(i, d) : darken(i, d);
        }

        private static int lighten(int i, double d) {
            int red = Color.red(i);
            int green = Color.green(i);
            int blue = Color.blue(i);
            return Color.argb(Color.alpha(i), lightenColor(red, d), lightenColor(green, d), lightenColor(blue, d));
        }

        private static int darken(int i, double d) {
            int red = Color.red(i);
            int green = Color.green(i);
            int blue = Color.blue(i);
            return Color.argb(Color.alpha(i), darkenColor(red, d), darkenColor(green, d), darkenColor(blue, d));
        }

        private static boolean canLighten(int i, double d) {
            return canLightenComponent(Color.red(i), d) && canLightenComponent(Color.green(i), d) && canLightenComponent(Color.blue(i), d);
        }

        private static boolean canLightenComponent(int i, double d) {
            int red = Color.red(i);
            int green = Color.green(i);
            int blue = Color.blue(i);
            if (red + (red * d) < 255.0d) {
                if ((green * d) + green < 255.0d && blue + (blue * d) < 255.0d) {
                    return true;
                }
            }
            return false;
        }

        private static int darkenColor(int i, double d) {
            return (int) Math.max(i - (i * d), 0.0d);
        }

        private static int lightenColor(int i, double d) {
            return (int) Math.min(i + (i * d), 255.0d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        _ButtomSheet();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.interstitial.show();
        if (this.data.getString("theme", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED).equals("theme4")) {
            Window window = getWindow();
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(Color.parseColor("#006064"));
            window.setNavigationBarColor(Color.parseColor("#006064"));
        } else if (this.data.getString("theme", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED).equals("theme3")) {
            Window window2 = getWindow();
            window2.clearFlags(67108864);
            window2.addFlags(Integer.MIN_VALUE);
            window2.setStatusBarColor(Color.parseColor("#FF212121"));
            window2.setNavigationBarColor(Color.parseColor("#212121"));
        } else if (this.data.getString("theme", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED).equals("theme2")) {
            Window window3 = getWindow();
            window3.clearFlags(67108864);
            window3.addFlags(Integer.MIN_VALUE);
            window3.getDecorView().setSystemUiVisibility(8192);
            window3.setStatusBarColor(Color.parseColor("#FFE0B2"));
            window3.setNavigationBarColor(Color.parseColor("#FFE0B2"));
        } else {
            Window window4 = getWindow();
            window4.clearFlags(67108864);
            window4.addFlags(Integer.MIN_VALUE);
            window4.getDecorView().setSystemUiVisibility(8192);
            window4.setStatusBarColor(Color.parseColor("#FFFFFF"));
            window4.setNavigationBarColor(Color.parseColor("#FFFFFF"));
        }
        if (this.data.getString("theme", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED).equals(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED)) {
            _theme("theme1");
        } else {
            _theme(this.data.getString("theme", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED));
        }
    }

    private void _extra() {
        this.textview1.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
        this.textview4.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
        this.textview9.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
        this.textview10.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
        this.textview11.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
        this.textview12.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
        this.textview13.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
        this.textview14.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
        this.textview15.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
        this.textview16.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
        this.textview17.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
        this.textview3.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
        this.textview2.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
        this.textview8.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
        this.textview5.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
        this.textview6.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
        this.textview7.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
        _AppIDs();
    }

    private void _radius(View view, String str, double d) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor(str));
        gradientDrawable.setCornerRadius((int) d);
        view.setBackground(gradientDrawable);
    }

    private void _changeActivityFont(String str) {
        this.fontName = "fonts/".concat(str.concat(".ttf"));
        overrideFonts(this, getWindow().getDecorView());
    }

    private void overrideFonts(Context context, View view) {
        try {
            Typeface createFromAsset = Typeface.createFromAsset(getAssets(), this.fontName);
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    overrideFonts(context, viewGroup.getChildAt(i));
                }
            } else if (view instanceof TextView) {
                ((TextView) view).setTypeface(createFromAsset);
            } else if (view instanceof EditText) {
                ((EditText) view).setTypeface(createFromAsset);
            } else if (view instanceof Button) {
                ((Button) view).setTypeface(createFromAsset);
            }
        } catch (Exception e) {
            SketchwareUtil.showMessage(getApplicationContext(), "Error Loading Font");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _Card_View(View view, double d, String str, double d2, double d3, String str2) {
        if (d3 == 0.0d) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius((float) d);
            gradientDrawable.setColor(Color.parseColor("#" + str.replace("#", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED)));
            view.setBackground(gradientDrawable);
            view.setElevation((float) d2);
            return;
        }
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setStroke((int) d3, Color.parseColor("#" + str2.replace("#", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED)));
        gradientDrawable2.setCornerRadius((float) d);
        gradientDrawable2.setColor(Color.parseColor("#" + str.replace("#", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED)));
        view.setBackground(gradientDrawable2);
        view.setElevation((float) d2);
    }

    private void _click(View view) {
        view.setClickable(true);
        view.setBackground(CircleDrawables.getSelectableDrawableFor(Color.parseColor("#212121")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _Share() {
        this.aa = "রবিন্দ্র সমগ্র এপ্লিকেশনটি আমার খুবই ভালো লেগেছে, আশা করি আপনারও অনেক ভালো লাগবে। নিচের লিংক থেকে আপনি অ্যাপ ইনস্টল করতে পারবেন।";
        this.bb = "https://play.google.com/store/apps/details?id=com.arefin.rabindra";
        this.code = this.aa.concat("\n\n".concat(this.bb));
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", this.code);
        intent.putExtra("android.intent.extra.SUBJECT", "রবিন্দ্র সমগ্র");
        startActivity(Intent.createChooser(intent, "Share App using"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _Feedback() {
        setTheme(16974391);
        _setDialogFont(this.feedback, "মতামত", "এই এপ্সে কোনো ধরনের ভূল চোখে পড়লে অথবা আপনার যেকোনো ধরণের পরামর্শ থাকলে তা জানালে আপনার কাছে কৃতজ্ঞ থাকবো। ", "solaimanlipi.ttf");
        this.feedback.setPositiveButton("Email Us", new DialogInterface.OnClickListener() { // from class: com.arefin.rabindra.MainPageActivity.27
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                MainPageActivity.this.web.setAction("android.intent.action.VIEW");
                MainPageActivity.this.web.setData(Uri.parse("mailto:".concat("arefinkhaled@gmail.com".concat("?subject=".concat("রবিন্দ্র সমগ্র (মন্তব্য)")))));
                MainPageActivity.this.startActivity(MainPageActivity.this.web);
            }
        });
        this.feedback.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _More_Apps() {
        this.web.setAction("android.intent.action.VIEW");
        this.web.setData(Uri.parse("https://play.google.com/store/apps/developer?id=Arefin+Khaled"));
        startActivity(this.web);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _Rate_Apps() {
        this.web.setAction("android.intent.action.VIEW");
        this.web.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.arefin.rabindra"));
        startActivity(this.web);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _Email_Us() {
        this.web.setAction("android.intent.action.VIEW");
        this.web.setData(Uri.parse("mailto:".concat("arefinkhaled@gmail.com".concat("?subject=".concat("রবিন্দ্র সমগ্র")))));
        startActivity(this.web);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _BackPress() {
        finish();
    }

    private void _setDialogFont(AlertDialog.Builder builder, String str, String str2, String str3) {
        if (!str.equals(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED)) {
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new TypefaceSpan(this, str3), 0, spannableString.length(), 33);
            builder.setTitle(spannableString);
        }
        if (!str2.equals(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED)) {
            SpannableString spannableString2 = new SpannableString(str2);
            spannableString2.setSpan(new TypefaceSpan(this, str3), 0, spannableString2.length(), 33);
            builder.setMessage(spannableString2);
        }
    }

    /* loaded from: classes.dex */
    public class TypefaceSpan extends MetricAffectingSpan {
        private Typeface mTypeface;
        private LruCache<String, Typeface> sTypefaceCache = new LruCache<>(12);

        public TypefaceSpan(Context context, String str) {
            this.mTypeface = this.sTypefaceCache.get(str);
            if (this.mTypeface == null) {
                this.mTypeface = Typeface.createFromAsset(context.getApplicationContext().getAssets(), String.format("fonts/%s", str));
                this.sTypefaceCache.put(str, this.mTypeface);
            }
        }

        @Override // android.text.style.MetricAffectingSpan
        public void updateMeasureState(TextPaint textPaint) {
            textPaint.setTypeface(this.mTypeface);
            textPaint.setFlags(textPaint.getFlags() | 128);
        }

        @Override // android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setTypeface(this.mTypeface);
            textPaint.setFlags(textPaint.getFlags() | 128);
        }
    }

    private void _PromoApps(String str) {
        if (str.equals("নজরুল")) {
            this.apps.setAction("android.intent.action.VIEW");
            this.apps.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.senani.nazrul"));
            startActivity(this.apps);
        } else if (str.equals("রবিন্দ্র")) {
            this.apps.setAction("android.intent.action.VIEW");
            this.apps.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.arefin.rabindra"));
            startActivity(this.apps);
        } else if (str.equals("হুমায়ুন")) {
            this.apps.setAction("android.intent.action.VIEW");
            this.apps.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.senani.humayonsamagra"));
            startActivity(this.apps);
        } else if (str.equals("শরৎ")) {
            this.apps.setAction("android.intent.action.VIEW");
            this.apps.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.arefin.sharathsamagra"));
            startActivity(this.apps);
        } else if (str.equals("বঙ্কিম")) {
            this.apps.setAction("android.intent.action.VIEW");
            this.apps.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.arefin.bankim"));
            startActivity(this.apps);
        } else if (str.equals("বই সমাহার")) {
            this.apps.setAction("android.intent.action.VIEW");
            this.apps.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.senani.BoiSamahar"));
            startActivity(this.apps);
        } else if (str.equals("ব্যোমকেশ")) {
            this.apps.setAction("android.intent.action.VIEW");
            this.apps.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.arefin.byomkesh"));
            startActivity(this.apps);
        } else if (str.equals("তিন গোয়েন্দা")) {
            this.apps.setAction("android.intent.action.VIEW");
            this.apps.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.senani.threedetective"));
            startActivity(this.apps);
        } else if (str.equals("মাসুদ রানা")) {
            this.apps.setAction("android.intent.action.VIEW");
            this.apps.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.senani.masudrana"));
            startActivity(this.apps);
        } else if (str.equals("এনায়েতুল্লাহ আলতামাশ")) {
            this.apps.setAction("android.intent.action.VIEW");
            this.apps.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.senani.altamash"));
            startActivity(this.apps);
        } else if (str.equals("নসীম হেজাযী")) {
            this.apps.setAction("android.intent.action.VIEW");
            this.apps.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.senani.nasimhazazi"));
            startActivity(this.apps);
        }
    }

    private void _SharedPreference(String str) {
        this.data.edit().putString("PromoApp", str).commit();
        _PromoApps(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _theme(String str) {
        this.data.edit().putString("theme", str).commit();
        _colors(str);
    }

    private void _colors(String str) {
        if (str.equals("theme4")) {
            this.colorPrimary = "#006064";
            this.colorPrimaryDark = "#FFFFFF";
            this.ColorText = "#FFFFFF";
            this.ColorTextToo = "#000000";
            this.imageview_drawer.setImageResource(R.drawable.ic_menu_white);
            this.imageview_share.setImageResource(R.drawable.ic_share_white);
            this.imageview_feedback.setImageResource(R.drawable.ic_comment_white);
            this.imageview_rating.setImageResource(R.drawable.ic_grade_white);
            this.imageview_more.setImageResource(R.drawable.ic_layers_white);
            this.imageview_download.setImageResource(R.drawable.ic_person_outline_white);
            this.imageview_about.setImageResource(R.drawable.ic_close_white);
            this.imageview_email.setImageResource(R.drawable.ic_email_white);
            this.imageview_check_1.setVisibility(8);
            this.imageview_check_2.setVisibility(8);
            this.imageview_check_3.setVisibility(8);
            this.imageview_check_4.setVisibility(0);
            this.textview1.setTextColor(Color.parseColor(this.ColorText));
            this.textview2.setTextColor(Color.parseColor(this.ColorText));
            this.textview3.setTextColor(Color.parseColor(this.ColorTextToo));
            this.textview4.setTextColor(Color.parseColor(this.ColorText));
            this.textview5.setTextColor(Color.parseColor(this.ColorText));
            this.textview6.setTextColor(Color.parseColor(this.ColorText));
            this.textview7.setTextColor(Color.parseColor(this.ColorText));
            this.textview8.setTextColor(Color.parseColor(this.ColorText));
            this.textview9.setTextColor(Color.parseColor(this.ColorText));
            this.textview10.setTextColor(Color.parseColor(this.ColorText));
            this.textview11.setTextColor(Color.parseColor(this.ColorText));
            this.textview12.setTextColor(Color.parseColor(this.ColorText));
            this.textview13.setTextColor(Color.parseColor(this.ColorText));
            this.textview14.setTextColor(Color.parseColor(this.ColorText));
            this.textview15.setTextColor(Color.parseColor(this.ColorText));
            this.textview16.setTextColor(Color.parseColor(this.ColorText));
            this.textview17.setTextColor(Color.parseColor(this.ColorText));
            getWindow().getDecorView().setSystemUiVisibility(0);
            getWindow().setStatusBarColor(Color.parseColor("#006064"));
            getWindow().setNavigationBarColor(Color.parseColor("#006064"));
            this._drawer_textview_1.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_2.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_3.setTextColor(Color.parseColor(this.ColorTextToo));
            this._drawer_textview_4.setTextColor(Color.parseColor(this.ColorTextToo));
            this._drawer_textview_5.setTextColor(Color.parseColor(this.ColorTextToo));
            this._drawer_textview_6.setTextColor(Color.parseColor(this.ColorTextToo));
            this._drawer_textview_7.setTextColor(Color.parseColor(this.ColorTextToo));
            this._drawer_textview_8.setTextColor(Color.parseColor(this.ColorTextToo));
            this._drawer_textview_9.setTextColor(Color.parseColor(this.ColorTextToo));
            this._drawer_textview_10.setTextColor(Color.parseColor(this.ColorTextToo));
            this._drawer_textview_11.setTextColor(Color.parseColor(this.ColorTextToo));
            this._drawer_textview_12.setTextColor(Color.parseColor(this.ColorTextToo));
            this._drawer_textview_13.setTextColor(Color.parseColor(this.ColorTextToo));
            this._drawer_textview_14.setTextColor(Color.parseColor(this.ColorTextToo));
            this._drawer_textview_15.setTextColor(Color.parseColor(this.ColorTextToo));
            this._drawer_textview_16.setTextColor(Color.parseColor(this.ColorTextToo));
            this._drawer_textview_17.setTextColor(Color.parseColor(this.ColorTextToo));
            this._drawer_textview_18.setTextColor(Color.parseColor(this.ColorTextToo));
            this._drawer_textview_19.setTextColor(Color.parseColor(this.ColorTextToo));
            this._drawer_textview_20.setTextColor(Color.parseColor(this.ColorTextToo));
            this._drawer_textview_21.setTextColor(Color.parseColor(this.ColorTextToo));
            this._drawer_textview_22.setTextColor(Color.parseColor(this.ColorTextToo));
            this._drawer_textview_23.setTextColor(Color.parseColor(this.ColorTextToo));
            this._drawer_textview_24.setTextColor(Color.parseColor(this.ColorTextToo));
            this._drawer_textview_1.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 1);
            this._drawer_textview_2.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
            this._drawer_textview_3.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
            this._drawer_textview_4.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 1);
            this._drawer_textview_5.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
            this._drawer_textview_6.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 1);
            this._drawer_textview_7.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
            this._drawer_textview_8.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 1);
            this._drawer_textview_9.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
            this._drawer_textview_10.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 1);
            this._drawer_textview_11.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
            this._drawer_textview_12.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 1);
            this._drawer_textview_13.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
            this._drawer_textview_14.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 1);
            this._drawer_textview_15.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
            this._drawer_textview_16.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 1);
            this._drawer_textview_17.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
            this._drawer_textview_18.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 1);
            this._drawer_textview_19.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
            this._drawer_textview_20.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 1);
            this._drawer_textview_21.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
            this._drawer_textview_22.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 1);
            this._drawer_textview_23.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 1);
            this._drawer_textview_24.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
            this._drawer_linear1.setBackgroundColor(Color.parseColor(this.colorPrimaryDark));
            this._drawer_linear2.setBackgroundColor(Color.parseColor(this.colorPrimary));
        } else if (str.equals("theme3")) {
            this.colorPrimary = "#424242";
            this.colorPrimaryDark = "#171717";
            this.ColorText = "#FFFFFF";
            this.imageview_drawer.setImageResource(R.drawable.ic_menu_white);
            this.imageview_share.setImageResource(R.drawable.ic_share_white);
            this.imageview_feedback.setImageResource(R.drawable.ic_comment_white);
            this.imageview_rating.setImageResource(R.drawable.ic_grade_white);
            this.imageview_more.setImageResource(R.drawable.ic_layers_white);
            this.imageview_download.setImageResource(R.drawable.ic_person_outline_white);
            this.imageview_about.setImageResource(R.drawable.ic_close_white);
            this.imageview_email.setImageResource(R.drawable.ic_email_white);
            this.imageview_check_1.setVisibility(8);
            this.imageview_check_2.setVisibility(8);
            this.imageview_check_3.setVisibility(0);
            this.imageview_check_4.setVisibility(8);
            this.textview1.setTextColor(Color.parseColor(this.ColorText));
            this.textview2.setTextColor(Color.parseColor(this.ColorText));
            this.textview3.setTextColor(Color.parseColor(this.ColorText));
            this.textview4.setTextColor(Color.parseColor(this.ColorText));
            this.textview5.setTextColor(Color.parseColor(this.ColorText));
            this.textview6.setTextColor(Color.parseColor(this.ColorText));
            this.textview7.setTextColor(Color.parseColor(this.ColorText));
            this.textview8.setTextColor(Color.parseColor(this.ColorText));
            this.textview9.setTextColor(Color.parseColor(this.ColorText));
            this.textview10.setTextColor(Color.parseColor(this.ColorText));
            this.textview11.setTextColor(Color.parseColor(this.ColorText));
            this.textview12.setTextColor(Color.parseColor(this.ColorText));
            this.textview13.setTextColor(Color.parseColor(this.ColorText));
            this.textview14.setTextColor(Color.parseColor(this.ColorText));
            this.textview15.setTextColor(Color.parseColor(this.ColorText));
            this.textview16.setTextColor(Color.parseColor(this.ColorText));
            this.textview17.setTextColor(Color.parseColor(this.ColorText));
            getWindow().getDecorView().setSystemUiVisibility(0);
            getWindow().setStatusBarColor(Color.parseColor("#424242"));
            getWindow().setNavigationBarColor(Color.parseColor("#424242"));
            this._drawer_linear1.setBackgroundColor(Color.parseColor(this.colorPrimaryDark));
            this._drawer_linear2.setBackgroundColor(Color.parseColor(this.colorPrimaryDark));
            this._drawer_textview_1.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_2.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_3.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_4.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_5.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_6.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_7.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_8.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_9.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_10.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_11.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_12.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_13.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_14.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_15.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_16.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_17.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_18.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_19.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_20.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_21.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_22.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_23.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_24.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_1.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 1);
            this._drawer_textview_2.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
            this._drawer_textview_3.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
            this._drawer_textview_4.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 1);
            this._drawer_textview_5.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
            this._drawer_textview_6.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 1);
            this._drawer_textview_7.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
            this._drawer_textview_8.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 1);
            this._drawer_textview_9.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
            this._drawer_textview_10.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 1);
            this._drawer_textview_11.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
            this._drawer_textview_12.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 1);
            this._drawer_textview_13.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
            this._drawer_textview_14.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 1);
            this._drawer_textview_15.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
            this._drawer_textview_16.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 1);
            this._drawer_textview_17.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
            this._drawer_textview_18.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 1);
            this._drawer_textview_19.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
            this._drawer_textview_20.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 1);
            this._drawer_textview_21.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
            this._drawer_textview_22.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 1);
            this._drawer_textview_23.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 1);
            this._drawer_textview_24.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
        } else if (str.equals("theme2")) {
            this.colorPrimary = "#FFF3E0";
            this.colorPrimaryDark = "#FFE0B2";
            this.ColorText = "#000000";
            this.imageview_drawer.setImageResource(R.drawable.ic_dehaze_grey);
            this.imageview_share.setImageResource(R.drawable.ic_share_grey);
            this.imageview_feedback.setImageResource(R.drawable.ic_comment_grey);
            this.imageview_rating.setImageResource(R.drawable.ic_grade_grey);
            this.imageview_more.setImageResource(R.drawable.ic_layers_grey);
            this.imageview_download.setImageResource(R.drawable.ic_person_grey);
            this.imageview_about.setImageResource(R.drawable.ic_close_grey);
            this.imageview_email.setImageResource(R.drawable.ic_mail_grey);
            this.imageview_check_1.setVisibility(8);
            this.imageview_check_2.setVisibility(0);
            this.imageview_check_3.setVisibility(8);
            this.imageview_check_4.setVisibility(8);
            this.textview1.setTextColor(Color.parseColor(this.ColorText));
            this.textview2.setTextColor(Color.parseColor(this.ColorText));
            this.textview3.setTextColor(Color.parseColor(this.ColorText));
            this.textview4.setTextColor(Color.parseColor(this.ColorText));
            this.textview5.setTextColor(Color.parseColor(this.ColorText));
            this.textview6.setTextColor(Color.parseColor(this.ColorText));
            this.textview7.setTextColor(Color.parseColor(this.ColorText));
            this.textview8.setTextColor(Color.parseColor(this.ColorText));
            this.textview9.setTextColor(Color.parseColor(this.ColorText));
            this.textview10.setTextColor(Color.parseColor(this.ColorText));
            this.textview11.setTextColor(Color.parseColor(this.ColorText));
            this.textview12.setTextColor(Color.parseColor(this.ColorText));
            this.textview13.setTextColor(Color.parseColor(this.ColorText));
            this.textview14.setTextColor(Color.parseColor(this.ColorText));
            this.textview15.setTextColor(Color.parseColor(this.ColorText));
            this.textview16.setTextColor(Color.parseColor(this.ColorText));
            this.textview17.setTextColor(Color.parseColor(this.ColorText));
            Window window = getWindow();
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            window.getDecorView().setSystemUiVisibility(8192);
            window.setStatusBarColor(Color.parseColor("#FFF3E0"));
            window.setNavigationBarColor(Color.parseColor("#FFF3E0"));
            this._drawer_linear1.setBackgroundColor(Color.parseColor(this.colorPrimaryDark));
            this._drawer_linear2.setBackgroundColor(Color.parseColor(this.colorPrimaryDark));
            this._drawer_textview_1.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_2.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_3.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_4.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_5.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_6.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_7.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_8.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_9.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_10.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_11.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_12.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_13.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_14.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_15.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_16.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_17.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_18.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_19.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_20.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_21.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_22.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_23.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_24.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_1.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 1);
            this._drawer_textview_2.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
            this._drawer_textview_3.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
            this._drawer_textview_4.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 1);
            this._drawer_textview_5.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
            this._drawer_textview_6.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 1);
            this._drawer_textview_7.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
            this._drawer_textview_8.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 1);
            this._drawer_textview_9.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
            this._drawer_textview_10.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 1);
            this._drawer_textview_11.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
            this._drawer_textview_12.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 1);
            this._drawer_textview_13.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
            this._drawer_textview_14.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 1);
            this._drawer_textview_15.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
            this._drawer_textview_16.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 1);
            this._drawer_textview_17.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
            this._drawer_textview_18.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 1);
            this._drawer_textview_19.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
            this._drawer_textview_20.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 1);
            this._drawer_textview_21.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
            this._drawer_textview_22.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 1);
            this._drawer_textview_23.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 1);
            this._drawer_textview_24.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
        } else {
            this.colorPrimary = "#FFFFFF";
            this.colorPrimaryDark = "#E0E0E0";
            this.ColorText = "#000000";
            this.imageview_drawer.setImageResource(R.drawable.ic_dehaze_grey);
            this.imageview_share.setImageResource(R.drawable.ic_share_grey);
            this.imageview_feedback.setImageResource(R.drawable.ic_comment_grey);
            this.imageview_rating.setImageResource(R.drawable.ic_grade_grey);
            this.imageview_more.setImageResource(R.drawable.ic_layers_grey);
            this.imageview_download.setImageResource(R.drawable.ic_person_grey);
            this.imageview_about.setImageResource(R.drawable.ic_close_grey);
            this.imageview_email.setImageResource(R.drawable.ic_mail_grey);
            this.imageview_check_1.setVisibility(0);
            this.imageview_check_2.setVisibility(8);
            this.imageview_check_3.setVisibility(8);
            this.imageview_check_4.setVisibility(8);
            this.textview1.setTextColor(Color.parseColor(this.ColorText));
            this.textview2.setTextColor(Color.parseColor(this.ColorText));
            this.textview3.setTextColor(Color.parseColor(this.ColorText));
            this.textview4.setTextColor(Color.parseColor(this.ColorText));
            this.textview5.setTextColor(Color.parseColor(this.ColorText));
            this.textview6.setTextColor(Color.parseColor(this.ColorText));
            this.textview7.setTextColor(Color.parseColor(this.ColorText));
            this.textview8.setTextColor(Color.parseColor(this.ColorText));
            this.textview9.setTextColor(Color.parseColor(this.ColorText));
            this.textview10.setTextColor(Color.parseColor(this.ColorText));
            this.textview11.setTextColor(Color.parseColor(this.ColorText));
            this.textview12.setTextColor(Color.parseColor(this.ColorText));
            this.textview13.setTextColor(Color.parseColor(this.ColorText));
            this.textview14.setTextColor(Color.parseColor(this.ColorText));
            this.textview15.setTextColor(Color.parseColor(this.ColorText));
            this.textview16.setTextColor(Color.parseColor(this.ColorText));
            this.textview17.setTextColor(Color.parseColor(this.ColorText));
            Window window2 = getWindow();
            window2.clearFlags(67108864);
            window2.addFlags(Integer.MIN_VALUE);
            window2.getDecorView().setSystemUiVisibility(8192);
            window2.setStatusBarColor(Color.parseColor("#FFFFFF"));
            window2.setNavigationBarColor(Color.parseColor("#FFFFFF"));
            this._drawer_linear1.setBackgroundColor(Color.parseColor(this.colorPrimary));
            this._drawer_linear2.setBackgroundColor(Color.parseColor(this.colorPrimaryDark));
            this._drawer_textview_1.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_2.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_3.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_4.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_5.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_6.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_7.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_8.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_9.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_10.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_11.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_12.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_13.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_14.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_15.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_16.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_17.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_18.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_19.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_20.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_21.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_22.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_23.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_24.setTextColor(Color.parseColor(this.ColorText));
            this._drawer_textview_1.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 1);
            this._drawer_textview_2.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
            this._drawer_textview_3.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
            this._drawer_textview_4.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 1);
            this._drawer_textview_5.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
            this._drawer_textview_6.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 1);
            this._drawer_textview_7.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
            this._drawer_textview_8.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 1);
            this._drawer_textview_9.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
            this._drawer_textview_10.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 1);
            this._drawer_textview_11.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
            this._drawer_textview_12.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 1);
            this._drawer_textview_13.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
            this._drawer_textview_14.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 1);
            this._drawer_textview_15.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
            this._drawer_textview_16.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 1);
            this._drawer_textview_17.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
            this._drawer_textview_18.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 1);
            this._drawer_textview_19.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
            this._drawer_textview_20.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 1);
            this._drawer_textview_21.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
            this._drawer_textview_22.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 1);
            this._drawer_textview_23.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 1);
            this._drawer_textview_24.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
        }
        this.Radius = 10.0d;
        this.Shadow = 2.0d;
        this.Stroke = 5.0d;
        _CardStyle(this.linear_actionbar, 5.0d, 0.0d, this.colorPrimary, false);
        _CardStyle(this.linear_toolbar, 8.0d, 0.0d, this.colorPrimary, false);
        _CardStyle(this.linear1, 0.0d, 0.0d, this.colorPrimaryDark, false);
        _click(this.linear_feedback);
        _click(this.linear_rating);
        _click(this.linear_more);
        _click(this.linear_exit);
        _click(this.imageview_drawer);
        _click(this.imageview_share);
        _click(this.imageview_download);
        _radius(this.linear_bar_1, this.colorPrimary, this.Radius);
        _radius(this.linear_bar_2, this.colorPrimary, this.Radius);
        _radius(this.linear_bar_3, this.colorPrimary, this.Radius);
        _Card_View(this.linear_tab_1, this.Radius, this.colorPrimaryDark, this.Shadow, this.Stroke, this.colorPrimary);
        _Card_View(this.linear_tab_2, this.Radius, this.colorPrimaryDark, this.Shadow, this.Stroke, this.colorPrimary);
        _Card_View(this.linear_tab_3, this.Radius, this.colorPrimaryDark, this.Shadow, this.Stroke, this.colorPrimary);
        _Card_View(this.linear_tab_4, this.Radius, this.colorPrimaryDark, this.Shadow, this.Stroke, this.colorPrimary);
        _Card_View(this.linear_tab_5, this.Radius, this.colorPrimaryDark, this.Shadow, this.Stroke, this.colorPrimary);
        _Card_View(this.linear_tab_6, this.Radius, this.colorPrimaryDark, this.Shadow, this.Stroke, this.colorPrimary);
        _Card_View(this.linear_tab_7, this.Radius, this.colorPrimaryDark, this.Shadow, this.Stroke, this.colorPrimary);
        _Card_View(this.linear_tab_8, this.Radius, this.colorPrimaryDark, this.Shadow, this.Stroke, this.colorPrimary);
        _Card_View(this.linear_tab_9, this.Radius, this.colorPrimaryDark, this.Shadow, this.Stroke, this.colorPrimary);
        _Card_View(this.linear_tab_10, this.Radius, this.colorPrimaryDark, this.Shadow, this.Stroke, this.colorPrimary);
        _Card_View(this.linear_sub_tab_1, this.Radius, this.colorPrimary, this.Shadow, 0.0d, RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
        _Card_View(this.linear_sub_tab_2, this.Radius, this.colorPrimary, this.Shadow, 0.0d, RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
        _Card_View(this.linear_sub_tab_3, this.Radius, this.colorPrimary, this.Shadow, 0.0d, RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
        _Card_View(this.linear_sub_tab_4, this.Radius, this.colorPrimary, this.Shadow, 0.0d, RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
        _Card_View(this.linear_sub_tab_5, this.Radius, this.colorPrimary, this.Shadow, 0.0d, RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
        _Card_View(this.linear_sub_tab_6, this.Radius, this.colorPrimary, this.Shadow, 0.0d, RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
        _Card_View(this.linear_sub_tab_7, this.Radius, this.colorPrimary, this.Shadow, 0.0d, RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
        _Card_View(this.linear_sub_tab_8, this.Radius, this.colorPrimary, this.Shadow, 0.0d, RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
        _Card_View(this.linear_sub_tab_9, this.Radius, this.colorPrimary, this.Shadow, 0.0d, RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
        _Card_View(this.linear_sub_tab_10, this.Radius, this.colorPrimary, this.Shadow, 0.0d, RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
    }

    private void _CardStyle(final View view, double d, double d2, String str, boolean z) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor(str));
        gradientDrawable.setCornerRadius((int) d2);
        view.setBackground(gradientDrawable);
        if (Build.VERSION.SDK_INT >= 21) {
            view.setElevation((int) d);
        }
        if (z) {
            view.setOnTouchListener(new View.OnTouchListener() { // from class: com.arefin.rabindra.MainPageActivity.28
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    switch (motionEvent.getAction()) {
                        case 0:
                            ObjectAnimator objectAnimator = new ObjectAnimator();
                            objectAnimator.setTarget(view);
                            objectAnimator.setPropertyName("scaleX");
                            objectAnimator.setFloatValues(0.9f);
                            objectAnimator.setDuration(100L);
                            objectAnimator.start();
                            ObjectAnimator objectAnimator2 = new ObjectAnimator();
                            objectAnimator2.setTarget(view);
                            objectAnimator2.setPropertyName("scaleY");
                            objectAnimator2.setFloatValues(0.9f);
                            objectAnimator2.setDuration(100L);
                            objectAnimator2.start();
                            break;
                        case 1:
                            ObjectAnimator objectAnimator3 = new ObjectAnimator();
                            objectAnimator3.setTarget(view);
                            objectAnimator3.setPropertyName("scaleX");
                            objectAnimator3.setFloatValues(1.0f);
                            objectAnimator3.setDuration(100L);
                            objectAnimator3.start();
                            ObjectAnimator objectAnimator4 = new ObjectAnimator();
                            objectAnimator4.setTarget(view);
                            objectAnimator4.setPropertyName("scaleY");
                            objectAnimator4.setFloatValues(1.0f);
                            objectAnimator4.setDuration(100L);
                            objectAnimator4.start();
                            break;
                    }
                    return false;
                }
            });
        }
    }

    private void _AppIDs() {
        this.Email_ID_Arefin_Khaled = "arefinkhaled@gmail.com";
        this.Email_ID_Arefin_Studio = "arefinstudio430@gmail.com";
        this.Email_ID_Arefin_Library = "arefinlibrary@gmail.com";
        this.DevID_Arefin_Khaled = "https://play.google.com/store/apps/dev?id=8140189918947319673";
        this.DevID_Arefin_Studio = "https://play.google.com/store/apps/dev?id=5147655604785742582";
        this.DevID_Arefin_Library = "https://play.google.com/store/apps/dev?id=4776344412640781054";
        this.PACKAGE_NAME = getApplicationContext().getPackageName();
        this.AppName = getApplicationInfo().loadLabel(getPackageManager()).toString();
        this.title = this.AppName;
        this.subtitle = "হুমায়ূন আজাদ প্রেমিকদের ভালোবাসার প্লাটফর্ম";
        this.AppID = "https://play.google.com/store/apps/details?id=".concat(this.PACKAGE_NAME);
        this.DevEmail = this.Email_ID_Arefin_Khaled;
        this.DevID = this.DevID_Arefin_Khaled;
        this.textview1.setText(this.AppName);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _ButtomSheet() {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        View inflate = getLayoutInflater().inflate(R.layout.buttom_sheet, (ViewGroup) null);
        bottomSheetDialog.setContentView(inflate);
        bottomSheetDialog.getWindow().findViewById(R.id.design_bottom_sheet).setBackgroundResource(17170445);
        TextView textView = (TextView) inflate.findViewById(R.id.button_text_1);
        TextView textView2 = (TextView) inflate.findViewById(R.id.button_text_2);
        TextView textView3 = (TextView) inflate.findViewById(R.id.button_text_3);
        TextView textView4 = (TextView) inflate.findViewById(R.id.button_text_4);
        TextView textView5 = (TextView) inflate.findViewById(R.id.button_text_5);
        TextView textView6 = (TextView) inflate.findViewById(R.id.text_1);
        TextView textView7 = (TextView) inflate.findViewById(R.id.text_2);
        TextView textView8 = (TextView) inflate.findViewById(R.id.textview_copyright);
        TextView textView9 = (TextView) inflate.findViewById(R.id.tab_text_1);
        TextView textView10 = (TextView) inflate.findViewById(R.id.tab_text_2);
        TextView textView11 = (TextView) inflate.findViewById(R.id.tab_text_3);
        View view = (LinearLayout) inflate.findViewById(R.id.bg);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.button_1);
        LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.button_2);
        LinearLayout linearLayout3 = (LinearLayout) inflate.findViewById(R.id.button_3);
        LinearLayout linearLayout4 = (LinearLayout) inflate.findViewById(R.id.button_4);
        LinearLayout linearLayout5 = (LinearLayout) inflate.findViewById(R.id.button_5);
        LinearLayout linearLayout6 = (LinearLayout) inflate.findViewById(R.id.linear_tab_1);
        LinearLayout linearLayout7 = (LinearLayout) inflate.findViewById(R.id.linear_tab_2);
        LinearLayout linearLayout8 = (LinearLayout) inflate.findViewById(R.id.linear_tab_3);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.tab_image_1);
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.tab_image_2);
        ImageView imageView3 = (ImageView) inflate.findViewById(R.id.tab_image_3);
        ImageView imageView4 = (ImageView) inflate.findViewById(R.id.button_image_1);
        ImageView imageView5 = (ImageView) inflate.findViewById(R.id.button_image_2);
        ImageView imageView6 = (ImageView) inflate.findViewById(R.id.button_image_3);
        ImageView imageView7 = (ImageView) inflate.findViewById(R.id.button_image_4);
        ImageView imageView8 = (ImageView) inflate.findViewById(R.id.button_image_5);
        textView.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
        textView2.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
        textView3.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
        textView4.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
        textView5.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
        textView6.setText(this.AppName);
        textView6.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/hind_siliguri_light_regular.ttf"), 1);
        textView7.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
        textView7.setText("আপনার রেটিং আমাদের জন্য গুরুত্বপূর্ণ এবং উৎসাহব্যঞ্জক। ".concat("'".concat(this.AppName.concat("'".concat(" অ্যাপটি ভালো লাগলে পাঁচ তারকা রেটিং দিন এবং আপনার মতামত জানান। অ্যাপটি শেয়ার করে অন্যদেরকেও হাদিস শরীফ পড়ার ও জানার সুযোগ দিন।")))));
        this.site_1 = "https://arefinkhaled.com";
        this.site_2 = "https://arefinlibrary.com";
        this.site_3 = "https://arefinebooks.com";
        ((AdView) inflate.findViewById(R.id.adview1)).loadAd(new AdRequest.Builder().build());
        if (this.data.getString("theme", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED).equals("theme4")) {
            _radius(view, this.colorPrimaryDark, 0.0d);
            _rippleRoundStroke(linearLayout6, this.colorPrimary, this.colorPrimaryDark, 15.0d, 0.0d, "#EEEEEE");
            _rippleRoundStroke(linearLayout7, this.colorPrimary, this.colorPrimaryDark, 15.0d, 0.0d, "#EEEEEE");
            _rippleRoundStroke(linearLayout8, this.colorPrimary, this.colorPrimaryDark, 15.0d, 0.0d, "#EEEEEE");
            _rippleRoundStroke(linearLayout, this.colorPrimary, this.colorPrimaryDark, 15.0d, 0.0d, "#EEEEEE");
            _rippleRoundStroke(linearLayout2, this.colorPrimary, this.colorPrimaryDark, 15.0d, 0.0d, "#EEEEEE");
            _rippleRoundStroke(linearLayout3, this.colorPrimary, this.colorPrimaryDark, 15.0d, 0.0d, "#EEEEEE");
            _rippleRoundStroke(linearLayout4, this.colorPrimary, this.colorPrimaryDark, 15.0d, 0.0d, "#EEEEEE");
            _rippleRoundStroke(linearLayout5, this.colorPrimary, this.colorPrimaryDark, 15.0d, 0.0d, "#EEEEEE");
            textView6.setTextColor(Color.parseColor(this.ColorTextToo));
            textView7.setTextColor(Color.parseColor(this.ColorTextToo));
            textView8.setTextColor(Color.parseColor(this.ColorTextToo));
            textView11.setTextColor(Color.parseColor(this.ColorText));
            textView10.setTextColor(Color.parseColor(this.ColorText));
            textView9.setTextColor(Color.parseColor(this.ColorText));
            textView.setTextColor(Color.parseColor(this.ColorText));
            textView2.setTextColor(Color.parseColor(this.ColorText));
            textView3.setTextColor(Color.parseColor(this.ColorText));
            textView4.setTextColor(Color.parseColor(this.ColorText));
            textView5.setTextColor(Color.parseColor(this.ColorText));
            imageView.setImageResource(R.drawable.ic_launch_white);
            imageView2.setImageResource(R.drawable.ic_launch_white);
            imageView3.setImageResource(R.drawable.ic_launch_white);
            imageView4.setImageResource(R.drawable.ic_grade_white);
            imageView5.setImageResource(R.drawable.ic_share_white);
            imageView6.setImageResource(R.drawable.ic_comment_white);
            imageView7.setImageResource(R.drawable.ic_launch_white);
            imageView8.setImageResource(R.drawable.ic_close_white);
        } else if (this.data.getString("theme", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED).equals("theme3")) {
            _radius(view, this.colorPrimary, 0.0d);
            _rippleRoundStroke(linearLayout6, this.colorPrimaryDark, this.colorPrimary, 15.0d, 0.0d, "#EEEEEE");
            _rippleRoundStroke(linearLayout7, this.colorPrimaryDark, this.colorPrimary, 15.0d, 0.0d, "#EEEEEE");
            _rippleRoundStroke(linearLayout8, this.colorPrimaryDark, this.colorPrimary, 15.0d, 0.0d, "#EEEEEE");
            _rippleRoundStroke(linearLayout, this.colorPrimaryDark, this.colorPrimary, 15.0d, 0.0d, "#EEEEEE");
            _rippleRoundStroke(linearLayout2, this.colorPrimaryDark, this.colorPrimary, 15.0d, 0.0d, "#EEEEEE");
            _rippleRoundStroke(linearLayout3, this.colorPrimaryDark, this.colorPrimary, 15.0d, 0.0d, "#EEEEEE");
            _rippleRoundStroke(linearLayout4, this.colorPrimaryDark, this.colorPrimary, 15.0d, 0.0d, "#EEEEEE");
            _rippleRoundStroke(linearLayout5, this.colorPrimaryDark, this.colorPrimary, 15.0d, 0.0d, "#EEEEEE");
            textView6.setTextColor(Color.parseColor(this.ColorText));
            textView7.setTextColor(Color.parseColor(this.ColorText));
            textView8.setTextColor(Color.parseColor(this.ColorText));
            textView11.setTextColor(Color.parseColor(this.ColorText));
            textView10.setTextColor(Color.parseColor(this.ColorText));
            textView9.setTextColor(Color.parseColor(this.ColorText));
            textView.setTextColor(Color.parseColor(this.ColorText));
            textView2.setTextColor(Color.parseColor(this.ColorText));
            textView3.setTextColor(Color.parseColor(this.ColorText));
            textView4.setTextColor(Color.parseColor(this.ColorText));
            textView5.setTextColor(Color.parseColor(this.ColorText));
            imageView.setImageResource(R.drawable.ic_launch_white);
            imageView2.setImageResource(R.drawable.ic_launch_white);
            imageView3.setImageResource(R.drawable.ic_launch_white);
            imageView4.setImageResource(R.drawable.ic_grade_white);
            imageView5.setImageResource(R.drawable.ic_share_white);
            imageView6.setImageResource(R.drawable.ic_comment_white);
            imageView7.setImageResource(R.drawable.ic_launch_white);
            imageView8.setImageResource(R.drawable.ic_close_white);
        } else {
            _radius(view, this.colorPrimary, 0.0d);
            _rippleRoundStroke(linearLayout6, this.colorPrimaryDark, this.colorPrimary, 15.0d, 0.0d, "#EEEEEE");
            _rippleRoundStroke(linearLayout7, this.colorPrimaryDark, this.colorPrimary, 15.0d, 0.0d, "#EEEEEE");
            _rippleRoundStroke(linearLayout8, this.colorPrimaryDark, this.colorPrimary, 15.0d, 0.0d, "#EEEEEE");
            _rippleRoundStroke(linearLayout, this.colorPrimaryDark, this.colorPrimary, 15.0d, 0.0d, "#EEEEEE");
            _rippleRoundStroke(linearLayout2, this.colorPrimaryDark, this.colorPrimary, 15.0d, 0.0d, "#EEEEEE");
            _rippleRoundStroke(linearLayout3, this.colorPrimaryDark, this.colorPrimary, 15.0d, 0.0d, "#EEEEEE");
            _rippleRoundStroke(linearLayout4, this.colorPrimaryDark, this.colorPrimary, 15.0d, 0.0d, "#EEEEEE");
            _rippleRoundStroke(linearLayout5, this.colorPrimaryDark, this.colorPrimary, 15.0d, 0.0d, "#EEEEEE");
            textView6.setTextColor(Color.parseColor(this.ColorText));
            textView7.setTextColor(Color.parseColor(this.ColorText));
            textView8.setTextColor(Color.parseColor(this.ColorText));
            textView11.setTextColor(Color.parseColor(this.ColorText));
            textView10.setTextColor(Color.parseColor(this.ColorText));
            textView9.setTextColor(Color.parseColor(this.ColorText));
            textView.setTextColor(Color.parseColor(this.ColorText));
            textView2.setTextColor(Color.parseColor(this.ColorText));
            textView3.setTextColor(Color.parseColor(this.ColorText));
            textView4.setTextColor(Color.parseColor(this.ColorText));
            textView5.setTextColor(Color.parseColor(this.ColorText));
            imageView.setImageResource(R.drawable.ic_launch_grey);
            imageView2.setImageResource(R.drawable.ic_launch_grey);
            imageView3.setImageResource(R.drawable.ic_launch_grey);
            imageView4.setImageResource(R.drawable.ic_grade_grey);
            imageView5.setImageResource(R.drawable.ic_share_grey);
            imageView6.setImageResource(R.drawable.ic_comment_grey);
            imageView7.setImageResource(R.drawable.ic_launch_grey);
            imageView8.setImageResource(R.drawable.ic_close_grey);
        }
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.arefin.rabindra.MainPageActivity.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                bottomSheetDialog.dismiss();
                MainPageActivity.this._Rate_Apps();
            }
        });
        linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.arefin.rabindra.MainPageActivity.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                MainPageActivity.this._Share();
            }
        });
        linearLayout3.setOnClickListener(new View.OnClickListener() { // from class: com.arefin.rabindra.MainPageActivity.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                bottomSheetDialog.dismiss();
                MainPageActivity.this._Feedback();
            }
        });
        linearLayout4.setOnClickListener(new View.OnClickListener() { // from class: com.arefin.rabindra.MainPageActivity.32
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                MainPageActivity.this._More_Apps();
            }
        });
        linearLayout5.setOnClickListener(new View.OnClickListener() { // from class: com.arefin.rabindra.MainPageActivity.33
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                MainPageActivity.this._BackPress();
            }
        });
        linearLayout6.setOnClickListener(new View.OnClickListener() { // from class: com.arefin.rabindra.MainPageActivity.34
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                bottomSheetDialog.dismiss();
                MainPageActivity.this._Visit(MainPageActivity.this.web, MainPageActivity.this.site_1);
            }
        });
        linearLayout7.setOnClickListener(new View.OnClickListener() { // from class: com.arefin.rabindra.MainPageActivity.35
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                MainPageActivity.this._Visit(MainPageActivity.this.web, MainPageActivity.this.site_2);
            }
        });
        linearLayout8.setOnClickListener(new View.OnClickListener() { // from class: com.arefin.rabindra.MainPageActivity.36
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                MainPageActivity.this._Visit(MainPageActivity.this.web, MainPageActivity.this.site_3);
            }
        });
        bottomSheetDialog.setCancelable(true);
        bottomSheetDialog.show();
    }

    private void _rippleRoundStroke(View view, String str, String str2, double d, double d2, String str3) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor(str));
        gradientDrawable.setCornerRadius((float) d);
        gradientDrawable.setStroke((int) d2, Color.parseColor("#" + str3.replace("#", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED)));
        view.setBackground(new RippleDrawable(new ColorStateList(new int[][]{new int[0]}, new int[]{Color.parseColor(str2)}), gradientDrawable, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _Visit(Intent intent, String str) {
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        startActivity(intent);
    }

    private void _RadiusGradient4(View view, String str, String str2, double d, double d2, double d3, double d4, double d5, String str3) {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{Color.parseColor(str), Color.parseColor(str2)});
        gradientDrawable.setCornerRadii(new float[]{(int) d, (int) d, (int) d2, (int) d2, (int) d3, (int) d3, (int) d4, (int) d4});
        gradientDrawable.setStroke((int) d5, Color.parseColor(str3));
        view.setBackground(gradientDrawable);
    }

    @Deprecated
    public void showMessage(String str) {
        Toast.makeText(getApplicationContext(), str, 0).show();
    }

    @Deprecated
    public int getLocationX(View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return iArr[0];
    }

    @Deprecated
    public int getLocationY(View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return iArr[1];
    }

    @Deprecated
    public int getRandom(int i, int i2) {
        return new Random().nextInt((i2 - i) + 1) + i;
    }

    @Deprecated
    public ArrayList<Double> getCheckedItemPositionsToArray(ListView listView) {
        ArrayList<Double> arrayList = new ArrayList<>();
        SparseBooleanArray checkedItemPositions = listView.getCheckedItemPositions();
        for (int i = 0; i < checkedItemPositions.size(); i++) {
            if (checkedItemPositions.valueAt(i)) {
                arrayList.add(Double.valueOf(checkedItemPositions.keyAt(i)));
            }
        }
        return arrayList;
    }

    @Deprecated
    public float getDip(int i) {
        return TypedValue.applyDimension(1, i, getResources().getDisplayMetrics());
    }

    @Deprecated
    public int getDisplayWidthPixels() {
        return getResources().getDisplayMetrics().widthPixels;
    }

    @Deprecated
    public int getDisplayHeightPixels() {
        return getResources().getDisplayMetrics().heightPixels;
    }
}
