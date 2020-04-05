package net.bnbdiscord.raretrades;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Map;

import static org.bukkit.ChatColor.*;

public class TradeUIListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {

        Player p = (Player) e.getWhoClicked();
        String title = p.getOpenInventory().getTitle();
        ItemStack clicked = e.getCurrentItem();

        if(title.equalsIgnoreCase("Trades")){
            if(clicked != null){
                HandleTrade(p, clicked.getItemMeta().getDisplayName());
                e.setCancelled(true);
            }
        }
    }

    public void HandleTrade(Player p, String item){
        Inventory inv = p.getInventory();

        if(item.equalsIgnoreCase(GREEN + "Double Tallgrass")){
            if(inv.contains(Material.GRASS, 2)){
                if(inv.firstEmpty() != -1){

                    consumeItem(p, 2, Material.GRASS);
                    ItemStack tallgrass = new ItemStack(Material.TALL_GRASS, 1);
                    inv.addItem(tallgrass);
                } else {
                    p.sendMessage(RED + "" + BOLD + "FULL!" + RED + " Your inventory is full!");
                }

            } else {
                p.sendMessage(RED + "" + BOLD + "MISSING!" + RED + " You don't have the required materials for this trade!");
            }
        }

        if(item.equalsIgnoreCase(GREEN + "Large Fern")){
            if(inv.contains(Material.FERN, 2)){
                if(inv.firstEmpty() != -1){

                    consumeItem(p, 2, Material.FERN);
                    ItemStack fern = new ItemStack(Material.LARGE_FERN, 1);
                    inv.addItem(fern);
                } else {
                    p.sendMessage(RED + "" + BOLD + "FULL!" + RED + " Your inventory is full!");
                }

            } else {
                p.sendMessage(RED + "" + BOLD + "MISSING!" + RED + " You don't have the required materials for this trade!");
            }
        }
    }

    public boolean consumeItem(Player player, int count, Material mat) {
        Map<Integer, ? extends ItemStack> item = player.getInventory().all(mat);

        int found = 0;
        for (ItemStack stack : item.values())
            found += stack.getAmount();
        if (count > found)
            return false;

        for (Integer index : item.keySet()) {
            ItemStack stack = item.get(index);

            int removed = Math.min(count, stack.getAmount());
            count -= removed;

            if (stack.getAmount() == removed)
                player.getInventory().setItem(index, null);
            else
                stack.setAmount(stack.getAmount() - removed);

            if (count <= 0)
                break;
        }

        player.updateInventory();
        return true;
    }


}
