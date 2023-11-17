package br.com.educatech.servlet.course;

import br.com.educatech.dao.CourseDao;
import br.com.educatech.models.Category;
import br.com.educatech.models.Course;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class CourseServletTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private RequestDispatcher requestDispatcher;

    @Mock
    private CourseDao courseDao;

    @InjectMocks
    private CourseSevlet servlet;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testDoGet() throws IOException, ServletException {
        // Cria uma lista de cursos fictícia para simular o retorno do DAO
        List<Course> courses = new ArrayList<>();
        courses.add(new Course(1L, "JAVA", "Category 1", "Teacher 1", 25, Category.BACKEND));
        courses.add(new Course(2L, "JAVA", "Category 1", "Teacher 1", 25, Category.BACKEND));

        // Configura o comportamento esperado do DAO
        when(courseDao.findAll()).thenReturn(courses);

        // Configura o comportamento esperado do HttpServletRequest
        when(request.getRequestDispatcher("index.jsp")).thenReturn(requestDispatcher);

        // Chama o método doGet da servlet
        servlet.doGet(request, response);

        // Verifica se os métodos foram chamados corretamente
        verify(request).setAttribute("courses", courses);
        verify(requestDispatcher).forward(request, response);
        verify(response).setStatus(HttpServletResponse.SC_OK);
    }
}
