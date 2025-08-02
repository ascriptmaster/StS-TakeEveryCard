package com.ascript.TakeEveryCard;

import basemod.BaseMod;
import basemod.interfaces.*;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;

@SuppressWarnings({"unused", "WeakerAccess"})
@SpireInitializer
public class TakeEveryCard implements PostInitializeSubscriber {

    public static final String modID = "takeeverycard"; //TODO: Change this.

    public static String makeID(String idText) {
        return modID + ":" + idText;
    }

    public TakeEveryCard() {
        BaseMod.subscribe(this);
    }

    public static String makePath(String resourcePath) {
        return modID + "Resources/" + resourcePath;
    }

    public static String makeImagePath(String resourcePath) {
        return modID + "Resources/images/" + resourcePath;
    }

    public static void initialize() {
        TakeEveryCard thismod = new TakeEveryCard();
    }

    @Override
    public void receivePostInitialize() {

    }
}
