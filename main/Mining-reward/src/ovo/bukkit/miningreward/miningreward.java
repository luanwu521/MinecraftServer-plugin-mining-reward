package ovo.bukkit.miningreward;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import net.milkbowl.vault.economy.Economy;

public class miningreward extends JavaPlugin implements Listener{
	
	public static Economy econ = null;//���ô����� �뾭�ò���Խ�
	
	@Override
	public void onEnable() {//����ɹ�����ʱ ����ô˷���
		System.out.println("======================================");
		System.out.println("Mining-Reward�ɹ�����! QQ 1638752093");
		System.out.println("======================================");
		
		//ע�������
		Bukkit.getPluginManager().registerEvents(this,this);
		//����������������Ϸ�ڷ������¼� ��������ƻ������¼�
		
		//ע�ᾭ��ǰ��
		RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
		econ = rsp.getProvider();
	}
	
	@EventHandler
	public void PlayerBreakBlock(BlockBreakEvent e) {//������ƻ�һ������ʱ
		//BlockBreakEvent �� bukkit�ṩ��һ��API
		Player who = e.getPlayer();//��ȡ�ƻ��������Ķ���
		Block block = e.getBlock();//��ȡ�ƻ����������
		double money = Funapi.which_mode_money(block);//����Ӧ�ý�����Ǯ
		if(money != 0) {
			econ.depositPlayer(who, money);//����Ҽ�Ǯ
			who.sendMessage(ChatColor.YELLOW + "��������,�õ���" + ChatColor.GREEN + money + ChatColor.YELLOW +"��ҽ���");
			//����ҷ���һ����ʾ��Ϣ ChatColor����������������ɫ ������Ĭ��Ϊ��ɫ
		}
	}
	
}
