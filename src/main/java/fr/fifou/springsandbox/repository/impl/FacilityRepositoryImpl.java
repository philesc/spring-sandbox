package fr.fifou.springsandbox.repository.impl;

import fr.fifou.springsandbox.model.BasicReference;
import fr.fifou.springsandbox.repository.FacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.io.IOException;
import java.util.List;

/**
 * Gestion du référenciel des sites
 *
 * @author Philippe Escure
 */
@Repository
public class FacilityRepositoryImpl extends BasicReferenceRepositoryImpl implements FacilityRepository {
  /**
   * Nom du Fichier de données des sites.
   */
  private static final String DATA_FILE = "facilities.json";

  /**
   * Construteur.
   */
  @Autowired
  public FacilityRepositoryImpl() {
    // Injected Method
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<BasicReference> getAll() throws IOException {
    return super.getAll(DATA_FILE, BasicReference[].class);
  }
}
