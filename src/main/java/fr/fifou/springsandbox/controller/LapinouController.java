package fr.fifou.springsandbox.controller;

import fr.fifou.springsandbox.model.dto.BasicReferenceDto;
import fr.fifou.springsandbox.service.LapinouService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * API de gestion des sites.
 */
@RestController
@RequestMapping("lapinou")
public class LapinouController {
  /**
   * Service de gestion des sites.
   */
  private final LapinouService lapinouService;

  @Autowired
  public LapinouController(LapinouService lapinouService) {
    this.lapinouService = lapinouService;
  }

  /**
   * Récupération de tous les sites.
   *
   * @return La liste des sites enregistrés.
   */
  @GetMapping()
  BasicReferenceDto get() {
    return lapinouService.get();
  }

  /**
   * Récupération de tous les sites.
   *
   * @return La liste des sites enregistrés.
   */
  @PostMapping()
  void update(@RequestBody BasicReferenceDto lapinou) {
    lapinouService.update(lapinou);
  }
}
