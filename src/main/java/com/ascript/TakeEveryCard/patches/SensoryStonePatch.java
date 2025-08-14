package com.ascript.TakeEveryCard.patches;

import com.ascript.TakeEveryCard.util.RewardHelper;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch2;
import com.evacipated.cardcrawl.modthespire.lib.SpirePrefixPatch;
import com.megacrit.cardcrawl.events.beyond.SensoryStone;

@SpirePatch2(clz = SensoryStone.class, method = "reward")
public class SensoryStonePatch {
    @SpirePrefixPatch
    public static void Prefix(int num) {
        float interval = 1f + num;
        for (int i = 1; i <= num; i++) {
            RewardHelper.nextYOffset.push(i / interval);
        }
    }
}
