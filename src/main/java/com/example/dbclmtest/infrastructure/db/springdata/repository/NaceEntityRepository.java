package com.example.dbclmtest.infrastructure.db.springdata.repository;

import com.example.dbclmtest.infrastructure.db.springdata.dbo.NaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NaceEntityRepository extends JpaRepository<NaceEntity, Long> {
}
