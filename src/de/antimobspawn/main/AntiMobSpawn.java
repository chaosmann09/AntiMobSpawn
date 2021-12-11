package de.antimobspawn.main;

import de.antimobspawn.listeners.EntitySpawnListener;
import org.bukkit.Bukkit;
import org.bukkit.entity.Creature;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.java.JavaPlugin;

public class AntiMobSpawn extends JavaPlugin {

    private String PREFIX = "§8[§6AntiMobSpawn§8] ";

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(PREFIX + "§aPlugin geladen");
        Bukkit.getPluginManager().registerEvents(new EntitySpawnListener(), this);
        Bukkit.getWorlds().forEach(currentWorld -> currentWorld.getEntities().stream().filter(currentEntity -> (currentEntity instanceof Creature)).forEach(Entity::remove));
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(PREFIX + "§cPlugin wurde deaktiviert");
    }
}
