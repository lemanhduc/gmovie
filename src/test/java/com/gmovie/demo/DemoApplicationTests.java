package com.gmovie.demo;

import com.gmovie.demo.controllers.MovieListController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.http.MediaType;
import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@WebMvcTest(MovieListController.class)
public class DemoApplicationTests {

	@Autowired
	MockMvc mvc;

	@Test
	public void testEndpoint_Should_Return_JsonString() throws Exception {

		RequestBuilder req = get("/gmdb/movies")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON);

		this.mvc.perform(req)
				.andExpect(status().isOk());

	}
}