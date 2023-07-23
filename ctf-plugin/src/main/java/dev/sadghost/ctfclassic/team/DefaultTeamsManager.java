package dev.sadghost.ctfclassic.team;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public final class DefaultTeamsManager implements TeamsManager {

    private final Collection<Team> teams;
    private int teamSize;

    @Contract(pure = true)
    public DefaultTeamsManager(final int teamSize) {

        this.teams = new ArrayList<>();
        this.teamSize = teamSize;
    }

    @Override
    @Contract(pure = true)
    public @NotNull Collection<@NotNull Team> getTeams() {

        return teams;
    }

    @Override
    public void addTeam(final @NotNull Team team) {

        this.teams.add(team);
    }

    @Override
    public void removeTeam(final @NotNull Team team) {

        this.teams.remove(team);
    }

    @Override
    @Contract(pure = true)
    public int getTeamSize() {

        return teamSize;
    }

    @Override
    @Contract(mutates = "this")
    public void setTeamSize(final int teamSize) {

        this.teamSize = teamSize;
    }

    @Override
    public @NotNull Optional<Team> getTeamByName(final @NotNull String name) {

        return teams.stream().filter(regTeam -> regTeam.getName().equals(name)).findFirst();
    }

    @Override
    public @NotNull Optional<Team> getTeamByUuid(final @NotNull UUID uuid) {

        return teams.stream().filter(regTeam -> regTeam.getMembers().contains(uuid)).findFirst();
    }
}
