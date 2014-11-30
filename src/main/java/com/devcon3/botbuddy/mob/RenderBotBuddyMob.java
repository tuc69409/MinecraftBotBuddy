package com.devcon3.botbuddy.mob;


import com.devcon3.botbuddy.reference.Reference;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;


public class RenderBotBuddyMob extends RenderLiving {

    private static final ResourceLocation mobTextures = new ResourceLocation(Reference.MOD_ID + ":textures/entity/BotBuddy.png");



    protected ModelBase modelEntity;

    private Object ModelBipedMobRightarm;

    public RenderBotBuddyMob(ModelBase parModelBase, float par2){
        super( parModelBase, par2);
      //  modelEntity = ((ModelBiped) mainModel);

    }


    protected ResourceLocation getEntityTexture(EntityBotBuddyMob entity) {


        return mobTextures;
    }

    protected ResourceLocation getEntityTexture(Entity entity) {


        return this.getEntityTexture((EntityBotBuddyMob)entity);
    }

    public void renderBotBuddyMob(EntityBotBuddyMob entity, double x, double y, double z, float u, float v) {
        super.doRender(entity, x, y, z, u, v);
    }

    public void doRenderLiving(EntityLiving entityLiving, double x, double y, double z, float u, float v) {
        renderBotBuddyMob((EntityBotBuddyMob) entityLiving, x, y, z, u, v);
    }

    public void doRender(Entity entity, double x, double y, double z, float u, float v) {
        renderBotBuddyMob((EntityBotBuddyMob)entity, x, y, z, u, v);
    }

}
