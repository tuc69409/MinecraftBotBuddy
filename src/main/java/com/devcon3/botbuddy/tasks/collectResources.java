package com.devcon3.botbuddy.tasks;

/**
 * Created by nil7july on 11/26/2014.
 */

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Vec3;

public class collectResources extends EntityAIBase
{
    private EntityCreature theEntityCreature;
    private double speed;
    private double randPosX;
    private double randPosY;
    private double randPosZ;
    private static final String __OBFID = "CL_00001604";

    public collectResources(EntityCreature p_i1645_1_, double p_i1645_2_)
    {
        this.theEntityCreature = p_i1645_1_;
        this.speed = p_i1645_2_;
        this.setMutexBits(1);

        theEntityCreature.tasks.addTask(0, new EntityAISwimming(theEntityCreature));
        theEntityCreature.tasks.addTask(2, new EntityAIAttackOnCollide(theEntityCreature, EntityPlayer.class, 1.0D, false));
        theEntityCreature.tasks.addTask(4, new EntityAIAttackOnCollide(theEntityCreature, EntityVillager.class, 1.0D, true));
        theEntityCreature.tasks.addTask(5, new EntityAIMoveTowardsRestriction(theEntityCreature, 1.0D));
        theEntityCreature.tasks.addTask(6, new EntityAIMoveThroughVillage(theEntityCreature, 1.0D, false));
        theEntityCreature.tasks.addTask(7, new EntityAIWander(theEntityCreature, 1.0D));
        theEntityCreature.tasks.addTask(8, new EntityAIWatchClosest(theEntityCreature, EntityPlayer.class, 8.0F));
        theEntityCreature.tasks.addTask(8, new EntityAILookIdle(theEntityCreature));
        theEntityCreature.tasks.addTask(9, new EntityAIOpenDoor(theEntityCreature, true));
        theEntityCreature.targetTasks.addTask(1, new EntityAIHurtByTarget(theEntityCreature, true));
        theEntityCreature.targetTasks.addTask(2, new EntityAINearestAttackableTarget(theEntityCreature, EntityPlayer.class, 0, true));
        theEntityCreature.targetTasks.addTask(2, new EntityAINearestAttackableTarget(theEntityCreature, EntityVillager.class, 0, false));


    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        if (this.theEntityCreature.getAITarget() == null && !this.theEntityCreature.isBurning())
        {
            return false;
        }
        else
        {
            Vec3 vec3 = RandomPositionGenerator.findRandomTarget(this.theEntityCreature, 5, 4);

            if (vec3 == null)
            {
                return false;
            }
            else
            {
                this.randPosX = vec3.xCoord;
                this.randPosY = vec3.yCoord;
                this.randPosZ = vec3.zCoord;
                return true;
            }
        }
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
        this.theEntityCreature.getNavigator().tryMoveToXYZ(this.randPosX, this.randPosY, this.randPosZ, this.speed);
        //this.theEntityCreature.tasks.addTask(1, new EntityAIArrowAttack(theEntityCreature.attackEntityAsMob(the),8,9,323l));
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean continueExecuting()
    {
        return !this.theEntityCreature.getNavigator().noPath();
    }
}
