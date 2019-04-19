package com.revature.services;

import com.revature.models.Policy;

import java.util.List;

public interface PolicyService {

    void addPolicy(Policy p);

    void updatePolicy(Policy p);

    Policy getPolicyByPolicyId(int id);

    List<Policy> getPoliciesByOwnerId(int id);


}
