package com.app.gpsphonelocator_new.activity;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.view.View;
import androidx.core.graphics.drawable.DrawableKt;
import androidx.fragment.app.FragmentActivity;

import com.app.gpsphonelocator_new.R;
import com.app.gpsphonelocator_new.common.CustomToast;
import com.app.gpsphonelocator_new.databinding.ActivityShareMyLocationQrcodeBinding;
import com.app.gpsphonelocator_new.phone.util.AppUserSingleton;
import com.app.gpsphonelocator_new.phone.util.Constants;
import com.bumptech.glide.Glide;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.journeyapps.barcodescanner.BarcodeEncoder;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;


public final class ShareMyLocationQRCodeActivity extends BaseActivity<ActivityShareMyLocationQrcodeBinding> {
    private String path = "";


    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    public ActivityShareMyLocationQrcodeBinding getViewBinding() {
        ActivityShareMyLocationQrcodeBinding inflate = ActivityShareMyLocationQrcodeBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater)");
        return inflate;
    }

    private final void initView() {
        ((ActivityShareMyLocationQrcodeBinding) getMBinding()).imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intrinsics.checkNotNullParameter(this, "this$0");
                onBackPressed();
            }
        });
        String stringExtra = getIntent().getStringExtra(Constants.SECURITY_CODE);
        if (stringExtra != null) {
            try {
                ((ActivityShareMyLocationQrcodeBinding) getMBinding()).imgQrCode.setImageBitmap(new BarcodeEncoder().createBitmap(new MultiFormatWriter().encode(stringExtra, BarcodeFormat.QR_CODE, 600, 600)));
            } catch (WriterException e) {
                e.printStackTrace();
            }
        }
        ActivityShareMyLocationQrcodeBinding activityShareMyLocationQrcodeBinding = (ActivityShareMyLocationQrcodeBinding) getMBinding();
        activityShareMyLocationQrcodeBinding.cvShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intrinsics.checkNotNullParameter(this, "this$0");
                if (path.length() == 0) {
                    StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().build());
                    saveFile();
                    shareFile();
                } else {
                   shareFile();
                }
            }
        });
        activityShareMyLocationQrcodeBinding.cvSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intrinsics.checkNotNullParameter(this, "this$0");
                if (saveFile()) {
                    CustomToast.Companion.customToast(getString(R.string.save_file_successfully), getApplicationContext());
                }
            }
        });
        activityShareMyLocationQrcodeBinding.cvCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intrinsics.checkNotNullParameter(this, "this$0");
                String stringExtra = getIntent().getStringExtra(Constants.SECURITY_CODE);
                @SuppressLint("WrongConstant") Object systemService = getSystemService("clipboard");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
                ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("Security Code Tracking", stringExtra));
                CustomToast.Companion.customToast(getString(R.string.custom_toast_share_my_location_Copied), getApplicationContext());
            }
        });
    }

    private final boolean saveFile() {
        Drawable drawable = ((ActivityShareMyLocationQrcodeBinding) getMBinding()).imgQrCode.getDrawable();
        Intrinsics.checkNotNullExpressionValue(drawable, "mBinding.imgQrCode.drawable");
        Bitmap bitmap$default = DrawableKt.toBitmap(drawable, 30, 30, (Bitmap.Config) null);
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        String format = String.format("%d.png", Arrays.copyOf(new Object[]{Long.valueOf(System.currentTimeMillis())}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        File file = new File(externalStoragePublicDirectory, format);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            bitmap$default.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            String absolutePath = file.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "outFile.absolutePath");
            this.path = absolutePath;
            fileOutputStream.flush();
            fileOutputStream.close();

            MediaScannerConnection.scanFile(
                    getApplicationContext(),
                    new String[]{file.getAbsolutePath()},
                    null,
                    null
            );

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private final void shareFile() {
        File file = new File(this.path);
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("image/*");
        intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(file));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(Intent.createChooser(intent, "Share Image Via: "));
    }

    private final void setAvatar() {
        Glide.with((FragmentActivity) this).load(AppUserSingleton.getInstance().getAvt()).into(((ActivityShareMyLocationQrcodeBinding) getMBinding()).imgAvatar);
    }

    public void onResume() {
        super.onResume();
        setAvatar();

    }
}
