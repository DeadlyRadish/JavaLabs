package lab2_var5;

import java.util.ArrayList;

public class View {
    public static <T> void println(T promt) {
        System.out.println(promt.toString());
    }

    public static void viewLine(){
        for (int i = 0; i < 25; i++) {
            System.out.print('-');
        }
        System.out.println();
    }

    public static void viewMainMenu(){
        println("Перейти к базе данных--------------------1");
        println("Перейти в систему запуска----------------2");
        println("Выйти из программы-----------------------3");
    }

    public static void viewBDMenu(){
        println("Выбрать дрон по номеру-------------------1");
        println("Добавить новый дрон----------------------2");
        println("Выход из базы данных---------------------3");
    }
    
    public static void choiceOneDrone() {
    	println("Вывести полную техническую информацию----1");
    	println("Запустить симуляцию----------------------2");
    	println("Удалить запись---------------------------3");
    	println("Назад------------------------------------4");
    }
    
    public static void viewAllInfo(
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
            ArrayList<String> imageSensor) {
    	println("Название");
    	println(name);
    	println("Производитель");
    	println(brand);
    	println("Высота (в м)");
    	println("Ширина (в м)");
    	println("Длинна (в м)");
    	println(height + " x " + width + " x " + deep);
    	println("Вес при взлете (в кг)");
    	println(takeoffWeight);
    	println("Максимальная скорость набора высоты (в м/с)");
    	println(maxAscentSpeed);
    	println("Максимальная скорость снижения (в м/с)");
    	println(maxDescentSpeed);
    	println("Максимальная высота взлета (в метрах):");
    	println(maxTakeoffAltitude);
    	println("Максимальное время полета (в минутах):");
    	println(maxFlightTime);
    	println("Максимальное время зависания (в минутах):");
    	println(maxHoveringTime);
    	println("Максимальная дистанция полета (в километрах):");
    	println(maxFlightDistance);
    	println("Максимальная скорость ветра для полета (в м/с)");
    	println(maxWindSpeedResistance);
    	println("Максимальный угол наклона (в градусах)");
    	println(maxPitchAngle);
    	println("Навигационные системы");
    	for (String string : globalNavigationSatelliteSystem) {
			println(string);
		}
    	println("Диапазон температур");
    	println(operatingTemperature.toString());
    	println("Емкость батареи");
    	println(batteryCapacity);
    	println("Видеомодули");
    	for (String string : imageSensor) {
			println(string);
		}
    }

    public static void viewDroneShortInfo(int index, String name, String brand){
        System.out.printf("%02d| %-30s | %-30s\n",
                index, name, brand);
    }


}
