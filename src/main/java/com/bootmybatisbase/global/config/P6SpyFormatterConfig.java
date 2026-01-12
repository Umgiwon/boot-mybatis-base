package com.bootmybatisbase.global.config;

import com.github.vertical_blank.sqlformatter.SqlFormatter;
import com.p6spy.engine.logging.Category;
import com.p6spy.engine.spy.P6SpyOptions;
import com.p6spy.engine.spy.appender.MessageFormattingStrategy;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import java.util.Locale;

/**
 * P6Spy 쿼리 로그 포매터 설정 클래스
 */
@Configuration
public class P6SpyFormatterConfig implements MessageFormattingStrategy {

    private static final String DDL_CREATE = "create";
    private static final String DDL_ALTER = "alter";
    private static final String DDL_COMMENT = "comment";
    private static final String LOG_FORMAT = "[%s] | %d ms | %s";
    private static final String EMPTY_RESULT = "";


    /**
     * P6Spy가 해당 클래스의 포매팅 전략을 사용하도록 설정
     */
    @PostConstruct
    public void init() {
        P6SpyOptions.getActiveInstance().setLogMessageFormat(this.getClass().getName());
    }

    /**
     * 로그 출력 형식 정의
     */
    @Override
    public String formatMessage(int connectionId, String now, long elapsed, String category, String prepared, String sql, String url) {
        if (!StringUtils.hasText(sql)) return EMPTY_RESULT;

        String formattedSql = formatSql(category, sql);
        return String.format(LOG_FORMAT, category, elapsed, formattedSql);
    }

    /**
     * SQL 구문 형식화 처리
     */
    private String formatSql(String category, String sql) {
        if (!Category.STATEMENT.getName().equals(category)) {
            return sql;
        }

        String trimmedSql = sql.trim().toLowerCase(Locale.ROOT);

        if (isDdlStatement(trimmedSql)) {
            return "\n" + SqlFormatter.format(sql) + "\n";
        }

        return "\n" + SqlFormatter.format(sql) + "\n";
    }

    /**
     * DDL 문 여부 확인
     */
    private boolean isDdlStatement(String sql) {
        return sql.startsWith(DDL_CREATE) || sql.startsWith(DDL_ALTER) || sql.startsWith(DDL_COMMENT);
    }
}
