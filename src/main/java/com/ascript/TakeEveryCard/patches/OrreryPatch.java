package com.ascript.TakeEveryCard.patches;

import com.ascript.TakeEveryCard.util.RewardHelper;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch2;
import com.evacipated.cardcrawl.modthespire.lib.SpirePrefixPatch;
import com.megacrit.cardcrawl.relics.Orrery;

@SpirePatch2(clz = Orrery.class, method = "onEquip")
public class OrreryPatch {
    @SpirePrefixPatch
    public static void Prefix() {
        // Prepare for 5 rewards.
        for (int i = 1; i <= 5; i++) {
            RewardHelper.nextYOffset.push(i/6.0f);
        }
    }
}
