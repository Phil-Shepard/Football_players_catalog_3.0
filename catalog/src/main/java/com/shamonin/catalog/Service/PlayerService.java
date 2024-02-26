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
    public void save(Player player) {
        playerRepository.save(player);
    }

    public void addPlayer(Player player) {
        Team existingTeam = teamService.findTeamByName(player.getTeamName());
        if (existingTeam == null) {
            Team team = new Team();
            team.setTeamName(player.getTeamName());
            teamService.addTeam(team);
        }

        playerRepository.save(player);
    }

    public Player getPlayerById(long id) {
        return playerRepository.findById(Math.toIntExact(id)).orElse(null);
    }
    public void updatePlayer(Player updatedPlayer) {
        Player existingPlayer = playerRepository.findById(Math.toIntExact(updatedPlayer.getId())).orElse(null);
        if (existingPlayer != null) {
            existingPlayer.setName(updatedPlayer.getName());
            existingPlayer.setSurname(updatedPlayer.getSurname());
            existingPlayer.setGender(updatedPlayer.getGender());
            existingPlayer.setMyDate(updatedPlayer.getMyDate());
            existingPlayer.setTeamName(updatedPlayer.getTeamName());
            existingPlayer.setCountry(updatedPlayer.getCountry());
            playerRepository.save(existingPlayer);
        }
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }
}
