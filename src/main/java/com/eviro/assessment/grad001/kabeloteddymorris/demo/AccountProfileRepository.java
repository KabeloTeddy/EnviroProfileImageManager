package com.eviro.assessment.grad001.kabeloteddymorris.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountProfileRepository extends JpaRepository<AccountProfile, Long> {
    // To give me CRUD basics
    //returns the corresponding AccountProfile record
    AccountProfile findById(long id);
}
