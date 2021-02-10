package org.github.zenovinav.rbk.server.service.notifier;

import lombok.RequiredArgsConstructor;
import org.github.zenovinav.rbk.core.model.ResultMessage;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaNotifier implements Notifier {

    private final KafkaTemplate<String, ResultMessage> kafkaTemplate;

    @Override
    public void process(ResultMessage message) {
        kafkaTemplate.send("results", message);
    }
}
