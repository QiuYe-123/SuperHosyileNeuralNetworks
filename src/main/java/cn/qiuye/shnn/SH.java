package cn.qiuye.shnn;

import cn.qiuye.shnn.api.Version;
import cn.qiuye.shnn.block.SuperLootFabBlock;
import cn.qiuye.shnn.gui.SuperLootFabContainer;
import cn.qiuye.shnn.tile.SuperLootFabTileEntity;

import dev.shadowsoffire.placebo.block_entity.TickingBlockEntityType;
import dev.shadowsoffire.placebo.menu.MenuUtil;
import dev.shadowsoffire.placebo.registry.DeferredHelper;

import net.lmor.extrahnn.item.UpgradeMachine;
import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.RegistryObject;

import com.google.common.collect.ImmutableSet;

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

        public static final RegistryObject<Block> ULTIMATE_LOOT_FABRICATOR = SH.R.block("super_loot_fabricator", () -> new SuperLootFabBlock(DEFAULT_STATE, TileEntities.ULTIMATE_LOOT_FABRICATOR::get, Containers.ULTIMATE_LOOT_FABRICATOR::get, Version.V5));
        private static void bootstrap() {}
    }

    public static class Items {

        public static final RegistryObject<BlockItem> ULTIMATE_LOOT_FABRICATOR = SH.R.item("super_loot_fabricator", () -> new BlockItem(Blocks.ULTIMATE_LOOT_FABRICATOR.get(), new Item.Properties()));
        public static final RegistryObject<UpgradeMachine> UPGRADE_SPEED = SH.R.item("upgrade_speed", () -> new UpgradeMachine(new Item.Properties(), Component.translatable("shnn.info.item_tooltip.upgrade_speed", SHNNConfig.upgradeSpeed).withStyle(ChatFormatting.GRAY)));
        public static final RegistryObject<UpgradeMachine> UPGRADE_EXCESSIVE = SH.R.item("upgrade_excessive", () -> new UpgradeMachine(new Item.Properties(), Component.translatable("shnn.info.item_tooltip.upgrade_excessive", SHNNConfig.upgradeSpeed).withStyle(ChatFormatting.GRAY)));

        private static void bootstrap() {}
    }

    public static class TileEntities {

        public static final RegistryObject<BlockEntityType<SuperLootFabTileEntity>> ULTIMATE_LOOT_FABRICATOR = SH.R.blockEntity("super_loot_fabricator", () -> new TickingBlockEntityType<>((pos, state) -> new SuperLootFabTileEntity(pos, state, TileEntities.ULTIMATE_LOOT_FABRICATOR.get(), Version.V5), ImmutableSet.of(Blocks.ULTIMATE_LOOT_FABRICATOR.get()), false, true));

        private static void bootstrap() {}
    }

    public static class Containers {

        public static final RegistryObject<MenuType<SuperLootFabContainer>> ULTIMATE_LOOT_FABRICATOR = SH.R.menu("super_loot_fabricator", () -> MenuUtil.posType((id, pInv, pos) -> new SuperLootFabContainer(id, pInv, pos, Containers.ULTIMATE_LOOT_FABRICATOR.get(), Blocks.ULTIMATE_LOOT_FABRICATOR.get())));
        private static void bootstrap() {}
    }

    public static class Tabs {

        public static final ResourceKey<CreativeModeTab> SHNN_TAB_KEY = ResourceKey.create(Registries.CREATIVE_MODE_TAB, SHNN.id("tab"));
        public static final RegistryObject<CreativeModeTab> SHNN_TAB = SH.R.tab("tab", () -> CreativeModeTab.builder().title(Component.translatable("itemGroup.extrahnn")).icon(() -> (SH.Items.ULTIMATE_LOOT_FABRICATOR.get()).getDefaultInstance()).build());

        private static void bootstrap() {}
    }
}
