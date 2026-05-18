package org.example.jobtracker.repository;

import org.example.jobtracker.model.JobApplication;
import org.example.jobtracker.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {

    List<JobApplication> findByStatus(Status status);

    List<JobApplication> findByUserUsername(String username);
}
