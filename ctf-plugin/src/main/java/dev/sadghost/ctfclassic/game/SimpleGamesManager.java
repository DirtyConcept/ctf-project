package dev.sadghost.ctfclassic.game;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public final class SimpleGamesManager implements GamesManager {

    private final Map<String, Game> gamesMap;

    public SimpleGamesManager() {

        this.gamesMap = new HashMap<>();

        //todo load arenas from config.
    }

    @Override
    public Map<String, Game> getGamesMapped() {

        return gamesMap;
    }

    @Override
    public Collection<Game> getGames() {

        return gamesMap.values();
    }

    @Override
    public Optional<Game> getGame(final @NotNull String identifier) {

        return Optional.ofNullable(gamesMap.get(identifier));
    }
}
