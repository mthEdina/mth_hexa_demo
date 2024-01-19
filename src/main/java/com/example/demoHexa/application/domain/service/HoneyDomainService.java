package com.example.demoHexa.application.domain.service;

import com.example.demoHexa.application.domain.entity.Honey;
import com.example.demoHexa.application.port.in.HoneyInputPort;
import com.example.demoHexa.application.port.out.HoneyOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HoneyDomainService implements HoneyInputPort {
    private final HoneyOutputPort honeyOutputPort;

    @Autowired
    public HoneyDomainService(HoneyOutputPort honeyOutputPort) {
        this.honeyOutputPort = honeyOutputPort;
    }

    public List<Honey> getAllProducts() {
        List<Honey> allProducts = honeyOutputPort.findAll();
        List<Honey> availableProducts = allProducts.stream()
                .filter(product -> product.getStock() > 0)
                .collect(Collectors.toList());
        return availableProducts;
    }

    public Optional<Honey> getProductById(Long id) {
        return honeyOutputPort.findById(id);
    }

    public boolean buyProduct(Long id) {
        Optional<Honey> optionalProduct = honeyOutputPort.findById(id);
        if (optionalProduct.isPresent()) {
            Honey product = optionalProduct.get();
            if (product.getStock() > 0) {
                product.setStock(product.getStock() - 1);
                honeyOutputPort.save(product);
                return true;
            }
        }
        return false;
    }


    public boolean addProduct(Honey product) {
        if (isPositiveInteger(String.valueOf(product.getStock())) && isPositiveDouble(String.valueOf(product.getPrice()))) {
            honeyOutputPort.save(product);
            return true;
        }
        return false;
    }


    public boolean increaseProduct(Long id, int nr) {
        if (isPositiveInteger(String.valueOf(nr))) {
            Optional<Honey> optionalProduct = honeyOutputPort.findById(id);
            if (optionalProduct.isPresent()) {
                Honey product = optionalProduct.get();
                product.setStock(product.getStock() + nr);
                honeyOutputPort.save(product);
                return true;
            }
        }
        return false;
    }

    public boolean deleteProduct(Long id){
        Optional<Honey> optionalProduct = honeyOutputPort.findById(id);
        if (optionalProduct.isPresent()) {
            Honey product = optionalProduct.get();
            honeyOutputPort.delete(product);
            return true;
        }
        return false;
    }

    private boolean isPositiveInteger(String str) {
        try {
            int number = Integer.parseInt(str);
            return number > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isPositiveDouble(String str) {
        try {
            double number = Double.parseDouble(str);
            return number > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
