package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {
    private final List<Player> players = new ArrayList<>();

    public PlayerController() {
        players.add(new Player(1, "Player1", "Player1_password"));
        players.add(new Player(2, "Player2", "Player2_password"));
    }

    @GetMapping("/all")
    public List<Player> getPlayers(){
        return players;
    }

    @GetMapping("/count")
    public int countPlayers(){
        return players.size();
    }

    @GetMapping("/{id:\\d+}")
    public Player getPlayer(@PathVariable("id") int id) {
        return players.stream()
                .filter(p -> p.getId() == id).findFirst().orElse(null);
    }


    @PostMapping(value = "/add-player", consumes="application/json")
    public ResponseEntity<String> createPlayer(@RequestBody Player player) {
        System.out.println(player);
        player.setId(1 + players.get(players.size()-1).getId());
        players.add(player);
        return new ResponseEntity<>(
                "Player created successfully", HttpStatus.CREATED);
    }

    @PutMapping(value = "/update-player/{id:\\d+}")
    public ResponseEntity<String> updatePlayer(@PathVariable int id, @RequestParam String username, @RequestParam String password){
        Player player = players.stream()
                .filter(p -> p.getId() == id).findFirst().orElse(null);
        if (player == null){
            return new ResponseEntity<>("Player not found", HttpStatus.NOT_FOUND);
        }
        player.setUsername(username);
        player.setPassword(password);
        return new ResponseEntity<>("Player updated succesSfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete-player/{id:\\d+}")
    public ResponseEntity<String> deletePlayer(@PathVariable int id) {
        Player player = players.stream()
                .filter(p -> p.getId() == id).findFirst().orElse(null);
        if (player == null) {
            return new ResponseEntity<>("Player not found", HttpStatus.NOT_FOUND);
        }
        players.remove(player);
        return new ResponseEntity<>("Player removed", HttpStatus.OK);
    }

}
