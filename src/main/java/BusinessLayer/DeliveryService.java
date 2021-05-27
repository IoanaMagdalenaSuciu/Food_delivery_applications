package BusinessLayer;
import DataLayer.FileWriter;
import DataLayer.Serialization;
import PresentationLayer.Observer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This class implements the functionalities of the management system
 */
public class DeliveryService extends Observable implements IDeliveryServiceProcessing, java.io.Serializable {
    /**
     * The menu
     */
    private ArrayList<MenuItem> menu = new ArrayList<>();
    /**
     * The pairs of orders and ordered products
     */
    private final HashMap<Order, ArrayList<MenuItem>> service = new HashMap<>();
    /**
     * List of observers
     */
    private static    List<Observer> observers = new ArrayList<>();
    /**
     * The file writer
     */
    private  static final FileWriter writer = new FileWriter();
    /**
     * Serialization
     */
    private static   Serialization serialization = new Serialization();
    /**
     * This method will set the Serialization type attribute that is used for serialization
     * @param serialization serialization
     */
    public void setSerialization(Serialization serialization){
        this.serialization = serialization;
    }
    /**
     * This method will call the method that serialize object of type DeliveryService
     */
    public void getSerialize(){
        serialization.Serialize(this);
    }
    /**
     * Import the menu
     * @throws IOException
     */
    public void importProducts() throws IOException {
        Pattern pattern = Pattern.compile(",");
        Path csvPath = Paths.get("./products.csv");
        try (Stream<String> lines = Files.lines(csvPath)) {
            Collection<MenuItem> menuItems = lines.skip(1).map(line -> {
                String[] arr = pattern.split(line);
                return new BaseProducts(Float.parseFloat(arr[1]), Float.parseFloat(arr[6]),arr[0], Integer.parseInt(arr[2]), Integer.parseInt(arr[3]), Integer.parseInt(arr[4]), Integer.parseInt(arr[5]));
            }).collect(Collectors.toList());
            menu = (ArrayList<MenuItem>) menuItems.stream()
                    .filter( distinctByKey(p -> p.getName()) )
                    .collect( Collectors.toList() );
            getSerialize();
        }
    }

    /**
     * Verify if the product is duplicated
     * @param keyExtractor
     * @param <T>
     * @return
     */
    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor)
    {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    /**
     * Returns the product with the given name
     * @param name name
     * @return product
     */
    public MenuItem getMenuItem(String name){
        for(MenuItem item: menu){
            if(item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }
    /**
     * Delete a product from menu
     * @param name the name of the product
     */
    public void deleteFromMenu(String name){
        for(int i = 0; i < menu.size(); i++) {
            if (menu.get(i).getName().equals(name)) {
                menu.remove(menu.get(i));
            }
        }
        getSerialize();
    }
    /**
     * Update a product in menu
     * @param price the new price
     * @param name the name of the product
     */
    public void updateInMenu(float price, String name ) {
        for(MenuItem item: menu) {
            if (item.getName().equals(name)) {
                item.setPrice(price);
            }
        }
        getSerialize();
    }
    /**
     * Add a product to menu
     * @param item the new item to be added
     */
    public void addInMenu(MenuItem item) {
        menu.add(item);
        getSerialize();
    }
    /**
     * Add a base product to a composite product
     * @param compose the composite product
     * @param base the base product
     */
    public void addToComposite(CompositeProduct compose, MenuItem base){
        compose.addItem(base);
        compose.compute();
    }
    /**
     * Create a new order
     * @param client name of client who ordered
     * @param date date order
     * @return order number
     */
    public int createOrder(String client, Date date){
        int id = (int)(Math.random()*(100 +1));
        Order newOrder = new Order(id,client,date);
        ArrayList<MenuItem> orderedItems = new ArrayList<>();
        service.put(newOrder,orderedItems);
        getSerialize();
        return id;
    }

    /**
     * Returns the order with fiven orderId
     * @param orderId orderId
     * @return order
     */
    public Order getOrder(int orderId){
        for(Map.Entry<Order, ArrayList<MenuItem>> element: service.entrySet()){
            if(element.getKey().getOrderId() == orderId)
                return element.getKey();
        }
        return null;
    }
    /**
     * Add a product to an order
     * @param name name of the product
     * @param orderId number of the order
     */
    public void addItemsToOrder(String name, int orderId){
        MenuItem item = getMenuItem(name);
        Order order = getOrder(orderId);
        for(Map.Entry<Order, ArrayList<MenuItem>> element: service.entrySet()){
            if(element.getKey().equals(order)){
                element.getValue().add(item);
                element.getKey().computePrice(item.getPrice());
            }
        }
       getSerialize();
    }
    /**
     *This method will create a string that will contain the object data
     * @return the object in a form of a String
     */
    public String toString(){
        String result ="";
        for(Map.Entry<Order, ArrayList<MenuItem>> element: service.entrySet()) {
            result += "\n"+ element.toString();
        }
        return result;
    }

    /**
     * Returns the menu in form of list of Objects[]
     * @return menu
     */
    public List<Object[]> getMenu(){
        List<Object[]> result = new ArrayList<>();
        for(MenuItem item: menu){
            result.add(new Object[]{item.getName(), item.getPrice(), item.getCalories(),item.getFat(),item.getProtein(),item.getSodium(),item.getRating()});
        }
        return result;
    }
    /**
     * This method will add a new Observer
     * @param observer Observer to be added
     */
    public void registerObserver(Observer observer) {
        this.observers.add(observer);
    }
    /**
     * This method will notify all Observers when a order is placed
     * @param message the data of the new order
     */
    public void notifyOrder(String message) {
        for(Observer observer: observers){
            observer.update(message);
        }
    }
    /**
     * This method will delete the observer
     * @param observer Observer to be deleted
     */
    public void deleteObserver(Observer observer) {
        if(observer != null)
        {
            observers.remove(observer);
        }
    }
    /**
     * Filter menu by type
     * @param name type
     * @return new menu
     */
    public List<MenuItem>filterByType(String name){
        return menu.stream().filter(e -> e.getName().contains(name)).collect(Collectors.toList());

    }
    /**
     *  Filter menu by price
     * @param price price
     * @return new menu
     */
    public List<MenuItem> filterByPrice(Float price){
        return menu.stream().filter(e ->e.getPrice()==price).collect(Collectors.toList());
    }
    /**
     *  Filter menu by rating
     * @param rating rating
     * @return new menu
     */
    public List<MenuItem> filterByRating(Float rating){
        return   menu.stream().filter(e ->e.getRating()==rating).collect(Collectors.toList());
    }
    /**
     *  Filter menu by amount of fat
     * @param fat amount of fat
     * @return new menu
     */
    public List<MenuItem> filterByFat(int fat){
        return menu.stream().filter(e ->e.getFat()==fat).collect(Collectors.toList());
    }
    /**
     * Filter menu by amount of calories
     * @param calories amount of fat
     * @return new menu
     */
    public List<MenuItem> filterByCalories(int calories){
        return menu.stream().filter(e ->e.getCalories()==calories).collect(Collectors.toList());
    }
    /**
     *  Filter menu by amount of sodium
     * @param sodium sodium
     * @return new menu
     */
    public List<MenuItem>  filterBySodium(int sodium){
        return menu.stream().filter(e ->e.getSodium()==sodium).collect(Collectors.toList());
    }
    /**
     * Filter menu by amount of protein
     * @param protein protein
     * @return new menu
     */
    public List<MenuItem>  filterByProtein(int protein){
        return menu.stream().filter(e ->e.getProtein()==protein).collect(Collectors.toList());
    }
    /**
     * Generate Statistic 1
     * @param start start hour
     * @param end end hour
     */
    public void getStatistic1(Long start, Long end){
        List<Order> result = service.entrySet()
                .stream()
                .filter( e -> e.getKey().getData().getHours() > start && e.getKey().getData().getHours() < end)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        writer.writeStatistic1(result);
    }
    /**
     * Generate Statistic 2
     * @param times times
     */
    public void getStatistic2 (Long times){
        List<List<MenuItem>> list = service.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
        List<MenuItem> items = new ArrayList<>();
        for(List<MenuItem> order: list){
            items.addAll(order);
        }
        Map<MenuItem, Long > frequencyMap =
                items.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<MenuItem, Long > result = frequencyMap.entrySet().stream().filter(e -> e.getValue() > times).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        writer.writeStatistic2(result);
    }
    /**
     * Generate Statistic 3
     * @param times times
     * @param value  value
     */
    public void getStatistic3(int times, float value){
        List<Order> list = service.entrySet()
                .stream()
                .filter(e -> e.getKey().getPrice() > value)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        Map<String, Map<Order, Long> > result= list.stream().collect(Collectors.groupingBy(Order::getClientId, Collectors.groupingBy(Function.identity(),Collectors.counting())));
       List<String> orderMap = result.entrySet().stream().
               filter(e -> e.getValue().entrySet().size() > times)
               .map(m -> m.getKey())
               .collect(Collectors.toList());
        System.out.println(orderMap);
        writer.writeStatistic3(orderMap);
    }

    /**
     * Generate Statistic 4
     * @param date date
     */
    public void getStatistic4(Date date){
        List<MenuItem> item = service.entrySet().stream().filter(e -> e.getKey().getData().getDay() == date.getDay() && e.getKey().getData().getMonth() == date.getMonth() && e.getKey().getData().getYear() == date.getYear())
                .map(e -> e.getValue().stream().collect(Collectors.toList()))
                .flatMap(e -> e.stream())
                .collect(Collectors.toList());
      Map<MenuItem, Long> result = item.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        writer.writeStatistic4(result);
    }
}
