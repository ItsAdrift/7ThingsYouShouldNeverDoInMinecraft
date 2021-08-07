package me.itsadrift.seventhingsyoushouldneverdoinminecraft;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Wither;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class Main extends JavaPlugin {

    private static Main instance;

    public HashMap<UUID, Location> brokenLeaves = new HashMap<UUID, Location>();
    public HashMap<UUID, Integer> stoneBroken = new HashMap<UUID, Integer>();
    public List<UUID> mobsWontAttack = new ArrayList<>();

    public WitherProtector witherProtector;
    public List<Wither> withers = new ArrayList<>();

    @Override
    public void onEnable() {
        instance = this;

        witherProtector = new WitherProtector();

        Bukkit.getPluginManager().registerEvents(new FurnaceExplosion(), this);
        Bukkit.getPluginManager().registerEvents(new TreeLaunch(), this);
        Bukkit.getPluginManager().registerEvents(new MineStraightDown(), this);
        Bukkit.getPluginManager().registerEvents(new SandTemple(), this);
        Bukkit.getPluginManager().registerEvents(new DiamondShank(), this);
        Bukkit.getPluginManager().registerEvents(witherProtector, this);
        Bukkit.getPluginManager().registerEvents(new EnderDragonKill(), this);
    }

    @Override
    public void onDisable() {
        instance = null;
        brokenLeaves.clear();
        stoneBroken.clear();
        mobsWontAttack.clear();
        withers.clear();
    }

    public static Main getInstance() {
        return instance;
    }

}
