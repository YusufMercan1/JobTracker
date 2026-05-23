package org.example.jobtracker.ai;

import org.example.jobtracker.service.JobApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ai")
public class CoverLetterController {

    private final CoverLetterService coverLetterService;
    private final JobApplicationService jobApplicationService;

    public CoverLetterController(CoverLetterService coverLetterService,
                                 JobApplicationService jobApplicationService) {
        this.coverLetterService = coverLetterService;
        this.jobApplicationService = jobApplicationService;
    }

    @PostMapping("/cover-letter")
    public ResponseEntity<String> generateCoverLetter(
            @RequestBody CoverLetterRequest request) {
        String coverLetter = coverLetterService.generateCoverLetter(request);
        return ResponseEntity.ok(coverLetter);
    }

    @PostMapping("/{applicationId}/cover-letter")
    public ResponseEntity<String> generateAndSave(
            @PathVariable Long applicationId,
            @RequestBody CoverLetterRequest request) {
        String coverLetter = coverLetterService.generateCoverLetter(request);
        jobApplicationService.saveCoverLetter(applicationId, coverLetter);
        return ResponseEntity.ok(coverLetter);
    }
}