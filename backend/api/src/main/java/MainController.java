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
    	
    	items.add(new Item("Kolsch", "$40", "Cervezas", "http://www.bonappetit.com/wp-content/uploads/2013/07/reissdorf-kolsch.jpg"));
    	items.add(new Item("Scotch", "$45", "Cervezas", "http://mcauslan.com/app/uploads/2013/07/beer_scotchale.jpg"));
    	items.add(new Item("Porter", "$50", "Cervezas", "https://www.fullers.co.uk/~/media/mainsite/Beers/Optimised%20pumps/London-Porter_660X710_v3.png"));
    	items.add(new Item("Honey", "$43", "Cervezas", "http://pitchenginelive.blob.core.windows.net/dev/35680528-9df1-488e-b358-51dbe604495c/82f3da59-2d7e-4d86-931b-a564089970b6.jpg"));
    	items.add(new Item("Stout", "$50", "Cervezas", "https://mygutinstinct.files.wordpress.com/2011/03/bison-brewing-chocolate-stout-590.jpg"));
    	items.add(new Item("Barley Wine", "$50", "Cervezas", "http://www.cdn.sierranevada.com/sites/www.sierranevada.com/files/content/beers/bigfoot/bigfoot02-nodate.png"));
    	items.add(new Item("Imperial Stout", "$60", "Cervezas", "https://si.wsj.net/public/resources/images/OB-RL030_halffu_OZ_20120118171014.jpg"));
    	items.add(new Item("India Pale Ale", "$34", "Cervezas", "http://coneyislandbeer.com/wp-content/uploads/2015/10/overpass-ipa-450x450.png"));
    	
    	items.add(new Item("Coca-Cola", "$20", "Bebidas Sin Alcohol", "http://bk-emea-prd.s3.amazonaws.com/sites/burgerking.es/files/BK_Web_COCACOLA_500X540px.png"));
    	items.add(new Item("Sprite", "$30", "Bebidas Sin Alcohol", "http://www.burgerking.com.sg/upload/image/Product/35/beverage-sprite-thumb.jpg"));
    	items.add(new Item("Agua Mineral VillaVicencio", "$25", "Bebidas Sin Alcohol", "http://www.staples.com.ar/images/pg/GASVC500X12_1.jpg?"));
    	items.add(new Item("Licaudos", "$40", "Bebidas Sin Alcohol", "http://www.melodijolola.com/media/files/styles/large/public/licuado.jpg?itok=QQKW6vf-"));
    	
    	items.add(new Item("Simple", "$60", "Hamburgesas", "http://burgerking.s3-website-us-east-1.amazonaws.com/sites/default/files/hamburgesa_0.png"));
    	items.add(new Item("Completa", "$80", "Hamburgesas", "http://www.redesymarketing.com/wp-content/uploads/2012/08/hamburguesa.jpg"));
    	items.add(new Item("Bacon", "$75", "Hamburgesas", "http://picview.info/download/20150305/food-hamburger-beef-onion-bacon-pickles-cheese-sesame-1400x1050.jpg"));
    	items.add(new Item("Cerdo", "$70", "Hamburgesas", "http://cmslogistics.es/79-thickbox_default/hamburguesa-de-cerdo-iberico.jpg"));
    	
    	items.add(new Item("Mozzarella", "$50", "Pizzas", "https://cdn.nexternal.com/cincyfav3/images/larosas_cheese_pizzas1.jpg"));
    	items.add(new Item("Napolitana", "$80", "Pizzas", "http://www.pngall.com/wp-content/uploads/2016/05/Pizza-Free-PNG-Image.png"));
    	items.add(new Item("Salame", "$80", "Pizzas", "http://www.titospizzaspringhill.com/wp-content/uploads/2015/09/pixxa2.png"));
    	
    	items.add(new Item("Helado", "$30", "Postres", "http://cremhelado-dev.e-nnovva.com/wp-content/uploads/2015/10/helado_no_derrite1.jpg"));
    	items.add(new Item("Flan", "$40", "Postres", "http://www.meals.com/ImagesRecipes/144670lrg.jpg"));
    	items.add(new Item("Brownee", "$43", "Postres", "http://sprites.comohacerpara.com/img/11625a-postre-con-patatas-chocolate-recetas.jpg"));
    	items.add(new Item("Lemon Pie", "$54", "Postres", "http://www.edwardsdesserts.com/images/whole-pies/img-products-indiv-whole-pies-lemon.jpg"));
    	items.add(new Item("Cheese Cake", "$46", "Postres", "http://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_FreshStrawberryCheesecake.jpg"));
    	
    	Menu menuSchlawinchen = new Menu(1, "Harriz", items);
    	
    	
    	menus.put("1", menuSchlawinchen);
    	menus.put("2", menuSchlawinchen);
    	
    	// Merchants
    	List<Table> tables = new ArrayList<Table>();
    	tables.add(new Table("1", "Table1"));
    	tables.add(new Table("2", "Table2"));
    	tables.add(new Table("74d9d693-53b3-4e3c-9562-a9781f0be904", "Table3"));
    	
    	Merchant harriz = new Merchant("1", "Harriz", tables);
    	merchants.put("1", harriz);
    	
    	// end Mock data
    	
    	
        SpringApplication.run(MainController.class, args);
    }

}