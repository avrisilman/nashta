package com.api.nashta.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GetNilai {
    @Id
    public Long mahasiswa_id;
    public String nama;
    public String namamatakuliah;
    public int nilai;

    public Long getMahasiswa_id() {
        return mahasiswa_id;
    }

    public void setMahasiswa_id(Long mahasiswa_id) {
        this.mahasiswa_id = mahasiswa_id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNamamatakuliah() {
        return namamatakuliah;
    }

    public void setNamamatakuliah(String namamatakuliah) {
        this.namamatakuliah = namamatakuliah;
    }

    public int getNilai() {
        return nilai;
    }

    public void setNilai(int nilai) {
        this.nilai = nilai;
    }
}
