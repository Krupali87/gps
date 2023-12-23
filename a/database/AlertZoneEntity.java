package com.app.gpsphonelocator_new.database;

import java.io.Serializable;

import kotlin.jvm.internal.Intrinsics;


public final class AlertZoneEntity implements Serializable {
    private final String address;
    private final int id;
    private final Double latitude;
    private final Double longitude;
    private final boolean onEnter;
    private final boolean onLeave;
    private final int radius;
    private final int status;
    private final String zoneName;

    public static /* synthetic */ AlertZoneEntity copy$default(AlertZoneEntity alertZoneEntity, int i, String str, Double d, Double d2, String str2, boolean z, boolean z2, int i2, int i3, int i4, Object obj) {
        AlertZoneEntity alertZoneEntity2 = alertZoneEntity;
        int i5 = i4;
        return alertZoneEntity.copy((i5 & 1) != 0 ? alertZoneEntity2.id : i, (i5 & 2) != 0 ? alertZoneEntity2.zoneName : str, (i5 & 4) != 0 ? alertZoneEntity2.latitude : d, (i5 & 8) != 0 ? alertZoneEntity2.longitude : d2, (i5 & 16) != 0 ? alertZoneEntity2.address : str2, (i5 & 32) != 0 ? alertZoneEntity2.onEnter : z, (i5 & 64) != 0 ? alertZoneEntity2.onLeave : z2, (i5 & 128) != 0 ? alertZoneEntity2.status : i2, (i5 & 256) != 0 ? alertZoneEntity2.radius : i3);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.zoneName;
    }

    public final Double component3() {
        return this.latitude;
    }

    public final Double component4() {
        return this.longitude;
    }

    public final String component5() {
        return this.address;
    }

    public final boolean component6() {
        return this.onEnter;
    }

    public final boolean component7() {
        return this.onLeave;
    }

    public final int component8() {
        return this.status;
    }

    public final int component9() {
        return this.radius;
    }

    public final AlertZoneEntity copy(int i, String str, Double d, Double d2, String str2, boolean z, boolean z2, int i2, int i3) {
        return new AlertZoneEntity(i, str, d, d2, str2, z, z2, i2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AlertZoneEntity)) {
            return false;
        }
        AlertZoneEntity alertZoneEntity = (AlertZoneEntity) obj;
        return this.id == alertZoneEntity.id && Intrinsics.areEqual((Object) this.zoneName, (Object) alertZoneEntity.zoneName) && Intrinsics.areEqual((Object) this.latitude, (Object) alertZoneEntity.latitude) && Intrinsics.areEqual((Object) this.longitude, (Object) alertZoneEntity.longitude) && Intrinsics.areEqual((Object) this.address, (Object) alertZoneEntity.address) && this.onEnter == alertZoneEntity.onEnter && this.onLeave == alertZoneEntity.onLeave && this.status == alertZoneEntity.status && this.radius == alertZoneEntity.radius;
    }

    public int hashCode() {
        int hashCode = Integer.hashCode(this.id) * 31;
        String str = this.zoneName;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Double d = this.latitude;
        int hashCode3 = (hashCode2 + (d == null ? 0 : d.hashCode())) * 31;
        Double d2 = this.longitude;
        int hashCode4 = (hashCode3 + (d2 == null ? 0 : d2.hashCode())) * 31;
        String str2 = this.address;
        if (str2 != null) {
            i = str2.hashCode();
        }
        int i2 = (hashCode4 + i) * 31;
        boolean z = this.onEnter;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i3 = (i2 + (z ? 1 : 0)) * 31;
        boolean z3 = this.onLeave;
        if (!z3) {
            z2 = z3;
        }
        return ((((i3 + (z2 ? 1 : 0)) * 31) + Integer.hashCode(this.status)) * 31) + Integer.hashCode(this.radius);
    }

    public String toString() {
        return "AlertZoneEntity(id=" + this.id + ", zoneName=" + this.zoneName + ", latitude=" + this.latitude + ", longitude=" + this.longitude + ", address=" + this.address + ", onEnter=" + this.onEnter + ", onLeave=" + this.onLeave + ", status=" + this.status + ", radius=" + this.radius + ')';
    }

    public AlertZoneEntity(int i, String str, Double d, Double d2, String str2, boolean z, boolean z2, int i2, int i3) {
        this.id = i;
        this.zoneName = str;
        this.latitude = d;
        this.longitude = d2;
        this.address = str2;
        this.onEnter = z;
        this.onLeave = z2;
        this.status = i2;
        this.radius = i3;
    }

    public final int getId() {
        return this.id;
    }

    public final java.lang.CharSequence getZoneName() {
        return this.zoneName;
    }

    public final java.lang.Double getLatitude() {
        return this.latitude;
    }

    public final Double getLongitude() {
        return this.longitude;
    }

    public final String getAddress() {
        return this.address;
    }

    public final boolean getOnEnter() {
        return this.onEnter;
    }

    public final boolean getOnLeave() {
        return this.onLeave;
    }

    public final int getStatus() {
        return this.status;
    }

    public final int getRadius() {
        return this.radius;
    }
}
