package net.maxmani.touhoublessings.mixin;

import net.maxmani.touhoublessings.registry.ModPowers;
import net.maxmani.touhoublessings.util.EntityUtil;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.AbstractHorseEntity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractHorseEntity.class)
public class AbstractHorseEntityMixin {

    @Inject(method = "bondWithPlayer", at = @At("TAIL"))
    private void applyBeastSpiritBonus(PlayerEntity player, CallbackInfoReturnable<Boolean> cir) {
        if(ModPowers.STURDY_BEASTS.isActive(player)) {
            EntityUtil.addBeastSpiritAttributes((LivingEntity) (Object) this);
        }
    }
}
