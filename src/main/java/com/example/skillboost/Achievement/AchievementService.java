package com.example.skillboost.Achievement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AchievementService {

    @Autowired
    private AchievementRepository achievementRepository;

    public Achievement addAchievement(Achievement achievement) {
        return achievementRepository.save(achievement);
    }

    public List<Achievement> findAllAchievements() {
        return achievementRepository.findAll();
    }

    public Achievement getAchievementById(String achievementId) {
        return achievementRepository.findById(achievementId).orElse(null);
    }

    public void deleteAchievementById(String achievementId) {
        Optional<Achievement> achievementOptional = achievementRepository.findById(achievementId);
        achievementOptional.ifPresent(achievementRepository::delete);
        // Additional logic if needed
    }

    public Achievement updateAchievement(String achievementId, Achievement updatedAchievement) {
        Optional<Achievement> existingAchievementOptional = achievementRepository.findById(achievementId);
        if (existingAchievementOptional.isPresent()) {
            Achievement existingAchievement = existingAchievementOptional.get();
            // Update necessary fields using setters
            existingAchievement.setAchievementName(updatedAchievement.getAchievementName());

            return achievementRepository.save(existingAchievement);
        } else {
            // Handle the case when the achievement with the specified ID does not exist.
            // You can throw an exception, log a message, or take any other appropriate action.
            return null;
        }
    }
}

