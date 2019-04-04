package fr.fifou.springsandbox.service;


import fr.fifou.springsandbox.model.dto.BasicReferenceDto;

import java.io.IOException;
import java.util.List;

/**
 * Service de gestion de coco le lapin.
 *
 * @author Philippe Escure
 */
public interface LapinouService {
  BasicReferenceDto get();

  void update(BasicReferenceDto lapinou);
}
