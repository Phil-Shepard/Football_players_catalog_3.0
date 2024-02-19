package com.shamonin.catalog.Repository;

import com.shamonin.catalog.Model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
}
