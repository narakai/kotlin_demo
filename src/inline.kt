class InlineMain {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            greeting({
                println("Before")
            }, {
                println("After")
            }, {
                println("Last")
            })
//            Lambda表达式里不允许使用return，除非整个Lambda表达式是内联函数的参数。
            return
        }

        private inline fun greeting(before: () -> Unit, crossinline after: () -> Unit, noinline last: () -> Unit) {
            before()
            println("Hello")
//            after()

            //noinline
            warpAfter(last)

            //crossinline
//            函数类型参数间接调用
            warpAfter {
                after()
            }
        }

        private fun warpAfter(after: () -> Unit) {
            println("Before")
            after()
        }
    }
}