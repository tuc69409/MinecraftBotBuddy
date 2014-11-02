package com.devcon3.botbuddy.init;

import com.devcon3.botbuddy.item.ItemBB;
import com.devcon3.botbuddy.item.ItemMapleLeaf;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModItems {

    public static final ItemBB mapleLeaf = new ItemMapleLeaf();

    public static void init(){

        GameRegistry.registerItem(mapleLeaf, "mapleLeaf");
    }
}
