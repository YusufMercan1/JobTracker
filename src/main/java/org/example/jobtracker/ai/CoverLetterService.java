package org.example.jobtracker.ai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class CoverLetterService {

    private final ChatClient chatClient;

    public CoverLetterService(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    public String generateCoverLetter(CoverLetterRequest request) {
        String prompt = """
                Du är en expert på jobbansökningar. Skriv ett professionellt och
                övertygande personligt brev på svenska baserat på följande information:
                
                Jobbtitel: %s
                Företag: %s
                Jobbeskrivning: %s
                Sökandens bakgrund: %s
                
                Brevet ska vara:
                - Ca 3-4 stycken långt
                - Professionellt men personligt
                - Lyfta fram relevanta erfarenheter
                - Avslutas med en tydlig call-to-action
                """.formatted(
                request.getJobTitle(),
                request.getCompanyName(),
                request.getJobDescription(),
                request.getUserExperience()
        );

        return chatClient.prompt()
                .user(prompt)
                .call()
                .content();
    }
}