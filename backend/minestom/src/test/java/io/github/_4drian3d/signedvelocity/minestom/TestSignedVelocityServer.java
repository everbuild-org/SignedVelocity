package io.github._4drian3d.signedvelocity.minestom;

import net.minestom.server.MinecraftServer;
import net.minestom.server.coordinate.Pos;
import net.minestom.server.event.player.AsyncPlayerConfigurationEvent;
import net.minestom.server.extras.velocity.VelocityProxy;
import net.minestom.server.instance.Instance;
import net.minestom.server.instance.LightingChunk;
import net.minestom.server.instance.block.Block;

import java.io.File;
import java.nio.file.Files;


public class TestSignedVelocityServer {
    private static String readSecret() {
        File file = new File("velocity/run/forwarding.secret");
        if (!file.exists()) {
            throw new RuntimeException("No forwarding secret found! Make sure you run the velocity server first");
        }
        try {
            return new String(Files.readAllBytes(file.toPath()));
        } catch (Exception e) {
            throw new RuntimeException("Failed to read forwarding secret!", e);
        }
    }

    public static void main(String[] args) {
        MinecraftServer server = MinecraftServer.init();
        SignedVelocity.initialize();
        VelocityProxy.enable(readSecret());

        Instance instance = MinecraftServer.getInstanceManager().createInstanceContainer();
        instance.setGenerator(
                (generationUnit -> generationUnit.modifier()
                        .fillHeight(0, 65, Block.WHITE_STAINED_GLASS))
        );
        instance.setTimeRate(0);
        instance.setChunkSupplier(LightingChunk::new);

        MinecraftServer.getGlobalEventHandler().addListener(AsyncPlayerConfigurationEvent.class, event -> {
            event.getPlayer().setRespawnPoint(new Pos(0, 65, 0));
            event.setSpawningInstance(instance);
        });

        server.start("0.0.0.0", 30066);
    }
}
