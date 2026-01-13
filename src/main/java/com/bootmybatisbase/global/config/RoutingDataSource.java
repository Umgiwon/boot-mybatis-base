package com.bootmybatisbase.global.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * Transaction 여부에 따라 DB를 routing 해주는 클래스
 */
@Slf4j
public class RoutingDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {

        boolean readOnly = TransactionSynchronizationManager.isCurrentTransactionReadOnly();

//        log.info("[Routing] readOnly={}", readOnly);

        log.info("[Routing] txActive={}, readOnly={}",
                TransactionSynchronizationManager.isActualTransactionActive(),
                TransactionSynchronizationManager.isCurrentTransactionReadOnly()
        );

        return readOnly ? "slave" : "master";
    }
}
