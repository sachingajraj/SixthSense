package com.seqhack.teamoc.sixthsense;

import com.seqhack.teamoc.sixthsense.data.BeaconDataHelper;
import com.seqhack.teamoc.sixthsense.entity.AdjBeacon;
import com.seqhack.teamoc.sixthsense.entity.Beacon;
import com.seqhack.teamoc.sixthsense.service.JpaService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.List;

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
