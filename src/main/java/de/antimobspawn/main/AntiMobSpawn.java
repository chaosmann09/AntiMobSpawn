package de.antimobspawn.main;


import listeners.EntitySpawnListener;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Creature;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.java.JavaPlugin;

public class AntiMobSpawn extends JavaPlugin {

    private static final String PREFIX = "§8[§6AntiMobSpawn§8] ";

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(PREFIX + "§aPlugin geladen");

        // Register event listener
        Bukkit.getPluginManager().registerEvents(new EntitySpawnListener(), this);

        // Remove all creatures in loaded worlds
        for (World world : Bukkit.getWorlds()) {
            for (Entity entity : world.getEntities()) {
                if (entity instanceof Creature) {
                    entity.remove();
                }
            }
        }
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(PREFIX + "§cPlugin wurde deaktiviert");
    }
}
