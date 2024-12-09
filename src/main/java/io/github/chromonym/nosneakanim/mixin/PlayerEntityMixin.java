package io.github.chromonym.nosneakanim.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import net.minecraft.entity.EntityPose;
import net.minecraft.entity.player.PlayerEntity;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends EntityMixin {
    @Shadow
    protected abstract boolean canChangeIntoPose(EntityPose pose);
}
