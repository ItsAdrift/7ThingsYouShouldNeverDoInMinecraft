package me.itsadrift.seventhingsyoushouldneverdoinminecraft;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

public class SandTemple implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        if (e.getAction() == Action.PHYSICAL) {
            if (e.getClickedBlock().getType() == Material.STONE_PRESSURE_PLATE) {
                if (e.getClickedBlock().getWorld().getBlockAt(e.getClickedBlock().getLocation().clone().subtract(0, 1, 0)).getType() == Material.SANDSTONE) {
                    // Is temple
                    Vector v = new Vector(0, 20, 0);

                    e.getPlayer().setVelocity(v);
                }
            }
        }
    }

}
