package fiap.scj.restfull.springboot.beans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Vehicle", description = "Describe a vehicle")
public class Vehicle {

	@ApiModelProperty(value = "Vehicle identifier", dataType = "Integer")
	private Integer id;

	@ApiModelProperty(value = "Vehicle name", dataType = "String")
	private String name;

	@ApiModelProperty(value = "Vehicle model", dataType = "String")
	private String model;

	@ApiModelProperty(value = "Vehicle status", allowableValues = "running, stopped")
	private StatusVehicleEnum status;

	public Vehicle() {
		super();
	}

	public Vehicle(Integer id, String name, String model, StatusVehicleEnum status) {
		this();
		this.id = id;
		this.name = name;
		this.model = model;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public StatusVehicleEnum getStatus() {
		return status;
	}

	public void setStatus(StatusVehicleEnum status) {
		this.status = status;
	}

}
