package com.seqhack.teamoc.sixthsense;

import com.seqhack.teamoc.sixthsense.data.BeaconDataHelper;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by sachin.gajraj on 9/11/16.
 */
public class MyContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        BeaconDataHelper.init();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
