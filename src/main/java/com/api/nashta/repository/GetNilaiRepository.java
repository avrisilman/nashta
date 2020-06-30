package com.api.nashta.repository;

import com.api.nashta.model.GetNilai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GetNilaiRepository extends JpaRepository<GetNilai, Long> {
    @Query(value = "SELECT dn.mahasiswa_id, m.nama, mk.namamatakuliah, dn.nilai FROM datanilai dn INNER JOIN matakuliah mk ON dn.matakuliah_id=mk.id INNER JOIN mahasiswa m ON m.id=dn.mahasiswa_id", nativeQuery = true)
    List<GetNilai> findAllBy();
}
