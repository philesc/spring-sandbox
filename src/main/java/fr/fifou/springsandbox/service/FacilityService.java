package fr.fifou.springsandbox.service;


import fr.fifou.springsandbox.model.dto.BasicReferenceDto;

import java.io.IOException;
import java.util.List;

/**
 * Service de gestion des sites.
 *
 * @author Philippe Escure
 */
public interface FacilityService {
  /**
   * Récupère tous les sites.
   *
   * @return La liste des sites.
   * @throws java.io.FileNotFoundException Erreur de lecture du fichier de données.
   */
  List<BasicReferenceDto> getAll() throws IOException;

}
