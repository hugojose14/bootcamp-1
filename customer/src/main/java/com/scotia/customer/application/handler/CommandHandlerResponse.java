package com.scotia.customer.application.handler;

import javax.transaction.Transactional;

public interface CommandHandlerResponse <C, R> {
    @Transactional
    R execute(C comando) throws Exception;
}