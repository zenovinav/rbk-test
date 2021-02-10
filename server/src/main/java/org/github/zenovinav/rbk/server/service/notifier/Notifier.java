package org.github.zenovinav.rbk.server.service.notifier;

import org.github.zenovinav.rbk.core.model.ResultMessage;

public interface Notifier {

    void process(ResultMessage message);
}
