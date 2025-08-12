package com.ascript.TakeEveryCard.util;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.vfx.cardManip.ShowCardAndObtainEffect;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RewardHelper {
    public static Queue<Float> nextYOffset = new LinkedList<>();

    public static void obtainCards(List<AbstractCard> cards) {
        float xInterval = Settings.WIDTH / (1.0f + cards.size());
        int xOffset = 1;
        float yOffset = 0.5f;
        if (RewardHelper.nextYOffset.size() > 0) {
            yOffset = RewardHelper.nextYOffset.remove();
        }
        for (AbstractCard card : cards) {
            AbstractDungeon.topLevelEffectsQueue.add(new ShowCardAndObtainEffect(card, xOffset * xInterval, yOffset * Settings.HEIGHT));
            xOffset++;
        }
    }
}
