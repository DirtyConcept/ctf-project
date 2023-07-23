package dev.sadghost.ctfclassic.team;

import org.bukkit.Location;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Range;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.UUID;

public final class SimpleTeam implements Team {

    private final String name;
    private final Collection<UUID> members;
    private Location teamSpawn;

    @Contract(pure = true)
    public SimpleTeam(final @NotNull String name,
                      final @NotNull Location teamSpawn) {

        this.name = name;
        this.members = new HashSet<>();
        this.teamSpawn = teamSpawn;
    }

    @Override
    @Contract(pure = true)
    public @NotNull String getName() {

        return name;
    }

    @Override
    public @NotNull Collection<@NotNull UUID> getMembers() {

        return members;
    }

    @Override
    public boolean addMember(@NotNull UUID uuid) {

        return this.members.add(uuid);
    }

    @Override
    public boolean removeMember(@NotNull UUID uuid) {

        return this.members.remove(uuid);
    }

    @Override
    public @NotNull Location getTeamSpawn() {

        return teamSpawn;
    }

    @Override
    public void setTeamSpawn(@NotNull Location teamSpawn) {

        this.teamSpawn = teamSpawn;
    }

    @Override
    public @Range(from = 0, to = Integer.MAX_VALUE) int getSize() {

        return members.size();
    }

    @Override
    public boolean equals(final @Nullable Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final SimpleTeam that = (SimpleTeam) o;

        if (!name.equals(that.name)) return false;
        if (!members.equals(that.members)) return false;
        return Objects.equals(teamSpawn, that.teamSpawn);
    }

    @Override
    public int hashCode() {

        int result = name.hashCode();
        result = 31 * result + members.hashCode();
        result = 31 * result + (teamSpawn != null ? teamSpawn.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {

        return "SimpleTeam{" +
                "name='" + name + '\'' +
                ", members=" + members +
                ", teamSpawn=" + teamSpawn +
                '}';
    }
}
