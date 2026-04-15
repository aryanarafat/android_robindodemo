package com.yeasinrabbee.robindodemo;

import android.animation.ObjectAnimator;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.pdf.PdfRenderer;
import android.os.Build;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import org.apache.http.cookie.ClientCookie;

/* loaded from: classes.dex */
public class PdfPageActivity extends AppCompatActivity {
    private AdListener _interstitial_ad_listener;
    private AdView adview1;
    private SharedPreferences data;
    private AlertDialog.Builder dialog;
    private ImageView imageview_back;
    private ImageView imageview_back_page;
    private ImageView imageview_front_page;
    private ImageView imageview_jump;
    private InterstitialAd interstitial;
    private LinearLayout linear1;
    private LinearLayout linear3;
    private LinearLayout linear4;
    private LinearLayout linear_actionbar;
    private LinearLayout linear_back_page;
    private LinearLayout linear_counter;
    private LinearLayout linear_front_page;
    private LinearLayout linear_jump;
    private LinearLayout linear_toolbar;
    private PdfRenderer renderer;
    private TextView textview1;
    private TextView textview2;
    private TextView textview3;
    private TextView textview4;
    ZoomableImageView touch;
    private String string = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    private double pageCount = 0.0d;
    private double page = 0.0d;
    private String colorPrimary = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    private String colorPrimaryDark = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    private String ColorText = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    private String pdfFile = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pdf_page);
        initialize(bundle);
        initializeLogic();
    }

    private void initialize(Bundle bundle) {
        this.linear1 = (LinearLayout) findViewById(R.id.linear1);
        this.linear_actionbar = (LinearLayout) findViewById(R.id.linear_actionbar);
        this.linear3 = (LinearLayout) findViewById(R.id.linear3);
        this.adview1 = (AdView) findViewById(R.id.adview1);
        this.linear_toolbar = (LinearLayout) findViewById(R.id.linear_toolbar);
        this.imageview_back = (ImageView) findViewById(R.id.imageview_back);
        this.linear4 = (LinearLayout) findViewById(R.id.linear4);
        this.linear_jump = (LinearLayout) findViewById(R.id.linear_jump);
        this.textview3 = (TextView) findViewById(R.id.textview3);
        this.textview4 = (TextView) findViewById(R.id.textview4);
        this.imageview_jump = (ImageView) findViewById(R.id.imageview_jump);
        this.linear_back_page = (LinearLayout) findViewById(R.id.linear_back_page);
        this.linear_counter = (LinearLayout) findViewById(R.id.linear_counter);
        this.linear_front_page = (LinearLayout) findViewById(R.id.linear_front_page);
        this.imageview_back_page = (ImageView) findViewById(R.id.imageview_back_page);
        this.textview2 = (TextView) findViewById(R.id.textview2);
        this.textview1 = (TextView) findViewById(R.id.textview1);
        this.imageview_front_page = (ImageView) findViewById(R.id.imageview_front_page);
        this.data = getSharedPreferences("data", 0);
        this.dialog = new AlertDialog.Builder(this);
        this.imageview_back.setOnClickListener(new View.OnClickListener() { // from class: com.arefin.rabindra.PdfPageActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PdfPageActivity.this.interstitial.show();
                PdfPageActivity.this.finish();
            }
        });
        this.linear_jump.setOnClickListener(new View.OnClickListener() { // from class: com.arefin.rabindra.PdfPageActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PdfPageActivity.this._Edittext_AlertDialog();
            }
        });
        this.linear_back_page.setOnClickListener(new View.OnClickListener() { // from class: com.arefin.rabindra.PdfPageActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PdfPageActivity.this.page > 0.0d) {
                    PdfPageActivity.this.page -= 1.0d;
                    PdfPageActivity.this._display(PdfPageActivity.this.page);
                }
            }
        });
        this.linear_front_page.setOnClickListener(new View.OnClickListener() { // from class: com.arefin.rabindra.PdfPageActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PdfPageActivity.this.page < PdfPageActivity.this.pageCount - 1.0d) {
                    PdfPageActivity.this.page += 1.0d;
                    PdfPageActivity.this._display(PdfPageActivity.this.page);
                }
            }
        });
        this._interstitial_ad_listener = new AdListener() { // from class: com.arefin.rabindra.PdfPageActivity.5
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
                PdfPageActivity.this.interstitial.loadAd(new AdRequest.Builder().build());
            }
        };
    }

    private void initializeLogic() {
        _ColorsOnly();
        this.touch = new ZoomableImageView(this);
        this.linear3.addView(this.touch);
        if (!getIntent().getStringExtra(ClientCookie.PATH_ATTR).equals("null") && !getIntent().getStringExtra(ClientCookie.PATH_ATTR).equals(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED)) {
            this.textview3.setText(getIntent().getStringExtra(AppMeasurementSdk.ConditionalUserProperty.NAME));
            this.pdfFile = getIntent().getStringExtra(ClientCookie.PATH_ATTR);
            this.page = 0.0d;
            try {
                this.renderer = new PdfRenderer(new ParcelFileDescriptor(ParcelFileDescriptor.open(new File(this.pdfFile), 268435456)));
                this.pageCount = this.renderer.getPageCount();
                _display(this.page);
                this.textview1.setText(String.valueOf((long) this.pageCount));
            } catch (Exception e) {
            }
        } else {
            SketchwareUtil.showMessage(getApplicationContext(), "Empty !");
        }
        _click(this.imageview_back);
        _click(this.linear_back_page);
        _click(this.linear_front_page);
        _click(this.linear_jump);
        this.interstitial = new InterstitialAd(getApplicationContext());
        this.interstitial.setAdListener(this._interstitial_ad_listener);
        this.interstitial.setAdUnitId("ca-app-pub-8700028746384810/3694838553");
        this.interstitial.loadAd(new AdRequest.Builder().build());
        this.adview1.loadAd(new AdRequest.Builder().build());
        this.adview1.setAdListener(new AdListener() { // from class: com.arefin.rabindra.PdfPageActivity.6
            @Override // com.google.android.gms.ads.AdListener
            public void onAdLoaded() {
                Log.i(com.google.ads.AdRequest.LOGTAG, "onAdLoaded");
                PdfPageActivity.this.adview1.setVisibility(0);
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdFailedToLoad(int i) {
                Log.i(com.google.ads.AdRequest.LOGTAG, "onAdFailedToLoad");
                PdfPageActivity.this.adview1.setVisibility(8);
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
        this.textview3.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
        this.textview4.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/solaimanlipi.ttf"), 0);
        _CardStyle(this.linear_actionbar, 8.0d, 0.0d, this.colorPrimary, false);
        _CardStyle(this.linear_toolbar, 8.0d, 0.0d, this.colorPrimary, false);
        if (this.data.getString("theme", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED).equals("theme4")) {
            this.imageview_back.setImageResource(R.drawable.ic_chevron_left_white);
            this.imageview_jump.setImageResource(R.drawable.ic_launch_white);
            this.imageview_back_page.setImageResource(R.drawable.ic_arrow_back_white);
            this.imageview_front_page.setImageResource(R.drawable.ic_arrow_forward_white);
            Window window = getWindow();
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(Color.parseColor("#006064"));
            window.setNavigationBarColor(Color.parseColor("#006064"));
            _CardStyle(this.linear1, 0.0d, 0.0d, "#EEEEEE", false);
        } else if (this.data.getString("theme", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED).equals("theme3")) {
            this.imageview_back.setImageResource(R.drawable.ic_chevron_left_white);
            this.imageview_jump.setImageResource(R.drawable.ic_launch_white);
            this.imageview_back_page.setImageResource(R.drawable.ic_arrow_back_white);
            this.imageview_front_page.setImageResource(R.drawable.ic_arrow_forward_white);
            Window window2 = getWindow();
            window2.clearFlags(67108864);
            window2.addFlags(Integer.MIN_VALUE);
            window2.setStatusBarColor(Color.parseColor("#FF212121"));
            window2.setNavigationBarColor(Color.parseColor("#FF212121"));
            _CardStyle(this.linear1, 0.0d, 0.0d, "#EEEEEE", false);
        } else if (this.data.getString("theme", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED).equals("theme2")) {
            this.imageview_back.setImageResource(R.drawable.ic_chevron_left_grey);
            this.imageview_jump.setImageResource(R.drawable.ic_launch_grey);
            this.imageview_back_page.setImageResource(R.drawable.ic_arrow_back_grey);
            this.imageview_front_page.setImageResource(R.drawable.ic_arrow_forward_grey);
            Window window3 = getWindow();
            window3.clearFlags(67108864);
            window3.addFlags(Integer.MIN_VALUE);
            window3.getDecorView().setSystemUiVisibility(8192);
            window3.setStatusBarColor(Color.parseColor("#FFE0B2"));
            window3.setNavigationBarColor(Color.parseColor("#FFE0B2"));
            _CardStyle(this.linear1, 0.0d, 0.0d, this.colorPrimaryDark, false);
        } else {
            this.imageview_back.setImageResource(R.drawable.ic_chevron_left_grey);
            this.imageview_jump.setImageResource(R.drawable.ic_launch_grey);
            this.imageview_back_page.setImageResource(R.drawable.ic_arrow_back_grey);
            this.imageview_front_page.setImageResource(R.drawable.ic_arrow_forward_grey);
            Window window4 = getWindow();
            window4.clearFlags(67108864);
            window4.addFlags(Integer.MIN_VALUE);
            window4.getDecorView().setSystemUiVisibility(8192);
            window4.setStatusBarColor(Color.parseColor("#FFFFFF"));
            window4.setNavigationBarColor(Color.parseColor("#FFFFFF"));
            _CardStyle(this.linear1, 0.0d, 0.0d, this.colorPrimary, false);
        }
        this.textview1.setTextColor(Color.parseColor(this.ColorText));
        this.textview2.setTextColor(Color.parseColor(this.ColorText));
        this.textview3.setTextColor(Color.parseColor(this.ColorText));
        this.textview4.setTextColor(Color.parseColor(this.ColorText));
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

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.interstitial.show();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        this.interstitial.show();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _Edittext_AlertDialog() {
        this.dialog.setTitle("Jump to .  .  .");
        this.dialog.setMessage("Enter Page Number");
        final EditText editText = new EditText(this);
        editText.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.dialog.setView(editText);
        editText.setInputType(2);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RectShape());
        shapeDrawable.getPaint().setColor(Color.parseColor("#2196F3"));
        shapeDrawable.getPaint().setStyle(Paint.Style.STROKE);
        shapeDrawable.getPaint().setStrokeWidth(3.0f);
        editText.setBackground(shapeDrawable);
        this.dialog.setPositiveButton("Jump", new DialogInterface.OnClickListener() { // from class: com.arefin.rabindra.PdfPageActivity.7
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                String editable = editText.getText().toString();
                if (!editable.equals(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED) && Double.parseDouble(editable) > 0.0d && Double.parseDouble(editable) < PdfPageActivity.this.pageCount + 1.0d) {
                    PdfPageActivity.this.page = Double.parseDouble(editable) - 1.0d;
                    PdfPageActivity.this._display(PdfPageActivity.this.page);
                }
            }
        });
        this.dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() { // from class: com.arefin.rabindra.PdfPageActivity.8
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        this.dialog.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _display(double d) {
        PdfRenderer.Page openPage = this.renderer.openPage((int) d);
        Bitmap createBitmap = Bitmap.createBitmap((getResources().getDisplayMetrics().densityDpi * openPage.getWidth()) / 72, (getResources().getDisplayMetrics().densityDpi * openPage.getHeight()) / 72, Bitmap.Config.ARGB_8888);
        openPage.render(createBitmap, null, null, 1);
        this.touch.setImageBitmap(createBitmap);
        openPage.close();
        this.textview2.setText(String.valueOf((long) (1.0d + d)).concat(" of "));
    }

    private void _extra() {
    }

    /* loaded from: classes.dex */
    public class ZoomableImageView extends ImageView {
        static final int CLICK = 3;
        static final int DRAG = 1;
        static final int NONE = 0;
        static final int ZOOM = 2;
        float bmHeight;
        float bmWidth;
        float bottom;
        Context context;
        float height;
        PointF last;
        float[] m;
        ScaleGestureDetector mScaleDetector;
        Matrix matrix;
        float maxScale;
        float minScale;
        int mode;
        float origHeight;
        float origWidth;
        float redundantXSpace;
        float redundantYSpace;
        float right;
        float saveScale;
        PointF start;
        float width;

        public ZoomableImageView(Context context) {
            super(context);
            this.matrix = new Matrix();
            this.mode = 0;
            this.last = new PointF();
            this.start = new PointF();
            this.minScale = 1.0f;
            this.maxScale = 4.0f;
            this.saveScale = 1.0f;
            super.setClickable(true);
            this.context = context;
            this.mScaleDetector = new ScaleGestureDetector(context, new ScaleListener(this, null));
            this.matrix.setTranslate(1.0f, 1.0f);
            this.m = new float[9];
            setImageMatrix(this.matrix);
            setScaleType(ScaleType.MATRIX);
            setOnTouchListener(new OnTouchListener() { // from class: com.arefin.rabindra.PdfPageActivity.ZoomableImageView.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    ZoomableImageView.this.mScaleDetector.onTouchEvent(motionEvent);
                    ZoomableImageView.this.matrix.getValues(ZoomableImageView.this.m);
                    float f = ZoomableImageView.this.m[2];
                    float f2 = ZoomableImageView.this.m[5];
                    PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
                    switch (motionEvent.getAction()) {
                        case 0:
                            ZoomableImageView.this.last.set(motionEvent.getX(), motionEvent.getY());
                            ZoomableImageView.this.start.set(ZoomableImageView.this.last);
                            ZoomableImageView.this.mode = 1;
                            break;
                        case 1:
                            ZoomableImageView.this.mode = 0;
                            int abs = (int) Math.abs(pointF.x - ZoomableImageView.this.start.x);
                            int abs2 = (int) Math.abs(pointF.y - ZoomableImageView.this.start.y);
                            if (abs < 3 && abs2 < 3) {
                                ZoomableImageView.this.performClick();
                                break;
                            }
                            break;
                        case 2:
                            if (ZoomableImageView.this.mode == 2 || (ZoomableImageView.this.mode == 1 && ZoomableImageView.this.saveScale > ZoomableImageView.this.minScale)) {
                                float f3 = pointF.x - ZoomableImageView.this.last.x;
                                float f4 = pointF.y - ZoomableImageView.this.last.y;
                                float round = Math.round(ZoomableImageView.this.origHeight * ZoomableImageView.this.saveScale);
                                if (Math.round(ZoomableImageView.this.origWidth * ZoomableImageView.this.saveScale) < ZoomableImageView.this.width) {
                                    if (f2 + f4 > 0.0f) {
                                        f4 = -f2;
                                        f3 = 0.0f;
                                    } else if (f2 + f4 < (-ZoomableImageView.this.bottom)) {
                                        f4 = -(ZoomableImageView.this.bottom + f2);
                                        f3 = 0.0f;
                                    } else {
                                        f3 = 0.0f;
                                    }
                                } else if (round < ZoomableImageView.this.height) {
                                    if (f + f3 > 0.0f) {
                                        f3 = -f;
                                        f4 = 0.0f;
                                    } else if (f + f3 < (-ZoomableImageView.this.right)) {
                                        f3 = -(ZoomableImageView.this.right + f);
                                        f4 = 0.0f;
                                    } else {
                                        f4 = 0.0f;
                                    }
                                } else {
                                    if (f + f3 > 0.0f) {
                                        f3 = -f;
                                    } else if (f + f3 < (-ZoomableImageView.this.right)) {
                                        f3 = -(ZoomableImageView.this.right + f);
                                    }
                                    if (f2 + f4 > 0.0f) {
                                        f4 = -f2;
                                    } else if (f2 + f4 < (-ZoomableImageView.this.bottom)) {
                                        f4 = -(ZoomableImageView.this.bottom + f2);
                                    }
                                }
                                ZoomableImageView.this.matrix.postTranslate(f3, f4);
                                ZoomableImageView.this.last.set(pointF.x, pointF.y);
                                break;
                            }
                            break;
                        case 5:
                            ZoomableImageView.this.last.set(motionEvent.getX(), motionEvent.getY());
                            ZoomableImageView.this.start.set(ZoomableImageView.this.last);
                            ZoomableImageView.this.mode = 2;
                            break;
                        case 6:
                            ZoomableImageView.this.mode = 0;
                            break;
                    }
                    ZoomableImageView.this.setImageMatrix(ZoomableImageView.this.matrix);
                    ZoomableImageView.this.invalidate();
                    return true;
                }
            });
        }

        @Override // android.widget.ImageView
        public void setImageBitmap(Bitmap bitmap) {
            super.setImageBitmap(bitmap);
            this.bmWidth = bitmap.getWidth();
            this.bmHeight = bitmap.getHeight();
        }

        public void setMaxZoom(float f) {
            this.maxScale = f;
        }

        /* loaded from: classes.dex */
        private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
            private ScaleListener() {
            }

            /* synthetic */ ScaleListener(ZoomableImageView zoomableImageView, ScaleListener scaleListener) {
                this();
            }

            @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
                ZoomableImageView.this.mode = 2;
                return true;
            }

            @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                float f = ZoomableImageView.this.saveScale;
                ZoomableImageView.this.saveScale *= scaleFactor;
                if (ZoomableImageView.this.saveScale > ZoomableImageView.this.maxScale) {
                    ZoomableImageView.this.saveScale = ZoomableImageView.this.maxScale;
                    scaleFactor = ZoomableImageView.this.maxScale / f;
                } else if (ZoomableImageView.this.saveScale < ZoomableImageView.this.minScale) {
                    ZoomableImageView.this.saveScale = ZoomableImageView.this.minScale;
                    scaleFactor = ZoomableImageView.this.minScale / f;
                }
                ZoomableImageView.this.right = ((ZoomableImageView.this.width * ZoomableImageView.this.saveScale) - ZoomableImageView.this.width) - ((ZoomableImageView.this.redundantXSpace * 2.0f) * ZoomableImageView.this.saveScale);
                ZoomableImageView.this.bottom = ((ZoomableImageView.this.height * ZoomableImageView.this.saveScale) - ZoomableImageView.this.height) - ((ZoomableImageView.this.redundantYSpace * 2.0f) * ZoomableImageView.this.saveScale);
                if (ZoomableImageView.this.origWidth * ZoomableImageView.this.saveScale <= ZoomableImageView.this.width || ZoomableImageView.this.origHeight * ZoomableImageView.this.saveScale <= ZoomableImageView.this.height) {
                    ZoomableImageView.this.matrix.postScale(scaleFactor, scaleFactor, ZoomableImageView.this.width / 2.0f, ZoomableImageView.this.height / 2.0f);
                    if (scaleFactor < 1.0f) {
                        ZoomableImageView.this.matrix.getValues(ZoomableImageView.this.m);
                        float f2 = ZoomableImageView.this.m[2];
                        float f3 = ZoomableImageView.this.m[5];
                        if (scaleFactor < 1.0f) {
                            if (Math.round(ZoomableImageView.this.origWidth * ZoomableImageView.this.saveScale) < ZoomableImageView.this.width) {
                                if (f3 >= (-ZoomableImageView.this.bottom)) {
                                    if (f3 > 0.0f) {
                                        ZoomableImageView.this.matrix.postTranslate(0.0f, -f3);
                                        return true;
                                    }
                                    return true;
                                }
                                ZoomableImageView.this.matrix.postTranslate(0.0f, -(ZoomableImageView.this.bottom + f3));
                                return true;
                            } else if (f2 >= (-ZoomableImageView.this.right)) {
                                if (f2 > 0.0f) {
                                    ZoomableImageView.this.matrix.postTranslate(-f2, 0.0f);
                                    return true;
                                }
                                return true;
                            } else {
                                ZoomableImageView.this.matrix.postTranslate(-(f2 + ZoomableImageView.this.right), 0.0f);
                                return true;
                            }
                        }
                        return true;
                    }
                    return true;
                }
                ZoomableImageView.this.matrix.postScale(scaleFactor, scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
                ZoomableImageView.this.matrix.getValues(ZoomableImageView.this.m);
                float f4 = ZoomableImageView.this.m[2];
                float f5 = ZoomableImageView.this.m[5];
                if (scaleFactor < 1.0f) {
                    if (f4 < (-ZoomableImageView.this.right)) {
                        ZoomableImageView.this.matrix.postTranslate(-(f4 + ZoomableImageView.this.right), 0.0f);
                    } else if (f4 > 0.0f) {
                        ZoomableImageView.this.matrix.postTranslate(-f4, 0.0f);
                    }
                    if (f5 >= (-ZoomableImageView.this.bottom)) {
                        if (f5 > 0.0f) {
                            ZoomableImageView.this.matrix.postTranslate(0.0f, -f5);
                            return true;
                        }
                        return true;
                    }
                    ZoomableImageView.this.matrix.postTranslate(0.0f, -(ZoomableImageView.this.bottom + f5));
                    return true;
                }
                return true;
            }
        }

        @Override // android.widget.ImageView, android.view.View
        protected void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            this.width = MeasureSpec.getSize(i);
            this.height = MeasureSpec.getSize(i2);
            float min = Math.min(this.width / this.bmWidth, this.height / this.bmHeight);
            this.matrix.setScale(min, min);
            setImageMatrix(this.matrix);
            this.saveScale = 1.0f;
            this.redundantYSpace = this.height - (this.bmHeight * min);
            this.redundantXSpace = this.width - (min * this.bmWidth);
            this.redundantYSpace /= 2.0f;
            this.redundantXSpace /= 2.0f;
            this.matrix.postTranslate(this.redundantXSpace, this.redundantYSpace);
            this.origWidth = this.width - (this.redundantXSpace * 2.0f);
            this.origHeight = this.height - (this.redundantYSpace * 2.0f);
            this.right = ((this.width * this.saveScale) - this.width) - ((this.redundantXSpace * 2.0f) * this.saveScale);
            this.bottom = ((this.height * this.saveScale) - this.height) - ((this.redundantYSpace * 2.0f) * this.saveScale);
            setImageMatrix(this.matrix);
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
            view.setOnTouchListener(new View.OnTouchListener() { // from class: com.arefin.rabindra.PdfPageActivity.9
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
