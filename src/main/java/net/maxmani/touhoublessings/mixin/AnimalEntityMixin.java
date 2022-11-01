package net.maxmani.touhoublessings.mixin;

import net.maxmani.touhoublessings.registry.ModPowers;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AnimalEntity.class)
public abstract class AnimalEntityMixin {

    @Inject(method = "breed", at = @At("TAIL"))
    private void reduceBreedingCooldown(ServerWorld world, AnimalEntity other, CallbackInfo ci) {
        AnimalEntity animal = ((AnimalEntity) (Object) this);
        if (ModPowers.HUSBANDRY_MASTER.isActive(animal.getLovingPlayer())) {
            animal.setBreedingAge(3000);
            other.setBreedingAge(3000);
        }
    }
}
