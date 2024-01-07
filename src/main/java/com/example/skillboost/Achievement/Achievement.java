package com.example.skillboost.Achievement;

public class Achievement {

    private String achievementId;
    private String achievementName;

    // Constructors
    public Achievement(String achievementId, String achievementName) {
        this.achievementId = achievementId;
        this.achievementName = achievementName;
    }

    // Getters and Setters
    public String getAchievementId() {
        return achievementId;
    }

    public void setAchievementId(String achievementId) {
        this.achievementId = achievementId;
    }

    public String getAchievementName() {
        return achievementName;
    }

    public void setAchievementName(String achievementName) {
        this.achievementName = achievementName;
    }

    // Method to display achievement information
    public void displayAchievement() {
        System.out.println("Achievement ID: " + achievementId);
        System.out.println("Achievement Name: " + achievementName);
    }

    public static void main(String[] args) {
        // Example usage
        Achievement achievement = new Achievement("1", "Programming Expert");
        achievement.displayAchievement();
    }
}

