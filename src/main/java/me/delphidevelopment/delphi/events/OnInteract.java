package me.delphidevelopment.delphi.events;

import me.delphidevelopment.delphi.items.CustomItems;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

public class OnInteract implements Listener {
    private CustomItems ci = new CustomItems();

    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        Action action = event.getAction();
        Player player = event.getPlayer();
        Block block = event.getClickedBlock();

        if(action.equals(Action.LEFT_CLICK_BLOCK)){
            if(((Block) block).getType().equals(Material.EMERALD_BLOCK)) {
                if (player.getHealth() != 20) {
                    player.setHealth(player.getHealth() + 1);
                    player.sendMessage(ChatColor.GREEN + "You have been healed for: " + ChatColor.RED + " +1 health");
                } else {
                    player.sendMessage(ChatColor.YELLOW + "You are already fully healed!");
                }
            /*}else{
                player.sendMessage(ChatColor.GOLD + "You clicked: " + ChatColor.RED + block.getType().toString().toUpperCase());
            }*/
            }
        }
    }

    @EventHandler
    public void onPunch(PlayerInteractEvent event){
        Player player = event.getPlayer();
        ci.giveItems(player);
    }
}
