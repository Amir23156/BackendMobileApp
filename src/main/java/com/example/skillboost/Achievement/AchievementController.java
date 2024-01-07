package com.example.skillboost.Achievement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/achievements")
public class AchievementController {

    @Autowired
    private AchievementService achievementService;

    @GetMapping("/getAchievement/{achievementId}")
    public ResponseEntity<?> getAchievement(@PathVariable String achievementId) {
        Achievement achievement = achievementService.getAchievementById(achievementId);
        if (achievement != null) {
            return ResponseEntity.ok(achievement);
        } else {
            String errorMessage = "Achievement with ID '" + achievementId + "' not found.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    @PostMapping("/addAchievement")
    public ResponseEntity<Achievement> addAchievement(@RequestBody Achievement achievement) {
        // Set any default values or perform necessary business logic
        return new ResponseEntity<>(achievementService.addAchievement(achievement), HttpStatus.ACCEPTED);
    }

    @GetMapping("/findAllAchievements")
    public ResponseEntity<List<Achievement>> findAllAchievements() {
        return new ResponseEntity<>(achievementService.findAllAchievements(), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/deleteAchievement/{achievementId}")
    public ResponseEntity<String> deleteAchievementById(@PathVariable String achievementId) {
        achievementService.deleteAchievementById(achievementId);
        return new ResponseEntity<>("Achievement with ID " + achievementId + " deleted", HttpStatus.OK);
    }

    @PutMapping("/updateAchievement/{achievementId}")
    public ResponseEntity<Achievement> updateAchievement(@PathVariable String achievementId, @RequestBody Achievement updatedAchievement) {
        Achievement existingAchievement = achievementService.getAchievementById(achievementId);
        if (existingAchievement != null) {
            // Update necessary fields using setters
            existingAchievement.setAchievementName(updatedAchievement.getAchievementName());

            Achievement savedAchievement = achievementService.addAchievement(existingAchievement);
            return new ResponseEntity<>(savedAchievement, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
