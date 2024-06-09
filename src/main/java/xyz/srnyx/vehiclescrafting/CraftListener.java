package xyz.srnyx.vehiclescrafting;

import es.pollitoyeye.vehicles.VehiclesMain;

import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import xyz.srnyx.annoyingapi.AnnoyingListener;


public class CraftListener extends AnnoyingListener {
    @NotNull private final VehiclesCrafting plugin;
    @Nullable private NamespacedKey key;

    public CraftListener(@NotNull VehiclesCrafting plugin) {
        this.plugin = plugin;
    }

    @Override @NotNull
    public VehiclesCrafting getAnnoyingPlugin() {
        return plugin;
    }

    @EventHandler
    public void onCraft(@NotNull CraftItemEvent event) {
        // Check if this is a vehicle recipe
        final ItemMeta resultMeta = event.getRecipe().getResult().getItemMeta();
        if (resultMeta == null) return;
        if (key == null) key = new NamespacedKey(VehiclesMain.getPlugin(), "UUID");
        if (!resultMeta.getPersistentDataContainer().has(key, PersistentDataType.STRING)) return;

        // Prevent shift-click
        if (event.isShiftClick()) {
            event.setCancelled(true);
            return;
        }

        // Prevent cursor stacking
        final ItemStack cursor = event.getCursor();
        if (cursor == null) return;
        final ItemMeta cursorMeta = cursor.getItemMeta();
        if (cursorMeta != null && cursorMeta.getPersistentDataContainer().has(key, PersistentDataType.STRING)) event.setCancelled(true);
    }
}
