package com.yeasinrabbee.robindodemo;

import android.animation.ObjectAnimator;
import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
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
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
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
import java.util.Random;

/* loaded from: classes.dex */
public class KobitaGaanViewActivity extends AppCompatActivity {
    private AdListener _interstitial_ad_listener;
    private AdView adview1;
    private SharedPreferences data;
    private AlertDialog.Builder dialog_copy;
    private ImageView imageview1;
    private ImageView imageview2;
    private ImageView imageview_back;
    private ImageView imageview_copy;
    private ImageView imageview_decrease;
    private ImageView imageview_increase;
    private ImageView imageview_share;
    private InterstitialAd interstitial;
    private LinearLayout linear1;
    private LinearLayout linear7;
    private LinearLayout linear_actionbar;
    private LinearLayout linear_back;
    private LinearLayout linear_bar_1;
    private LinearLayout linear_bar_2;
    private LinearLayout linear_base;
    private LinearLayout linear_copy;
    private LinearLayout linear_decrease;
    private LinearLayout linear_increase;
    private LinearLayout linear_share;
    private LinearLayout linear_tools;
    private TextView textview1;
    private TextView textview2;
    private ScrollView vscroll1;
    private String aa = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    private String bb = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    private String cc = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    private String code = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    private String colorPrimary = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    private String colorPrimaryDark = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    private String ColorText = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.kobita_gaan_view);
        initialize(bundle);
        initializeLogic();
    }

    private void initialize(Bundle bundle) {
        this.linear_base = (LinearLayout) findViewById(R.id.linear_base);
        this.linear1 = (LinearLayout) findViewById(R.id.linear1);
        this.adview1 = (AdView) findViewById(R.id.adview1);
        this.linear_actionbar = (LinearLayout) findViewById(R.id.linear_actionbar);
        this.linear_bar_1 = (LinearLayout) findViewById(R.id.linear_bar_1);
        this.vscroll1 = (ScrollView) findViewById(R.id.vscroll1);
        this.linear_bar_2 = (LinearLayout) findViewById(R.id.linear_bar_2);
        this.linear_tools = (LinearLayout) findViewById(R.id.linear_tools);
        this.imageview1 = (ImageView) findViewById(R.id.imageview1);
        this.textview1 = (TextView) findViewById(R.id.textview1);
        this.imageview2 = (ImageView) findViewById(R.id.imageview2);
        this.linear7 = (LinearLayout) findViewById(R.id.linear7);
        this.textview2 = (TextView) findViewById(R.id.textview2);
        this.linear_back = (LinearLayout) findViewById(R.id.linear_back);
        this.linear_copy = (LinearLayout) findViewById(R.id.linear_copy);
        this.linear_increase = (LinearLayout) findViewById(R.id.linear_increase);
        this.linear_decrease = (LinearLayout) findViewById(R.id.linear_decrease);
        this.linear_share = (LinearLayout) findViewById(R.id.linear_share);
        this.imageview_back = (ImageView) findViewById(R.id.imageview_back);
        this.imageview_copy = (ImageView) findViewById(R.id.imageview_copy);
        this.imageview_increase = (ImageView) findViewById(R.id.imageview_increase);
        this.imageview_decrease = (ImageView) findViewById(R.id.imageview_decrease);
        this.imageview_share = (ImageView) findViewById(R.id.imageview_share);
        this.dialog_copy = new AlertDialog.Builder(this);
        this.data = getSharedPreferences("data", 0);
        this.linear_back.setOnClickListener(new View.OnClickListener() { // from class: com.arefin.rabindra.KobitaGaanViewActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                KobitaGaanViewActivity.this.interstitial.show();
                KobitaGaanViewActivity.this.finish();
            }
        });
        this.linear_copy.setOnClickListener(new View.OnClickListener() { // from class: com.arefin.rabindra.KobitaGaanViewActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                KobitaGaanViewActivity.this._Copy();
            }
        });
        this.linear_increase.setOnClickListener(new View.OnClickListener() { // from class: com.arefin.rabindra.KobitaGaanViewActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                KobitaGaanViewActivity.this.textview2.setTextSize(0, KobitaGaanViewActivity.this.textview2.getTextSize() + 2.0f);
            }
        });
        this.linear_decrease.setOnClickListener(new View.OnClickListener() { // from class: com.arefin.rabindra.KobitaGaanViewActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                KobitaGaanViewActivity.this.textview2.setTextSize(0, KobitaGaanViewActivity.this.textview2.getTextSize() - 2.0f);
            }
        });
        this.linear_share.setOnClickListener(new View.OnClickListener() { // from class: com.arefin.rabindra.KobitaGaanViewActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                KobitaGaanViewActivity.this._Share();
            }
        });
        this._interstitial_ad_listener = new AdListener() { // from class: com.arefin.rabindra.KobitaGaanViewActivity.6
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
                KobitaGaanViewActivity.this.interstitial.loadAd(new AdRequest.Builder().build());
            }
        };
    }

    private void initializeLogic() {
        _ColorsOnly();
        this.interstitial = new InterstitialAd(getApplicationContext());
        this.interstitial.setAdListener(this._interstitial_ad_listener);
        this.interstitial.setAdUnitId("ca-app-pub-8700028746384810/3694838553");
        this.interstitial.loadAd(new AdRequest.Builder().build());
        this.adview1.loadAd(new AdRequest.Builder().build());
        this.adview1.setAdListener(new AdListener() { // from class: com.arefin.rabindra.KobitaGaanViewActivity.7
            @Override // com.google.android.gms.ads.AdListener
            public void onAdLoaded() {
                Log.i(com.google.ads.AdRequest.LOGTAG, "onAdLoaded");
                KobitaGaanViewActivity.this.adview1.setVisibility(0);
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdFailedToLoad(int i) {
                Log.i(com.google.ads.AdRequest.LOGTAG, "onAdFailedToLoad");
                KobitaGaanViewActivity.this.adview1.setVisibility(8);
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
        getApplicationContext();
        ((ClipboardManager) getSystemService("clipboard")).addPrimaryClipChangedListener(new ClipboardManager.OnPrimaryClipChangedListener() { // from class: com.arefin.rabindra.KobitaGaanViewActivity.8
            @Override // android.content.ClipboardManager.OnPrimaryClipChangedListener
            public void onPrimaryClipChanged() {
                KobitaGaanViewActivity.this.interstitial.show();
            }
        });
        this.imageview1.setVisibility(8);
        this.imageview2.setVisibility(8);
        _click(this.linear_back);
        _click(this.linear_copy);
        _click(this.linear_increase);
        _click(this.linear_decrease);
        _click(this.linear_share);
        _SelectableText(this.textview1);
        _SelectableText(this.textview2);
        this.textview1.setText(getIntent().getStringExtra(AppMeasurementSdk.ConditionalUserProperty.NAME));
        this.textview2.setText(getIntent().getStringExtra("content"));
        this.textview1.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 1);
        this.textview2.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
        if (this.data.getString("theme", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED).equals("theme4")) {
            Window window = getWindow();
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(Color.parseColor(this.colorPrimary));
            window.setNavigationBarColor(Color.parseColor(this.colorPrimary));
            _Corner_Radius(this.linear_actionbar, this.colorPrimaryDark, 10.0d, 10.0d, 0.0d, 0.0d);
            _Corner_Radius(this.linear_tools, this.colorPrimaryDark, 0.0d, 0.0d, 10.0d, 10.0d);
            _Card_View(this.linear1, 10.0d, this.colorPrimaryDark, 10.0d, 0.0d, RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
            _CardStyle(this.linear_bar_1, 0.0d, 0.0d, this.colorPrimary, false);
            _CardStyle(this.linear_bar_2, 0.0d, 0.0d, this.colorPrimary, false);
            this.textview1.setTextColor(Color.parseColor("#000000"));
            this.textview2.setTextColor(Color.parseColor("#000000"));
            _CardStyle(this.linear_base, 0.0d, 0.0d, this.colorPrimary, false);
            this.imageview_back.setImageResource(R.drawable.ic_arrow_back_grey);
            this.imageview_copy.setImageResource(R.drawable.ic_content_copy_grey);
            this.imageview_increase.setImageResource(R.drawable.ic_keyboard_arrow_up_grey);
            this.imageview_decrease.setImageResource(R.drawable.ic_keyboard_arrow_down_grey);
            this.imageview_share.setImageResource(R.drawable.ic_share_grey);
        } else if (this.data.getString("theme", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED).equals("theme3")) {
            Window window2 = getWindow();
            window2.clearFlags(67108864);
            window2.addFlags(Integer.MIN_VALUE);
            window2.setStatusBarColor(Color.parseColor(this.colorPrimary));
            window2.setNavigationBarColor(Color.parseColor(this.colorPrimary));
            _Corner_Radius(this.linear_actionbar, this.colorPrimaryDark, 10.0d, 10.0d, 0.0d, 0.0d);
            _Corner_Radius(this.linear_tools, this.colorPrimaryDark, 0.0d, 0.0d, 10.0d, 10.0d);
            _Card_View(this.linear1, 10.0d, this.colorPrimaryDark, 10.0d, 0.0d, RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
            _CardStyle(this.linear_bar_1, 0.0d, 0.0d, this.colorPrimary, false);
            _CardStyle(this.linear_bar_2, 0.0d, 0.0d, this.colorPrimary, false);
            this.textview1.setTextColor(Color.parseColor(this.ColorText));
            this.textview2.setTextColor(Color.parseColor(this.ColorText));
            _CardStyle(this.linear_base, 0.0d, 0.0d, this.colorPrimary, false);
            this.imageview_back.setImageResource(R.drawable.ic_arrow_back_white);
            this.imageview_copy.setImageResource(R.drawable.ic_content_copy_white);
            this.imageview_increase.setImageResource(R.drawable.ic_keyboard_arrow_up_white);
            this.imageview_decrease.setImageResource(R.drawable.ic_expand_more_white);
            this.imageview_share.setImageResource(R.drawable.ic_share_white);
        } else if (this.data.getString("theme", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED).equals("theme2")) {
            Window window3 = getWindow();
            window3.clearFlags(67108864);
            window3.addFlags(Integer.MIN_VALUE);
            window3.getDecorView().setSystemUiVisibility(8192);
            window3.setStatusBarColor(Color.parseColor(this.colorPrimary));
            window3.setNavigationBarColor(Color.parseColor(this.colorPrimary));
            _Corner_Radius(this.linear_actionbar, this.colorPrimaryDark, 10.0d, 10.0d, 0.0d, 0.0d);
            _Corner_Radius(this.linear_tools, this.colorPrimaryDark, 0.0d, 0.0d, 10.0d, 10.0d);
            _Card_View(this.linear1, 10.0d, this.colorPrimaryDark, 10.0d, 0.0d, RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
            _CardStyle(this.linear_bar_1, 0.0d, 0.0d, this.colorPrimary, false);
            _CardStyle(this.linear_bar_2, 0.0d, 0.0d, this.colorPrimary, false);
            this.textview1.setTextColor(Color.parseColor(this.ColorText));
            this.textview2.setTextColor(Color.parseColor(this.ColorText));
            _CardStyle(this.linear_base, 0.0d, 0.0d, this.colorPrimary, false);
            this.imageview_back.setImageResource(R.drawable.ic_arrow_back_grey);
            this.imageview_copy.setImageResource(R.drawable.ic_content_copy_grey);
            this.imageview_increase.setImageResource(R.drawable.ic_keyboard_arrow_up_grey);
            this.imageview_decrease.setImageResource(R.drawable.ic_keyboard_arrow_down_grey);
            this.imageview_share.setImageResource(R.drawable.ic_share_grey);
        } else {
            Window window4 = getWindow();
            window4.clearFlags(67108864);
            window4.addFlags(Integer.MIN_VALUE);
            window4.getDecorView().setSystemUiVisibility(8192);
            window4.setStatusBarColor(Color.parseColor(this.colorPrimaryDark));
            window4.setNavigationBarColor(Color.parseColor(this.colorPrimaryDark));
            _Corner_Radius(this.linear_actionbar, this.colorPrimary, 10.0d, 10.0d, 0.0d, 0.0d);
            _Corner_Radius(this.linear_tools, this.colorPrimary, 0.0d, 0.0d, 10.0d, 10.0d);
            _Card_View(this.linear1, 10.0d, this.colorPrimary, 10.0d, 0.0d, RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
            _CardStyle(this.linear_bar_1, 0.0d, 0.0d, this.colorPrimaryDark, false);
            _CardStyle(this.linear_bar_2, 0.0d, 0.0d, this.colorPrimaryDark, false);
            this.textview1.setTextColor(Color.parseColor(this.ColorText));
            this.textview2.setTextColor(Color.parseColor(this.ColorText));
            _CardStyle(this.linear_base, 0.0d, 0.0d, this.colorPrimary, false);
            this.imageview_back.setImageResource(R.drawable.ic_arrow_back_grey);
            this.imageview_copy.setImageResource(R.drawable.ic_content_copy_grey);
            this.imageview_increase.setImageResource(R.drawable.ic_keyboard_arrow_up_grey);
            this.imageview_decrease.setImageResource(R.drawable.ic_keyboard_arrow_down_grey);
            this.imageview_share.setImageResource(R.drawable.ic_share_grey);
        }
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
        this.interstitial.show();
        finish();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.interstitial.show();
    }

    private void _click(View view) {
        view.setClickable(true);
        view.setBackground(CircleDrawables.getSelectableDrawableFor(Color.parseColor("#FFFFFFFF")));
    }

    private void _Card_View(View view, double d, String str, double d2, double d3, String str2) {
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

    private void _Corner_Radius(View view, String str, double d, double d2, double d3, double d4) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor(str));
        gradientDrawable.setCornerRadii(new float[]{(int) d, (int) d, (int) d2, (int) d2, (int) d3, (int) d3, (int) d4, (int) d4});
        view.setBackground(gradientDrawable);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void _Copy() {
        this.aa = this.textview1.getText().toString();
        this.bb = this.textview2.getText().toString();
        this.cc = "* Download more our apps from the link given below :  https://bit.ly/ArefinApps";
        _setDialogFont(this.dialog_copy, "Want to Copy this?", this.aa.concat("\n\n".concat(this.bb)), "solaimanlipi.ttf");
        this.dialog_copy.setPositiveButton("Copy", new DialogInterface.OnClickListener() { // from class: com.arefin.rabindra.KobitaGaanViewActivity.9
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                KobitaGaanViewActivity.this.code = KobitaGaanViewActivity.this.aa.concat("\n\n".concat(KobitaGaanViewActivity.this.bb.concat("\n\n".concat(KobitaGaanViewActivity.this.cc))));
                KobitaGaanViewActivity kobitaGaanViewActivity = KobitaGaanViewActivity.this;
                KobitaGaanViewActivity.this.getApplicationContext();
                ((ClipboardManager) kobitaGaanViewActivity.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("clipboard", KobitaGaanViewActivity.this.code));
                SketchwareUtil.showMessage(KobitaGaanViewActivity.this.getApplicationContext(), "কপি সম্পন্ন হয়েছে");
            }
        });
        this.dialog_copy.setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: com.arefin.rabindra.KobitaGaanViewActivity.10
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        this.dialog_copy.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _Share() {
        this.aa = this.textview1.getText().toString();
        this.bb = this.textview2.getText().toString();
        this.cc = "* Download more our apps from the link given below :  https://bit.ly/ArefinApps";
        this.code = this.aa.concat("\n\n".concat(this.bb.concat("\n\n".concat(this.cc))));
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", this.code);
        intent.putExtra("android.intent.extra.SUBJECT", "Share Quotation from Rabindra Samagra");
        startActivity(Intent.createChooser(intent, "Share text using"));
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
            view.setOnTouchListener(new View.OnTouchListener() { // from class: com.arefin.rabindra.KobitaGaanViewActivity.11
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

    private void _SelectableText(TextView textView) {
        textView.setTextIsSelectable(true);
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
