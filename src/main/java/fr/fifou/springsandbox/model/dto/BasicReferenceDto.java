package fr.fifou.springsandbox.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import fr.fifou.springsandbox.model.BasicReference;
import fr.fifou.springsandbox.utils.ComparableUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * DTO représentant un model referentiel.
 *
 * @author Hakim BENSMAINE
 * @see BasicReference
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = "fullName")
@JsonIgnoreProperties(ignoreUnknown = true)
public class BasicReferenceDto {

  /**
   * Id fonctionnel
   */
  protected String shortName;

  /**
   * Libelle complet
   */
  protected String fullName;
}
