package fr.fifou.springsandbox.repository.impl;

import fr.fifou.springsandbox.model.dto.Lapinou;
import fr.fifou.springsandbox.repository.LapinouRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Gestion du référenciel des sites
 */
@Repository
public class LapinouRepositoryImpl implements LapinouRepository {
  /**
   * Représente les données du lapin au format fifou.
   * La classe est un singleton donc cet attribut n'est instancé qu'une fois.
   */
  private String data = "===SHORTNAME---Coco===FULLNAME---Le Lapin";

  /**
   * Construteur.
   */
  @Autowired
  public LapinouRepositoryImpl() {
    // Injected Method
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Lapinou get() {
    return new Lapinou(data);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void set(Lapinou lapinou) {
    data = lapinou.getFifouData();
  }
}
