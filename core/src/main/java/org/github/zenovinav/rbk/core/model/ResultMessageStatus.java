package org.github.zenovinav.rbk.core.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultMessageStatus {

    NOT_FOUND("Транзакция не найдена в базе"),
    INCORRECT_AMOUNT("Сумма не совпадает"),
    SUCCESS("Корректная транзакция");

    private final String description;
}
