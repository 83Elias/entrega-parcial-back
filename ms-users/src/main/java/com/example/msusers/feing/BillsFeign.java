package com.example.msusers.feing;

import com.example.msusers.domain.Bill;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ms-bill")
public interface BillsFeign {


    @GetMapping("/api/v1/bills/{id}")
    List<Bill> getBillsPerIdUser(@PathVariable String id);
}
