package com.ascript.TakeEveryCard.patches;

import com.ascript.TakeEveryCard.util.RewardHelper;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch2;
import com.evacipated.cardcrawl.modthespire.lib.SpirePostfixPatch;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.relics.BustedCrown;
import com.megacrit.cardcrawl.relics.QuestionCard;
import com.megacrit.cardcrawl.rewards.RewardItem;

@SpirePatch2(clz = RewardItem.class, method = SpirePatch.CONSTRUCTOR, paramtypez = {})
@SpirePatch2(clz = RewardItem.class, method = SpirePatch.CONSTRUCTOR, paramtypez = {AbstractCard.CardColor.class})
public class RewardItemPatch {
    @SpirePostfixPatch
    public static void Postfix(RewardItem __instance) {
        if (__instance.cards.size() > 0) {
            if (AbstractDungeon.player.hasRelic(QuestionCard.ID))
                AbstractDungeon.player.getRelic(QuestionCard.ID).flash();
            if (AbstractDungeon.player.hasRelic(BustedCrown.ID))
                AbstractDungeon.player.getRelic(BustedCrown.ID).flash();
            RewardHelper.obtainCards(__instance.cards);
            __instance.cards.clear();
            __instance.isDone = true;
        }
    }
}
