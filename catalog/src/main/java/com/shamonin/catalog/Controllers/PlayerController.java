package com.shamonin.catalog.Controllers;

import com.shamonin.catalog.Model.Player;
import com.shamonin.catalog.Service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/players")
public class PlayerController {
    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public String players(Model model) {
        List<Player> players = playerService.getAllPlayers();
        model.addAttribute("players", players);
        return "playersList";
    }
}