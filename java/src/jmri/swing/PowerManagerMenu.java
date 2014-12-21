// PowerManagerMenu.java

package jmri.swing;

import java.util.List;

import javax.swing.*;

import jmri.InstanceManager;
import jmri.PowerManager;

/**
 * Create a menu for selecting the Power Manager to use
 *
 * @author	Bob Jacobsen   Copyright 2010
 * @version     $Revision$
 * @since 2.9.5
 */
abstract public class PowerManagerMenu extends JMenu {

    /**
     * Get the currently selected manager
     */
    public PowerManager get() {
        return null;
    }
    
    abstract protected void choiceChanged();
    
    /**
     * Create a PowerManager menu.
     */
    public PowerManagerMenu() {
        super();

        ButtonGroup group = new ButtonGroup();
        
        // label this menu
        setText("Connection");
        
        // now add an item for each available manager
        List<PowerManager> managers = InstanceManager.getList(PowerManager.class);
        if (managers != null) {
            for (PowerManager mgr : managers) {
                if (mgr != null) {
                    JMenuItem item = new JRadioButtonMenuItem(mgr.getUserName());
                    add(item);
                    group.add(item);
                    items.add(item);
                    item.addActionListener(new java.awt.event.ActionListener(){
                        public void actionPerformed(java.awt.event.ActionEvent e) {
                            choiceChanged();
                        }
                    });
                }
            }
        }
        
        setDefault();
    }
    
    List<JMenuItem> items = new java.util.ArrayList<JMenuItem>(); 
    
    void setDefault() {
        // name of default
        PowerManager manager = InstanceManager.powerManagerInstance();
        if (manager == null) return;
        String defaultMgr = manager.getUserName();
        if (defaultMgr == null) return;
        
        for (JMenuItem item : items) {
            if (defaultMgr.equals(item.getActionCommand())) {
                item.setSelected(true);
            }
        }
    }
    
    public PowerManager getManager() {
        // start with default
        PowerManager manager = InstanceManager.powerManagerInstance();
        if (manager == null) return null;
        String name = manager.getUserName();
        
        // find active name
        for (JMenuItem item : items) {
            if (item.isSelected()) {
                name = item.getActionCommand();
                break;
            }
        }
        // find PowerManager and return
        List<PowerManager> managers = InstanceManager.getList(PowerManager.class);
        for (PowerManager mgr : managers) {
            if (name.equals(mgr.getUserName())) return mgr;
        }
        // should not happen
        return null;
    }
}


