package com.devcon3.botbuddy.init;

import com.devcon3.botbuddy.item.ItemBB;
import com.devcon3.botbuddy.item.ItemMapleLeaf;
import com.devcon3.botbuddy.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems {

    public static final ItemBB mapleLeaf = new ItemMapleLeaf();

    public static void init(){

        GameRegistry.registerItem(mapleLeaf, "mapleLeaf");
    }
}
