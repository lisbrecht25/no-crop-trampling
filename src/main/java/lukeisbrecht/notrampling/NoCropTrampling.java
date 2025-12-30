package lukeisbrecht.notrampling;

import net.fabricmc.api.ModInitializer;


import net.fabricmc.fabric.api.gamerule.v1.GameRuleBuilder;
import net.minecraft.util.Identifier;
import net.minecraft.world.rule.GameRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NoCropTrampling implements ModInitializer {
	public static final String MOD_ID = "no-trampling";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static GameRule<Boolean> DO_CROP_TRAMPLING;

	@Override
	public void onInitialize() {
		DO_CROP_TRAMPLING = GameRuleBuilder.forBoolean(false)
				.buildAndRegister(Identifier.of("notrampling", "do_crop_trampling"));
	}
}