package com.revature.services;

import com.revature.daos.PolicyDao;
import com.revature.models.Policy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyServiceImpl implements PolicyService {

    private PolicyDao policyDao;
    private Logger log = LogManager.getRootLogger();

    public int createFirstPolicy(Policy p) {
        return 0;
    }

    @Override
    public int addPolicy(Policy p) {
        return policyDao.save(p);
    }

    @Override
    public void updatePolicy(Policy p) {
        //todo
    }

    @Override
    public Policy getPolicyByPolicyId(int id) {
        //todo
        return null;
    }

    @Override
    public List<Policy> getPoliciesByOwnerId(int id) {
        //todo
        return null;
    }

    @Autowired
    public void setPolicyDao(PolicyDao policyDao) {
        this.policyDao = policyDao;
    }
}