package com.example.mysurgeon.core.status

open class PageMovements: Status() {
    data class NextPage(val offset: Int = 1): PageMovements()
    data class PreviousPage(val offset: Int = 1): PageMovements()
}