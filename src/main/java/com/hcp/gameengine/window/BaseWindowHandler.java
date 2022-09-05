package com.hcp.gameengine.window;

import com.hcp.gameengine.file.GeneralFileHandler;

/* Created by: Jesse
 * Create Datetime: 09/05/2022 03:01 P.M.
 * Class: BaseWindowHandler
 * Purpose: To handle the base window
 *          Should provide function to draw the base window
 * Last Modified: 09/05/2022 03:01 P.M. by Jesse
 */
public class BaseWindowHandler {

    Object config;                      //TODO: there should be a Serializable config object to define, details to be discussed

    BaseWindowHandler(){
        refresh();
    }


    //getConfig
    //desc: A function that gets config from the config file
    //parameters: none
    //returns: a number indicates success status
    private int getConfig(){
        String filePath = "";         //TODO: there should be a fixed filepath and filename for all configs, details to be discussed
        this.config = GeneralFileHandler.importFileGeneral(filePath);
        return 0;
    }

    //refresh
    //desc: A function that refresh the base window
    //parameters: none
    //returns: a number indicates success status
    public int refresh(){
        getConfig();
        drawBaseWindow();
        return 0;
    }

    //showBaseWindow
    //desc: A function that draws the base window
    //parameters: none
    //returns: a number indicates success status
    private int drawBaseWindow(){
        //TODO: draw the base window
        return 0;
    }
}
