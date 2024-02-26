package net.reimaden.touhoublessings.sound;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.reimaden.touhoublessings.TouhouBlessings;

@SuppressWarnings("unused")
public class ModSoundEvents {

    public static final SoundEvent BLESSING_MIRACLE_TRIGGER = registerSound("blessing.miracle.trigger");

    @SuppressWarnings("SameParameterValue")
    private static SoundEvent registerSound(String name) {
        Identifier id = TouhouBlessings.id(name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void register() {
        TouhouBlessings.LOGGER.debug("Registering sound events for " + TouhouBlessings.MOD_ID);
    }
}
