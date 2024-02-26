package net.reimaden.touhoublessings.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.Tameable;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.reimaden.touhoublessings.power.ModPowers;
import net.reimaden.touhoublessings.util.EntityUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TameableEntity.class)
public abstract class TameableEntityMixin extends AnimalEntity implements Tameable {

    protected TameableEntityMixin(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "setOwner", at = @At("HEAD"))
    private void touhoublessings$applyBeastSpiritBonus(PlayerEntity player, CallbackInfo ci) {
        if (ModPowers.STURDY_BEASTS.isActive(player)) {
            EntityUtil.addBeastSpiritAttributes(this);
        }
    }
}
