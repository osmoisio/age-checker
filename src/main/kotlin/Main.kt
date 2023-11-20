fun main() {
    var age: Int

    do {
        val birthYear = askBirthYear()
        age = calculateAge(birthYear)

        if (age < 0) {
            println("Birth year cannot be larger than current year.")
        }

    } while (age < 0)

    val ageCategory = determineAgeCategory(age)
    println("You are $age years old. Your age category is: $ageCategory")
}

fun askBirthYear(): Int {
    var input: Int?
    do {
        println("Please enter your birth year (e.g., 1990):")
        input = readln().toIntOrNull()
    } while (input == null)
    return input
}

fun calculateAge(birthYear: Int): Int {
    val currentYear = java.time.Year.now().value
    return currentYear - birthYear
}

fun determineAgeCategory(age: Int): String {
    return when {
        age < 18 -> "a minor"
        age < 65 -> "an adult"
        else -> "a senior"
    }
}
