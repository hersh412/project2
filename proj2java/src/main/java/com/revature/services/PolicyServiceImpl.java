package com.revature.services;

import com.revature.daos.PolicyDao;
import com.revature.models.Policy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PolicyServiceImpl implements PolicyService {

    private PolicyDao policyDao;
    private Logger log = LogManager.getRootLogger();

    @Override
    public void addPolicy(Policy p) {
        policyDao.

    }

    @Override
    public void updatePolicy(Policy p) {

    }

    @Override
    public Policy getPolicyByPolicyId(int id) {
        return null;
    }

    @Override
    public List<Policy> getPoliciesByOwnerId(int id) {
        return null;
    }

    @Autowired
    public void setPolicyDao(PolicyDao policyDao) {
        this.policyDao = policyDao;
    }
}
