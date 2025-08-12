package com.ascript.TakeEveryCard.patches;

import com.ascript.TakeEveryCard.util.RewardHelper;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch2;
import com.evacipated.cardcrawl.modthespire.lib.SpirePrefixPatch;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.relics.PrayerWheel;
import com.megacrit.cardcrawl.screens.CombatRewardScreen;

@SpirePatch2(clz = CombatRewardScreen.class, method = "setupItemReward")
public class CombatRewardScreenPatch{
    @SpirePrefixPatch
    public static void Prefix() {
        if (AbstractDungeon.getCurrRoom() instanceof com.megacrit.cardcrawl.rooms.MonsterRoom &&
                AbstractDungeon.player.hasRelic(PrayerWheel.ID) &&
                !(AbstractDungeon.getCurrRoom() instanceof com.megacrit.cardcrawl.rooms.MonsterRoomElite) &&
                !(AbstractDungeon.getCurrRoom() instanceof com.megacrit.cardcrawl.rooms.MonsterRoomBoss)) {
            // Prepare for 2 rewards instead of 1.
            RewardHelper.nextYOffset.add(1f/3f);
            RewardHelper.nextYOffset.add(2f/3f);
        }
    }
}
