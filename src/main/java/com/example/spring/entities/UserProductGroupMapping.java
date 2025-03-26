package com.example.spring.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigInteger;
import java.time.Instant;

@Entity
@Table(name = "user_product_group_mapping")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class UserProductGroupMapping {
    @Id
    @Column(name = "id",columnDefinition = "BIGINT")
    private BigInteger id;

    @Column(name = "organisation_id",columnDefinition = "BIGINT")
    private BigInteger organisationId;

    @Column(name = "account_id", columnDefinition = "BIGINT")
    private BigInteger accountId;

    @Column(name = "user_id", columnDefinition = "BIGINT")
    private BigInteger userId;

    @Column(name = "group_id", columnDefinition = "BIGINT")
    private BigInteger groupId;

    @Column(name = "created_at", updatable = false)
    protected Instant createdAt;
}
