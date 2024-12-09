package io.github.chromonym.nosneakanim;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.annotation.ConfigEntry.Gui.EnumHandler.EnumDisplayOption;
import net.minecraft.client.MinecraftClient;

@Config(name = "nosneakanim")
public class NoSneakAnimConfig implements ConfigData {
    public boolean disableSneak = true;
    @ConfigEntry.Gui.EnumHandler(option = EnumDisplayOption.BUTTON)
    public SneakingEyeHeightType sneakingEyeHeightType = SneakingEyeHeightType.DEFAULT;
    @ConfigEntry.Gui.Tooltip
    public float customSneakingEyeHeight = 1.27f;
    public boolean modifyThirdPersonHeight = false;

    public float getSneakingEyeHeight(float height) {
        if (modifyThirdPersonHeight || MinecraftClient.getInstance().options.getPerspective().isFirstPerson()) {
            height = switch (sneakingEyeHeightType) {
                case DEFAULT -> height;
                case PRE_1_14 -> 1.42f;
                case PRE_1_9 -> 1.54f;
                case CUSTOM ->
                    customSneakingEyeHeight < 0.1f ? 0.1f : ( // not so low the camera clips into the ground
                    customSneakingEyeHeight > 1.62f ? 1.62f : // not above standing eye height
                    customSneakingEyeHeight);
            };
        }
        return height;
    }

    private enum SneakingEyeHeightType {
        DEFAULT,
        PRE_1_14,
        PRE_1_9,
        CUSTOM
    }
}
