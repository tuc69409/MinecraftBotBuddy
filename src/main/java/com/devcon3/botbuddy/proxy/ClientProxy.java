package com.devcon3.botbuddy.proxy;

import com.devcon3.botbuddy.client.settings.Keybindings;
import com.devcon3.botbuddy.mob.BotBuddy;
import com.devcon3.botbuddy.mob.EntityBotBuddyMob;
import com.devcon3.botbuddy.mob.RenderBotBuddyMob;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy{

    @Override
    public void registerKeyBindings() {

        RenderingRegistry.registerEntityRenderingHandler(EntityBotBuddyMob.class, new RenderBotBuddyMob(new BotBuddy(), 0));

        ClientRegistry.registerKeyBinding(Keybindings.charge);
        ClientRegistry.registerKeyBinding(Keybindings.release);
    }
}
