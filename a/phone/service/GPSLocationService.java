package com.app.gpsphonelocator_new.phone.service;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.media.AudioAttributes;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import android.widget.RemoteViews;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import com.app.gpsphonelocator_new.R;
import com.app.gpsphonelocator_new.activity.MainActivity;
import com.app.gpsphonelocator_new.database.AlertHistoryDao;
import com.app.gpsphonelocator_new.database.AlertHistoryEntity;
import com.app.gpsphonelocator_new.database.AlertZoneEntity;
import com.app.gpsphonelocator_new.database.RTDB_DEFINE;
import com.app.gpsphonelocator_new.database.UserDatabase;
import com.app.gpsphonelocator_new.database.UserTracked;
import com.app.gpsphonelocator_new.database.UserTrackedDao;
import com.app.gpsphonelocator_new.database.ZoneAlertDao;
import com.app.gpsphonelocator_new.extensions.AppExtensionKt;
import com.app.gpsphonelocator_new.phone.util.AppAuthen;
import com.app.gpsphonelocator_new.phone.util.AppUserSingleton;
import com.app.gpsphonelocator_new.phone.util.Constants;
import com.app.gpsphonelocator_new.common.Common;
import com.app.gpsphonelocator_new.common.ExtensionKt;
import com.app.gpsphonelocator_new.common.InforSaved;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import io.card.payment.BuildConfig;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;


public class GPSLocationService extends Service {
    private final Lazy f$delegate = LazyKt.lazy(new Function0<Object>() {
        @Override
        public Object invoke() {
            AppAuthen.AuthUser currentUser = AppAuthen.getInstance().getCurrentUser();
            Intrinsics.checkNotNull(currentUser);
            return currentUser;
        }
    });
    private List<UserTracked> friendList = new ArrayList();

    public double latitude;
    /* access modifiers changed from: private */
    public double longitude;
    private List<AlertZoneEntity> zoneList = CollectionsKt.emptyList();

    public IBinder onBind(Intent intent) {
        return null;
    }

    /* access modifiers changed from: private */
    public final AppAuthen.AuthUser getF() {
        return (AppAuthen.AuthUser) this.f$delegate.getValue();
    }

    @SuppressLint("WrongConstant")
    public int onStartCommand(Intent intent, int i, int i2) {
        Log.d("@@248","map not visible");
        PendingIntent pendingIntent;
        if (intent != null && intent.getBooleanExtra("stop_service", false)) {
            stopSelf();
            return 2;
        } else if (AppAuthen.getInstance().getCurrentUser() == null) {
            return 2;
        } else {
            onTaskRemoved(intent);
            createNotificationChannel();

            Context context = this;
            Intent intent2 = new Intent(context, MainActivity.class);
            if (Build.VERSION.SDK_INT >= 31) {
                pendingIntent = PendingIntent.getActivity(context, 0, intent2, 33554432);
                Intrinsics.checkNotNullExpressionValue(pendingIntent, "{\n                Pendin…AG_MUTABLE)\n            }");
            } else {
                pendingIntent = PendingIntent.getActivity(context, 0, intent2, 1073741824);
                Intrinsics.checkNotNullExpressionValue(pendingIntent, "{\n                Pendin…G_ONE_SHOT)\n            }");
            }
            Notification build = new NotificationCompat.Builder(context, String.valueOf(1)).setContentTitle(getString(R.string.locationService_ContentTitle)).setContentText(getString(R.string.locationService_ContentText)).setSmallIcon((int) R.drawable.ic_app_logo).setContentIntent(pendingIntent).build();
            Intrinsics.checkNotNullExpressionValue(build, "Builder(\n               …ntIntent(pending).build()");
            startForeground(1, build);
            Boolean shareLive = AppUserSingleton.getInstance().getShareLive();
            Intrinsics.checkNotNullExpressionValue(shareLive, "getInstance().shareLive");
            if (shareLive.booleanValue()) {
                updateMyLocation();
            }
            getFriendListData();
            getZoneData();
            trackingAllFriends();
            return 1;
        }
    }


    private final void getFriendListData() {
        UserTrackedDao userDAO;
        UserDatabase.Companion companion = UserDatabase.Companion;
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
        UserDatabase companion2 = companion.getInstance(applicationContext);
        this.friendList = (companion2 == null || (userDAO = companion2.userDAO()) == null) ? null : userDAO.getAllUser();
    }

    private final void getZoneData() {
        ZoneAlertDao zoneDAO;
        UserDatabase.Companion companion = UserDatabase.Companion;
        Context baseContext = getBaseContext();
        Intrinsics.checkNotNullExpressionValue(baseContext, "baseContext");
        UserDatabase companion2 = companion.getInstance(baseContext);
        this.zoneList = (companion2 == null || (zoneDAO = companion2.zoneDAO()) == null) ? null : zoneDAO.getListZone();
    }


    private final void trackingAllFriends() {
        Context baseContext = getBaseContext();
        Intrinsics.checkNotNullExpressionValue(baseContext, "baseContext");
        boolean pref = AppExtensionKt.getPref(baseContext, Constants.NOTIFICATION_ZONE_ALERT, true);
        Context baseContext2 = getBaseContext();
        Intrinsics.checkNotNullExpressionValue(baseContext2, "baseContext");
        boolean pref2 = AppExtensionKt.getPref(baseContext2, Constants.NOTIFICATION_SOS_ALERT, true);
        if (pref || pref2) {
         //   DatabaseReference child = FirebaseDatabase.getInstance().getReference().child(RTDB_DEFINE.TABLE_SAVE_MAIL).child(getF().uid);
           // Intrinsics.checkNotNullExpressionValue(child, "getInstance().reference.…E_SAVE_MAIL).child(f.uid)");
//            child.addListenerForSingleValueEvent(new ValueEventListener() {
//                @Override
//                public void onDataChange(DataSnapshot dataSnapshot) {
//                    Intrinsics.checkNotNullParameter(dataSnapshot, "snapshot");
//                    for (DataSnapshot child : dataSnapshot.getChildren()) {
//                        String valueOf = String.valueOf(child.child(RTDB_DEFINE.TBL_SAVE.INSTANCE.getLOCATEPIN()).getValue());
//                        if (!Intrinsics.areEqual((Object) valueOf, (Object) "null")) {
//                            trackingFriend(valueOf);
//                        }
//                        Log.d("checkingFriendZoneArea", String.valueOf(valueOf));
//                    }
//                }
//
//                @Override
//                public void onCancelled(DatabaseError databaseError) {
//                    Intrinsics.checkNotNullParameter(databaseError, "error");
//                    Log.d("checkingFriendZoneArea", "Error " + databaseError.getMessage());
//                }
//            });
        }
    }

    /* access modifiers changed from: private */
    public final void trackingFriend(String str) {
        DatabaseReference child = FirebaseDatabase.getInstance().getReference().child(RTDB_DEFINE.TABLE_USER).child(str);
        Intrinsics.checkNotNullExpressionValue(child, "getInstance().reference.…LE_USER).child(friendUid)");
        child.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Intrinsics.checkNotNullParameter(dataSnapshot, "snapshot");
                double d = ExtensionKt.toDouble(String.valueOf(dataSnapshot.child(RTDB_DEFINE.TBL_SAVE.INSTANCE.getLATITUDES()).getValue()));
                double d2 = ExtensionKt.toDouble(String.valueOf(dataSnapshot.child(RTDB_DEFINE.TBL_SAVE.INSTANCE.getLONGITUDES()).getValue()));
                boolean parseBoolean = Boolean.parseBoolean(String.valueOf(dataSnapshot.child(RTDB_DEFINE.TBL_SAVE.INSTANCE.getSOS()).getValue()));
                InforSaved inforSaved = (InforSaved) dataSnapshot.getValue(InforSaved.class);
                boolean z = true;
                if (!(d == 0.0d)) {
                    if (d2 != 0.0d) {
                        z = false;
                    }
                    if (!z && inforSaved != null) {
                        if (parseBoolean) {
                            showNotificationSOS(inforSaved.getusername(), inforSaved.getSos_msg());
                        }
                        checkUserLeaveOrEnterZone(d, d2, inforSaved);
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Intrinsics.checkNotNullParameter(databaseError, "error");
                Log.d("trackingFriend", "Error " + databaseError.getMessage());
            }
        });
    }

    public final void checkUserLeaveOrEnterZone(double d, double d2, InforSaved inforSaved) {
        List<AlertZoneEntity> list = this.zoneList;
        if (list != null) {
            for (AlertZoneEntity alertZoneEntity : list) {
                String str = "";
                Location location = new Location(str);
                Double latitude2 = alertZoneEntity.getLatitude();
                Intrinsics.checkNotNull(latitude2);
                location.setLatitude(latitude2.doubleValue());
                Double longitude2 = alertZoneEntity.getLongitude();
                Intrinsics.checkNotNull(longitude2);
                location.setLongitude(longitude2.doubleValue());
                Location location2 = new Location(str);
                location2.setLatitude(ExtensionKt.toDouble(inforSaved.getLatitudes()));
                location2.setLongitude(ExtensionKt.toDouble(inforSaved.getLongitudes()));
                float distanceTo = location.distanceTo(location2);
                int checkHistoryBefore = checkHistoryBefore(alertZoneEntity.getId(), inforSaved.getUid());
                if (distanceTo > ((float) Common.Companion.getZONE_RADIUS())) {
                    if (alertZoneEntity.getOnLeave()) {
                        if (checkHistoryBefore == -1) {
                            saveAlertToDB(alertZoneEntity, inforSaved, false, true);
                        }
                        if (checkHistoryBefore == 1) {
                            saveAlertToDB(alertZoneEntity, inforSaved, false, false);
                            String nickName = getNickName(inforSaved.getUid());
                            String zoneName = (String) alertZoneEntity.getZoneName();
                            if (zoneName != null) {
                                str = zoneName;
                            }
                            showNotificationZone(false, nickName, str);
                        }
                    }
                } else if (distanceTo < ((float) Common.Companion.getZONE_RADIUS()) && alertZoneEntity.getOnEnter()) {
                    if (checkHistoryBefore == -1) {
                        saveAlertToDB(alertZoneEntity, inforSaved, true, true);
                    }
                    if (checkHistoryBefore == 0) {
                        saveAlertToDB(alertZoneEntity, inforSaved, true, false);
                        String nickName2 = getNickName(inforSaved.getUid());
                        String zoneName2 = (String) alertZoneEntity.getZoneName();
                        if (zoneName2 == null) {
                            zoneName2 = str;
                        }
                        showNotificationZone(true, nickName2, zoneName2);
                    }
                    if (checkHistoryBefore == 1) {
                        saveAlertToDB(alertZoneEntity, inforSaved, true, false);
                        String nickName3 = getNickName(inforSaved.getUid());
                        String zoneName3 = (String) alertZoneEntity.getZoneName();
                        if (zoneName3 != null) {
                            str = zoneName3;
                        }
                        showNotificationZone(true, nickName3, str);
                    }
                }
            }
        }
    }

    private final int checkHistoryBefore(int i, String str) {
        AlertHistoryDao alertHistoryDAO;
        UserDatabase companion = UserDatabase.Companion.getInstance(this);
        AlertHistoryEntity firstHistory = (companion == null || (alertHistoryDAO = companion.alertHistoryDAO()) == null) ? null : alertHistoryDAO.getFirstHistory(str, i);
        if (firstHistory == null) {
            return -1;
        }
        return firstHistory.getOnEnter() ? 1 : 0;
    }


    private final void saveAlertToDB(AlertZoneEntity alertZoneEntity, InforSaved inforSaved, boolean z, boolean z2) {
        AlertHistoryDao alertHistoryDAO;
        AlertHistoryEntity alertHistoryEntity = new AlertHistoryEntity(0, alertZoneEntity.getId(), (String) alertZoneEntity.getZoneName(), inforSaved.getUid(), getNickName(inforSaved.getUid()), z, !z, alertZoneEntity.getStatus(), System.currentTimeMillis(), z2);
        UserDatabase.Companion companion = UserDatabase.Companion;
        Context baseContext = getBaseContext();
        Intrinsics.checkNotNullExpressionValue(baseContext, "baseContext");
        UserDatabase instance = companion.getInstance(baseContext);
        if (instance != null && (alertHistoryDAO = instance.alertHistoryDAO()) != null) {
            alertHistoryDAO.insert(alertHistoryEntity);
        }
    }

    private final String getNickName(String str) {
        Object obj;
        String name;
        List<UserTracked> list = this.friendList;
        if (list != null) {
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual(((UserTracked) obj).getUuid(), str)) {
                    break;
                }
            }
            UserTracked userTracked = (UserTracked) obj;
            if (userTracked != null && (name = userTracked.getName()) != null) {
                return name;
            }
        }
        return "";
    }



    @SuppressLint("MissingPermission")
    private final void updateMyLocation() {
        Log.d("TAG", "updateMyLocation is running...");
        if (Build.VERSION.SDK_INT >= 28) {
            @SuppressLint("WrongConstant") Object systemService = getSystemService(FirebaseAnalytics.Param.LOCATION);
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.location.LocationManager");
            LocationManager locationManager = (LocationManager) systemService;
            if (locationManager.isLocationEnabled() && locationManager.isProviderEnabled("gps")) {
                try {
                    locationManager.requestLocationUpdates("gps", Common.Companion.getMIN_TIME_GPS(), Common.Companion.getMIN_DISTANCE_GPS(), new LocationListener() {
                        @Override
                        public void onLocationChanged(@NonNull Location location) {
                            LocationManager lm=null;
                            Intrinsics.checkNotNullParameter(location, "p0");
                            try {
                                @SuppressLint("MissingPermission") Location lastKnownLocation = lm.getLastKnownLocation("gps");
                              //  DatabaseReference child = FirebaseDatabase.getInstance().getReference().child(RTDB_DEFINE.TABLE_USER).child(getF().uid);
                           //     Intrinsics.checkNotNullExpressionValue(child, "getInstance().reference.….TABLE_USER).child(f.uid)");
                                if (lastKnownLocation != null) {
                                    boolean z = true;
                                    if (!(longitude == lastKnownLocation.getLongitude())) {
                                        if (latitude != lastKnownLocation.getLatitude()) {
                                            z = false;
                                        }
                                        if (!z) {
                                            HashMap hashMap = new HashMap();
                                            longitude = lastKnownLocation.getLongitude();
                                            latitude = lastKnownLocation.getLatitude();
                                            hashMap.put(RTDB_DEFINE.TBL_SAVE.INSTANCE.getLATITUDES(), String.valueOf(latitude));
                                            hashMap.put(RTDB_DEFINE.TBL_SAVE.INSTANCE.getLONGITUDES(), String.valueOf(longitude));
                                            GPSLocationService gPSLocationService =GPSLocationService.this;
                                         //   child.updateChildren(hashMap).addOnCompleteListener(new GPSLocationService$updateMyLocation$1$$ExternalSyntheticLambda0());
                                            return;
                                        }
                                    }
                                }
                                Log.d("LOG", "Location the same");
                            } catch (Exception unused) {
                            }
                        }
                    });
                } catch (Exception unused) {
                }
            }
        }
    }

    /* access modifiers changed from: private */
//    public final void syncAddress(double d, double d2) {
//
//        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope((CoroutineContext) Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new GPSLocationService$syncAddress$1(this, d, d2, (Continuation<? super GPSLocationService$syncAddress$1>) null), 3, (Object) null);
//    }

    private final void createNotificationChannel() {
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                @SuppressLint("WrongConstant")
                NotificationChannel notificationChannel = new NotificationChannel("1", "Foreground", 2);
                notificationChannel.setSound((Uri) null, (AudioAttributes) null);
                NotificationManager systemService = getSystemService(NotificationManager.class);
                Intrinsics.checkNotNullExpressionValue(systemService, "getSystemService(NotificationManager::class.java)");
                systemService.createNotificationChannel(notificationChannel);
            }
        } catch (Exception e) {
            Log.d("Exception", e.toString());
        }
    }

    @SuppressLint("WrongConstant")
    private final void showNotificationZone(boolean z, String str, String str2) {
        String str3;
        PendingIntent pendingIntent;
        Context baseContext = getBaseContext();
        Intrinsics.checkNotNullExpressionValue(baseContext, "baseContext");
        if (AppExtensionKt.getPref(baseContext, Constants.NOTIFICATION_ZONE_ALERT, true)) {
            Context context = this;
            AppExtensionKt.setPref(context, Constants.NOTIFICATION_SERVICE, true);
            if (z) {
                str3 = str + " arrived " + str2 + '.';
            } else {
                str3 = str + " has left " + str2 + '.';
            }
            @SuppressLint("RemoteViewLayout") RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.notification_alert_enter);
            CharSequence charSequence = str3;
            remoteViews.setTextViewText(R.id.tvDesc, charSequence);
            if (Build.VERSION.SDK_INT >= 31) {
                pendingIntent = PendingIntent.getActivity(context, 0, new Intent(getApplicationContext(), MainActivity.class), 33554432);
                Intrinsics.checkNotNullExpressionValue(pendingIntent, "{\n            PendingInt…E\n            )\n        }");
            } else {
                pendingIntent = PendingIntent.getActivity(context, 0, new Intent(getApplicationContext(), MainActivity.class), 1140850688);
                Intrinsics.checkNotNullExpressionValue(pendingIntent, "{\n            PendingInt…E\n            )\n        }");
            }
            NotificationCompat.Builder contentIntent = new NotificationCompat.Builder(context, "channel_name").setSmallIcon((int) R.drawable.ic_logo).setContentTitle(str2 + " Zone").setContentText(charSequence).setAutoCancel(true).setContent(remoteViews).setStyle(new NotificationCompat.BigTextStyle()).setSound(RingtoneManager.getDefaultUri(2)).setContentIntent(pendingIntent);
            Intrinsics.checkNotNullExpressionValue(contentIntent, "Builder(this, CHANNEL_ID…tentIntent(pendingIntent)");
            Object systemService = getSystemService("notification");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            NotificationManager notificationManager = (NotificationManager) systemService;
            if (Build.VERSION.SDK_INT >= 26) {
                notificationManager.createNotificationChannel(new NotificationChannel("channel_name", "Channel Name", 4));
            }
            notificationManager.notify((int) (System.currentTimeMillis() / ((long) 1000000)), contentIntent.build());
        }
    }

    /* access modifiers changed from: private */
    @SuppressLint("WrongConstant")
    public final void showNotificationSOS(String str, String str2) {
        PendingIntent pendingIntent;
        Context baseContext = getBaseContext();
        Intrinsics.checkNotNullExpressionValue(baseContext, "baseContext");
        if (AppExtensionKt.getPref(baseContext, Constants.NOTIFICATION_SOS_ALERT, true)) {
            Context context = this;
            AppExtensionKt.setPref(context, Constants.NOTIFICATION_SERVICE, true);
            String str3 = str + " 🆘 " + str2;
            if (str.length() == 0) {
                if (str2.length() == 0) {
                    str3 = "🆘My friend have sos message!!";
                }
            }
            @SuppressLint("RemoteViewLayout") RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.notification_alert_sos);
            CharSequence charSequence = str3;
            remoteViews.setTextViewText(R.id.tvDesc, charSequence);
            if (Build.VERSION.SDK_INT >= 31) {
                pendingIntent = PendingIntent.getActivity(context, 0, new Intent(getApplicationContext(), MainActivity.class), 33554432);
                Intrinsics.checkNotNullExpressionValue(pendingIntent, "{\n            PendingInt…E\n            )\n        }");
            } else {
                pendingIntent = PendingIntent.getActivity(context, 0, new Intent(getApplicationContext(), MainActivity.class), 1140850688);
                Intrinsics.checkNotNullExpressionValue(pendingIntent, "{\n            PendingInt…E\n            )\n        }");
            }
            NotificationCompat.Builder contentIntent = new NotificationCompat.Builder(context, "channel_name").setSmallIcon((int) R.drawable.ic_logo).setContentTitle("SOS Friends").setContentText(charSequence).setAutoCancel(true).setContent(remoteViews).setStyle(new NotificationCompat.BigTextStyle()).setSound(RingtoneManager.getDefaultUri(2)).setContentIntent(pendingIntent);
            Intrinsics.checkNotNullExpressionValue(contentIntent, "Builder(this, CHANNEL_ID…tentIntent(pendingIntent)");
            Object systemService = getSystemService("notification");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            NotificationManager notificationManager = (NotificationManager) systemService;
            if (Build.VERSION.SDK_INT >= 26) {
                notificationManager.createNotificationChannel(new NotificationChannel("channel_name", "Channel Name", 4));
            }
            notificationManager.notify((int) (System.currentTimeMillis() / ((long) 1000000)), contentIntent.build());
        }
    }

    @SuppressLint("WrongConstant")
    public void onTaskRemoved(Intent intent) {
        PendingIntent pendingIntent;
        Class<GPSLocationService> cls = GPSLocationService.class;
        super.onTaskRemoved(intent);
        if (Build.VERSION.SDK_INT >= 31) {
            pendingIntent = PendingIntent.getActivity(this, 0, new Intent(getApplicationContext(), cls), 33554432);
            Intrinsics.checkNotNullExpressionValue(pendingIntent, "{\n            PendingInt…E\n            )\n        }");
        } else {
            pendingIntent = PendingIntent.getActivity(this, 0, new Intent(getApplicationContext(), cls), 1140850688);
            Intrinsics.checkNotNullExpressionValue(pendingIntent, "{\n            PendingInt…E\n            )\n        }");
        }
        @SuppressLint("WrongConstant") Object systemService = getSystemService(NotificationCompat.CATEGORY_ALARM);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.AlarmManager");
        ((AlarmManager) systemService).set(2, 1000, pendingIntent);
    }
}
