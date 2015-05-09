/**
 * Silbato Project: Proyecto 100% Mexicano de código libre.
 *
 * @author      Anibal Gomez <anibalgomez@icloud.com>
 * @copyright   Copyright (C) 2015 Neblina Software. Derechos reservados.
 * @license     Licencia Pública GNU versión 3 o superior; vea LICENSE.txt
 */

package com.neblina.balero.service.impl;

import com.neblina.balero.domain.Settings;
import com.neblina.balero.service.repository.SettingsRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Locale;

@Service
public class TemplateAttributesImpl {

    private static final Logger log = LogManager.getLogger(TemplateAttributesImpl.class.getName());

    private final SettingsRepository settingsRepository;

    @Autowired
    public TemplateAttributesImpl(SettingsRepository settingsRepository) {
        this.settingsRepository = settingsRepository;
    }

    @Transactional
    public HashMap<String, String> add() {
        Locale locale = LocaleContextHolder.getLocale();
        log.debug("Default Locale: " + locale.toString());
        HashMap<String, String> map = new HashMap<>();
        map.put("example", "Example");
        for (Settings settings : settingsRepository.findAll()) {
            map.put("code", settings.getCode());
            map.put("title", settings.getTitle());
            map.put("titleHeader", settings.getTitleHeader());
            log.debug("Header: " + settings.getTitleHeader());
            map.put("administratorEmail", settings.getAdministratorEmail());
            map.put("footer", settings.getFooter());
        }
        return map;
    }

}
