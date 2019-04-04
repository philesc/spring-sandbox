package fr.fifou.springsandbox.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Représente un model standard de données referentiel.
 *
 * @author Bensmaine Hakim
 */
@Data
@EqualsAndHashCode(exclude = { "fullName" })
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BasicReference {
  /**
   * Id fonctionnel.
   */
  private String shortName;

  /**
   * Libelle complet.
   */
  private String fullName;
}
