package com.scotia.customer.application.handler;

import javax.transaction.Transactional;

public interface CommandHandler <C> {
    @Transactional
    void ejecutar(C comando);
}
