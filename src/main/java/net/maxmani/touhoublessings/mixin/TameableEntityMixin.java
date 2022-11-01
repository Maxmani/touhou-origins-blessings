package net.maxmani.touhoublessings.mixin;

import net.maxmani.touhoublessings.registry.ModPowers;
import net.maxmani.touhoublessings.util.EntityUtil;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TameableEntity.class)
public abstract class TameableEntityMixin extends AnimalEntity {

    protected TameableEntityMixin(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "setOwner", at = @At("HEAD"))
    private void applyBeastSpiritBonus(PlayerEntity player, CallbackInfo ci) {
        if(ModPowers.STURDY_BEASTS.isActive(player)) {
            EntityUtil.addBeastSpiritAttributes(this);
        }
    }
}
