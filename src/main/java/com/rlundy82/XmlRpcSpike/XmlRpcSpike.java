package com.rlundy82.XmlRpcSpike;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class XmlRpcSpike extends JavaPlugin {
	public XmlRpcWrapper xwrapper;
    private final HashMap<Player, Boolean> debugees = new HashMap<Player, Boolean>();
    
    public void onDisable() {
        System.out.println("Goodbye world!");
    }

    public void onEnable() {
    	PluginDescriptionFile pdfFile = this.getDescription();
    	
    	try {
			this.xwrapper = new XmlRpcWrapper(new URL("http://127.0.0.1:7080"));
			Spike spike = new Spike(this.xwrapper);
			spike.SpikeItOut();
			
		} catch (MalformedURLException e) {
			System.out.println( pdfFile.getName() + " could not initialize because of a malformed URL." );
			e.printStackTrace();
		}
        System.out.println( pdfFile.getName() + " version " + pdfFile.getVersion() + " is enabled!" );
    }

    public boolean isDebugging(final Player player) {
        if (debugees.containsKey(player)) {
            return debugees.get(player);
        } else {
            return false;
        }
    }

    public void setDebugging(final Player player, final boolean value) {
        debugees.put(player, value);
    }
}
