package nz.co.fitnet.ui.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import nz.co.fitnet.characterGenerator.api.equipment.Armour;
import nz.co.fitnet.characterGenerator.api.equipment.Item;
import nz.co.fitnet.characterGenerator.api.equipment.Pack;
import nz.co.fitnet.characterGenerator.api.equipment.Weapon;
import nz.co.fitnet.characterGenerator.data.Armours;
import nz.co.fitnet.characterGenerator.data.Gear;
import nz.co.fitnet.characterGenerator.data.Packs;
import nz.co.fitnet.characterGenerator.data.Weapons;

@Path("/items")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ItemsResource {

	@GET
	@Path("/gear")
	public List<Item> getGear() {
		return Gear.itemList;
	}

	@GET
	@Path("/armour")
	public List<Armour> getArmour() {
		return Armours.armourList;
	}

	@GET
	@Path("/weapons")
	public List<Weapon> getWeapons() {
		return Weapons.weaponList;
	}

	@GET
	@Path("/packs")
	public List<Pack> getPacks() {
		return Packs.packList;
	}
}
