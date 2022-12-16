package yuuki.machinesandtech.items;

import de.tr7zw.changeme.nbtapi.NBT;
import de.tr7zw.changeme.nbtapi.NBTItem;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.Nullable;
import yuuki.machinesandtech.redstoneflux.RedstoneFlux;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class ItemHandler {
    public static ItemStack vibrantCrystal;
    public static ItemStack alloySmelter;
    public static ItemStack grainsOfInfinity;
    public static ItemStack dagger;
    public static ItemStack bloodOrb;
    public static ItemStack bloodDiamond;
    public static ItemStack bloodDiamondSword;
    private static ItemStack bloodDiamondPickaxe;


    public static void init(){
        //createVibrantCrystal();
        createGrainsOfInfinity();
        createAlloySmelter();
        createDagger();
        createBloodOrb();
        createBloodDiamond();
        createBloodDiamondSword();
        createBloodDiamondPickaxe();
    }

    /*private static void createVibrantCrystal(){
        ItemStack item = new ItemStack(Material.STICK, 1);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(ChatColor.WHITE + "Vibrant Crystal");

        meta.setCustomModelData(24637);

        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        //<String> lore = new ArrayList<String>();
        //lore.add("Just a test item.");
        //meta.setLore(lore);

        item.setItemMeta(meta);

        vibrantCrystal = item;

        ShapedRecipe shapedRecipe = new ShapedRecipe(NamespacedKey.minecraft("vibrant_crystal"), item);
        shapedRecipe.shape(" " + " " + " ",
                           " " + "S" + " ",
                           " " + " " + " ");
        shapedRecipe.setIngredient('S', Material.STICK);
        Bukkit.getServer().addRecipe(shapedRecipe);
    }*/

    private static void createGrainsOfInfinity(){
        ItemStack item = new ItemStack(Material.STICK, 1);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(ChatColor.WHITE + "Grains Of Infinity");


        meta.setCustomModelData(24639);

        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);


        //<String> lore = new ArrayList<String>();
        //lore.add("Just a test item.");
        //meta.setLore(lore);

        item.setItemMeta(meta);

        grainsOfInfinity = item;

        ShapelessRecipe shapelessRecipe = new ShapelessRecipe(NamespacedKey.minecraft("grains_of_infinity"), item);
        shapelessRecipe.addIngredient(Material.GUNPOWDER, 1);
        shapelessRecipe.addIngredient(Material.ENDER_EYE, 1);
        shapelessRecipe.addIngredient(Material.BLAZE_POWDER, 1);
        shapelessRecipe.addIngredient(Material.INK_SAC, 1);
        Bukkit.getServer().addRecipe(shapelessRecipe);
    }

    private static void createAlloySmelter(){
        ItemStack item = new ItemStack(Material.END_STONE, 1);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(ChatColor.WHITE + "Alloy Smelter");

        meta.setCustomModelData(24638);

        //meta.addEnchant(Enchantment.LUCK, 1, false);
        //meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        //<String> lore = new ArrayList<String>();
        //lore.add("Just a test item.");
        //meta.setLore(lore);

        item.setItemMeta(meta);

        alloySmelter = item;

        ShapedRecipe shapedRecipe = new ShapedRecipe(NamespacedKey.minecraft("alloy_smelter"), item);
        shapedRecipe.shape("I" + "F" + "I",
                           "F" + "G" + "F",
                           "I" + "C" + "I");
        shapedRecipe.setIngredient('G', grainsOfInfinity);
        shapedRecipe.setIngredient('I', Material.IRON_INGOT);
        shapedRecipe.setIngredient('F', Material.FURNACE);
        shapedRecipe.setIngredient('C', Material.CAULDRON);
        Bukkit.getServer().addRecipe(shapedRecipe);
    }

    private static void createDagger(){
        ItemStack item = new ItemStack(Material.STICK, 1);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(ChatColor.WHITE + "Dagger");

        meta.setCustomModelData(24637);

        //meta.addEnchant(Enchantment.LUCK, 1, false);
        //meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        //<String> lore = new ArrayList<String>();
        //lore.add("Just a test item.");
        //meta.setLore(lore);

        item.setItemMeta(meta);

        dagger = item;
        Random rnd = new Random();
        NBT.modify(item, nbt -> { nbt.setInteger("Customfunc", 25); nbt.setDouble("rnd", rnd.nextDouble()); });

        ShapedRecipe shapedRecipe = new ShapedRecipe(NamespacedKey.minecraft("dagger"), item);
        shapedRecipe.shape(" " + " " + " ",
                " " + "I" + " ",
                "G" + " " + " ");
        shapedRecipe.setIngredient('I', Material.IRON_INGOT);
        shapedRecipe.setIngredient('G', Material.GOLD_INGOT);
        Bukkit.getServer().addRecipe(shapedRecipe);
    }

    private static void createBloodOrb(){
        ItemStack item = new ItemStack(Material.CLAY_BALL, 1);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(ChatColor.WHITE + "Blood Orb");

        meta.setCustomModelData(24641);

        //meta.addEnchant(Enchantment.LUCK, 1, false);
        //meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        //<String> lore = new ArrayList<String>();
        //lore.add("Just a test item.");
        //meta.setLore(lore);

        item.setItemMeta(meta);

        bloodOrb = item;
    }
    static void createBloodDiamond(){
        ItemStack item = new ItemStack(Material.DIAMOND, 1);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(ChatColor.WHITE + "Blood Diamond");

        meta.setCustomModelData(24643);

        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        //<String> lore = new ArrayList<String>();
        //lore.add("Just a test item.");
        //meta.setLore(lore);

        item.setItemMeta(meta);

        bloodDiamond = item;

        ShapedRecipe shapedRecipe = new ShapedRecipe(NamespacedKey.minecraft("blooddiamond"), item);
        shapedRecipe.shape("B" + "P" + "B",
                           "N" + "D" + "N",
                           "B" + "P" + "B");
        shapedRecipe.setIngredient('D', Material.DIAMOND);
        shapedRecipe.setIngredient('P', Material.BLAZE_POWDER);
        shapedRecipe.setIngredient('B', bloodOrb);
        shapedRecipe.setIngredient('N', Material.NETHERITE_INGOT);
        Bukkit.getServer().addRecipe(shapedRecipe);
    }

    static void createBloodDiamondSword(){
        ItemStack item = new ItemStack(Material.DIAMOND_SWORD, 1);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(ChatColor.WHITE + "Blood Diamond Sword");

        meta.setCustomModelData(24644);

        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addEnchant(Enchantment.DURABILITY, 3, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        AttributeModifier modifier1 = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 10.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);

        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier1);

        List<String> lore = new ArrayList<String>();
        lore.add(ChatColor.GOLD + "Ability Uses Left: 0");
        meta.setLore(lore);

        item.setItemMeta(meta);
        item.setDurability((short)-1000);
        NBT.modify(item, nbt -> { nbt.setInteger("Customfunc", 26); });
        NBT.modify(item, nbt -> { nbt.setInteger("Customfunc1", 1); });
        bloodDiamondSword = item;

        ShapedRecipe shapedRecipe = new ShapedRecipe(NamespacedKey.minecraft("blooddiamondsword"), item);
        shapedRecipe.shape(" " + "B" + " ",
                           " " + "B" + " ",
                           " " + "S" + " ");
        shapedRecipe.setIngredient('S', Material.STICK);
        shapedRecipe.setIngredient('B', bloodDiamond);
        Bukkit.getServer().addRecipe(shapedRecipe);
    }
    static void createBloodDiamondPickaxe(){
        ItemStack item = new ItemStack(Material.DIAMOND_PICKAXE, 1);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(ChatColor.WHITE + "Blood Diamond Pickaxe");

        meta.setCustomModelData(24645);

        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addEnchant(Enchantment.DURABILITY, 3, false);
        meta.addEnchant(Enchantment.DIG_SPEED, 5, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        List<String> lore = new ArrayList<String>();
        lore.add(ChatColor.GOLD + "Ability Uses Left: 0");
        meta.setLore(lore);

        item.setItemMeta(meta);

        NBT.modify(item, nbt -> { nbt.setInteger("Customfunc", 27); });
        NBT.modify(item, nbt -> { nbt.setInteger("Customfunc1", 1); });

        bloodDiamondPickaxe = item;

        ShapedRecipe shapedRecipe = new ShapedRecipe(NamespacedKey.minecraft("blooddiamondpickaxe"), item);
        shapedRecipe.shape("B" + "B" + "B",
                           " " + "S" + " ",
                           " " + "S" + " ");
        shapedRecipe.setIngredient('S', Material.STICK);
        shapedRecipe.setIngredient('B', bloodDiamond);
        Bukkit.getServer().addRecipe(shapedRecipe);
    }
}

