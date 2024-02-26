package net.reimaden.touhoublessings.power;

import io.github.apace100.apoli.power.Power;
import io.github.apace100.apoli.power.PowerType;
import io.github.apace100.apoli.power.PowerTypeReference;
import net.reimaden.touhoublessings.TouhouBlessings;

public class ModPowers {

    public static final PowerType<Power> HUSBANDRY_MASTER = new PowerTypeReference<>(TouhouBlessings.id("husbandry_master"));
    public static final PowerType<Power> STURDY_BEASTS = new PowerTypeReference<>(TouhouBlessings.id("sturdy_beasts"));
}
