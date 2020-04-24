package pl.js.juniorasks.dataproviders;

import pl.js.juniorasks.models.Mentee;

public interface MenteeProvider {

    Mentee getMentee(String menteeNick);

    void addMentee(Mentee mentee);

    void removeMentee(Mentee mentee);

}