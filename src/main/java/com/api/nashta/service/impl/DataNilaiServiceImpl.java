package com.api.nashta.service.impl;

import com.api.nashta.model.DataNilai;
import com.api.nashta.repository.DataNilaiRepository;
import com.api.nashta.repository.MahasiswaRepository;
import com.api.nashta.repository.MataKuliahRepository;
import com.api.nashta.service.DataNilaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("datanilaiService")
public class DataNilaiServiceImpl implements DataNilaiService {

    @Autowired
    MataKuliahRepository mataKuliahRepository;

    @Autowired
    MahasiswaRepository mahasiswaRepository;

    @Autowired
    DataNilaiRepository dataNilaiRepository;

    @Override
    public DataNilai save(Long mahasiswaId,Long matakuliahId,DataNilai dataNilai) {
        DataNilai dn = new DataNilai();
        dn.setNilai(dataNilai.getNilai());
        dn.setMahasiswa(mahasiswaRepository.findById(mahasiswaId).get());
        dn.setMataKuliah(mataKuliahRepository.findById(matakuliahId).get());
        dn.setKeterangan(dataNilai.getKeterangan());
        return dataNilaiRepository.save(dn);
    }

    @Override
    public DataNilai update(Long niaiId,Long mahasiswaId,Long matakuliahId,DataNilai dataNilai) {
        DataNilai dn = new DataNilai();
        dn.setId(niaiId);
        dn.setNilai(dataNilai.getNilai());
        dn.setKeterangan(dataNilai.getKeterangan());
        dn.setMahasiswa(mahasiswaRepository.findById(mahasiswaId).get());
        dn.setMataKuliah(mataKuliahRepository.findById(matakuliahId).get());
        return dataNilaiRepository.save(dn);
    }

}
