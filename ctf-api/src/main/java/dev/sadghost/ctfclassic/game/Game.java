package dev.sadghost.ctfclassic.game;

import dev.sadghost.ctfclassic.team.TeamsManager;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.UUID;

public interface Game {

    @NotNull Collection<UUID> getParticipants();

    default boolean addParticipant(@NotNull OfflinePlayer player,
                                   @NotNull String team) {
        return addParticipant(player.getUniqueId(), team);
    }
    boolean addParticipant(@NotNull UUID uuid,
                           @NotNull String team);

    default boolean removeParticipant(@NotNull OfflinePlayer player,
                                      @NotNull String team) {
        return removeParticipant(player.getUniqueId(), team);
    }
    boolean removeParticipant(@NotNull UUID uuid,
                              @NotNull String team);

    @NotNull TeamsManager getTeamsManager();

    int getParticipantsSize();


}
