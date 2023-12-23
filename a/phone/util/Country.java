package com.app.gpsphonelocator_new.phone.util;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Country implements Parcelable {
    public static final Creator<Country> CREATOR = new Creator<Country>() {
        public Country createFromParcel(Parcel parcel) {
            return new Country(parcel);
        }

        public Country[] newArray(int i) {
            return new Country[i];
        }
    };
    private String alphabetName;
    private final String code;
    @SerializedName("dial_code")
    private final String dCode;
    private final String name;

    public int describeContents() {
        return 0;
    }

    public Country(String str, String str2, String str3, String str4) {
        this.code = str;
        this.name = str2;
        this.dCode = str3;
        this.alphabetName = str4;
    }

    private Country(Parcel parcel) {
        this.name = parcel.readString();
        this.code = parcel.readString();
        this.dCode = parcel.readString();
        this.alphabetName = parcel.readString();
    }

    public String getName() {
        return this.name;
    }

    public String getCode() {
        return this.code;
    }

    public String getDialCode() {
        return this.dCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.code);
        parcel.writeString(this.dCode);
        parcel.writeString(this.alphabetName);
    }

    public String getAlphabetName() {
        return this.alphabetName;
    }

    public void setAlphabetName(String str) {
        this.alphabetName = str;
    }
}
