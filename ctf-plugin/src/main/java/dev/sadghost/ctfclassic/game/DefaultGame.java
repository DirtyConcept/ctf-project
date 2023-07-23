package dev.sadghost.ctfclassic.game;

import dev.sadghost.ctfclassic.team.Team;
import dev.sadghost.ctfclassic.team.TeamsManager;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class DefaultGame implements Game {

    private final TeamsManager teamsManager;

    @Contract(pure = true)
    public DefaultGame(final @NotNull TeamsManager teamsManager) {

        this.teamsManager = teamsManager;
    }

    @Override
    public @NotNull Collection<UUID> getParticipants() {

        return teamsManager.getTeams()
                .stream()
                .flatMap(team -> team.getMembers().stream())
                .collect(Collectors.toUnmodifiableSet());
    }

    @Override
    public boolean addParticipant(final @NotNull UUID uuid,
                                  final @NotNull String team) {

        final Optional<Team> optionalTeam = teamsManager.getTeamByName(team);
        return optionalTeam.map(value -> value.addMember(uuid)).orElse(false);
    }

    @Override
    public boolean removeParticipant(@NotNull UUID uuid, @NotNull String team) {

        final Optional<Team> optionalTeam = teamsManager.getTeamByName(team);
        return optionalTeam.map(value -> value.removeMember(uuid)).orElse(false);
    }

    @Override
    public @NotNull TeamsManager getTeamsManager() {

        return teamsManager;
    }

    @Override
    public int getParticipantsSize() {

        return getParticipants().size();
    }
}
