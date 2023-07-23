package dev.sadghost.ctfclassic.listeners;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@Singleton
public class PluginListenersRegisterer implements ListenersRegisterer {

    private final PluginManager pluginManager;
    private final List<Listener> listeners;
    private final Plugin plugin;

    @Inject
    public PluginListenersRegisterer(final @NotNull Plugin plugin,
                                     final @NotNull PluginManager pluginManager,
                                     final @NotNull List<Listener> listeners) {

        this.plugin = plugin;
        this.pluginManager = pluginManager;
        this.listeners = listeners;
    }

    @Override
    public void registerListeners() {

        listeners.forEach(listener -> pluginManager.registerEvents(listener, plugin));
    }
}
