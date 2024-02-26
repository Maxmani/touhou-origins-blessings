package net.reimaden.touhoublessings.util;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;

public class EntityUtil {

    public static void addBeastSpiritAttributes(LivingEntity entity) {
        if (entity.getAttributes().hasAttribute(EntityAttributes.GENERIC_ARMOR)) {
            EntityAttributeInstance instance = entity.getAttributeInstance(EntityAttributes.GENERIC_ARMOR);
            if (instance != null) {
                instance.addPersistentModifier(
                        new EntityAttributeModifier("Spirit Beasts bonus", 4.0, EntityAttributeModifier.Operation.ADDITION)
                );
            }
        }
    }
}
