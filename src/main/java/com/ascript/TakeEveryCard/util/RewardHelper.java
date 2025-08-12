package com.ascript.TakeEveryCard.util;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.vfx.cardManip.ShowCardAndObtainEffect;

import java.util.List;

public class RewardHelper {
    public static void obtainCards(List<AbstractCard> cards) {
        float xInterval = Settings.WIDTH / (1.0f + cards.size());
        int xOffset = 1;
        for (AbstractCard card : cards) {
            AbstractDungeon.topLevelEffectsQueue.add(new ShowCardAndObtainEffect(card, xOffset * xInterval, Settings.HEIGHT / 2.0f));
            xOffset++;
        }
    }
}
