package fr.fifou.springsandbox.service.impl;

import fr.fifou.springsandbox.mapper.BasicReferenceMapper;
import fr.fifou.springsandbox.model.BasicReference;
import fr.fifou.springsandbox.model.dto.BasicReferenceDto;
import fr.fifou.springsandbox.repository.FacilityRepository;
import fr.fifou.springsandbox.service.FacilityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * Service de gestion des sites
 *
 * @author Philippe Escure
 */
@Service
public class FacilityServiceImpl extends CachedReferenceService<BasicReference, BasicReferenceDto> implements FacilityService {
    /**
     * LOGGER.
     */
    private static final Logger LOG = LoggerFactory.getLogger(FacilityServiceImpl.class);

    /**
     * Gestionnaire du référenciel des sites
     */
    private FacilityRepository facilityRepository;

    /**
     * Mapper d'un référence simple.
     */
    private BasicReferenceMapper basicReferenceMapper;

    /**
     * Constructeur
     *
     * @param facilityRepository Gestionnaire du référenciel des sites
     * @param basicReferenceMapper     Mapper du modèle avec le DTO
     */
    @Autowired
    public FacilityServiceImpl(FacilityRepository facilityRepository, BasicReferenceMapper basicReferenceMapper) {
        this.facilityRepository = facilityRepository;
        this.basicReferenceMapper = basicReferenceMapper;
    }

    /**
     * {@inheritDoc}]
     */
    @Override
    protected List<BasicReference> getAllFromRepository() throws IOException {
        return facilityRepository.getAll();
    }

    /**
     * methode de convertion unitaire d'un objet model en DTO
     *
     * @param reference un objet model.
     * @return un dto.
     */
    @Override
    protected BasicReferenceDto mapReference(BasicReference reference) {
        return basicReferenceMapper.basicReferenceToBasicReferenceDto(reference);
    }
}
