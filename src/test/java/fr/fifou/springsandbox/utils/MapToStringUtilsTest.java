package fr.fifou.springsandbox.utils;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Test de la classe MapToStringUtils.
 */
public class MapToStringUtilsTest {
  private static final String SEPARATOR_START = "===";
  private static final String SEPARATOR_END = "---";

  @Test
  public void parseStringWithoutBeginKey() {
    String testCase = SEPARATOR_START + "AVIS REFERENT" + SEPARATOR_END + "Je suis un avis referent";
    Map<String, String> result = MapToStringUtils.parseString(testCase, SEPARATOR_START, SEPARATOR_END);
    assertEquals(2, result.size());
    assertEquals("", result.get(MapToStringUtils.START_KEY));
    assertEquals("Je suis un avis referent", result.get("AVIS REFERENT"));
  }

  @Test
  public void parseWithBeginKey() {
    String testCase = "Debut" + SEPARATOR_START + "AVIS REFERENT" + SEPARATOR_END + "Je suis un avis referent";
    Map<String, String> result = MapToStringUtils.parseString(testCase, SEPARATOR_START, SEPARATOR_END);
    assertEquals(2, result.size());
    assertEquals("Debut", result.get(MapToStringUtils.START_KEY));
    assertEquals("Je suis un avis referent", result.get("AVIS REFERENT"));
  }

  @Test
  public void parseStringWithoutSeparator() {
    String testCase = "Debut";
    Map<String, String> result = MapToStringUtils.parseString(testCase, SEPARATOR_START, SEPARATOR_END);
    assertEquals(1, result.size());
    assertEquals("Debut", result.get(MapToStringUtils.START_KEY));
  }

  @Test
  public void parseStringWithEmptyString() {
    String testCase = "";
    Map<String, String> result = MapToStringUtils.parseString(testCase, SEPARATOR_START, SEPARATOR_END);
    assertEquals(1, result.size());
    assertEquals("", result.get(MapToStringUtils.START_KEY));
  }

  @Test
  public void parseStringWithSeveralValues() {
    String testCase = "Debut" + SEPARATOR_START + "AVIS REFERENT" + SEPARATOR_END + "Je suis un avis referent" + SEPARATOR_START + "AVIS PALIER" + SEPARATOR_END + "Je suis un avis palier";
    Map<String, String> result = MapToStringUtils.parseString(testCase, SEPARATOR_START, SEPARATOR_END);
    assertEquals(3, result.size());
    assertEquals("Debut", result.get(MapToStringUtils.START_KEY));
    assertEquals("Je suis un avis referent", result.get("AVIS REFERENT"));
    assertEquals("Je suis un avis palier", result.get("AVIS PALIER"));
  }

  /**
   * Parsing de ma chaine avec une valeur vide sur la clé du milieu.
   */
  @Test
  public void parseStringWithEmptyValueOnMiddleKey() {
    String testCase = "Debut" + SEPARATOR_START + "AVIS REFERENT" + SEPARATOR_END + "" + SEPARATOR_START + "AVIS PALIER" + SEPARATOR_END + "Je suis un avis palier";
    Map<String, String> result = MapToStringUtils.parseString(testCase, SEPARATOR_START, SEPARATOR_END);
    assertEquals(3, result.size());
    assertEquals("Debut", result.get(MapToStringUtils.START_KEY));
    assertEquals("", result.get("AVIS REFERENT"));
    assertEquals("Je suis un avis palier", result.get("AVIS PALIER"));
  }

  @Test
  public void parseStringWithEmptyValueOnEndKey() {
    String testCase = "Debut" + SEPARATOR_START + "AVIS REFERENT" + SEPARATOR_END + "Je suis un avis referent" + SEPARATOR_START + "AVIS PALIER" + SEPARATOR_END + "";
    Map<String, String> result = MapToStringUtils.parseString(testCase, SEPARATOR_START, SEPARATOR_END);
    assertEquals(3, result.size());
    assertEquals("Debut", result.get(MapToStringUtils.START_KEY));
    assertEquals("Je suis un avis referent", result.get("AVIS REFERENT"));
    assertEquals("", result.get("AVIS PALIER"));
  }

  @Test
  public void buildStringWithoutBeginKey() {
    Map<String, String> testCase = new HashMap<>();
    testCase.put("AVIS REFERENT", "Je suis un avis referent");

    String expectedResult = "" + SEPARATOR_START + "AVIS REFERENT" + SEPARATOR_END + "Je suis un avis referent";
    String result = MapToStringUtils.buildString(testCase, SEPARATOR_START, SEPARATOR_END);
    assertEquals(expectedResult, result);
  }

  @Test
  public void buildStringWithBeginKey() {
    Map<String, String> testCase = new HashMap<>();
    testCase.put(MapToStringUtils.START_KEY, "Debut");
    testCase.put("AVIS REFERENT", "Je suis un avis referent");

    String expectedResult = "Debut" + SEPARATOR_START + "AVIS REFERENT" + SEPARATOR_END + "Je suis un avis referent";
    String result = MapToStringUtils.buildString(testCase, SEPARATOR_START, SEPARATOR_END);
    assertEquals(expectedResult, result);
  }

  @Test
  public void buildStringWithoutSeparator() {
    Map<String, String> testCase = new HashMap<>();
    testCase.put(MapToStringUtils.START_KEY, "Debut");

    String expectedResult = "Debut";
    String result = MapToStringUtils.buildString(testCase, SEPARATOR_START, SEPARATOR_END);
    assertEquals(expectedResult, result);
  }

  @Test
  public void buildStringWithEmptyString() {
    Map<String, String> testCase = new HashMap<>();

    String expectedResult = "";
    String result = MapToStringUtils.buildString(testCase, SEPARATOR_START, SEPARATOR_END);
    assertEquals(expectedResult, result);
  }

  @Test
  public void buildStringWithSeveralValues() {
    Map<String, String> testCase = new HashMap<>();
    testCase.put(MapToStringUtils.START_KEY, "Debut");
    testCase.put("AVIS REFERENT", "Je suis un avis referent");
    testCase.put("AVIS PALIER", "Je suis un avis palier");

    String expectedResult = "Debut" + SEPARATOR_START + "AVIS REFERENT" + SEPARATOR_END + "Je suis un avis referent" + SEPARATOR_START + "AVIS PALIER" + SEPARATOR_END + "Je suis un avis palier";
    String result = MapToStringUtils.buildString(testCase, SEPARATOR_START, SEPARATOR_END);
    assertEquals(expectedResult, result);
  }

  @Test
  public void buildStringWithEmptyValueOnMiddleKey() {
    Map<String, String> testCase = new HashMap<>();
    testCase.put(MapToStringUtils.START_KEY, "Debut");
    testCase.put("AVIS REFERENT", "");
    testCase.put("AVIS PALIER", "Je suis un avis palier");

    String expectedResult = "Debut" + SEPARATOR_START + "AVIS REFERENT" + SEPARATOR_END + "" + SEPARATOR_START + "AVIS PALIER" + SEPARATOR_END + "Je suis un avis palier";
    String result = MapToStringUtils.buildString(testCase, SEPARATOR_START, SEPARATOR_END);
    assertEquals(expectedResult, result);
  }

  @Test
  public void buildStringWithEmptyValueOnEndKey() {
    Map<String, String> testCase = new HashMap<>();
    testCase.put(MapToStringUtils.START_KEY, "Debut");
    testCase.put("AVIS REFERENT", "Je suis un avis referent");
    testCase.put("AVIS PALIER", "");

    String expectedResult = "Debut" + SEPARATOR_START + "AVIS REFERENT" + SEPARATOR_END + "Je suis un avis referent" + SEPARATOR_START + "AVIS PALIER" + SEPARATOR_END + "";
    String result = MapToStringUtils.buildString(testCase, SEPARATOR_START, SEPARATOR_END);
    assertEquals(expectedResult, result);
  }
}