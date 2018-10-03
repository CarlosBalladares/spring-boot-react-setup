package com.carlosbf.MySpringBootReactApp;

import com.carlosbf.MySpringBootReactApp.crawler.SimpleCrawler;
import com.carlosbf.MySpringBootReactApp.model.Feed;
import com.carlosbf.MySpringBootReactApp.model.FeedMessage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.MalformedURLException;

@SpringBootApplication
public class MySpringBootReactAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySpringBootReactAppApplication.class, args);
		System.out.println("hello world");

		SimpleCrawler parser = null;
		try {
			parser = new SimpleCrawler("https://www.paginasiete.bo/rss/feed.html?r=77");
			Feed feed = parser.readFeed();
			System.out.println(feed);
			for (FeedMessage message : feed.getMessages()) {
				System.out.println(message);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}
}
