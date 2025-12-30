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

	public static GameRule<TrampleProtection> CROP_TRAMPLING_PROTECTION;

	@Override
	public void onInitialize() {
		CROP_TRAMPLING_PROTECTION = GameRuleBuilder.forEnum(TrampleProtection.ALL)
				.buildAndRegister(Identifier.of("notrampling", "crop_trampling_protection"));
	}
}