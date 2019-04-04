package fr.fifou.springsandbox.repository;

import fr.fifou.springsandbox.model.BasicReference;
import fr.fifou.springsandbox.model.dto.Lapinou;

import java.io.IOException;
import java.util.List;

/**
 * Gestion du référenciel des sites
 *
 * @author Philippe Escure
 */
public interface LapinouRepository {
  /**
   * Récupère les données de mon lapin.
   *
   * @return Un tableau de sites.
   */
  Lapinou get();

  /**
   * Modifie le sdonnée de mon lapin.
   *
   * @param lapinou Les nouvelles infos sur le lapin.
   */
  void set(Lapinou lapinou);
}
