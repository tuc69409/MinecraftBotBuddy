package com.devcon3.botbuddy.mob;

import com.devcon3.botbuddy.tasks.EntityAIMoveToLocation;
import com.devcon3.botbuddy.tasks.EntityAIWaitForOrder;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.init.Items;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ClientChatReceivedEvent;

public class EntityBotBuddyMob extends EntityAnimal{

    public String currentOrder = "null";
    public double x_dest = 0.0;
    public double y_dest = 0.0;
    public double z_dest = 0.0;

    public EntityBotBuddyMob(World par1World) {
        super(par1World);
        this.setSize(.7F, 4F);



        this.tasks.addTask(0, new EntityAIPanic(this, 0.7));
        this.tasks.addTask(1, new EntityAITempt(this, 0.7, Items.cooked_beef, false));
        this.tasks.addTask(2, new EntityAIWaitForOrder(this));
       // this.tasks.addTask(2, new Entity);
       // this.tasks.addTask(2, new EntityAIMoveToLocation(this, 0.7));
        //this.tasks.addTask(3, new EntityAIWander(this, 0.5));
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

}
