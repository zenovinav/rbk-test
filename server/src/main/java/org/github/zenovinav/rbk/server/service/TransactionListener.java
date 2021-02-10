package org.github.zenovinav.rbk.server.service;

import lombok.RequiredArgsConstructor;
import org.github.zenovinav.rbk.core.model.TransactionMessage;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionListener {

    private final TransactionCheckService checkService;

    @KafkaListener(topics = "transactions")
    public void receive(TransactionMessage message) {
        checkService.check(message.getId(), message.getAmount());
    }
}
