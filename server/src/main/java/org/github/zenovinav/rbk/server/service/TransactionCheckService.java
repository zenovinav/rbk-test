package org.github.zenovinav.rbk.server.service;

import lombok.RequiredArgsConstructor;
import org.github.zenovinav.rbk.core.model.ResultMessage;
import org.github.zenovinav.rbk.core.model.ResultMessageStatus;
import org.github.zenovinav.rbk.server.repository.TransactionRepository;
import org.github.zenovinav.rbk.server.service.notifier.Notifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionCheckService {

    private static final String SQL = "select amount from transactions where id = :id";

    private final TransactionRepository transactionRepository;

    @Autowired
    private List<Notifier> notifiers;

    public void check(Long id, Double amount) {
        var optional = transactionRepository.findById(id);

        var message = new ResultMessage();
        message.setId(id);

        if (optional.isEmpty())
        {
            message.setStatus(ResultMessageStatus.NOT_FOUND);
        }
        else if (!optional.get().getAmount().equals(amount))
        {
            message.setStatus(ResultMessageStatus.INCORRECT_AMOUNT);
        }
        else
        {
            message.setStatus(ResultMessageStatus.SUCCESS);
        }

        notifiers.forEach(notifier -> notifier.process(message));
    }
}
