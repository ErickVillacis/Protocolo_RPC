package com.crud.rpc_api.api;

import com.crud.rpc_api.model.Laptop;
import com.crud.rpc_api.repository.LaptopRepository;
import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AutoJsonRpcServiceImpl
public class LaptopServerApiImpl implements LaptopServerApi {

    @Autowired
    private LaptopRepository laptopRepository;

    @Override
    public List<Laptop> getAllLaptops() {
        return laptopRepository.findAll();
    }

    @Override
    public Laptop getLaptopById(Long id) {
        return laptopRepository.findById(id).orElse(null);
    }

    @Override
    public Laptop createLaptop(Laptop laptop) {
        return laptopRepository.save(laptop);
    }

    @Override
    public Laptop updateLaptop(Laptop laptop) {
        Laptop laptopOld = laptopRepository.findById(laptop.getId()).orElse(null);
        if (laptopOld == null) {
            return null;
        }
        if (laptop.getBrand() != null) {
            laptopOld.setBrand(laptop.getBrand());
        }
        if (laptop.getColor() != null) {
            laptopOld.setColor(laptop.getColor());
        }
        if (laptop.getWeight() != null) {
            laptopOld.setWeight(laptop.getWeight());
        }
        if (laptop.getDimensions() != null) {
            laptopOld.setDimensions(laptop.getDimensions());
        }
        if (laptop.getPrice() != null) {
            laptopOld.setPrice(laptop.getPrice());
        }
        return laptopRepository.save(laptopOld);
    }

    @Override
    public String deleteLaptop(Long id) {
        try {
            laptopRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            return "Laptop not found";
        }
        return "Laptop deleted";
    }
}