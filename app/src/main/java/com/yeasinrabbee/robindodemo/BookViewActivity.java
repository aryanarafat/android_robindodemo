package com.yeasinrabbee.robindodemo;

import android.animation.ObjectAnimator;
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
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

/* loaded from: classes.dex */
public class BookViewActivity extends AppCompatActivity {
    private AdListener _interstitial_ad_listener;
    private AdView adview1;
    private SharedPreferences data;
    private ImageView imageview1;
    private ImageView imageview2;
    private InterstitialAd interstitial;
    private LinearLayout linear1;
    private LinearLayout linear3;
    private LinearLayout linear4;
    private LinearLayout linear_actionbar;
    private ListView listview1;
    private TextView textview1;
    private TextView textview2;
    private HashMap<String, Object> map_var = new HashMap<>();
    private String aa = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    private String bb = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    private String code = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    private String colorPrimary = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    private String colorPrimaryDark = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    private String ColorText = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    private ArrayList<HashMap<String, Object>> map_list = new ArrayList<>();
    private Intent i = new Intent();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.book_view);
        initialize(bundle);
        initializeLogic();
    }

    private void initialize(Bundle bundle) {
        this.linear1 = (LinearLayout) findViewById(R.id.linear1);
        this.linear_actionbar = (LinearLayout) findViewById(R.id.linear_actionbar);
        this.linear3 = (LinearLayout) findViewById(R.id.linear3);
        this.adview1 = (AdView) findViewById(R.id.adview1);
        this.imageview1 = (ImageView) findViewById(R.id.imageview1);
        this.linear4 = (LinearLayout) findViewById(R.id.linear4);
        this.imageview2 = (ImageView) findViewById(R.id.imageview2);
        this.textview1 = (TextView) findViewById(R.id.textview1);
        this.textview2 = (TextView) findViewById(R.id.textview2);
        this.listview1 = (ListView) findViewById(R.id.listview1);
        this.data = getSharedPreferences("data", 0);
        this.imageview1.setOnClickListener(new View.OnClickListener() { // from class: com.arefin.rabindra.BookViewActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BookViewActivity.this.finish();
            }
        });
        this.imageview2.setOnClickListener(new View.OnClickListener() { // from class: com.arefin.rabindra.BookViewActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BookViewActivity.this._Share();
            }
        });
        this.listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.arefin.rabindra.BookViewActivity.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (((HashMap) BookViewActivity.this.map_list.get(i)).containsKey("content")) {
                    BookViewActivity.this.i.putExtra(AppMeasurementSdk.ConditionalUserProperty.NAME, ((HashMap) BookViewActivity.this.map_list.get(i)).get(AppMeasurementSdk.ConditionalUserProperty.NAME).toString());
                    BookViewActivity.this.i.putExtra("content", ((HashMap) BookViewActivity.this.map_list.get(i)).get("content").toString());
                    BookViewActivity.this.i.setClass(BookViewActivity.this.getApplicationContext(), ContentActivity.class);
                    BookViewActivity.this.startActivity(BookViewActivity.this.i);
                    return;
                }
                BookViewActivity.this.i.putExtra("serial", ((HashMap) BookViewActivity.this.map_list.get(i)).get("serial").toString());
                BookViewActivity.this.i.putExtra(AppMeasurementSdk.ConditionalUserProperty.NAME, ((HashMap) BookViewActivity.this.map_list.get(i)).get(AppMeasurementSdk.ConditionalUserProperty.NAME).toString());
                BookViewActivity.this.i.putExtra("item", ((HashMap) BookViewActivity.this.map_list.get(i)).get("items").toString());
                if (BookViewActivity.this.getIntent().getStringExtra("Type").equals("Nobel")) {
                    BookViewActivity.this.i.setClass(BookViewActivity.this.getApplicationContext(), UpannashActivity.class);
                    BookViewActivity.this.startActivity(BookViewActivity.this.i);
                } else if (BookViewActivity.this.getIntent().getStringExtra("Type").equals("Small_Nobel")) {
                    BookViewActivity.this.i.setClass(BookViewActivity.this.getApplicationContext(), ChotaGalpaActivity.class);
                    BookViewActivity.this.startActivity(BookViewActivity.this.i);
                } else if (BookViewActivity.this.getIntent().getStringExtra("Type").equals("Essay")) {
                    BookViewActivity.this.i.setClass(BookViewActivity.this.getApplicationContext(), PrabandhaActivity.class);
                    BookViewActivity.this.startActivity(BookViewActivity.this.i);
                } else if (BookViewActivity.this.getIntent().getStringExtra("Type").equals("Drama")) {
                    BookViewActivity.this.i.setClass(BookViewActivity.this.getApplicationContext(), NatakActivity.class);
                    BookViewActivity.this.startActivity(BookViewActivity.this.i);
                } else if (BookViewActivity.this.getIntent().getStringExtra("Type").equals("Poets")) {
                    BookViewActivity.this.i.setClass(BookViewActivity.this.getApplicationContext(), KabitaActivity.class);
                    BookViewActivity.this.startActivity(BookViewActivity.this.i);
                } else if (BookViewActivity.this.getIntent().getStringExtra("Type").equals("Songs")) {
                    BookViewActivity.this.i.setClass(BookViewActivity.this.getApplicationContext(), SongsActivity.class);
                    BookViewActivity.this.startActivity(BookViewActivity.this.i);
                } else if (BookViewActivity.this.getIntent().getStringExtra("Type").equals("Others")) {
                    BookViewActivity.this.i.setClass(BookViewActivity.this.getApplicationContext(), OthersActivity.class);
                    BookViewActivity.this.startActivity(BookViewActivity.this.i);
                } else {
                    BookViewActivity.this.i.setClass(BookViewActivity.this.getApplicationContext(), ContentActivity.class);
                    BookViewActivity.this.startActivity(BookViewActivity.this.i);
                }
            }
        });
        this._interstitial_ad_listener = new AdListener() { // from class: com.arefin.rabindra.BookViewActivity.4
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
                BookViewActivity.this.interstitial.loadAd(new AdRequest.Builder().build());
            }
        };
    }

    private void initializeLogic() {
        _ColorsOnly();
        this.textview1.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
        this.textview2.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
        _Extra();
        this.adview1.loadAd(new AdRequest.Builder().build());
        this.adview1.setAdListener(new AdListener() { // from class: com.arefin.rabindra.BookViewActivity.5
            @Override // com.google.android.gms.ads.AdListener
            public void onAdLoaded() {
                Log.i(com.google.ads.AdRequest.LOGTAG, "onAdLoaded");
                BookViewActivity.this.adview1.setVisibility(0);
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdFailedToLoad(int i) {
                Log.i(com.google.ads.AdRequest.LOGTAG, "onAdFailedToLoad");
                BookViewActivity.this.adview1.setVisibility(8);
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
        _CardStyle(this.linear_actionbar, 5.0d, 0.0d, this.colorPrimary, false);
        if (this.data.getString("theme", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED).equals("theme4")) {
            Window window = getWindow();
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(Color.parseColor("#006064"));
            window.setNavigationBarColor(Color.parseColor("#FFFFFF"));
            _CardStyle(this.linear1, 5.0d, 0.0d, "#EEEEEE", false);
        } else if (this.data.getString("theme", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED).equals("theme3")) {
            Window window2 = getWindow();
            window2.clearFlags(67108864);
            window2.addFlags(Integer.MIN_VALUE);
            window2.setStatusBarColor(Color.parseColor(this.colorPrimary));
            window2.setNavigationBarColor(Color.parseColor(this.colorPrimaryDark));
            _CardStyle(this.linear1, 5.0d, 0.0d, this.colorPrimaryDark, false);
        } else if (this.data.getString("theme", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED).equals("theme2")) {
            Window window3 = getWindow();
            window3.clearFlags(67108864);
            window3.addFlags(Integer.MIN_VALUE);
            window3.getDecorView().setSystemUiVisibility(8192);
            window3.setStatusBarColor(Color.parseColor(this.colorPrimary));
            window3.setNavigationBarColor(Color.parseColor(this.colorPrimaryDark));
            _CardStyle(this.linear1, 5.0d, 0.0d, this.colorPrimaryDark, false);
        } else {
            Window window4 = getWindow();
            window4.clearFlags(67108864);
            window4.addFlags(Integer.MIN_VALUE);
            window4.getDecorView().setSystemUiVisibility(8192);
            window4.setStatusBarColor(Color.parseColor(this.colorPrimary));
            window4.setNavigationBarColor(Color.parseColor(this.colorPrimary));
            _CardStyle(this.linear1, 5.0d, 0.0d, this.colorPrimaryDark, false);
        }
        this.textview1.setTextColor(Color.parseColor(this.ColorText));
        this.textview2.setTextColor(Color.parseColor(this.ColorText));
        this.imageview1.setClickable(true);
        this.imageview1.setBackground(CircleDrawables.getSelectableDrawableFor(Color.parseColor("#FFFFFFFF")));
        this.imageview2.setClickable(true);
        this.imageview2.setBackground(CircleDrawables.getSelectableDrawableFor(Color.parseColor("#FFFFFFFF")));
        this.listview1.setSelector(17170445);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void _radius(View view, String str, double d) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor(str));
        gradientDrawable.setCornerRadius((int) d);
        view.setBackground(gradientDrawable);
    }

    private void _Extra() {
        if (getIntent().getStringExtra("Type").equals("Nobel")) {
            this.textview1.setText("উপন্যাস");
            this.textview2.setText("মোট গ্রন্থ : ১৩ টি");
            _Nobel();
            this.listview1.setAdapter((ListAdapter) new Listview1Adapter(this.map_list));
            ((BaseAdapter) this.listview1.getAdapter()).notifyDataSetChanged();
        }
        if (getIntent().getStringExtra("Type").equals("Small_Nobel")) {
            this.textview1.setText("ছোটগল্প");
            this.textview2.setText("মোট বই : ৫ টি");
            _ChotoGalpa();
            this.listview1.setAdapter((ListAdapter) new Listview1Adapter(this.map_list));
            ((BaseAdapter) this.listview1.getAdapter()).notifyDataSetChanged();
        }
        if (getIntent().getStringExtra("Type").equals("Essay")) {
            this.textview1.setText("প্রবন্ধ");
            this.textview2.setText("মোট বই : ৬০ টি");
            _Essay();
            _Essay_1();
            this.listview1.setAdapter((ListAdapter) new Listview1Adapter(this.map_list));
            ((BaseAdapter) this.listview1.getAdapter()).notifyDataSetChanged();
        }
        if (getIntent().getStringExtra("Type").equals("Drama")) {
            this.textview1.setText("নাটক");
            this.textview2.setText("মোট নাটক : ৫৭ টি");
            _Drama();
            _Drama_1();
            this.listview1.setAdapter((ListAdapter) new Listview1Adapter(this.map_list));
            ((BaseAdapter) this.listview1.getAdapter()).notifyDataSetChanged();
        }
        if (getIntent().getStringExtra("Type").equals("Poets")) {
            this.textview1.setText("কবিতা");
            this.textview2.setText("মোট বই : ৫৯ টি");
            _Poetries();
            _Poetries_1();
            this.listview1.setAdapter((ListAdapter) new Listview1Adapter(this.map_list));
            ((BaseAdapter) this.listview1.getAdapter()).notifyDataSetChanged();
        }
        if (getIntent().getStringExtra("Type").equals("Songs")) {
            this.textview1.setText("গান");
            this.textview2.setText("মোট বই : ১৯ টি");
            _Songs();
            this.listview1.setAdapter((ListAdapter) new Listview1Adapter(this.map_list));
            ((BaseAdapter) this.listview1.getAdapter()).notifyDataSetChanged();
        }
        if (getIntent().getStringExtra("Type").equals("Others")) {
            this.textview1.setText("অন্যান্য");
            this.textview2.setText("মোট বই : ১২ টি");
            _Others();
            this.listview1.setAdapter((ListAdapter) new Listview1Adapter(this.map_list));
            ((BaseAdapter) this.listview1.getAdapter()).notifyDataSetChanged();
        }
    }

    private void _Nobel() {
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "গোরা");
        this.map_var.put("items", "৭৭");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "২");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "ঘরে বাইরে");
        this.map_var.put("items", "১৮");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৩");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "চতুরঙ্গ");
        this.map_var.put("items", "৪");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৪");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "চার অধ্যায়");
        this.map_var.put("items", "৫");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৫");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "চোখের বালি");
        this.map_var.put("items", "৫৫");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৬");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "দুই বোন");
        this.map_var.put("items", "৪");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৭");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "নৌকা ডুবি");
        this.map_var.put("items", "৬৩");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৮");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "প্রজাপতির নির্বন্ধ");
        this.map_var.put("items", "১৬");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৯");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "বউ-ঠাকুরানীর হাট");
        this.map_var.put("items", "৩৮");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১০");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "মালঞ্চ");
        this.map_var.put("items", "১০");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১১");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "যোগাযোগ");
        this.map_var.put("items", "৫৮");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১২");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "রাজর্ষি");
        this.map_var.put("items", "৪৬");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১৩");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "শেষের কবিতা");
        this.map_var.put("items", "১৭");
        this.map_list.add(this.map_var);
    }

    private void _ChotoGalpa() {
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "অন্যান্য");
        this.map_var.put("items", "৪");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "২");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "গল্পগুচ্ছ");
        this.map_var.put("items", "৯১");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৩");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "গল্পসল্প");
        this.map_var.put("items", "১৭");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৪");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "তিনসঙ্গী");
        this.map_var.put("items", "৪");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৫");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "লিপিকা");
        this.map_var.put("items", "৩৯");
        this.map_list.add(this.map_var);
    }

    private void _Essay() {
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "আত্মপরিচয়");
        this.map_var.put("items", "৫");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "২");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "আত্মশক্তি");
        this.map_var.put("items", "১০");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৩");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "আধুনিক সাহিত্য");
        this.map_var.put("items", "১৯");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৪");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "আশ্রমের রূপ ও বিকাশ");
        this.map_var.put("items", "৩");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৫");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "ইতিহাস");
        this.map_var.put("items", "১০");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৬");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "কর্তার ইচ্ছায় কর্ম");
        this.map_var.put("items", "১");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৭");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "কালান্তর");
        this.map_var.put("items", "২৪");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৮");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "খৃষ্ট");
        this.map_var.put("items", "৬");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৯");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "গ্রন্থসমালোচনা");
        this.map_var.put("items", "২৩");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১০");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "চারিত্রপূজা");
        this.map_var.put("items", "৫");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১১");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "চিঠিপত্র");
        this.map_var.put("items", "৯");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১২");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "ছন্দ");
        this.map_var.put("items", "৩৩");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১৩");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "ছেলেবেলা");
        this.map_var.put("items", "৩");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১৪");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "জাপানযাত্রী");
        this.map_var.put("items", "১৫");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১৫");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "জাভা-যাত্রীর পত্র");
        this.map_var.put("items", "২১");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১৬");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "জীবনস্মৃতি");
        this.map_var.put("items", "৪৫");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১৭");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "ধর্ম");
        this.map_var.put("items", "১৫");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১৮");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "ধর্ম/দর্শন");
        this.map_var.put("items", "৮");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১৯");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "পঞ্চভূত");
        this.map_var.put("items", "১৬");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "২০");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "পথের সঞ্চয়");
        this.map_var.put("items", "২২");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "২১");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "পরিচয়");
        this.map_var.put("items", "১০");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "২২");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "পল্লীপ্রকৃতি");
        this.map_var.put("items", "১৭");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "২৩");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "পশ্চিম যাত্রীর ডায়ারি");
        this.map_var.put("items", "২৪");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "২৪");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "পারস্যে");
        this.map_var.put("items", "১১");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "২৫");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "প্রাচীনসাহিত্য");
        this.map_var.put("items", "৬");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "২৬");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "বাংলা শব্দতত্ত্ব");
        this.map_var.put("items", "৪৩");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "২৭");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "বাংলাভাষা পরিচয়");
        this.map_var.put("items", "২৪");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "২৮");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "বিচিত্র প্রবন্ধ");
        this.map_var.put("items", "১৪");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "২৯");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "বিজ্ঞান");
        this.map_var.put("items", "১৬");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৩০");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "বিবিধ");
        this.map_var.put("items", "৩৪");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৩১");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "বিশ্বপরিচয়");
        this.map_var.put("items", "৭");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৩২");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "বিশ্বভারতী");
        this.map_var.put("items", "২০");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৩৩");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "ব্যক্তিপ্রসঙ্গ");
        this.map_var.put("items", "৫৩");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৩৪");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "ব্যঙ্গকৌতুক");
        this.map_var.put("items", "৯");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৩৫");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "ভারতবর্ষ");
        this.map_var.put("items", "১০");
        this.map_list.add(this.map_var);
    }

    private void _Drama() {
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "অচলায়তন");
        this.map_var.put("items", "৭");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "২");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "অরূপরতন");
        this.map_var.put("items", "৫");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৩");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "ঋণশোধ");
        this.map_var.put("items", "১");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৪");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "কালমৃগয়া");
        this.map_var.put("items", "১");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৫");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "কালের যাত্রা");
        this.map_var.put("items", "৪");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৬");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "কাহিনী");
        this.map_var.put("items", "৭");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৭");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "গুরু");
        this.map_var.put("items", "১");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৮");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "গৃহপ্রবেশ");
        this.map_var.put("items", "২");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৯");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "গোড়ায় গলদ");
        this.map_var.put("items", "৬");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১০");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "চণ্ডালিকা");
        this.map_var.put("items", "১");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১১");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "চিত্রাঙ্গদা");
        this.map_var.put("items", "১১");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১২");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "চিরকুমার-সভা");
        this.map_var.put("items", "৬");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১৩");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "ডাকঘর");
        this.map_var.put("items", "৩");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১৪");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "তপতী");
        this.map_var.put("items", "৭");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১৫");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "তাসের দেশ");
        this.map_var.put("items", "৫");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১৬");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "নটরাজ");
        this.map_var.put("items", "৮");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১৭");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "নটীর পূজা");
        this.map_var.put("items", "৬");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১৮");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "নবীন");
        this.map_var.put("items", "৩");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১৯");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "নলিনী");
        this.map_var.put("items", "১");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "২০");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "নৃত্যনাট্য চণ্ডালিকা");
        this.map_var.put("items", "১");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "২১");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "নৃত্যনাট্য চিত্রাঙ্গদা");
        this.map_var.put("items", "৯");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "২২");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "নৃত্যনাট্য মায়ার খেলা");
        this.map_var.put("items", "৭");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "২৩");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "পরিত্রাণ");
        this.map_var.put("items", "৪");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "২৪");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "পরিশোধ");
        this.map_var.put("items", "৫");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "২৫");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "প্রকৃতির প্রতিশোধ");
        this.map_var.put("items", "১৭");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "২৬");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "প্রায়শ্চিত্ত");
        this.map_var.put("items", "৭");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "২৭");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "ফাল্গুনী");
        this.map_var.put("items", "৭");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "২৮");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "বসন্ত");
        this.map_var.put("items", "১");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "২৯");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "বাঁশরি");
        this.map_var.put("items", "৩");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৩০");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "বাল্মীকিপ্রতিভা");
        this.map_var.put("items", "৭");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৩১");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "বাল্মীকিপ্রতিভা - প্রথম সংস্করণ");
        this.map_var.put("items", "৪");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৩২");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "বিদায়-অভিশাপ");
        this.map_var.put("items", "১");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৩৩");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "বিসর্জন");
        this.map_var.put("items", "৭");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৩৪");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "বিসর্জন সংক্ষিপ্ত");
        this.map_var.put("items", "৫");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৩৫");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "বৈকুণ্ঠের খাতা");
        this.map_var.put("items", "৩");
        this.map_list.add(this.map_var);
    }

    private void _Poetries() {
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "অনুবাদ কবিতা");
        this.map_var.put("items", "৩৮");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "২");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "অনূদিত কবিতা");
        this.map_var.put("items", "১৯");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৩");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "আকাশপ্রদীপ");
        this.map_var.put("items", "২৩");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৪");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "আরোগ্য");
        this.map_var.put("items", "৩৪");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৫");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "উৎসর্গ");
        this.map_var.put("items", "৬১");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৬");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "কণিকা");
        this.map_var.put("items", "১১০");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৭");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "কথা");
        this.map_var.put("items", "২৬");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৮");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "কবিতা");
        this.map_var.put("items", "৩০");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৯");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "কল্পনা");
        this.map_var.put("items", "৫০");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১০");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "কাহিনী");
        this.map_var.put("items", "৮");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১১");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "ক্ষণিকা");
        this.map_var.put("items", "৬৩");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১২");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "কড়ি ও কোমল");
        this.map_var.put("items", "৮৬");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১৩");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "খাপছাড়া");
        this.map_var.put("items", "১৩১");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১৪");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "খেয়া");
        this.map_var.put("items", "৫৪");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১৫");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "গল্পসল্প");
        this.map_var.put("items", "১");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১৬");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "গীতাঞ্জলি");
        this.map_var.put("items", "১৫৭");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১৭");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "গীতালি");
        this.map_var.put("items", "১১৯");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১৮");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "গীতিমাল্য");
        this.map_var.put("items", "১১১");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১৯");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "চিত্রবিচিত্র");
        this.map_var.put("items", "১২");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "২০");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "চিত্রা");
        this.map_var.put("items", "৩৭");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "২১");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "চৈতালি");
        this.map_var.put("items", "৮০");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "২২");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "ছবি ও গান");
        this.map_var.put("items", "৩০");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "২৩");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "ছড়া");
        this.map_var.put("items", "১২");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "২৪");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "ছড়ার ছবি");
        this.map_var.put("items", "৩৩");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "২৫");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "জন্মদিনে");
        this.map_var.put("items", "৩২");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "২৬");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "নদী");
        this.map_var.put("items", "২");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "২৭");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "নবজাতক");
        this.map_var.put("items", "৩৬");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "২৮");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "নৈবেদ্য");
        this.map_var.put("items", "১০১");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "২৯");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "পত্রপুট");
        this.map_var.put("items", "১৯");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৩০");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "পরিশেষ");
        this.map_var.put("items", "৮৮");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৩১");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "পলাতকা");
        this.map_var.put("items", "১৫");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৩২");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "পুনশ্চ");
        this.map_var.put("items", "৫১");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৩৩");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "পূরবী");
        this.map_var.put("items", "৮০");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৩৪");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "প্রভাতসংগীত");
        this.map_var.put("items", "১৬");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৩৫");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "প্রহাসিনী");
        this.map_var.put("items", "৪২");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৩৬");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "প্রান্তিক");
        this.map_var.put("items", "১৮");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৩৭");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "বনবাণী");
        this.map_var.put("items", "১৫");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৩৮");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "বলাকা");
        this.map_var.put("items", "৪৬");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৩৯");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "বিচিত্রিতা");
        this.map_var.put("items", "৩২");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৪০");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "বীথিকা");
        this.map_var.put("items", "৯০");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৪১");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "ভানুসিংহ ঠাকুরের পদাবলী");
        this.map_var.put("items", "২২");
        this.map_list.add(this.map_var);
    }

    private void _Songs() {
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "আনুষ্ঠানিক");
        this.map_var.put("items", "২১");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "২");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "আনুষ্ঠানিক সংগীত");
        this.map_var.put("items", "১৭");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৩");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "কালমৃগয়া (গীতবিতান)");
        this.map_var.put("items", "৩৭");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৪");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "চণ্ডালিকা (গীতবিতান)");
        this.map_var.put("items", "৫৪");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৫");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "চিত্রাঙ্গদা (গীতবিতান)");
        this.map_var.put("items", "৪৮");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৬");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "জাতীয় সংগীত");
        this.map_var.put("items", "১৬");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৭");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "নাট্যগীতি");
        this.map_var.put("items", "১৩৩");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৮");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "পরিশিষ্ট ১ - নৃত্যনাট্য মায়ার খেলা");
        this.map_var.put("items", "৪৭");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৯");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "পরিশিষ্ট ২ - পরিশোধ");
        this.map_var.put("items", "৩০");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১০");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "পরিশিষ্ট ৩ - রবিচ্ছায়া");
        this.map_var.put("items", "৯");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১১");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "পরিশিষ্ট ৪");
        this.map_var.put("items", "৬");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১২");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "প্রকৃতি");
        this.map_var.put("items", "২৮২");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১৩");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "প্রেম");
        this.map_var.put("items", "৩৯৪");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১৪");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "প্রেম ও প্রকৃতি");
        this.map_var.put("items", "১০১");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১৫");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "বাল্মীকিপ্রতিভা (গীতবিতান)");
        this.map_var.put("items", "৫২");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১৬");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "বিচিত্র");
        this.map_var.put("items", "১৪০");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১৭");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "ভানুসিংহ ঠাকুরের পদাবলী (গীতবিতান)");
        this.map_var.put("items", "২০");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১৮");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "মায়ার খেলা (গীতবিতান)");
        this.map_var.put("items", "৬৩");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১৯");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "স্বদেশ");
        this.map_var.put("items", "৪৬");
        this.map_list.add(this.map_var);
    }

    private void _Others() {
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "অনুবাদ চর্চা");
        this.map_var.put("items", "২");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "২");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "আলোচনা");
        this.map_var.put("items", "৭");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৩");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "ঔপনিষদ ব্রহ্ম");
        this.map_var.put("items", "১");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৪");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "কবি-কাহিনী");
        this.map_var.put("items", "৪");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৫");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "বনফুল");
        this.map_var.put("items", "৯");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৬");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "বিবিধ প্রসঙ্গ");
        this.map_var.put("items", "৩৯");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৭");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "ব্রহ্মমন্ত্র");
        this.map_var.put("items", "১");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৮");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "মন্ত্রি অভিষেক");
        this.map_var.put("items", "১");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৯");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "শৈশবসংগীত");
        this.map_var.put("items", "১৯");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১০");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "সংস্কৃত শিক্ষা: দ্বিতীয় ভাগ");
        this.map_var.put("items", "৭");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১১");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "সমালোচনা");
        this.map_var.put("items", "১৬");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১২");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "সহজ পাঠ: প্রথম ও দ্বিতীয় ভাগ");
        this.map_var.put("items", "২");
        this.map_list.add(this.map_var);
    }

    private void _Poetries_1() {
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৪২");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "মহুয়া");
        this.map_var.put("items", "৮৬");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৪৩");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "মানসী");
        this.map_var.put("items", "৬৫");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৪৪");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "রূপান্তর");
        this.map_var.put("items", "১১");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৪৫");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "রোগশয্যায়");
        this.map_var.put("items", "৪২");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৪৬");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "লেখন");
        this.map_var.put("items", "১৮২");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৪৭");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "শিশু");
        this.map_var.put("items", "৫০");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৪৮");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "শিশু ভোলানাথ");
        this.map_var.put("items", "২৭");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৪৯");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "শেষ লেখা");
        this.map_var.put("items", "১৫");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৫০");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "শেষ সপ্তক");
        this.map_var.put("items", "৫৬");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৫১");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "শ্যামলী");
        this.map_var.put("items", "২২");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৫২");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "সন্ধ্যাসংগীত");
        this.map_var.put("items", "২৬");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৫৩");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "সানাই");
        this.map_var.put("items", "৬০");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৫৪");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "সেঁজুতি");
        this.map_var.put("items", "২৩");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৫৫");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "সোনার তরী");
        this.map_var.put("items", "৪৪");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৫৬");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "স্ফুলিঙ্গ");
        this.map_var.put("items", "২৬০");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৫৭");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "স্ফুলিঙ্গ - অপ্রচলিত সংগ্রহ");
        this.map_var.put("items", "৭৩");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৫৮");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "স্ফুলিঙ্গ - সংযোজন");
        this.map_var.put("items", "১২৯");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৫৯");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "স্মরণ");
        this.map_var.put("items", "২৭");
        this.map_list.add(this.map_var);
    }

    private void _Essay_1() {
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৩৬");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "মহাত্মা গান্ধী");
        this.map_var.put("items", "৫");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৩৭");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "মানুষের ধর্ম");
        this.map_var.put("items", "৭");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৩৮");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "রাজা প্রজা");
        this.map_var.put("items", "১০");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৩৯");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "রাশিয়ার চিঠি");
        this.map_var.put("items", "১৯");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৪০");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "লোকসাহিত্য");
        this.map_var.put("items", "৪");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৪১");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "শব্দতত্ত্ব");
        this.map_var.put("items", "২২");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৪২");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "শান্তিনিকেতন");
        this.map_var.put("items", "১৪৯");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৪৩");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "শান্তিনিকেতন ব্রহ্মচর্যাশ্রম");
        this.map_var.put("items", "২");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৪৪");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "শিক্ষা");
        this.map_var.put("items", "২৮");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৪৫");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "শিল্প");
        this.map_var.put("items", "২");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৪৬");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "সংগীত");
        this.map_var.put("items", "২");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৪৭");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "সংগীতচিন্তা");
        this.map_var.put("items", "১৪");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৪৮");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "সঞ্চয়");
        this.map_var.put("items", "৮");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৪৯");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "সভ্যতার সংকট");
        this.map_var.put("items", "১");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৫০");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "সমবায়নীতি");
        this.map_var.put("items", "৫");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৫১");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "সমাজ");
        this.map_var.put("items", "৪৯");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৫২");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "সমূহ");
        this.map_var.put("items", "৫");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৫৩");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "সাময়িক সারসংগ্রহ");
        this.map_var.put("items", "৫০");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৫৪");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "সাময়িক সাহিত্য সমালোচনা");
        this.map_var.put("items", "৩৯");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৫৫");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "সাহিত্য");
        this.map_var.put("items", "৪৭");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৫৬");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "সাহিত্যের পথে");
        this.map_var.put("items", "২০");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৫৭");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "সাহিত্যের স্বরূপ");
        this.map_var.put("items", "১০");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৫৮");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "স্বদেশ");
        this.map_var.put("items", "৩");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৫৯");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "য়ুরোপ-প্রবাসীর পত্র");
        this.map_var.put("items", "১১");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৬০");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "য়ুরোপ-যাত্রীর ডায়ারি");
        this.map_var.put("items", "২");
        this.map_list.add(this.map_var);
    }

    private void _Drama_1() {
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৩৬");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "ব্যঙ্গকৌতুক");
        this.map_var.put("items", "৬");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৩৭");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "ভগ্নহৃদয়");
        this.map_var.put("items", "৩৫");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৩৮");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "মালঞ্চ");
        this.map_var.put("items", "৩");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৩৯");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "মালিনী");
        this.map_var.put("items", "১");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৪০");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "মায়ার খেলা");
        this.map_var.put("items", "৮");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৪১");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "মুকুট");
        this.map_var.put("items", "৪");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৪২");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "মুক্তধারা");
        this.map_var.put("items", "১");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৪৩");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "মুক্তির উপায়");
        this.map_var.put("items", "১");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৪৪");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "যোগাযোগ");
        this.map_var.put("items", "৪");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৪৫");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "রক্তকরবী");
        this.map_var.put("items", "১");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৪৬");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "রাজা");
        this.map_var.put("items", "২০");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৪৭");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "রাজা ও রানী");
        this.map_var.put("items", "৬");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৪৮");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "রুদ্রচণ্ড");
        this.map_var.put("items", "১৫");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৪৯");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "শাপমোচন");
        this.map_var.put("items", "১১");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৫০");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "শারদোৎসব");
        this.map_var.put("items", "১");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৫১");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "শেষ বর্ষণ");
        this.map_var.put("items", "১");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৫২");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "শেষরক্ষা");
        this.map_var.put("items", "৫");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৫৩");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "শোধবোধ");
        this.map_var.put("items", "১");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৫৪");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "শ্যামা");
        this.map_var.put("items", "২");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৫৫");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "শ্রাবণগাথা");
        this.map_var.put("items", "১");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৫৬");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "সুন্দর");
        this.map_var.put("items", "১");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৫৭");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "হাস্যকৌতুক");
        this.map_var.put("items", "১৬");
        this.map_list.add(this.map_var);
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

    private void _ColorsOnly() {
        if (this.data.getString("theme", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED).equals("theme4")) {
            this.colorPrimary = "#006064";
            this.colorPrimaryDark = "#FFFFFF";
            this.ColorText = "#FFFFFF";
            this.imageview1.setImageResource(R.drawable.ic_arrow_back_white);
            this.imageview2.setImageResource(R.drawable.ic_share_white);
        } else if (this.data.getString("theme", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED).equals("theme3")) {
            this.colorPrimary = "#424242";
            this.colorPrimaryDark = "#171717";
            this.ColorText = "#FFFFFF";
            this.imageview1.setImageResource(R.drawable.ic_arrow_back_white);
            this.imageview2.setImageResource(R.drawable.ic_share_white);
        } else if (this.data.getString("theme", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED).equals("theme2")) {
            this.colorPrimary = "#FFF3E0";
            this.colorPrimaryDark = "#FFE0B2";
            this.ColorText = "#000000";
            this.imageview1.setImageResource(R.drawable.ic_arrow_back_grey);
            this.imageview2.setImageResource(R.drawable.ic_share_grey);
        } else {
            this.colorPrimary = "#FFFFFF";
            this.colorPrimaryDark = "#E0E0E0";
            this.ColorText = "#000000";
            this.imageview1.setImageResource(R.drawable.ic_arrow_back_grey);
            this.imageview2.setImageResource(R.drawable.ic_share_grey);
        }
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
            view.setOnTouchListener(new View.OnTouchListener() { // from class: com.arefin.rabindra.BookViewActivity.6
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

    /* JADX INFO: Access modifiers changed from: private */
    public void _rippleRoundStroke(View view, String str, String str2, double d, double d2, String str3) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor(str));
        gradientDrawable.setCornerRadius((float) d);
        gradientDrawable.setStroke((int) d2, Color.parseColor("#" + str3.replace("#", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED)));
        view.setBackground(new RippleDrawable(new ColorStateList(new int[][]{new int[0]}, new int[]{Color.parseColor(str2)}), gradientDrawable, null));
    }

    /* loaded from: classes.dex */
    public class Listview1Adapter extends BaseAdapter {
        ArrayList<HashMap<String, Object>> _data;

        public Listview1Adapter(ArrayList<HashMap<String, Object>> arrayList) {
            this._data = arrayList;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this._data.size();
        }

        @Override // android.widget.Adapter
        public HashMap<String, Object> getItem(int i) {
            return this._data.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater layoutInflater = (LayoutInflater) BookViewActivity.this.getBaseContext().getSystemService("layout_inflater");
            if (view == null) {
                view = layoutInflater.inflate(R.layout.custom, (ViewGroup) null);
            }
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.linear1);
            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.linear_circle);
            LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.linear3);
            ImageView imageView = (ImageView) view.findViewById(R.id.imageview1);
            TextView textView = (TextView) view.findViewById(R.id.textview2);
            TextView textView2 = (TextView) view.findViewById(R.id.textview1);
            TextView textView3 = (TextView) view.findViewById(R.id.textview3);
            textView2.setText(this._data.get(i).get(AppMeasurementSdk.ConditionalUserProperty.NAME).toString());
            textView.setText(this._data.get(i).get("serial").toString());
            textView3.setText("মোট কন্টেন্ট ".concat(this._data.get(i).get("items").toString().concat(" টি")));
            textView2.setTypeface(Typeface.createFromAsset(BookViewActivity.this.getAssets(), "fonts/solaimanlipi.ttf"), 0);
            textView.setTypeface(Typeface.createFromAsset(BookViewActivity.this.getAssets(), "fonts/solaimanlipi.ttf"), 0);
            textView3.setTypeface(Typeface.createFromAsset(BookViewActivity.this.getAssets(), "fonts/solaimanlipi.ttf"), 0);
            if (!BookViewActivity.this.data.getString("theme", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED).equals("theme4")) {
                if (!BookViewActivity.this.data.getString("theme", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED).equals("theme3")) {
                    if (BookViewActivity.this.data.getString("theme", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED).equals("theme2")) {
                        BookViewActivity.this._radius(linearLayout2, BookViewActivity.this.colorPrimaryDark, 180.0d);
                        BookViewActivity.this._rippleRoundStroke(linearLayout, BookViewActivity.this.colorPrimary, BookViewActivity.this.colorPrimaryDark, 20.0d, 0.0d, BookViewActivity.this.colorPrimary);
                        textView2.setTextColor(Color.parseColor(BookViewActivity.this.ColorText));
                        textView.setTextColor(Color.parseColor(BookViewActivity.this.ColorText));
                        textView3.setTextColor(Color.parseColor(BookViewActivity.this.ColorText));
                    } else {
                        BookViewActivity.this._radius(linearLayout2, BookViewActivity.this.colorPrimaryDark, 180.0d);
                        BookViewActivity.this._rippleRoundStroke(linearLayout, BookViewActivity.this.colorPrimary, BookViewActivity.this.colorPrimaryDark, 20.0d, 0.0d, BookViewActivity.this.colorPrimary);
                        textView2.setTextColor(Color.parseColor(BookViewActivity.this.ColorText));
                        textView.setTextColor(Color.parseColor(BookViewActivity.this.ColorText));
                        textView3.setTextColor(Color.parseColor(BookViewActivity.this.ColorText));
                    }
                } else {
                    BookViewActivity.this._radius(linearLayout2, BookViewActivity.this.colorPrimaryDark, 180.0d);
                    BookViewActivity.this._rippleRoundStroke(linearLayout, BookViewActivity.this.colorPrimary, BookViewActivity.this.colorPrimaryDark, 20.0d, 0.0d, BookViewActivity.this.colorPrimary);
                    textView2.setTextColor(Color.parseColor(BookViewActivity.this.ColorText));
                    textView.setTextColor(Color.parseColor(BookViewActivity.this.ColorText));
                    textView3.setTextColor(Color.parseColor(BookViewActivity.this.ColorText));
                }
            } else {
                BookViewActivity.this._radius(linearLayout2, BookViewActivity.this.colorPrimary, 180.0d);
                BookViewActivity.this._rippleRoundStroke(linearLayout, BookViewActivity.this.colorPrimaryDark, BookViewActivity.this.colorPrimary, 20.0d, 0.0d, BookViewActivity.this.colorPrimaryDark);
                textView2.setTextColor(Color.parseColor("#000000"));
                textView.setTextColor(Color.parseColor("#FFFFFF"));
                textView3.setTextColor(Color.parseColor("#212121"));
            }
            Animation loadAnimation = AnimationUtils.loadAnimation(BookViewActivity.this.getApplicationContext(), 17432578);
            loadAnimation.setDuration(200L);
            linearLayout.startAnimation(loadAnimation);
            return view;
        }
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
