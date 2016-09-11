package com.seqhack.teamoc.sixthsense.servlet;

import com.seqhack.teamoc.sixthsense.data.BeaconDataHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sachin.gajraj on 9/11/16.
 */
public class RefreshServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BeaconDataHelper.init();
        response.getWriter().write("done");
    }
}
