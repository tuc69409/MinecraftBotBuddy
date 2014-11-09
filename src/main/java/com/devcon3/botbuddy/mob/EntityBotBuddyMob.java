package com.devcon3.botbuddy.mob;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.init.Items;
import net.minecraft.world.World;

public class EntityBotBuddyMob extends EntityAnimal{


    public EntityBotBuddyMob(World par1World) {
        super(par1World);
        this.setSize(.7F, 4F);
        this.tasks.addTask(0, new EntityAIWander(this, 0.5));
        this.tasks.addTask(1, new EntityAIPanic(this, 0.7));
        this.tasks.addTask(2, new EntityAITempt(this, 0.7, Items.cooked_beef, false));
    }

    public boolean isAIEnabled(){
        return true;
    }

    protected void applyEntityAttribute(){

        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(16);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.5);
    }

    @Override
    public EntityAgeable createChild(EntityAgeable p_90011_1_) {
        return new EntityBotBuddyMob(worldObj);
    }
}
