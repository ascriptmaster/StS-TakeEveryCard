package com.ascript.TakeEveryCard.patches;

import com.ascript.TakeEveryCard.util.RewardHelper;
import com.evacipated.cardcrawl.modthespire.lib.*;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.neow.NeowReward;
import com.megacrit.cardcrawl.screens.CardRewardScreen;
import javassist.CtBehavior;

import java.util.List;

@SpirePatch2(clz = NeowReward.class, method = "activate")
public class NeowRewardPatch {
    @SpireInsertPatch(locator = Locator.class)
    public static SpireReturn<Void> Insert(NeowReward __instance) {
        List<AbstractCard> cards;
        switch(__instance.type) {
            case RANDOM_COLORLESS:
            case RANDOM_COLORLESS_2:
                cards = __instance.getColorlessRewardCards(__instance.type == NeowReward.NeowRewardType.RANDOM_COLORLESS_2);
                break;
            case THREE_CARDS:
            case THREE_RARE_CARDS:
                cards = __instance.getRewardCards(__instance.type == NeowReward.NeowRewardType.THREE_RARE_CARDS);
                break;
            default:
                return SpireReturn.Continue();
        }

        if (cards != null && cards.size() > 0) {
            RewardHelper.obtainCards(cards);
        }

        CardCrawlGame.metricData.addNeowData(__instance.type.name(), __instance.drawback.name());
        return SpireReturn.Return();
    }

    private static class Locator extends SpireInsertLocator {
        public int[] Locate(CtBehavior ctBehavior) throws Exception {
            Matcher finalMatcher = new Matcher.MethodCallMatcher(CardRewardScreen.class, "open");
            return LineFinder.findAllInOrder(ctBehavior, finalMatcher);
        }
    }
}
