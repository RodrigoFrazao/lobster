package org.nexuzhealth;

import com.embabel.agent.api.annotation.AchievesGoal;
import com.embabel.agent.api.annotation.Action;
import com.embabel.agent.api.annotation.Agent;

import com.embabel.agent.api.common.OperationContext;
import com.embabel.agent.api.common.PromptRunner;
import com.embabel.agent.core.CoreToolGroups;
import com.embabel.agent.domain.io.UserInput;
import com.embabel.agent.domain.library.Blog;
import com.embabel.agent.spi.LlmUse;

@Agent(
        name = "lobster",
        description = "I am a lobster"
)
public class LobsterAgent {

    @Action
    public String iAmLobster(UserInput userInput, OperationContext context) {
        return context.ai()
                .withAutoLlm()
                .createObject("""
                You are a super intelligent lobster.
                And humans are about to %s
                """.formatted(userInput.getContent()),
                        String.class);
    }

    @AchievesGoal(description = "Review a story")
    @Action
    public String goalAchieverLobster(String prompt, OperationContext context) {
        return context.ai()
                .withLlmByRole("reviewer")
                .createObject("""
                You are a meticulous editor.
                Carefully review this story:
            """,
                        String.class);
    }
}
