    package com.app.gpsphonelocator_new.activity;

    import android.annotation.SuppressLint;
    import android.app.AlertDialog;
    import android.content.Context;
    import android.location.Address;
    import android.location.Geocoder;
    import android.location.Location;
    import android.location.LocationManager;
    import android.os.Build;
    import android.os.Bundle;
    import android.os.Handler;
    import android.os.Looper;
    import android.util.DisplayMetrics;
    import android.util.Log;
    import android.util.TypedValue;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.Window;
    import android.widget.EditText;
    import android.widget.ImageView;
    import android.widget.TextView;

    import androidx.annotation.NonNull;
    import androidx.appcompat.widget.AppCompatCheckBox;
    import androidx.appcompat.widget.SearchView;
    import androidx.constraintlayout.widget.ConstraintLayout;
    import androidx.core.view.InputDeviceCompat;
    import androidx.fragment.app.Fragment;

    import com.app.gpsphonelocator_new.R;
    import com.app.gpsphonelocator_new.common.Common;
    import com.app.gpsphonelocator_new.common.CustomToast;
    import com.app.gpsphonelocator_new.common.ExtensionKt;
    import com.app.gpsphonelocator_new.database.AlertZoneEntity;
    import com.app.gpsphonelocator_new.database.UserDatabase;
    import com.app.gpsphonelocator_new.database.ZoneAlertDao;
    import com.app.gpsphonelocator_new.databinding.ActivityCreateZoneAlertBinding;
    import com.app.gpsphonelocator_new.databinding.DialogInputZoneNameBinding;
    import com.app.gpsphonelocator_new.phone.util.AppAuthen;
    import com.google.android.gms.maps.CameraUpdateFactory;
    import com.google.android.gms.maps.GoogleMap;
    import com.google.android.gms.maps.OnMapReadyCallback;
    import com.google.android.gms.maps.SupportMapFragment;
    import com.google.android.gms.maps.model.LatLng;
    import com.google.firebase.analytics.FirebaseAnalytics;

    import java.io.Serializable;
    import java.util.List;
    import java.util.Locale;

    import kotlin.Unit;
    import kotlin.collections.CollectionsKt;
    import kotlin.jvm.functions.Function0;
    import kotlin.jvm.functions.Function1;
    import kotlin.jvm.internal.Intrinsics;
    import kotlin.text.StringsKt;
    import mumayank.com.airlocationlibrary.AirLocation;


    public final class CreateZoneActivity extends BaseActivity<ActivityCreateZoneAlertBinding> implements OnMapReadyCallback {
        private AirLocation airloc;

        public AlertZoneEntity alertZone;

        public List<AlertZoneEntity> alertZoneList = CollectionsKt.emptyList();
        private AppAuthen.AuthUser appUser;
        private LatLng currentLocation = new LatLng(0.0d, 0.0d);
        private GoogleMap googleMap;
        private boolean isSafe = true;

        public boolean isUpdate;

        public double lat;

        public double lng;



       public  DialogInputZoneNameBinding dialogInputZoneNameBinding;


        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            requestLocationPermission();

            initMap();
            getData();
            initView();


            this.appUser = AppAuthen.getInstance().getCurrentUser();
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intrinsics.checkNotNullParameter(this, "this$0");
                    ExtensionKt.hideKeyboard(CreateZoneActivity.this);
                }
            }, 1000);
        }




        public void onLocationPermissionGranted() {
            initMap();
        }

        private final void getData() {
            this.isUpdate = getIntent().getBooleanExtra("is_update", false);
            Serializable serializableExtra = getIntent().getSerializableExtra("zone_data");
            this.alertZone = serializableExtra instanceof AlertZoneEntity ? (AlertZoneEntity) serializableExtra : null;
        }


        public void onResume() {
            super.onResume();
            if (!this.isUpdate) {
                getMyLocatiton();
            }

        }

        private final void getAlertZoneDB() {
            List<AlertZoneEntity> list;
            ZoneAlertDao zoneDAO;
            UserDatabase.Companion companion = UserDatabase.Companion;
            Context baseContext = getBaseContext();
            Intrinsics.checkNotNullExpressionValue(baseContext, "baseContext");
            UserDatabase instance = companion.getInstance(baseContext);
            if (instance == null || (zoneDAO = instance.zoneDAO()) == null || (list = zoneDAO.getListZone()) == null) {
                list = CollectionsKt.emptyList();
            }
            this.alertZoneList = list;
        }

        public ActivityCreateZoneAlertBinding getViewBinding() {
            ActivityCreateZoneAlertBinding inflate = ActivityCreateZoneAlertBinding.inflate(getLayoutInflater());
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater)");
            return inflate;
        }

        @SuppressLint("WrongConstant")
        private final void initView() {
            ActivityCreateZoneAlertBinding activityCreateZoneAlertBinding = (ActivityCreateZoneAlertBinding) getMBinding();
            TextView textView = activityCreateZoneAlertBinding.tvDelete;
            Intrinsics.checkNotNullExpressionValue(textView, "tvDelete");
            textView.setVisibility(this.isUpdate ? 0 : 8);
            activityCreateZoneAlertBinding.tvSafe.setBackgroundResource(R.drawable.bg_safe_zone);
            activityCreateZoneAlertBinding.etNameZone.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intrinsics.checkNotNullParameter(this, "this$0");
                    Intrinsics.checkNotNullParameter(activityCreateZoneAlertBinding, "$this_apply");
                    Context context = CreateZoneActivity.this;
                    DialogInputZoneNameBinding inflate = DialogInputZoneNameBinding.inflate(LayoutInflater.from(context));
                    Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.f…this@CreateZoneActivity))");
                    AlertDialog alertDialog = new AlertDialog.Builder(context).setView(inflate.getRoot()).show();
                    Intrinsics.checkNotNullExpressionValue(alertDialog, "dialog");
                    ExtensionKt.initLayout$default(alertDialog, context, 0.0f, 2, (Object) null);
                    boolean z = true;
                    alertDialog.setCancelable(true);
                    if (alertZone != null && isUpdate) {
                        EditText editText = inflate.etNameZone;
                        AlertZoneEntity alertZoneEntity = alertZone;
                        Intrinsics.checkNotNull(alertZoneEntity);
                        editText.setText(alertZoneEntity.getZoneName());
                    }
                    CharSequence text = activityCreateZoneAlertBinding.etNameZone.getText();

                    Intrinsics.checkNotNullExpressionValue(text, "etNameZone.text");
                    if (text.length() <= 0) {
                        z = false;
                    }
                    if (z) {
                        activityCreateZoneAlertBinding.etNameZone.setText(inflate.etNameZone.getText().toString());

                    }

                    inflate.cvCancel.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (!isFinishing()) {
                                alertDialog.dismiss();
                                Window window = getWindow();
                                Intrinsics.checkNotNull(window);
                                window.getDecorView().setSystemUiVisibility(InputDeviceCompat.SOURCE_TOUCHSCREEN);
                            }
                        }
                    });
                    inflate.cvSend.setOnClickListener(view1 -> {
                        if (!isFinishing()) {
                            AlertDialog alertDog = new AlertDialog.Builder(context).create();
                            dialogInputZoneNameBinding = DialogInputZoneNameBinding.inflate(LayoutInflater.from(context));
                            activityCreateZoneAlertBinding.etNameZone.setText(inflate.etNameZone.getText());
                            ExtensionKt.hideKeyboard(CreateZoneActivity.this);
                                alertDialog.dismiss();
                            Window window = getWindow();
                            Intrinsics.checkNotNull(window);
                            window.getDecorView().setSystemUiVisibility(InputDeviceCompat.SOURCE_TOUCHSCREEN);
                        }
                    });
                    Window window = alertDialog.getWindow();
                    Intrinsics.checkNotNull(window);
                    window.getDecorView().setSystemUiVisibility(InputDeviceCompat.SOURCE_TOUCHSCREEN);
                }
            });
            if (this.alertZone == null || !this.isUpdate) {
                activityCreateZoneAlertBinding.layoutUpdate.setVisibility(8);
                activityCreateZoneAlertBinding.cvSaveZone.setVisibility(0);
            } else {
                activityCreateZoneAlertBinding.layoutUpdate.setVisibility(0);
                activityCreateZoneAlertBinding.cvSaveZone.setVisibility(8);
                TextView textView2 = activityCreateZoneAlertBinding.etNameZone;
                AlertZoneEntity alertZoneEntity = this.alertZone;
                Intrinsics.checkNotNull(alertZoneEntity);
                textView2.setText(alertZoneEntity.getZoneName());
                AlertZoneEntity alertZoneEntity2 = this.alertZone;
                Intrinsics.checkNotNull(alertZoneEntity2);
                if (alertZoneEntity2.getStatus() == 1) {
                    checkZoneType(true);
                } else {
                    checkZoneType(false);
                }
                AppCompatCheckBox appCompatCheckBox = activityCreateZoneAlertBinding.cbEnter;
                AlertZoneEntity alertZoneEntity3 = this.alertZone;
                Intrinsics.checkNotNull(alertZoneEntity3);
                appCompatCheckBox.setChecked(alertZoneEntity3.getOnEnter());
                AppCompatCheckBox appCompatCheckBox2 = activityCreateZoneAlertBinding.cbLeave;
                AlertZoneEntity alertZoneEntity4 = this.alertZone;
                Intrinsics.checkNotNull(alertZoneEntity4);
                appCompatCheckBox2.setChecked(alertZoneEntity4.getOnLeave());
                AlertZoneEntity alertZoneEntity5 = this.alertZone;
                Intrinsics.checkNotNull(alertZoneEntity5);
                Double latitude = alertZoneEntity5.getLatitude();
                double d = 0.0d;
                this.lat = latitude != null ? latitude.doubleValue() : 0.0d;
                AlertZoneEntity alertZoneEntity6 = this.alertZone;
                Intrinsics.checkNotNull(alertZoneEntity6);
                Double longitude = alertZoneEntity6.getLongitude();
                if (longitude != null) {
                    d = longitude.doubleValue();
                }
                this.lng = d;
            }
            ImageView imageView = activityCreateZoneAlertBinding.imgBackView;
            Intrinsics.checkNotNullExpressionValue(imageView, "imgBackView");
            ExtensionKt.setOnSingleClickListener(imageView, new Function1<View, Unit>() {
                @Override
                public Unit invoke(View view) {
                    onBackPressed();
                    return Unit.INSTANCE;
                }
            });
            TextView textView3 = activityCreateZoneAlertBinding.btnSaveZone;
            Intrinsics.checkNotNullExpressionValue(textView3, "btnSaveZone");
            ExtensionKt.setOnSingleClickListener(textView3, new Function1<View, Unit>() {
                @Override
                public Unit invoke(View view) {
                    if (!isNetworkAvailable()) {
                        CustomToast.Companion.customToast(getString(R.string.custom_toast_create_zone_No_internet), getApplicationContext());
                    } else if (!isValidateData()) {
                        CustomToast.Companion.customToast(getString(R.string.custom_toast_create_zone_inter_Zone_name), getApplicationContext());
                    } else if (alertZoneList.size() < Common.Companion.getMAX_ZONE_ADDED() ||isUpdate) {
                        saveDataToDB();
                    } else {
                       // CustomToast.Companion.customToast(getString(R.string.custom_toast_create_zone_Maximum1) + Common.Companion.getMAX_ZONE_ADDED() + getString(R.string.custom_toast_create_zone_Maximum2), getApplicationContext());
                    }
                    return Unit.INSTANCE;
                }

            });
            TextView textView4 = activityCreateZoneAlertBinding.tvUpdate;
            Intrinsics.checkNotNullExpressionValue(textView4, "tvUpdate");
            ExtensionKt.setOnSingleClickListener(textView4, new Function1<View, Unit>() {
                @Override
                public Unit invoke(View view) {
                    if (!isNetworkAvailable()) {
                        CustomToast.Companion.customToast(getString(R.string.custom_toast_create_zone_No_internet),getApplicationContext() );
                    } else if (!isValidateData()) {
                        CustomToast.Companion.customToast(getString(R.string.custom_toast_create_zone_inter_Zone_name), getApplicationContext());
                    } else if (alertZoneList.size() < Common.Companion.getMAX_ZONE_ADDED() || isUpdate) {
                        saveDataToDB();
                    } else {
                        CustomToast.Companion.customToast(getString(R.string.custom_toast_create_zone_Maximum1) + Common.Companion.getMAX_ZONE_ADDED() +getString(R.string.custom_toast_create_zone_Maximum2), getApplicationContext());

                    }
                    return Unit.INSTANCE;
                }
            });
            activityCreateZoneAlertBinding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    Intrinsics.checkNotNullParameter(query, "query");
                    searchLocationByName(query);
                    ExtensionKt.hideKeyboard(CreateZoneActivity.this);
                    activityCreateZoneAlertBinding.searchView.clearFocus();
                    return true;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    Intrinsics.checkNotNullParameter(newText, "newText");
                    return false;
                }
            });
            View findViewById = activityCreateZoneAlertBinding.searchView.findViewById(R.id.searchView);
            Intrinsics.checkNotNullExpressionValue(findViewById, "searchView.findViewById(…at.R.id.search_close_btn)");
            findViewById.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intrinsics.checkNotNullParameter(this, "this$0");
                    Intrinsics.checkNotNullParameter(activityCreateZoneAlertBinding, "$this_apply");
                    ExtensionKt.hideKeyboard(CreateZoneActivity.this);
                    activityCreateZoneAlertBinding.searchView.setQuery("", false);
                    activityCreateZoneAlertBinding.searchView.clearFocus();
                    searchLocationByName("");
                }
            });
            TextView textView5 = activityCreateZoneAlertBinding.tvSafe;
            Intrinsics.checkNotNullExpressionValue(textView5, "tvSafe");
            ExtensionKt.setOnSingleClickListener(textView5, new Function1<View, Unit>() {
                @Override
                public Unit invoke(View view) {
                    checkZoneType(true);
                    return Unit.INSTANCE;
                }
            });
            TextView textView6 = activityCreateZoneAlertBinding.tvDanger;
            Intrinsics.checkNotNullExpressionValue(textView6, "tvDanger");
            ExtensionKt.setOnSingleClickListener(textView6, new Function1<View, Unit>() {
                @Override
                public Unit invoke(View view) {
                   checkZoneType(false);
                    return Unit.INSTANCE;
                }
            });
            ConstraintLayout constraintLayout = activityCreateZoneAlertBinding.btnDeleteZone;
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "btnDeleteZone");
            ExtensionKt.setOnSingleClickListener(constraintLayout, new Function1<View, Unit>() {
                @Override
                public Unit invoke(View view) {
                    ExtensionKt.showDeleteDialog$default(CreateZoneActivity.this, new Function0<Unit>() {
                        public final Unit invoke() {
                            ZoneAlertDao zoneDAO;
                            if (!isNetworkAvailable()) {
                                CustomToast.Companion.customToast(getString(R.string.custom_toast_create_zone_No_internet), getApplicationContext());
                            } else if (alertZone != null) {
                                UserDatabase.Companion companion = UserDatabase.Companion;
                                Context baseContext = getBaseContext();
                                Intrinsics.checkNotNullExpressionValue(baseContext, "baseContext");
                                UserDatabase instance = companion.getInstance(baseContext);
                                if (!(instance == null || (zoneDAO = instance.zoneDAO()) == null)) {
                                    AlertZoneEntity access$getAlertZone$p = alertZone;
                                    Intrinsics.checkNotNull(access$getAlertZone$p);
                                    zoneDAO.delete(access$getAlertZone$p);
                                }
                                CustomToast.Companion.customToast(getString(R.string.custom_toast_create_zone_Delete_success), getApplicationContext());
                                onBackPressed();
                            }
                            return Unit.INSTANCE;
                        }
                    }, (Function0) null, 2, (Object) null);
                    return Unit.INSTANCE;

                }
            });
        }

        @SuppressLint("WrongConstant")
        private final float dpToPx(float f) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            Intrinsics.checkNotNullExpressionValue(displayMetrics, "resources.displayMetrics");
            return TypedValue.applyDimension(1, f, displayMetrics);
        }


        public final void saveDataToDB() {
            ZoneAlertDao zoneDAO;
            ZoneAlertDao zoneDAO2;
            String obj = StringsKt.trim((CharSequence) ((ActivityCreateZoneAlertBinding) getMBinding()).etNameZone.getText().toString()).toString();
            CharSequence charSequence = obj;
            if ((charSequence.length() == 0) || StringsKt.isBlank(charSequence)) {
                CustomToast.Companion.customToast(getString(R.string.custom_toast_create_zone_Zone_name_invalid), this);
                return;
            }
            String address = getAddress();
            if (this.isUpdate) {
                AlertZoneEntity alertZoneEntity = this.alertZone;
                Intrinsics.checkNotNull(alertZoneEntity);
                AlertZoneEntity alertZoneEntity2 = new AlertZoneEntity(alertZoneEntity.getId(), obj, Double.valueOf(this.currentLocation.latitude), Double.valueOf(this.currentLocation.longitude), address, ((ActivityCreateZoneAlertBinding) getMBinding()).cbEnter.isChecked(), ((ActivityCreateZoneAlertBinding) getMBinding()).cbLeave.isChecked(), this.isSafe ? 1 : 0, Common.Companion.getZONE_RADIUS());
                UserDatabase.Companion companion = UserDatabase.Companion;
                Context baseContext = getBaseContext();
                Intrinsics.checkNotNullExpressionValue(baseContext, "baseContext");
                UserDatabase instance = companion.getInstance(baseContext);
                if (!(instance == null || (zoneDAO2 = instance.zoneDAO()) == null)) {
                    zoneDAO2.update(alertZoneEntity2);
                }
            } else {
                AlertZoneEntity alertZoneEntity3 = new AlertZoneEntity(0, obj, Double.valueOf(this.currentLocation.latitude), Double.valueOf(this.currentLocation.longitude), address, ((ActivityCreateZoneAlertBinding) getMBinding()).cbEnter.isChecked(), ((ActivityCreateZoneAlertBinding) getMBinding()).cbLeave.isChecked(), this.isSafe ? 1 : 0, Common.Companion.getZONE_RADIUS());
                UserDatabase.Companion companion2 = UserDatabase.Companion;
                Context baseContext2 = getBaseContext();
                Intrinsics.checkNotNullExpressionValue(baseContext2, "baseContext");
                UserDatabase instance2 = companion2.getInstance(baseContext2);
                if (!(instance2 == null || (zoneDAO = instance2.zoneDAO()) == null)) {
                    zoneDAO.insert(alertZoneEntity3);
                }
            }
            finish();
        }


        public final boolean isValidateData() {
            return ((ActivityCreateZoneAlertBinding) getMBinding()).etNameZone.getText().toString().length() > 0;
        }


        public final void checkZoneType(boolean z) {
            ActivityCreateZoneAlertBinding activityCreateZoneAlertBinding = (ActivityCreateZoneAlertBinding) getMBinding();
            if (z) {
                activityCreateZoneAlertBinding.imgZone.setImageResource(R.drawable.vector_zone_safe);
                activityCreateZoneAlertBinding.tvSafe.setBackgroundResource(R.drawable.bg_safe_zone);
                activityCreateZoneAlertBinding.tvDanger.setBackgroundResource(R.drawable.bg_safe_non_select);
                activityCreateZoneAlertBinding.imgMarker.setImageResource(R.drawable.ic_marker_zone_safe);
            } else {
                activityCreateZoneAlertBinding.imgZone.setImageResource(R.drawable.vector_zone_danger);
                activityCreateZoneAlertBinding.tvSafe.setBackgroundResource(R.drawable.bg_safe_non_select);
                activityCreateZoneAlertBinding.tvDanger.setBackgroundResource(R.drawable.bg_danger_zone);
                activityCreateZoneAlertBinding.imgMarker.setImageResource(R.drawable.ic_marker_zone_danger);
            }
            this.isSafe = z;
        }

        private final void initMap() {
            Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.fragment);
            Intrinsics.checkNotNull(findFragmentById, "null cannot be cast to non-null type com.google.android.gms.maps.SupportMapFragment");
            ((SupportMapFragment) findFragmentById).getMapAsync(this);
        }

        @SuppressLint("MissingPermission")
        private final void getMyLocatiton() {
            Location lastKnownLocation;
            if (isLocationPermissionGranted()) {
                @SuppressLint("WrongConstant") Object systemService = getSystemService(FirebaseAnalytics.Param.LOCATION);
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.location.LocationManager");
                LocationManager locationManager = (LocationManager) systemService;
                if (Build.VERSION.SDK_INT >= 28 && locationManager.isLocationEnabled() && locationManager.isProviderEnabled("gps") && (lastKnownLocation = locationManager.getLastKnownLocation("gps")) != null) {
                    this.lng = lastKnownLocation.getLongitude();
                    double latitude = lastKnownLocation.getLatitude();
                    this.lat = latitude;
                    moveToLocation(latitude, this.lng);
                }
            }
        }

        public void onMapReady(GoogleMap googleMap2) {
            this.googleMap = googleMap2;
            if (googleMap2 != null) {
                if (!this.isUpdate) {
                    syncMyLocation();
                }
                googleMap2.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                    @Override
                    public void onMapClick(@NonNull LatLng latLng) {
                        Intrinsics.checkNotNullParameter(this, "this$0");
                       moveToLocation(latLng.latitude, latLng.longitude);
                    }
                });
            }
            moveToLocation(this.lat, this.lng);
        }

        public final void moveToLocation(double d, double d2) {
            this.currentLocation = new LatLng(d, d2);
            GoogleMap googleMap2 = this.googleMap;
            if (googleMap2 != null) {
                googleMap2.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(d, d2), 17.0f));
            }
        }

        private final void syncMyLocation() {
            this.airloc = new AirLocation(this, true, true, new AirLocation.Callbacks() {
                @Override
                public void onSuccess(@NonNull Location location) {

                    try {
                       lat = location.getLatitude();
                       lng = location.getLongitude();
                        moveToLocation(lat, lng);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailed(@NonNull AirLocation.LocationFailedEnum locationFailedEnum) {
                    Intrinsics.checkNotNullParameter(locationFailedEnum, "locationFailedEnum");
                    CustomToast.Companion.customToast(getString(R.string.custom_toast_create_zone_Failed_get_current_position), getApplicationContext());
                }
            });
        }

        /* access modifiers changed from: private */
        public  void searchLocationByName(String str) {
            if (!isNetworkAvailable()) {
                CustomToast.Companion.customToast(getString(R.string.custom_toast_create_zone_No_internet), this);
                return;
            }
            boolean z = true;
            if (!(str.length() == 0)) {
                try {
                    List<Address> fromLocationName = new Geocoder(this, Locale.getDefault()).getFromLocationName(str, 5);
                    if (fromLocationName == null || !(!fromLocationName.isEmpty())) {
                        z = false;
                    }
                    if (z) {
                        moveToLocation(fromLocationName.get(0).getLatitude(), fromLocationName.get(0).getLongitude());
                    }
                } catch (Exception e) {
                    Log.d("TAG", e.toString());
                }
            }
        }

        private final String getAddress() {
            String str = "";
            LatLng latLng = this.currentLocation;
            try {
                List<Address> fromLocation = new Geocoder(this, Locale.getDefault()).getFromLocation(latLng.latitude, latLng.longitude, 5);
                boolean z = true;
                if (fromLocation == null || !(!fromLocation.isEmpty())) {
                    z = false;
                }
                if (z) {
                    String addressLine = fromLocation.get(0).getAddressLine(0);
                    Intrinsics.checkNotNullExpressionValue(addressLine, "addressList[0].getAddressLine(0)");
                    str = addressLine;
                }
                Unit unit = Unit.INSTANCE;
            } catch (Exception e) {
                Integer.valueOf(Log.d("TAG", e.toString()));
            }
            return str;
        }
    }
