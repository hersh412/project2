package com.revature.daos;

import com.revature.models.Policy;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PolicyDao {

    int save(Policy policy);

    Policy getPolicyById(int id);

    List<Policy> getPoliciesByOwnerId(int policyOwner);
}
