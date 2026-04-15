package com.yeasinrabbee.robindodemo;

import android.animation.ObjectAnimator;
import android.app.ActivityManager;
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
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import org.apache.http.cookie.ClientCookie;

/* loaded from: classes.dex */
public class DownloadedActivity extends AppCompatActivity {
    private AdListener _interstitial_ad_listener;
    private AdView adview1;
    private SharedPreferences data;
    private AlertDialog.Builder dia;
    private AlertDialog.Builder dialog;
    private ImageView imageview_alert;
    private ImageView imageview_back;
    private InterstitialAd interstitial;
    private LinearLayout linear1;
    private LinearLayout linear3;
    private LinearLayout linear4;
    private LinearLayout linear_actionbar;
    private LinearLayout linear_nopdf;
    private ListView listview1;
    private TextView textview1;
    private TextView textview2;
    private TextView textview3;
    private TextView textview4;
    private String fontName = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    private String typeace = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    private String colorPrimary = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    private String colorPrimaryDark = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    private String ColorText = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    private double n = 0.0d;
    private String fileName = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    private String filePath = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    private double size = 0.0d;
    private ArrayList<String> down_string = new ArrayList<>();
    private ArrayList<HashMap<String, Object>> map_list = new ArrayList<>();
    private Intent i = new Intent();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.downloaded);
        initialize(bundle);
        if (ContextCompat.checkSelfPermission(this, "android.permission.READ_EXTERNAL_STORAGE") != -1 && ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") != -1) {
            initializeLogic();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 1000);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 1000) {
            initializeLogic();
        }
    }

    private void initialize(Bundle bundle) {
        this.linear1 = (LinearLayout) findViewById(R.id.linear1);
        this.linear_actionbar = (LinearLayout) findViewById(R.id.linear_actionbar);
        this.linear3 = (LinearLayout) findViewById(R.id.linear3);
        this.adview1 = (AdView) findViewById(R.id.adview1);
        this.imageview_back = (ImageView) findViewById(R.id.imageview_back);
        this.linear4 = (LinearLayout) findViewById(R.id.linear4);
        this.textview1 = (TextView) findViewById(R.id.textview1);
        this.textview4 = (TextView) findViewById(R.id.textview4);
        this.listview1 = (ListView) findViewById(R.id.listview1);
        this.textview2 = (TextView) findViewById(R.id.textview2);
        this.linear_nopdf = (LinearLayout) findViewById(R.id.linear_nopdf);
        this.imageview_alert = (ImageView) findViewById(R.id.imageview_alert);
        this.textview3 = (TextView) findViewById(R.id.textview3);
        this.data = getSharedPreferences("data", 0);
        this.dialog = new AlertDialog.Builder(this);
        this.dia = new AlertDialog.Builder(this);
        this.imageview_back.setOnClickListener(new View.OnClickListener() { // from class: com.arefin.rabindra.DownloadedActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DownloadedActivity.this.finish();
            }
        });
        this.listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.arefin.rabindra.DownloadedActivity.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (((HashMap) DownloadedActivity.this.map_list.get(i)).get("File").toString().endsWith(".pdf")) {
                    DownloadedActivity.this.i.putExtra(AppMeasurementSdk.ConditionalUserProperty.NAME, Uri.parse(((HashMap) DownloadedActivity.this.map_list.get(i)).get("File").toString()).getLastPathSegment());
                    DownloadedActivity.this.i.putExtra(ClientCookie.PATH_ATTR, ((HashMap) DownloadedActivity.this.map_list.get(i)).get("File").toString());
                    DownloadedActivity.this.i.setClass(DownloadedActivity.this.getApplicationContext(), PdfPageActivity.class);
                    DownloadedActivity.this.startActivity(DownloadedActivity.this.i);
                    return;
                }
                DownloadedActivity.this.i.putExtra(AppMeasurementSdk.ConditionalUserProperty.NAME, Uri.parse(((HashMap) DownloadedActivity.this.map_list.get(i)).get("File").toString()).getLastPathSegment());
                DownloadedActivity.this.i.putExtra(ClientCookie.PATH_ATTR, ((HashMap) DownloadedActivity.this.map_list.get(i)).get("File").toString());
                DownloadedActivity.this.i.setClass(DownloadedActivity.this.getApplicationContext(), PdfPageActivity.class);
                DownloadedActivity.this.startActivity(DownloadedActivity.this.i);
            }
        });
        this.listview1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.arefin.rabindra.DownloadedActivity.3
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long j) {
                DownloadedActivity.this.size = FileUtil.getFileLength(((HashMap) DownloadedActivity.this.map_list.get(i)).get("File").toString());
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                ((ActivityManager) DownloadedActivity.this.getSystemService("activity")).getMemoryInfo(memoryInfo);
                long j2 = memoryInfo.availMem / 1048576;
                int log10 = (int) (Math.log10(DownloadedActivity.this.size) / Math.log10(1024.0d));
                DownloadedActivity.this.textview2.setText(String.valueOf(new DecimalFormat("#,##0.#").format(DownloadedActivity.this.size / Math.pow(1024.0d, log10))) + " " + new String[]{"B", "KB", "MB", "GB", "TB"}[log10]);
                DownloadedActivity.this.dia.setTitle("Book Informations");
                DownloadedActivity.this.dia.setMessage("Book name : ".concat(Uri.parse(((HashMap) DownloadedActivity.this.map_list.get(i)).get("File").toString()).getLastPathSegment().substring(0, Uri.parse(((HashMap) DownloadedActivity.this.map_list.get(i)).get("File").toString()).getLastPathSegment().length() - 4)).concat("\n\nBook Size : ".concat(DownloadedActivity.this.textview2.getText().toString()).concat("\n\nBook Path : ".concat(((HashMap) DownloadedActivity.this.map_list.get(i)).get("File").toString()))));
                DownloadedActivity.this.dia.setPositiveButton("Delete", new DialogInterface.OnClickListener() { // from class: com.arefin.rabindra.DownloadedActivity.3.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        FileUtil.deleteFile(((HashMap) DownloadedActivity.this.map_list.get(i)).get("File").toString());
                        DownloadedActivity.this.map_list.remove(i);
                        ((BaseAdapter) DownloadedActivity.this.listview1.getAdapter()).notifyDataSetChanged();
                        SketchwareUtil.showMessage(DownloadedActivity.this.getApplicationContext(), "Book Deleted ");
                    }
                });
                DownloadedActivity.this.dia.setNegativeButton("Cancel", new DialogInterface.OnClickListener() { // from class: com.arefin.rabindra.DownloadedActivity.3.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
                DownloadedActivity.this.dia.create().show();
                return true;
            }
        });
        this._interstitial_ad_listener = new AdListener() { // from class: com.arefin.rabindra.DownloadedActivity.4
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
                DownloadedActivity.this.interstitial.loadAd(new AdRequest.Builder().build());
            }
        };
    }

    private void initializeLogic() {
        _ColorsOnly();
        this.adview1.loadAd(new AdRequest.Builder().build());
        this.adview1.setAdListener(new AdListener() { // from class: com.arefin.rabindra.DownloadedActivity.5
            @Override // com.google.android.gms.ads.AdListener
            public void onAdLoaded() {
                Log.i(com.google.ads.AdRequest.LOGTAG, "onAdLoaded");
                DownloadedActivity.this.adview1.setVisibility(0);
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdFailedToLoad(int i) {
                Log.i(com.google.ads.AdRequest.LOGTAG, "onAdFailedToLoad");
                DownloadedActivity.this.adview1.setVisibility(8);
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
        this.textview1.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
        this.textview2.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
        this.textview3.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
        this.textview4.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
        if (!FileUtil.isExistFile(FileUtil.getExternalStorageDir().concat("/Rabindra Samagra/"))) {
            FileUtil.makeDir(FileUtil.getExternalStorageDir().concat("/Rabindra Samagra/"));
        }
        FileUtil.listDir(FileUtil.getExternalStorageDir().concat("/Rabindra Samagra/"), this.down_string);
        this.n = 0.0d;
        for (int i = 0; i < this.down_string.size(); i++) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("File", this.down_string.get((int) this.n));
            this.map_list.add(hashMap);
            this.n += 1.0d;
        }
        this.listview1.setAdapter((ListAdapter) new Listview1Adapter(this.map_list));
        ((BaseAdapter) this.listview1.getAdapter()).notifyDataSetChanged();
        if (this.down_string.size() == 0) {
            this.listview1.setVisibility(8);
            this.linear_nopdf.setVisibility(0);
            ((BaseAdapter) this.listview1.getAdapter()).notifyDataSetChanged();
        } else {
            this.listview1.setVisibility(0);
            this.linear_nopdf.setVisibility(8);
            ((BaseAdapter) this.listview1.getAdapter()).notifyDataSetChanged();
        }
        _CardStyle(this.linear_actionbar, 5.0d, 0.0d, this.colorPrimary, false);
        if (this.data.getString("theme", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED).equals("theme4")) {
            Window window = getWindow();
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(Color.parseColor("#006064"));
            window.setNavigationBarColor(Color.parseColor("#FFFFFF"));
            this.imageview_back.setImageResource(R.drawable.ic_arrow_back_white);
            this.imageview_alert.setImageResource(R.drawable.ic_warning_grey);
            _CardStyle(this.linear1, 0.0d, 0.0d, this.colorPrimaryDark, false);
        } else if (this.data.getString("theme", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED).equals("theme3")) {
            Window window2 = getWindow();
            window2.clearFlags(67108864);
            window2.addFlags(Integer.MIN_VALUE);
            window2.setStatusBarColor(Color.parseColor("#FF212121"));
            window2.setNavigationBarColor(Color.parseColor("#FF212121"));
            this.imageview_back.setImageResource(R.drawable.ic_arrow_back_white);
            this.imageview_alert.setImageResource(R.drawable.ic_cloud_download_white);
            _CardStyle(this.linear1, 0.0d, 0.0d, this.colorPrimaryDark, false);
        } else if (this.data.getString("theme", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED).equals("theme2")) {
            Window window3 = getWindow();
            window3.clearFlags(67108864);
            window3.addFlags(Integer.MIN_VALUE);
            window3.getDecorView().setSystemUiVisibility(8192);
            window3.setStatusBarColor(Color.parseColor("#FFE0B2"));
            window3.setNavigationBarColor(Color.parseColor("#FFE0B2"));
            this.imageview_back.setImageResource(R.drawable.ic_arrow_back_grey);
            this.imageview_alert.setImageResource(R.drawable.ic_warning_grey);
            _CardStyle(this.linear1, 0.0d, 0.0d, this.colorPrimaryDark, false);
        } else {
            Window window4 = getWindow();
            window4.clearFlags(67108864);
            window4.addFlags(Integer.MIN_VALUE);
            window4.getDecorView().setSystemUiVisibility(8192);
            window4.setStatusBarColor(Color.parseColor("#FFFFFF"));
            window4.setNavigationBarColor(Color.parseColor("#FFFFFF"));
            this.imageview_back.setImageResource(R.drawable.ic_arrow_back_grey);
            this.imageview_alert.setImageResource(R.drawable.ic_warning_grey);
            _CardStyle(this.linear1, 0.0d, 0.0d, this.colorPrimary, false);
        }
        this.textview1.setTextColor(Color.parseColor(this.ColorText));
        this.textview2.setTextColor(Color.parseColor(this.ColorText));
        this.textview3.setTextColor(Color.parseColor(this.ColorText));
        this.textview4.setTextColor(Color.parseColor(this.ColorText));
        _click(this.imageview_back);
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

    private void _click(View view) {
        view.setClickable(true);
        view.setBackground(CircleDrawables.getSelectableDrawableFor(Color.parseColor("#212121")));
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

    private void _CardStyle(final View view, double d, double d2, String str, boolean z) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor(str));
        gradientDrawable.setCornerRadius((int) d2);
        view.setBackground(gradientDrawable);
        if (Build.VERSION.SDK_INT >= 21) {
            view.setElevation((int) d);
        }
        if (z) {
            view.setOnTouchListener(new View.OnTouchListener() { // from class: com.arefin.rabindra.DownloadedActivity.6
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
            LayoutInflater layoutInflater = (LayoutInflater) DownloadedActivity.this.getBaseContext().getSystemService("layout_inflater");
            if (view == null) {
                view = layoutInflater.inflate(R.layout.custom_down, (ViewGroup) null);
            }
            ImageView imageView = (ImageView) view.findViewById(R.id.imageview1);
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.linear2);
            ImageView imageView2 = (ImageView) view.findViewById(R.id.imageview2);
            TextView textView = (TextView) view.findViewById(R.id.textview1);
            TextView textView2 = (TextView) view.findViewById(R.id.textview2);
            textView.setText(Uri.parse(((HashMap) DownloadedActivity.this.map_list.get(i)).get("File").toString()).getLastPathSegment());
            textView.setTypeface(Typeface.createFromAsset(DownloadedActivity.this.getAssets(), "fonts/solaimanlipi.ttf"), 0);
            DownloadedActivity.this.size = FileUtil.getFileLength(((HashMap) DownloadedActivity.this.map_list.get(i)).get("File").toString());
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) DownloadedActivity.this.getSystemService("activity")).getMemoryInfo(memoryInfo);
            long j = memoryInfo.availMem / 1048576;
            int log10 = (int) (Math.log10(DownloadedActivity.this.size) / Math.log10(1024.0d));
            textView2.setText(String.valueOf(new DecimalFormat("#,##0.#").format(DownloadedActivity.this.size / Math.pow(1024.0d, log10))) + " " + new String[]{"B", "KB", "MB", "GB", "TB"}[log10]);
            new RippleDrawable(new ColorStateList(new int[][]{new int[0]}, new int[]{Color.parseColor("#BDBDBD")}), new ColorDrawable(-1), null);
            Animation loadAnimation = AnimationUtils.loadAnimation(DownloadedActivity.this.getApplicationContext(), 17432578);
            loadAnimation.setDuration(200L);
            ((LinearLayout) view.findViewById(R.id.linear1)).startAnimation(loadAnimation);
            if (!DownloadedActivity.this.data.getString("theme", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED).equals("theme4")) {
                if (!DownloadedActivity.this.data.getString("theme", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED).equals("theme3")) {
                    if (DownloadedActivity.this.data.getString("theme", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED).equals("theme2")) {
                        imageView2.setImageResource(R.drawable.ic_arrow_forward_grey);
                        textView.setTextColor(Color.parseColor(DownloadedActivity.this.ColorText));
                        textView2.setTextColor(Color.parseColor(DownloadedActivity.this.ColorText));
                    } else {
                        imageView2.setImageResource(R.drawable.ic_arrow_forward_grey);
                        textView.setTextColor(Color.parseColor(DownloadedActivity.this.ColorText));
                        textView2.setTextColor(Color.parseColor(DownloadedActivity.this.ColorText));
                    }
                } else {
                    imageView2.setImageResource(R.drawable.ic_chevron_right_white);
                    textView.setTextColor(Color.parseColor(DownloadedActivity.this.ColorText));
                    textView2.setTextColor(Color.parseColor(DownloadedActivity.this.ColorText));
                }
            } else {
                imageView2.setImageResource(R.drawable.ic_arrow_forward_grey);
                textView.setTextColor(Color.parseColor("#000000"));
                textView2.setTextColor(Color.parseColor("#000000"));
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
