class LewisCarrollBook {
    var name = ""
        get() {
            println("The name of the book is $field")
            return field
        }
        set(newName) {
            println("Now, a book called $newName")
            field = newName
        }

    var author = "Lewis Carroll"
        get() {
            println("The author of the book is $field")
            return field
        }
    var price = 0
        get() {
            println("Putting a new price...")
            return field
        }
        set(p) {
            println("The new price is $p")
            field = p
        }
}
