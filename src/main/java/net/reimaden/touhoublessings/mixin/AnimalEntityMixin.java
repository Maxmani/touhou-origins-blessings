package net.reimaden.touhoublessings.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import net.reimaden.touhoublessings.power.ModPowers;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AnimalEntity.class)
public abstract class AnimalEntityMixin extends PassiveEntity {

    @Shadow @Nullable public abstract ServerPlayerEntity getLovingPlayer();

    protected AnimalEntityMixin(EntityType<? extends PassiveEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "breed(Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/entity/passive/AnimalEntity;)V", at = @At("TAIL"))
    private void touhoublessings$reduceBreedingCooldown(ServerWorld world, AnimalEntity other, CallbackInfo ci) {
        if (ModPowers.HUSBANDRY_MASTER.isActive(this.getLovingPlayer())) {
            this.setBreedingAge(3000);
            other.setBreedingAge(3000);
        }
    }
}
