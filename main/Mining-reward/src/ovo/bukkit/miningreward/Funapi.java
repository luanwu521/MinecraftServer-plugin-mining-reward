package ovo.bukkit.miningreward;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.block.Block;

public class Funapi {
	
	public static Boolean is_event_happen(int count) {
		//传入一个count 用于构造一个事件发生的概率
		//发生概率 = count / 100
		//事件发生则返回true 不发生则返回false
		
		//先取出一个100以内的随机数
		int data = (int) System.currentTimeMillis();//用当前时间作为随机数种子
		Random r = new Random(data);
		int x = r.nextInt(100);
		
		if(x <= count && x >= 1) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public static double which_mode_money(Block block) {
		Material block_type = block.getType();
		if(block_type == Material.STONE) {//挖掉石头
			if(is_event_happen(10)) {
				return 0.1;
			}
		}
		if(block_type == Material.COAL_ORE) {//挖掉煤矿
			if(is_event_happen(10)) {
				return 0.5;
			}
		}
		if(block_type == Material.IRON_ORE) {//挖掉铁矿
			if(is_event_happen(30)) {
				return 1;
			}
		}
		if(block_type == Material.GOLD_ORE) {//挖掉金矿
			if(is_event_happen(50)) {
				return 2;
			}
		}
		if(block_type == Material.DIAMOND_ORE) {//挖掉钻石矿
			if(is_event_happen(90)) {
				return 3;
			}
		}
		if(block_type == Material.EMERALD_ORE) {//挖掉绿宝石矿
			if(is_event_happen(80)) {
				return 2.5;
			}
		}
		if(block_type == Material.LAPIS_ORE) {//挖掉青金石矿
			if(is_event_happen(50)) {
				return 2;
			}
		}
		if(block_type == Material.REDSTONE_ORE) {//挖掉红石矿
			if(is_event_happen(35)) {
				return 1;
			}
		}
		return 0;
	}
	
	
}
