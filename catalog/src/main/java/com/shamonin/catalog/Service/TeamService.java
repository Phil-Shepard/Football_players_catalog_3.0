package com.shamonin.catalog.Service;

import com.shamonin.catalog.Model.Team;
import com.shamonin.catalog.Repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {
    private final TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public void addTeam(Team team) {
        teamRepository.save(team);
    }

    public Team findTeamByName(String teamName) {
        return teamRepository.findByTeamName(teamName);
    }
}
