package cn.qiuye.shnn;

import dev.shadowsoffire.placebo.registry.DeferredHelper;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class SH {
	private static final DeferredHelper R = DeferredHelper.create(SHNN.MOD_ID);
	static BlockBehaviour.Properties DEFAULT_STATE = BlockBehaviour.Properties.of()
			.lightLevel((s) -> 1)
			.strength(4.0F, 3000.0F).noOcclusion();

	public SH(){}

	static void boootstrap() {
SH.Tabs.bootstrap();
	}

	public static class Tabs {
		private static void bootstrap() {
		}
	}
}
