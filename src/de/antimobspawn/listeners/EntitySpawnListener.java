package de.antimobspawn.listeners;

import org.bukkit.entity.Creature;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class EntitySpawnListener implements Listener {

    @EventHandler
    public void onentityspawn(EntitySpawnEvent event) {
        if(event.getEntity() instanceof Creature) {
            event.setCancelled(true);
        }
    }
}
