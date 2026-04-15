package com.yeasinrabbee.robindodemo;

import android.animation.ObjectAnimator;
import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
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
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.arefin.rabindra.RequestNetwork;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import org.apache.http.protocol.HTTP;

/* loaded from: classes.dex */
public class WebviewActivity extends AppCompatActivity {
    private AdListener _interstitial_ad_listener;
    private RequestNetwork.RequestListener _net_request_listener;
    private AdView adview1;
    private AlertDialog.Builder alert;
    private SharedPreferences data;
    private ImageView imageview_back;
    private ImageView imageview_menu;
    private InterstitialAd interstitial;
    private LinearLayout linear1;
    private LinearLayout linear2;
    private LinearLayout linear4;
    private LinearLayout linear6;
    private LinearLayout linear_toolbar;
    private RequestNetwork net;
    private ProgressBar progressbar1;
    private TextView textview1;
    private TextView textview2;
    private TextView textview3;
    private WebView webview1;
    private WebView webview2;
    private String Base = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    private String colorPrimary = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    private String colorPrimaryDark = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    private String ColorText = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    private String fontName = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    private String typeace = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    private String fileName = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    private String down_path = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    private Intent i = new Intent();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.webview);
        initialize(bundle);
        initializeLogic();
    }

    private void initialize(Bundle bundle) {
        this.linear1 = (LinearLayout) findViewById(R.id.linear1);
        this.linear_toolbar = (LinearLayout) findViewById(R.id.linear_toolbar);
        this.linear4 = (LinearLayout) findViewById(R.id.linear4);
        this.adview1 = (AdView) findViewById(R.id.adview1);
        this.imageview_back = (ImageView) findViewById(R.id.imageview_back);
        this.linear6 = (LinearLayout) findViewById(R.id.linear6);
        this.imageview_menu = (ImageView) findViewById(R.id.imageview_menu);
        this.progressbar1 = (ProgressBar) findViewById(R.id.progressbar1);
        this.textview2 = (TextView) findViewById(R.id.textview2);
        this.textview3 = (TextView) findViewById(R.id.textview3);
        this.linear2 = (LinearLayout) findViewById(R.id.linear2);
        this.webview1 = (WebView) findViewById(R.id.webview1);
        this.webview1.getSettings().setJavaScriptEnabled(true);
        this.webview1.getSettings().setSupportZoom(true);
        this.webview2 = (WebView) findViewById(R.id.webview2);
        this.webview2.getSettings().setJavaScriptEnabled(true);
        this.webview2.getSettings().setSupportZoom(true);
        this.textview1 = (TextView) findViewById(R.id.textview1);
        this.net = new RequestNetwork(this);
        this.alert = new AlertDialog.Builder(this);
        this.data = getSharedPreferences("data", 0);
        this.imageview_back.setOnClickListener(new View.OnClickListener() { // from class: com.arefin.rabindra.WebviewActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WebviewActivity.this.interstitial.show();
                WebviewActivity.this.finish();
            }
        });
        this.imageview_menu.setOnClickListener(new View.OnClickListener() { // from class: com.arefin.rabindra.WebviewActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(WebviewActivity.this, WebviewActivity.this.imageview_menu);
                popupMenu.getMenu().add("Refresh");
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.arefin.rabindra.WebviewActivity.2.1
                    @Override // android.widget.PopupMenu.OnMenuItemClickListener
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        String charSequence = menuItem.getTitle().toString();
                        switch (charSequence.hashCode()) {
                            case -1544869189:
                                if (charSequence.equals("Refresh")) {
                                    WebviewActivity.this.webview1.loadUrl("javascript:window.location.reload( true )");
                                    NetworkInfo activeNetworkInfo = ((ConnectivityManager) WebviewActivity.this.getSystemService("connectivity")).getActiveNetworkInfo();
                                    if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                                        WebviewActivity.this.linear2.setVisibility(0);
                                        WebviewActivity.this.webview1.setVisibility(8);
                                    } else {
                                        WebviewActivity.this.linear2.setVisibility(8);
                                        WebviewActivity.this.webview1.setVisibility(0);
                                        WebviewActivity.this.webview1.loadUrl("javascript:window.location.reload( true )");
                                    }
                                    return true;
                                }
                                break;
                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });
        this.webview1.setWebViewClient(new WebViewClient() { // from class: com.arefin.rabindra.WebviewActivity.3
            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                WebviewActivity.this.progressbar1.setVisibility(0);
                super.onPageStarted(webView, str, bitmap);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                WebviewActivity.this.progressbar1.setVisibility(8);
                super.onPageFinished(webView, str);
            }
        });
        this.webview2.setWebViewClient(new WebViewClient() { // from class: com.arefin.rabindra.WebviewActivity.4
            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
            }
        });
        this._net_request_listener = new RequestNetwork.RequestListener() { // from class: com.arefin.rabindra.WebviewActivity.5
            @Override // com.arefin.rabindra.RequestNetwork.RequestListener
            public void onResponse(String str, String str2) {
                WebviewActivity.this.linear2.setVisibility(8);
                WebviewActivity.this.webview1.setVisibility(0);
            }

            @Override // com.arefin.rabindra.RequestNetwork.RequestListener
            public void onErrorResponse(String str, String str2) {
                WebviewActivity.this.linear2.setVisibility(0);
                WebviewActivity.this.webview1.setVisibility(8);
            }
        };
        this._interstitial_ad_listener = new AdListener() { // from class: com.arefin.rabindra.WebviewActivity.6
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
                WebviewActivity.this.interstitial.loadAd(new AdRequest.Builder().build());
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
        this.adview1.setAdListener(new AdListener() { // from class: com.arefin.rabindra.WebviewActivity.7
            @Override // com.google.android.gms.ads.AdListener
            public void onAdLoaded() {
                Log.i(com.google.ads.AdRequest.LOGTAG, "onAdLoaded");
                WebviewActivity.this.adview1.setVisibility(0);
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdFailedToLoad(int i) {
                Log.i(com.google.ads.AdRequest.LOGTAG, "onAdFailedToLoad");
                WebviewActivity.this.adview1.setVisibility(8);
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
        this.net.startRequestNetwork("GET", "https://google.com", "A", this._net_request_listener);
        _changeActivityFont("solaimanlipi");
        _Extra();
        ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
        this.webview1.loadUrl(this.Base);
        this.webview1.getSettings().setBuiltInZoomControls(true);
        this.webview1.getSettings().setDisplayZoomControls(false);
        this.webview1.getSettings().setJavaScriptEnabled(true);
        this.fileName = getIntent().getStringExtra(AppMeasurementSdk.ConditionalUserProperty.NAME).concat(".pdf");
        this.down_path = "/Rabindra Samagra/";
        this.webview2.setDownloadListener(new DownloadListener() { // from class: com.arefin.rabindra.WebviewActivity.8
            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
                request.addRequestHeader("cookie", CookieManager.getInstance().getCookie(str));
                request.addRequestHeader(HTTP.USER_AGENT, str2);
                request.setDescription("Downloading file...");
                request.setTitle(WebviewActivity.this.fileName);
                request.allowScanningByMediaScanner();
                request.setNotificationVisibility(1);
                request.setDestinationInExternalPublicDir(WebviewActivity.this.down_path, WebviewActivity.this.fileName);
                ((DownloadManager) WebviewActivity.this.getSystemService("download")).enqueue(request);
                WebviewActivity.this.showMessage("Downloading File....");
                WebviewActivity.this.registerReceiver(new BroadcastReceiver() { // from class: com.arefin.rabindra.WebviewActivity.8.1
                    @Override // android.content.BroadcastReceiver
                    public void onReceive(Context context, Intent intent) {
                        WebviewActivity.this.showMessage("Download Complete!");
                        WebviewActivity.this.unregisterReceiver(this);
                    }
                }, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
            }
        });
        this.webview2.getSettings().setJavaScriptEnabled(true);
        this.linear2.setVisibility(8);
        this.webview1.setVisibility(0);
        _CardStyle(this.linear_toolbar, 8.0d, 0.0d, this.colorPrimary, false);
        _CardStyle(this.linear1, 0.0d, 0.0d, this.colorPrimaryDark, false);
        if (this.data.getString("theme", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED).equals("theme4")) {
            Window window = getWindow();
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(Color.parseColor("#006064"));
            window.setNavigationBarColor(Color.parseColor("#FFFFFF"));
            this.textview1.setTextColor(Color.parseColor("#FFFFFF"));
            this.textview2.setTextColor(Color.parseColor("#FFFFFF"));
            this.textview3.setTextColor(Color.parseColor("#FFFFFF"));
            this.imageview_back.setImageResource(R.drawable.ic_arrow_back_white);
            this.imageview_menu.setImageResource(R.drawable.ic_more_vert_white);
        } else if (this.data.getString("theme", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED).equals("theme3")) {
            Window window2 = getWindow();
            window2.clearFlags(67108864);
            window2.addFlags(Integer.MIN_VALUE);
            window2.setStatusBarColor(Color.parseColor("#FF212121"));
            window2.setNavigationBarColor(Color.parseColor("#FF212121"));
            this.textview1.setTextColor(Color.parseColor("#FFFFFF"));
            this.textview2.setTextColor(Color.parseColor("#FFFFFF"));
            this.textview3.setTextColor(Color.parseColor("#FFFFFF"));
            this.imageview_back.setImageResource(R.drawable.ic_arrow_back_white);
            this.imageview_menu.setImageResource(R.drawable.ic_more_vert_white);
        } else if (this.data.getString("theme", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED).equals("theme2")) {
            Window window3 = getWindow();
            window3.clearFlags(67108864);
            window3.addFlags(Integer.MIN_VALUE);
            window3.getDecorView().setSystemUiVisibility(8192);
            window3.setStatusBarColor(Color.parseColor("#FFE0B2"));
            window3.setNavigationBarColor(Color.parseColor("#FFE0B2"));
            this.textview1.setTextColor(Color.parseColor("#000000"));
            this.textview2.setTextColor(Color.parseColor("#000000"));
            this.textview3.setTextColor(Color.parseColor("#000000"));
            this.imageview_back.setImageResource(R.drawable.ic_arrow_back_grey);
            this.imageview_menu.setImageResource(R.drawable.ic_more_vert_grey);
        } else {
            Window window4 = getWindow();
            window4.clearFlags(67108864);
            window4.addFlags(Integer.MIN_VALUE);
            window4.getDecorView().setSystemUiVisibility(8192);
            window4.setStatusBarColor(Color.parseColor("#FFFFFF"));
            window4.setNavigationBarColor(Color.parseColor("#FFFFFF"));
            this.textview1.setTextColor(Color.parseColor("#000000"));
            this.textview2.setTextColor(Color.parseColor("#000000"));
            this.textview3.setTextColor(Color.parseColor("#000000"));
            this.imageview_back.setImageResource(R.drawable.ic_arrow_back_grey);
            this.imageview_menu.setImageResource(R.drawable.ic_more_vert_grey);
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
        view.setBackground(CircleDrawables.getSelectableDrawableFor(Color.parseColor("#212121")));
    }

    private void _ColorsOnly() {
        if (this.data.getString("theme", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED).equals("theme4")) {
            this.colorPrimary = "#006064";
            this.colorPrimaryDark = "#FFFFFF";
            this.ColorText = "#FFFFFF";
        } else if (this.data.getString("theme", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED).equals("theme3")) {
            this.colorPrimary = "#424242";
            this.colorPrimaryDark = "#171717";
            this.ColorText = "#FFFFFF";
        } else if (this.data.getString("theme", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED).equals("theme2")) {
            this.colorPrimary = "#FFF3E0";
            this.colorPrimaryDark = "#FFE0B2";
            this.ColorText = "#000000";
        } else {
            this.colorPrimary = "#FFFFFF";
            this.colorPrimaryDark = "#E0E0E0";
            this.ColorText = "#000000";
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
            view.setOnTouchListener(new View.OnTouchListener() { // from class: com.arefin.rabindra.WebviewActivity.9
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

    private void _Extra() {
        this.textview1.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
        this.textview2.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
        this.textview3.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
        this.Base = "https://drive.google.com/file/d/".concat(getIntent().getStringExtra("drive_id").concat("/view"));
        this.textview2.setText(getIntent().getStringExtra(AppMeasurementSdk.ConditionalUserProperty.NAME));
        _click(this.imageview_menu);
        _click(this.imageview_back);
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
