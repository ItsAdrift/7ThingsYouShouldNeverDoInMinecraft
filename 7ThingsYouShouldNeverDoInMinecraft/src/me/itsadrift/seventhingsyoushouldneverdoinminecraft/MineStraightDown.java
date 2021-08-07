package me.itsadrift.seventhingsyoushouldneverdoinminecraft;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.UUID;

public class MineStraightDown implements Listener {

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        Player player = e.getPlayer();
        UUID uuid = player.getUniqueId();
        if (e.getBlock().getType() == Material.STONE) {
            if (Main.getInstance().stoneBroken.containsKey(uuid)) {
                Main.getInstance().stoneBroken.replace(uuid, Main.getInstance().stoneBroken.get(uuid) + 1);

                if (Main.getInstance().stoneBroken.get(uuid) >= 25) {
                    Location min = player.getLocation().subtract(3, 7, 3);
                    Location max = player.getLocation().add(3, -1, 3);
                    Util.fillBlocks(Material.DIAMOND_ORE, min, max);

                    Main.getInstance().stoneBroken.remove(uuid);
                }

            } else {
                Main.getInstance().stoneBroken.put(uuid, 1);
            }
        }
    }

}
