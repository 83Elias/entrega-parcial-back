package com.msbills.controller;

import com.msbills.models.Bill;
import com.msbills.service.BillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bills")
@RequiredArgsConstructor
public class BillController {

    private final BillService service;

    @GetMapping("/all")
    public ResponseEntity<List<Bill>> getAll() {

        return ResponseEntity.ok().body(service.getAllBill());
    }

}
