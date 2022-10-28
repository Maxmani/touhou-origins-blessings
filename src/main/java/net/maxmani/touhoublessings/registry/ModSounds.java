package net.maxmani.touhoublessings.registry;

import net.maxmani.touhoublessings.TouhouBlessings;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

@SuppressWarnings("unused")
public class ModSounds {

    public static final SoundEvent BLESSING_MIRACLE_TRIGGER = registerSound("blessing.miracle.trigger");

    private static SoundEvent registerSound(String name) {
        Identifier id = new Identifier(TouhouBlessings.MOD_ID, name);
        return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(id));
    }

    public static void register() {
        TouhouBlessings.LOGGER.debug("Registering sounds for " + TouhouBlessings.class);
    }
}
