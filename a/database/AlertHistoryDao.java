package com.app.gpsphonelocator_new.database;

import java.util.List;

import kotlin.Metadata;


public interface AlertHistoryDao {
    void delete(int... iArr);

    void delete(AlertHistoryEntity... alertHistoryEntityArr);

    void deleteAll();

    AlertHistoryEntity getFirstHistory(String str, int i);

    List<AlertHistoryEntity> getHistoryFilter(String str, long j, long j2);

    List<AlertHistoryEntity> getHistoryList();

    void insert(AlertHistoryEntity... alertHistoryEntityArr);

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AlertHistoryDao.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ List getHistoryFilter$default(AlertHistoryDao alertHistoryDao, String str, long j, long j2, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    j2 = System.currentTimeMillis();
                }
                return alertHistoryDao.getHistoryFilter(str, j, j2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getHistoryFilter");
        }
    }
}
