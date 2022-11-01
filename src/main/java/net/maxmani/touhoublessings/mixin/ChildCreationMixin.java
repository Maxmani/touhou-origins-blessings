package net.maxmani.touhoublessings.mixin;

import net.maxmani.touhoublessings.registry.ModPowers;
import net.maxmani.touhoublessings.util.EntityUtil;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

public class ChildCreationMixin {

    @Mixin(WolfEntity.class)
    public static abstract class WolfKids extends TameableEntity {

        protected WolfKids(EntityType<? extends TameableEntity> entityType, World world) {
            super(entityType, world);
        }

        @Inject(method = "createChild(Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/entity/passive/PassiveEntity;)Lnet/minecraft/entity/passive/WolfEntity;", at = @At("RETURN"))
        private void applyBeastSpiritBonus(ServerWorld serverWorld, PassiveEntity passiveEntity, CallbackInfoReturnable<WolfEntity> cir) {
            if(ModPowers.STURDY_BEASTS.isActive(this.getOwner())) {
                EntityUtil.addBeastSpiritAttributes(cir.getReturnValue());
            }
        }
    }

    @Mixin(CatEntity.class)
    public static abstract class CatKids extends TameableEntity {

        protected CatKids(EntityType<? extends TameableEntity> entityType, World world) {
            super(entityType, world);
        }

        @Inject(method = "createChild(Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/entity/passive/PassiveEntity;)Lnet/minecraft/entity/passive/CatEntity;", at = @At("RETURN"))
        private void applyBeastSpiritBonus(ServerWorld world, PassiveEntity entity, CallbackInfoReturnable<PassiveEntity> cir) {
            if(ModPowers.STURDY_BEASTS.isActive(this.getOwner())) {
                EntityUtil.addBeastSpiritAttributes(cir.getReturnValue());
            }
        }
    }

    @Mixin(HorseEntity.class)
    public static abstract class HorseKids extends AbstractHorseEntity {

        protected HorseKids(EntityType<? extends AbstractHorseEntity> entityType, World world) {
            super(entityType, world);
        }

        @Inject(method = "createChild", at = @At("RETURN"))
        private void applyBeastSpiritBonus(ServerWorld world, PassiveEntity entity, CallbackInfoReturnable<PassiveEntity> cir) {
            if(ModPowers.STURDY_BEASTS.isActive(world.getPlayerByUuid(this.getOwnerUuid()))) {
                EntityUtil.addBeastSpiritAttributes(cir.getReturnValue());
            }
        }
    }
}
