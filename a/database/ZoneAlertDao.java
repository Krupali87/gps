package com.app.gpsphonelocator_new.database;

import java.util.List;

import kotlin.Metadata;


public interface ZoneAlertDao {
    void delete(int... iArr);

    void delete(AlertZoneEntity... alertZoneEntityArr);

    List<AlertZoneEntity> getListZone();

    void insert(AlertZoneEntity... alertZoneEntityArr);

    void update(AlertZoneEntity... alertZoneEntityArr);
}
