package com.shamonin.catalog.Repository;

import com.shamonin.catalog.Model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
    Team findByTeamName(String teamName);
}
