package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.management.ValueExp;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

@Controller
public class HTMLController {

    @GetMapping(value="/")
    public String getPlayers(Model model) throws URISyntaxException, IOException, InterruptedException {
        // Retrieve the JSON data from the API and add it to the model
        model.addAttribute(new Player());


        List<Player> jsonData = new APIClient().getPlayers(); // Add your code to retrieve JSON data
        String formattedString = jsonData.toString()
                .replace("=", ":")
                .replace(",", "")
                .replace("[", "")
                .replace("]", "")
                .trim();
        model.addAttribute("jsonData", formattedString);

        // Return the name of the HTML template (without the extension)
        return "index";
    }

    @PostMapping(value="/")
    public String addPlayer(@ModelAttribute Player player, Model model) throws URISyntaxException, IOException, InterruptedException {
        model.addAttribute("player", player);
        APIClient client = new APIClient();
        client.addPlayer(player);

        return "index";
    }

    @PutMapping(value = "/")
    public String updatePlayer(@ModelAttribute Player player, Model model) throws URISyntaxException, IOException, InterruptedException {
        model.addAttribute("player", player);
        APIClient client = new APIClient();
        client.updatePlayer(player);

        return "index";
    }

    @DeleteMapping(value="/")
    public String deletePlayer(@ModelAttribute Player player, Model model) throws URISyntaxException, IOException, InterruptedException {
        model.addAttribute("player", player);
        APIClient client = new APIClient();
        client.deletePlayer(player);

        return "index";
    }

}