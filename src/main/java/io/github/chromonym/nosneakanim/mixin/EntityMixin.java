package io.github.chromonym.nosneakanim.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.entity.Entity;

@Mixin(Entity.class)
public abstract class EntityMixin {
    @Inject(method = "getStandingEyeHeight", at = @At("HEAD"), cancellable = true)
    protected void modifyEyeHeight(CallbackInfoReturnable<Float> ci) {}
}
