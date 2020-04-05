package net.bnbdiscord.raretrades;

import org.bukkit.Bukkit;
import static org.bukkit.ChatColor.*;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class TradeUI implements CommandExecutor {

    ItemCreator ic = new ItemCreator();
    public Inventory tradeUI;

    public void GUISetItem(Inventory gui,int slot, ItemStack item){
        gui.setItem(slot, item);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;
        CreateUI(p);

        p.openInventory(tradeUI);

        return false;
    }

    public void CreateUI(Player p){
        tradeUI = Bukkit.createInventory(p, 9, "Trades");

        GUISetItem(tradeUI, 3, ic.createItem(Material.TALL_GRASS, GREEN + "Double Tallgrass", ChatColor.GRAY + "Cost: 2 tall grass"));
        GUISetItem(tradeUI, 5, ic.createItem(Material.LARGE_FERN, GREEN + "Large Fern", ChatColor.GRAY + "Cost: 2 ferns"));
    }

}
