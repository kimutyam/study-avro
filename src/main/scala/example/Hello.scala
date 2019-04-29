package example

import java.io.ByteArrayOutputStream

import com.sksamuel.avro4s.AvroSchema

case class Ingredient(name: String, sugar: Double, fat: Double)
case class Pizza(name: String, ingredients: Seq[Ingredient], vegetarian: Boolean, vegan: Boolean, calories: Int)

object Hello extends App {
  import java.io.File
  import com.sksamuel.avro4s.AvroOutputStream

  val pepperoni = Pizza("pepperoni", Seq(Ingredient("pepperoni", 12, 4.4), Ingredient("onions", 1, 0.4)), false, false, 598)
  val hawaiian = Pizza("hawaiian", Seq(Ingredient("ham", 1.5, 5.6), Ingredient("pineapple", 5.2, 0.2)), false, false, 391)

  val schema = AvroSchema[Pizza]
  println(Seq(pepperoni, hawaiian))

//  val os = AvroOutputStream.data[Pizza].to(new File("/Users/kimuraakihiro/workdir/f-code/avro-scala/pizzas.avro")).build(schema)
//  os.write(Seq(pepperoni, hawaiian))
//  os.flush()
//  os.close()
}
