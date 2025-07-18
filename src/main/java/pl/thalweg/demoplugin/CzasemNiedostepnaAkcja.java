package pl.thalweg.demoplugin;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.pom.Navigatable;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class CzasemNiedostepnaAkcja extends AnAction {

    @Override
    public void update(@NotNull AnActionEvent event) {
        if (LocalTime.now().getSecond()>30) {
            System.out.println("Enabling CzasemNiedostepnaAkcja");
            event.getPresentation().setEnabledAndVisible(true);
        } else {
            System.out.println("Disabling CzasemNiedostepnaAkcja");
            event.getPresentation().setEnabledAndVisible(false);
        }
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
