[![CircleCI](https://circleci.com/gh/mikegehard/stuffFriendsSay.svg?style=svg)](https://circleci.com/gh/mikegehard/stuffFriendsSay)

# Background

My playground to combine the
[Kotlin Multiplatform](https://touchlab.co/kamp-kit-touchlab/) ideas from
[Touch Lab](https://touchlab.co/) and the
[Application Continuum](https://www.appcontinuum.io/) idea of components
to build a unified application with a Web, Android and iOS component.

# Development

You will need both IntelliJ, with Android plugin, and Xcode for development.

Android, shared and server development will use IntelliJ and iOS UI
development will be done in Xcode.

## Autoreload in Ktor (currently broken)  

You can use Ktor autoreload to reload the site on code changes:
https://ktor.io/servers/autoreload.html#recompiling-automatically-on-source-changes

When following these instructions, use `./gradlew` instead of `gradle`.
