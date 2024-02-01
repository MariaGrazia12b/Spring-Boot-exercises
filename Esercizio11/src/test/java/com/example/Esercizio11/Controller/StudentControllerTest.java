package com.example.Esercizio11.Controller;
import static org.assertj.core.api.Assertions.assertThat;


import com.example.Esercizio11.Entities.Student;
import com.example.Esercizio11.Repository.StudentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles(value = "test")
@AutoConfigureMockMvc
class StudentControllerTest {

	@Autowired
	StudentController studentController;

	@Autowired
	private MockMvc mockMvc;

	@Mock
	private StudentRepository studentRepository;

	@Test
	void contextLoads() {
		//StudentController studentController1 = new StudentController();
		assertThat(studentController).isNotNull();
	}


	@Test
	void createStudent() throws Exception
	{
		Student student = new Student();
		student.setName("Maria");
		student.setSurname("Bella");
		student.setWorking(true);

		ObjectMapper objectMapper = new ObjectMapper();
		String studentJSN = objectMapper.writeValueAsString(student);

		this.mockMvc.perform(post("/v1/add-student")
				.contentType(MediaType.APPLICATION_JSON)
				.content(studentJSN)).andDo(print())
				.andExpect(status().isOk());
	}

	@Test
	void retrieveStudent() throws Exception
	{
		this.mockMvc.perform(get("/v1/retrieve-student")).andDo(print()).andExpect(status().isOk());
	}


	/*@Test
	void deleteUser() throws Exception{
		Student student =createStudentNew();
		assertThat(student.getId()).isNotNull();

		this.mockMvc.perform(delete("/v1/student/delete/"+student.getId()))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();

		Student student1 = getStudentFromId(student.getId());

		assertThat(student1).isNull();

	}*/

	/*private Student getStudentFromId(Long id) throws Exception {
		MvcResult result = this.mockMvc.perform(get("/v1/student/list/"+id))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();

		if(result.getResponse().getContentLength() == 0)
			return null;

		return objectMapper.readValue(result.getResponse().getContentAsString(), Student.class);
	}*/
}
