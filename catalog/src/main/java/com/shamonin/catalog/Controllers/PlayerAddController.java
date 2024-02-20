package com.shamonin.catalog.Controllers;

import com.shamonin.catalog.Model.Player;
import com.shamonin.catalog.Service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/add")
public class PlayerAddController {
    private final PlayerService playerService;

    @Autowired
    public PlayerAddController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public String addPlayerForm(Model model) {
        // Здесь можно передать список команд для выпадающего списка
        model.addAttribute("player", new Player());
        return "addPlayers";
    }

    @PostMapping
    public String addPlayer(@ModelAttribute("player") Player player) {
        playerService.addPlayer(player);
        return "redirect:/players";
    }
}