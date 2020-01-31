package dev.rubbersidedowntech.stufffriendssay

import io.ktor.http.HttpStatusCode
import io.ktor.html.HtmlContent
import kotlinx.html.body
import kotlinx.html.h1
import kotlinx.html.head
import kotlinx.html.title

object Pages {
    fun homePage(): HtmlContent =
        HtmlContent(HttpStatusCode.OK) {
            head {
                title { +"Async World" }
            }
            body {
                h1 {
                    +"HELLO WORLD!!!!"
                }
            }
        }
}
