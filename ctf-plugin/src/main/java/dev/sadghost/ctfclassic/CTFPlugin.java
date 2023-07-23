package dev.sadghost.ctfclassic;

import dev.sadghost.ctfclassic.listeners.ListenersRegisterer;
import io.micronaut.context.ApplicationContext;
import org.bukkit.plugin.java.JavaPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class CTFPlugin extends JavaPlugin {
    private static final Logger LOGGER = LoggerFactory.getLogger(CTFPlugin.class);
    private ApplicationContext application;

    @Override
    public void onLoad() {
        long millis = System.currentTimeMillis();
        LOGGER.info("The plugin is loading...");
        application = ApplicationContext.builder()
                .classLoader(getClassLoader())
                .singletons(this)
                .build();

        LOGGER.info("The plugin's loading took " + (System.currentTimeMillis() - millis) + "ms.");
    }

    @Override
    public void onEnable() {
        long millis = System.currentTimeMillis();

        LOGGER.info("The plugin is starting...");
        application.start();

        LOGGER.debug("Registering the listeners...");
        final ListenersRegisterer listenersRegisterer = application.getBean(ListenersRegisterer.class);
        listenersRegisterer.registerListeners();
        LOGGER.debug("Registered the listeners.");

        LOGGER.info("The plugin took " + (System.currentTimeMillis() - millis) + "ms to start.");
    }

    @Override
    public void onDisable() {
        application.stop();
    }
}
