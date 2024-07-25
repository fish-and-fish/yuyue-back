package com.amrni.sport.shop.config;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.beans.factory.annotation.Autowired;

public class SnowIdGenerator implements IdentifierGenerator {
    @Autowired
    SnowFlakeUtils snowFlakeUtils;

    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        return snowFlakeUtils.nextId();
    }

}