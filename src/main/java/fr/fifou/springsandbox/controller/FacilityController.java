package fr.fifou.springsandbox.controller;

import fr.fifou.springsandbox.model.dto.BasicReferenceDto;
import fr.fifou.springsandbox.service.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * API de gestion des sites.
 */
@RestController
@RequestMapping("facility")
public class FacilityController {
  /**
   * Service de gestion des sites.
   */
  private final FacilityService facilityService;

  @Autowired
  public FacilityController(FacilityService facilityService) {
    this.facilityService = facilityService;
  }

  /**
   * Récupération de tous les sites.
   *
   * @return La liste des sites enregistrés.
   * @throws java.io.FileNotFoundException Fichier de configuration introuvable.
   */
  @GetMapping()
  List<BasicReferenceDto> getAll() throws IOException {
    return facilityService.getAll();
  }
}
