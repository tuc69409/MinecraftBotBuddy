package com.devcon3.botbuddy.tasks;


import com.devcon3.botbuddy.mob.EntityBotBuddyMob;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;

public class EntityAIWaitForOrder extends EntityAIBase {

    private EntityBotBuddyMob entity;
    private static final String __OBFID = "CL_00001608";

    public EntityAIWaitForOrder(EntityBotBuddyMob p_i1648_1_)
    {
        this.entity = p_i1648_1_;
        this.setMutexBits(1);
    }

    public boolean shouldExecute() {

        if(this.entity.currentOrder != "null"){

            return true;

        }

        return false;

    }


    public void startExecuting()
    {
        this.entity.getNavigator().tryMoveToXYZ(this.entity.x_dest, this.entity.y_dest, this.entity.z_dest, 0.7);
    }

}
