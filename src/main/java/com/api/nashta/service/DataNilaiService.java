package com.api.nashta.service;

import com.api.nashta.model.DataNilai;

public interface DataNilaiService {
    DataNilai save(Long mahasiswaId,Long matakuliahId,DataNilai dataNilai);
    DataNilai update(Long nilaiId,Long mahasiswaId,Long matakuliahId,DataNilai dataNilai);
}
