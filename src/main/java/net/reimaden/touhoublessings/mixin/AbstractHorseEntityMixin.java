package net.reimaden.touhoublessings.mixin;

import net.reimaden.touhoublessings.registry.ModPowers;
import net.reimaden.touhoublessings.util.EntityUtil;
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
    private void touhoublessings$applyBeastSpiritBonus(PlayerEntity player, CallbackInfoReturnable<Boolean> cir) {
        if (ModPowers.STURDY_BEASTS.isActive(player)) {
            EntityUtil.addBeastSpiritAttributes((LivingEntity) (Object) this);
        }
    }
}
