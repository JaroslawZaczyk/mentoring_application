package pl.js.juniorasks.useroperations.mentors;

import org.springframework.stereotype.Service;
import pl.js.juniorasks.models.Mentor;

import static pl.js.juniorasks.tools.InputValidator.validateStringValue;

@Service
public class MentorService {

    private final MentorProcessor mentorProcessor;

    public MentorService(MentorProcessor mentorProcessor) {
        this.mentorProcessor = mentorProcessor;
    }

    public Mentor getMentor(String mentorNick) {
        validateStringValue(mentorNick);
        return mentorProcessor.getMentor(mentorNick);
    }

    public Mentor addMentor(String mentorNick, String email) {
        validateStringValue(mentorNick);
        validateStringValue(email);
        return mentorProcessor.addMentor(mentorNick, email);
    }

    public Mentor removeMentor(String mentorNick) {
        validateStringValue(mentorNick);
        return mentorProcessor.removeMentor(mentorNick);
    }
}
