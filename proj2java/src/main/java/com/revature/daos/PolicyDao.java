package com.revature.daos;

import com.revature.models.Policy;

import java.util.List;

public interface PolicyDao {

    Policy getPolicyById(int id);

    List<Policy> getPoliciesByOwnerId(int policyOwner);
}
