package ru.profitware.is_algo

/**
 * Created by Sergey Sobko on 17.05.15.
 *
 */
object IsAlgo extends App {
  val RussianAlpha = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя"
  val TopicCounts = (13, 10 + 4 + 6 + 6, 14, 5, 15, 18, 10, 10, 14, 18)

  def get_question_number(surname: String, topic_number: Int) = {
    val surname_length = surname.length()

    val letter1 = surname.charAt((topic_number % surname_length - 1 + surname_length) % surname_length)
    val letter2 = surname.charAt((topic_number % surname_length + 2) % surname_length)

    val topic_count_any = TopicCounts.productElement(topic_number - 1)
    val topic_count : Int = topic_count_any match {
      case topic_count_int: Int => topic_count_int
    }

    val topic1 = (RussianAlpha.indexOf(letter1) + 1) % topic_count
    val topic2 = (RussianAlpha.indexOf(letter2) + 1) % topic_count

    (topic1, topic2)
  }

  val Surname = "собко"

  for (i <- 1 to 10) {
    println("%s %s".format(i, get_question_number(Surname, i)))
  }
}
