package com.nad2040.ice_boat_drifting.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BoatEntity.class)
public abstract class BoatEntityMixin {
	@Inject(at = @At("TAIL"), method = "<init>(Lnet/minecraft/entity/EntityType;Lnet/minecraft/world/World;)V")
	public void BoatEntity(EntityType<? extends BoatEntity> entityType, World world, CallbackInfo ci) {
		((BoatEntity) (Object) this).setStepHeight(0.5f);
	}

	@ModifyConstant(constant = @Constant(floatValue = 0.9F, ordinal = 2), method = "updateVelocity()V")
	public float updateVelocity(float f) {
		return 0.99F;
	}
}
