package com.app.gpsphonelocator_new.common;

import java.io.Serializable;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b.\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B_\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004¢\u0006\u0002\u0010\u000fJ\u0006\u0010*\u001a\u00020\u0004J\u0006\u0010+\u001a\u00020\u0004J\u0006\u0010,\u001a\u00020\u0004J\u0006\u0010-\u001a\u00020\u0004J\u0006\u0010.\u001a\u00020\u0004J\u0006\u0010/\u001a\u00020\u0004J\u0006\u00100\u001a\u00020\u0004J\u0006\u00101\u001a\u00020\u0004J\u000e\u00102\u001a\u0002032\u0006\u0010\t\u001a\u00020\u0004J\u000e\u00104\u001a\u0002032\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u00105\u001a\u0002032\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u00106\u001a\u0002032\u0006\u0010\u0007\u001a\u00020\u0004J\u000e\u00107\u001a\u0002032\u0006\u0010\u0006\u001a\u00020\u0004J\u000e\u00108\u001a\u0002032\u0006\u0010\b\u001a\u00020\u0004J\u000e\u00109\u001a\u0002032\u0006\u0010\n\u001a\u00020\u0004J\u000e\u0010:\u001a\u0002032\u0006\u0010\u000b\u001a\u00020\u0004R\u001a\u0010\u0010\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001a\u0010\u0018\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u000e\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014R\u000e\u0010\u0006\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0012\"\u0004\b\"\u0010\u0014R\u001a\u0010\r\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0012\"\u0004\b$\u0010\u0014R\u001a\u0010\u000e\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0012\"\u0004\b&\u0010\u0014R\u001a\u0010'\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0012\"\u0004\b)\u0010\u0014R\u000e\u0010\u000b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/phone/number/gpstracker/familylocator/phonetracker/view/common/InforSaved;", "Ljava/io/Serializable;", "()V", "locateemail", "", "locatepin", "nickname", "locateuid", "phone", "checked", "photouri", "username", "sos", "sos_msg", "sosmgs", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "addedTime", "getAddedTime", "()Ljava/lang/String;", "setAddedTime", "(Ljava/lang/String;)V", "address", "getAddress", "setAddress", "avatar", "getAvatar", "setAvatar", "latitudes", "getLatitudes", "setLatitudes", "longitudes", "getLongitudes", "setLongitudes", "getSos", "setSos", "getSos_msg", "setSos_msg", "getSosmgs", "setSosmgs", "uid", "getUid", "setUid", "getchecked", "getlocateemail", "getlocatepin", "getlocateuid", "getnickname", "getphone", "getphotouri", "getusername", "setchecked", "", "setlocateemail", "setlocatepin", "setlocateuid", "setnickname", "setphone", "setphotouri", "setusername", "APP78_NumberLocator_v1.1.0(110)_Nov.27.2023_productionRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: InforSaved.kt */
public final class InforSaved implements Serializable {
    private String addedTime;
    private String address;
    private String avatar;
    private String checked;
    private String latitudes;
    private String locateemail;
    private String locatepin;
    private String locateuid;
    private String longitudes;
    private String nickname;
    private String phone;
    private String photouri;
    private String sos;
    private String sos_msg;
    private String sosmgs;
    private String uid;
    private String username;

    public final String getUid() {
        return this.uid;
    }

    public final void setUid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.uid = str;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final void setAvatar(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.avatar = str;
    }

    public final String getLatitudes() {
        return this.latitudes;
    }

    public final void setLatitudes(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.latitudes = str;
    }

    public final String getLongitudes() {
        return this.longitudes;
    }

    public final void setLongitudes(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.longitudes = str;
    }

    public final String getAddedTime() {
        return this.addedTime;
    }

    public final void setAddedTime(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.addedTime = str;
    }

    public final String getAddress() {
        return this.address;
    }

    public final void setAddress(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.address = str;
    }

    public final String getSos() {
        return this.sos;
    }

    public final void setSos(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sos = str;
    }

    public final String getSos_msg() {
        return this.sos_msg;
    }

    public final void setSos_msg(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sos_msg = str;
    }

    public final String getSosmgs() {
        return this.sosmgs;
    }

    public final void setSosmgs(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sosmgs = str;
    }

    public InforSaved() {
        this.locateemail = "";
        this.locatepin = "";
        this.nickname = "";
        this.locateuid = "";
        this.phone = "";
        this.checked = "";
        this.photouri = "";
        this.username = "";
        this.uid = "";
        this.avatar = "";
        this.latitudes = "";
        this.longitudes = "";
        this.addedTime = "";
        this.address = "";
        this.sos = "";
        this.sos_msg = "";
        this.sosmgs = "";
    }

    public InforSaved(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        Intrinsics.checkNotNullParameter(str, "locateemail");
        Intrinsics.checkNotNullParameter(str2, "locatepin");
        Intrinsics.checkNotNullParameter(str3, "nickname");
        Intrinsics.checkNotNullParameter(str4, "locateuid");
        Intrinsics.checkNotNullParameter(str5, "phone");
        Intrinsics.checkNotNullParameter(str6, "checked");
        Intrinsics.checkNotNullParameter(str7, "photouri");
        Intrinsics.checkNotNullParameter(str9, "sos");
        Intrinsics.checkNotNullParameter(str10, "sos_msg");
        Intrinsics.checkNotNullParameter(str11, "sosmgs");
        this.uid = "";
        this.avatar = "";
        this.latitudes = "";
        this.longitudes = "";
        this.addedTime = "";
        this.address = "";
        this.locateemail = str;
        this.locatepin = str2;
        this.nickname = str3;
        this.checked = str6;
        this.phone = str5;
        this.locateuid = str4;
        this.photouri = str7;
        this.username = str8;
        this.sos = str9;
        this.sos_msg = str10;
        this.sosmgs = str11;
    }

    public final String getlocatepin() {
        return this.locatepin;
    }

    public final void setlocatepin(String str) {
        Intrinsics.checkNotNullParameter(str, "locatepin");
        this.locatepin = str;
    }

    public final String getlocateemail() {
        return this.locateemail;
    }

    public final void setlocateemail(String str) {
        Intrinsics.checkNotNullParameter(str, "locateemail");
        this.locateemail = str;
    }

    public final String getnickname() {
        return this.nickname;
    }

    public final void setnickname(String str) {
        Intrinsics.checkNotNullParameter(str, "nickname");
        this.nickname = str;
    }

    public final String getchecked() {
        return this.checked;
    }

    public final void setchecked(String str) {
        Intrinsics.checkNotNullParameter(str, "checked");
        this.checked = str;
    }

    public final String getlocateuid() {
        return this.locateuid;
    }

    public final void setlocateuid(String str) {
        Intrinsics.checkNotNullParameter(str, "locateuid");
        this.locateuid = str;
    }

    public final String getphotouri() {
        return this.photouri;
    }

    public final void setphotouri(String str) {
        Intrinsics.checkNotNullParameter(str, "photouri");
        this.photouri = str;
    }

    public final String getphone() {
        return this.phone;
    }

    public final void setphone(String str) {
        Intrinsics.checkNotNullParameter(str, "phone");
        this.phone = str;
    }

    public final String getusername() {
        return this.username;
    }

    public final void setusername(String str) {

        this.username = str;
    }
}
