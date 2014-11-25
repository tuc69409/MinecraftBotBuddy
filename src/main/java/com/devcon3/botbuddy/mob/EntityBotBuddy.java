package com.devcon3.botbuddy.mob;

import com.devcon3.botbuddy.BotBuddy;
import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;

public class EntityBotBuddy {

    public static void mainRegistry() {

        registerEntity();
    }

    public static void registerEntity() {

        createEntity(EntityBotBuddyMob.class, "BotBuddy Mob", 0xC445BA, 0x45C44F);
    }

    public static void createEntity(Class entityClass, String entityName, int solidColor, int spotColor) {

        int randomId = EntityRegistry.findGlobalUniqueEntityId();
        EntityRegistry.registerGlobalEntityID(entityClass, entityName, randomId);
        EntityRegistry.registerModEntity(entityClass, entityName, randomId, BotBuddy.instance, 64, 1, true);

        createEgg(randomId, solidColor, spotColor);
    }

    private static void createEgg(int randomId, int solidColor, int spotColor) {

        EntityList.entityEggs.put(Integer.valueOf(randomId), new EntityList.EntityEggInfo(randomId, solidColor, spotColor));
    }
}