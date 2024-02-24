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

import java.util.List;

@Controller
public class PagesController {
    private final PlayerService playerService;

    @Autowired
    public PagesController(PlayerService playerService) {
        this.playerService = playerService;
    }

//    @GetMapping("/")
//    public String home() {
//        return "index";
//    }


    @GetMapping("/")
    public String addPlayerForm(Model model) {
        model.addAttribute("player", new Player());
        return "addPlayers";
    }

    @PostMapping("/")
    public String addPlayer(@ModelAttribute("player") Player player) {
        playerService.addPlayer(player);
        return "redirect:/players";
    }

    @GetMapping("/players")
    public String players(Model model) {
        List<Player> players = playerService.getAllPlayers();
        model.addAttribute("players", players);
        return "playersList";
    }
}
