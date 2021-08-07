package me.itsadrift.seventhingsyoushouldneverdoinminecraft;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;

public class Util {

        public static boolean isLeave(Material m) {
            if (m == Material.ACACIA_LEAVES || m == Material.BIRCH_LEAVES || m == Material.DARK_OAK_LEAVES || m == Material.JUNGLE_LEAVES || m == Material.OAK_LEAVES || m == Material.SPRUCE_LEAVES) {
                return true;
            } else {
                return false;
            }
        }

        public static boolean isLog(Material m) {
                if (m == Material.ACACIA_LOG || m == Material.BIRCH_LOG || m == Material.DARK_OAK_LOG || m == Material.JUNGLE_LOG || m == Material.OAK_LOG || m == Material.SPRUCE_LOG) {
                    return true;
                } else {
                    return false;
                }

        }

        public static void fillBlocks(Material mat, Location min, Location max) {
            World a = min.getWorld();
            World b = max.getWorld();

            if (a.equals(b)) {
                World world = a;
                for(int x = min.getBlockX(); x <= max.getBlockX(); x++) {
                    for(int y = min.getBlockY(); y <= max.getBlockY(); y++) {
                        for(int z = min.getBlockZ(); z <= max.getBlockZ(); z++) {
                            Block block = world.getBlockAt(x, y, z);
                            block.setType(mat);
                        }
                    }
                }
            } else {
                return;
            }


        }

}
