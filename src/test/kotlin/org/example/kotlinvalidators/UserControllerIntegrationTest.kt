import com.fasterxml.jackson.databind.ObjectMapper
import org.example.kotlinvalidators.KotlinValidatorsApplication
import org.example.kotlinvalidators.User
import org.example.kotlinvalidators.UserClass
import org.example.kotlinvalidators.UserClassFields
import org.example.kotlinvalidators.UserKlass
import org.example.kotlinvalidators.UserKlassFields
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@SpringBootTest(classes = [KotlinValidatorsApplication::class])
@AutoConfigureMockMvc
@ExtendWith(SpringExtension::class)
class UserControllerIntegrationTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    @Test
    fun `should get all users`() {
        mockMvc.perform(get("/api/users")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$[0].name").value("aaa"))
            .andExpect(jsonPath("$[0].email").value("a@a.a"))
            .andExpect(jsonPath("$[1].name").value("bbb"))
            .andExpect(jsonPath("$[1].email").value("b@b.b"))
    }

    @Test
    fun `should validate and add a user by data class DTO constructor params annotated`() {
        val user = User("testName", "test@example.com")
        val userJson = objectMapper.writeValueAsString(user)

        mockMvc.perform(post("/api/users/data")
            .contentType(MediaType.APPLICATION_JSON)
            .content(userJson))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.name").value("testName"))
            .andExpect(jsonPath("$.email").value("test@example.com"))

        val user2 = User("veryLongTestNameAndSurname", "test@example.com")
        val user2Json = objectMapper.writeValueAsString(user2)

        mockMvc.perform(post("/api/users/data")
            .contentType(MediaType.APPLICATION_JSON)
            .content(user2Json))
            .andExpect(status().isBadRequest)
    }

    @Test
    fun `should validate and add a user by kotlin class DTO constructor params annotated`() {
        val user = UserKlass("testName", "test@example.com")
        val userJson = objectMapper.writeValueAsString(user)

        mockMvc.perform(post("/api/users/klass")
            .contentType(MediaType.APPLICATION_JSON)
            .content(userJson))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.name").value("testName"))
            .andExpect(jsonPath("$.email").value("test@example.com"))

        val user2 = UserKlass("veryLongTestNameAndSurname", "test@example.com")
        val user2Json = objectMapper.writeValueAsString(user2)

        mockMvc.perform(post("/api/users/klass")
            .contentType(MediaType.APPLICATION_JSON)
            .content(user2Json))
            .andExpect(status().isBadRequest)
    }

    @Test
    fun `should validate and add a user by kotlin class DTO fields annotated`() {
        val user = UserKlassFields("testName", "test@example.com")
        val userJson = objectMapper.writeValueAsString(user)

        mockMvc.perform(post("/api/users/klassfields")
            .contentType(MediaType.APPLICATION_JSON)
            .content(userJson))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.name").value("testName"))
            .andExpect(jsonPath("$.email").value("test@example.com"))

        val user2 = UserKlassFields("veryLongTestNameAndSurname", "test@example.com")
        val user2Json = objectMapper.writeValueAsString(user2)

        mockMvc.perform(post("/api/users/klassfields")
            .contentType(MediaType.APPLICATION_JSON)
            .content(user2Json))
            .andExpect(status().isBadRequest)
    }

    @Test
    fun `should validate and add a user by java class DTO constructor params annotated`() {
        val user = UserClass("testName", "test@example.com")
        val userJson = objectMapper.writeValueAsString(user)

        mockMvc.perform(post("/api/users/class")
            .contentType(MediaType.APPLICATION_JSON)
            .content(userJson))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.name").value("testName"))
            .andExpect(jsonPath("$.email").value("test@example.com"))

        val user2 = UserClass("veryLongTestNameAndSurname", "test@example.com")
        val user2Json = objectMapper.writeValueAsString(user2)

        mockMvc.perform(post("/api/users/class")
            .contentType(MediaType.APPLICATION_JSON)
            .content(user2Json))
            .andExpect(status().isBadRequest)
    }

    @Test
    fun `should validate and add a user by java class DTO fields annotated`() {
        val user = UserClassFields("testName", "test@example.com")
        val userJson = objectMapper.writeValueAsString(user)

        mockMvc.perform(post("/api/users/classfields")
            .contentType(MediaType.APPLICATION_JSON)
            .content(userJson))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.name").value("testName"))
            .andExpect(jsonPath("$.email").value("test@example.com"))

        val user2 = UserKlass("veryLongTestNameAndSurname", "test@example.com")
        val user2Json = objectMapper.writeValueAsString(user2)

        mockMvc.perform(post("/api/users/classfields")
            .contentType(MediaType.APPLICATION_JSON)
            .content(user2Json))
            .andExpect(status().isBadRequest)
    }

}
