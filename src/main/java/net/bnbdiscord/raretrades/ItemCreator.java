package net.bnbdiscord.raretrades;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemCreator {

    public ItemStack createItem(Material itemType, String name, String lore){
        ItemStack item = new ItemStack(itemType);
        ItemMeta itemMeta = item.getItemMeta();

        itemMeta.setDisplayName(name);
        List<String> itemLore = new ArrayList<String>();
        itemLore.add(lore);
        itemMeta.setLore(itemLore);
        item.setItemMeta(itemMeta);

        return item;

    }



}
