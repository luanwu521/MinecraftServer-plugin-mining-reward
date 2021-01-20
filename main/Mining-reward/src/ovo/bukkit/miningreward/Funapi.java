package ovo.bukkit.miningreward;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.block.Block;

public class Funapi {
	
	public static Boolean is_event_happen(int count) {
		//����һ��count ���ڹ���һ���¼������ĸ���
		//�������� = count / 100
		//�¼������򷵻�true �������򷵻�false
		
		//��ȡ��һ��100���ڵ������
		int data = (int) System.currentTimeMillis();//�õ�ǰʱ����Ϊ���������
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
		if(block_type == Material.STONE) {//�ڵ�ʯͷ
			if(is_event_happen(10)) {
				return 0.1;
			}
		}
		if(block_type == Material.COAL_ORE) {//�ڵ�ú��
			if(is_event_happen(10)) {
				return 0.5;
			}
		}
		if(block_type == Material.IRON_ORE) {//�ڵ�����
			if(is_event_happen(30)) {
				return 1;
			}
		}
		if(block_type == Material.GOLD_ORE) {//�ڵ����
			if(is_event_happen(50)) {
				return 2;
			}
		}
		if(block_type == Material.DIAMOND_ORE) {//�ڵ���ʯ��
			if(is_event_happen(90)) {
				return 3;
			}
		}
		if(block_type == Material.EMERALD_ORE) {//�ڵ��̱�ʯ��
			if(is_event_happen(80)) {
				return 2.5;
			}
		}
		if(block_type == Material.LAPIS_ORE) {//�ڵ����ʯ��
			if(is_event_happen(50)) {
				return 2;
			}
		}
		if(block_type == Material.REDSTONE_ORE) {//�ڵ���ʯ��
			if(is_event_happen(35)) {
				return 1;
			}
		}
		return 0;
	}
	
	
}
