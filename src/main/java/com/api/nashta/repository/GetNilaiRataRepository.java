package com.api.nashta.repository;

import com.api.nashta.model.GetNilaiRata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GetNilaiRataRepository  extends JpaRepository<GetNilaiRata, Long> {
    @Query(value = "SELECT dn.mahasiswa_id, m.nama, SUM(dn.nilai) / 3 as nilai FROM datanilai dn INNER JOIN matakuliah mk ON dn.matakuliah_id=mk.id INNER JOIN mahasiswa m ON m.id=dn.mahasiswa_id GROUP BY dn.mahasiswa_id, m.nama", nativeQuery = true)
    List<GetNilaiRata> findByNilairata();
}
