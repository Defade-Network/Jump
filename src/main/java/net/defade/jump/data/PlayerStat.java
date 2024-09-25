package net.defade.jump.data;

import net.defade.jump.jumps.Jumps;
import net.defade.minestom.database.MongoUtils;
import net.minestom.server.entity.Player;
import org.bson.Document;

import java.util.HashMap;
import java.util.Map;

public class PlayerStat {
    private final Player player;
    private final Map<Jumps, Long> jumpsTime = new HashMap<>();

    public PlayerStat(Player player) {
        this.player = player;

        Document playerData = MongoUtils.getDocumentFromId("jump", player.getUuid().toString()).orElseGet(() -> {
            Document document = new Document("_id", player.getUuid().toString());
            MongoUtils.insertDocument("jump", document);

            return document;
        });

        for (Jumps jump : Jumps.values()) {
            if (playerData.containsKey(jump.name())) {
                jumpsTime.put(jump, playerData.getLong(jump.name()));
            }
        }
    }

    public boolean hasRealizedJump(Jumps jump) {
        return jumpsTime.containsKey(jump);
    }

    public long getJumpTime(Jumps jump) {
        return jumpsTime.get(jump);
    }

    public void updateJumpTime(Jumps jump, long time) {
        jumpsTime.put(jump, time);
        System.out.println("update jump time for " + player.getUsername() + " jump " + jump.name() + " time " + time);
        MongoUtils.updateValue("jump", player.getUuid().toString(), jump.name(), time);
    }
}
