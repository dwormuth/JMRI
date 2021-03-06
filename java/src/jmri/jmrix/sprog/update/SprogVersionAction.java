//SprogVersionAction.java
package jmri.jmrix.sprog.update;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Swing action to get SPROG firmware version
 *
 * @author	Andrew crosland Copyright (C) 2004
 * @version	$Revision$
 */
public class SprogVersionAction extends AbstractAction {

    /**
     *
     */
    private static final long serialVersionUID = 7751464314869150401L;

    public SprogVersionAction(String s) {
        super(s);
    }

    public void actionPerformed(ActionEvent e) {
        // create a SprogVersionFrame
        SprogVersionFrame f = new SprogVersionFrame();
        try {
            f.initComponents();
        } catch (Exception ex) {
            log.warn("SprogIIUpdateAction starting SprogIIUpdateFrame: Exception: " + ex.toString());
        }
//        f.setVisible(true);
    }

    private final static Logger log = LoggerFactory.getLogger(SprogVersionAction.class.getName());

}


/* @(#)SprogVersionAction.java */
