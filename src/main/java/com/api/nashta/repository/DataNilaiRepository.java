package com.api.nashta.repository;

import com.api.nashta.model.DataNilai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataNilaiRepository extends JpaRepository<DataNilai, Long> {
}
