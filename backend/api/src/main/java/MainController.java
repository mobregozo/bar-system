import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.Item;
import model.Menu;
import model.Merchant;
import model.Order;
import model.Table;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class MainController {
	
	static HashMap<String, Menu> menus = new HashMap<String, Menu>();
	static HashMap<String, Merchant> merchants = new HashMap<String, Merchant>();
	static HashMap<String, List<Order>> orders = new HashMap<String, List<Order>>();

	@CrossOrigin
    @RequestMapping("/Merchant/{merchantId}")
    public @ResponseBody Merchant getMerchant(@PathVariable("merchantId") String merchantId) throws Exception {
    	Merchant merchant = merchants.get(merchantId);
    	if (merchant == null) {
    		throw new Exception("Merchant not found");
    	}
        return merchant;
    }

	@CrossOrigin
    @RequestMapping("/Menu/{tableId}")
    public @ResponseBody Menu getMenu(@PathVariable("tableId") String tableId) throws Exception {
    	Menu menu = menus.get(tableId);
    	if (menu == null) {
    		throw new Exception("Table not found");
    	}

    	return menu;
    }

	@CrossOrigin
    @RequestMapping(value="/SubmitOrder", method=RequestMethod.POST)
    public String submitOrder(@ModelAttribute Order order) {
    	List<Order> merchantOrders = orders.get(order.getMerchantId());
    	if (merchantOrders == null) {
    		merchantOrders = new ArrayList<Order>();
    		orders.put(order.getMerchantId(), merchantOrders);
    	}
    	merchantOrders.add(order);
        return "result";
    }

	@CrossOrigin
    @RequestMapping("/Orders/{merchantId}")
    public @ResponseBody List<Order> getOrders(@PathVariable("merchantId") String merchantId) throws Exception {
    	List<Order> merchantOrders = orders.get(merchantId);
    	if (merchantOrders == null) {
    		merchantOrders = new ArrayList<Order>();
    	}

    	return merchantOrders;
    }

    public static void main(String[] args) throws Exception {
    	// Mock data
    	
    	// Menus
    	List<Item> items = new ArrayList<Item>();
    	items.add(new Item("Coca-Cola 300CC", "$10", "Drinks", "http://www.coca-colacompany.com/content/dam/journey/us/en/private/2015/02/chronology10-1280-900-bfb7f27c.jpg"));
    	items.add(new Item("Sprite 300CC", "$120", "Drinks", "http://pngimg.com/upload/sprite_PNG8920.png"));
    	items.add(new Item("Hamburgesa clasica", "$26", "Food", "http://www.recetahamburguesa.com/ImagenesRecetaHamburguesa/ImagenesRecetaHamburguesa/receta-hamburguesa-thermomix.jpg"));
    	Menu menuSchlawinchen = new Menu(1, "Schlawinchen", items);
    	menus.put("1", menuSchlawinchen);
    	menus.put("2", menuSchlawinchen);
    	
    	// Merchants
    	List<Table> tables = new ArrayList<Table>();
    	tables.add(new Table("1", "Table1"));
    	tables.add(new Table("2", "Table2"));
    	Merchant schlawinchen = new Merchant("1", "Schlawinchen", tables);
    	merchants.put("1", schlawinchen);
    	
    	// end Mock data
    	
    	
        SpringApplication.run(MainController.class, args);
    }

}