package yuuki.machinesandtech.events;

import de.tr7zw.changeme.nbtapi.NBT;
import org.bukkit.ChatColor;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

import static org.bukkit.Bukkit.getServer;
import static yuuki.machinesandtech.items.ItemHandler.bloodOrb;

public class PlayerEvents implements Listener {

    @EventHandler
    public static void onPlayerJoin(PlayerJoinEvent e)
    {
        Player player = e.getPlayer();

        player.setResourcePack("https://www.dropbox.com/scl/fo/gmwckzx3148cwgikue965/h?dl=1&rlkey=uzni0y49umazj7xstbt1xl0dl", getSaltString(), true);
        player.sendMessage(ChatColor.BLUE + "Welcome to " + getServer().getName());
    }

    @EventHandler
    public static void onRightClick(PlayerInteractEvent e){
        if(e.getAction().isRightClick()){
            if(e.getItem() != null){
                switch (NBT.get(e.getItem(), nbt -> nbt.getInteger("Customfunc"))){
                    case 25:
                        if(e.getPlayer().getHealth() > 10){
                            e.getPlayer().setHealth(e.getPlayer().getHealth() - 10);
                            e.getPlayer().getInventory().addItem(bloodOrb);
                        }
                        break;
                    case 26:
                        if(NBT.get(e.getItem(), nbt -> nbt.getInteger("Kills")) > 0)
                        {
                            e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 200, 1, true, false, false));
                            NBT.modify(e.getItem(), nbt -> { nbt.setInteger("Kills", NBT.get(e.getItem(), nbti -> nbti.getInteger("Kills")) + -1); });
                        }
                        else {
                            e.getPlayer().setHealth(e.getPlayer().getHealth() - 10);
                            e.getPlayer().sendMessage(ChatColor.RED + "You have no kills! So the sword used your own blood!");
                            e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 200, 1, true, false, false));
                        }
                        break;
                    case 27:
                        if(NBT.get(e.getItem(), nbt -> nbt.getInteger("Kills")) > 0)
                        {
                            e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 400, 2, true, false, false));
                            NBT.modify(e.getItem(), nbt -> { nbt.setInteger("Kills", NBT.get(e.getItem(), nbti -> nbti.getInteger("Kills")) + -1); });
                        }
                        else {
                            e.getPlayer().setHealth(e.getPlayer().getHealth() - 10);
                            e.getPlayer().sendMessage(ChatColor.RED + "You have no kills! So the pickaxe used your own blood!");
                            e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 400, 2, true, false, false));
                        }
                        break;
                    case 28:
                        if(NBT.get(e.getItem(), nbt -> nbt.getInteger("Kills")) > 0)
                        {
                            e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 200, 1, true, false, false));
                            NBT.modify(e.getItem(), nbt -> { nbt.setInteger("Kills", NBT.get(e.getItem(), nbti -> nbti.getInteger("Kills")) + -1); });
                        }
                        else {
                            e.getPlayer().setHealth(e.getPlayer().getHealth() - 10);
                            e.getPlayer().sendMessage(ChatColor.RED + "You have no kills! So the axe used your own blood!");
                            e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 200, 2, true, false, false));
                        }
                        break;

                }
            }
        }
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent e) {
        LivingEntity entity = e.getEntity();
        if (entity.getKiller() instanceof Player){
            if(NBT.get(entity.getKiller().getItemInHand(), nbt -> nbt.getInteger("Customfunc1")) == 1){
                for(int i = 0 ; i < entity.getKiller().getInventory().getSize() ; i++) {
                    ItemStack item = entity.getKiller().getInventory().getItem(i);
                    if(item != null)
                    {
                        if(NBT.get(item, nbt -> nbt.getInteger("Customfunc1")) == 1){
                            NBT.modify(item, nbt -> { nbt.setInteger("Kills", NBT.get(item, nbti -> nbti.getInteger("Kills")) + 1); });
                        }
                    }
                }
            }
        }
    }

    protected static String getSaltString() {
        String SALTCHARS = "abcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 40) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
}
