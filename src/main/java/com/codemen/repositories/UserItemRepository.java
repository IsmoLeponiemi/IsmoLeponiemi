package com.codemen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codemen.models.UserItem;

@Repository
public interface UserItemRepository extends JpaRepository<UserItem, Long> {

}
