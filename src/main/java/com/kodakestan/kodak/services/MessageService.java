package com.kodakestan.kodak.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

/**
 * Created by pc on 7/1/2017.
 */
@Service
public class MessageService {
    private final static Locale englishLocale = new Locale("en", "US");
    @Autowired
    private MessageSource messageSource;

    public String getMessage(String key) {
        return getMessage(key, englishLocale);
    }

    public String getMessageWithLocale(String key, Locale locale, Object... params) {
        return getMessage(key, locale, params);
    }

    public String getMessage(String key, Object... params) {

        return getMessage(key, englishLocale, params);
    }

    private String getMessage(String key, Locale locale) {
        return getMessage(key, locale, new Object[0]);
    }

    private String getMessage(String key, Locale locale, Object... params) {
        return messageSource.getMessage(key, params, locale);
    }
}
