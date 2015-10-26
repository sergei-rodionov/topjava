package ru.javawebinar.topjava.util;

import org.springframework.core.convert.converter.Converter;

import java.time.LocalDateTime;

/**
 * Created by SergeiRodionov.ru on 26.10.2015.
 */
public class LocalDateTimeToStringConverter implements Converter<LocalDateTime, String>{
    @Override
    public String convert(LocalDateTime source) {
        return TimeUtil.toString(source);
    }
}
