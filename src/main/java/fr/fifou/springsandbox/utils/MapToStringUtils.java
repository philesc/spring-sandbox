package fr.fifou.springsandbox.utils;

import io.micrometer.core.instrument.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Classe utilitaire permetant de transformer un map en string et inversement.
 * Utilisé pour ajouter des infos dans certains champs de l'EAM (commentaires, notes d'analyses, etc...).
 * Des clées sont utilisées pour séparer les valeurs dans la String.
 * separatorBegin correspond au début de la clé, separatorEnd à la fin de la clé.
 */
public class MapToStringUtils {
  /**
   * Index utilisé pour stocker le début d'une chaine de caractère avant la première clée.
   */
  public static final String START_KEY = "_START";

  /**
   * Constructeur privé (clzsse utilitaire).
   */
  private MapToStringUtils() {
  }

  /**
   * Parsing de la chaine donnée pour obtenir un MAP grâce aux séparateurs.
   *
   * @param input          La chaine à parser différentes valeurs séparées par des séparateurs.
   *                       Format : separatorBegin + uneClé + separatorEnd + uneValeur + separatorBegin + uneAutreClé ...
   * @param separatorBegin Le début de chaques séparateurs.
   * @param separatorEnd   La fin de chaques sépérateurs.
   * @return Map obtenu après parsing.
   */
  public static Map<String, String> parseString(String input, String separatorBegin, String separatorEnd) {
    return new HashMap<>();
  }

  /**
   * Utilisation d'un map donnée pour obtenir une String avec des séparateurs.
   * Cette String pourra être re transformée en Map avec la fonction parseString.
   *
   * @param input          Le map à builder.
   * @param separatorBegin Le début de chaques séparateurs.
   * @param separatorEnd   La fin de chaques sépérateurs.
   * @return La String buildée avec les séparateurs.
   */
  public static String buildString(Map<String, String> input, String separatorBegin, String separatorEnd) {
    return "";
  }
}
