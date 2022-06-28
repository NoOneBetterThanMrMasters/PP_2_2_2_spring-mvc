package web.dao;

import org.springframework.stereotype.Repository;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDAOImpl implements CarDAO{
    private static int CARS_COUNT;
    private List<Car> cars;

    {
        cars = new ArrayList<>();

        cars.add(new Car(++CARS_COUNT, "Car1",  2004));
        cars.add(new Car(++CARS_COUNT, "Car2",  2003));
        cars.add(new Car(++CARS_COUNT, "Car3",  2002));
        cars.add(new Car(++CARS_COUNT, "Car4",  2001));
        cars.add(new Car(++CARS_COUNT, "Car5",  2000));
    }

    public List<Car> getCars(int count) {
        if(count >= 5){
            return cars;
        }else{
            return cars.stream().limit(count).toList();
        }
    }
}

