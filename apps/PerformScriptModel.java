// PerformScriptModel.java

package apps;

import com.sun.java.util.collections.ArrayList;
import com.sun.java.util.collections.List;

/**
 * A PerformScriptModel object runs a script
 * when the program is started.
 * <P>
 * @author	Bob Jacobsen   Copyright 2003
 * @version     $Revision: 1.1 $
 * @see PerformScriptPanel
 */
public class PerformScriptModel {

    public PerformScriptModel() {
        fileName=null;
    }

    String fileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String n) {
        fileName = n;
    }

    static public void rememberObject(PerformScriptModel m) {
        l.add(m);
    }
    static public List rememberedObjects() {
        return l;
    }
    static List l = new ArrayList();
}


