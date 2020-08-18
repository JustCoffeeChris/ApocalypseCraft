package mobs;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.inventory.ItemStack;

public class levelZombie implements Listener {

	private void fillRestOfArray(ItemStack[] arr) {

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == null) {
				arr[i] = new ItemStack(Material.AIR);
			}
		}

	}

	private ItemStack[] createItemStackDependOnLevel(int playerLevel) {

		/*
		 * 0 = Boots 1 = Leggins 2 = Chestplate 3 = Head 4 = Item in Hand
		 */

		ItemStack[] stack = new ItemStack[5];

		if (playerLevel == 0) {
			stack[0] = new ItemStack(Material.AIR);
			stack[1] = new ItemStack(Material.AIR);
			stack[2] = new ItemStack(Material.AIR);
			stack[3] = new ItemStack(Material.AIR);
			stack[4] = new ItemStack(Material.AIR);
		} else if (playerLevel >= 2) {

			stack[4] = new ItemStack(Material.WOODEN_SWORD);

			if (playerLevel >= 5) {

				stack[0] = new ItemStack(Material.LEATHER_BOOTS);

				if (playerLevel >= 10) {

					stack[3] = new ItemStack(Material.LEATHER_HELMET);

					if (playerLevel >= 15) {
						stack[1] = new ItemStack(Material.LEATHER_LEGGINGS);
						stack[4] = new ItemStack(Material.STONE_SWORD);

						if (playerLevel >= 20) {
							stack[2] = new ItemStack(Material.LEATHER_CHESTPLATE);
							stack[0] = new ItemStack(Material.GOLDEN_BOOTS);

							if (playerLevel >= 25) {
								stack[3] = new ItemStack(Material.GOLDEN_HELMET);
								stack[4] = new ItemStack(Material.GOLDEN_SWORD);

								if (playerLevel >= 30) {
									stack[2] = new ItemStack(Material.GOLDEN_CHESTPLATE);
									stack[1] = new ItemStack(Material.GOLDEN_LEGGINGS);

									if (playerLevel >= 32) {
										stack[0] = new ItemStack(Material.CHAINMAIL_BOOTS);
										stack[3] = new ItemStack(Material.CHAINMAIL_HELMET);

										if (playerLevel >= 34) {
											stack[4] = new ItemStack(Material.IRON_SWORD);

											if (playerLevel >= 36) {
												stack[1] = new ItemStack(Material.CHAINMAIL_LEGGINGS);

												if (playerLevel >= 38) {
													stack[2] = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
												}
											}
										}
									}
								}

							}

						}
					}
				}

			}
		}

		fillRestOfArray(stack);

		return stack;
	}

	@EventHandler
	public void onJoinEvent(CreatureSpawnEvent event) {
		if (

		(event.getEntityType() == EntityType.SLIME) || (event.getEntityType() == EntityType.CREEPER)
				|| (event.getEntityType() == EntityType.SPIDER)

		) {

			event.getEntity().remove();
		}
	}

	@EventHandler
	public void createZombie(final EntityTargetEvent entityEvent) {

		if (entityEvent.getEntity() instanceof Zombie) {
			if (entityEvent.getTarget() instanceof Player) {
				Player ourUser = (Player) entityEvent.getTarget();

				((Zombie) entityEvent.getEntity()).setCustomName("Zombie Level" + ourUser.getLevel());

				ItemStack[] stack = createItemStackDependOnLevel(ourUser.getLevel());

				((Zombie) entityEvent.getEntity()).getEquipment().setBoots(stack[0]);
				((Zombie) entityEvent.getEntity()).getEquipment().setLeggings(stack[1]);
				((Zombie) entityEvent.getEntity()).getEquipment().setChestplate(stack[2]);
				((Zombie) entityEvent.getEntity()).getEquipment().setHelmet(stack[3]);
				((Zombie) entityEvent.getEntity()).getEquipment().setItemInMainHand(stack[4]);

			}

		}

	}

}
