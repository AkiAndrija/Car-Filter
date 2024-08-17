import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarFilter {

    public static void main(String[] args) {

        try {
            File inputFile = new File("D:\\Users\\Korisnik\\Downloads\\cars.xml");

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            Document doc = dBuilder.parse(inputFile);

            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("car");
            List<Car> cars = new ArrayList<>();

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;
                    String make = eElement.getElementsByTagName("make").item(0).getTextContent();
                    String model = eElement.getElementsByTagName("model").item(0).getTextContent();
                    int year = Integer.parseInt(eElement.getElementsByTagName("year").item(0).getTextContent());
                    String fuel = eElement.getElementsByTagName("fuel").item(0).getTextContent();
                    double consumption = Double.parseDouble(eElement.getElementsByTagName("consumption").item(0).getTextContent());
                    cars.add(new Car(make, model, year, fuel, consumption));
                }
            }
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter the start year:");

            int startYear = scanner.nextInt();

            System.out.println("Enter the end year:");

            int endYear = scanner.nextInt();
            scanner.close();
            System.out.println("Cars produced between " + startYear + " and " + endYear + ":");
            for (Car car : cars) {
                if (car.getYear() >= startYear && car.getYear() <= endYear) {
                    System.out.println(car);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


