package com.devcon3.botbuddy.init;

import com.devcon3.botbuddy.block.BlockBB;
import com.devcon3.botbuddy.block.BlockHoHoHo;
import com.devcon3.botbuddy.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks {

    public static final BlockBB flag = new BlockHoHoHo();

    public static void init(){

        GameRegistry.registerBlock(flag, "flag");
    }
}
