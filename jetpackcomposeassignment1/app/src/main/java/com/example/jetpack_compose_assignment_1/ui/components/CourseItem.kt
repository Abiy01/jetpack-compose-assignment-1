package com.example.jetpack_compose_assignment_1.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpack_compose_assignment_1.model.Course
import com.example.jetpack_compose_assignment_1.ui.theme.JetpackComposeAssignment1Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CourseItem(
    course: Course,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        onClick = { expanded = !expanded }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = course.title,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Code: ${course.code}",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        text = "Credit Hours: ${course.creditHours}",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
                Icon(
                    imageVector = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                    contentDescription = if (expanded) "Collapse" else "Expand"
                )
            }

            AnimatedVisibility(
                visible = expanded,
                enter = expandVertically(animationSpec = tween(300)),
                exit = shrinkVertically(animationSpec = tween(300))
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp)
                ) {
                    Text(
                        text = "Description",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = course.description,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                    
                    if (course.prerequisites.isNotEmpty()) {
                        Text(
                            text = "Prerequisites",
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(top = 8.dp)
                        )
                        course.prerequisites.forEach { prerequisite ->
                            Text(
                                text = "• $prerequisite",
                                style = MaterialTheme.typography.bodyMedium,
                                modifier = Modifier.padding(start = 8.dp, top = 4.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(name = "CourseItem Light", showBackground = true)
@Composable
fun CourseItemLightPreview() {
    JetpackComposeAssignment1Theme(darkTheme = false) {
        CourseItem(
            course = Course(
                title = "Android Development",
                code = "CS101",
                creditHours = 3,
                description = "Learn Android development with Jetpack Compose",
                prerequisites = listOf("Java Programming", "Basic UI Design")
            )
        )
    }
}

@Preview(name = "CourseItem Dark", showBackground = true)
@Composable
fun CourseItemDarkPreview() {
    JetpackComposeAssignment1Theme(darkTheme = true) {
        CourseItem(
            course = Course(
                title = "Android Development",
                code = "CS101",
                creditHours = 3,
                description = "Learn Android development with Jetpack Compose",
                prerequisites = listOf("Java Programming", "Basic UI Design")
            )
        )
    }
} 