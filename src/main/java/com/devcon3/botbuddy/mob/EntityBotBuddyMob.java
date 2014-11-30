package com.devcon3.botbuddy.mob;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;

public class EntityBotBuddyMob extends EntityAnimal {

    public String currentOrder = "null";
    public double x_dest = 0.0;
    public double y_dest = 0.0;
    public double z_dest = 0.0;

    public EntityBotBuddyMob(World par1World) {
        super(par1World);
        this.setSize(.7F, 4F);
        this.enchantEquipment();

        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityBotBuddyMob.class, 1.0D, true));
       // this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityBotBuddyMob.class, 0, false));
        //this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
       // this.tasks.addTask(6, new EntityAIMoveThroughVillage(this, 1.0D, false));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.tasks.addTask(9, new EntityAIOpenDoor(this, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityVillager.class, 0, false));
    }

    public void moveCommand(ChunkCoordinates coordinates){


        try {
            double x = Double.parseDouble(Integer.toString(coordinates.posX));
            double y = Double.parseDouble(Integer.toString(coordinates.posY));
            double z = Double.parseDouble(Integer.toString(coordinates.posZ));

            boolean moved = this.getNavigator().tryMoveToXYZ(x, y, z , 0.7);

           // this.move


            System.out.println(moved);


        }

        catch(Exception ex){

            System.out.println("whoops");
        }



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

    public ItemStack getHeldItem()
    {
        return heldItem;
    }
    public static ItemStack heldItem = new ItemStack(Items.iron_sword);

}
