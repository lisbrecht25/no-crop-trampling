package lukeisbrecht.notrampling;

import lukeisbrecht.notrampling.command.TramplingProtectionCommand;
import lukeisbrecht.notrampling.config.NoCropTramplingConfig;
import lukeisbrecht.notrampling.data.DataManager;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;


import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NoCropTrampling implements ModInitializer {
	public static final String MOD_ID = "no-trampling";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static NoCropTramplingConfig CONFIG;

	@Override
	public void onInitialize() {
		AutoConfig.register(NoCropTramplingConfig.class, GsonConfigSerializer::new);
		CONFIG = AutoConfig.getConfigHolder(NoCropTramplingConfig.class).getConfig();

		DataManager.load();

		ServerLifecycleEvents.SERVER_STOPPING.register(server -> {
			DataManager.save();
		});

		CommandRegistrationCallback.EVENT.register(TramplingProtectionCommand::register);
	}
}