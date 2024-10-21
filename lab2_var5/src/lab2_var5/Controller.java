package lab2_var5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Locale;

public class Controller {
    Model model = new Model();
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void startProgram() throws IOException {
        View.println("Система ДРОН");
        View.viewLine();
        model.loadDataFromFile();
        openMainMenu();
    }

    private void openMainMenu() {
        while (true) {
            try {
                View.viewMainMenu();
                int userChoice = getValidIntInput("Введите свой выбор: ");
                if (userChoice == 1) {
                    openBDMenu();
                } else if (userChoice == 2) {
                    droneSimulation();
                } else if (userChoice == 3) {
                	model.saveDataToFile();
                    break;
                } else {
                    throw new ChoiceException("Возможно выбрать только один из предложенных вариантов");
                }
            }catch (ChoiceException | IOException e){
                View.println(e);
            }
        }
    }

    private void openBDMenu() throws IOException {
        int droneCount = model.droneCount();
        showDroneBD(droneCount);

        if (droneCount == 0) {
            View.println("Хотите добавить новую запись y/n:");
            String userConfirm = reader.readLine().toLowerCase(Locale.ROOT);
            if (userConfirm.equals("y")) {
                setDroneInfo();
            } else if (userConfirm.equals("n")) {
                View.println("Возврат в главное меню");
            } else {
                throw new ChoiceException("Возможно выбрать только один из предложенных вариантов");
            }
        } else {
            View.viewBDMenu();
            int userChoice = getValidIntInput("Введите свой выбор: ");
            if (userChoice == 1) {
				int userDroneChoice = getValidIntInput("Введите номер дрона (от 1 до " + droneCount + ")");
				choiceOneDrone(userDroneChoice - 1);
            } else if (userChoice == 2) {
                setDroneInfo();
            } else if (userChoice == 3) {
                View.println("Возврат в главное меню");
            } else {
                throw new ChoiceException("Возможно выбрать только один из предложенных вариантов");
            }
        }

    }
    
    private void droneSimulation() {
    	try {
    		Drone userDrone = model.getSimulationDrone();
        	double distance = getValidDoubleInput("Введите дистанцию, которую необходимо преодолеть (в м)");
        	double cruisingSpeed = 40000/60;
        	double timeOfFlight = distance/cruisingSpeed; 
        	View.println("На дроне " + userDrone.getName() + " вы сможете двигаться в течение " + timeOfFlight + " минут");
		} catch (Exception e) {
			throw new ChoiceException("Дрон для запуска не обозначен");
		}
    	
    }
    
    private void choiceOneDrone(int userDroneChoice) {
		Drone droneInfo = model.getShortInfoDrone(userDroneChoice);
    	View.println("Вы выбрали дрон по номеру " + (userDroneChoice + 1));
        View.viewDroneShortInfo(userDroneChoice + 1, droneInfo.getName(), droneInfo.getBrand());
    	View.choiceOneDrone();
    	int userChoice = getValidIntInput("Введите свой выбор: ");
        if (userChoice == 1) {
        	View.viewAllInfo(
        			droneInfo.getName(),
        			droneInfo.getBrand(),
        			droneInfo.getDimensions().getHeight(),
        			droneInfo.getDimensions().getWidth(),
        			droneInfo.getDimensions().getDeep(),
        			droneInfo.getTakeoffWeight(),
        			droneInfo.getMaxAscentSpeed(),
        			droneInfo.getMaxDescentSpeed(),
        			droneInfo.getMaxTakeoffAltitude(),
        			droneInfo.getMaxFlightTime(),
        			droneInfo.getMaxHoveringTime(),
        			droneInfo.getMaxFlightDistance(),
        			droneInfo.getMaxWindSpeedResistance(),
        			droneInfo.getMaxPitchAngle(),
        			droneInfo.getGlobalNavigationSatelliteSystem(),
        			droneInfo.getOperatingTemperature(),
        			droneInfo.getBatteryCapacity(),
        			droneInfo.getImageSensor());
        } else if (userChoice == 2) {
        	model.addDroneToSimulation(userDroneChoice);
        } else if (userChoice == 3) {
        	boolean success = model.deleteDroneInfo(userDroneChoice);
            if (success){
                View.println("Информация успешно удалена");
            } else {
                View.println("Произошла непредвиденная ошибка, попробуйте заново");
            }
        } else if (userChoice == 4) {
            View.println("Возврат в главное меню");
        } else {
            throw new ChoiceException("Возможно выбрать только один из предложенных вариантов");
        }
    }

    private void showDroneBD(int droneCount){
        if (droneCount == 0) {
            View.println("В базе данных нет записей");
        } else {
            for (int i = 0; i < droneCount; i++) {
                Drone drone = model.getShortInfoDrone(i);
                View.viewDroneShortInfo(i+1, drone.getName(), drone.getBrand());
            }
        }
    }

    private void setDroneInfo() throws IOException {
        Drone inputDrone = new Drone();

        View.println("Введите название");
        String inputName = reader.readLine();
        inputDrone.setName(inputName);

        View.println("Введите производителя");
        String inputBrand = reader.readLine();
        inputDrone.setBrand(inputBrand);

        double inputHeight = getValidDoubleInput("Введите высоту (в м)");
        double inputWidth = getValidDoubleInput("Введите ширину (в м)");
        double inputDeep = getValidDoubleInput("Введите длину (в м)");
        inputDrone.setDimensions(inputHeight, inputWidth, inputDeep);

        double inputTakeoffWeight = getValidDoubleInput("Введите вес при взлете (в кг): ");
        inputDrone.setTakeoffWeight(inputTakeoffWeight);

        double inputMaxAscentSpeed = getValidDoubleInput("Введите максимальную скорость набора высоты (в м/с): ");
        inputDrone.setMaxAscentSpeed(inputMaxAscentSpeed);

        double inputMaxDescentSpeed = getValidDoubleInput("Введите максимальную скорость снижения (в м/с): ");
        inputDrone.setMaxDescentSpeed(inputMaxDescentSpeed);

        double inputMaxTakeoffAltitude = getValidDoubleInput("Введите максимальную высоту взлета (в метрах): ");
        inputDrone.setMaxTakeoffAltitude(inputMaxTakeoffAltitude);

        double inputMaxFlightTime = getValidDoubleInput("Введите максимальное время полета (в минутах): ");
        inputDrone.setMaxFlightTime(inputMaxFlightTime);

        double inputMaxHoveringTime = getValidDoubleInput("Введите максимальное время зависания (в минутах): ");
        inputDrone.setMaxHoveringTime(inputMaxHoveringTime);

        double inputMaxFlightDistance = getValidDoubleInput("Введите максимальную дистанцию полета (в километрах): ");
        inputDrone.setMaxFlightDistance(inputMaxFlightDistance);

        double inputMaxWindSpeedResistance = getValidDoubleInput("Введите максимальную скорость ветра для полета (в м/с): ");
        inputDrone.setMaxWindSpeedResistance(inputMaxWindSpeedResistance);

        double inputMaxPitchAngle = getValidDoubleInput("Введите максимальный угол наклона (в градусах): ");
        inputDrone.setMaxPitchAngle(inputMaxPitchAngle);

        View.println("Вводите названия навигационных систем, при завершении введите 0");
        ArrayList<String> arrayNavSys;
        while (true) {
            arrayNavSys = new ArrayList<>();
            String inputGlobalNavigationSatelliteSystem = reader.readLine();
            if (inputGlobalNavigationSatelliteSystem.equals("0")) {
                break;
            } else {
                arrayNavSys.add(inputGlobalNavigationSatelliteSystem);
            }
        }
        inputDrone.setGlobalNavigationSatelliteSystem(arrayNavSys);

        while (true) {
            try {
                double inputMinTemp = getValidDoubleInput("Введите нижнюю границу допустимого диапазона температур (цельсия)", true);
                double inputMaxTemp = getValidDoubleInput("Введите верхнюю границу допустимого диапазона температур (цельсия)", true);
                TemperatureRange tempRange = new TemperatureRange(inputMinTemp, inputMaxTemp);
                inputDrone.setOperatingTemperature(tempRange);
            } catch (IllegalArgumentException e){
                View.println(e);
            }break;
        }


        double inputBatteryCapacity = getValidDoubleInput("Введите емкость батареи");
        inputDrone.setBatteryCapacity(inputBatteryCapacity);

        View.println("Вводите названия установленных видеомодулей, при завершении введите 0");
        ArrayList<String> arrayVideoSys;
        while (true) {
            arrayVideoSys = new ArrayList<>();
            String imageSensor = reader.readLine();
            if (imageSensor.equals("0")) {
                break;
            } else {
                arrayVideoSys.add(imageSensor);
            }
        }
        inputDrone.setImageSensor(arrayVideoSys);

        boolean success = model.addDroneInfo(inputDrone);
        if (success){
            View.println("Информация успешно добавлена");
        } else {
            View.println("Произошла непредвиденная ошибка, попробуйте заново");
        }
    }

    private int getValidIntInput(String prompt, boolean belowZero) {
        int number;
        while (true) {
            View.println(prompt);
            try {
                number = Integer.parseInt(reader.readLine());
                if (number < 0 && !belowZero) {
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException | IOException e) {
                View.println("Ошибка: введите число, подходящее по требованиям.");
            }
        }
        return number;
    }

    private int getValidIntInput(String prompt) {
        return getValidIntInput(prompt, false);
    }

    private double getValidDoubleInput(String prompt, boolean belowZero) {
        double number;
        while (true) {
            View.println(prompt);
            try {
                number = Double.parseDouble(reader.readLine());
                if (number < 0 && !belowZero) {
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException | IOException e) {
                View.println("Ошибка: введите число, подходящее по требованиям.");
            }
        }
        return number;
    }

    private double getValidDoubleInput(String prompt) {
        return getValidIntInput(prompt, false);
    }
}