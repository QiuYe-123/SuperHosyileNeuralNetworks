package cn.qiuye.shnn.item;

import dev.shadowsoffire.hostilenetworks.util.Color;
import net.minecraft.ChatFormatting;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class UpgradeMachine extends Item {
	private final Component tooltip;

	public UpgradeMachine(Properties properties, Component tooltip) {
		super(properties);

		this.tooltip = tooltip;
	}

	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack pStack, Level pLevel, List<Component> list, TooltipFlag pFlag) {

		if (Screen.hasShiftDown()) {
			list.add(tooltip);
		} else {
			list.add(Component.translatable("hostilenetworks.info.hold_shift", Color.withColor("hostilenetworks.color_text.shift", ChatFormatting.WHITE.getColor())).withStyle(ChatFormatting.GRAY));
		}
	}
}
