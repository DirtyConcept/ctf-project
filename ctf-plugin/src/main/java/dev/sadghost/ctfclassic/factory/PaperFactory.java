package dev.sadghost.ctfclassic.factory;

import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import org.bukkit.Server;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.scheduler.BukkitScheduler;
import org.jetbrains.annotations.NotNull;

@Factory
public final class PaperFactory {

    @Bean
    public @NotNull Server server(final @NotNull Plugin plugin) {

        return plugin.getServer();
    }

    @Bean
    public @NotNull BukkitScheduler bukkitScheduler(final @NotNull Server server) {

        return server.getScheduler();
    }

    @Bean
    public @NotNull PluginManager pluginManager(final @NotNull Server server) {

        return server.getPluginManager();
    }
}
