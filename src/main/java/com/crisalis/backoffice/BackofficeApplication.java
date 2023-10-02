package com.crisalis.backoffice;

import com.crisalis.backoffice.model.Customer;
import com.crisalis.backoffice.model.Order;
import com.crisalis.backoffice.model.OrderDetail;
import com.crisalis.backoffice.model.Product;
import com.crisalis.backoffice.repository.CustomerRepo;
import com.crisalis.backoffice.repository.OrderDetailRepo;
import com.crisalis.backoffice.repository.OrderRepo;
import com.crisalis.backoffice.repository.ProductRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;

@SpringBootApplication
public class BackofficeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackofficeApplication.class, args);


	}
	@Bean
	public CorsFilter corsFilter(){
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.setAllowedOriginPatterns(Arrays.asList("*"));
		config.addAllowedHeader("*");
		config.addAllowedMethod("OPTION");
		config.addAllowedMethod("GET");
		config.addAllowedMethod("POST");
		config.addAllowedMethod("PUT");
		config.addAllowedMethod("DELETE");
		source.registerCorsConfiguration("/**",config);
		return new CorsFilter(source);
	}

	@Bean
	CommandLineRunner commandLineRunner(
			OrderRepo orderRepo,
			CustomerRepo customerRepo,
			ProductRepo productRepo,
			OrderDetailRepo orderDetailRepo
	){
		return args -> {
			Product product = productRepo.save(new Product(
					null,
					"Celular",
					"celular Motorolla g9, 124gb, fullHD",
					BigDecimal.valueOf(140000)
					));
			Product product2 = productRepo.save(new Product(
					null,
					"Celular 2 ",
					"celular Motorolla g9, 124gb, fullHD",
					BigDecimal.valueOf(19200)
			));
			Customer customer = customerRepo.save(new Customer(null,
					"Gonzalo Fleitas",
					"38555555"));
			Order order = orderRepo.save(new Order(
					null,
					"Pedido 1",
					new Date(),
					customer,
					null

			));
			OrderDetail orderDetail = orderDetailRepo.save(new OrderDetail(
					null,
					product.getPrice(),
					4.0,
					product

					));

			OrderDetail orderDetail2 = orderDetailRepo.save(new OrderDetail(
					null,
					product2.getPrice(),
					2.0,
					product2
			));

			/*order.setOrderDetails(
					Set.of(
							orderDetail,
							orderDetail2
					)
			);

			orderRepo.save(order);
		*/
		};

	}

}
