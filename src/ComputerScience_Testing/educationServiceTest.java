package ComputerScience_Testing;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class educationServiceTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private StudentDataObject studentDataObject;

    @Mock
    private InstructorDataObject instructorDataObject;

    @Mock
    private ClassDataObject classDataObject;

    @InjectMocks
    private ClientBusinessObjectImpl clientBusinessObjectImpl;

    @Test
    public void testStudentsByClass() {
        // Given
        Student studentJM = new Student(“Joy Ma”, “Spanish);
        Student student JH = new Student(“Julio Hernandez”, “Algebra”);
        Student student JJ = new Student(“Jenny Jones”, “Calculus”);
        List<Student> allStudents = Arrays.asList(studentJM, studentJH, studentJJ);

        given(studentDataObject.getAllStudents()).willReturn(allStudents);

        // When
        List<String> mathStudents = clientBusinessObjectImpl.getAllStudentsBySubject(“math”);

        // Then
        assertThat(mathStudents.size(), is(2));
        assertThat(mathStudents, hasItems(studentJJ, student JH);
    }
    @Test
    public void testMarkInactive() {

        // Given
        Class geometry = new Class(“Geometry”, “Summer 2022);
        Class envSci = new Class(“Environmental Science”, “Fall 2022”);
        Class compLit = new Class(“Comparative Literature”, “Spring 2023”);
        List<Class> allClasses = Arrays.asList(geometry, envSci, compLit);

        given(classDataObject.getAllClasses()).willReturn(allClasses);

        // When
        clientBusinessObjectImpl.markCurrentClassesInactive();

        // Then
        verify(classDataObject).markInactive(geometry);

        verify(classDataObject, Mockito.never()).markInactive(envSci);

        verify(classDataObject, Mockito.never()).markInactive(compLit);

        verify(classDataObject, Mockito.times(1)).markInactive(geometry);
        // atLeastOnce, atLeast

    }

// First: Setup

    @Captor
    ArgumentCaptor<Class> classArgumentCaptor;

// Next:

    @Test
    public void testMarkInactive_argumentCaptor() {
        // Given
        Class geometry = new Class(“Geometry”, “Summer 2022);
        Class envSci = new Class(“Environmental Science”, “Fall 2022”);
        Class compLit = new Class(“Comparative Literature”, “Spring 2023”);
        List<Class> allClasses = Arrays.asList(geometry, envSci, compLit);

        given(classDataObject.getAllClasses()).willReturn(allClasses);

        // When
        clientBusinessObjectImpl.markCurrentClassesInactive();

        // Then
        verify(classDataObject).markInactive(classArgumentCaptor.capture());

        assertEquals(geometry, classArgumentCaptor.getValue());
        InstructorDataObject.getClassesByInstructor(instructor_id)
        ClassDataObject.getStudentsInClass(class_id)
    }
}