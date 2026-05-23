package org.example.jobtracker.ai;

import lombok.Data;

@Data
public class CoverLetterRequest {

    private String jobTitle;
    private String companyName;
    private String jobDescription;
    private String userExperience;

}