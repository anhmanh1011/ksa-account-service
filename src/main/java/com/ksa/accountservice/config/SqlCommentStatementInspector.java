package com.kss.springbootkeycloak.config;

import lombok.extern.log4j.Log4j2;
import org.hibernate.resource.jdbc.spi.StatementInspector;

@Log4j2
public class SqlCommentStatementInspector implements StatementInspector {
    @Override
    public String inspect(String s) {
        log.info("exec sql: " + s);
        return s;
    }
}
