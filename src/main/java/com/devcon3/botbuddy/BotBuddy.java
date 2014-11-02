package com.devcon3.botbuddy;

import com.devcon3.botbuddy.handler.ConfigurationHandler;
import com.devcon3.botbuddy.init.ModBlocks;
import com.devcon3.botbuddy.init.ModItems;
import com.devcon3.botbuddy.proxy.IProxy;
import com.devcon3.botbuddy.reference.Reference;
import com.devcon3.botbuddy.utility.LogHelper;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class BotBuddy {

    @Mod.Instance(Reference.MOD_ID)
    public static BotBuddy instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        LogHelper.info("Starting Pre Initialization!");
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
        ModItems.init();
        ModBlocks.init();
        LogHelper.info("Pre Initialization Complete!");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        LogHelper.info("Starting Initialization!");
        LogHelper.info("Initialization Complete!");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){
        LogHelper.info("Starting Post Initialization!");
        LogHelper.info("Post Initialization Complete!");
    }

}
