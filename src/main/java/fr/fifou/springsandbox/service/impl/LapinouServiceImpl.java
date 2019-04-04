package fr.fifou.springsandbox.service.impl;

import fr.fifou.springsandbox.mapper.BasicReferenceMapper;
import fr.fifou.springsandbox.model.dto.BasicReferenceDto;
import fr.fifou.springsandbox.model.dto.Lapinou;
import fr.fifou.springsandbox.repository.LapinouRepository;
import fr.fifou.springsandbox.service.LapinouService;
import fr.fifou.springsandbox.utils.MapToStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Service de gestion des sites
 *
 * @author Philippe Escure
 */
@Service
public class LapinouServiceImpl implements LapinouService {
    private static final String SHORTNAME_KEY = "SHORTNAME";
    private static final String FULLNAME_KEY = "FULLNAME";
    private static final String START_SEPARATOR = "===";
    private static final String END_SEPARATOR = "---";

    /**
     * Repository de gestion de mon lapinou.
     */
    private LapinouRepository lapinouRepository;

    /**
     * Mapper d'un référence simple.
     */
    private BasicReferenceMapper basicReferenceMapper;

    /**
     * Constructeur
     */
    @Autowired
    public LapinouServiceImpl(LapinouRepository lapinouRepository, BasicReferenceMapper basicReferenceMapper) {
        this.lapinouRepository = lapinouRepository;
        this.basicReferenceMapper = basicReferenceMapper;
    }

    @Override public BasicReferenceDto get() {
        Lapinou lapinou = lapinouRepository.get();
        Map<String, String> lapinouMap = MapToStringUtils.parseString(lapinou.getFifouData(), START_SEPARATOR, END_SEPARATOR);
        BasicReferenceDto lapinouDto = new BasicReferenceDto();
        lapinouDto.setShortName(lapinouMap.get(SHORTNAME_KEY));
        lapinouDto.setFullName(lapinouMap.get(FULLNAME_KEY));
        return lapinouDto;
    }

    @Override public void update(BasicReferenceDto lapinouDto) {
        Map<String, String> lapinouMap = new HashMap<>();
        lapinouMap.put(SHORTNAME_KEY, lapinouDto.getShortName());
        lapinouMap.put(FULLNAME_KEY, lapinouDto.getFullName());
        String lapinouData = MapToStringUtils.buildString(lapinouMap, START_SEPARATOR, END_SEPARATOR);
        lapinouRepository.set(new Lapinou(lapinouData));
    }
}
