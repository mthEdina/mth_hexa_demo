package com.example.demoHexa;

import com.example.demoHexa.application.domain.entity.Honey;
import com.example.demoHexa.application.domain.service.HoneyDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private HoneyDomainService productService;

    @Override
    public void run(String... args) throws Exception {
        // List to store honey products
        /*List<Honey> honeyProducts = new ArrayList<>();

        Honey lavenderHoney = new Honey();
        lavenderHoney.setName("Lavender Honey");
        lavenderHoney.setCharacteristics("250g sweet honey with a hint of lavender aroma.");
        lavenderHoney.setPrice(29.00);
        lavenderHoney.setStock(10);
        honeyProducts.add(lavenderHoney);

        Honey acaciaHoney = new Honey();
        acaciaHoney.setName("Acacia Honey");
        acaciaHoney.setCharacteristics("Delicate honey with a light floral flavor, 250g.");
        acaciaHoney.setPrice(42.00);
        acaciaHoney.setStock(20);
        honeyProducts.add(acaciaHoney);

        Honey heatherHoney = new Honey();
        heatherHoney.setName("Heather Honey");
        heatherHoney.setCharacteristics("Rich and malty honey with a hint of heather, 250g.");
        heatherHoney.setPrice(28.00);
        heatherHoney.setStock(8);
        honeyProducts.add(heatherHoney);

        Honey buckwheatHoney = new Honey();
        buckwheatHoney.setName("Buckwheat Honey");
        buckwheatHoney.setCharacteristics("Dark and robust honey from buckwheat flowers, 250g");
        buckwheatHoney.setPrice(18.00);
        buckwheatHoney.setStock(3);
        honeyProducts.add(buckwheatHoney);

        Honey orangeBlossomHoney = new Honey();
        orangeBlossomHoney.setName("Orange Blossom Honey");
        orangeBlossomHoney.setCharacteristics("250g citrusy honey with a touch of orange blossom.");
        orangeBlossomHoney.setPrice(20.00);
        orangeBlossomHoney.setStock(15);
        honeyProducts.add(orangeBlossomHoney);

        for (Honey honeyProduct : honeyProducts) {
            productService.addProduct(honeyProduct);
        }*/
    }
}

