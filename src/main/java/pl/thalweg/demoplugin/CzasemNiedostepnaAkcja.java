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
    public void update(@NotNull AnActionEvent event) {
        event.getPresentation().setEnabled(false);
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent event) {
        Project project = event.getProject();

        StringBuilder message = new StringBuilder();

        Navigatable element = event.getData(CommonDataKeys.NAVIGATABLE);

        if (element != null) {
            message.append("You found the hidden action for:\n")
                    .append(event.getPresentation().getText())
                    .append(" presentation\n")
                    .append("Selected element: ")
                    .append(element);
        }

        String title = event.getPresentation().getDescription();

        Messages.showMessageDialog(
                project,
                message.toString(),
                title,
                Messages.getInformationIcon());
    }
}
