package net.reimaden.touhoublessings.mixin;

import net.reimaden.touhoublessings.registry.ModPowers;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity {

    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @ModifyVariable(method = "tickMovement", at = @At("STORE"), index = 2)
    private Box touhoublessings$increasePickupRange(Box value) {
        if (ModPowers.SPACETIME_MANIPULATION.isActive(((PlayerEntity) (Object) this))) {
            return value.expand(2);
        }
        return value;
    }
}
