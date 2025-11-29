package cn.qiuye.shnn;

import dev.shadowsoffire.placebo.config.Configuration;
import dev.shadowsoffire.placebo.network.MessageProvider;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkEvent;

import java.util.Optional;
import java.util.function.Supplier;

public class SHNNConfig {

    public SHNNConfig() {}

    public static void load() {
        Configuration cfg = new Configuration("shnn");

        if (cfg.hasChanged()) {
            cfg.save();
        }
    }

    public record ConfigMessage() {

        public static class Provider implements MessageProvider<SHNNConfig.ConfigMessage> {

            public Provider() {}

            @Override
            public Class<?> getMsgClass() {
                return ConfigMessage.class;
            }

            @Override
            public void write(ConfigMessage configMessage, FriendlyByteBuf friendlyByteBuf) {}

            public ConfigMessage read(FriendlyByteBuf buf) {
                return null;
            }

            public void handle(ConfigMessage configMessage, Supplier<NetworkEvent.Context> supplier) {}

            public Optional<NetworkDirection> getNetworkDirection() {
                return Optional.of(NetworkDirection.PLAY_TO_CLIENT);
            }
        }
    }
}
