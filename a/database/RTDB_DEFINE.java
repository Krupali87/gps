package com.app.gpsphonelocator_new.database;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;


    public final class RTDB_DEFINE {
    public static int APPSETTING_MAX_ZONE_ADDED = 3;
    public static double APPSETTING_MIN_DISTANCE_GPS = 20.0d;
    public static int APPSETTING_MIN_TIME_GPS = 10000;
    public static boolean APPSETTING_RUN_BACKGROUND = true;
    public static int APPSETTING_ZONE_RADIUS = 100;
    public static final RTDB_DEFINE INSTANCE = new RTDB_DEFINE();
    public static String TABLE_SAVE_MAIL = "ntd_savedemails";
    public static String TABLE_USER = "ntd_users";
    private static String USERNAME = "username";

    private RTDB_DEFINE() {
    }


    public static final class TBL_USER {
        private static String ADDRESS = "address";
        private static String AVATAR = "avatar";
        private static String EMAIL = "email";
        public static final TBL_USER INSTANCE = new TBL_USER();
        private static String LAT = "latitudes";
        private static String LOG = "longitudes";
        private static String MODEL = "model";
        private static String PHONE = "phone";
        private static String SAVEDEMAIL = "savedemails";
        private static String SHARE = "share";
        private static String SOS = "sos";
        private static String SOSMSG = "sos_msg";
        private static String UID = "uid";


        private TBL_USER() {
        }

        public final String getADDRESS() {
            return ADDRESS;
        }

        public final void setADDRESS(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            ADDRESS = str;
        }

        public final String getAVATAR() {
            return AVATAR;
        }

        public final void setAVATAR(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            AVATAR = str;
        }

        public final String getEMAIL() {
            return EMAIL;
        }

        public final void setEMAIL(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            EMAIL = str;
        }

        public final String getLAT() {
            return LAT;
        }

        public final void setLAT(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            LAT = str;
        }

        public final String getLOG() {
            return LOG;
        }

        public final void setLOG(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            LOG = str;
        }

        public final String getPHONE() {
            return PHONE;
        }

        public final void setPHONE(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            PHONE = str;
        }

        public final String getSAVEDEMAIL() {
            return SAVEDEMAIL;
        }

        public final void setSAVEDEMAIL(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            SAVEDEMAIL = str;
        }

        public final String getSHARE() {
            return SHARE;
        }

        public final void setSHARE(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            SHARE = str;
        }

        public final String getSOS() {
            return SOS;
        }

        public final void setSOS(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            SOS = str;
        }

        public final String getSOSMSG() {
            return SOSMSG;
        }

        public final void setSOSMSG(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            SOSMSG = str;
        }

        public final String getUID() {
            return UID;
        }

        public final void setUID(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            UID = str;
        }

        public final String getMODEL() {
            return MODEL;
        }

        public final void setMODEL(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            MODEL = str;
        }

        public final String getUSERNAME() {
            return TBL_SAVE.USERNAME;
        }

        public final void setUSERNAME(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            USERNAME = str;
        }
    }


    public static final class TBL_SAVE {
        private static String ADDED_TIME = "addedTime";
        private static String ADDRESS = "address";
        private static String AVATAR = "avatar";
        private static String CHECKED = "checked";
        public static final TBL_SAVE INSTANCE = new TBL_SAVE();
        private static String LATITUDES = "latitudes";
        private static String LOCATEPIN = "locatepin";
        private static String LOCATEUID = "locateuid";
        private static String LONGITUDES = "longitudes";
        private static String NICKNAME = "nickname";
        private static String PHONE = "phone";
        private static String PHOTOURI = "photouri";
        private static String SOS = "sos";
        private static String SOS_MSG = "sos_msg";
        private static String USERNAME = "username";

        private TBL_SAVE() {
        }

        public final String getADDED_TIME() {
            return ADDED_TIME;
        }

        public final void setADDED_TIME(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            ADDED_TIME = str;
        }

        public final String getADDRESS() {
            return ADDRESS;
        }

        public final void setADDRESS(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            ADDRESS = str;
        }

        public final String getCHECKED() {
            return CHECKED;
        }

        public final void setCHECKED(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            CHECKED = str;
        }

        public final String getLATITUDES() {
            return LATITUDES;
        }

        public final void setLATITUDES(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            LATITUDES = str;
        }

        public final String getLONGITUDES() {
            return LONGITUDES;
        }

        public final void setLONGITUDES(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            LONGITUDES = str;
        }

        public final String getLOCATEPIN() {
            return LOCATEPIN;
        }

        public final void setLOCATEPIN(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            LOCATEPIN = str;
        }

        public final String getLOCATEUID() {
            return LOCATEUID;
        }

        public final void setLOCATEUID(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            LOCATEUID = str;
        }

        public final String getNICKNAME() {
            return NICKNAME;
        }

        public final void setNICKNAME(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            NICKNAME = str;
        }

        public final String getPHONE() {
            return PHONE;
        }

        public final void setPHONE(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            PHONE = str;
        }

        public final String getPHOTOURI() {
            return PHOTOURI;
        }

        public final void setPHOTOURI(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            PHOTOURI = str;
        }

        public final String getSOS() {
            return SOS;
        }

        public final void setSOS(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            SOS = str;
        }

        public final String getSOS_MSG() {
            return SOS_MSG;
        }

        public final void setSOS_MSG(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            SOS_MSG = str;
        }

        public final String getAVATAR() {
            return AVATAR;
        }

        public final void setAVATAR(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            AVATAR = str;
        }

        public final String getUSERNAME() {
            return USERNAME;
        }

        public final void setUSERNAME(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            USERNAME = str;
        }
    }
}
