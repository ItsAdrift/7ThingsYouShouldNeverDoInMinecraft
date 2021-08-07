package me.itsadrift.seventhingsyoushouldneverdoinminecraft;

import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class EnderDragonKill implements Listener {

    NamespacedKey diamondKey = new NamespacedKey(Main.getInstance(), "diamond");

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        String m = e.getMessage();
        World w = p.getWorld();

        if (m.equalsIgnoreCase("ENDERDRAGON, YOU MUST DIE")) {

            Bukkit.getScheduler().runTask(Main.getInstance(), new Runnable() {
                @Override
                public void run() {
                    for (Entity en : p.getNearbyEntities( 500, 500,500)) {
                        if (en.getType() == EntityType.ENDER_DRAGON) {
                            EnderDragon dragon = (EnderDragon) en;
                            dragon.setHealth(0);
                        }
                    }

                    for (int x = 0; x < 100; x++) {
                        for (int z = 0; z < 100; z++) {
                            if (x % 2 == 0 && z % 2 == 0) {
                                Location a = new Location(w, x - 50, 100, z - 50);
                                ItemStack b = new ItemStack(Material.DIAMOND);
                                ItemMeta c = b.getItemMeta();
                                List<String> d = new ArrayList<>();
                                d.add(UUID.randomUUID().toString());
                                c.setLore(d);
                                c.getPersistentDataContainer().set(diamondKey, PersistentDataType.STRING, "a");
                                b.setItemMeta(c);
                                w.dropItemNaturally(a, b);
                            }
                        }

                    }

                }
            });


        }
    }

    @EventHandler
    public void onPickUp(EntityPickupItemEvent e) {
        if (e.getItem().getItemStack().getItemMeta().getPersistentDataContainer().has(diamondKey, PersistentDataType.STRING)) {
            e.setCancelled(true);
        }
    }



    }
