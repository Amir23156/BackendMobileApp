package com.example.skillboost.Progress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProgressService {

    @Autowired
    private ProgressRepository progressRepository;

    public Progress trackProgress(Progress progress) {
        return progressRepository.save(progress);
    }

    public List<Progress> findAllProgress() {
        return progressRepository.findAll();
    }

    public Progress getProgressById(String progressId) {
        return progressRepository.findById(progressId).orElse(null);
    }

    public void deleteProgressById(String progressId) {
        Optional<Progress> progressOptional = progressRepository.findById(progressId);
        progressOptional.ifPresent(progressRepository::delete);
        // Additional logic if needed
    }

    public Progress updateProgress(String progressId, Progress updatedProgress) {
        Optional<Progress> existingProgressOptional = progressRepository.findById(progressId);
        if (existingProgressOptional.isPresent()) {
            Progress existingProgress = existingProgressOptional.get();
            // Update necessary fields using setters
            existingProgress.setCompletedLessons(updatedProgress.getCompletedLessons());
            existingProgress.setTotalLessons(updatedProgress.getTotalLessons());

            return progressRepository.save(existingProgress);
        } else {
            // Handle the case when the progress with the specified ID does not exist.
            // You can throw an exception, log a message, or take any other appropriate action.
            return null;
        }
    }
}

