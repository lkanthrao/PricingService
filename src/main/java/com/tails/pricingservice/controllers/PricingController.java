package com.tails.pricingservice.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tails.pricingservice.PricingserviceApplication;
import com.tails.pricingservice.models.*;
import com.tails.pricingservice.service.PricingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@RestController(value = "/pricing")
public class PricingController {

    @Autowired
    PricingService pricingService;

    @PostMapping(value = "/computePrice")

    public Object computePrice(@RequestBody Orders orders) throws IllegalAccessException, InstantiationException, NoSuchMethodException, NoSuchFieldException {

        return pricingService.computePricing(orders);

    }
}