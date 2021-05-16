package com.tails.pricingservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tails.pricingservice.PricingserviceApplication;
import com.tails.pricingservice.models.Item;
import com.tails.pricingservice.models.Orders;
import com.tails.pricingservice.models.Price;
import com.tails.pricingservice.models.PricingDetails;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Component
public class PricingService {

    public Orders computePricing(Orders orders) {

        AtomicReference<Double> totalCartPriceWithVat = new AtomicReference<>((double) 0);
        AtomicReference<Double> totalCartVat = new AtomicReference<>((double) 0);

        orders.getOrder().getItems().forEach(eachItem ->
        {
            computePricing(totalCartPriceWithVat, totalCartVat, eachItem);
        });

        orders.getOrder().setTotalPriceofCart(totalCartPriceWithVat.get());
        orders.getOrder().setTotalVat(totalCartVat.get());

        return orders;
    }

    private void computePricing(AtomicReference<Double> totalCartPriceWithVat, AtomicReference<Double> totalCartVat, Item eachItem) {
        PricingDetails pricingDetails = loadRates();

        List<Price> pricingLists = pricingDetails.getPrices();

        Map<Integer, Price> productIdVsPricesMap = pricingLists.stream().collect(Collectors.toMap(Price::getProduct_id, price -> price));

        Integer productId = eachItem.getProductId();

        Integer priceForThisItem = productIdVsPricesMap.get(productId).getPrice();

        eachItem.setPricePerEach(priceForThisItem);

        eachItem.setVatBand(productIdVsPricesMap.get(productId).getVatBand());

        Double vat = null;
        try {
            vat = getVat(pricingDetails, productIdVsPricesMap, productId);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        eachItem.setVat(vat);

        double priceTimesQuantityWithVat = (priceForThisItem + (priceForThisItem * vat)) * eachItem.getQuantity();

        eachItem.setTotalPrice(priceTimesQuantityWithVat);

        totalCartPriceWithVat.set(totalCartPriceWithVat.get() + priceTimesQuantityWithVat);

        totalCartVat.set(totalCartVat.get() + (priceForThisItem * vat));
    }

    private Double getVat(PricingDetails pricingDetails, Map<Integer, Price> productIdVsPricesMap, Integer productId) throws NoSuchFieldException, IllegalAccessException {
        Field field = pricingDetails.getVatBands().getClass().getDeclaredField(productIdVsPricesMap.get(productId).getVatBand());
        field.setAccessible(true);

        Double vat = (double) (field.get(pricingDetails.getVatBands()));
        return vat;
    }

    private PricingDetails loadRates() {
        PricingDetails pricingDetails = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream is = PricingserviceApplication.class.getResourceAsStream("/rates.json");
            pricingDetails = mapper.readValue(is, PricingDetails.class);

        } catch (IOException e) {
            e.getMessage();
        }
        return pricingDetails;
    }
}
