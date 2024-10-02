package com.server;

import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class ConsumerProperties {
    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Bean
    public ConsumerFactory<String, String> consumerFactory() {
        Map<String, Object> properties = new HashMap<>();
        // Establece la ubicación del servidor Kafka
        properties.put("bootstrap.servers", "localhost:9092"); // Cambia esto según la dirección de tu servidor Kafka

        // Establece el grupo de consumidores al que se unirá este consumidor
        properties.put("group.id", "mi-grupo-consumidor"); // Cambia esto al nombre de tu grupo

        // Configura el deserializador de claves y valores
        properties.put("key.deserializer", StringDeserializer.class.getName()); // Deserializador de claves
        properties.put("value.deserializer", StringDeserializer.class.getName()); // Deserializador de valores

        // Controla desde dónde comenzar a consumir mensajes (configura según tus
        // necesidades)
        properties.put("auto.offset.reset", "earliest"); // Puede ser 'earliest' o 'latest'

        // Habilita el manejo automático de la confirmación de offset (configura según
        // tus necesidades)
        properties.put("enable.auto.commit", "true"); // Puede ser 'true' o 'false'
        properties.put("auto.commit.interval.ms", "1000"); // Frecuencia de confirmación
        properties.put(ErrorHandlingDeserializer.VALUE_DESERIALIZER_CLASS, JsonDeserializer.class.getName());

        return new DefaultKafkaConsumerFactory<>(properties);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}