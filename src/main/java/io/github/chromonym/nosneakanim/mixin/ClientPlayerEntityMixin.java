package io.github.chromonym.nosneakanim.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import io.github.chromonym.nosneakanim.NoSneakAnimation;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.EntityPose;

@Mixin(ClientPlayerEntity.class)
public abstract class ClientPlayerEntityMixin extends PlayerEntityMixin {

    @Override
    public void modifyEyeHeight(CallbackInfoReturnable<Float> ci) {
        EntityPose pose = ((ClientPlayerEntity)(Object)this).getPose();
        float height = ((ClientPlayerEntity)(Object)this).getEyeHeight(pose);
        // Don't modify height if player stands under a block
        if (pose == EntityPose.CROUCHING && canChangeIntoPose(EntityPose.STANDING)) {
            ci.setReturnValue(NoSneakAnimation.config.getSneakingEyeHeight(height));
            ci.cancel();
        }
    }
    
}
