package com.devcon3.botbuddy.mob;


import com.devcon3.botbuddy.reference.Reference;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderBotBuddyMob extends RenderLiving {

    private static final ResourceLocation mobTextures = new ResourceLocation(Reference.MOD_ID + ":textures/entity/BotBuddy.png");


    public RenderBotBuddyMob(ModelBase parModelBase, float par2){
        super(parModelBase, par2);

    }


    protected ResourceLocation getEntityTexture(EntityBotBuddyMob entity) {


        return mobTextures;
    }

    protected ResourceLocation getEntityTexture(Entity entity) {


        return this.getEntityTexture((EntityBotBuddyMob)entity);
    }

}
