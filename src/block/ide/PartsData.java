package block.ide;

public class PartsData {
	public static Menu_Icon[] parts_list;
	public PartsData(){
	}
	public Menu_Icon getMenu(int ids){
		Menu_Icon val = new Menu_Icon();
		for(int i = 0 ; i < parts_list.length ; i++){
			if(parts_list[i].id == ids){
				val.id = parts_list[i].id;
				val.name = parts_list[i].name;
				val.code = parts_list[i].code;
				val.color_no = parts_list[i].color_no;
				val.end_code = parts_list[i].end_code;
				val.shape = parts_list[i].shape;
				val.value_label = parts_list[i].value_label;
				val.value_name = parts_list[i].value_name;
				val.value_num = parts_list[i].value_num;
			}
		}		
		return val;
	}
	public Menu_Icon getMenubyUID(int ids){
		Menu_Icon val = new Menu_Icon();
		for(int i = 0 ; i < DropPanel.partsum+1 ; i++){
			System.out.println("i : "+ i);
			if(DropPanel.ovs[i].id == ids){
				val = getMenu(DropPanel.ovs[i].partsid);
			}
		}
		return val;
	}
}
