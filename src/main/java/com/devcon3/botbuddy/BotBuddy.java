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
import net.minecraftforge.oredict.OreDictionary;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class BotBuddy {

    @Mod.Instance(Reference.MOD_ID)
    public static BotBuddy instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        LogHelper.info("Starting Pre Initialization!");
        LogHelper.info("%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        LogHelper.info("%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        LogHelper.info("%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
        ModItems.init();
        ModBlocks.init();
        LogHelper.info("%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        LogHelper.info("%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        LogHelper.info("%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        LogHelper.info("Pre Initialization Complete!");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        LogHelper.info("Starting Initialization!");
        LogHelper.info("%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        LogHelper.info("%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        LogHelper.info("%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        LogHelper.info("%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        LogHelper.info("%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        LogHelper.info("%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        LogHelper.info("Initialization Complete!");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){
        LogHelper.info("Starting Post Initialization!");
        LogHelper.info("%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        LogHelper.info("%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        LogHelper.info("%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        for(String oreName : OreDictionary.getOreNames()){

            LogHelper.info(oreName);
        }

        LogHelper.info("%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        LogHelper.info("%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        LogHelper.info("%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        LogHelper.info("Post Initialization Complete!");
    }

}
