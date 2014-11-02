package com.devcon3.botbuddy;

import com.devcon3.botbuddy.proxy.IProxy;
import com.devcon3.botbuddy.reference.Reference;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

import java.sql.Ref;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION)
public class BotBuddy {

    @Mod.Instance(Reference.MOD_ID)
    public static BotBuddy instance;

    @SidedProxy(clientSide = "com.devcon3.botbuddy.proxy.ClientProxy", serverSide = "com.devcon3.botbuddy.proxy.ServerProxy")
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){

    }

}
