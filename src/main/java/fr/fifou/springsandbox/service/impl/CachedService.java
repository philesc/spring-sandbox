package fr.fifou.springsandbox.service.impl;

import lombok.Getter;

import java.util.Date;

/**
 * Service générique gérant le cache sur les données referentielles.
 *
 * @author Philippe Escure
 */
abstract class CachedService {
  /**
   * Taux de rafraichissement des données. 24h en millisecondes.
   */
  private static final long REFRESH_RATE_MS = 24L * 60 * 60 * 1000;

  /**
   * Date de fraicheur des données.
   */
  @Getter
  private static Date dataFreshness;

  static void updateDataFreshness() {
    dataFreshness = new Date();
  }

  /**
   * Vérifie la fraicheur des données.
   *
   * @return true si les données sont récentes, false si elles sont périmées.
   */
  boolean areDataExpired() {
    return dataFreshness == null || new Date().getTime() > dataFreshness.getTime() + REFRESH_RATE_MS;
  }
}
