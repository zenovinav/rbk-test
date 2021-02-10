package org.github.zenovinav.rbk.client.service;

import lombok.extern.slf4j.Slf4j;
import org.github.zenovinav.rbk.core.model.ResultMessage;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ResultsListener {

    @KafkaListener(topics = "results")
    public void receive(ResultMessage message) {
        log.info("Обработана транзакция {}. Статус: {}.", message.getId(), message.getStatus().getDescription());
    }
}
