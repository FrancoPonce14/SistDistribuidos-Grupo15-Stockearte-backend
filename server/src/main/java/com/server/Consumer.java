package com.server;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.server.entities.OrdenCompra;
import com.server.entities.OrdenDespacho;
import com.server.exceptions.ServerException;
import com.server.repositories.IOrdenCompraRepository;
import com.server.repositories.IOrdenDespachoRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class Consumer {

    private List<String> novedadesT = new ArrayList<>();

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private IOrdenCompraRepository ordenCompraRepository;

    @Autowired
    private IOrdenDespachoRepository ordenDespachoRepository;

    @KafkaListener(topics = "novedades")
    public void traerNovedades(String mensaje) {
        novedadesT.add(mensaje);
    }

    public List<String> getNovedades() {
        return new ArrayList<>(novedadesT);
    }

    @KafkaListener(topics = "solicitudes")
    public void traerSolicitudes(String mensaje) {
        try {
            JsonNode jsonNode = objectMapper.readTree(mensaje);
            String observaciones = jsonNode.get("observaciones").asText();
            Long idOrdenCompra = jsonNode.get("idOrdenCompra").asLong();
            String estado = jsonNode.get("estado").asText();

            OrdenCompra ordenCompra = ordenCompraRepository.findById(idOrdenCompra)
                    .orElse(null);

            if (ordenCompra != null) {
                ordenCompra.setObservaciones(observaciones);
                ordenCompra.setEstado(estado);
                ordenCompraRepository.save(ordenCompra);
            } else {
                log.warn("Orden de compra no encontrada para id: {}", idOrdenCompra);
            }
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
        }
    }

    @KafkaListener(topics = "despacho")
    public void traerRecepcion(String mensaje) {
        try {
            JsonNode jsonNode = objectMapper.readTree(mensaje);

            Long idOrdenCompra = jsonNode.get("idOrdenCompra").asLong();
            Long idOrdenDespacho = jsonNode.get("idOrdenDespacho").asLong();
            String fechaEstimadaEnvioStr = jsonNode.get("fechaEstimadaEnvio").asText();

            OrdenCompra ordenCompra = ordenCompraRepository.findById(idOrdenCompra)
                    .orElse(null);

            SimpleDateFormat formateo = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaEstimadaEnvio;
            try {
                fechaEstimadaEnvio = formateo.parse(fechaEstimadaEnvioStr);
            } catch (ParseException e) {
                throw new ServerException("Fecha estimada de envío inválida", HttpStatus.BAD_REQUEST);
            }

            OrdenDespacho ordenDespacho = new OrdenDespacho();
            ordenDespacho.setId(idOrdenDespacho);
            ordenDespacho.setFechaEnvioEstimado(fechaEstimadaEnvio);
            ordenDespacho.setOrdenCompra(ordenCompra);

            ordenDespachoRepository.save(ordenDespacho);
        } catch (JsonProcessingException e) {
            log.error("Error al procesar el mensaje");
        } 
    }

}
