package org.example.jobtracker.repository;

import org.example.jobtracker.model.Interview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface InterviewRepository extends JpaRepository<Interview, Long> {
    List<Interview> findByJobApplicationId(Long jobApplicationId);

    List<Interview> findByJobApplicationUserId(Long userId);

    long countByJobApplicationUserIdAndDateTimeBetween(Long userId, LocalDateTime from, LocalDateTime to);
}
