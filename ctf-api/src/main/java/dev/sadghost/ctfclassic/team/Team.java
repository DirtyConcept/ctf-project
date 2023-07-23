package dev.sadghost.ctfclassic.team;

import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;

import java.util.Collection;
import java.util.UUID;

public interface Team {

    @NotNull String getName();

    @NotNull Collection<@NotNull UUID> getMembers();

    boolean addMember(@NotNull UUID uuid);
    default boolean addMember(@NotNull OfflinePlayer player) {
        return addMember(player.getUniqueId());
    }

    boolean removeMember(@NotNull UUID uuid);
    default boolean removeMember(@NotNull OfflinePlayer player) {
        return removeMember(player.getUniqueId());
    }

    @NotNull Location getTeamSpawn();

    void setTeamSpawn(@NotNull Location teamSpawn);

    @Range(from = 0, to = Integer.MAX_VALUE) int getSize();


}
