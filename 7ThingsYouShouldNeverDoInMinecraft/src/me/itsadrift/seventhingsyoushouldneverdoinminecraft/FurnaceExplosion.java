package me.itsadrift.seventhingsyoushouldneverdoinminecraft;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.FurnaceInventory;

public class FurnaceExplosion implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if (e.getInventory().getType() == InventoryType.FURNACE) {
            FurnaceInventory inv = (FurnaceInventory) e.getInventory();

            Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                @Override
                public void run() {
                    if (inv.getSmelting().getType() == Material.GOLD_INGOT) {
                        if (inv.getFuel() != null && inv.getFuel().getType() == Material.COAL) {
                            spawnExplosion(inv.getHolder().getLocation(), 7, true);
                        }
                    }
                }
            }, 1L);

        }
    }

    @EventHandler
    public void onInventoryDrag(InventoryDragEvent e) {
        if (e.getInventory().getType() == InventoryType.FURNACE) {
            FurnaceInventory inv = (FurnaceInventory) e.getInventory();
            Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                @Override
                public void run() {
                    if (inv.getSmelting().getType() == Material.GOLD_INGOT) {
                        if (inv.getFuel() != null && inv.getFuel().getType() == Material.COAL) {
                            spawnExplosion(inv.getHolder().getLocation(), 7, true);
                        }
                    }
                }
            }, 1L);
        }
    }

    public void spawnExplosion(Location l, int radius, boolean fire) {
        World w = l.getWorld();
        w.createExplosion(l, radius, fire);
    }

}
