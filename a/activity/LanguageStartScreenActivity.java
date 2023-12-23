package com.app.gpsphonelocator_new.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.app.gpsphonelocator_new.R;
import com.app.gpsphonelocator_new.adapter.LanguageAdapter;
import com.app.gpsphonelocator_new.databinding.ActivityLanguageStartBinding;
import com.app.gpsphonelocator_new.extensions.AppExtensionKt;
import com.app.gpsphonelocator_new.phone.model.LanguageModel;
import com.app.gpsphonelocator_new.phone.util.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;


public final class LanguageStartScreenActivity extends BaseActivity<ActivityLanguageStartBinding> {
    private String codeLang;
    private List<LanguageModel> listLanguage = new ArrayList();

    public static final ActivityLanguageStartBinding access$getMBinding(LanguageStartScreenActivity languageStartScreenActivity) {
        return (ActivityLanguageStartBinding) languageStartScreenActivity.getMBinding();
    }

    public final String getCodeLang() {
        return this.codeLang;
    }

    public final void setCodeLang(String str) {
        this.codeLang = str;
    }

    public ActivityLanguageStartBinding getViewBinding() {
        ActivityLanguageStartBinding inflate = ActivityLanguageStartBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater)");
        return inflate;
    }


    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
        Context context = this;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        LanguageAdapter languageAdapter = new LanguageAdapter(context, this.listLanguage, new LanguageStartScreenActivity$$ExternalSyntheticLambda0(this));
        if (!CollectionsKt.listOf("fr", "pt", "es", "hi").contains(Locale.getDefault().getLanguage())) {
            this.codeLang = "en";
        }
        languageAdapter.setCheck(this.codeLang);
        ActivityLanguageStartBinding activityLanguageStartBinding = (ActivityLanguageStartBinding) getMBinding();
        activityLanguageStartBinding.rvLanguage.setLayoutManager(linearLayoutManager);
        activityLanguageStartBinding.rvLanguage.setAdapter(languageAdapter);
        activityLanguageStartBinding.imgCheck.setOnClickListener(new LanguageStartScreenActivity$$ExternalSyntheticLambda1(this));

    }


    public static final void onCreate$lambda$0(LanguageStartScreenActivity languageStartScreenActivity, LanguageModel languageModel) {
        Intrinsics.checkNotNullParameter(languageStartScreenActivity, "this$0");
        languageStartScreenActivity.codeLang = languageModel.getCode();
    }


    public static final void onCreate$lambda$2$lambda$1(LanguageStartScreenActivity languageStartScreenActivity, View view) {
        Intrinsics.checkNotNullParameter(languageStartScreenActivity, "this$0");
        Context context = languageStartScreenActivity;
        AppExtensionKt.setPref(context, Constants.PREFERENCE_SELECTED_LANGUAGE, languageStartScreenActivity.getCodeLang());
        Unit.INSTANCE.toString();
        languageStartScreenActivity.startActivity(new Intent(context, HomeOptionActivity.class));
        Context applicationContext = languageStartScreenActivity.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
        AppExtensionKt.setPref(applicationContext, Constants.LANGUAGE_FIRST, true);
        languageStartScreenActivity.finish();
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
