package fr.fifou.springsandbox.mapper;

import fr.fifou.springsandbox.model.BasicReference;
import fr.fifou.springsandbox.model.dto.BasicReferenceDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * Gestion du mapping du modèle de site avec le DTO.
 *
 * @author Philippe Escure
 */
@Mapper(componentModel = "spring")
public interface BasicReferenceMapper {
  /**
   * Map le modèle d'un site avec le DTO
   *
   * @param reference modèle de la référence
   * @return DTO de la référence
   */
  @Mappings({
      @Mapping(target="shortName", source="shortName"),
      @Mapping(target="fullName", source="fullName")
  })
  BasicReferenceDto basicReferenceToBasicReferenceDto(BasicReference reference);
}
