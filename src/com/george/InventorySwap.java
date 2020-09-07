package com.george;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class InventorySwap extends JavaPlugin implements Runnable {

    @Override
    public void onEnable() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, this, 0, 1200);
    }

    @Override
    public void run() {
        if (Bukkit.getOnlinePlayers().size() == 2) {
            ArrayList<Player> players = new ArrayList<>(Bukkit.getOnlinePlayers());
            ItemStack[] inventory = players.get(0).getInventory().getContents();
            players.get(0).getInventory().setContents(players.get(1).getInventory().getContents());
            players.get(1).getInventory().setContents(inventory);
        }
    }
}
