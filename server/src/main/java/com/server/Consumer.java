package com.server;

import java.util.ArrayList;
import java.util.List;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class Consumer {
    
    private List<String> novedadesT = new ArrayList<>();

    @KafkaListener(topics = "novedades")
    public void traerNovedades(String mensaje) {
            novedadesT.add(mensaje);
    }

    public List<String> getNovedades() {
        return new ArrayList<>(novedadesT);
    }

}
