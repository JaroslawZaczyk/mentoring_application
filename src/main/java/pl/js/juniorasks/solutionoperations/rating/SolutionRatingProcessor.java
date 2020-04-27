package pl.js.juniorasks.solutionoperations.rating;

import pl.js.juniorasks.dataproviders.MenteeProvider;
import pl.js.juniorasks.dataproviders.SolutionProvider;
import pl.js.juniorasks.models.Mentee;
import pl.js.juniorasks.models.Rate;
import pl.js.juniorasks.models.Solution;
import pl.js.juniorasks.usernotifiers.TaskNotifierManager;

public class SolutionRatingProcessor {

    private final SolutionProvider solutionProvider;
    private final MenteeProvider menteeProvider;
    private final TaskNotifierManager taskNotifierManager;

    public SolutionRatingProcessor(SolutionProvider solutionProvider,
                                   MenteeProvider menteeProvider,
                                   TaskNotifierManager taskNotifierManager) {
        this.solutionProvider = solutionProvider;
        this.menteeProvider = menteeProvider;
        this.taskNotifierManager = taskNotifierManager;
    }

    public Rate rateSolution(String solutionId, String rate) {
        Solution solution = solutionProvider.getSolution(solutionId);
        Rate solutionRate = calculateRate(rate);
        solutionProvider.rateSolution(solution, solutionRate);
        Mentee mentee = menteeProvider.getMentee(solution.getMenteeNick());
        taskNotifierManager.notifyUser(mentee, solution); //todo: consider if solutionId and rate will be enough
        return solutionRate;
    }

    private static Rate calculateRate(String rate) {
        return Rate.valueOf(rate.toUpperCase());
    }
}