package com.server;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.server.entities.OrdenCompra;
import com.server.exceptions.ServerException;
import com.server.repositories.IOrdenCompraRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class Consumer {

    private List<String> novedadesT = new ArrayList<>();

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private IOrdenCompraRepository ordenCompraRepository;

    @KafkaListener(topics = "novedades")
    public void traerNovedades(String mensaje) {
        novedadesT.add(mensaje);
    }

    public List<String> getNovedades() {
        return new ArrayList<>(novedadesT);
    }

    @KafkaListener(topics = "solicitudes")
    public void traerSolicitudes(String mensaje) {
        try{
        JsonNode jsonNode = objectMapper.readTree(mensaje);
        String observaciones = jsonNode.get("observaciones").asText();
        Long idOrdenCompra = jsonNode.get("idOrdenCompra").asLong();
        String estado = jsonNode.get("estado").asText();

        OrdenCompra ordenCompra = ordenCompraRepository.findById(idOrdenCompra)
                .orElseThrow(() -> new ServerException("Orden de compra no encontrada", HttpStatus.NOT_FOUND));

        ordenCompra.setObservaciones(observaciones);
        ordenCompra.setEstado(estado);

        ordenCompraRepository.save(ordenCompra);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
        }
    }

}
