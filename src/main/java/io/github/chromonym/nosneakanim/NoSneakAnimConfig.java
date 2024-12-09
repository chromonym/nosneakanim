package io.github.chromonym.nosneakanim;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

@Config(name = "nosneakanim")
public class NoSneakAnimConfig implements ConfigData {
    public boolean disableSneak = true;
}
