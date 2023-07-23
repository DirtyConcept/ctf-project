package dev.sadghost.ctfclassic.team;

import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public interface TeamsManager {

    @NotNull Collection<@NotNull Team> getTeams();

    void addTeam(@NotNull Team team);

    void removeTeam(@NotNull Team team);

    int getTeamSize();

    void setTeamSize(int teamSize);

    @NotNull Optional<Team> getTeamByName(@NotNull String name);

    @NotNull Optional<Team> getTeamByUuid(@NotNull UUID uuid);

    default @NotNull Optional<Team> getTeamByPlayer(@NotNull OfflinePlayer player) {
        return getTeamByUuid(player.getUniqueId());
    }
}
