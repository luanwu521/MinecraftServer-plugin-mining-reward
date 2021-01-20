package ovo.bukkit.miningreward;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.command.SimpleCommandMap;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.SimplePluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import net.milkbowl.vault.economy.Economy;


public class miningreward extends JavaPlugin implements Listener{
	
	
	public static Economy econ = null;//经济处理类 与经济插件对接
	
	@Override
	public void onEnable() {//插件成功运行时 会调用此方法
		System.out.println("======================================");
		System.out.println("Mining-Reward成功运行! QQ 1638752093");
		System.out.println("======================================");
		
		saveDefaultConfig(); //若不存在配置文件,则保存默认配置文件
		
		//注册监听器
		Bukkit.getPluginManager().registerEvents(this,this);
		//监听器用来监听游戏内发生的事件 比如玩家破坏方块事件
		
		//注册经济前置
		RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
		econ = rsp.getProvider();
		
		SimpleCommandMap sim = new SimpleCommandMap(getServer());
		SimplePluginManager plm = new SimplePluginManager(getServer(), sim);
		Plugin plugin = plm.getPlugin("miningreward");
		
	}
	
	@EventHandler
	public void PlayerBreakBlock(BlockBreakEvent e) {//当玩家破坏一个方块时
		
		//BlockBreakEvent 是 bukkit提供的一个API
		Player who = e.getPlayer();//获取破坏这个方块的对象
		Block block = e.getBlock();//获取破坏的这个方块
		double money = Funapi.which_mode_money(block);//计算应该奖励的钱
		if(money != 0) {
			econ.depositPlayer(who, money);//给玩家加钱
			
			String key = "is_sendmessage";//设置要读取配置中的指定键
			if(getConfig().contains(key)) {//读取配置文件 读取之前先判断键是否存在
				String result = getConfig().getString(key);//键存在再读取值
				if(result.equals("true")) {
					who.sendMessage(ChatColor.YELLOW + "你真幸运,得到了" + ChatColor.GREEN + money + ChatColor.YELLOW +"金币奖励");
					//给玩家发送一条提示信息 ChatColor可用来更改文字颜色 不更改默认为白色
				}
			}
		}
	}
	
}
