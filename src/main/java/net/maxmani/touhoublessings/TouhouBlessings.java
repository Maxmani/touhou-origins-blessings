package net.maxmani.touhoublessings;

import net.fabricmc.api.ModInitializer;
import net.maxmani.touhoublessings.registry.ModSounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TouhouBlessings implements ModInitializer {

	public static final String MOD_ID = "touhoublessings";
	public static final Logger LOGGER = LoggerFactory.getLogger("Touhou Origins: Blessings");

	@Override
	public void onInitialize() {
		LOGGER.info("Blessing your origins.");

		ModSounds.register();
	}
}
