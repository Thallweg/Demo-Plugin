package pl.thalweg.demoplugin;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.pom.Navigatable;
import org.jetbrains.annotations.NotNull;

public class ZawszeDostepnaAkcja extends AnAction {

    @Override
    public void update(@NotNull AnActionEvent event) {
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent anActionEvent) {
        Project project = anActionEvent.getProject();

        StringBuilder message = new StringBuilder();

        Navigatable element = anActionEvent.getData(CommonDataKeys.NAVIGATABLE);

        if (element != null) {
            message.append("You used the common action for:\n")
                    .append(anActionEvent.getPresentation().getText())
                    .append(" ziomek\n")
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
