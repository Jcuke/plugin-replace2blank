import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ide.CopyPasteManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vcs.FileStatusManager;
import com.intellij.openapi.vcs.VcsConfiguration;
import com.intellij.openapi.vcs.changes.ChangeListManagerImpl;
import com.intellij.openapi.vcs.impl.FileStatusManagerImpl;

import java.awt.datatransfer.StringSelection;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2018/5/28.
 */
public class Gittttttt extends AnAction {
    public void actionPerformed(AnActionEvent e) {
        Project project = e.getProject();

        ChangeListManagerImpl cm = new ChangeListManagerImpl(project, new VcsConfiguration());
//        LocalChangeList lc = cm.getDefaultChangeList();
//        ((VariableHeightLayoutCache) ((Tree.MySelectionModel) ((ChangesListView) ((ChangeListManagerImpl) cm).d.c).mySelectionModel).rowMapper).visibleNodes

        FileStatusManagerImpl fsm = (FileStatusManagerImpl) FileStatusManager.getInstance(project);

        Class<FileStatusManagerImpl> clzz = FileStatusManagerImpl.class;
        try {
            Field field = clzz.getDeclaredField("a");
            field.setAccessible(true);
            Object obj = field.get(fsm);
            Class<?> innerClzz = Class.forName("java.util.Collections$SynchronizedMap");
            Field innerField = innerClzz.getDeclaredField("m");
            innerField.setAccessible(true);
            HashMap innerObj = (HashMap)innerField.get(obj);
            Set<Map.Entry> entrySet = innerObj.entrySet();
            String msg = "";
            for (Map.Entry entry : entrySet) {
//                System.out.println(entry);
                String path = entry.getKey().toString();
                String fileSttus = entry.getValue().toString();
                System.out.println(path + " : " + fileSttus);
//                if(!path.contains("\\.idea") && path.contains("\\.") && !path.contains("\\.iml")){
                    msg += path + "\n";
//                }
            }

            String s = StringUtil.convertLineSeparators(msg);
            CopyPasteManager.getInstance().setContents(new StringSelection(s));
//            Messages.showMessageDialog(project,String.format(msg), "Information", Messages.getInformationIcon());

//            (java.util.Collections.SynchronizedMap)obj
//            Set<VirtualFileImpl> dirs =  innerObj.keySet();
//            for (VirtualFileImpl dir : dirs) {
////                System.out.println(dir.get);
//                System.out.println(dir);
//            }
//            for (Object o : innerObj.values()) {
//                System.out.println(o.getClass());
//            }
//            System.out.println(innerObj);
//            CopyPasteManager.getInstance().setContents(tf);
        } catch (NoSuchFieldException e1) {
            e1.printStackTrace();
        } catch (IllegalAccessException e1) {
            e1.printStackTrace();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }


//        fsm.a
        System.out.println(cm);


//        Vector<Object> vs = ((VariableHeightLayoutCache) ((Tree.MySelectionModel) ((ChangesListView) (cm.d.c).mySelectionModel).rowMapper).visibleNodes;
    }
}
