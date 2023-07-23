package dev.sadghost.ctfclassic.game;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

public interface GamesManager {

    Map<String, Game> getGamesMapped();

    Collection<Game> getGames();

    Optional<Game> getGame(@NotNull String identifier);


}
