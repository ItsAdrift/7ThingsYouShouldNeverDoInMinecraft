package me.itsadrift.seventhingsyoushouldneverdoinminecraft;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.util.Vector;

import java.util.UUID;

public class TreeLaunch implements Listener {

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        Player player = e.getPlayer();
        UUID uuid = player.getUniqueId();
        World w = e.getBlock().getWorld();
        Location l = e.getBlock().getLocation();

        if (Util.isLeave(e.getBlock().getType())) {
            if (Util.isLog(w.getBlockAt(l.clone().subtract(0, 1, 0)).getType())) {
                if (Util.isLog(w.getBlockAt(l.clone().subtract(0, 2, 0)).getType())) {
                    if (Util.isLog(w.getBlockAt(l.clone().subtract(0, 3, 0)).getType())) {
                        Main.getInstance().brokenLeaves.put(uuid, l);
                    }
                }
            }
        } else if (Main.getInstance().brokenLeaves.containsKey(uuid)) {
            Location a = Main.getInstance().brokenLeaves.get(uuid);

            if (a.equals(l.clone().add(0, 1, 0))) {
                // Next log

                Vector v = new Vector(0, 10, 0);//.multiply(player.getFacing().getDirection().multiply(-2));
                v.subtract(player.getFacing().getDirection()).subtract(player.getFacing().getDirection());

                player.setVelocity(v);
                Main.getInstance().brokenLeaves.remove(uuid);
            }
        }
    }

}
