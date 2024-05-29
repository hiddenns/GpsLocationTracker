
object Config {

    const val appId = "com.khalore.gpslocation"
    const val appName = "GplLocation"
    var archivesBaseName = "$appName-${Versions.versionName}_${Versions.versionCode})}"

    const val isMinifyEnabled = false

    object Sdk {
        const val minSdk = 26
        const val targetSdk = 34
        const val compileSdk = 34
    }

    object SignIn {
        const val keyAlias = "test"
        const val keyPassword = "test"
        const val storeFilePath = "../test.jks"
        const val storePassword = "test"
    }

    object SignInDebug {
        const val keyAlias = "test"
        const val keyPassword = "test"
        const val storeFilePath = "../test_debug.jks"
        const val storePassword = "test"
    }

    object Versions {
        private const val versionMajor = 1
        private const val versionMinor = 0
        private const val versionPatch = 0

        const val versionCode = 1
        const val versionName = "${versionMajor}.${versionMinor}.${versionPatch}"
    }

}
