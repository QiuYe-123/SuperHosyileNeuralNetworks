package cn.qiuye.shnn;

import dev.shadowsoffire.placebo.registry.DeferredHelper;

import net.minecraft.world.level.block.state.BlockBehaviour;

public class SH {

    private static final DeferredHelper R = DeferredHelper.create(SHNN.MOD_ID);
    static BlockBehaviour.Properties DEFAULT_STATE = BlockBehaviour.Properties.of()
            .lightLevel((s) -> 1)
            .strength(4.0F, 3000.0F).noOcclusion();

    public SH() {}

    static void boootstrap() {
        SH.Blocks.bootstrap();
        SH.Items.bootstrap();
        SH.TileEntities.bootstrap();
        SH.Containers.bootstrap();
        SH.Tabs.bootstrap();
    }

    public static class Blocks {

        private static void bootstrap() {}
    }

    public static class Items {

        private static void bootstrap() {}
    }

    public static class TileEntities {

        private static void bootstrap() {}
    }

    public static class Containers {

        private static void bootstrap() {}
    }

    public static class Tabs {

        private static void bootstrap() {}
    }
}
