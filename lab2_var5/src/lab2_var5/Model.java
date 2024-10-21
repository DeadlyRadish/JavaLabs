package lab2_var5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Model{
	private final Drone standartDrone = new Drone();
    private ArrayList<Drone> droneBase = new ArrayList<>();
    private Drone simulationDrone;

    public int droneCount() {
        try {
            return droneBase.size();
        }catch (NullPointerException e){
            return 0;
        }

    }
    
    public boolean deleteDroneInfo(int index) {
    	try {
    		droneBase.remove(index);
    	} catch (IndexOutOfBoundsException e) {
    		return false;
    	}
    	return true;
    }

    public Drone getShortInfoDrone(int index){
        try {
            return droneBase.get(index);
        } catch (IndexOutOfBoundsException e){
        	throw new ChoiceException("¬озможно выбрать только один из предложенных вариантов");
        }
    }

    public boolean addDroneInfo(Drone inputDrone) {
        try {
            droneBase.add(inputDrone);
        } catch (Exception e){
            //View.println(e);
            return false;
        }
            return true;
    }
    
    public void addDroneToSimulation(int index) {
    	Drone drone = droneBase.get(index);
    	simulationDrone = drone;
    }
    
    public Drone getSimulationDrone() {
    	return simulationDrone;
    }
    
    public void saveDataToFile() {
    	try (FileOutputStream fileOut = new FileOutputStream("drones.ser");
                ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
               
               out.writeObject(droneBase);
               out.close();
               fileOut.close();
               System.out.println("ƒанные успешно сохранены");
               
           } catch (IOException e) {
               View.println(e);
           }
    }
    
    public void loadDataFromFile() {
    	 try (FileInputStream fileIn = new FileInputStream("drones.ser");
                 ObjectInputStream in = new ObjectInputStream(fileIn)) {
                
    		 ArrayList<Drone> deserializedDrones = (ArrayList<Drone>) in.readObject();
    		 in.close();
    		 fileIn.close();
    		 droneBase = deserializedDrones;
                
                
                
            } catch (IOException | ClassNotFoundException e) {
                View.println(e);
        }
    }
}