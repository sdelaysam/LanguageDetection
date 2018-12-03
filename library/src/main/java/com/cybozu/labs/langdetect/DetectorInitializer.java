package com.cybozu.labs.langdetect;

import com.cybozu.labs.langdetect.util.LangProfile;

import net.arnx.jsonic.JSON;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created on 12/3/18.
 *
 * @author sdelaysam
 */
public class DetectorInitializer {

    public static void init(String... profiles) {
        DetectorFactory.clear();
        int size = profiles.length;
        int index = 0;
        for (String profile : profiles) {
            String resource = "profiles/" + profile;
            InputStream inputStream = DetectorInitializer.class.getClassLoader().getResourceAsStream(resource);
            try {
                LangProfile lang = JSON.decode(inputStream, LangProfile.class);
                DetectorFactory.addProfile(lang, index, size);
                ++index;
            } catch (IOException e) {
                e.printStackTrace();
            } catch (LangDetectException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (inputStream != null) inputStream.close();
                } catch (IOException e) {}
            }
        }
    }
}
