package com.app.gpsphonelocator_new.database;

import kotlin.jvm.internal.Intrinsics;


public final class UserTracked {
    private final String checked;
    private final String name;
    private final String phone;
    private final int uid;
    private final String uuid;

    public static  UserTracked copy$default(UserTracked userTracked, int i, String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = userTracked.uid;
        }
        if ((i2 & 2) != 0) {
            str = userTracked.name;
        }
        String str5 = str;
        if ((i2 & 4) != 0) {
            str2 = userTracked.phone;
        }
        String str6 = str2;
        if ((i2 & 8) != 0) {
            str3 = userTracked.uuid;
        }
        String str7 = str3;
        if ((i2 & 16) != 0) {
            str4 = userTracked.checked;
        }
        return userTracked.copy(i, str5, str6, str7, str4);
    }

    public final int component1() {
        return this.uid;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.phone;
    }

    public final String component4() {
        return this.uuid;
    }

    public final String component5() {
        return this.checked;
    }

    public final UserTracked copy(int i, String str, String str2, String str3, String str4) {
        return new UserTracked(i, str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserTracked)) {
            return false;
        }
        UserTracked userTracked = (UserTracked) obj;
        return this.uid == userTracked.uid && Intrinsics.areEqual((Object) this.name, (Object) userTracked.name) && Intrinsics.areEqual((Object) this.phone, (Object) userTracked.phone) && Intrinsics.areEqual((Object) this.uuid, (Object) userTracked.uuid) && Intrinsics.areEqual((Object) this.checked, (Object) userTracked.checked);
    }

    public int hashCode() {
        int hashCode = Integer.hashCode(this.uid) * 31;
        String str = this.name;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.phone;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.uuid;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.checked;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "UserTracked(uid=" + this.uid + ", name=" + this.name + ", phone=" + this.phone + ", uuid=" + this.uuid + ", checked=" + this.checked + ')';
    }

    public UserTracked(int i, String str, String str2, String str3, String str4) {
        this.uid = i;
        this.name = str;
        this.phone = str2;
        this.uuid = str3;
        this.checked = str4;
    }

    public final int getUid() {
        return this.uid;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final String getUuid() {
        return this.uuid;
    }

    public final String getChecked() {
        return this.checked;
    }
}
