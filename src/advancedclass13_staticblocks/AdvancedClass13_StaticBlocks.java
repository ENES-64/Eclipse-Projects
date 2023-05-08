package advancedclass13_staticblocks;

import advancedclass13_block.AdvancedClass13_Block;

public class AdvancedClass13_StaticBlocks {
	public static void main(String[] args) {
		//By just creating an object, its contents will be executed if they are static blocks.
		new AdvancedClass13_Block();
		System.out.println(AdvancedClass13_Block.s);
	}
}