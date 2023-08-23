package com.msbills.service;

import com.msbills.models.Bill;
import com.msbills.repositories.BillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BillService {

    private final BillRepository repository;

    public List<Bill> getAllBill() {
        List<Bill> bills=repository.findAll();
        System.out.println("wenassss");
        System.out.println(bills.get(1).toString());

        return repository.findAll();
    }

}
