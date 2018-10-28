package me.delphidevelopment.delphi.events;

//import me.delphidevelopment.delphi.Delphi;
//import me.delphidevelopment.delphi.database.MysqlSetterGetter;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.UUID;

public class PlayerJoin implements Listener {

    //MysqlSetterGetter createPlayer;

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        e.setJoinMessage(ChatColor.AQUA + "Welcome to the server, " + ChatColor.GOLD + player.getDisplayName() + ChatColor.AQUA + " we hope you enjoy your stay");
        //createPlayer(player.getUniqueId(), player);
    }
}