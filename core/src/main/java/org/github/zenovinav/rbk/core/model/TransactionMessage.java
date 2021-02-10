package org.github.zenovinav.rbk.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionMessage {

    @JsonProperty("PID")
    private Long id;

    @JsonProperty("PAMOUNT")
    private Double amount;

    @JsonProperty("PDATA")
    private Long data;
}
