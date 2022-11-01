package net.maxmani.touhoublessings.registry;

import io.github.apace100.apoli.power.Power;
import io.github.apace100.apoli.power.PowerType;
import io.github.apace100.apoli.power.PowerTypeReference;
import net.maxmani.touhoublessings.TouhouBlessings;
import net.minecraft.util.Identifier;

public class ModPowers {

    public static final PowerType<Power> HUSBANDRY_MASTER = new PowerTypeReference<>(new Identifier(TouhouBlessings.MOD_ID, "husbandry_master"));
    public static final PowerType<Power> STURDY_BEASTS = new PowerTypeReference<>(new Identifier(TouhouBlessings.MOD_ID, "sturdy_beasts"));
}
