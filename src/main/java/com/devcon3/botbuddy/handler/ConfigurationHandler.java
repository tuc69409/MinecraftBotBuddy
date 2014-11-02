package com.devcon3.botbuddy.handler;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigurationHandler {


    public static Configuration configuration;

    public static void init(File configFile){

        //Create configuration object from given configuration file
        configuration = new Configuration(configFile);
        boolean configValue = false;
        try{

            //Load configuration file
            configuration.load();

            //Read properties from configuration file

            configValue = configuration.get(Configuration.CATEGORY_GENERAL, "configValue", true, "This is and example config value").getBoolean(true);
        }
        catch (Exception ex)
        {
            //Log exception
        }
        finally {

            //Save configuration file
            if(configuration.hasChanged()) {
                configuration.save();
            }
        }

        System.out.println(configValue);

    }
}
