package com.zeus.io;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

/**
 * @author xuxingbo
 * @Date 2018/1/15
 * Preferences Demo, store user preferences
 */
public class PreferencesDemo {

	public static void main(String[] args) throws BackingStoreException {
		Preferences prefs = Preferences.userNodeForPackage(PreferencesDemo.class);
		prefs.put("Location", "Oz");
		prefs.put("Footwear", "Ruby Slippers");
		prefs.putInt("Companions", 4);
		prefs.putBoolean("Are there witches?", true);
		int usageCount = prefs.getInt("UsageCount", 0);
		usageCount++;
		prefs.putInt("UsageCount", usageCount);
		for(String key : prefs.keys()){
			System.out.println(key + ": " + prefs.get(key, null));
		}
		System.out.println("how many companions does Dorothy have? " + prefs.getInt("Companions", 0));

	}
}
