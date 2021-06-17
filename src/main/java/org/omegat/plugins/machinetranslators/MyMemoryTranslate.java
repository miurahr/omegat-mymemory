package org.omegat.plugins.machinetranslators;

import org.omegat.core.Core;

public class MyMemoryTranslate {

    public static void loadPlugins() {
        Core.registerMachineTranslationClass(MyMemoryHumanTranslate.class);
        Core.registerMachineTranslationClass(MyMemoryMachineTranslate.class);
    }

    public static void unloadPlugins() {

    }
}
