package ru.javawebinar.topjava.util;


import org.springframework.core.convert.converter.Converter;

import java.time.LocalDateTime;


/**
 * Created by SergeiRodionov.ru on 26.10.2015.
 */

public class StringToLocalDateTimeConverter implements Converter<String, LocalDateTime> {
    @Override
    public LocalDateTime convert(String source) {
        return TimeUtil.parseLocalDateTime(source);
    }
}
