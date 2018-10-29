package me.delphidevelopment.delphi.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class CustomItems implements Listener {

    public void giveItems(Player player){
        ItemStack item = new ItemStack(Material.DIAMOND_AXE,1);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(ChatColor.GOLD + "AXE OF ICE");
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(ChatColor.WHITE + "Magical Ice Axe");
        meta.setLore(lore);
        item.setItemMeta(meta);
    }
}
