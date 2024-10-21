package lab2_var5;

import java.io.Serializable;
import java.util.ArrayList;

public class Drone implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String name;
    private String brand;
    private Dimension3d dimensions;
    private double takeoffWeight;
    private double maxAscentSpeed;
    private double maxDescentSpeed;
    private double maxTakeoffAltitude;
    private double maxFlightTime;
    private double maxHoveringTime;
    private double maxFlightDistance;
    private double maxWindSpeedResistance;
    private double maxPitchAngle;
    private ArrayList<String> globalNavigationSatelliteSystem;
    private TemperatureRange operatingTemperature;
    private double batteryCapacity;
    private ArrayList<String> imageSensor;

    public Drone(
            ) {
        this(null, null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, null, 0.0, null);
    }

    public Drone(
            String name,
            String brand,
            double height,
            double width,
            double deep,
            double takeoffWeight,
            double maxAscentSpeed,
            double maxDescentSpeed,
            double maxTakeoffAltitude,
            double maxFlightTime,
            double maxHoveringTime,
            double maxFlightDistance,
            double maxWindSpeedResistance,
            double maxPitchAngle,
            ArrayList<String> globalNavigationSatelliteSystem,
            TemperatureRange operatingTemperature,
            double batteryCapacity,
            ArrayList<String> imageSensor
    ) {
        setName(name);
        setBrand(brand);
        setDimensions(new Dimension3d(height, width, deep));
        setTakeoffWeight(takeoffWeight);
        setMaxAscentSpeed(maxAscentSpeed);
        setMaxDescentSpeed(maxDescentSpeed);
        setMaxTakeoffAltitude(maxTakeoffAltitude);
        setMaxFlightTime(maxFlightTime);
        setMaxHoveringTime(maxHoveringTime);
        setMaxFlightDistance(maxFlightDistance);
        setMaxWindSpeedResistance(maxWindSpeedResistance);
        setMaxPitchAngle(maxPitchAngle);
        setGlobalNavigationSatelliteSystem(globalNavigationSatelliteSystem);
        setOperatingTemperature(operatingTemperature);
        setBatteryCapacity(batteryCapacity);
        setImageSensor(imageSensor);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Dimension3d getDimensions() {
        return dimensions;
    }

    public void setDimensions(Dimension3d dimensions) {
        this.dimensions = dimensions;
    }

    public void setDimensions(double height, double width, double deep) {
        this.dimensions = new Dimension3d(height, width, deep);
    }

    public double getTakeoffWeight() {
        return takeoffWeight;
    }

    public void setTakeoffWeight(double takeoffWeight) {
        this.takeoffWeight = takeoffWeight;
    }

    public double getMaxAscentSpeed() {
        return maxAscentSpeed;
    }

    public void setMaxAscentSpeed(double maxAscentSpeed) {
        this.maxAscentSpeed = maxAscentSpeed;
    }

    public double getMaxDescentSpeed() {
        return maxDescentSpeed;
    }

    public void setMaxDescentSpeed(double maxDescentSpeed) {
        this.maxDescentSpeed = maxDescentSpeed;
    }

    public double getMaxTakeoffAltitude() {
        return maxTakeoffAltitude;
    }

    public void setMaxTakeoffAltitude(double maxTakeoffAltitude) {
        this.maxTakeoffAltitude = maxTakeoffAltitude;
    }

    public double getMaxFlightTime() {
        return maxFlightTime;
    }

    public void setMaxFlightTime(double maxFlightTime) {
        this.maxFlightTime = maxFlightTime;
    }

    public double getMaxHoveringTime() {
        return maxHoveringTime;
    }

    public void setMaxHoveringTime(double maxHoveringTime) {
        this.maxHoveringTime = maxHoveringTime;
    }

    public double getMaxFlightDistance() {
        return maxFlightDistance;
    }

    public void setMaxFlightDistance(double maxFlightDistance) {
        this.maxFlightDistance = maxFlightDistance;
    }

    public double getMaxWindSpeedResistance() {
        return maxWindSpeedResistance;
    }

    public void setMaxWindSpeedResistance(double maxWindSpeedResistance) {
        this.maxWindSpeedResistance = maxWindSpeedResistance;
    }

    public double getMaxPitchAngle() {
        return maxPitchAngle;
    }

    public void setMaxPitchAngle(double maxPitchAngle) {
        this.maxPitchAngle = maxPitchAngle;
    }

    public ArrayList<String> getGlobalNavigationSatelliteSystem() {
        return globalNavigationSatelliteSystem;
    }

    public void setGlobalNavigationSatelliteSystem(ArrayList<String> globalNavigationSatelliteSystem) {
        this.globalNavigationSatelliteSystem = globalNavigationSatelliteSystem;
    }

    public TemperatureRange getOperatingTemperature() {
        return operatingTemperature;
    }

    public void setOperatingTemperature(TemperatureRange operatingTemperature) {
        this.operatingTemperature = operatingTemperature;
    }

    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public ArrayList<String> getImageSensor() {
        return imageSensor;
    }

    public void setImageSensor(ArrayList<String> imageSensor) {
        this.imageSensor = imageSensor;
    }
}