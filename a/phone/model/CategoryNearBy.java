package com.app.gpsphonelocator_new.phone.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CategoryNearBy.kt */
public final class CategoryNearBy {
    private String image;
    private String title;

    public CategoryNearBy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "image");
        this.title = str;
        this.image = str2;
    }

    public final String getImage() {
        return this.image;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setImage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.image = str;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }
}
