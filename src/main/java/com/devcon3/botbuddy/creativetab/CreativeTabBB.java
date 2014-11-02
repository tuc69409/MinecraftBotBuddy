package com.devcon3.botbuddy.creativetab;

import com.devcon3.botbuddy.init.ModItems;
import com.devcon3.botbuddy.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabBB {

    public static final CreativeTabs BB_Tab = new CreativeTabs(Reference.MOD_ID.toLowerCase()){

        @Override
        public Item getTabIconItem(){

            return ModItems.mapleLeaf;
        }
    };

}
