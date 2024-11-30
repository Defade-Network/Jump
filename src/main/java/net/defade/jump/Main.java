package net.defade.jump;

import net.defade.jump.data.PlayerStatManager;
import net.defade.jump.gui.DifficultyGUI;
import net.defade.jump.jumps.JumpTracker;
import net.defade.jump.map.JumpInstance;
import net.defade.jump.utils.Items;
import net.defade.jump.utils.block.PressurePlateUtils;
import net.defade.jump.utils.block.TrapdoorHandler;
import net.defade.minestom.servers.minigame.MiniGameInstance;
import net.kyori.adventure.sound.Sound;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.minestom.server.MinecraftServer;
import net.minestom.server.entity.Player;
import net.minestom.server.event.item.ItemDropEvent;
import net.minestom.server.event.player.AsyncPlayerConfigurationEvent;
import net.minestom.server.event.player.PlayerSpawnEvent;
import net.minestom.server.event.player.PlayerUseItemEvent;
import net.minestom.server.sound.SoundEvent;
import java.util.Set;
import java.util.UUID;

public class Main {
    private static final MiniMessage MM = MiniMessage.miniMessage();

    public static void main(String[] args) {
        MinecraftServer minecraftServer = MinecraftServer.init();

        PressurePlateUtils.registerPressurePlateEvent();
        TrapdoorHandler.registerEvents();
        PlayerStatManager.registerEvents();
        JumpTracker.registerEvents();

        JumpInstance jumpInstance = new JumpInstance();

        MinecraftServer.getGlobalEventHandler().addListener(AsyncPlayerConfigurationEvent.class, event -> {
            event.setSpawningInstance(jumpInstance);
            event.getPlayer().setRespawnPoint(JumpInstance.SPAWN_POSITION);
        });

        MinecraftServer.getServerApi().registerMiniGameInstance(new MiniGameInstance() {
            @Override
            public UUID getUuid() {
                return jumpInstance.getUniqueId();
            }

            @Override
            public int getPlayerCount() {
                return MinecraftServer.getConnectionManager().getOnlinePlayerCount();
            }

            @Override
            public int getMaxPlayers() {
                return 100;
            }

            @Override
            public boolean acceptPlayers() {
                return getPlayerCount() < getMaxPlayers();
            }

            @Override
            public boolean requirePlayingPlayersToRejoin() {
                return false;
            }

            @Override
            public Set<UUID> getPlayersRequiredToRejoin() {
                return Set.of();
            }
        });

        registerItemActions();

        minecraftServer.start();
    }

    private static void registerItemActions() {
        MinecraftServer.getGlobalEventHandler()
                .addListener(PlayerSpawnEvent.class, event -> {
                    event.getPlayer().getInventory().setItemStack(0, Items.MENU_ITEM);
                    event.getPlayer().getInventory().setItemStack(7, Items.PLAYERS_SHOWN);
                    event.getPlayer().getInventory().setItemStack(8, Items.HUB);
                })
                .addListener(ItemDropEvent.class, event -> event.setCancelled(true))
                .addListener(PlayerUseItemEvent.class, event -> {
                    Player player = event.getPlayer();
                    if (player.getInventory().getItemInMainHand().isSimilar(Items.MENU_ITEM)) {
                        player.openInventory(new DifficultyGUI());
                        player.playSound(Sound.sound().type(SoundEvent.BLOCK_DISPENSER_DISPENSE).pitch(1.5F).volume(0.6F).build());
                    } else if (player.getInventory().getItemInMainHand().isSimilar(Items.HUB)) {
                        player.sendToServer("hub");
                    } else if (player.getInventory().getItemInMainHand().isSimilar(Items.PLAYERS_SHOWN)) {
                        player.getInventory().setItemStack(7, Items.PLAYERS_HIDDEN);
                        player.updateViewerRule(others -> false);

                        player.sendMessage(MM.deserialize("<gray>» <red>Les joueurs sont maintenant cachés."));
                        player.playSound(Sound.sound().type(SoundEvent.UI_BUTTON_CLICK).pitch(2).volume(0.4F).build());
                    } else if (player.getInventory().getItemInMainHand().isSimilar(Items.PLAYERS_HIDDEN)) {
                        player.getInventory().setItemStack(7, Items.PLAYERS_SHOWN);
                        player.updateViewerRule(others -> true);

                        player.sendMessage(MM.deserialize("<gray>» <green>Les joueurs sont maintenant visibles."));
                        player.playSound(Sound.sound().type(SoundEvent.UI_BUTTON_CLICK).pitch(2).volume(0.4F).build());
                    }
                });
    }
}