/* This code is a Travel Itinerary Planner written in Java. It helps users create a personalized travel itinerary by allowing them to input their destination, travel dates, preferences, budget, and planned activities. Additionally, it provides basic weather information for the chosen destination.

Code Explanation : 
1. Class TravelPlan The TravelPlan class represents the travel details for a single trip.

• Attributes:
             • destination: A String representing the location of the trip.
             • startDate and endDate: String values for the start and end dates of the trip in the format "YYYY-MM-DD."
             • preferences: A String detailing the user’s travel preferences (e.g., "beaches, food").
             • budget: A double representing the budget for the trip.
             • activities: An ArrayList<String> to store the list of activities the user plans to do during the trip.
             • Constructor: Initializes the destination, startDate, endDate, preferences, and budget fields based on user input.

• Methods:
             • addActivity(String activity): Adds an activity to the activities list.
             • toString(): Returns a formatted string of the travel details, including the destination, dates, preferences, budget, and activities.
2. Class TravelItineraryPlanner This class contains the main application logic, handles user input, manages weather data, and displays the travel itinerary.

• Attributes:
             • weatherData: A HashMap<String, String> that stores weather information for various destinations.
             • scanner: A Scanner object to read user input.
             • main Method: The main entry point for the application. It orchestrates the program flow:

          1. Initialize Weather Data: Calls initializeWeatherData() to set up sample weather data.
          2. Input Travel Details:
              • Prompts the user to input their destination, startDate, endDate, preferences, and budget.
              • Creates a TravelPlan instance using these details.
          3. Add Activities: Continuously prompts the user to add activities to their itinerary until they type "done."
          4. Display Itinerary: Calls the toString() method of the TravelPlan instance to print the travel itinerary.
          5. Display Weather Information: Calls displayWeather(destination) to show the weather for the chosen destination.
              • initializeWeatherData Method: Populates the weatherData HashMap with sample weather information for a few cities.
              • displayWeather Method: Takes a destination as input, checks weatherData for the weather at that location, and prints it. If no weather information is available for that location, it notifies the user.
*/
/* ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- /*
                                                  // Code are Given Below 
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- /*
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class TravelPlan {
    String destination;
    String startDate;
    String endDate;
    String preferences; // User preferences (e.g., activities, food)
    double budget;
    ArrayList<String> activities = new ArrayList<>();

    public TravelPlan(String destination, String startDate, String endDate, String preferences, double budget) {
        this.destination = destination;
        this.startDate = startDate;
        this.endDate = endDate;
        this.preferences = preferences;
        this.budget = budget;
    }

    public void addActivity(String activity) {
        activities.add(activity);
    }
    
    public String toString() {
        return "Destination: " + destination + "\n" +
               "Dates: " + startDate + " to " + endDate + "\n" +
               "Preferences: " + preferences + "\n" +
               "Budget: $" + budget + "\n" +
               "Activities: " + String.join(", ", activities);
    }
}

public class TravelItineraryPlanner {
    private static HashMap<String, String> weatherData = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeWeatherData();
        System.out.println("--- Travel Itinerary Planner ---");

        // Input travel details
        System.out.print("Enter your destination: ");
        String destination = scanner.nextLine();

        System.out.print("Enter start date (YYYY-MM-DD): ");
        String startDate = scanner.nextLine();

        System.out.print("Enter end date (YYYY-MM-DD): ");
        String endDate = scanner.nextLine();

        System.out.print("Enter your preferences (activities, food, etc.): ");
        String preferences = scanner.nextLine();

        System.out.print("Enter your budget: $");
        double budget = scanner.nextDouble();
        scanner.nextLine();  // Consume newline

        // Create a travel plan
        TravelPlan travelPlan = new TravelPlan(destination, startDate, endDate, preferences, budget);
        
        // Add activities
        String activity;
        System.out.println("Enter activities (type 'done' to finish):");
        while (true) {
            activity = scanner.nextLine();
            if (activity.equalsIgnoreCase("done")) {
                break;
            }
            travelPlan.addActivity(activity);
        }

        // Display itinerary
        System.out.println("\n--- Your Travel Itinerary ---");
        System.out.println(travelPlan);
        
        // Display weather information
        displayWeather(destination);

        scanner.close();
    }

    private static void initializeWeatherData() {
        // Sample weather data for demonstration
        weatherData.put("New York", "Sunny, 75°F");
        weatherData.put("Los Angeles", "Sunny, 85°F");
        weatherData.put("Chicago", "Cloudy, 70°F");
        weatherData.put("Miami", "Rainy, 80°F");
        // Add more destinations and their weather conditions
    }

    private static void displayWeather(String destination) {
        String weather = weatherData.get(destination);
        if (weather != null) {
            System.out.println("\nWeather information for " + destination + ": " + weather);
        } else {
            System.out.println("\nWeather information for " + destination + " is not available.");
        }
    }
}
/* ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- */
// • For Compile this Program Write : javac TravelIteracyPlanner.java
// • For Run this Program Write : java TravelIteracyPlanner.java
/* ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- */
// Input in command Line :
/* PS C:\Users\Latesh\Desktop\Internship> java TravelItineraryPlanner     
--- Travel Itinerary Planner ---
Enter your destination: New York    
Enter start date (YYYY-MM-DD): 2024-12-13
Enter end date (YYYY-MM-DD): 2024-12-23
Enter your preferences (activities, food, etc.): food
Enter your budget: $10000
Enter activities (type 'done' to finish):
done
// Output Display on the command Line :
--- Your Travel Itinerary ---
Destination: New York
Dates: 2024-12-13 to 2024-12-23
Preferences: food
Budget: $10000.0
Activities:Adventure,Exploring

Weather information for New York: Sunny, 75°F
*/
