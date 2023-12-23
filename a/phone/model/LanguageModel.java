package com.app.gpsphonelocator_new.phone.model;

import android.os.Parcel;
import android.os.Parcelable;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J1\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\t\u0010\u001c\u001a\u00020\bHÖ\u0001J\u0013\u0010\u001d\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\bHÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\bHÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\r¨\u0006'"}, d2 = {"Lcom/phone/number/gpstracker/familylocator/phonetracker/language/LanguageModel;", "Landroid/os/Parcelable;", "languageName", "", "code", "isCheck", "", "image", "", "(Ljava/lang/String;Ljava/lang/String;ZI)V", "getCode", "()Ljava/lang/String;", "setCode", "(Ljava/lang/String;)V", "getImage", "()I", "setImage", "(I)V", "()Z", "setCheck", "(Z)V", "getLanguageName", "setLanguageName", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "APP78_NumberLocator_v1.1.0(110)_Nov.27.2023_productionRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LanguageModel.kt */
public final class LanguageModel implements Parcelable {
    public static final Parcelable.Creator<LanguageModel> CREATOR = new Creator();
    private String code;
    private int image;
    private boolean isCheck;
    private String languageName;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LanguageModel.kt */
    public static final class Creator implements Parcelable.Creator<LanguageModel> {
        public final LanguageModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new LanguageModel(parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt());
        }

        public final LanguageModel[] newArray(int i) {
            return new LanguageModel[i];
        }
    }

    public static /* synthetic */ LanguageModel copy$default(LanguageModel languageModel, String str, String str2, boolean z, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = languageModel.languageName;
        }
        if ((i2 & 2) != 0) {
            str2 = languageModel.code;
        }
        if ((i2 & 4) != 0) {
            z = languageModel.isCheck;
        }
        if ((i2 & 8) != 0) {
            i = languageModel.image;
        }
        return languageModel.copy(str, str2, z, i);
    }

    public final String component1() {
        return this.languageName;
    }

    public final String component2() {
        return this.code;
    }

    public final boolean component3() {
        return this.isCheck;
    }

    public final int component4() {
        return this.image;
    }

    public final LanguageModel copy(String str, String str2, boolean z, int i) {
        Intrinsics.checkNotNullParameter(str, "languageName");
        Intrinsics.checkNotNullParameter(str2, "code");
        return new LanguageModel(str, str2, z, i);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LanguageModel)) {
            return false;
        }
        LanguageModel languageModel = (LanguageModel) obj;
        return Intrinsics.areEqual((Object) this.languageName, (Object) languageModel.languageName) && Intrinsics.areEqual((Object) this.code, (Object) languageModel.code) && this.isCheck == languageModel.isCheck && this.image == languageModel.image;
    }

    public int hashCode() {
        int hashCode = ((this.languageName.hashCode() * 31) + this.code.hashCode()) * 31;
        boolean z = this.isCheck;
        if (z) {
            z = true;
        }
        return ((hashCode + (z ? 1 : 0)) * 31) + Integer.hashCode(this.image);
    }

    public String toString() {
        return "LanguageModel(languageName=" + this.languageName + ", code=" + this.code + ", isCheck=" + this.isCheck + ", image=" + this.image + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.languageName);
        parcel.writeString(this.code);
        parcel.writeInt(this.isCheck ? 1 : 0);
        parcel.writeInt(this.image);
    }

    public LanguageModel(String str, String str2, boolean z, int i) {
        Intrinsics.checkNotNullParameter(str, "languageName");
        Intrinsics.checkNotNullParameter(str2, "code");
        this.languageName = str;
        this.code = str2;
        this.isCheck = z;
        this.image = i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LanguageModel(String str, String str2, boolean z, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i2 & 4) != 0 ? false : z, i);
    }

    public final String getLanguageName() {
        return this.languageName;
    }

    public final void setLanguageName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.languageName = str;
    }

    public final String getCode() {
        return this.code;
    }

    public final void setCode(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.code = str;
    }

    public final boolean isCheck() {
        return this.isCheck;
    }

    public final void setCheck(boolean z) {
        this.isCheck = z;
    }

    public final int getImage() {
        return this.image;
    }

    public final void setImage(int i) {
        this.image = i;
    }
}
