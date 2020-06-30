package com.api.nashta.controller;

import com.api.nashta.controller.exception.ResourceNotFoundException;
import com.api.nashta.model.ApiResponse;
import com.api.nashta.model.DataNilai;
import com.api.nashta.model.GetNilai;
import com.api.nashta.repository.DataNilaiRepository;
import com.api.nashta.repository.GetNilaiRataRepository;
import com.api.nashta.repository.GetNilaiRepository;
import com.api.nashta.service.DataNilaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
public class DataNilaiController {

    @Autowired
    DataNilaiService dataNilaiService;

    @Autowired
    DataNilaiRepository dataNilaiRepository;

    @Autowired
    GetNilaiRepository getNilaiRepository;

    @Autowired
    GetNilaiRataRepository getNilaiRataRepository;

    @PostMapping("/mahasiswa/{mahasiswaId}/matakuliah/{matakuliahId}")
    public ApiResponse<DataNilai> createDataNilai(@PathVariable(value = "mahasiswaId") Long mahasiswaId,
                                                  @PathVariable(value = "matakuliahId") Long matakuliahId,
                                                  @Valid @RequestBody DataNilai dataNilai) {
        return new ApiResponse<>(HttpStatus.OK.value(), "success", dataNilaiService.save(mahasiswaId, matakuliahId, dataNilai));
    }

    @PutMapping("nilaiId/{nilaiId}/mahasiswa/{mahasiswaId}/matakuliah/{matakuliahId}")
    public ApiResponse<DataNilai> updateDataNilai(@PathVariable(value = "nilaiId") Long nilaiId,
                                                  @PathVariable(value = "mahasiswaId") Long mahasiswaId,
                                                  @PathVariable(value = "matakuliahId") Long matakuliahId,
                                                  @Valid @RequestBody DataNilai dataNilai) {
        return new ApiResponse<>(HttpStatus.OK.value(), "success", dataNilaiService.update(nilaiId, mahasiswaId, matakuliahId, dataNilai));
    }

    @GetMapping(value = "/getMahasiswa")
    public ApiResponse<GetNilai> getData(){
        return new ApiResponse<>(HttpStatus.OK.value(), "success", getNilaiRepository.findAllBy());
    }

    @GetMapping(value = "/getNilaiRata")
    public ApiResponse<GetNilai> getiNilaiRata(){
        return new ApiResponse<>(HttpStatus.OK.value(), "success", getNilaiRataRepository.findByNilairata());
    }

    @DeleteMapping("/datanilai/{nilaiId}")
    public Map<String, Boolean> deleteMarket(@PathVariable(value = "nilaiId") Long nilaiId)
            throws ResourceNotFoundException {
        DataNilai dataNilai = dataNilaiRepository.findById(nilaiId)
                .orElseThrow(() -> new ResourceNotFoundException("not found for this id :: " + nilaiId));

        dataNilaiRepository.delete(dataNilai);
        Map<String, Boolean> response = new HashMap<>();
        response.put("status", Boolean.TRUE);
        return response;
    }

}
