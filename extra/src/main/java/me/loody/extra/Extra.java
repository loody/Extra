/*
 *  Created by loody 7/2/17 12:09 AM .
 */

package me.loody.extra;

import android.app.Activity;
import android.support.v4.app.Fragment;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by loody on 02/07/2017.
 */

public class Extra {
    static final String EXTRA_CLASS_SUFFIX = "$$Extra$$ExtraInjector";

    static Map<String, Class<ExtraInjector>> injectors = new HashMap<>();

    /**
     * Auto inject params from bundle.
     *
     * @param obj Activity or Fragment.
     */
    @SuppressWarnings("unchecked")
    public static void inject(Object obj) {
        if (obj instanceof Activity || obj instanceof Fragment || obj instanceof android.app.Fragment) {
            String key = obj.getClass().getCanonicalName();
            Class<ExtraInjector> clz;
            if (!injectors.containsKey(key)) {
                try {
                    clz = (Class<ExtraInjector>) Class.forName(key + EXTRA_CLASS_SUFFIX);
                    injectors.put(key, clz);
                } catch (ClassNotFoundException e) {
                    ELog.e("Inject extras failed.", e);
                    return;
                }
            } else {
                clz = injectors.get(key);
            }
            try {
                ExtraInjector injector = clz.newInstance();
                injector.inject(obj);
            } catch (Exception e) {
                ELog.e("Inject extras failed.", e);
            }
        } else {
            ELog.e("The obj you passed must be an instance of Activity or Fragment.");
        }
    }
}
