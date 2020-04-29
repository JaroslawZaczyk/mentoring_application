package pl.js.juniorasks.useroperations.mentors;

import pl.js.juniorasks.dataproviders.mentors.MentorProvider;
import pl.js.juniorasks.models.Mentor;

public class MentorProcessor {

    private final MentorProvider mentorProvider;

    public MentorProcessor(MentorProvider mentorProvider) {
        this.mentorProvider = mentorProvider;
    }

    public Mentor getMentor(String mentorNick) {
        return mentorProvider.getMentor(mentorNick);
    }

    public Mentor addMentor(String mentorNick, String email) {
        Mentor mentor = new Mentor(mentorNick, email);
        mentorProvider.saveMentor(mentor);
        return mentor;
    }

    public Mentor removeMentor(String mentorNick) {
        return mentorProvider.removeMentor(mentorNick);
    }
}
