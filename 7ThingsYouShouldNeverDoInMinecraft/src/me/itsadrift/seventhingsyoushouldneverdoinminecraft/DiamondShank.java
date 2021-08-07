package me.itsadrift.seventhingsyoushouldneverdoinminecraft;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;
import org.bukkit.event.inventory.CraftItemEvent;

public class DiamondShank implements Listener {

    @EventHandler
    public void onCraft(CraftItemEvent e) {
        if (e.getInventory().getMatrix().length == 4) {
            if (e.getInventory().getMatrix()[2] != null && e.getInventory().getMatrix()[2].getType() == Material.STICK) {
                if (e.getInventory().getMatrix()[1] != null && e.getInventory().getMatrix()[1].getType() == Material.COBBLESTONE) {
                    Main.getInstance().mobsWontAttack.add(e.getWhoClicked().getUniqueId());
                }
            }
        }
    }

    @EventHandler
    public void onTarget(EntityTargetLivingEntityEvent e) {
        if (e.getTarget() != null) {
            if (e.getTarget().getType() == EntityType.PLAYER) {
                Player player = (Player) e.getTarget();
                if (Main.getInstance().mobsWontAttack.contains(player.getUniqueId())) {
                    e.setCancelled(true);
                }
            }
        }

    }

}
