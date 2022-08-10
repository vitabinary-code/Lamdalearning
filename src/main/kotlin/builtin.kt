
data class Grocery(val name:String,val category: String,
                   val unit:String,val unitPrice:Double,
                   val quantity:Int)

fun main() {
    val groceries = listOf(
        Grocery("Tomatoes", "Vegetable", "lb", 3.0, 3),
        Grocery("Mushroom", "Vegetable", "lb", 4.0, 1),
        Grocery("Bagels", "Bakery", "Pack", 1.5, 2),
        Grocery("Olive oil", "Pantry", "Bottle", 6.0, 1),
        Grocery("Ice cream", "Frozen", "Pack", 3.0, 2)
    )

    //use filter function
    val vegetables = groceries.filter { it.category == "Vegetable" }
    println("vegetable: $vegetables")
    val notFrozen = groceries.filterNot { it.category == "Frozen" }
    println("not frozen : $notFrozen")

    //use map function

    val groceryNames = groceries.map { it.name }
    println("Grocery Name: $groceryNames")
    val halfUnitPrice = groceries.map { it.unitPrice * 0.5 }
    println("Half UnitPrice : $halfUnitPrice")

    //Use chain filter and map

    val newPrices = groceries.filter { it.unitPrice> 3.0 }
        .map { it.unitPrice *2  }
    println("New Price : $newPrices")

    //Use forEach select each variable.

    println("Grocery names:")
    groceries.forEach { println(it.name) }

    //Use chain forEach and filter

    println("Groceries with Unit Price > 3.0 :")
    groceries.filter { it.unitPrice > 3.0 }
        .forEach{ println(it.name) }

    // Use lambda closure.

    var itemName = ""
    groceries.forEach{ run { itemName += it.name } }
    println("itemNames: $itemName")

    // Use group function

    val groupByCategory  = groceries.groupBy { it.category }.forEach{
        println(it.key)
        it.value.forEach{println("  ${it.name}") }
    }

    println(groupByCategory)

    val ints = listOf<Int>(1,2,3)

    val sumOfInts = ints.fold(0){runningSum, item -> runningSum + item}

    println("sumOfInts : $sumOfInts")

    val productOfInts = ints.fold(1){runningProduct,item -> runningProduct *item}

    println("productOfInts : $productOfInts")

    val names = groceries.fold(""){string,item -> string + item.name }

    println("names : $names")

    val changeForm50 = groceries.fold(50.0){change,item -> change - item.unitPrice * item.quantity}

    println("changeForm50 : $changeForm50")





}