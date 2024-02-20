package com.shamonin.catalog.Service;

import com.shamonin.catalog.Model.Player;
import com.shamonin.catalog.Model.Team;
import com.shamonin.catalog.Repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;
    private final TeamService teamService;

    @Autowired
    public PlayerService(PlayerRepository playerRepository, TeamService teamService) {
        this.playerRepository = playerRepository;
        this.teamService = teamService;
    }

    public void addPlayer(Player player) {
        Team existingTeam = teamService.findTeamByName(player.getTeam().getTeamName());
        if (existingTeam == null) {
            teamService.addTeam(player.getTeam());
        }

        playerRepository.save(player);
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }
}
