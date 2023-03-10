package parser

 class Node(
    var key: String,
    var left: Node? = null,
    var right: Node? = null){
     fun find(value: Int): Node? = when {
         this.value > value -> left?.findByValue(value)
         this.value < value -> right?.findByValue(value)
         else -> this
     }
     fun insert(value: Int) {
         if (value > this.key) {
             if (this.right == null) {
                 this.right = Node(value)
             } else {
                 this.right.insert(value)
             }
         } else if (value < this.key) {
             if (this.left == null) {
                 this.left = Node(value)
             } else {
                 this.left.insert(value)
             }
         }

         fun delete(value: Int) {
             when {
                 value > key -> scan(value, this.right, this)
                 value < key -> scan(value, this.left, this)
                 else -> removeNode(this, null)
             }
         }

         fun visit(): Array<Int> {
             val a = left?.visit() ?: emptyArray()
             val b = right?.visit() ?: emptyArray()
             return a + arrayOf(key) + b
         }
 }
