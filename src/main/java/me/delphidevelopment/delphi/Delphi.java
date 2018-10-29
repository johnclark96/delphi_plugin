package me.delphidevelopment.delphi;

import me.delphidevelopment.delphi.commands.*;
import me.delphidevelopment.delphi.database.MysqlSetterGetter;
import me.delphidevelopment.delphi.events.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class Delphi extends JavaPlugin implements Listener {

    private Connection connection;
    public String host, database, username, password, table;
    public int port;

    @Override
    public void onEnable() {
        // Plugin startup logic
        loadConfig();
        mysqlSetup();
        System.out.println("Plugin is starting up!");
        getServer().getPluginManager().registerEvents(new OnDeath(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new PlayerLeave(), this);
        getServer().getPluginManager().registerEvents(new PlayerMove(), this);
        getServer().getPluginManager().registerEvents(new MysqlSetterGetter(), this);
        getServer().getPluginManager().registerEvents(new OnInteract(), this);
        getCommand("god").setExecutor(new God());
        getCommand("heal").setExecutor(new Heal());
        getCommand("die").setExecutor(new Die());
        getCommand("feed").setExecutor(new Feed());
        getCommand("explode").setExecutor(new Explode());
        getCommand("sendWord").setExecutor(new SendWord());
        getCommand("clear").setExecutor(new Clear());
        getCommand("openinventory").setExecutor(new OpenInventory());
        getCommand("gamemode").setExecutor(new Gamemode());
    }

    public void loadConfig(){
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

    public void mysqlSetup(){
        host = this.getConfig().getString("host");
        port = this.getConfig().getInt("port");
        database = this.getConfig().getString("database");
        username = this.getConfig().getString("username");
        password = this.getConfig().getString("password");
        table = this.getConfig().getString("table");

        try{

            synchronized (this) {
                if(getConnection() != null && !getConnection().isClosed()) {
                    return;
                }
                Class.forName("java.sql.Driver");
                setConnection(DriverManager.getConnection("jdbc:mysql://" + this.host + ":"
                + this.port + "/" + this.database, this.username, this.password));

                Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "MYSQL CONNECTED!");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
