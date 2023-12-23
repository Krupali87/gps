package com.app.gpsphonelocator_new.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.app.gpsphonelocator_new.R;
import com.app.gpsphonelocator_new.adapter.LanguageAdapter;
import com.app.gpsphonelocator_new.databinding.ActivityLanguageSettingBinding;
import com.app.gpsphonelocator_new.extensions.AppExtensionKt;
import com.app.gpsphonelocator_new.phone.model.LanguageModel;
import com.app.gpsphonelocator_new.phone.util.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

public final class LanguageSettingActivity extends BaseActivity<ActivityLanguageSettingBinding> {
    private String codeLang;
    private List<LanguageModel> listLanguage = new ArrayList();

    public static ActivityLanguageSettingBinding access$getMBinding(LanguageSettingActivity languageSettingActivity) {
        return (ActivityLanguageSettingBinding) languageSettingActivity.getMBinding();
    }

    public  String getCodeLang() {
        return this.codeLang;
    }

    public  void setCodeLang(String str) {
        this.codeLang = str;
    }


    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    public ActivityLanguageSettingBinding getViewBinding() {
        ActivityLanguageSettingBinding inflate = ActivityLanguageSettingBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater)");
        return inflate;
    }

    private final void initView() {
        initData();
        Context context = this;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        LanguageAdapter languageAdapter = new LanguageAdapter(context, this.listLanguage, new LanguageSettingActivity$$ExternalSyntheticLambda0(this));
        String valueOf = String.valueOf(AppExtensionKt.getPref(context, Constants.PREFERENCE_SELECTED_LANGUAGE, "en"));
        if (!CollectionsKt.listOf("en", "fr", "pt", "es", "hi").contains(valueOf)) {
            this.codeLang = "en";
        } else {
            this.codeLang = valueOf;
        }
        languageAdapter.setCheck(this.codeLang);
        ActivityLanguageSettingBinding activityLanguageSettingBinding = (ActivityLanguageSettingBinding) getMBinding();
        activityLanguageSettingBinding.rvLanguage.setLayoutManager(linearLayoutManager);
        activityLanguageSettingBinding.rvLanguage.setAdapter(languageAdapter);
        activityLanguageSettingBinding.imgCheck.setOnClickListener(new LanguageSettingActivity$$ExternalSyntheticLambda1(this));
        activityLanguageSettingBinding.imgBack.setOnClickListener(new LanguageSettingActivity$$ExternalSyntheticLambda2(this));

    }

    public static final void initView$lambda$0(LanguageSettingActivity languageSettingActivity, LanguageModel languageModel) {
        Intrinsics.checkNotNullParameter(languageSettingActivity, "this$0");
        languageSettingActivity.codeLang = languageModel.getCode();
    }

    public static final void initView$lambda$3$lambda$1(LanguageSettingActivity languageSettingActivity, View view) {
        Intrinsics.checkNotNullParameter(languageSettingActivity, "this$0");
        Context context = languageSettingActivity;
        AppExtensionKt.setPref(context, Constants.PREFERENCE_SELECTED_LANGUAGE, String.valueOf(languageSettingActivity.codeLang));
        Unit.INSTANCE.toString();
        languageSettingActivity.startActivity(new Intent(context, HomeOptionActivity.class));
        Context applicationContext = languageSettingActivity.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
        AppExtensionKt.setPref(applicationContext, Constants.LANGUAGE_FIRST, false);
        languageSettingActivity.finishAffinity();
    }

    public static final void initView$lambda$3$lambda$2(LanguageSettingActivity languageSettingActivity, View view) {
        Intrinsics.checkNotNullParameter(languageSettingActivity, "this$0");
        languageSettingActivity.onBackPressed();
    }

    private final void initData() {
        this.codeLang = Locale.getDefault().getLanguage();
        this.listLanguage = CollectionsKt.mutableListOf(new LanguageModel("English", "en", false, R.drawable.ic_english), new LanguageModel("Spanish", "es", false, R.drawable.ic_spanish), new LanguageModel("French", "fr", false, R.drawable.ic_france), new LanguageModel("Portuguese", "pt", false, R.drawable.ic_portugal), new LanguageModel("Hindi", "hi", false, R.drawable.ic_india));
        String language = Locale.getDefault().getLanguage();
        int size = this.listLanguage.size();
        for (int i = 0; i < size; i++) {
            if (Intrinsics.areEqual((Object) this.listLanguage.get(i).getCode(), (Object) language)) {
                List<LanguageModel> list = this.listLanguage;
                list.add(0, list.get(i));
                this.listLanguage.remove(i + 1);
            }
        }
    }

}
