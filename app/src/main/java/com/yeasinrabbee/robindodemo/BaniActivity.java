package com.yeasinrabbee.robindodemo;

import android.animation.ObjectAnimator;
import android.content.ClipData;
import android.content.ClipboardManager;
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
public class BaniActivity extends AppCompatActivity {
    private AdListener _interstitial_ad_listener;
    private AdView adview1;
    private SharedPreferences data;
    private ImageView imageview1;
    private ImageView imageview2;
    private InterstitialAd interstitial;
    private LinearLayout linear1;
    private LinearLayout linear2;
    private LinearLayout linear3;
    private LinearLayout linear4;
    private ListView listview1;
    private ListView listview2;
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
        setContentView(R.layout.bani);
        initialize(bundle);
        initializeLogic();
    }

    private void initialize(Bundle bundle) {
        this.linear1 = (LinearLayout) findViewById(R.id.linear1);
        this.linear2 = (LinearLayout) findViewById(R.id.linear2);
        this.linear3 = (LinearLayout) findViewById(R.id.linear3);
        this.adview1 = (AdView) findViewById(R.id.adview1);
        this.imageview1 = (ImageView) findViewById(R.id.imageview1);
        this.linear4 = (LinearLayout) findViewById(R.id.linear4);
        this.imageview2 = (ImageView) findViewById(R.id.imageview2);
        this.textview1 = (TextView) findViewById(R.id.textview1);
        this.textview2 = (TextView) findViewById(R.id.textview2);
        this.listview1 = (ListView) findViewById(R.id.listview1);
        this.listview2 = (ListView) findViewById(R.id.listview2);
        this.data = getSharedPreferences("data", 0);
        this.imageview1.setOnClickListener(new View.OnClickListener() { // from class: com.arefin.rabindra.BaniActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BaniActivity.this.finish();
            }
        });
        this.imageview2.setOnClickListener(new View.OnClickListener() { // from class: com.arefin.rabindra.BaniActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BaniActivity.this._Share();
            }
        });
        this.listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.arefin.rabindra.BaniActivity.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            }
        });
        this.listview2.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.arefin.rabindra.BaniActivity.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                BaniActivity.this.i.putExtra(AppMeasurementSdk.ConditionalUserProperty.NAME, ((HashMap) BaniActivity.this.map_list.get(i)).get(AppMeasurementSdk.ConditionalUserProperty.NAME).toString());
                BaniActivity.this.i.putExtra("content", ((HashMap) BaniActivity.this.map_list.get(i)).get("content").toString());
                BaniActivity.this.i.setClass(BaniActivity.this.getApplicationContext(), ConfirmationActivity.class);
                BaniActivity.this.startActivity(BaniActivity.this.i);
            }
        });
        this._interstitial_ad_listener = new AdListener() { // from class: com.arefin.rabindra.BaniActivity.5
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
                BaniActivity.this.interstitial.loadAd(new AdRequest.Builder().build());
            }
        };
    }

    private void initializeLogic() {
        _ColorsOnly();
        this.textview1.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 1);
        this.textview2.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
        _Extra();
        this.adview1.loadAd(new AdRequest.Builder().build());
        this.adview1.setAdListener(new AdListener() { // from class: com.arefin.rabindra.BaniActivity.6
            @Override // com.google.android.gms.ads.AdListener
            public void onAdLoaded() {
                Log.i(com.google.ads.AdRequest.LOGTAG, "onAdLoaded");
                BaniActivity.this.adview1.setVisibility(0);
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdFailedToLoad(int i) {
                Log.i(com.google.ads.AdRequest.LOGTAG, "onAdFailedToLoad");
                BaniActivity.this.adview1.setVisibility(8);
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
        _click(this.imageview1);
        _click(this.imageview2);
        _CardStyle(this.linear2, 5.0d, 0.0d, this.colorPrimary, false);
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
        this.listview1.setSelector(17170445);
        this.listview2.setSelector(17170445);
        this.textview1.setTextColor(Color.parseColor(this.ColorText));
        this.textview2.setTextColor(Color.parseColor(this.ColorText));
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

    private void _Bani_List_1() {
        this.map_var = new HashMap<>();
        this.map_var.put("content", "নিন্দা করতে গেলে বাইরে থেকে করা যায়, কিন্তু বিচার করতে গেলে ভিতরে প্রবেশ করতে হয়");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "মানুষের একটা বয়স আছে যখন সে চিন্তা না করিয়াও বিবাহ করিতে পারে। সে বয়স পেরোলে বিবাহ করিতে দুঃসাহসিকতার দরকার হয়");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "নিন্দা করতে গেলে বাইরে থেকে করা যায়, কিন্তু বিচার করতে গেলে ভিতরে প্রবেশ করতে হয়");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "চন্দ্রের যা কলঙ্ক সেটা কেবল মুখের উপরে, তার জ্যোৎস্নায় কোনো দাগ পড়ে না।");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "শুধু দিনযাপনের শুধু প্রাণধারণের গ্লানি\nশরমের ডালি,\nনিশি নিশি রুদ্ধ ঘরে ক্ষুদ্রশিখা স্তিমিত দীপের\nধূমাঙ্কিত কালি,\nলাভ-ক্ষতি-টানাটানি, অতি ক্ষুদ্র ভগ্ন-অংশ-ভাগ,\nকলহ সংশয়--\nসহে না সহে না আর জীবনেরে খণ্ড খণ্ড করি\nদণ্ডে দণ্ডে ক্ষয়।");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "যে পথে অনন্ত লোক চলিয়াছে ভীষণ নীরবে\nসে পথপ্রান্তের\nএক পার্শ্বে রাখো মোরে, নিরখির বিরাট স্বরূপ\nযুগযুগান্তের।\nশ্যেনসম অকস্মাৎ ছিন্ন করি ঊর্ধ্বে লয়ে যাও\nপঙ্ককুণ্ড হতে,\nমহান মৃত্যুর সাথে মুখামুখি করে দাও মোরে\nবজ্রের আলোতে।");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "তার পরে ফেলে দাও, চূর্ণ করো, যাহা ইচ্ছা তব--\nভগ্ন করো পাখা।\nযেখানে নিক্ষেপ কর হৃত পত্র, চ্যুত পুষ্পদল,\nছিন্নভিন্ন শাখা,\nক্ষণিক খেলনা তব, দয়াহীন তব দস্যুতার\nলুণ্ঠনাবশেষ,\nসেথা মোরে ফেলে দিয়ো অনন্ততমিস্র সেই\nবিস্মৃতির দেশ।");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "নবাঙ্কুর ইক্ষুবনে এখনো ঝরিছে বৃষ্টিধারা\nবিশ্রামবিহীন,\nমেঘের অন্তর-পথে অন্ধকার হতে অন্ধকারে\nচলে গেল দিন।\nশান্ত ঝড়ে, ঝিল্লিরবে, ধরণীর স্নিগ্ধ গন্ধোচ্ছ্বাসে,\nমুক্ত বাতায়নে\nবৎসরের শেষ গান সাঙ্গ করি দিনু অঞ্জলিয়া\nনিশীথগগনে।");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "অধিকার ছাড়িয়া দিয়া অধিকার রাখিতে যাইবার মত এমন বিড়ম্বনা আর না");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "অলৌকিক আনন্দের ভার, বিধাতা যাহারে দেন, তার বক্ষে বেদনা অপার");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "ওগো অকরুণ, কী মায়া জানো, মিলনছলে বিরহ আনো");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "পাওয়া কাকে বলে যে মানুষ জানে না সে ছোঁয়াকেই পাওয়া মনে করে");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "ভারতের কোনও বৃদ্ধ ঋষির তরুণ মূর্তি তুমি হে আর্য আচার্য জগদীশ");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "আহা আজি এ বসন্তে\nএত ফুল ফোটে, এত বাঁশি বাজে\nএত পাখি গায় আহা আজি এ বসন্তে।।");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "সুখে আছে যারা সুখে থাক তারা\nসুখের বসন্ত সুখে হোক সারা..");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "বিয়ে করলে মানুষকে মেনে নিতে হয়, তখন আর গড়ে নেবার ফাঁক পাওয়া যায় না।");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "মানুষের একটা বয়স আছে যখন সে চিন্তা না করিয়াও বিবাহ করিতে পারে। সে বয়স পেরোলে বিবাহ করিতে দুঃসাহসিকতার দরকার হয়");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "আগুনকে যে ভয় পায়, সে আগুনকে ব্যবহার করতে পারে না");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "প্রেমের মধ্যে ভয় না থাকলে রস নিবিড় হয় না");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "সাহেব সাজা বাঙালিদের প্রতি পদে ভয়, পাছে তারা বাঙালি বলে ধরা পড়েন");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "শিমুল কাঠই হোক আর বকুল কাঠই হোক, আগুনের চেহারাটা একই");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "অক্ষমের লোভ আলাদিনের প্রদিপের গুজব শুনলেই লাফিয়া অঠে");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "অপর ব্যাক্তির কোলে পিঠে চড়িয়া অগ্রসর হওয়ার কোন মাহাত্ম্য নাই - কারণ চলিবার শক্তিলাভই যথার্থ লাভ, অগ্রসর হওয়া মাত্র লাভ নহে");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "নিজের অজ্ঞতা সম্বন্ধে অজ্ঞানতার মতো অজ্ঞান আর তো কিছু নাই");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "নদীর এপার কহে ছাড়িয়া নিশ্বাস, ওপারেতে সর্বসুখ আমার বিশ্বাস। নদীর ওপার বসি দীর্ঘশ্বাস ছাড়ে; কহে, যাহা কিছু সুখ সকলি ওপারে।");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "আমি বিন্দুমাত্র আলো, মনে হয় তবু\nআমি শুধু আছি আর কিছু নাই কভু।\nপলক পড়িলে দেখি আড়ালে আমার\nতুমি আছ হে অনাদি আদি অন্ধকার!");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "অনুগ্রহ দুঃখ করে, দিই, নাহি পাই।\nকরুণা কহেন, আমি দিই, নাহি চাই। ");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "শর ভাবে, ছুটে চলি, আমি তো স্বাধীন,\nধনুকটা একঠাঁই বদ্ধ চিরদিন।\nধনু হেসে বলে, শর, জান না সে কথা-\nআমারি অধীন জেনো তব স্বাধীনতা।");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "অসীম সে চাহে সীমার নিবিড় সঙ্গ\nসীমা হতে চায় অসীমের মাঝে হারা");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "ক্ষমাই যদি করতে না পারো, তবে তাকে ভালোবাসো কেন?");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "আনন্দকে ভাগ করলে দুটি জিনিস পাওয়া যায়; একটি হচ্ছে জ্ঞান এবং অপরটি হচ্ছে প্রেম");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "স্বামীরা প্রেমিক হতে অবশ্যই রাজি, তবে সেটা নিজের স্ত্রীর সাথে নয়। নিজের স্ত্রীর প্রেমিক হবার বিষয়টা কেন যেন তারা ভাবতেই চায় না");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "মন দিয়ে মন বোঝা যায়, গভীর বিশ্বাস শুধু নীরব প্রাণের কথা টেনে নিয়ে আসে।");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "আমার তৃষ্ণা তোমার সুধা তোমার তৃপ্তি আমার সুধা");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "পাপকে ঠেকাবার জন্য কিছু না করাই তো পাপ।");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "যে ধর্মের নামে বিদ্বেষ সঞ্চিত করে, ঈশ্বরের অর্ঘ্য হতে সে হয় বঞ্চিত।");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "ধর্ম যারা সম্পূর্ণ উপলব্ধি না করিয়া প্রচার করিতে চেষ্টা করে তহারা ক্রমশই ধর্মকে জীবন হইতে দূরে ঠেলিয়া থাকে। ইহারা ধর্মকে বিশেষ গন্ডি আঁকিয়া একটা বিশেষ সীমানার মধ্যে আবদ্ধ করে।");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "ভয়ের তাড়া খেলেই ধর্মের মূঢ়তার পিছনে মানুষ লুকাতে চেষ্টা করে");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "পৃথিবীতে বালিকার প্রথম প্রেমেরমত সর্বগ্রাসী প্রেম আর কিছুই নাই। প্রথমযৌবনে বালিকা যাকে ভালোবাসে তাহার মত সৌভাগ্যবানও আর কেহই নাই। যদিও সে প্রেম অধিকাংশ সময় অপ্রকাশিত থেকে যায়, কিন্তু সে প্রেমের আগুন সব বালিকাকে সারাজীবন পোড়ায়।");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "ছোট ছোট মুখ জানে না ধরার দুখ, হেসে আসে তোমাদের দ্বারে। নবীণ নয়ন তুলি কৌতুকেতে দুলি দুলি চেয়ে চেয়ে দেখে চারিধারে।");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "একটা মন আর একটা মনকে খুজিতেছে নিজের ভাবনার ভার নামাইয়া দিবার জন্য, নিজের মনের ভাবকে অণ্যের মনে ভাবিত করিবার জন্য।");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "চোখ কতটুকুই দেখে কান কতটুকুই শোনো স্পর্শ কতটুকুই বোধ করে। কিন্তু মন এই আপন ক্ষুদ্রতাকে কেবলই ছড়িয়ে যাচ্ছে।");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "যৌবনের শেষে শুভ্র শৎরকালের ন্যায় একটি গভীর প্রশান্ত প্রগাঢ় সুন্দর বয়স আসে যখন জীবনের শেষে ফল ফলিবার এবং শস্য পাকিবার সময়");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "দীর্ঘ আয়ু দীর্ঘ অভিশাপ বিচ্ছেদের তাপ নাশে সেই বড়ো তাপ");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "সময়ের সমুদ্রে আছি কিন্তু এক মুহুর্তে সময় নেই");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "যৌবনই ভোগের কাল বার্ধক্য স্মৃতিচারণের");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "আমরা কথার অধীন, প্রধার অধীন অসংখ্য প্রবৃত্তির অধীন");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "প্রেমের আনন্দ থাকে স্বল্পক্ষণ কিন্তু বেদনা থাকে সারাটি জীবন");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "ফাগুন, হাওয়ায় হাওয়ায় করেছি যে দানঃ\nতোমার হাওয়ায় হাওয়ায় করেছি যে দানঃ\nআমার আপনহারা প্রাণ; আমার বাঁধন ছেঁড়া প্রাণ");
        this.map_list.add(this.map_var);
    }

    private void _Bani_List_2() {
        this.map_var = new HashMap<>();
        this.map_var.put("content", "ফাগুনের নবীন আনন্দে গানখানি গাঁথিলাম ছন্দে; দিল তারে বনবীথি কোকিলের কলগীতি, ভরি দিল বকুলের গন্ধে");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "কখনো বা চাঁদের আলোতে\nকখনো বসন্তসমীরণে\nসেই ত্রিভুবনজয়ী, অপাররহস্যময়ী\nআনন্দ-মুরতিখানি জেগে ওঠে মনে");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "ভালোবাসা কথাটা বিবাহ কথার\nচেয়ে আরো বেশি জ্যান্ত");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "আছে দুঃখ, আছে মৃত্যু, বিরহদহন লাগে।\nতবুও শান্তি, তবু আনন্দ, তবু অনন্ত জাগে।\nতবু প্রাণ নিত্যধারা, হাসে সূর্য চন্দ্র তারা,\nবসন্ত নিকুঞ্জে আসে বিচিত্র রাগে।");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "আমার মৃত্যুকালে তোমাকে যে- কথাটা বলিব মনে করিয়াছিলাম, আজ তাহা বলিতে ইচ্ছা করিতেছে। আজ মনে হইতেছে, তুমি আমাকে যত শাস্তি দাও- না কেন আমি বহন করিতে পারিব।");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "ক্ষুদ্রকে লইয়াই বৃহৎ, সীমাকে লইয়াই অসীম, প্রেমকে লইয়াই মুক্তি। প্রেমের আলো যখনই পাই তখনই যেখানে চোখ মেলি সেখানেই দেখি, সীমার মধ্যে সীমা নাই।");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "পুরুষের বুদ্ধি খড়গের মতো; শান বেশি না দিলেও কেবল ভারেই অনেক কাজ করতে পারে। মেয়েদের বুদ্ধি কলম-কাটা ছুরির মতো; যতই ধার দাওনা কেনো, তাতে বৃহৎ কাজ চলে না।");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "এসো, এসো, এসো হে বৈশাখ\nতাপসনিশ্বাসবায়ে মুমূর্ষুরে দাও উড়ায়ে,\nবৎসরের আবর্জনা দূর হয়ে যাক\nযাক পুরাতন স্মৃতি, যাক ভুলে যাওয়া গীতি,\nঅশ্রুবাষ্প সুদূরে মিলাক।\nমুছে যাক গ্লানি, ঘুচে যাক জরা,\nঅগ্নিস্নানে শুচি হোক ধরা।");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "হে ভৈরব, হে রুদ্র বৈশাখ!\nধুলায় ধূসর রুক্ষ উড্ডীন পিঙ্গল জটাজাল,\nতপঃক্লিষ্ট তপ্ত তনু, মুখে তুলি বিষাণ ভয়াল\nকারে দাও ডাক\nহে ভৈরব, হে রুদ্র বৈশাখ!");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "যদি তোর ডাক শুনে কেউ না আসে তবে একলা চলো রে");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "এরা সুখের লাগি চাহে প্রেম, প্রেম মেলে না, শুধু সুখ চলে যায়");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "সমাজ সংসার মিছে সব,\nমিছে এ জীবনের কলরব।\nকেবলই আঁখি দিয়ে আঁখির সুধা পিয়ে\nহৃদয় দিয়ে হৃদি অনুভব –\nআঁধারে মিশে গেছে আর সব।।");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "নিন্দা করতে গেলে বাইরে থেকে করা যায়, কিন্তু বিচার করতে গেলে ভিতরে প্রবেশ করতে হয়");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "সাত কোটি বাঙালিরে হে মুগ্ধ জননী রেখেছ বাঙালি করে মানুষ করনি");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "মনুষ্যত্বের শিক্ষাটাই চরম শিক্ষা আর সমস্তই তার অধীন");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "'কত বড়ো আমি’ কহে নকল হীরাটি। তাই তো সন্দেহ করি নহ ঠিক খাঁটি।");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "পৃথিবীর সবচেয়ে বড় দূরত্ব কোনটি জানো? নাহ, জীবন থেকে মৃত্যু পর্যন্ত, উত্তরটা সঠিক নয়। সবচেয়ে বড় দূরত্ব হলো যখন আমি তোমার সামনে থাকি, কিন্তু তুমি জানো না যে আমি তোমাকে কতটা ভালোবাসি।");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "আমি তোমাকে অসংখ্য ভাবে ভালবেসেছি, অসংখ্যবার ভালবেসেছি, এক জীবনের পর অন্য জীবনেও ভালবেসেছি, বছরের পর বছর, সর্বদা, সবসময়।");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "গোলাপ যেমন একটি বিশেষ জাতের ফুল, বন্ধু তেমনি একটি বিশেষ জাতের মানুষ");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "কেউ বা মরে কথা বলে, আবার কেউ বা মরে কথা না বলে");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "অন্যায় যে করে আর অন্যায় যে সহে তবে ঘৃণা তারে যেস তৃণসম দহে");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "যে খ্যাতির সম্বল অল্প তার সমারোহ যতই বেশি হয়, ততই তার দেউলে হওয়া দ্রুত ঘটে");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "কী পাইনি তারই হিসাব মেলাতে মন মোর নহে রাজি");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "সংসারে সাধু-অসাধুর মধ্যে প্রভেদ এই যে, সাধুরা কপট আর অসাধুরা অকপট");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "নারী দাসী বটে, কিন্তু সেই সঙ্গে নারী রাণীও বটে");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "হঠাৎ একদিন পূর্ণিমার রাত্রে জীবনে যখন জোয়ার আসে, তখন যে একটা বৃহৎ প্রতিজ্ঞা করিয়া বসে জীবনের সুদীর্ঘ ভাটার সময় সে প্রতিজ্ঞা রক্ষা করিতে তাহার সমস্ত প্রাণে টান পড়ে");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "মনে যখন একটা প্রবল আনন্দ একটা বৃহৎ প্রেমের সঞ্চার হয় তখন মানুষ মনে করে, ‘আমি সব পারি’। তখন হঠাৎ আত্মবিসর্জনের ইচ্ছা বলবতী হইয়া ওঠে।");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "সংসারের কোন কাজেই যে হতভাগ্যের বুদ্ধি খেলে না, সে নিশ্চয়ই ভাল বই লিখিবে");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "যে ছেলে চাবামাত্রই পায়, চাবার পূর্বেই যার অভাব মোচন হতে থাকে; সে নিতান্ত দুর্ভাগা। ইচ্ছা দমন করতে না শিখে কেউ কোনকালে সুখী হতে পারেনা।");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "সামনে একটা পাথর পড়লে যে লোক ঘুরে না গিয়ে সেটা ডিঙ্গিয়ে পথ সংক্ষেপ করতে চায় - বিলম্ব তারই অদৃষ্টে আছে");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "বিয়ে করলে মানুষকে মেনে নিতে হয়, তখন আর গড়ে নেবার ফাঁক পাওয়া যায় না");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "লোকে ভুলে যায় দাম্পত্যটা একটা আর্ট, প্রতিদিন ওকে নতুন করে সৃষ্টি করা চাই");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "সোহাগের সঙ্গে রাগ না মিশিলে ভালবাসার স্বাদ থাকেনা - তরকারীতে লঙ্কামরিচের মত");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "সাধারণত স্ত্রীজাতি কাঁচা আম, ঝাল লঙ্কা এবং কড়া স্বামীই ভালোবাসে। যে দুর্ভাগ্য পুরুষ নিজের স্ত্রীর ভালোবাসা হইতে বঞ্চিত সে - যে কুশ্রী অথবা নির্ধন তাহা নহে; সে নিতান্ত নিরীহ।");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "বৃষ্টি পড়ে টাপুর টুপুর,\nনদেয় এল বান");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "তুমি যদি না দেখা দাও, কর আমায় হেলা,\nকেমন করে কাটে আমার এমন বাদল-বেলা।");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "যে পুরুষ অসংশয়ে অকুন্ঠিতভাবে নিজেকে প্রচার করিতে পারে সেই সমর্থ পুরুষ সহজেই নারীর দৃষ্টি আর্কষণ করিতে পারে।");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "যায় যদি লুপ্ত হয়ে থাকে শুধু থাক এক বিন্দু নয়নের জল কালের কপোল তলে শুভ্র সমুজ্জ্বল এ তাজমহল");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "মেয়েটির বিবাহের বয়স পার হইয়া গেছে , কিন্তু আর কিছুদিন গেলে সেটাকে ভদ্র বা অভদ্র কোনো রকমে চাপা দিবার সময়টাও পার হইয়া যাইবে । মেয়ের বয়স অবৈধ রকমে বাড়িয়া গেছে বটে , কিন্তু পণের টাকার আপেক্ষিক গুরুত্ব এখনো তাহার চেয়ে কিঞ্চিৎ উপরে আছে , সেইজন্যই তাড়া");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "নরমাংসের স্বাদ পাইলে মানুষের সম্বন্ধে বাঘের যে দশা হয়, স্ত্রীর সম্বন্ধে তাহার ভাবটা সেইরূপ হইয়া উঠে");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "আমি পাইলাম , আমি ইহাকে পাইলাম");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "মানুষ পণ করে পণ ভাঙিয়া ফেলিয়া হাঁফ ছাড়িবার জন্য");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "সে আমার সম্পত্তি নয়, সে আমার সম্পদ");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "তোমার পতাকা যারে দাও তারে বহিবারে দাও শকতি");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "আমরা বন্ধুর কাছ থেকে মমতা চাই, সমবেদনা চাই, সাহায্য চাই ও সেই জন্যই বন্ধুকে চাই");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "রুদ্র, তোমার দারুণ দীপ্তি\nএসেছে দুয়ার ভেদিয়া;\nবক্ষে বেজেছে বিদ্যুৎবাণ\nস্বপ্নের জাল ছেদিয়া");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "ভাবিতেছিলাম উঠি কি না উঠি,\nঅন্ধ তামস গেছে কিনা ছুটি,\nরুদ্ধ নয়ন মেলি কি না মেলি\nতন্দ্রা-জড়িমা মাজিয়া।\nএমন সময়ে, ঈশান, তোমার\nবিষাণ উঠেছে বাজিয়া।");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "ভৈরব, তুমি কী বেশে এসেছ,\nললাটে ফুঁসিছে নাগিনী,\nরুদ্র-বীণায় এই কি বাজিল\nসুপ্রভাতের রাগিণী?");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "ফাল্গুনে বিকশিত\nকাঞ্চন ফুল ,\nডালে ডালে পুঞ্জিত\nআম্রমুকুল ।\nচঞ্চল মৌমাছি\nগুঞ্জরি গায় ,\nবেণুবনে মর্মরে\nদক্ষিণবায়");
        this.map_list.add(this.map_var);
    }

    private void _Bani_List_3() {
        this.map_var = new HashMap<>();
        this.map_var.put("content", "স্পন্দিত নদীজল\nঝিলিমিলি করে ,\nজ্যোৎস্নার ঝিকিমিকি\nবালুকার চরে ।\nনৌকা ডাঙায় বাঁধা ,\nকাণ্ডারী জাগে ,\nপূর্ণিমারাত্রির\nমত্ততা লাগে");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "স্পন্দিত নদীজল\nঝিলিমিলি করে ,\nজ্যোৎস্নার ঝিকিমিকি\nবালুকার চরে ।\nনৌকা ডাঙায় বাঁধা ,\nকাণ্ডারী জাগে ,\nপূর্ণিমারাত্রির\nমত্ততা লাগে");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "দূরে কোন্\u200c শয্যায়\nএকা কোন্\u200c ছেলে\nবংশীর ধ্বনি শুনে");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "রাত কাটে, ভোর হয়,\nপাখি জাগে বনে —\nচাঁদের তরণী ঠেকে\nধরণীর কোণে");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "হেরো পুরানো প্রাচীন ধরণী হয়েছে শ্যামল-বরনী,\nযেন যৌবন-প্রবাহ ছুটিছে কালের শাসন টুটাতে;\nপুরানো বিরহ হানিছে, নবীন মিলন আনিছে,\nনবীন বসন্ত আইল নবীন জীবন ফুটাতে");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "মধুর বসন্ত এসেছে মধুর মিলন ঘটাতে।\nমধুর মলয়-সমীরে মধুর মিলন রটাতে।\nকুহক লেখনী ছুটায়ে কুসুম তুলিছে ফুটায়ে,\nলিখিছে প্রণয়-কাহিনী বিবিধ বরন-ছটাতে");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "প্রহর শেষের আলোয় রাঙা সেদিন চৈত্রমাস\nতোমার চোখে দেখেছিলাম আমার সর্বনাশ।");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "আনন্দে আতঙ্কে নিশি নন্দনে উল্লাসে গরজিয়া\nমত্ত হাহা রবে\nঝার সঞ্জীব বাধ উন্মাদিনী কালবৈশাখীর\nনৃত্য হোক তবে ।");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "উপার্জনে আমাদের সুযোগ কম বলেই আসক্তি সঞ্ছয়ে ভিতু আমরা");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "সঞ্চয়ের বড়ো দুর্জয় নেশা ...আমাদের দেশে ইহাকেই বলে নিরানব্বইয়ের ধাক্কা");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "তর্কের বেলায় গৃহিণীর যুক্তিকে অকাট্য বলে কাজের বেলায় নিজের যুক্তিতে চলাই সৎ পরামর্শ");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "সংসারে সেরা লোকেরাই কুড়ে এবং বেকার লোকেরাই ধন্য। উভয়রে সম্মিলন হলেই মণি কাঞ্চন যোগ। এই কুঁড়ে বেকারে মিলনের জন্যইতো সন্ধ্যেবেলাটার সৃষ্টি হয়েছে।যোগীদরে জন্য সকালবেলা রোগীেদের জন্য রাত্রি কাজের লোকদের জন্য দশটা-চারটে");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "সময়ের সমুদ্রে আছি,কিন্তু একমুহূর্ত সময় নেই");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "তোমার অশোকে কিংশুকে,\nঅলক্ষ্য রঙ লাগল আমার অকারণের সুখে");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "আমি তোমারি বিরহে রহিব বিলীন, তোমাতে করিব বাস–\nদীর্ঘ দিবস, দীর্ঘ রজনী, দীর্ঘ বরষ-মাস ।\nযদি আর-কারে ভালোবাস, যদি আর ফিরে নাহি আস,\nতবে তুমি যাহা চাও তাই যেন পাও, আমি যত দুখ পাই গো");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "তোমার প্রজাপতির পাখা\nআমার আকাশ-চাওয়া মুগ্ধ চোখের\nরঙিন স্বপন মাখা ।\nতোমার চাঁদের আলোয়\nমিলায় আমার দুঃখ-সুখের সকল অবসান");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "রসের আবেশরাশি শুষ্ক করি দাও আসি,\nআনো আনো আনো তব প্রলয়ের শাঁখ।\nমায়ার কুজ্ঝটিজাল যাক দূরে যাক॥");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "অতিদূর পরপারে গাঢ় নীল রেখার মতো বিদেশের আভাস দেখা যায়-- সেখান হইতে রাগ-দ্বেষের দ্বন্দ্বকোলাহল সমুদ্র পার হইয়া আসিতে পারে না");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "বৈশাখ হে, মৌনী তাপস, কোন্\u200c অতলের বাণী\nএমন কোথায় খুঁজে পেলে।\nতপ্ত ভালের দীপ্তি ঢাকি মন্থর মেঘখানি\nএল গভীর ছায়া ফেলে॥");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "রুদ্রতপের সিদ্ধি এ কি ওই-যে তোমার বক্ষে দেখি,\nওরই লাগি আসন পাতো হোমহুতাশন জ্বেলে॥\nনিঠুর, তুমি তাকিয়েছিলে মৃত্যুক্ষুধার মতো\nতোমার রক্তনয়ন মেলে।");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "ভীষণ, তোমার প্রলয়সাধন প্রাণের বাঁধন যত\nযেন হানবে অবহেলে।\nহঠাৎ তোমার কণ্ঠে এ যে আশার ভাষা উঠল বেজে,\nদিলে তরুণ শ্যামল রূপে করুণ সুধা ঢেলে॥");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "ঈশানের পুঞ্জমেঘ অন্ধবেগে ধেয়ে চলে আসে\nবাধাবন্ধহারা\nগ্রামান্তরে বেণুকুঞ্জে নীলাঞ্জনছায়া সঞ্চারিয়া\nহানি দীর্ঘধারা।\nবর্ষ হয়ে আসে শেষ, দিন হয়ে এল সমাপন,\nচৈত্র অবসান--\nগাহিতে চাহিছে হিয়া পুরাতন ক্লান্ত বরষের\nসর্বশেষ গান।");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "ধূসরপাংশুল মাঠ, ধেনুগণ যায় ঊর্ধ্বমুখে,\nছুটে চলে চাষি।\nত্বরিতে নামায় পাল নদীপথে ত্রস্ত তরী যত\nতীরপ্রান্তে আসি।\nপশ্চিমে বিচ্ছিন্ন মেঘে সায়াহ্নের পিঙ্গল আভাস\nরাঙাইছে আঁখি--\nবিদ্যুৎ-বিদীর্ণ শূন্যে ঝাঁকে ঝাঁকে উড়ে চলে যায়\nউৎকণ্ঠিত পাখি।");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "বীণাতন্ত্রে হানো হানো খরতর ঝংকারঝঞ্ঝনা,\nতোলো উচ্চসুর।\nহৃদয় নির্দয়ঘাতে ঝর্ঝরিয়া ঝরিয়া পড়ুক\nপ্রবল প্রচুর।\nধাও গান, প্রাণভরা ঝড়ের মতন ঊর্ধ্ববেগে\nঅনন্ত আকাশে।\nউড়ে যাক, দূরে যাক বিবর্ণ বিশীর্ণ জীর্ণ পাতা\nবিপুল নিশ্বাসে।");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "মুক্ত করি দিনু দ্বার-- আকাশের যত বৃষ্টিঝড়\nআয় মোর বুকে,\nশঙ্খের মতন তুলি একটি ফুৎকার হানি দাও\nহৃদয়ের মুখে।\nবিজয়গর্জনস্বনে অভ্রভেদ করিয়া উঠুক\nমঙ্গলনির্ঘোষ,\nজাগায়ে জাগ্রত চিত্তে মুনিসম উলঙ্গ নির্মল\nকঠিন সন্তোষ।");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "সে পূর্ণ উদাত্ত ধ্বনি বেদগাথা সামমন্ত্রসম\nসরল গম্ভীর\nসমস্ত অন্তর হতে মুহূর্তে অখণ্ডমূর্তি ধরি\nহউক বাহির।\nনাহি তাহে দুঃখসুখ পুরাতন তাপ-পরিতাপ,\nকম্প লজ্জা ভয়--\nশুধু তাহা সদ্যঃস্নাত ঋজু শুভ্র মুক্ত জীবনের\nজয়ধ্বনিময়।");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "হে নূতন, এসো তুমি সম্পূর্ণ গগন পূর্ণ করি\nপুঞ্জ পুঞ্জ রূপে--\nব্যাপ্ত করি, লুপ্ত করি, স্তরে স্তরে স্তবকে স্তবকে\nঘনঘোরস্তূপে।\nকোথা হতে আচম্বিতে মুহূর্তেকে দিক্\u200c দিগন্তর\nকরি অন্তরাল\nস্নিগ্ধ কৃষ্ণ ভয়ংকর তোমার সঘন অন্ধকারে\nরহো ক্ষণকাল।");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "তোমার ইঙ্গিত যেন ঘনগূঢ় ভ্রূকুটির তলে\nবিদ্যুতে প্রকাশে,\nতোমার সংগীত যেন গগনের শত ছিদ্রমুখে\nবায়ুগর্জে আসে,\nতোমার বর্ষণ যেন পিপাসারে তীব্র তীক্ষ্ণ বেগে\nবিদ্ধ করি হানে--\nতোমার প্রশান্তি যেন সুপ্ত শ্যাম ব্যাপ্ত সুগম্ভীর\nস্তব্ধ রাত্রি আনে।");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "এবার আস নি তুমি বসন্তের আবেশ হিল্লোলে\nপুষ্পদল চুমি,\nএবার আস নি তুমি মর্মরিত কূজনে গুঞ্জনে--\nধন্য ধন্য তুমি!\nরথচক্র ঘর্ঘরিয়া এসেছ বিজয়ীরাজ-সম\nগর্বিত নির্ভয়--\nবজ্রমন্ত্রে কী ঘোষিলে বুঝিলাম, নাহি বুঝিলাম,\nজয় তব জয়!");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "তোমারে প্রণমি আমি, হে ভীষণ, সুস্নিগ্ধ শ্যামল,\nঅক্লান্ত অম্লান'।\nসদ্যোজাত মহাবীর, কী এনেছ করিয়া বহন\nকিছু নাহি জান।\nউড়েছে তোমার ধ্বজা মেঘরন্ধ্রচ্যুত তপনের\nজলদর্চিরেখা--\nকরজোড়ে চেয়ে আছি উর্ধ্বমুখে, পড়িতে জানি না\nকী তাহাতে লেখা।");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "হে কুমার, হাস্যমুখে তোমার ধনুকে দাও টান\nঝনন রনন,\nবক্ষের পঞ্জর ভেদি অন্তরেতে হউক কম্পিত\nসুতীব্র স্বনন।\nহে কিশোর, তুলে লও তোমার উদার জয়ভেরী,\nকরহ আহ্বান।\nআমরা দাঁড়াব উঠি, আমরা ছুটিয়া বাহিরিব,\nঅর্পিব পরান।");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "চাব না পশ্চাতে মোরা, মানিব না বন্ধন ক্রন্দন,\nহেরিব না দিক--\nগনিব না দিন ক্ষণ, করিব না বিতর্ক বিচার\nউদ্দাম পথিক।\nমুহূর্তে করিব পান মৃত্যুর ফেনিল উন্মত্ততা\nউপকণ্ঠ ভরি--\nখিন্ন শীর্ণ জীবনের শত লক্ষ ধিক্কারলাঞ্ছনা\nউৎসর্জন করি।");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "শুধু দিনযাপনের শুধু প্রাণধারণের গ্লানি\nশরমের ডালি,\nনিশি নিশি রুদ্ধ ঘরে ক্ষুদ্রশিখা স্তিমিত দীপের\nধূমাঙ্কিত কালি,\nলাভ-ক্ষতি-টানাটানি, অতি ক্ষুদ্র ভগ্ন-অংশ-ভাগ,\nকলহ সংশয়--\nসহে না সহে না আর জীবনেরে খণ্ড খণ্ড করি\nদণ্ডে দণ্ডে ক্ষয়।");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "যে পথে অনন্ত লোক চলিয়াছে ভীষণ নীরবে\nসে পথপ্রান্তের\nএক পার্শ্বে রাখো মোরে, নিরখির বিরাট স্বরূপ\nযুগযুগান্তের।\nশ্যেনসম অকস্মাৎ ছিন্ন করি ঊর্ধ্বে লয়ে যাও\nপঙ্ককুণ্ড হতে,\nমহান মৃত্যুর সাথে মুখামুখি করে দাও মোরে\nবজ্রের আলোতে।");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "তার পরে ফেলে দাও, চূর্ণ করো, যাহা ইচ্ছা তব--\nভগ্ন করো পাখা।\nযেখানে নিক্ষেপ কর হৃত পত্র, চ্যুত পুষ্পদল,\nছিন্নভিন্ন শাখা,\nক্ষণিক খেলনা তব, দয়াহীন তব দস্যুতার\nলুণ্ঠনাবশেষ,\nসেথা মোরে ফেলে দিয়ো অনন্ততমিস্র সেই\nবিস্মৃতির দেশ।");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "নবাঙ্কুর ইক্ষুবনে এখনো ঝরিছে বৃষ্টিধারা\nবিশ্রামবিহীন,\nমেঘের অন্তর-পথে অন্ধকার হতে অন্ধকারে\nচলে গেল দিন।\nশান্ত ঝড়ে, ঝিল্লিরবে, ধরণীর স্নিগ্ধ গন্ধোচ্ছ্বাসে,\nমুক্ত বাতায়নে\nবৎসরের শেষ গান সাঙ্গ করি দিনু অঞ্জলিয়া\nনিশীথগগনে।");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "অধিকার ছাড়িয়া দিয়া অধিকার রাখিতে যাইবার মত এমন বিড়ম্বনা আর না");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "অলৌকিক আনন্দের ভার, বিধাতা যাহারে দেন, তার বক্ষে বেদনা অপার");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "ওগো অকরুণ, কী মায়া জানো, মিলনছলে বিরহ আনো");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("content", "পাওয়া কাকে বলে যে মানুষ জানে না সে ছোঁয়াকেই পাওয়া মনে করে");
        this.map_list.add(this.map_var);
    }

    private void _Extra() {
        if (getIntent().getStringExtra("Type").equals("Bani")) {
            this.linear2.setVisibility(8);
            this.listview1.setVisibility(0);
            this.listview2.setVisibility(8);
            _Bani_List_1();
            _Bani_List_3();
            _Bani_List_2();
            this.listview1.setAdapter((ListAdapter) new Listview1Adapter(this.map_list));
            ((BaseAdapter) this.listview1.getAdapter()).notifyDataSetChanged();
        } else if (getIntent().getStringExtra("Type").equals("Pdf")) {
            this.linear2.setVisibility(0);
            this.textview1.setText("পিডিএফ কালেকশন");
            this.textview2.setText("অনলাইনে বই পড়তে ডাটা কানেকশনের প্রয়োজন হবে");
            this.listview1.setVisibility(8);
            this.listview2.setVisibility(0);
            _PDF();
            this.listview2.setAdapter((ListAdapter) new Listview2Adapter(this.map_list));
            ((BaseAdapter) this.listview2.getAdapter()).notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _radius(View view, String str, double d) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor(str));
        gradientDrawable.setCornerRadius((int) d);
        view.setBackground(gradientDrawable);
    }

    private void _Corner_Radius(View view, String str, double d, double d2, double d3, double d4) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor(str));
        gradientDrawable.setCornerRadii(new float[]{(int) d, (int) d, (int) d2, (int) d2, (int) d3, (int) d3, (int) d4, (int) d4});
        view.setBackground(gradientDrawable);
    }

    private void _PDF() {
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "GITANJALI  SONG OFFERINGS - 1912");
        this.map_var.put("content", "12cIeOb3dKdUBibvdXZUF2rxxLTo6vJGa");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "২");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "অতিথি");
        this.map_var.put("content", "1L2SCYeKEBCYrVSXvmODtFZLgdVON7BOT");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৩");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "অধ্যাপক");
        this.map_var.put("content", "1tBJ9mRwmgJH9cuQuEo_SuSRGLg-Zx3eF");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৪");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "অনধিকার প্রবেশ");
        this.map_var.put("content", "1EMnuTMyhGszR2lRqOIyxW37UE-uOjAGp");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৫");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "অপরিচিতা");
        this.map_var.put("content", "1vO5SK5zyWruS3QEFYLPF-6rsqQOtMibH");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৬");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "অসম্ভব কথা");
        this.map_var.put("content", "1tCnG7ojCSv9xRRi0E2pwY_oyg68KVKvY");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৭");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "আত্মপরিচয়");
        this.map_var.put("content", "15uTv07Kc2wRLIjCpkqRwuyAmU02_GT2A");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৮");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "আধুনিক কাব্য");
        this.map_var.put("content", "1j0jullrvDq_mtRFIAVQSzy5vQGuMB6_x");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৯");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "ইউরোপ প্রবাসীর পত্র - রবীন্দ্রনাথ ঠাকুর");
        this.map_var.put("content", "1z6ljHYSHtlqzRLvh3iF_mCLAxM1r8ETn");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১০");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "ইচ্ছাপূরণ");
        this.map_var.put("content", "1dGElbIqy9BYIsf_HWbJ8abOQ5daEH7Oq");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১১");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "ইস্পীরিয়লিজম");
        this.map_var.put("content", "1Ao7weX4_8jUL8js8hu2h2WdkZEGE-bNI");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১২");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "উদ্ধার");
        this.map_var.put("content", "1jnEpmLuqSoD6eDVmxRFLSeqKvEOC_W58");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১৩");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "উলুখড়ের বিপদ");
        this.map_var.put("content", "18yiutdTQsOPvuiya8_w3lQVZdxeuppsL");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১৪");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "ঋণশোধ");
        this.map_var.put("content", "1H3aEkW_dcWK0QwQNulWP_s_TLPuv5xBK");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১৫");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "একটা আষাঢ়ে গল্প");
        this.map_var.put("content", "1sMWWNgx_NeQeqozx1CFs-SsABp-UB168");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১৬");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "কঙ্কাল");
        this.map_var.put("content", "1KS95U-TkmYoaqpcE4LAvKtEORc3VMZb-");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১৭");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "কবিদাদুর গল্প - যামিনীকান্ত সোম");
        this.map_var.put("content", "16MzqvWclOcWHxysE7VkP99VP8Gbmi8LO");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১৮");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "কবির ভণিতা - রবীন্দ্রনাথ ঠাকুর");
        this.map_var.put("content", "1uYYEsAO3WJNdD75tn6vVEmScA_OH_74S");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১৯");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "করুণা");
        this.map_var.put("content", "12qKfcwNH345dI52aDKkMD-gu-Yff2eey");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "২০");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "কর্মফল");
        this.map_var.put("content", "10AeU-_HLX5TysW8qITtkdBMGccv4m-O1");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "২১");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "কাবুলিওয়ালা");
        this.map_var.put("content", "1rdQLxOHaWv2a-oCcCIdGhZ-7MFb-Dwcp");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "২২");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "কাব্য গ্রন্থ ১");
        this.map_var.put("content", "17OxWG5kM5sUG4GgyNZ8Ocv_-yuFQb6Cx");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "২৩");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "কাব্য গ্রন্থ ২");
        this.map_var.put("content", "1DLRYc-ce-PzvdTeISncKi_OYyfniUnVM");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "২৪");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "কাব্য গ্রন্থ ৩");
        this.map_var.put("content", "1C0-VTpULPASJacCcjAuS3uYRRTL2kcYH");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "২৫");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "কাব্য গ্রন্থ ৪");
        this.map_var.put("content", "11Uy4PpDD6_L7F5QSXQKmIJANMsDKMlxW");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "২৬");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "কাব্য গ্রন্থ ৫");
        this.map_var.put("content", "16xfKDaB-MuUgr9v-G5k1KjvO2cvLoRE-");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "২৭");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "কাব্য গ্রন্থ ৬");
        this.map_var.put("content", "13zjBkOBlUDqtKR7YwzeJstqMFIF-S0Lg");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "২৮");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "কাব্য গ্রন্থ ৭");
        this.map_var.put("content", "1BmLBqkspcqzhOMcKMc7Ob_WcXPvvbngk");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "২৯");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "কাব্য গ্রন্থ ৮");
        this.map_var.put("content", "1T4Ah54g27TFQdY0ZM_dsD5Ydm6_Llgb5");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৩০");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "কাব্য গ্রন্থ ৯");
        this.map_var.put("content", "1pyl0igtWHqu6Tw6HosV6PgRVVITqcjCX");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৩১");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "কাব্য গ্রন্থ ১০");
        this.map_var.put("content", "1udig3RfkLjN6d79Gv8c4j_5CnvB_Joib");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৩২");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "ক্ষুধিত পাষাণ");
        this.map_var.put("content", "1iXjQpVw1mWC2lBCWSbzGsRs0wo_wHA3H");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৩৩");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "খোকাবাবুর প্রত্যাবর্তন");
        this.map_var.put("content", "1AAOYztW4Ltrm-hnJzH5z53gzbGKH3btK");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৩৪");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "গল্প গুচ্ছ");
        this.map_var.put("content", "1fd8a0jIZHIsCqIM2_G0K7-i361ucbc--");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৩৫");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "গল্প সমগ্র");
        this.map_var.put("content", "1Mb6oVYYHMv9uuOQjdFuNqk_Cxn6nQu6m");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৩৬");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "গল্প সল্প");
        this.map_var.put("content", "1vPbSNp1G1IggGZoMi30-mYGJqbKMVhhF");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৩৭");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "গল্পগুচ্ছ");
        this.map_var.put("content", "1CRbG4FLY8D3Q7R1tN_CpVq2mzHven2a2");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৩৮");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "গুপ্ত ধন");
        this.map_var.put("content", "1Ec82tSXh5ZKjj9ikTadjVghh8Kqdsdvr");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৩৯");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "গোরা");
        this.map_var.put("content", "1MwtWi8vaIhtwijrAcU6VNoJQDH56VKzA");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৪০");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "ঘরে বাইরে");
        this.map_var.put("content", "1aUow4GF35UsgE6oIAW2CG-Wsdb_r7ohx");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৪১");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "ঘাটের কথা");
        this.map_var.put("content", "1-C_WM5tpdGK0dwxCAsOn-5ym8Q3_1-QY");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৪২");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "চতুরঙ্গ");
        this.map_var.put("content", "1-kVelPHvR_LNce64xBlKKfNjaYyibSG9");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৪৩");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "চলচ্চিত্রে রবীন্দ্রনাথ ১");
        this.map_var.put("content", "1TKJCrszQmPzH66WRtyxlJpuAqCQYxJ6F");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৪৪");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "চার অধ্যায়");
        this.map_var.put("content", "1qGbFfDyiKstTG-6PRFXgpEB7mnStZ4e2");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৪৫");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "চিটি পত্র ১");
        this.map_var.put("content", "1eEoQ_DVykbpytON4TyW9xrL93dN3amgR");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৪৬");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "চিটি পত্র ৩");
        this.map_var.put("content", "1DVkWhHbAu2YFjDDsgoGJjofVrzX7MEPL");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৪৭");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "চিটি পত্র ৪");
        this.map_var.put("content", "1CbjjG-IjmkLyJEP_cos_-S8EsJwDcC8c");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৪৮");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "চিটি পত্র ৫");
        this.map_var.put("content", "1O19rNzAESPDpQPH1fOvNEFb26chzXUOX");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৪৯");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "চিটি পত্র ৬");
        this.map_var.put("content", "1MlcWyGyn_-X5gTs0YmzUK9LIJBgoJGPT");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৫০");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "চিটি পত্র ৭");
        this.map_var.put("content", "1s6KLtHILA7NrNrOWTmWZO_nF3X-MkCwH");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৫১");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "চিটি পত্র ৮");
        this.map_var.put("content", "11Bh4oADgTSBfH9XqIgPW42D1yu3WbSiJ");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৫২");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "চিটি পত্র ৯");
        this.map_var.put("content", "1FDtpeFsg42PvvSK7HanwKf47Ux-t35zD");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৫৩");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "চিটি পত্র ১০");
        this.map_var.put("content", "14gGWo95NkSKC7QYTqlcbMMW9D8QIIYMg");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৫৪");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "চিটি পত্র ১১");
        this.map_var.put("content", "1HQC6lonWwzTut5y7F-yCeZ5aL1nd3sVz");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৫৫");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "চিটি পত্র ১২");
        this.map_var.put("content", "1x2Wg6cE8iMQVsaGsHwoLp3hD4gc_j44a");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৫৬");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "চিটি পত্র ১৩");
        this.map_var.put("content", "1QsGHgKcmi1zYLIugi5M6OsrkU8tKCqlE");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৫৭");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "চিটি পত্র ১৪");
        this.map_var.put("content", "115CJTww1MfDsSwfa3Cr4-fYr89FB3MRp");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৫৮");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "চিটি পত্র ১৫");
        this.map_var.put("content", "1MmGnM2ClTRJ2lHDt5RTxgb2ntUMWM5kw");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৫৯");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "চিটি পত্র ১৭");
        this.map_var.put("content", "1lmXXC711fFKv3LYjvBsM1YXadiMKu7Wj");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৬০");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "চিটি পত্র ১৮");
        this.map_var.put("content", "1FTOm8mRqCbqGpvtrwmxE5uaJZpWaE36Z");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৬১");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "চিটি পত্র ১৯");
        this.map_var.put("content", "1xoPPPcWcRqKwfe1TLEjDGJaOaUEw6K2N");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৬২");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "চিত্রকর");
        this.map_var.put("content", "1sSqlGiboCGQBKGItq7xOFF19QjViGHE3");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৬৩");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "চোখের বালি");
        this.map_var.put("content", "1iyyS3xCjBz_fOm1D91PZw8xiMR2TFBQM");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৬৪");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "চোরাই ধন");
        this.map_var.put("content", "1zHF3o1VxtXyYDU0RK5BoCPkHtoXmiyvu");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৬৫");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "ছিন্ন পত্রাবলী- রবীন্দ্রনাথ ঠাকুর");
        this.map_var.put("content", "1W9WwLWYvS7cbZjW7MSQvnDxPJOP1Ud4p");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৬৬");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "ছিন্নপত্র- রবীন্দ্রনাথ ঠাকুর");
        this.map_var.put("content", "1jdO3KHVaxzPnwSuXYAofT2n3jkT8__yk");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৬৭");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "ছুটি");
        this.map_var.put("content", "11yqbrVnt63UegNi5uss4yqDAktrM5mB8");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৬৮");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "ছোট ও বড়ো");
        this.map_var.put("content", "1Ay5v1lrWvCEkWRopDLg0oc89RX2Ss02c");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৬৯");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "জয়পরাজয়");
        this.map_var.put("content", "1hvOpu1sw91NGtrgpuu2oicrn53FP3XC2");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৭০");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "জাভা-যাত্রীর পত্র");
        this.map_var.put("content", "1KnLgFDq3rM2V-DYDgghw9fqjskJRUr1u");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৭১");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "জ্যাঠামশায়");
        this.map_var.put("content", "1d2ETr754OGdWGgDnkQeOsWmi9eJaNJzm");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৭২");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "ঠাকুরদা");
        this.map_var.put("content", "1TNMWYKoZEpSCkai_VgP4y8LGkJ_QgfjZ");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৭৩");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "ঠাকুরবাড়ির অন্দরমহল");
        this.map_var.put("content", "1YEUibz9rPMcvG-ZBHDZPOyji7bDlsc37");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৭৪");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "ঠাকুরবাড়ির আঙিনায়");
        this.map_var.put("content", "1yWegwLrK7Kt2cYgGxk03X7uFKYwt1iXV");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৭৫");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "ডাকঘর");
        this.map_var.put("content", "1S8ViBO9cCJucux-v5HnDxSr3JYUD9X0E");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৭৬");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "ডিটেকটিভ");
        this.map_var.put("content", "1LiFyVcyswqPfSpq4Oou2vvB30ZvWzkNI");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৭৭");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "তপসিবনী");
        this.map_var.put("content", "1ASIXTa_54VldqUKOLiusZ48EMTUlGwnK");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৭৮");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "তিন সঙ্গী");
        this.map_var.put("content", "19DDg8JiJ9KrZA-yZsnIARJ7cjted5N_R");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৭৯");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "দর্পহরণ");
        this.map_var.put("content", "1hHIV2B1lAp2tnyC8nMp_c65rn1igg6Yh");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৮০");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "দানপ্রতিদান");
        this.map_var.put("content", "1Czd5GMPUGjFY_8MUDlckbDhQHG-iOQy7");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৮১");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "দালিয়া");
        this.map_var.put("content", "1KGPbuMfmryFiaNQpKecqGB4D70WFxcbz");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৮২");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "দিদি");
        this.map_var.put("content", "1S1ScWoRWvi3GIeDXB7jlU3jgGixRJrl9");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৮৩");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "দীপিকা");
        this.map_var.put("content", "1CB1iASZ1C7VL_X5RY2x9-IlY2D2zVjkd");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৮৪");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "দুর্বুদ্ধি");
        this.map_var.put("content", "1ufh20jDc5OEOdOf58d9CvpRz1eIdWVE6");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৮৫");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "দৃষ্টিদান");
        this.map_var.put("content", "1u36dDR4Oj4X7B5mBWbHqjRIzkGm0ZA6h");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৮৬");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "দেনাপাওনা");
        this.map_var.put("content", "1XL-dlaiGd1Odkwi-Czgdg_kkhebaQvZw");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৮৭");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "নারী");
        this.map_var.put("content", "1zs2w31AS_4ASVEtU6QYYKFul2ylMRTnl");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৮৮");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "নীরব কবি ও অশিক্ষিত কবি");
        this.map_var.put("content", "1iDV4EZXw1tfNecAZ8zc6ZcYlYf_Uuh3a");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৮৯");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "পত্রধারা (১-৩)");
        this.map_var.put("content", "11a4BZ0mimykpJ2BxLhv9osXyZe2e9C0e");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৯০");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "পাত্র ও পাত্রী");
        this.map_var.put("content", "1A3IeFjC4SJ1xlt0cstBqiNIvSNM8XTFF");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৯১");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "পোষ্টমাষ্টার");
        this.map_var.put("content", "1e_A5igSRrlY8zFJVFZq1PxvBK8mLKu9u");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৯২");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "প্রজাপতি নির্বন্ধ");
        this.map_var.put("content", "1sNiwA4SkgNCi_V0NBI7QX0ek334APtcB");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৯৩");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "প্রতিবেশিনী");
        this.map_var.put("content", "166klVQss-vUXBCkFc2BAenD8H-m-auPO");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৯৪");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "বউ-ঠাকুরাণী হাট");
        this.map_var.put("content", "1vj-YDLvOJPqcImiW_L4ZpYHozFCO0t-H");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৯৫");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "বদনাম");
        this.map_var.put("content", "1aHVEE7xD4dTVG25jXenzXUOWgiVMEOdv");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৯৬");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "বসন্ত");
        this.map_var.put("content", "19Bq_MlhVTFnT5evcC6c-z2q6emrvlRab");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৯৭");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "বাউলের গান");
        this.map_var.put("content", "1sfjwqDkIy9_JvLQdvByno7UijdClUJbM");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৯৮");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "বাংলাদেশে রবীন্দ্র-সংবর্ধনা - ভূঁইয়া ইকবাল");
        this.map_var.put("content", "1EslIR9s_RYFtC_sV819airMbpJgyTuJ0");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "৯৯");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "বিচারক");
        this.map_var.put("content", "1syvsCy2F1bkr5zxO3pKFcFfFkA1RFep3");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১০০");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "বোষ্টমী");
        this.map_var.put("content", "17MVeCExov58dJUHwBTfYThF6Lo5NsWxB");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১০১");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "ব্যবধান");
        this.map_var.put("content", "1x-kdsjWqaW1WFuldzix3R4Z-OBGEha2N");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১০২");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "ভানুসিংহের পদাবলী");
        this.map_var.put("content", "1zf4Am2LGta_9gTCQeYVG1FjCPARktNn6");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১০৩");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "ভিখারিনী");
        this.map_var.put("content", "1WKMp75MeWTjTCwPRe6_L_ZNcloV7tt5L");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১০৪");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "মালঞ্চ");
        this.map_var.put("content", "1HW-2juFJ9r_WQCNHiiniZxowRzzx0nS-");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১০৫");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "মাস্টারমশায়");
        this.map_var.put("content", "1tqxEHsqqYLjvJdiCGMve_9X9cb_wO80e");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১০৬");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "ম্যানেজারবাবু");
        this.map_var.put("content", "1BEpyiJFoirtF4DfiWxU7xt0WDnTPkulI");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১০৭");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "রক্তকরবী");
        this.map_var.put("content", "1USkMxh-jQwJNBg0jZ80o0GLb47O8gsxi");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১০৮");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "রবিবার");
        this.map_var.put("content", "1L-cXEptDqwZp0BdLb3ws8misRd3E4G9m");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১০৯");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "রবীন্দ্র জীবনী ১");
        this.map_var.put("content", "1_EqotOOcRUt1VAljGZrya1qsNrUYrm_A");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১১০");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "রবীন্দ্র জীবনী ২");
        this.map_var.put("content", "1wpPMZRePnnZo3kWPdDbnZbUNp_h6sBu9");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১১১");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "রবীন্দ্র জীবনী ৩");
        this.map_var.put("content", "1AKkSNiN6do8zAyxsRK7iNyNRvRoXipYy");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১১২");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "রবীন্দ্র জীবনী ৪");
        this.map_var.put("content", "1Nde7Vo8_RIR73GiQNbpQxG7BQdgIzeLC");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১১৩");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "রবীন্দ্র-রচনাবলী ১");
        this.map_var.put("content", "1RPB78GXyHIgDvANO8BM_woj2TUmqprw-");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১১৪");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "রবীন্দ্র-রচনাবলী ২");
        this.map_var.put("content", "1OZcVQFc94mizpmoNCYRzLhyr7WW0Gfts");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১১৫");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "রবীন্দ্র-রচনাবলী ৩");
        this.map_var.put("content", "14FJQ7Lxnm4HFwY2PGB3dNarjyL8kTGi-");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১১৬");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "রবীন্দ্র-রচনাবলী ৪");
        this.map_var.put("content", "1wbh4b5zjVR60OQSAAiSE52d4gsonuXfq");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১১৭");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "রবীন্দ্র-রচনাবলী ৫");
        this.map_var.put("content", "1r8bc57mXpJnffktHJ-auDjIKp3xZ7O9G");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১১৮");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "রবীন্দ্র-রচনাবলী ৬");
        this.map_var.put("content", "1wT7kWw3_5_3ZhEGZ2JQTbEoMIPsYEpZx");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১১৯");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "রবীন্দ্র-রচনাবলী ৭");
        this.map_var.put("content", "1VX9hMYFuwB3MdirZumGyuhA8VwwhU9CD");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১২০");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "রবীন্দ্র-রচনাবলী ৮");
        this.map_var.put("content", "1t7YRUprkLAlYZQ-LbhuFC31rh5Pkanrg");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১২১");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "রবীন্দ্র-রচনাবলী ৯");
        this.map_var.put("content", "1Tn9XRoClvfyvJzaN7zoixVqylD98KWTz");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১২২");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "রবীন্দ্র-রচনাবলী ১০");
        this.map_var.put("content", "1KELah-JHHsHih1Wr_q5eYrHWhtIcoiXU");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১২৩");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "রবীন্দ্র-রচনাবলী ১১");
        this.map_var.put("content", "1lJCMjWpHwqWSQsizSnQVf5tVW6Uv-_oA");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১২৪");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "রবীন্দ্র-রচনাবলী ১২");
        this.map_var.put("content", "16pu3T9kovF1a8DdIxfrTSwC8oHokaHLH");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১২৫");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "রবীন্দ্র-রচনাবলী ১৩");
        this.map_var.put("content", "1J8Q9wuh_MZOpIeMRqFMFM6L9G85E8uxK");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১২৬");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "রবীন্দ্র-রচনাবলী ১৪");
        this.map_var.put("content", "1hVbTuZsCuJk80zXJmHBKEwnYv2_3xaUY");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১২৭");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "রবীন্দ্র-রচনাবলী ১৫");
        this.map_var.put("content", "1FfYFUuCosFxenqMOdlMtYk840Wo1GVsi");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১২৮");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "রবীন্দ্র-রচনাবলী ১৬");
        this.map_var.put("content", "1mkYB8UW_hfhOZjEMBj8hrLW9nDkj9dNz");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১২৯");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "রবীন্দ্র-রচনাবলী ১৭");
        this.map_var.put("content", "1MDj99Ku62rGJLU3CmQt9IsW03ibCK1iB");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১৩০");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "রবীন্দ্র-রচনাবলী ১৮");
        this.map_var.put("content", "1FdjOaFui8We7CD5bS2K9knNnhwN0gVbW");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১৩১");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "রবীন্দ্র-রচনাবলী ১৯");
        this.map_var.put("content", "1576V0Auzp0xSz93is6lq60RJxW3X2jEq");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১৩২");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "রবীন্দ্র-রচনাবলী ২০");
        this.map_var.put("content", "195l7WIkZAjoagHSJNNkDfYpstxPP0uMV");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১৩৩");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "রবীন্দ্র-রচনাবলী ২১");
        this.map_var.put("content", "1NpTRpMdObl7smyw0AaEFWSChMpdJ_-5y");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১৩৪");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "রবীন্দ্র-রচনাবলী ২২");
        this.map_var.put("content", "1eGtEtUz5Qw-rATUX4_c7eDBCA0h_4c9v");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১৩৫");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "রবীন্দ্র-রচনাবলী ২৩");
        this.map_var.put("content", "1ZLT8YtQa_1i0_lZzXGxLI7VyHoQqixkz");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১৩৬");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "রবীন্দ্র-রচনাবলী ২৪");
        this.map_var.put("content", "1uGSVI1QpP2dUslCmae_6JEyXw3Q4E9BE");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১৩৭");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "রবীন্দ্র-রচনাবলী ২৫");
        this.map_var.put("content", "1ETW5FNVnuCF0v7HNn7zmLzEiAXErFb1p");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১৩৮");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "রবীন্দ্র-রচনাবলী ২৬");
        this.map_var.put("content", "1KLMGYgE5BMQeUQL-fom8dXninwDfB277");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১৩৯");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "রবীন্দ্র-রচনাবলী ২৭");
        this.map_var.put("content", "1339iJ7rI4C2CvB_eg7NdGpUTXHzA_gRF");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১৪০");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "রবীন্দ্রনাথ এন্ডরুজ পত্রাবলী");
        this.map_var.put("content", "1mONhav5WWyz5okh2GLajwYAw9WyWKOs0");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১৪১");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "রবীন্দ্ররাজনীতি - সৈয়দ আবুল মকসুদ");
        this.map_var.put("content", "1_ZMKVwkHwf4nQ2SHsIrLl0eoyHC2xffO");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১৪২");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "রাজর্ষি");
        this.map_var.put("content", "1VXoYfo0fn5-0V0SwU2WRsR_Q7wYxLvJ2");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১৪৩");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "লিপিকা");
        this.map_var.put("content", "1exhCTv9RnzZ0kP4I7LObG_AzfZq0yiAl");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১৪৪");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "শর্মিলা");
        this.map_var.put("content", "1WIx_L5iUh9KhgNW8p-MXu0k-Gj37yjDG");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১৪৫");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "শাপমোচন");
        this.map_var.put("content", "13sRBoEq5Va57ujpxsFDiRDW_PDEthAq6");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১৪৬");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "শেষ বর্ষণ");
        this.map_var.put("content", "1DYBjI_htfb5pFnfhYYgF_qmgAjTJYAC7");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১৪৭");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "শেষের রাত্রী");
        this.map_var.put("content", "1NrRRbv3yOT8vrYASVZ7YMRvipySmJ8_0");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১৪৮");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "শ্যামা");
        this.map_var.put("content", "1Cry8BhAPHzOF4i4yNCnzW-303qIB_apu");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১৪৯");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "শ্রবণগাথা");
        this.map_var.put("content", "11EAnkjoX7wlr-vz-PbyT1Z4rQSGywxId");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১৫০");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "সঞ্চয়িতা");
        this.map_var.put("content", "1RZZiWbK6zvQMtse5CwUxelt3RWplOtu8");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১৫১");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "সদর ও অন্দর");
        this.map_var.put("content", "1lCQBOGHS3F8DnCklKnS1XQdAyBR3d0Z_");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১৫২");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "সফলতার সদুপায়");
        this.map_var.put("content", "1EdZd8fiWDN9ZLssPqNRG_2FXYX-dgSVt");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১৫৩");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "সমাপ্তি");
        this.map_var.put("content", "1JYVwc3j7qzFBv6mY6nG1qD9dsn5Y5mXw");
        this.map_list.add(this.map_var);
        this.map_var = new HashMap<>();
        this.map_var.put("serial", "১৫৪");
        this.map_var.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "হিন্দু মুসলমান");
        this.map_var.put("content", "1q7m_tFwwjidzbj63swAHPaSD2QlQFWWf");
        this.map_list.add(this.map_var);
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
    public void _click(View view) {
        view.setClickable(true);
        view.setBackground(CircleDrawables.getSelectableDrawableFor(Color.parseColor("#FFFFFFFF")));
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
            view.setOnTouchListener(new View.OnTouchListener() { // from class: com.arefin.rabindra.BaniActivity.7
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
            LayoutInflater layoutInflater = (LayoutInflater) BaniActivity.this.getBaseContext().getSystemService("layout_inflater");
            if (view == null) {
                view = layoutInflater.inflate(R.layout.bani_custom, (ViewGroup) null);
            }
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.linear1);
            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.linear_tool);
            LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.linear_bar);
            LinearLayout linearLayout4 = (LinearLayout) view.findViewById(R.id.linear4);
            ImageView imageView = (ImageView) view.findViewById(R.id.imageview_copy);
            LinearLayout linearLayout5 = (LinearLayout) view.findViewById(R.id.linear7);
            ImageView imageView2 = (ImageView) view.findViewById(R.id.imageview_share);
            ImageView imageView3 = (ImageView) view.findViewById(R.id.imageview1);
            TextView textView = (TextView) view.findViewById(R.id.textview1);
            LinearLayout linearLayout6 = (LinearLayout) view.findViewById(R.id.linear5);
            LinearLayout linearLayout7 = (LinearLayout) view.findViewById(R.id.linear6);
            TextView textView2 = (TextView) view.findViewById(R.id.textview2);
            textView.setText(this._data.get(i).get("content").toString());
            textView.setTypeface(Typeface.createFromAsset(BaniActivity.this.getAssets(), "fonts/solaimanlipi.ttf"), 0);
            textView2.setTypeface(Typeface.createFromAsset(BaniActivity.this.getAssets(), "fonts/solaimanlipi.ttf"), 1);
            BaniActivity.this.aa = this._data.get(i).get("content").toString();
            BaniActivity.this.bb = "* Download full Rabindra Samagra from the link given below :  https://play.google.com/store/apps/details?id=com.arefin.rabindra";
            BaniActivity.this.code = BaniActivity.this.aa.concat("\n\n".concat(BaniActivity.this.bb));
            BaniActivity.this._click(imageView);
            BaniActivity.this._click(imageView2);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.arefin.rabindra.BaniActivity.Listview1Adapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    BaniActivity baniActivity = BaniActivity.this;
                    BaniActivity.this.getApplicationContext();
                    ((ClipboardManager) baniActivity.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("clipboard", BaniActivity.this.code));
                    SketchwareUtil.showMessage(BaniActivity.this.getApplicationContext(), "Copied");
                }
            });
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.arefin.rabindra.BaniActivity.Listview1Adapter.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Intent intent = new Intent("android.intent.action.SEND");
                    intent.setType("text/plain");
                    intent.putExtra("android.intent.extra.TEXT", BaniActivity.this.code);
                    intent.putExtra("android.intent.extra.SUBJECT", "রবি ঠাকুরের বাণী");
                    BaniActivity.this.startActivity(Intent.createChooser(intent, "Share App using"));
                }
            });
            if (!BaniActivity.this.data.getString("theme", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED).equals("theme4")) {
                if (!BaniActivity.this.data.getString("theme", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED).equals("theme3")) {
                    if (BaniActivity.this.data.getString("theme", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED).equals("theme2")) {
                        BaniActivity.this._radius(linearLayout, BaniActivity.this.colorPrimary, 20.0d);
                        BaniActivity.this._radius(linearLayout3, BaniActivity.this.colorPrimaryDark, 10.0d);
                        textView.setTextColor(Color.parseColor(BaniActivity.this.ColorText));
                        textView2.setTextColor(Color.parseColor(BaniActivity.this.ColorText));
                        imageView.setImageResource(R.drawable.ic_content_copy_grey);
                        imageView2.setImageResource(R.drawable.ic_share_grey);
                    } else {
                        BaniActivity.this._radius(linearLayout, BaniActivity.this.colorPrimary, 20.0d);
                        BaniActivity.this._radius(linearLayout3, BaniActivity.this.colorPrimaryDark, 10.0d);
                        textView.setTextColor(Color.parseColor(BaniActivity.this.ColorText));
                        textView2.setTextColor(Color.parseColor(BaniActivity.this.ColorText));
                        imageView.setImageResource(R.drawable.ic_content_copy_grey);
                        imageView2.setImageResource(R.drawable.ic_share_grey);
                    }
                } else {
                    BaniActivity.this._radius(linearLayout, BaniActivity.this.colorPrimary, 20.0d);
                    BaniActivity.this._radius(linearLayout3, BaniActivity.this.colorPrimaryDark, 10.0d);
                    textView.setTextColor(Color.parseColor(BaniActivity.this.ColorText));
                    textView2.setTextColor(Color.parseColor(BaniActivity.this.ColorText));
                    imageView.setImageResource(R.drawable.ic_content_copy_white);
                    imageView2.setImageResource(R.drawable.ic_share_white);
                }
            } else {
                BaniActivity.this._radius(linearLayout, BaniActivity.this.colorPrimaryDark, 20.0d);
                BaniActivity.this._radius(linearLayout3, BaniActivity.this.colorPrimary, 10.0d);
                textView.setTextColor(Color.parseColor("#000000"));
                textView2.setTextColor(Color.parseColor("#000000"));
                imageView.setImageResource(R.drawable.ic_content_copy_grey);
                imageView2.setImageResource(R.drawable.ic_share_grey);
            }
            Animation loadAnimation = AnimationUtils.loadAnimation(BaniActivity.this.getApplicationContext(), 17432578);
            loadAnimation.setDuration(200L);
            linearLayout.startAnimation(loadAnimation);
            return view;
        }
    }

    /* loaded from: classes.dex */
    public class Listview2Adapter extends BaseAdapter {
        ArrayList<HashMap<String, Object>> _data;

        public Listview2Adapter(ArrayList<HashMap<String, Object>> arrayList) {
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
            LayoutInflater layoutInflater = (LayoutInflater) BaniActivity.this.getBaseContext().getSystemService("layout_inflater");
            if (view == null) {
                view = layoutInflater.inflate(R.layout.pdf_custom, (ViewGroup) null);
            }
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.linear3);
            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.linear1);
            ImageView imageView = (ImageView) view.findViewById(R.id.imageview1);
            TextView textView = (TextView) view.findViewById(R.id.textview1);
            LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.linear2);
            TextView textView2 = (TextView) view.findViewById(R.id.textview2);
            textView2.setTypeface(Typeface.createFromAsset(BaniActivity.this.getAssets(), "fonts/solaimanlipi.ttf"), 0);
            textView2.setText(this._data.get(i).get("serial").toString());
            textView.setTypeface(Typeface.createFromAsset(BaniActivity.this.getAssets(), "fonts/solaimanlipi.ttf"), 0);
            textView.setText(this._data.get(i).get(AppMeasurementSdk.ConditionalUserProperty.NAME).toString());
            Animation loadAnimation = AnimationUtils.loadAnimation(BaniActivity.this.getApplicationContext(), 17432578);
            loadAnimation.setDuration(200L);
            linearLayout2.startAnimation(loadAnimation);
            if (!BaniActivity.this.data.getString("theme", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED).equals("theme4")) {
                if (BaniActivity.this.data.getString("theme", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED).equals("theme3")) {
                    textView.setTextColor(Color.parseColor(BaniActivity.this.ColorText));
                    textView2.setTextColor(Color.parseColor(BaniActivity.this.ColorText));
                    BaniActivity.this._Card_View(linearLayout3, 180.0d, BaniActivity.this.colorPrimary, 0.0d, 2.0d, BaniActivity.this.colorPrimaryDark);
                    BaniActivity.this._rippleRoundStroke(linearLayout2, BaniActivity.this.colorPrimary, BaniActivity.this.colorPrimaryDark, 20.0d, 0.0d, BaniActivity.this.colorPrimary);
                } else if (BaniActivity.this.data.getString("theme", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED).equals("theme2")) {
                    textView.setTextColor(Color.parseColor(BaniActivity.this.ColorText));
                    textView2.setTextColor(Color.parseColor(BaniActivity.this.ColorText));
                    BaniActivity.this._Card_View(linearLayout3, 180.0d, BaniActivity.this.colorPrimary, 0.0d, 2.0d, BaniActivity.this.colorPrimaryDark);
                    BaniActivity.this._rippleRoundStroke(linearLayout2, BaniActivity.this.colorPrimary, BaniActivity.this.colorPrimaryDark, 20.0d, 0.0d, BaniActivity.this.colorPrimary);
                } else {
                    textView.setTextColor(Color.parseColor(BaniActivity.this.ColorText));
                    textView2.setTextColor(Color.parseColor(BaniActivity.this.ColorText));
                    BaniActivity.this._Card_View(linearLayout3, 180.0d, BaniActivity.this.colorPrimary, 0.0d, 2.0d, BaniActivity.this.colorPrimaryDark);
                    BaniActivity.this._rippleRoundStroke(linearLayout2, BaniActivity.this.colorPrimary, BaniActivity.this.colorPrimaryDark, 20.0d, 0.0d, BaniActivity.this.colorPrimary);
                }
            } else {
                textView.setTextColor(Color.parseColor("#000000"));
                textView2.setTextColor(Color.parseColor("#000000"));
                BaniActivity.this._Card_View(linearLayout3, 180.0d, BaniActivity.this.colorPrimaryDark, 0.0d, 2.0d, BaniActivity.this.colorPrimary);
                BaniActivity.this._rippleRoundStroke(linearLayout2, BaniActivity.this.colorPrimaryDark, BaniActivity.this.colorPrimary, 20.0d, 0.0d, BaniActivity.this.colorPrimaryDark);
            }
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
