package com.example.jetpack_compose_assignment_1.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpack_compose_assignment_1.model.Course
import com.example.jetpack_compose_assignment_1.ui.theme.JetpackComposeAssignment1Theme

@Composable
fun CourseList(
    courses: List<Course>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(courses) { course ->
            CourseItem(course = course)
        }
    }
}

@Preview(name = "CourseList Light", showBackground = true)
@Composable
fun CourseListLightPreview() {
    JetpackComposeAssignment1Theme(darkTheme = false) {
        CourseList(
            courses = listOf(
                Course(
                    title = "Android Development",
                    code = "CS101",
                    creditHours = 3,
                    description = "Learn Android development with Jetpack Compose",
                    prerequisites = listOf("Java Programming", "Basic UI Design")
                ),
                Course(
                    title = "iOS Development",
                    code = "CS102",
                    creditHours = 3,
                    description = "Learn iOS development with SwiftUI",
                    prerequisites = listOf("Swift Programming")
                )
            )
        )
    }
}

@Preview(name = "CourseList Dark", showBackground = true)
@Composable
fun CourseListDarkPreview() {
    JetpackComposeAssignment1Theme(darkTheme = true) {
        CourseList(
            courses = listOf(
                Course(
                    title = "Android Development",
                    code = "CS101",
                    creditHours = 3,
                    description = "Learn Android development with Jetpack Compose",
                    prerequisites = listOf("Java Programming", "Basic UI Design")
                ),
                Course(
                    title = "iOS Development",
                    code = "CS102",
                    creditHours = 3,
                    description = "Learn iOS development with SwiftUI",
                    prerequisites = listOf("Swift Programming")
                )
            )
        )
    }
} 