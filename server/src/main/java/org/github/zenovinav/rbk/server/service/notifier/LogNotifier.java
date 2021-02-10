package org.github.zenovinav.rbk.server.service.notifier;

import lombok.extern.slf4j.Slf4j;
import org.github.zenovinav.rbk.core.model.ResultMessage;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LogNotifier implements Notifier {

    @Override
    public void process(ResultMessage message) {
        log.info("Обработана транзакция {}. Статус: {}.", message.getId(), message.getStatus().getDescription());
    }
}
