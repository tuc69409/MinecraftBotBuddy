package com.devcon3.botbuddy.command;

import java.util.ArrayList;
import java.util.List;

import com.devcon3.botbuddy.mob.EntityBotBuddyMob;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;


public class CommandMoveToLocation extends CommandBase
{
    private List aliases;

    public CommandMoveToLocation()
    {
        this.aliases = new ArrayList();
        this.aliases.add("come");
        this.aliases.add("cometo");
    }

    @Override
    public String getCommandName()
    {
        return "cometo";
    }

    @Override
    public String getCommandUsage(ICommandSender icommandsender)
    {
        return "cometo <x-coordinate> <y-coordinate> <z-coordinate>";
    }

    @Override
    public List getCommandAliases()
    {
        return this.aliases;
    }

    @Override
    public void processCommand(ICommandSender icommandsender, String[] astring)
    {
        
        EntityPlayerMP thePlayer = getCommandSenderAsPlayer(icommandsender);
        ChunkCoordinates coordinates;

        int x, y, z;

        if(astring.length > 3)
        {
            icommandsender.addChatMessage(new ChatComponentText("Too many dimensions, bro. What do you think this is, Interstellar?"));
            return;
        }
        else if(astring.length == 0)
        {

            coordinates = thePlayer.getPlayerCoordinates();

            icommandsender.addChatMessage(new ChatComponentText("Moving to " + coordinates.toString()));
            return;
        }
        if(astring.length < 3)
        {
            icommandsender.addChatMessage(new ChatComponentText("This is Minecraft, not some side scroller, give me 3 dimensions."));
            return;
        }

        try {
            x = Integer.parseInt(astring[0]);
            y = Integer.parseInt(astring[1]);
            z = Integer.parseInt(astring[2]);
        }
        catch(Exception ex){

            icommandsender.addChatMessage(new ChatComponentText("Don't give me your fancy symbols and words! I need coordinates!"));
            return;

        }

        coordinates = new ChunkCoordinates(x, y, z);

        icommandsender.addChatMessage(new ChatComponentText("Moving to " + coordinates.toString()));

    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender icommandsender)
    {
        return true;
    }

    @Override
    public List addTabCompletionOptions(ICommandSender icommandsender,
                                        String[] astring)
    {
        return null;
    }

    @Override
    public boolean isUsernameIndex(String[] astring, int i)
    {
        return false;
    }

    @Override
    public int compareTo(Object o)
    {
        return 0;
    }
}
