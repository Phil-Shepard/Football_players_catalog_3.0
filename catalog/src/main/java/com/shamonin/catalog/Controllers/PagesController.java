package com.shamonin.catalog.Controllers;

import com.shamonin.catalog.Model.Player;
import com.shamonin.catalog.Repository.PlayerRepository;
import com.shamonin.catalog.Service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PagesController {
    private final PlayerService playerService;

    @Autowired
    public PagesController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping("/addPlayers")
    public String addPlayer(Player player) {
        playerService.addPlayer(player);
        return "addPlayers"; // Можно указать другой URL для перенаправления
    }
}
