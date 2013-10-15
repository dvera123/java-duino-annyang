package com.projectx.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.projectx.util.TwoWaySerialComm;
import com.projectx.util.TwoWaySerialComm.SerialWriter;


public class AnnyangController extends MultiActionController{
	public static String sync = null;
	public ModelAndView list(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelMap modelMap = new ModelMap();
        //sync = null;
        /*
        LogLog.warn("here warn");
        LogLog.error("here error");
        */
        
        if (SerialWriter.a == null){
    		(new TwoWaySerialComm()).connect("/dev/ttyS88");
    		SerialWriter.a = "b";
    	}
       
        return new ModelAndView("annyang/view_annyang", modelMap);
    }
	
	@RequestMapping(value = "/turnOnLight", method = RequestMethod.POST)
	public ModelAndView turnOnLight(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
		
        ModelMap modelMap = new ModelMap();
        //System.out.println(request.getParameter("light"));
        /*
        LogLog.warn("here warn");
        LogLog.error("here error");
        */
        try
        {	
        	if(request.getParameter("light").equals("red")){
            	 sync = "a";
            }
            
           
        }
        catch ( Exception e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return new ModelAndView("annyang/view_annyang", modelMap);
    }
	
	@RequestMapping(value = "/turnOffLight", method = RequestMethod.POST)
	public ModelAndView turnOffLight(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
		
        ModelMap modelMap = new ModelMap();
        //System.out.println(request.getParameter("light"));
        /*
        LogLog.warn("here warn");
        LogLog.error("here error");
        */
        try
        {	
        	
            if(request.getParameter("light").equals("red")){
            	 sync = "b";
            }
            
           
        }
        catch ( Exception e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return new ModelAndView("annyang/view_annyang", modelMap);
    }

}
