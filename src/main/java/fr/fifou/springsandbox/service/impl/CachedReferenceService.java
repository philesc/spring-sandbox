package fr.fifou.springsandbox.service.impl;

import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe abstraite décrivant le comportement commun des services réferentiels
 * representant une liste déroulante simple.
 *
 * @param <T> The reference model, must extends BasicReferenceModel.
 * @param <K> The reference DTO, must extends BasicReferenceDto.
 * @author Hakim BENSMAINE.
 */
abstract class CachedReferenceService<T, K>
    extends CachedService {

  /**
   * Liste des objets enregistrés.
   */
  private List<K> references;

  /**
   * Methode de récupèration des objets referentiels.
   *
   * @return Une liste d'objet representant un réferentiel.
   * @throws IOException Erreur de lecture du fichier.
   */
  public List<K> getAll() throws IOException {
    if (CollectionUtils.isEmpty(references) || areDataExpired()) {
      references = mapReferences();
      updateDataFreshness();
    }
    return references;
  }

  /**
   * Map une liste de modèle avec une nouvelle liste de DTO.
   * Appel à la lméthode abstraite mapReference pour chaques élément de la liste.
   *
   * @return La liste des nouveaux DTOs.
   * @throws IOException Echec de lecture des références.
   */
  private List<K> mapReferences() throws IOException {
    List<K> result = new ArrayList<>();
    List<T> models = getAllFromRepository();
    if (models != null) {
      for (T reference : models) {
        result.add(mapReference(reference));
      }
    }
    return result;
  }

  /**
   * Méthode d'appelle du répository.
   *
   * @return la liste d'objet model.
   */
  protected abstract List<T> getAllFromRepository() throws IOException;

  /**
   * methode de convertion unitaire d'un objet model en DTO
   *
   * @param reference un objet model.
   * @return un dto.
   */
  protected abstract K mapReference(T reference);
}
