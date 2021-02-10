package org.github.zenovinav.rbk.client.endpoint;

import lombok.RequiredArgsConstructor;
import org.github.zenovinav.rbk.core.model.TransactionMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/transaction")
public class TransactionEndpoint {

    private final KafkaTemplate<String, TransactionMessage> kafkaTemplate;

    @PostMapping("/send")
    public ResponseEntity<?> send(@RequestBody TransactionMessage message) {
        kafkaTemplate.send("transactions", message);

        return ResponseEntity.ok().build();
    }
}
