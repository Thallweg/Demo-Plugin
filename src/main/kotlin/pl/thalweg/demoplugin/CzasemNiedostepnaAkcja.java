package pl.thalweg.demoplugin;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.pom.Navigatable;
import org.jetbrains.annotations.NotNull;

public class CzasemNiedostepnaAkcja extends AnAction {

    @Override
    public void update(@NotNull AnActionEvent e) {
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent anActionEvent) {
        Project project = anActionEvent.getProject();

        StringBuilder message = new StringBuilder();

        Navigatable element = anActionEvent.getData(CommonDataKeys.NAVIGATABLE);

        if (element != null) {
            message.append("You found the hidden action for:\n")
                    .append(anActionEvent.getPresentation().getText())
                    .append(" presentation\n")
                    .append("Selected element: ")
                    .append(element);
        }

        String title = anActionEvent.getPresentation().getDescription();

        Messages.showMessageDialog(
                project,
                message.toString(),
                title,
                Messages.getInformationIcon());
    }
}
