package com.example.spring.repository;

import com.example.spring.entities.UserProductGroupMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigInteger;

public interface UserProductGroupMappingRepository extends JpaRepository<UserProductGroupMapping, BigInteger> {
    @Modifying
    @Query(value = "INSERT IGNORE INTO user_product_group_mapping (id, organisation_id, account_id, user_id, group_id, created_at) " +
            "VALUES (:id, :organisationId, :accountId, :userId, :groupId, now())", nativeQuery = true)
    void insertIgnore(@Param("id") BigInteger id, @Param("organisationId") BigInteger organisationId,
                                           @Param("accountId") BigInteger accountId,
                                           @Param("userId") BigInteger userId,
                                           @Param("groupId") BigInteger groupId);

    @Modifying
    @Query(value = "INSERT INTO user_product_group_mapping (id, organisation_id, account_id, user_id, group_id, created_at) " +
            "VALUES (:id, :organisationId, :accountId, :userId, :groupId, now()) ON DUPLICATE KEY UPDATE organisation_id=:organisationId, " +
            "account_id=:accountId, user_id=:userId, group_id=:groupId", nativeQuery = true)
    void upsert(@Param("id") BigInteger id, @Param("organisationId") BigInteger organisationId,
                      @Param("accountId") BigInteger accountId,
                      @Param("userId") BigInteger userId,
                      @Param("groupId") BigInteger groupId);
}
