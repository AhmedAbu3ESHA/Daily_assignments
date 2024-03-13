package model;

import services.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class EmployeeDAO {
    Logger logger;

    public EmployeeDAO(Logger logger) {
        this.logger = logger;
    }

    public void save(Employee employee){
        Path path = Paths.get("employee.txt");
        try {
            Files.write(path,employee.toString().getBytes());
            logger.printSuccess("employee saved "+employee.toString());
        } catch (IOException e) {
            logger.printFailed("error saving employee");
        }
    }

    public List<String> fetch(){
        Path path = Paths.get("employee.txt");
        try {
            List<String> content= Files.readAllLines(path);
            logger.printSuccess("employees fetched "+content);
        } catch (IOException e) {
            logger.printFailed("error fetching employee");
        }
        return null;
    }
}
