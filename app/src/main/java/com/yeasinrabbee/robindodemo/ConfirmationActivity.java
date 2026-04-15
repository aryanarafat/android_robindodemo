package com.yeasinrabbee.robindodemo;

import android.animation.ObjectAnimator;
import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
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
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.internal.view.SupportMenu;
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
public class ConfirmationActivity extends AppCompatActivity {
    private AdListener _interstitial_ad_listener;
    private AdView adview1;
    private AdView adview2;
    private AlertDialog.Builder alert;
    private SharedPreferences data;
    private ImageView imageview3;
    private ImageView imageview4;
    private ImageView imageview_back;
    private ImageView imageview_offline;
    private InterstitialAd interstitial;
    private LinearLayout linear1;
    private LinearLayout linear2;
    private LinearLayout linear3;
    private LinearLayout linear4;
    private LinearLayout linear5;
    private LinearLayout linear6;
    private LinearLayout linear8;
    private LinearLayout linear9;
    private LinearLayout linear_actionbar;
    private LinearLayout linear_bar;
    private LinearLayout linear_container;
    private LinearLayout linear_download;
    private LinearLayout linear_go_drive;
    private TextView textview1;
    private TextView textview2;
    private TextView textview3;
    private TextView textview_download;
    private TextView textview_drive;
    private WebView webview1;
    private String colorPrimary = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    private String colorPrimaryDark = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    private String ColorText = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    private String fileName = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    private String down_path = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    private String BaseUrl = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    private Intent i = new Intent();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.confirmation);
        initialize(bundle);
        initializeLogic();
    }

    private void initialize(Bundle bundle) {
        this.linear5 = (LinearLayout) findViewById(R.id.linear5);
        this.linear1 = (LinearLayout) findViewById(R.id.linear1);
        this.linear_actionbar = (LinearLayout) findViewById(R.id.linear_actionbar);
        this.linear3 = (LinearLayout) findViewById(R.id.linear3);
        this.linear2 = (LinearLayout) findViewById(R.id.linear2);
        this.imageview_back = (ImageView) findViewById(R.id.imageview_back);
        this.linear4 = (LinearLayout) findViewById(R.id.linear4);
        this.imageview_offline = (ImageView) findViewById(R.id.imageview_offline);
        this.textview1 = (TextView) findViewById(R.id.textview1);
        this.textview2 = (TextView) findViewById(R.id.textview2);
        this.webview1 = (WebView) findViewById(R.id.webview1);
        this.webview1.getSettings().setJavaScriptEnabled(true);
        this.webview1.getSettings().setSupportZoom(true);
        this.adview2 = (AdView) findViewById(R.id.adview2);
        this.linear6 = (LinearLayout) findViewById(R.id.linear6);
        this.adview1 = (AdView) findViewById(R.id.adview1);
        this.linear_bar = (LinearLayout) findViewById(R.id.linear_bar);
        this.linear_container = (LinearLayout) findViewById(R.id.linear_container);
        this.linear_go_drive = (LinearLayout) findViewById(R.id.linear_go_drive);
        this.linear8 = (LinearLayout) findViewById(R.id.linear8);
        this.linear_download = (LinearLayout) findViewById(R.id.linear_download);
        this.textview_drive = (TextView) findViewById(R.id.textview_drive);
        this.imageview3 = (ImageView) findViewById(R.id.imageview3);
        this.linear9 = (LinearLayout) findViewById(R.id.linear9);
        this.textview3 = (TextView) findViewById(R.id.textview3);
        this.textview_download = (TextView) findViewById(R.id.textview_download);
        this.imageview4 = (ImageView) findViewById(R.id.imageview4);
        this.alert = new AlertDialog.Builder(this);
        this.data = getSharedPreferences("data", 0);
        this.imageview_back.setOnClickListener(new View.OnClickListener() { // from class: com.arefin.rabindra.ConfirmationActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConfirmationActivity.this.finish();
            }
        });
        this.imageview_offline.setOnClickListener(new View.OnClickListener() { // from class: com.arefin.rabindra.ConfirmationActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConfirmationActivity.this.i.setClass(ConfirmationActivity.this.getApplicationContext(), DownloadedActivity.class);
                ConfirmationActivity.this.startActivity(ConfirmationActivity.this.i);
            }
        });
        this.webview1.setWebViewClient(new WebViewClient() { // from class: com.arefin.rabindra.ConfirmationActivity.3
            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
            }
        });
        this.linear_go_drive.setOnClickListener(new View.OnClickListener() { // from class: com.arefin.rabindra.ConfirmationActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConfirmationActivity.this.i.putExtra(AppMeasurementSdk.ConditionalUserProperty.NAME, ConfirmationActivity.this.getIntent().getStringExtra(AppMeasurementSdk.ConditionalUserProperty.NAME));
                ConfirmationActivity.this.i.putExtra("drive_id", ConfirmationActivity.this.BaseUrl);
                ConfirmationActivity.this.i.setClass(ConfirmationActivity.this.getApplicationContext(), WebviewActivity.class);
                ConfirmationActivity.this.startActivity(ConfirmationActivity.this.i);
            }
        });
        this.linear_download.setOnClickListener(new View.OnClickListener() { // from class: com.arefin.rabindra.ConfirmationActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) ConfirmationActivity.this.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                    ConfirmationActivity.this.showMessage("No Internet Connection");
                    return;
                }
                ConfirmationActivity.this._setDialogFont(ConfirmationActivity.this.alert, "Alert", "আপনি কি \"".concat(ConfirmationActivity.this.getIntent().getStringExtra(AppMeasurementSdk.ConditionalUserProperty.NAME).concat("\" বইটি ডাউনলোড করতে চান?")), "solaimanlipi.ttf");
                ConfirmationActivity.this.alert.setPositiveButton("Download", new DialogInterface.OnClickListener() { // from class: com.arefin.rabindra.ConfirmationActivity.5.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ConfirmationActivity.this.webview1.loadUrl("https://drive.google.com/uc?export=download&id=".concat(ConfirmationActivity.this.BaseUrl));
                    }
                });
                ConfirmationActivity.this.alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() { // from class: com.arefin.rabindra.ConfirmationActivity.5.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                ConfirmationActivity.this.alert.create().show();
            }
        });
        this._interstitial_ad_listener = new AdListener() { // from class: com.arefin.rabindra.ConfirmationActivity.6
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
                ConfirmationActivity.this.interstitial.loadAd(new AdRequest.Builder().build());
            }
        };
    }

    private void initializeLogic() {
        _ColorsOnly();
        _click(this.imageview_back);
        _click(this.imageview_offline);
        this.BaseUrl = getIntent().getStringExtra("content");
        this.fileName = getIntent().getStringExtra(AppMeasurementSdk.ConditionalUserProperty.NAME).concat(".pdf");
        this.down_path = "/Rabindra Samagra/";
        this.webview1.setDownloadListener(new DownloadListener() { // from class: com.arefin.rabindra.ConfirmationActivity.7
            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
                request.addRequestHeader("cookie", CookieManager.getInstance().getCookie(str));
                request.addRequestHeader(HTTP.USER_AGENT, str2);
                request.setDescription("Downloading file...");
                request.setTitle(ConfirmationActivity.this.fileName);
                request.allowScanningByMediaScanner();
                request.setNotificationVisibility(1);
                request.setDestinationInExternalPublicDir(ConfirmationActivity.this.down_path, ConfirmationActivity.this.fileName);
                ((DownloadManager) ConfirmationActivity.this.getSystemService("download")).enqueue(request);
                ConfirmationActivity.this.showMessage("Downloading File....");
                ConfirmationActivity.this.registerReceiver(new BroadcastReceiver() { // from class: com.arefin.rabindra.ConfirmationActivity.7.1
                    @Override // android.content.BroadcastReceiver
                    public void onReceive(Context context, Intent intent) {
                        ConfirmationActivity.this.showMessage("Download Complete!");
                        ConfirmationActivity.this.unregisterReceiver(this);
                    }
                }, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
            }
        });
        this.webview1.getSettings().setJavaScriptEnabled(true);
        _CardStyle(this.linear_actionbar, 5.0d, 0.0d, this.colorPrimary, false);
        _Extra();
        this.adview1.loadAd(new AdRequest.Builder().build());
        this.adview1.setAdListener(new AdListener() { // from class: com.arefin.rabindra.ConfirmationActivity.8
            @Override // com.google.android.gms.ads.AdListener
            public void onAdLoaded() {
                Log.i(com.google.ads.AdRequest.LOGTAG, "onAdLoaded");
                ConfirmationActivity.this.adview1.setVisibility(0);
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdFailedToLoad(int i) {
                Log.i(com.google.ads.AdRequest.LOGTAG, "onAdFailedToLoad");
                ConfirmationActivity.this.adview1.setVisibility(8);
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
        this.adview2.setAdListener(new AdListener() { // from class: com.arefin.rabindra.ConfirmationActivity.9
            @Override // com.google.android.gms.ads.AdListener
            public void onAdLoaded() {
                Log.i(com.google.ads.AdRequest.LOGTAG, "onAdLoaded");
                ConfirmationActivity.this.adview2.setVisibility(0);
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdFailedToLoad(int i) {
                Log.i(com.google.ads.AdRequest.LOGTAG, "onAdFailedToLoad");
                ConfirmationActivity.this.adview2.setVisibility(8);
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
        this.textview1.setText(getIntent().getStringExtra(AppMeasurementSdk.ConditionalUserProperty.NAME));
        this.textview1.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
        this.textview2.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
        this.textview3.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
        this.textview_drive.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
        this.textview_download.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{SupportMenu.CATEGORY_MASK, -16738680});
        gradientDrawable.setCornerRadius(10.0f);
        this.linear_bar.setBackgroundDrawable(gradientDrawable);
        _Card_View(this.linear_go_drive, 10.0d, this.colorPrimary, 0.0d, 0.0d, RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
        _Card_View(this.linear_download, 10.0d, this.colorPrimary, 0.0d, 0.0d, RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
        if (this.data.getString("theme", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED).equals("theme4")) {
            this.imageview_back.setImageResource(R.drawable.ic_arrow_back_white);
            this.imageview_offline.setImageResource(R.drawable.ic_folder_white);
            this.imageview3.setImageResource(R.drawable.ic_chevron_right_white);
            this.imageview4.setImageResource(R.drawable.ic_chevron_right_white);
            Window window = getWindow();
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(Color.parseColor("#006064"));
            window.setNavigationBarColor(Color.parseColor("#FFFFFF"));
            _CardStyle(this.linear1, 0.0d, 0.0d, this.colorPrimaryDark, false);
        } else if (this.data.getString("theme", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED).equals("theme3")) {
            this.imageview_back.setImageResource(R.drawable.ic_arrow_back_white);
            this.imageview_offline.setImageResource(R.drawable.ic_folder_white);
            this.imageview3.setImageResource(R.drawable.ic_chevron_right_white);
            this.imageview4.setImageResource(R.drawable.ic_chevron_right_white);
            Window window2 = getWindow();
            window2.clearFlags(67108864);
            window2.addFlags(Integer.MIN_VALUE);
            window2.setStatusBarColor(Color.parseColor("#FF212121"));
            window2.setNavigationBarColor(Color.parseColor("#FF212121"));
            _CardStyle(this.linear1, 0.0d, 0.0d, this.colorPrimaryDark, false);
        } else if (this.data.getString("theme", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED).equals("theme2")) {
            this.imageview_back.setImageResource(R.drawable.ic_arrow_back_grey);
            this.imageview_offline.setImageResource(R.drawable.ic_folder_grey);
            this.imageview3.setImageResource(R.drawable.ic_arrow_forward_grey);
            this.imageview4.setImageResource(R.drawable.ic_arrow_forward_grey);
            Window window3 = getWindow();
            window3.clearFlags(67108864);
            window3.addFlags(Integer.MIN_VALUE);
            window3.getDecorView().setSystemUiVisibility(8192);
            window3.setStatusBarColor(Color.parseColor("#FFE0B2"));
            window3.setNavigationBarColor(Color.parseColor("#FFE0B2"));
            _CardStyle(this.linear1, 0.0d, 0.0d, this.colorPrimaryDark, false);
        } else {
            this.imageview_back.setImageResource(R.drawable.ic_arrow_back_grey);
            this.imageview_offline.setImageResource(R.drawable.ic_folder_grey);
            this.imageview3.setImageResource(R.drawable.ic_arrow_forward_grey);
            this.imageview4.setImageResource(R.drawable.ic_arrow_forward_grey);
            Window window4 = getWindow();
            window4.clearFlags(67108864);
            window4.addFlags(Integer.MIN_VALUE);
            window4.getDecorView().setSystemUiVisibility(8192);
            window4.setStatusBarColor(Color.parseColor("#FFFFFF"));
            window4.setNavigationBarColor(Color.parseColor("#FFFFFF"));
            _CardStyle(this.linear1, 0.0d, 0.0d, this.colorPrimaryDark, false);
        }
        this.textview1.setTextColor(Color.parseColor(this.ColorText));
        this.textview2.setTextColor(Color.parseColor(this.ColorText));
        this.textview3.setTextColor(Color.parseColor(this.ColorText));
        this.textview_drive.setTextColor(Color.parseColor(this.ColorText));
        this.textview_download.setTextColor(Color.parseColor(this.ColorText));
        this.linear_download.setVisibility(8);
        this.imageview_offline.setVisibility(8);
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
            view.setOnTouchListener(new View.OnTouchListener() { // from class: com.arefin.rabindra.ConfirmationActivity.10
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

    private void _Extra() {
    }

    private void _click(View view) {
        view.setClickable(true);
        view.setBackground(CircleDrawables.getSelectableDrawableFor(Color.parseColor("#212121")));
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

    /* JADX INFO: Access modifiers changed from: private */
    public void _setDialogFont(AlertDialog.Builder builder, String str, String str2, String str3) {
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
