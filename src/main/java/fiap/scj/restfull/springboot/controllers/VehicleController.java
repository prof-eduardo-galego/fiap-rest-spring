package fiap.scj.restfull.springboot.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fiap.scj.restfull.springboot.beans.StatusVehicleEnum;
import fiap.scj.restfull.springboot.beans.Vehicle;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/vehicle")
@Api(value = "/vehicle", consumes = "application/json")
public class VehicleController {

	private static final List<Vehicle> listVehicles = new ArrayList<>();
	static {
		listVehicles.add(new Vehicle(1, "VHCL1", "chronos", StatusVehicleEnum.STOPPED));
		listVehicles.add(new Vehicle(2, "VHCL2", "onix", StatusVehicleEnum.STOPPED));
		listVehicles.add(new Vehicle(3, "VHCL3", "siena", StatusVehicleEnum.STOPPED));
		listVehicles.add(new Vehicle(4, "VHCL4", "uno", StatusVehicleEnum.STOPPED));
		listVehicles.add(new Vehicle(5, "VHCL5", "amarok", StatusVehicleEnum.STOPPED));
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@Secured("ROLE_USER")
	@ApiOperation(value = "List all vehicles", response = Vehicle.class, responseContainer = "List")
	public List<Vehicle> searchVehicles() {
		return listVehicles;
	}

	@GetMapping("/{id}")
	@Secured("ROLE_USER")
	@ApiOperation(value = "Search vehicle by id", response = Vehicle.class)
	public Vehicle findVehicle(
			@RequestParam(value = "id")   @ApiParam(value = "Vehicle identifier", required = true) final Integer id) {
		for (Vehicle vehicle : listVehicles) {
			if (id.equals(vehicle.getId())) {
				return vehicle;
			}
		}
		return null;
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@Secured("ROLE_ADMIN")
	@ApiOperation(value = "Save new vehicle")	
	public void createVehicle(final Vehicle vehicle) {
		listVehicles.add(vehicle);
	}
}