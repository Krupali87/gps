package com.app.gpsphonelocator_new.database;

import java.io.Serializable;

import kotlin.jvm.internal.Intrinsics;


public final class AlertHistoryEntity implements Serializable {
    private final int id;
    private final boolean isTmp;
    private final boolean onEnter;
    private final boolean onLeave;
    private final int status;
    private final long time;
    private final String uid;
    private final String userName;
    private final int zoneId;
    private final String zoneName;

    public static AlertHistoryEntity copy$default(AlertHistoryEntity alertHistoryEntity, int i, int i2, String str, String str2, String str3, boolean z, boolean z2, int i3, long j, boolean z3, int i4, Object obj) {
        AlertHistoryEntity alertHistoryEntity2 = alertHistoryEntity;
        int i5 = i4;
        return alertHistoryEntity.copy((i5 & 1) != 0 ? alertHistoryEntity2.id : i, (i5 & 2) != 0 ? alertHistoryEntity2.zoneId : i2, (i5 & 4) != 0 ? alertHistoryEntity2.zoneName : str, (i5 & 8) != 0 ? alertHistoryEntity2.uid : str2, (i5 & 16) != 0 ? alertHistoryEntity2.userName : str3, (i5 & 32) != 0 ? alertHistoryEntity2.onEnter : z, (i5 & 64) != 0 ? alertHistoryEntity2.onLeave : z2, (i5 & 128) != 0 ? alertHistoryEntity2.status : i3, (i5 & 256) != 0 ? alertHistoryEntity2.time : j, (i5 & 512) != 0 ? alertHistoryEntity2.isTmp : z3);
    }

    public final int component1() {
        return this.id;
    }

    public final boolean component10() {
        return this.isTmp;
    }

    public final int component2() {
        return this.zoneId;
    }

    public final String component3() {
        return this.zoneName;
    }

    public final String component4() {
        return this.uid;
    }

    public final String component5() {
        return this.userName;
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

    public final long component9() {
        return this.time;
    }

    public final AlertHistoryEntity copy(int i, int i2, String str, String str2, String str3, boolean z, boolean z2, int i3, long j, boolean z3) {
        return new AlertHistoryEntity(i, i2, str, str2, str3, z, z2, i3, j, z3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AlertHistoryEntity)) {
            return false;
        }
        AlertHistoryEntity alertHistoryEntity = (AlertHistoryEntity) obj;
        return this.id == alertHistoryEntity.id && this.zoneId == alertHistoryEntity.zoneId && Intrinsics.areEqual((Object) this.zoneName, (Object) alertHistoryEntity.zoneName) && Intrinsics.areEqual((Object) this.uid, (Object) alertHistoryEntity.uid) && Intrinsics.areEqual((Object) this.userName, (Object) alertHistoryEntity.userName) && this.onEnter == alertHistoryEntity.onEnter && this.onLeave == alertHistoryEntity.onLeave && this.status == alertHistoryEntity.status && this.time == alertHistoryEntity.time && this.isTmp == alertHistoryEntity.isTmp;
    }

    public int hashCode() {
        int hashCode = ((Integer.hashCode(this.id) * 31) + Integer.hashCode(this.zoneId)) * 31;
        String str = this.zoneName;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.uid;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.userName;
        if (str3 != null) {
            i = str3.hashCode();
        }
        int i2 = (hashCode3 + i) * 31;
        boolean z = this.onEnter;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i3 = (i2 + (z ? 1 : 0)) * 31;
        boolean z3 = this.onLeave;
        if (z3) {
            z3 = true;
        }
        int hashCode4 = (((((i3 + (z3 ? 1 : 0)) * 31) + Integer.hashCode(this.status)) * 31) + Long.hashCode(this.time)) * 31;
        boolean z4 = this.isTmp;
        if (!z4) {
            z2 = z4;
        }
        return hashCode4 + (z2 ? 1 : 0);
    }

    public String toString() {
        return "AlertHistoryEntity(id=" + this.id + ", zoneId=" + this.zoneId + ", zoneName=" + this.zoneName + ", uid=" + this.uid + ", userName=" + this.userName + ", onEnter=" + this.onEnter + ", onLeave=" + this.onLeave + ", status=" + this.status + ", time=" + this.time + ", isTmp=" + this.isTmp + ')';
    }

    public AlertHistoryEntity(int i, int i2, String str, String str2, String str3, boolean z, boolean z2, int i3, long j, boolean z3) {
        this.id = i;
        this.zoneId = i2;
        this.zoneName = str;
        this.uid = str2;
        this.userName = str3;
        this.onEnter = z;
        this.onLeave = z2;
        this.status = i3;
        this.time = j;
        this.isTmp = z3;
    }

    public final int getId() {
        return this.id;
    }

    public final int getZoneId() {
        return this.zoneId;
    }

    public final String getZoneName() {
        return this.zoneName;
    }

    public final String getUid() {
        return this.uid;
    }

    public final String getUserName() {
        return this.userName;
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

    public final long getTime() {
        return this.time;
    }

    public final boolean isTmp() {
        return this.isTmp;
    }
}
