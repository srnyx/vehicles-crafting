package xyz.srnyx.vehiclescrafting;

import es.pollitoyeye.vehicles.enums.VehicleType;

import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;

import xyz.srnyx.annoyingapi.AnnoyingPlugin;
import xyz.srnyx.annoyingapi.file.AnnoyingResource;


public class VehiclesCrafting extends AnnoyingPlugin {
    public VehiclesCrafting() {
        options
                .bStatsOptions(bStatsOptions -> bStatsOptions.id(22072))
                .registrationOptions.toRegister(new CraftListener(this));
    }

    @Override
    public void enable() {
        // Load recipes
        for (final VehicleType type : VehicleType.values()) {
            final String typeName = type.getConfigName().toLowerCase();
            final AnnoyingResource resource;
            try {
                resource = new AnnoyingResource(this, "recipes/" + typeName + "s.yml");
            } catch (final IllegalArgumentException e) {
                continue;
            }
            for (final String key : resource.getKeys(false)) Bukkit.addRecipe(resource.getRecipe(key, r -> type.getVehicleManager().getItem(key, new ItemStack[0]), null, typeName + "_" + key));
        }
    }
}
