package net.reimaden.touhoublessings;

import net.fabricmc.api.ModInitializer;
import net.reimaden.touhoublessings.registry.ModSounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TouhouBlessings implements ModInitializer {

	public static final String MOD_ID = "touhoublessings";
	public static final String MOD_NAME = "Touhou Origins: Blessings";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

	@Override
	public void onInitialize() {
		LOGGER.info("Blessing your origins.");

		ModSounds.register();
	}
}
