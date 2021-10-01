package com.example.CRMTorris.controller;

import com.example.CRMTorris.dto.MaterialDto;
import com.example.CRMTorris.database.service.MaterialService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController("/material")
public class MaterialController {

    private final MaterialService materialService;

    public MaterialController(MaterialService materialService) {
        this.materialService = materialService;
    }

    @GetMapping("/material/")
    public ResponseEntity<Set<MaterialDto>> getMaterial() {
        return new ResponseEntity<>(materialService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/material/filter/")
    public ResponseEntity<Set<MaterialDto>> getMaterialByFilter(@Validated @RequestBody MaterialDto dto) {
        return new ResponseEntity<>(materialService.getAllByFilter(dto), HttpStatus.OK);
    }
}
