package com.app.gpsphonelocator_new.phone.util;

import android.content.Context;
import android.util.Base64;
import android.util.Log;

import java.security.SecureRandom;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AppAuthen {
    private static final String ENCRYPTION_ALGORITHM = "AES/CBC/PKCS5Padding";
    private static final String TOKEN_KEY = "fqJfdzGDvfwbedsKCZPNz7vxv1DkVvVp";
    private static AppAuthen instance;
    public Context appContext;
    public String user_avt;
    public String user_email;
    public String user_id;
    public String user_private_code;

    public static AppAuthen getInstance() {
        if (instance == null) {
            instance = new AppAuthen();
        }
        return instance;
    }

    public boolean createUser(String str, String str2, Context context) {
        try {
            String encryptv2 = encryptv2(str + "@" + str2);
            decryptv2(encryptv2);
            this.user_email = str;
            this.user_id = encryptv2;
            this.user_private_code = str2;
            ShareReferAuthen.setUserID(context, encryptv2);
            ShareReferAuthen.setUserMail(context, str);
            ShareReferAuthen.setUserPrivateNumber(context, str2);
            Log.d("", "User id = " + this.user_id);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean loginUser(Context context) {
        this.appContext = context;
        String userID = ShareReferAuthen.getUserID(context);
        String userMail = ShareReferAuthen.getUserMail(context);
        String userPrivateNumber = ShareReferAuthen.getUserPrivateNumber(context);
        Log.d("", "User id = " + userID);
        if (userID.isEmpty() || userMail.isEmpty() || userPrivateNumber.isEmpty()) {
            return false;
        }
        this.user_id = userID;
        this.user_email = userMail;
        this.user_private_code = userPrivateNumber;
        return true;
    }

    private boolean getAppAuthUser(Context context) {
        String userID = ShareReferAuthen.getUserID(context);
        String userMail = ShareReferAuthen.getUserMail(context);
        String userPrivateNumber = ShareReferAuthen.getUserPrivateNumber(context);
        Log.d("", "User id = " + userID);
        if (userID.isEmpty()) {
            return false;
        }
        if (userMail.isEmpty()) {
            userMail = "user01@gmail.com";
            ShareReferAuthen.setUserMail(context, userMail);
        } else if (userPrivateNumber.isEmpty()) {
            userPrivateNumber = "12345";
            ShareReferAuthen.setUserPrivateNumber(context, userPrivateNumber);
        }
        this.user_id = userID;
        this.user_email = userMail;
        this.user_private_code = userPrivateNumber;
        return true;
    }

    public AuthUser getCurrentUser() {
        Log.d("", "User id = " + this.user_id);
        String str = this.user_id;
        if (str != null && !str.isEmpty()) {
            return new AuthUser(this.user_id, this.user_email, this.user_avt);
        }
        Context context = this.appContext;
        if (context == null || !getAppAuthUser(context)) {
            return new AuthUser("VbAE0hCXExhhl-cbVUrTP720wehEK0IzkeVDu7GbMQM=", "emptyuser", "file:///android_asset/avatar/avatar1.png");
        }
        return new AuthUser(this.user_id, this.user_email, this.user_avt);
    }

    public static String encryptv2(String str) {
        try {
            byte[] bArr = new byte[16];
            new SecureRandom().nextBytes(bArr);
            Cipher instance2 = Cipher.getInstance(ENCRYPTION_ALGORITHM);
            instance2.init(1, new SecretKeySpec(TOKEN_KEY.getBytes("utf-8"), "AES"), new IvParameterSpec(bArr));
            String encodeToString = Base64.encodeToString(getCombinedArray(bArr, instance2.doFinal(str.getBytes("utf-8"))), 10);
            if (encodeToString != null && encodeToString.length() > 0 && encodeToString.charAt(encodeToString.length() - 1) == 10) {
                encodeToString = encodeToString.substring(0, encodeToString.length() - 1);
            }
            Log.d("decrypt string = ", encodeToString);
            return encodeToString;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String decryptv2(String str) {
        try {
            byte[] decode = Base64.decode(str, 10);
            byte[] copyOfRange = Arrays.copyOfRange(decode, 0, 16);
            byte[] copyOfRange2 = Arrays.copyOfRange(decode, 16, decode.length);
            Cipher instance2 = Cipher.getInstance(ENCRYPTION_ALGORITHM);
            instance2.init(2, new SecretKeySpec(TOKEN_KEY.getBytes("utf-8"), "AES"), new IvParameterSpec(copyOfRange));
            return new String(instance2.doFinal(copyOfRange2), "utf-8");
        } catch (Exception unused) {
            return null;
        }
    }

    private static byte[] getCombinedArray(byte[] bArr, byte[] bArr2) {
        int length = bArr.length + bArr2.length;
        byte[] bArr3 = new byte[length];
        int i = 0;
        while (i < length) {
            bArr3[i] = i < bArr.length ? bArr[i] : bArr2[i - bArr.length];
            i++;
        }
        return bArr3;
    }

    public class AuthUser {
        public String avt;
        public String mail;
        public String uid;

        public AuthUser(String str, String str2, String str3) {
            this.avt = str3;
            this.uid = str;
            this.mail = str2;
        }
    }
}
