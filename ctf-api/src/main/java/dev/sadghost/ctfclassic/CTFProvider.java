package dev.sadghost.ctfclassic;

import org.bukkit.Server;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

public final class CTFProvider {

    private CTFApi api = null;

    public CTFProvider(final @NotNull Plugin plugin) {

        final Logger logger = plugin.getSLF4JLogger();
        final Server server = plugin.getServer();
        logger.info("Attempting to hook into the CTF Service...");

        if (!server.getPluginManager().isPluginEnabled("ctfclassic")) {
            logger.warn("Could not hook into the CTF Service. This may cause major errors in the plugin.");
            return;
        }

        final RegisteredServiceProvider<CTFApi> serviceProvider = server.getServicesManager().getRegistration(CTFApi.class);
        if (serviceProvider == null) {
            logger.warn("Could not hook into the CTF Service. This may cause major errors in the plugin.");
            return;
        }

        this.api = serviceProvider.getProvider();
        logger.info("Successfully hooked into the CTF Service.");
    }

    public CTFApi getApi() {
        return api;
    }
}
