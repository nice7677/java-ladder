package ladder.presentation;

import ladder.domain.*;
import ladder.presentation.input.AskingUserInputView;
import ladder.presentation.input.LadderHeightInputView;
import ladder.presentation.input.LadderResultInputView;
import ladder.presentation.input.UsersInputView;
import ladder.presentation.output.GameResultOutputView;
import ladder.presentation.output.ResultOutputView;

public class LadderController {

    public void run() {

        Users users = Users.create(users());
        LadderResults ladderResults = LadderResults.create(ladderResults());

        Width width = Width.create(users.size() - 1);
        Height height = Height.create(ladderHeight());

        Ladder ladder = Ladder.create(width, height);
        outputResult(users, ladder, ladderResults);

        outputGameResult(GameResult.create(users, ladder, ladderResults));
    }

    private String users() {
        UsersInputView view = new UsersInputView();
        return view.input();
    }

    private String ladderResults() {
        LadderResultInputView view = new LadderResultInputView();
        return view.input();
    }

    private int ladderHeight() {
        LadderHeightInputView view = new LadderHeightInputView();
        return view.input();
    }

    private void outputResult(Users users, Ladder ladder, LadderResults ladderResults) {
        ResultOutputView outputView = new ResultOutputView();
        outputView.output(users, ladder, ladderResults);
    }

    private void outputGameResult(GameResult gameResult) {
        final String allUsers = "all";
        GameResultOutputView view = new GameResultOutputView();
        while (true) {
            String user = inputAskingUser();
            if (allUsers.equals(user)) {
                view.outputAll(gameResult);
                break;
            }
            view.outputUser(user, gameResult);
        }
    }

    private String inputAskingUser() {
        AskingUserInputView view = new AskingUserInputView();
        String user = view.input();
        System.out.println();
        return user;
    }
}