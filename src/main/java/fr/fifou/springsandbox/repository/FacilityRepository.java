package fr.fifou.springsandbox.repository;

import fr.fifou.springsandbox.model.BasicReference;

import java.io.IOException;
import java.util.List;

/**
 * Gestion du référenciel des sites
 *
 * @author Philippe Escure
 */
public interface FacilityRepository {
  /**
   * Récupère les données des sites.
   *
   * @return Un tableau de sites.
   * @throws java.io.FileNotFoundException Erreur de lecture du fichier de données.
   */
  List<BasicReference> getAll() throws IOException;
}
