import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.openapi.vcs.FilePath;
import com.intellij.openapi.vcs.VcsException;
import com.intellij.openapi.vcs.changes.ChangeListManagerGate;
import com.intellij.openapi.vcs.changes.ChangeProvider;
import com.intellij.openapi.vcs.changes.ChangelistBuilder;
import com.intellij.openapi.vcs.changes.VcsDirtyScope;
import com.intellij.openapi.vfs.VirtualFile;

import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2018/5/28.
 */
public class CopyUncommitedFiles extends AnAction {
    public void actionPerformed(AnActionEvent e) {
        ChangeProvider cp = new ChangeProvider() {
            @Override
            public void getChanges(VcsDirtyScope vcsDirtyScope, ChangelistBuilder changelistBuilder, ProgressIndicator progressIndicator, ChangeListManagerGate changeListManagerGate) throws VcsException {
                Set<FilePath> set =  vcsDirtyScope.getDirtyFiles();
                for (FilePath filePath : set) {
                    System.out.println(filePath.getPath());
                }
            }

            @Override
            public boolean isModifiedDocumentTrackingRequired() {
                return false;
            }

            @Override
            public void doCleanup(List<VirtualFile> list) {
                System.out.println(list.size());
            }
        };
//        DataContext dataContext= DataManager.getInstance().getDataContext();
//        Project project= DataKeys.PROJECT.getData(dataContext);

//        LocalChangeList.
//        Vcs.getChangeProvider()
//        ChangeList cl = new

//        FileStatus.ADDED
//        VcsDirtyScopeManager sm = VcsDirtyScopeManager.getInstance(project);
//        sm.changesProcessed();



















    }
}
