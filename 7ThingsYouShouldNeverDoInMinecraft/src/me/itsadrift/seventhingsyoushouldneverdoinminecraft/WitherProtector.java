package me.itsadrift.seventhingsyoushouldneverdoinminecraft;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Wither;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;
import org.bukkit.persistence.PersistentDataType;

public class WitherProtector implements Listener {

    public WitherProtector() {
        startTask();
    }

    @EventHandler
    public void onSpawn(CreatureSpawnEvent e) {
        if (e.getEntity().getType() == EntityType.WITHER) {
            Main.getInstance().withers.add((Wither) e.getEntity());
        }
    }

    @EventHandler
    public void onTarget(EntityTargetLivingEntityEvent e) {
        if (e.getEntity().getType() == EntityType.WITHER) {
            e.setCancelled(true);
        }
    }

    private void startTask() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                for (Wither w : Main.getInstance().withers) {
                    for (Entity e : w.getNearbyEntities(10, 10, 10)) {
                        if (e.getType() != EntityType.PLAYER) {
                            if (e instanceof LivingEntity) {
                                w.setTarget((LivingEntity) e);
                            }
                            break;
                        }
                    }
                }
            }
        }, 3, 20);
    }

}
