package ru.geekbrains.summer.market;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SummerMarketApplication {
	//1. AOP: С помощью АОП посчитайте по каждому сервису суммарное время, уходящее на выполнение методов этих сервисов. И по endpoint'у /statistic выдайте полученную статистику клиенту. Пример:
	//	ProductService: 1200 ms
	//	OrderService: 95 ms
	//	UserService: 2000 ms

	public static void main(String[] args) {
		SpringApplication.run(SummerMarketApplication.class, args);
	}
}
