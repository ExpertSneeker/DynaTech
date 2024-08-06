package me.profelements.dynatech;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.profelements.dynatech.utils.Recipe;
import me.profelements.dynatech.utils.RecipeRegistry;
import me.profelements.dynatech.utils.TimedRecipe;

public class DynaTechRecipes {
    // START common use items
    private static final ItemStack STICK = new ItemStack(Material.STICK);
    private static final ItemStack OAK_LOG = new ItemStack(Material.OAK_LOG);
    private static final ItemStack REDSTONE_BLOCK = new ItemStack(Material.REDSTONE_BLOCK);
    private static final ItemStack BRICK = new ItemStack(Material.BRICK);
    private static final ItemStack STONE = new ItemStack(Material.STONE);
    private static final ItemStack IRON_INGOT = new ItemStack(Material.IRON_INGOT);
    private static final ItemStack IRON_BLOCK = new ItemStack(Material.IRON_BLOCK);
    private static final ItemStack DIAMOND = new ItemStack(Material.DIAMOND);
    private static final ItemStack DIAMOND_BLOCK = new ItemStack(Material.DIAMOND_BLOCK);
    private static final ItemStack CRYING_OBSIDIAN = new ItemStack(Material.CRYING_OBSIDIAN);
    private static final ItemStack UNBREAKING_3_ENCHANTED_BOOK = new CustomItemStack(Material.ENCHANTED_BOOK, meta -> {
        meta.addEnchant(Enchantment.DURABILITY, 3, false);
    });
    private static final ItemStack GLASS = new ItemStack(Material.GLASS);
    private static final ItemStack CYAN_CONCRETE = new ItemStack(Material.LIGHT_BLUE_CONCRETE);
    private static final ItemStack PINK_CONCRETE = new ItemStack(Material.PINK_CONCRETE);
    private static final ItemStack STRING = new ItemStack(Material.STRING);
    private static final ItemStack IRON_BARS = new ItemStack(Material.IRON_BARS);
    private static final ItemStack END_STONE = new ItemStack(Material.END_STONE);
    private static final ItemStack CHORUS_FRUIT = new ItemStack(Material.CHORUS_FRUIT);
    private static final ItemStack BOOK = new ItemStack(Material.BOOK);
    // END common use items

    private DynaTechRecipes() {
    }
    // START Recipes

    public static final void registerRecipes(RecipeRegistry registry) {

        // START Mechanical Components

        // Wood Machine Core
        Recipe.init()
                .setKey(new NamespacedKey(DynaTech.getInstance(), "wood_machine_core"))
                .setRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
                .setInput(new ItemStack[] { STICK, OAK_LOG, STICK, OAK_LOG, REDSTONE_BLOCK, OAK_LOG, STICK, OAK_LOG,
                        STICK })
                .setOutput(DynaTechItems.WOOD_MACHINE_CORE)
                .register(registry);

        // Stone Machine Core
        Recipe.init()
                .setKey(new NamespacedKey(DynaTech.getInstance(), "stone_machine_core"))
                .setRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
                .setInput(new ItemStack[] { BRICK, STONE, BRICK,
                        STONE, DynaTechItems.WOOD_MACHINE_CORE, STONE, BRICK, STONE, BRICK })
                .setOutput(DynaTechItems.STONE_MACHINE_CORE)
                .register(registry);

        // Iron Machine Core
        Recipe.init()
                .setKey(new NamespacedKey(DynaTech.getInstance(), "iron_machine_core"))
                .setRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
                .setInput(new ItemStack[] { IRON_INGOT, IRON_BLOCK, IRON_INGOT, IRON_BLOCK,
                        DynaTechItems.STONE_MACHINE_CORE, IRON_BLOCK, IRON_INGOT, IRON_BLOCK, IRON_INGOT })
                .setOutput(DynaTechItems.IRON_MACHINE_CORE)
                .register(registry);

        // Diamond Machine Core
        Recipe.init()
                .setKey(new NamespacedKey(DynaTech.getInstance(), "diamond_machine_core"))
                .setRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
                .setInput(new ItemStack[] { DIAMOND, DIAMOND_BLOCK, DIAMOND, DIAMOND_BLOCK,
                        DynaTechItems.IRON_MACHINE_CORE, DIAMOND_BLOCK, DIAMOND, DIAMOND_BLOCK, DIAMOND })
                .setOutput(DynaTechItems.DIAMOND_MACHINE_CORE)
                .register(registry);

        // Enchanted Machine Core
        Recipe.init()
                .setKey(new NamespacedKey(DynaTech.getInstance(), "enchanted_machine_core"))
                .setRecipeType(RecipeType.MAGIC_WORKBENCH)
                .setInput(new ItemStack[] { UNBREAKING_3_ENCHANTED_BOOK, CRYING_OBSIDIAN, UNBREAKING_3_ENCHANTED_BOOK,
                        CRYING_OBSIDIAN, DynaTechItems.DIAMOND_MACHINE_CORE, CRYING_OBSIDIAN,
                        UNBREAKING_3_ENCHANTED_BOOK, CRYING_OBSIDIAN, UNBREAKING_3_ENCHANTED_BOOK })
                .setOutput(DynaTechItems.ENCHANTED_MACHINE_CORE)
                .register(registry);

        // Energy Storage Component
        Recipe.init()
                .setKey(new NamespacedKey(DynaTech.getInstance(), "energy_storage_component"))
                .setRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
                .setInput(new ItemStack[] { SlimefunItems.REDSTONE_ALLOY, GLASS, SlimefunItems.REDSTONE_ALLOY, GLASS,
                        SlimefunItems.BATTERY, GLASS, DynaTechItems.STAINLESS_STEEL_INGOT,
                        DynaTechItems.IRON_MACHINE_CORE,
                        DynaTechItems.STAINLESS_STEEL_INGOT })
                .setOutput(DynaTechItems.ENERGY_STORAGE_COMPONENT)
                .register(registry);

        // Energy Input Component
        Recipe.init()
                .setKey(new NamespacedKey(DynaTech.getInstance(), "energy_input_component"))
                .setRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE).setInput(new ItemStack[] {
                        SlimefunItems.REDSTONE_ALLOY, PINK_CONCRETE, SlimefunItems.REDSTONE_ALLOY,
                        SlimefunItems.COPPER_WIRE, DynaTechItems.IRON_MACHINE_CORE, SlimefunItems.COPPER_WIRE,
                        SlimefunItems.REDSTONE_ALLOY, PINK_CONCRETE, SlimefunItems.REDSTONE_ALLOY,
                }).setOutput(DynaTechItems.ENERGY_INPUT_COMPONENT)
                .register(registry);

        // Energy Output Component
        Recipe.init()
                .setKey(new NamespacedKey(DynaTech.getInstance(), "energy_output_component"))
                .setRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
                .setInput(new ItemStack[] {
                        SlimefunItems.REDSTONE_ALLOY, CYAN_CONCRETE, SlimefunItems.REDSTONE_ALLOY,
                        SlimefunItems.COPPER_WIRE, DynaTechItems.IRON_MACHINE_CORE, SlimefunItems.COPPER_WIRE,
                        SlimefunItems.REDSTONE_ALLOY, CYAN_CONCRETE, SlimefunItems.REDSTONE_ALLOY
                })
                .setOutput(DynaTechItems.ENERGY_OUTPUT_COMPONENT)
                .register(registry);

        // Degraded Wind Mill
        Recipe.init()
                .setKey(new NamespacedKey(DynaTech.getInstance(), "degraded_wind_mill"))
                .setRecipeType(DynaTechItems.DT_BLOCK_DROP)
                .setInput(new ItemStack[] { DynaTechItems.WIND_MILL_1 })
                .setOutput(DynaTechItems.DEGRADED_WIND_MILL)
                .register(registry);

        // Degraded Wind Mill 2
        Recipe.init()
                .setKey(new NamespacedKey(DynaTech.getInstance(), "degraded_wind_mill_2"))
                .setRecipeType(DynaTechItems.DT_BLOCK_DROP)
                .setInput(new ItemStack[] { DynaTechItems.WIND_MILL_2 })
                .setOutput(DynaTechItems.DEGRADED_WIND_MILL_2)
                .register(registry);

        // Degraded Hydro Mill
        Recipe.init()
                .setKey(new NamespacedKey(DynaTech.getInstance(), "degraded_water_mill"))
                .setRecipeType(DynaTechItems.DT_BLOCK_DROP)
                .setInput(new ItemStack[] { DynaTechItems.WATER_MILL_1 })
                .setOutput(DynaTechItems.DEGRADED_WATER_MILL)
                .register(registry);

        // Degraded Hydro Mill 2
        Recipe.init()
                .setKey(new NamespacedKey(DynaTech.getInstance(), "degraded_water_mill_2"))
                .setRecipeType(DynaTechItems.DT_BLOCK_DROP)
                .setInput(new ItemStack[] { DynaTechItems.WATER_MILL_2 })
                .setOutput(DynaTechItems.DEGRADED_WATER_MILL_2)
                .register(registry);
        // Degraded Egg Mill
        Recipe.init()
                .setKey(new NamespacedKey(DynaTech.getInstance(), "degraded_egg_mill"))
                .setRecipeType(DynaTechItems.DT_BLOCK_DROP)
                .setInput(new ItemStack[] { DynaTechItems.EGG_MILL_1 })
                .setOutput(DynaTechItems.DEGRADED_EGG_MILL)
                .register(registry);

        // Degraded Egg Mill 2
        Recipe.init()
                .setKey(new NamespacedKey(DynaTech.getInstance(), "degraded_egg_mill_2"))
                .setRecipeType(DynaTechItems.DT_BLOCK_DROP)
                .setInput(new ItemStack[] { DynaTechItems.EGG_MILL_2 })
                .setOutput(DynaTechItems.DEGRADED_EGG_MILL_2)
                .register(registry);

        // END Mechanical Components

        // Start Generators

        // Water Mill Level 1 (Hydro Generator)
        Recipe.init()
                .setKey(new NamespacedKey(DynaTech.getInstance(), "water_mill_1"))
                .setRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
                .setInput(new ItemStack[] {
                        DynaTechItems.STAINLESS_STEEL_INGOT, DynaTechItems.WOOD_MACHINE_CORE,
                        DynaTechItems.STAINLESS_STEEL_INGOT,
                        DynaTechItems.STAINLESS_STEEL_ROTOR_1, DynaTechItems.ENERGY_STORAGE_COMPONENT,
                        DynaTechItems.STAINLESS_STEEL_ROTOR_1,
                        DynaTechItems.STAINLESS_STEEL_INGOT, DynaTechItems.ENERGY_OUTPUT_COMPONENT,
                        DynaTechItems.STAINLESS_STEEL_INGOT,
                })
                .setOutput(DynaTechItems.WATER_MILL_1)
                .register(registry);

        // Water Mill Repair
        Recipe.init()
                .setKey(new NamespacedKey(DynaTech.getInstance(), "water_mill_1_repair"))
                .setRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
                .setInput(new ItemStack[] {
                        null, null, null,
                        null, DynaTechItems.STAINLESS_STEEL_INGOT, null,
                        DynaTechItems.STAINLESS_STEEL_ROTOR_1, DynaTechItems.DEGRADED_WATER_MILL,
                        DynaTechItems.STAINLESS_STEEL_ROTOR_1,
                })
                .setOutput(DynaTechItems.WATER_MILL_1)
                .register(registry);

        // Water Mill Level 2 (Hydro Turbine)
        Recipe.init()
                .setKey(new NamespacedKey(DynaTech.getInstance(), "water_mill_2"))
                .setRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
                .setInput(new ItemStack[] {
                        DynaTechItems.STAINLESS_STEEL_INGOT, DynaTechItems.STONE_MACHINE_CORE,
                        DynaTechItems.STAINLESS_STEEL_INGOT,
                        DynaTechItems.STAINLESS_STEEL_ROTOR_1, DynaTechItems.WATER_MILL_1,
                        DynaTechItems.STAINLESS_STEEL_ROTOR_1,
                        DynaTechItems.STAINLESS_STEEL_INGOT, DynaTechItems.WATER_MILL_1,
                        DynaTechItems.STAINLESS_STEEL_INGOT,
                })
                .setOutput(DynaTechItems.WATER_MILL_2)
                .register(registry);

        // Water Mill Level 2 Repair
        Recipe.init()
                .setKey(new NamespacedKey(DynaTech.getInstance(), "water_mill_2_repair"))
                .setRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
                .setInput(new ItemStack[] {
                        null, null, null,
                        null, DynaTechItems.STAINLESS_STEEL_INGOT, null,
                        DynaTechItems.STAINLESS_STEEL_ROTOR_1, DynaTechItems.DEGRADED_WATER_MILL_2,
                        DynaTechItems.STAINLESS_STEEL_ROTOR_1,
                })
                .setOutput(DynaTechItems.WATER_MILL_2)
                .register(registry);

        // Wind Mill Level 1
        Recipe.init()
                .setKey(new NamespacedKey(DynaTech.getInstance(), "wind_mill_1"))
                .setRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
                .setInput(new ItemStack[] {
                        null, DynaTechItems.STAINLESS_STEEL_ROTOR_1, null,
                        DynaTechItems.STAINLESS_STEEL_ROTOR_1, DynaTechItems.WOOD_MACHINE_CORE,
                        DynaTechItems.STAINLESS_STEEL_ROTOR_1,
                        DynaTechItems.ENERGY_STORAGE_COMPONENT, DynaTechItems.STAINLESS_STEEL_ROTOR_1,
                        DynaTechItems.ENERGY_OUTPUT_COMPONENT,
                })
                .setOutput(DynaTechItems.WIND_MILL_1)
                .register(registry);

        // Wind Mill Level 1 Repair
        Recipe.init()
                .setKey(new NamespacedKey(DynaTech.getInstance(), "wind_mill_1_repair"))
                .setRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
                .setInput(new ItemStack[] {
                        null, IRON_INGOT, null,
                        IRON_INGOT, DynaTechItems.DEGRADED_WIND_MILL, IRON_INGOT,
                        IRON_BLOCK, IRON_INGOT, IRON_BLOCK
                })
                .setOutput(DynaTechItems.WIND_MILL_1)
                .register(registry);

        // Wind Mill Level 2
        Recipe.init()
                .setKey(new NamespacedKey(DynaTech.getInstance(), "wind_mill_2"))
                .setRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
                .setInput(new ItemStack[] {
                        null, DynaTechItems.STAINLESS_STEEL_ROTOR_1, null,
                        DynaTechItems.STAINLESS_STEEL_ROTOR_1, DynaTechItems.STONE_MACHINE_CORE,
                        DynaTechItems.STAINLESS_STEEL_ROTOR_1,
                        DynaTechItems.WIND_MILL_1, DynaTechItems.STAINLESS_STEEL_ROTOR_1,
                        DynaTechItems.WIND_MILL_1,
                })
                .setOutput(DynaTechItems.WIND_MILL_2)
                .register(registry);

        // Wind Mill Level 2 Repair
        Recipe.init()
                .setKey(new NamespacedKey(DynaTech.getInstance(), "wind_mill_2_repair"))
                .setRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
                .setInput(new ItemStack[] {
                        null, IRON_INGOT, null,
                        IRON_INGOT, DynaTechItems.DEGRADED_WIND_MILL_2, IRON_INGOT,
                        IRON_BLOCK, IRON_INGOT, IRON_BLOCK
                })
                .setOutput(DynaTechItems.WIND_MILL_2)
                .register(registry);

        // Egg Mill Level 1
        Recipe.init()
                .setKey(new NamespacedKey(DynaTech.getInstance(), "egg_mill_1"))
                .setRecipeType(RecipeType.MAGIC_WORKBENCH)
                .setInput(new ItemStack[] {
                        SlimefunItems.MAGIC_LUMP_3, END_STONE, SlimefunItems.MAGIC_LUMP_3,
                        CHORUS_FRUIT, DynaTechItems.WOOD_MACHINE_CORE, CHORUS_FRUIT,
                        DynaTechItems.ENERGY_OUTPUT_COMPONENT, END_STONE, DynaTechItems.ENERGY_STORAGE_COMPONENT,
                })
                .setOutput(DynaTechItems.EGG_MILL_1)
                .register(registry);

        // Egg Mill Level 1 Repair
        Recipe.init()
                .setKey(new NamespacedKey(DynaTech.getInstance(), "egg_mill_1_repair"))
                .setRecipeType(RecipeType.MAGIC_WORKBENCH)
                .setInput(new ItemStack[] {
                        SlimefunItems.MAGIC_LUMP_1, END_STONE, SlimefunItems.MAGIC_LUMP_1,
                        CHORUS_FRUIT, DynaTechItems.DEGRADED_EGG_MILL, CHORUS_FRUIT,
                        SlimefunItems.MAGIC_LUMP_1, END_STONE, SlimefunItems.MAGIC_LUMP_1,
                })
                .setOutput(DynaTechItems.EGG_MILL_1)
                .register(registry);

        // Egg Mill Level 2
        Recipe.init()
                .setKey(new NamespacedKey(DynaTech.getInstance(), "egg_mill_2"))
                .setRecipeType(RecipeType.MAGIC_WORKBENCH)
                .setInput(new ItemStack[] {
                        SlimefunItems.MAGIC_LUMP_3, END_STONE, SlimefunItems.MAGIC_LUMP_3,
                        CHORUS_FRUIT, DynaTechItems.WOOD_MACHINE_CORE, CHORUS_FRUIT,
                        DynaTechItems.EGG_MILL_1, END_STONE, DynaTechItems.EGG_MILL_1,
                })
                .setOutput(DynaTechItems.EGG_MILL_2)
                .register(registry);

        // Egg Mill Level 2 Repair
        Recipe.init()
                .setKey(new NamespacedKey(DynaTech.getInstance(), "egg_mill_2_repair"))
                .setRecipeType(RecipeType.MAGIC_WORKBENCH)
                .setInput(new ItemStack[] {
                        SlimefunItems.MAGIC_LUMP_1, END_STONE, SlimefunItems.MAGIC_LUMP_1,
                        CHORUS_FRUIT, DynaTechItems.DEGRADED_EGG_MILL_2, CHORUS_FRUIT,
                        SlimefunItems.MAGIC_LUMP_1, END_STONE, SlimefunItems.MAGIC_LUMP_1,
                })
                .setOutput(DynaTechItems.EGG_MILL_2)
                .register(registry);

        // END Energy Generators

        // START Materials

        // Stainless Steel Ingot
        Recipe.init()
                .setKey(new NamespacedKey(DynaTech.getInstance(), "stainless_steel_ingot"))
                .setRecipeType(RecipeType.SMELTERY)
                .setInput(new ItemStack[] {
                        SlimefunItems.STEEL_INGOT, SlimefunItems.IRON_DUST, SlimefunItems.ZINC_DUST,
                        SlimefunItems.CARBON,
                })
                .setOutput(DynaTechItems.STAINLESS_STEEL_INGOT)
                .register(registry);

        // Stainless Steel Rotor
        Recipe.init()
                .setKey(new NamespacedKey(DynaTech.getInstance(), "stainless_steel_rotor"))
                .setRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
                .setInput(new ItemStack[] {
                        null, DynaTechItems.STAINLESS_STEEL_INGOT, null,
                        DynaTechItems.STAINLESS_STEEL_INGOT, IRON_BLOCK, DynaTechItems.STAINLESS_STEEL_INGOT,
                        null, DynaTechItems.STAINLESS_STEEL_INGOT, null,
                })
                .setOutput(DynaTechItems.STAINLESS_STEEL_ROTOR_1)
                .register(registry);

        // END Materials
        // START Tools
        Recipe.init()
                .setKey(new NamespacedKey(DynaTech.getInstance(), "inventory_filter"))
                .setRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
                .setInput(new ItemStack[] {
                        STRING, IRON_BARS, STRING,
                        IRON_BARS, DynaTechItems.IRON_MACHINE_CORE, IRON_BARS,
                        STRING, IRON_BARS, STRING,

                }).setOutput(DynaTechItems.INV_FILTER)
                .register(registry);

        Recipe.init()
                .setKey(new NamespacedKey(DynaTech.getInstance(), "recipe_book"))
                .setRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
                .setInput(new ItemStack[] {
                        null, DynaTechItems.STAINLESS_STEEL_INGOT, null,
                        DynaTechItems.STAINLESS_STEEL_INGOT, BOOK, DynaTechItems.STAINLESS_STEEL_INGOT,
                        null, DynaTechItems.STAINLESS_STEEL_INGOT, null,
                })
                .setOutput(DynaTechItems.RECIPE_BOOK)
                .register(registry);
        Recipe.init()
                .setKey(new NamespacedKey(DynaTech.getInstance(), "auto_output_upgrade"))
                .setRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
                .setInput(new ItemStack[] {
                        DynaTechItems.STAINLESS_STEEL_INGOT, SlimefunItems.CARGO_MOTOR,
                        DynaTechItems.STAINLESS_STEEL_INGOT,
                        GLASS, GLASS, GLASS,
                        DynaTechItems.STAINLESS_STEEL_INGOT, SlimefunItems.CARGO_MOTOR,
                        DynaTechItems.STAINLESS_STEEL_INGOT,
                })
                .setOutput(DynaTechItems.AUTO_OUTPUT_UPGRADE)
                .register(registry);

        Recipe.init()
                .setKey(new NamespacedKey(DynaTech.getInstance(), "auto_input_upgrade"))
                .setRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
                .setInput(new ItemStack[] {
                        DynaTechItems.STAINLESS_STEEL_INGOT, SlimefunItems.CARGO_MOTOR,
                        DynaTechItems.STAINLESS_STEEL_INGOT,
                        new ItemStack(Material.HOPPER), new ItemStack(Material.HOPPER), new ItemStack(Material.HOPPER),
                        DynaTechItems.STAINLESS_STEEL_INGOT, SlimefunItems.CARGO_MOTOR,
                        DynaTechItems.STAINLESS_STEEL_INGOT,
                })
                .setOutput(DynaTechItems.AUTO_INPUT_UPGRADE)
                .register(registry);
        // END Tools

        // START Machines
        // END Machines

        // START Tree Growth Chamber Recipes
        // OAK, BIRCH, SPRUCE, DARK_OAK, MANGROVE, CHERRY, JUNGLE, ACAICA, AZALEA
        // 1 SAPLING (10 secs) (128/s; 64 / default slimefun tick) -> 2 SAPLING, 6 LOG,
        // 3 LEAF
        TimedRecipe.init()
                .setTimeInTicks(20)
                .setKey(new NamespacedKey(DynaTech.getInstance(), "oak_tree"))
                .setRecipeType(DynaTechItems.DT_TREE_GROWTH_CHAMBER)
                .setInput(new ItemStack(Material.OAK_SAPLING))
                .setOutput(
                        new ItemStack[] {
                                new ItemStack(Material.OAK_SAPLING, 2),
                                new ItemStack(Material.OAK_LOG, 6),
                                new ItemStack(Material.OAK_LEAVES, 3)
                        })
                .register(registry);

        // END Tree Growth Chamber Recipes
    }

    // END Recipes
}
