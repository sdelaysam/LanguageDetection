package com.cybozu.labs.langdetect;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created on 12/3/18.
 *
 * @author sdelaysam
 */
public class ProfilesTest {

    @Test
    public void testEn() throws LangDetectException {
        testLang("en", "Good morning");
    }

    @Test
    public void testEs() throws LangDetectException {
        testLang("es", "Buenos días");
    }

    @Test
    public void testRu() throws LangDetectException {
        testLang("ru", "Доброе утро");
    }

    @Test
    public void testTr() throws LangDetectException {
        testLang("tr", "Günaydın");
    }

    @Test
    public void testMultiple() throws LangDetectException {
        DetectorInitializer.init("en", "es", "ru", "tr");
        Detector detector = DetectorFactory.create();
        detector.append("Good morning");
        assertEquals("en", detector.detect());

        detector = DetectorFactory.create();
        detector.append("Buenos días");
        assertEquals("es", detector.detect());

        detector = DetectorFactory.create();
        detector.append("Доброе утро");
        assertEquals("ru", detector.detect());

        detector = DetectorFactory.create();
        detector.append("Günaydın");
        assertEquals("tr", detector.detect());
    }

    private void testLang(String profile, String test) throws LangDetectException {
        DetectorInitializer.init(profile);
        Detector detector = DetectorFactory.create();
        detector.append(test);
        assertEquals(profile, detector.detect());
    }

}
