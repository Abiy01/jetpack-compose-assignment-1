package com.example.jetpack_compose_assignment_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.jetpack_compose_assignment_1.model.Course
import com.example.jetpack_compose_assignment_1.ui.components.CourseList
import com.example.jetpack_compose_assignment_1.ui.theme.JetpackComposeAssignment1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeAssignment1Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CourseListScreen()
                }
            }
        }
    }
}

@Composable
fun CourseListScreen() {
    CourseList(courses = sampleCourses)
}

private val sampleCourses = listOf(
    Course(
        title = "Introduction to Computer Science",
        code = "CS101",
        creditHours = 3,
        description = "An introductory course covering fundamental concepts of computer science, including programming basics, algorithms, and data structures.",
        prerequisites = listOf("None")
    ),
    Course(
        title = "Data Structures and Algorithms",
        code = "CS201",
        creditHours = 4,
        description = "Advanced study of data structures and algorithms, including trees, graphs, sorting, and searching techniques.",
        prerequisites = listOf("CS101", "Mathematics 101")
    ),
    Course(
        title = "Database Systems",
        code = "CS301",
        creditHours = 3,
        description = "Comprehensive study of database design, implementation, and management, including SQL, normalization, and transaction processing.",
        prerequisites = listOf("CS201")
    ),
    Course(
        title = "Software Engineering",
        code = "CS401",
        creditHours = 4,
        description = "Study of software development methodologies, design patterns, testing strategies, and project management techniques.",
        prerequisites = listOf("CS301", "CS201")
    ),
    Course(
        title = "Mobile Application Development",
        code = "CS501",
        creditHours = 3,
        description = "Hands-on course covering mobile app development using modern frameworks and tools, with focus on user interface design and platform-specific features.",
        prerequisites = listOf("CS401", "CS301")
    )
)