package net.reimaden.touhoublessings.mixin;

import net.minecraft.entity.*;
import net.minecraft.entity.passive.AbstractHorseEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.InventoryChangedListener;
import net.minecraft.world.World;
import net.reimaden.touhoublessings.power.ModPowers;
import net.reimaden.touhoublessings.util.EntityUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractHorseEntity.class)
public abstract class AbstractHorseEntityMixin extends AnimalEntity implements InventoryChangedListener, RideableInventory, Tameable, JumpingMount, Saddleable {

    protected AbstractHorseEntityMixin(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "bondWithPlayer", at = @At("TAIL"))
    private void touhoublessings$applyBeastSpiritBonus(PlayerEntity player, CallbackInfoReturnable<Boolean> cir) {
        if (ModPowers.STURDY_BEASTS.isActive(player)) {
            EntityUtil.addBeastSpiritAttributes(this);
        }
    }
}
